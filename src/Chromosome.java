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

import java.util.Random;


public class Chromosome implements Comparable<Chromosome> {
//..............................................................................
    Random random = new Random();
//..............................................................................
    protected int geneSize;
    protected char[] genes;
    protected String strGenes;
    protected int fitness;
//..............................................................................


//------------------------------------------------------------------------------
    public Chromosome (int size){
        geneSize = size;
        genes = new char[geneSize];
    }

//------------------------------------------------------------------------------
    protected void newRandomChromosome() {
        char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'A', 'B', 'C', 'D', 'E', 'F'};

        for(int i=0; i<geneSize; ++i) {
            char rndHex = hexValues[random.nextInt(hexValues.length)];
            setGene(i, rndHex);
        }
    }

//------------------------------------------------------------------------------
    protected void mutate(boolean useManyMutations) {
        char[] hexValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'A', 'B', 'C', 'D', 'E', 'F'};

        if(useManyMutations){
            int nMutations = random.nextInt(geneSize);
            while(nMutations > 0){
                int geneIndex = random.nextInt(geneSize);
                char rndHex = hexValues[random.nextInt(hexValues.length)];
                setGene(geneIndex, rndHex);
                nMutations--;
            }
        }
        else{
            int geneIndex = random.nextInt(geneSize);
            char rndHex = hexValues[random.nextInt(hexValues.length)];
            setGene(geneIndex, rndHex);
        }
    }

//------------------------------------------------------------------------------
    private void setGene(int index, char gene) {
        genes[index] = gene;
    }

//------------------------------------------------------------------------------
    protected String getChromosome(){
        strGenes = new String(genes);
        return strGenes;
    }

//------------------------------------------------------------------------------
    protected void evaluateFitness(String[] markScheme,
                                  boolean useSubsequence, boolean useSubstring){
        int test_1 = 0;
        int test_2 = 0;
        int totalFitness = 0;

        if(useSubstring && !useSubsequence){
            test_1 = evaluate_LCSubstring(markScheme);
            fitness = test_1;
        }
        else if(useSubsequence && !useSubstring){
            test_2 = evaluate_LCSubsequence(markScheme);
            fitness = test_2;
        }
        else {
            test_1 = evaluate_LCSubstring(markScheme);
            test_2 = evaluate_LCSubsequence(markScheme);
            totalFitness = test_1 + test_2;
            fitness = totalFitness;
        }
    }

//------------------------------------------------------------------------------
    private int evaluate_LCSubstring(String[] markScheme){
        String chromosome = getChromosome();
        int totalFitness = 0;

        for(int index = 0 ; index < markScheme.length ; index++) {
            String comparator = markScheme[index];
            int[][] matrix = new int[geneSize][geneSize];
            int maxLength = 0;

            for (int i = 0; i < geneSize; i++) {
                for (int j = 0; j < geneSize; j++) {
                    if (comparator.charAt(i) == chromosome.charAt(j)) {
                        if (i == 0 || j == 0) {
                            matrix[i][j] = 1;
                        }
                        else {
                            matrix[i][j] = matrix[i - 1][j - 1] + 1;
                        }
                        if (matrix[i][j] > maxLength) {
                            maxLength = matrix[i][j];
                        }
                    }
                }
            }
            totalFitness += maxLength;
         }
         totalFitness = totalFitness/markScheme.length;
         return totalFitness;
    }

//------------------------------------------------------------------------------
    private int evaluate_LCSubsequence(String[] markScheme){
        String chromosome = getChromosome();
        int totalFitness = 0;

        for(int index = 0 ; index < markScheme.length ; index++) {
            String comparator = markScheme[index];
            int[][] opt = new int[geneSize+1][geneSize+1];
            String lcsString = "";

            for (int i = geneSize-1; i >= 0; i--) {
                for (int j = geneSize-1; j >= 0; j--) {
                    if (comparator.charAt(i) == chromosome.charAt(j))
                        opt[i][j] = opt[i+1][j+1] + 1;
                    else
                        opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
                }
            }

            int i = 0, j = 0;
            while(i < geneSize && j < geneSize) {
                if (comparator.charAt(i) == chromosome.charAt(j)) {
                    lcsString += comparator.charAt(i);
                    i++;
                    j++;
                }
                else if (opt[i+1][j] >= opt[i][j+1])
                    i++;
                else
                    j++;
            }
            totalFitness += lcsString.length();
        }
        totalFitness = totalFitness/markScheme.length;
        return totalFitness;
    }


//------------------------------------------------------------------------------
    protected int getFitness(){
        return fitness;
    }

//------------------------------------------------------------------------------
    public int compareTo(Chromosome other) {
        int sortValue = this.fitness - other.fitness;
        return sortValue;
    }
}