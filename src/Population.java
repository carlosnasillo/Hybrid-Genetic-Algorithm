/* 
+++
    Copyright (C) 2012 Carlos Nasillo / me@carlosnasillo.com.
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of 
    this software and associated documentation files (the "Software"), to deal in the 
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the 
    following conditions:
    
    The above copyright notice and this permission notice shall be included in all copies
    or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
    PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
    FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
    OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
    DEALINGS IN THE SOFTWARE.
---
*/

package project_clean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class Population {
//..............................................................................
    Random random = new Random();
//..............................................................................
    Chromosome chromosome;
    ArrayList<Chromosome> pool = new ArrayList<Chromosome>();
    ArrayList<Chromosome> pool_Offpring = new ArrayList<Chromosome>();
//..............................................................................
    protected int poolSize;
    protected int chromosomeLength;
    protected int maxFitness;
    protected int totalPoolFitness;
    protected String[] markScheme;
    protected boolean useSubsequence;
    protected boolean useSubstring;
//..............................................................................


//------------------------------------------------------------------------------
    public Population(int populationSize, int chromosomeSize, String[] markScheme,
                      boolean useSubsequence, boolean useSubstring){
        poolSize = populationSize;
        chromosomeLength = chromosomeSize;
        this.markScheme = markScheme;
        this.useSubsequence = useSubsequence;
        this.useSubstring = useSubstring;
    }

//------------------------------------------------------------------------------
    public void initializePool(){
        for(int i=0; i < poolSize; i++){
            chromosome = new Chromosome(chromosomeLength);
            chromosome.newRandomChromosome();
            chromosome.evaluateFitness(markScheme, useSubsequence, useSubstring);
            pool.add(chromosome);
        }
        sortPool_descending();
        getPoolFitnessTotal();
    }

//------------------------------------------------------------------------------
    protected void sortPool_descending(){
        Collections.sort(pool);
        Collections.reverse(pool);
    }

//------------------------------------------------------------------------------
    protected int getPoolFitnessTotal(){
        Iterator<Chromosome> poolIterator = pool.iterator();
        int sum = 0;

        while(poolIterator.hasNext()){
            sum += poolIterator.next().getFitness();
        }
        totalPoolFitness = sum;
        return totalPoolFitness;
    }


//------------------------------------------------------------------------------
    protected Chromosome getBestChromosome(){
        return pool.get(0);
    }

//------------------------------------------------------------------------------
    protected Chromosome wheelSelection(){
        int index = 0;
        double wheelSpin = 0;

        wheelSpin = random.nextInt(totalPoolFitness);
        for(index = 0; wheelSpin > 0 && index < poolSize-1; index++){
            wheelSpin -= pool.get(index).getFitness();
        }
        return pool.get(index);
    }

//------------------------------------------------------------------------------
    protected Chromosome tournamentSelection(int nRounds){
        int rndRank = 0;
        int bestRank = 0;

        while(nRounds > 0){
            rndRank = random.nextInt(poolSize);
            if(rndRank < bestRank){
                bestRank = rndRank;
            }
            nRounds--;
        }
        return pool.get(bestRank);
    }

//------------------------------------------------------------------------------
    protected Chromosome[] crossover(Chromosome parent1, Chromosome parent2,
                                     boolean onePoint){
        Chromosome[] offpring = new Chromosome[2];
        offpring[0] = new Chromosome(chromosomeLength);
        offpring[1] = new Chromosome(chromosomeLength);
        String tempOffpring_0 = "";
        String tempOffpring_1 = "";

        if(onePoint){
            int locus = random.nextInt(chromosomeLength);
            tempOffpring_0 = parent1.getChromosome().substring(0, locus)
                           + parent2.getChromosome().substring(locus);
            tempOffpring_1 = parent2.getChromosome().substring(0, locus)
                           + parent1.getChromosome().substring(locus);
            offpring[0].genes = tempOffpring_0.toCharArray();
            offpring[1].genes = tempOffpring_1.toCharArray();
        }
        else{
            int locusA = random.nextInt(chromosomeLength);
            int locusB = random.nextInt(chromosomeLength);
            if(locusA > locusB){
                int locusSwap = locusA;
                locusA = locusB;
                locusB = locusSwap;
            }
            String parent1_A = parent1.getChromosome().substring(0, locusA);
            String parent1_B = parent1.getChromosome().substring(locusA, locusB);
            String parent1_C = parent1.getChromosome().substring(locusB);
            String parent2_A = parent2.getChromosome().substring(0, locusA);
            String parent2_B = parent2.getChromosome().substring(locusA, locusB);
            String parent2_C = parent2.getChromosome().substring(locusB);
            tempOffpring_0 = parent1_A + parent2_B + parent1_C;
            tempOffpring_1 = parent2_A + parent1_B + parent2_C;
            offpring[0].genes = tempOffpring_0.toCharArray();
            offpring[1].genes = tempOffpring_1.toCharArray();
        }
        return offpring;
    }

//------------------------------------------------------------------------------
    protected void evaluateAllChromosomesFitness(){
        Iterator<Chromosome> poolIterator = pool.iterator();
        while(poolIterator.hasNext()){
            poolIterator.next().evaluateFitness(markScheme,
                                                useSubsequence, useSubstring);
        }
        getPoolFitnessTotal();
    }

//------------------------------------------------------------------------------
    protected void storeElite(Chromosome best){
        pool_Offpring.add(best);
    }

//------------------------------------------------------------------------------
    protected void storeNewOffpring(Chromosome[] offpring){
        pool_Offpring.addAll(Arrays.asList(offpring));
    }

//------------------------------------------------------------------------------
    protected void replaceOldPool(){
        Collections.copy(pool, pool_Offpring);
        pool_Offpring.clear();
    }
}