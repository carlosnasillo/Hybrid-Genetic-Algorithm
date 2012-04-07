>##Polymorphic Virus Signature Recognition 
##via Hybrid Genetic Algorithm
####Carlos Alberto Nasillo González

**ABSTRACT**

Computer viruses have become an ever rising plague that constantly poses serious threats to many aspects of our daily life in this current information-based society. Even with the latest virus detection technologies, the exponential growth of computer systems infections is yet to decay due to usage viral polymorphism. Every virus is represented by a unique sequence of hexadecimal characters that current detection mechanisms look for in order to detect malware, however if this pattern is modified in the slightest, the aforementioned process is unsuccessful. 

In this paper, we propose a new type of virus signature definition, called evolutive signature, and a novel detection mechanism to deal with polymorphic viruses using Heuristic String Pattern matching algorithms and by inducing artificial evolution through Genetic Algorithms (GA) on existing virus definitions. The experimental results showed a strong potential for the proposed system in the detection of polymorphic signatures through String Matching heuristics as well as an average of 50% accuracy by means of signature evolution.

</br>
**1.	INTRODUCTION**

   Computer Malware is a program designed to infect, damage computer systems and replicate itself by using a machine resources without the owner’s permission [1]. The term malware is a broader term that includes under its definition; exploits, viruses, backdoors, worms, etc. However, the most distinguished type of malware are viruses; term which was coined by Fred Cohen in 1983 [2].
   
   The increasing usage of web browsers, Peer-to-Peer technology and USB devices has attracted the development of sophisticated types of malware and infection techniques. Such advancement in functionality and behaviour can be classified into five different generations [3]. First generation malware possesses simple infection behaviour, for instance, attaching themselves to benign files and wait for manual execution. The second generation adds sophistication by functionalities such as self-recognition. Stepping into the third generation, viruses use stealth capabilities to decrease detection rates by antivirus software. Malware belonging to the fourth generation uses armouring techniques to prevent disinfection. Finally, the fifth and current generation, uses polymorphism to obfuscate their code with every replication, resulting in the modification of their virus signature and therefore avoiding detection even once discovered.
   
   Polymorphic malware maintains the same functionality and payload as their original version, while having apparently different structures. This polymorphic change (from A1 to A2) of a virus is referred to as a variant of the malware. 
   
   Current antivirus software use primarily static signatures from a database to match against suspicious files and therefore detecting viruses. Each signature is said to be static given it represents a pattern and/or structure of program code which is present in the virus. For each malware variant, a respective static virus signature is needed for successful detection [4, 5]. Polymorphism invalidates such signatures. As a result, one of the aims of the proposed system has been to design a malware detection technique which is resilient to structure obfuscation through polymorphism by developing a Heuristic framework that evaluates using 3 different String Matching algorithms for pattern similarities between the suspect file and the known signatures. 
   
   Moreover, in this paper, a novel type of virus signature definitions have been developed, called evolutive signatures. Such signature is the result of inducing artificial evolution through a Genetic Algorithm on various static definitions of a polymorphic variant. Theoretically, as seen in Figure 1, the evolutive signature represents a Robust Scheme with certain efficiency across a broad spectrum of variants, more specifically; one successfully evolved signature returns a match for different variants of a virus.   
   
 ![figure1](http://i.imgur.com/pjdXb.png)
 
      
      Figure 1: Expected evolvable signature efficiency across the broad spectrum of variants of a given virus
   
         
   Based on the aforementioned design we amalgamated both techniques in a single malware detection program. Experimental results indicate that although variants detection was highly successful using Heuristic Pattern Matching algorithms, those algorithms did not return the same efficiency level when employed as a fitness function on the Genetic Algorithm. 
      
   In addition to the practical aim of this project to develop an accurate polymorphic virus detection tool, another objective is that on the base of the experimental results of this system, draw conclusions that contribute and strengthen the current body of scientific knowledge on this field.
           
   The remainder of this paper is organised as follows. In section 2 we evaluate and discuss in detail related work on the topic. Section 3 provides background knowledge on the topics of virus polymorphism, code obfuscation and Genetic Algorithms. Section 4 provides an overview of the methodology used to develop this project. Section 5 illustrates in detail the proposed system, followed by the Development Process and Results Evaluation in Section 6 and 7 respectively. Last but not least, in Section 8 concludes the paper and offers suggestions for future related works.

</br>
**2.	RESEARCH**

   A wide variety of malware detection techniques have been previously proposed with the aim to prevent different sorts of malware; such as virus, worms, etc. The simplest and most widely used technique is signature-based which requires forensic experts to study each malware assembly code to generate and log its static signature on the database [4]. However, this method requires an individual definition to be logged for each of the virus variants, making it hard, to detect new strains. In order to solve this issue, several approaches were proposed, between them; rule learning [6], data mining [7], neural networks [8] and control flow graph [9], although such systems proved to have certain degree of efficiency detecting new threats, they also returned a significant amount of false positives. For those reasons, the consequent detection methods were suggested, using what is called Static differencing. Early work [10] checks for alterations at code level using line by line comparison, although to a certain extent effective, such technique is expensive in term of computer resources and time. Several different approaches [11, 12, 13] were proposed to assess program similarity by comparing Dependency Graphs, Call graphs and I/O dependencies of functions. All the aforementioned methods, with the exception of [12], work on source or intermediate code representation of the malware, resulting in the method not being able to handle program versions which appear different statically but in runtime behave the same.
   
   Furthermore, compared to the research work and quantity in static differencing, and not only until recent years [14, 15, 16], fewer works have been carried out in dynamic differencing. Through the use of GA in conjunction with Dependency Graph and Heuristics, Kim and Moon [16], successfully detect highly polymorphic Script viruses with no false positives shown in experiments. While such state-of-the-art technique has proven successful for source and byte-code malware, it requires each file tested to go through lengthy complex calculations that notoriously slow down the detection process, and therefore limiting the proposed system. 
   Even though several techniques have been previously proposed for the detection of polymorphic malware, no research was found on the efficiency and manipulation of simple static virus signatures thought GA’s, as well as on the generation of new signature definitions though evolutionary algorithms for polymorphic malware detection. 

- **2.1.	Advanced Literature Review**

   In addition to the above reviewed literature, several other closely related research papers have also been studied. One of these papers [17], examined the possibility of mimicking the human antibodies to gain protection against new strands of malware. This paper advances the idea of using genetic algorithms in order to estimate and induce natural evolution on virus signatures in order to detect malware in a similar way the body develops antibodies. However, this paper focuses on the implementation of memory from previous attacks such that the local minima remain unchanged. Therefore when such minimum is encountered, the algorithm can restore itself to an earlier “safe” state and perform different choices in regards the immunisation against the current malware attack. This algorithm was named REALGO, after the RNA in the human immune system. On the other hand, the main difference with our proposed system is that this method, although successful, did not produce a real knowledge base that could be shared with other isolated computer systems, therefore each system must develop its own memory in order to be protected against current threats. 
   
   Furthermore, and quite the contrary to the objective of our proposed system, another research paper was found on the Evolution of Malware using GA [18]. This paper dealt with the idea of using GA’s in order to evolve malware, rather than the malware detector. This scheme works on the same bases as ours, where each malware has a “genotype” representation based on its low-level code, however the authors studied the automatic creation/evolution of new malicious malware variants based on natural evolution. From the gathered results of their experiments they clearly show that malware can be successfully evolved using nothing more than a genetic algorithm with fine-tuned selection and crossover operators. This paper shined a bright light onto our proposed system, as it has already been demonstrated the ability to create new malware using GA’s, therefore the opposite, which we aimed to accomplish, had a high probability of also being achievable. Additionally we learned that the selection and crossover operators play a fundamental role in the success of the mutation, and for those reasons we allow these values to be modified from the user interface of our program. 
   
   Another paper studied [19] dealt with a comparison for ten different rule-based algorithms, where five of those algorithms (XCA, UCS, GAssistADI, GAssist-Intervalar and SLAVE) were evolutionary and the remaining five non-evolutionary (RIPPER, SLIPPER, PART, C4.5 and RIONA). All the aforementioned algorithms were all implemented to a system with the aim to study their efficiency for detecting malicious executables and studying their performance of these tasks.  According to their findings, Genetic Algorithms had inferior performance, to the counterpart, however other work cited [20] [21] by the authors imply that for others evolutionary algorithms, are generally on par with if not superior to non-evolutive ones. On the other hand, the results of this paper supported our initial hypothesis and matched with our obtained results that Genetic Algorithms are – although slower – accurate and effective mechanisms when implemented for the detection of malware.

- **2.2.	Other Influencing Work**
-  Besides all the previously reviewed material on genetic algorithms, specifically in regards to their implementation in the field of security, several other papers that focus on String Pattern search have been referred to with the aim of gaining further understanding on the topic, therefore allowing us to select the best suited algorithms to use when comparing signature tokens, as well as when evaluating the fitness of chromosomes in the Genetic Algorithm. Some of the algorithms researched include; 
   - Longest Common Substring [22][23]
   - Longest Common Subsequence [24] 
   - Levenshtein Distance [25]
   - Needleman - Wunsch algorithm [26]
   - Smith - Waterman algorithm [27]
   - Fuzzy String Matching [28][29] 
   - Boyer - Moore algorithm [30]
   
   </br>
   As a result of the reading carried out, greater understanding was gained on the factors that denote the performance  and accuracy of a given algorithm, as well as, their suitability for different problems, the main two being; the average lengths of both the base string and pattern length and the uses of insertion, deletions and wildcards during string searches. 
   
   At the initial development stage of the proposed system, only the LCSubsequence algorithm was implemented, however after further analysis of initial results, a new separate “Token grading” framework was developed, using the following algorithms; LCSubstring, LCSubsequence and Levenshtein Distance. These three algorithms met all the desired requirements with relatively average time complexity.  Later on this paper, under sections 4.2, we will elaborate further on the basis for this decision as well as explain in depth how each individual algorithms works.

</br>
**3.	THEORETICAL BACKGROUND**

- **3.1.	Source-code Obfuscation**

   Polymorphic viruses confuse malware detection technologies by code obfuscation, which produces changes in their low-level structure (Figure 2 [31]) and thus making detection hard due to the modification of their hex signature. 

      Figure 2: Example of low-level code obfuscation (in grey) and signature modification through format alteration.
   
   However, computer malware can be written in a variety of programming languages, and different programming languages are handled in different ways; some are compiled directly into machine code (binary executables), while some are converted to instruction files (byte-code) that are then interpreted during execution into machine code (low-level).

      Figure 3: Programming Languages illustration, Compiled vs. Interpreted execution.
   Although, byte-code obfuscation (mid-level) equally results in modifications to the low-level structure of the program, it becomes much harder to obtain static signatures definitions as a vast number of interpreters will need to be developed and implemented to translate, as a whole, the byte-code instruction file into machine language. For that reason, the scope of the proposed system will remain on binary executables and static files such as documents.


--- **3.2.	Virus Polymorphism**
- 
</br>
Along this paper we will discuss code obfuscation in high-level (source code) terms, yet, it is important to emphasise that all obfuscation performed to the source code of a program produces an equivalent change to the low-level structure of itself. 
   The following seven techniques are the most commonly used by virus developers and malware mutation engines [16]. Additionally, Figure 4 (b)-(h) [16] respectively, illustrates in source code form the polymorphism variants of a simple program. 

**_Format Alteration_**

It is done by inserting and/or removing comments and blanks lines. This method in comparison to others is the simplest and has the lowest “success” rate.

**_Variable Renaming_**

Involves the consistent modification of variables identifier names throughout the program. Such technique is ineffective against malware detection mechanisms.

**_Statement Rearrangement_**

Is the rearrangement of programs statements, causing a modification in the program structure, without altering behaviour.

**_Statement Replacement_**

Performs changes on the actual statements, usually though mathematical operations, yet the logic remains unaffected. For example, the variable x=1, could be replaced to x=y/5, exploiting the fact that y=5. 

**_Swapping of Control Statements_**

Variables and dependency statements remain unchanged, while changing control statements that produce the same output. For example, the swap of a while loop with a for loop.

**_Junk Code Addition_**

Unconnected statements are inserted to confuse detection, while not altering the original logic of the program. Such code is inert with respect to the rest of the source code.

**_Code Transportation_**

Consecutive statements are dispersed and associated together by unconditional jumps using goto statements.


     Figure 4: Examples of high-level polymorphism 
     
For complexity and space considerations, three of the above discussed obfuscation techniques are illustrated (Figure 5 [31]) in low-level terms. It is important to remark that the assembly program in the stated figure bellow is not related in terms of functionality to the one provided in Figure 4 (a).
 
Figure 5: Illustration of various changes occurred at low-level though polymorphism.
3.3.	Genetic Algorithms
   Inspired by Darwin’s theory of evolution which presumes what can be summarised as “descent with modification”, meaning that all leaving creatures evolve from ancestors over a period of time. In other words, as random genetic mutations occur within an organism’s genetic code, the beneficial mutations are preserved because they aid survival – a process known as Natural Selection [32].
  In the field of computing, Genetic Algorithms where first proposed by Holland [33] in the early 1970s, where he proposed the mimic of the evolutionary process in nature applied to computer programs.
  Regardless of the search space in which the GA is bound to work on, the manner in which all GA’s execute always remains the same. The genetic algorithm is started with a set of possible solutions (randomly generated) each of them is referred to as a chromosome, forming a population. The best solutions (parents) from one population are taken (selection) and modified through crossover and random mutations in order to form a new offspring pool, this is motivated by the hope that changes in the new population will be better than the old. Parent chromosomes are chosen based on their fitness, in other words, based on their suitability to solve the problem. The above-mentioned steps are repeated until a stated condition is met; usually until x number of generations has been reached.
  
  In order for the reader to better understand how evolution through genetic algorithms is achieved, a special point needs to be made on the operators that are used in a GA. 

Encoding
  One of the fundamental aspects to the structure of a genetic algorithm is the way in which a problem is represented in the form of a string (chromosome). Some of the encoding techniques normally used are Binary, Permutation, Value encoding and Tree encoding. 

Selection
  According with Darwin’s theory of evolution, the best individuals (chromosomes) should have higher survival rate in order to produce offspring. There are several techniques used to achieve that, one of the most widely used being Roulette wheel selection. This method works by placing all of the population’s chromosomes in a “roulette wheel” with the characteristic that higher fitness individuals are given a bigger portion of the wheel, and therefore better chromosomes will have statistically more chances of being selected. Figure 6 illustrates the above.


Figure 6: Roulette wheel selection
Elitism
  In addition to the standard selection process, an optional operator of a Genetic Algorithm is the use of Elitism. This is nothing more than forcibly selecting the two best chromosomes of each population with the aim of ensuring the fittest individuals are always included in the new offspring pool without any alterations to their structure.
Crossover
  As one of the main genetic operators, it function is to vary the “programming” of a chromosome from one generation to the other, however due to the fact that crossover occurs between highly fit individuals, there are high statistical chances that a mixture between both parent will result in a higher fitness offspring. The two main way of performing this technique is through either one, or two points crossover, this second one having an advantage over the first, as it allows genetic material from the middle of both chromosomes to be exchanged, rather than working only with its extremities. Figure 7 exemplifies these procedures. 


Figure 7: One and two-point crossover

Mutation
  This technique prevents the population from falling into a local optimum. In other words, mutation is used to maintain genetic diversity between generations. The average mutation probability is usually 0.5 to 1%, as otherwise will result in the GA becoming nothing more than random search.

Overview of a Genetic Algorithm
1. Start
Create a random population of n chromosomes
2. Fitness
Evaluate the fitness f(x) of each chromosome in the pool
3. New Generation
Create a new offspring until the population size has been met
3.1 - Selection
Select two parent chromosomes for a population according to their fitness.
3.2 - Crossover
Based on a previously stated crossover probability, merge sections of one parent to another and vice versa
3.3 - Mutation
Depending on a mutation probability, randomly mutate one or more locus of an offspring.
3.4 - Acceptance
Introduce the offspring onto the new population
4. Replacement
Re-run the algorithm using the newly created population
5. Test
If current generation is less than the maximum stated repeat step 2, otherwise stop and return best chromosome.
4.	METHODOLOGY
4.1.	Project Overview
Development Approach
  The prototyping development model has been used along this project as this allowed us to evaluate consistently our design methods by actually trying the system. 


Figure 8: Prototyping model
  Further reasons that support the selection of this development approach is that during the proposal and interim milestones of the project, we were allowed to get more tangible feedback by observing the actual performance and the core functionalities of the system against our initial specifications as well as for the problem domain as a whole. Proof of this can be read in section 4.3, where by actually developing the system we found unforeseen issues and could tackle them on time by our choice of proposed solutions, for example; the decision to implement multiple pattern search algorithms to improve heuristic variants detection. The implementation of this model can be shown by the actual steps taken in the process of developing the system;
1.	Write preliminary requirements (Proposal)
2.	Design Prototype (Interim)
3.	Problems discovered and feedback (Interim)
4.	Further develop and polish prototype 
a.	Build User Interface
b.	Implement new Heuristic Framework
c.	Develop Genetic Algorithm
d.	Result chromosome heuristic evaluation
5.	Testing, debugging and minor re-designs
a.	Implement dual fitness evaluators
b.	Implement elitism
c.	Implement optional GA operators
d.	Improve user interface
e.	Correct program irregularities and errors
6.	Finalise the system 
a.	Organise and document source-code
7.	Document the drawn conclusions from the system
   To summarise, our objective when using this technique was to build a very robust prototype in a structured manner and constantly refine it, allowing us to continuously add unforeseen but necessary features, and/or to make changes that couldn't be conceived during the requirements and design phase.

4.2.	Choice of techniques and Justification
String Pattern Matching algorithms 
    As explained earlier, a crucial component of the proposed system is the heuristic evaluation of token similarities between the suspicious file and a given virus definition. After our initial implementation, where we only used the Longest Common Subsequence algorithm, we learned that the accuracy of this algorithm alone will not suffice. We then proceeded to study and implement related string search algorithms with the aim that these will complement each other producing higher fidelity token matches and therefore increasing the probability of successfully generating a high fitness evolutionary signature. In this section we will briefly expand on how each of this algorithms work, and on those bases justify our decision behind using them in conjunction. 

Longest Common Subsequence 
  This algorithm is used to find the longest subsequence common to all sequences in a set of strings. 


Figure 9: Longest Common Subsequence Problem
In other words, this algorithm finds a sequence of characters S that is present in the same continuous order in any given two strings A and B. For example;


Figure 9: Subsequence Match
  The characteristics of this algorithm are ideal for solving our problem, as when used to find the similarities between to tokens, even if not exactly the same (ie: polymorphism due to junk code insertion) it will still turn an accurate match by removing the element(s) that was introduced though polymorphism.
Longest Common Substring 
  The Longest Common Substring problem is based on first finding the longest common suffix for all pairs for prefixes on the string:


Figure 10: Longest Common Suffix Problem
Then we find the maximal of the common suffixes matches of all the possible prefixes, and these must be the longest common substring of A and B:


Figure 11: Longest Common Substring Problem
In other words, all this can be summarized as finding the longest string S that is a sub-string of two or more strings. For example; given two strings A and B, of length X and Y respectively, find the longest string which is a substring of both A and B.

  This algorithm is tremendously useful when solving the sort of paradigms proposed for the heuristics in our system when trying to find pattern similitudes between tokens. This implementation will allow us to find consistent patterns as well as in some cases exact token matches that will statistically represent very high probabilities of polymorphism (ie, Code transportation).

Figure 12: Substring Match example
Dynamic GA operators
  As mentioned earlier in this paper, after thorough testing and evaluating the effects that different probabilities and GA operators have in terms of signature evolution accuracy, we proceed to design and implement in the system most of the existing genetic operators. Furthermore, we allow the user to easily fine-tune these values through the user interface. As a result, we have produced a flexible genetic algorithm that offers the opportunity for the user to experiment and observe the great difference that the slightest change of these values can produce.

4.3.	Constraints & Limitations
   Since the early stages of development, and after gaining further knowledge on, string pattern matching algorithms performance, the good and bad aspects of genetic algorithms and observing the actual performance of the program at its different stages, a number of constraints and limitations of the proposed system where defined. Along this section we elaborate on such findings as well as discuss the reasoning and justification behind them.

Heuristics - false positives
   After careful examination during the early stages of the proposed system a key constraint was discovered. During the first heuristics (using only LCS) of token matching, if a false positive does occur, the benign file will continue onto the evolution stage. Then if during the 2nd heuristic process the evolved signature is also flagged as Malware the system will automatically store the false-positive evolvable signature onto the malware database, resulting in a loss of accuracy and potentially reducing the effectiveness of the system. In order to avoid such loss of accuracy, the following proposed solution has been implemented on the final program. 
  Initially, we further developed the token matching framework to include several strings matching algorithms which resulted in higher accuracy token matches and therefore avoiding false-positives in the initial examination process. In the situation this newly implemented grading framework also returns a false-positive, we reduce the system’s accuracy loss by performing the following step. When a file is classified as malware with a bare minimum statistical similarity, the evolvable signature will be placed onto a second database of virus signatures. When signatures from this database are used during a file scan, the heuristic classification of the file in question will be more vigorous (higher similarity between tokens is required) that way compensating for any possible loss of accuracy with the system. 

File Size
   Given the nature of the proposed system it is necessary to scan for similarities using complex algorithms a very large combination of strings, resulting in a lengthy operation even with the smallest of files. Therefore, it has been decided that the file in question to be scanned remains smaller than 500kb that way the performance of the proposed system will not represent a limiting factor in terms time, during the detection and evolution processes. 

Evolution local minima
  Earlier on this paper we elaborated on the weakness of genetic algorithms to fall at times under a local minima. For that reason we implemented not only single locus mutations but actually allow the user to select under the GA settings an option to use multiple random mutations at random intervals per chromosome, producing a positive effect on both the positive evolution of chromosomes in terms of fitness and guaranteeing genetic diversity.  
5.	PROPOSED SYSTEM
5.1.	Outline
   A graphical representation of the proposed system can be seen in figure 6.

1.	The system parses and converts the target file S1 to be examined to a hexadecimal representation; this string is then broken down into strings of 10 hex characters. At this point S1 has not yet been classified as either benign or infected.

2.	The system then proceeds to select a known static malicious signature S2 from the database.

3.	Once S2 has been selected, it is broken into groups of 1014 hexadecimal characters. The system then compares recurrently each hex group of S1 against each group of S2. In the process, S1 groups are given a grade individually according to their statistical similarity with S2. If the process is unsuccessful, the system returns to step 2.

4.	If a match with statistical significance is found between S1 and S2 , then S2 will automatically becomes part of the “mark scheme” in the Genetic Algorithm, to which chromosomes will be evaluated against.

5.	Using a Hybrid Genetic Algorithm, the system will draw the final decision, measuring the evolved signature Se against all of the elements of the GA mark scheme (using Substring and/or Subsequence).

6.	If Se is re-evaluated using step 3, if a match is returned, then it is added to the known malicious signature database for future use.


Figure 13: Overview of the proposed system
5.2.	Heuristic Evaluators
  The string matching framework is comprised by the three earlier mentioned algorithms; The Longest Common Subsequence, Longest Common Substring and the Levenshtein Distance algorithm. From all of the above, the Longest Common Subsequence carries most of the weight when grading a token. The logic behind it is that as in polymorphic signatures the string is consistently modified and mostly only by a few values, the Subsequence problem return higher matches than the Longest Substring. The following example, illustrates in practice this theory.


Figure 14: Substring vs Subsequence match
  Figure 14, can be better explained on the following way; Substrings are consecutives parts of a string, while subsequence’s need not to be. Therefore, a Substring of a signature is always a subsequence of the signature, but a subsequence of a signature is not necessarily a substring of that same signature. 
  On that knowledge, the proposed system always checks first for the Longest Subsequence, when its length is >= 70% of the original string, we proceed to evaluate it again only this time we check for longest Substring and the edit distance, otherwise if less than 70% is discarded. In the situation the Longest Subsequence equals the length of the signature token, this token is no longer evaluated and is immediately stored on the system, otherwise it proceeds to be evaluated.
  The percentage that each of the algorithms contributes to the final grade of the token on base 100 is the following;

•	Subsequence = 60% (100% if exact match)
•	Substring = 30%
•	Levenshtein = 10%

  Finally, another reason why the grading framework was developed in such way is that this process; of first checking for Subsequence’s and then for the other algorithm, allows us to stop examining a token that will score poorly, resulting in a reduction of execution time.

5.3.	Genetic Operators
   Given the substantial number of possible variations of a virus signature, a Genetic Algorithm is appropriate method to cover in a relatively short period of time the search space of this problem. A GA will generate a set of initial solutions and evolves them in parallel over a set number of iterations. Said number of iterations can be shorten once the best solution is found (through a fitness/objective function), then the algorithm terminates. The proposed GA is explained in further detail bellow;

Chromosome Representation
   As in all GA’s, linear representation is required for the chromosomes. In the proposed system, the hexadecimal signature itself will represent the chromosomes. Each gene set in the chromosome is equivalent to the hexadecimal representation of a machine code statement. 

Fitness Function
   In order to evaluate how well each chromosome solves the problem at hand, all chromosomes are graded against an objective function that represents the problem itself. In this case, the longest common subsequence’s and substrings combined when evaluated against the GA’s mark scheme signatures. The higher the fitness value, the lower difference between Se and all the elements of the mark scheme.

Initialization
   All chromosomes are created at random, all with equal length. This length is set on the recommended value of 10 however it can be modified on the user interface.

Selection
   In order to determine offspring reproduction, this operator allocates all chromosomes in a “roulette wheel” with slots sized accordingly to their fitness value.

Crossover
   This operator will randomly choose one or multiple locus (depending whether two-point crossover is selected) and exchange the content after (or between) the locus among the two chromosomes.
 
Mutation
   According to [34, 35], mutation probabilities should remain significantly low, between Pm = 0.01 and Pm = 0.001. This will randomly select a locus in a chromosome and swap the character in that position for another randomly generated hexadecimal value. This parameter can also be fine-tuned on the user interface, and additionally multiple mutations per chromosomes can be selected for use.
Replacement
   During each generation, we will replace the old individuals by performing roulette wheel selection, crossover and mutation to the offspring until the stated population size has been met.

5.4.	Dataset
  In order to try the correct functioning of the program we gathered [36] 14.000 static virus signatures in the form of a .csv file as our virus knowledge base. Additionally we manually created polymorphic virus strings (based on those acquired signatures) which we used to embed on files using Hexadecimal Editors, or just by just entering them into the program under the option “Check a signature string”.

6.	SYSTEM DEVELOPMENT 
6.1.	Program Overview
  On program start the user is presented with user interface from where all the resources (file/signature to scan) are selected and where the settings of both the heuristics and GA can be modified. Figure 14 illustrates the user interface of the program.


Figure 14: Program Interface
  First, the user selects whether he/she desires to examine a suspect hexadecimal signature or a suspicious file for polymorphism. Depending on the choice, the button and text field bellow will change according to the selection. If the user selected to enter a string the text box will become enabled allowing the user to type/paste a string, this string is then validated (See section 6.3) and a success of error icon is display adjacent to the field.
See Figure 15 on following page.

Figure 15: String check input and validation
This same process is repeated when a user chooses to scan a file, with the difference the button “Enter string” becomes “Select a file” that when pressed displays a file chooser for easier directory browsing, the absolute path to the file selected is then displayed in the disabled text field. This process is also validated to avoid selecting corrupted files, or files without the correct permissions. See screen capture bellow.

Figure 16: File Selection and validation
  Once the above is completed, the user is requested to choose a signature database as the knowledge base for the program. The selection process is the same as when selecting a file, however, in addition to the standard file validations another check is added to corroborate the file contains signatures, this process is explain in further detail on section 6.3.
  Prior to selecting the files and database, the user has the option to modify the parameters that will be used for the token matching heuristics, these settings will be frozen (disable UI components) to ensure consistent manipulation of strings and therefore avoiding program errors. Figure 17 shows the available settings.


Figure 17: Modifiable Heuristic settings
    At this point the user is able to initialize the program, to find possible variants of the suspect file. In order to do so the user clicks the button “Scan” and the string pattern matching algorithms will initialize. Prior and throughout the whole of the program’s execution the user is informed at the program log text area of major events, such as; file selection error or success, and current stages of the detection process. Furthermore a progress bar displays to the user a friendlier estimate of completed and remaining processes.


Figure 18: Program log and Progress bar
  After this initial heuristic string matching stage has finished and depending on the results, the user will be notified the following;
•	“No matches found”, therefore end of program
•	“Low fidelity matches found” (< 65% avrg. grade)
•	“High fidelity matches found”
  Depending on the above, the program will either stop executing but remain open, if low fidelity then matches will be displayed in the “Matches Table” (Figure 19) and the user has the option to force GA evolution, and in the case high grade matches are found, then program automatically initializes the genetic algorithm to work on those found variants.


Figure 19: Low fidelity matches returned
  In the events when the genetic algorithm is either forced or started automatically, the progress bar will update its values accordingly with the progress of these procedures. In addition to that the program will inform the user of relevant information of the evolution process such as; highest fitness achieved, current generation and display the current best chromosome. The screen captures of figure 20 demonstrate how this is presented to the user.


Figure 20: GA Evolution information
  Once the signature evolution has been finalized, the program will prompt the user to re-check if desired the evolved signature against the suspicious file and previous variant matches. This is done by selecting the button “Check evolved Signature”, which when pressed will repeat the string matching heuristics on the new data.

Figure 21: Prompt for evaluation of evolved signature
  Finally, after the evolved signature has been evaluated, the user will be informed in the program log whether signature evolution and therefore detection was successful or not. If successful the matching variants for the evolved signature of the suspicious file is displayed alone with its grade on the Token Matches table.

6.2.	Stepwise Program Execution 
  On this section we have produced a concise explanation of the development process for each of the components of the system as well as the order of execution on which these are carried.

Interface initialization
   On execution the program first declares and initializes all of the elements of the user interface, as well as sets the look as feel to the windows theme. At this point and previous to beginning the scan process the program variables are updated according to the UI setting values.

File Selection
  In order for the user to easily select the desired file and database to use, a JFileChooser swing window is displayed, once the user selects the desired file, its absolute path is stored for usage on the following step

Hexadecimal parser
   In this next step the program parses trough the selected file we wish to scan. Initially when reading the Input Stream the file is parsed in binary mode, for that reason we create a control statement that for each byte read, we convert the in byte to hexadecimal notation using the pattern “%02X” which will format the string to produce a two hexadecimal value of an integer using capital letters for the hex digits. As this process continues, the “translated” input stream gets appended to form single string.

Loading the database
   Due to the way out virus signature database is formatted, a few steps are necessary when loading the database onto the program.
   Once the file has been selected, we proceed to organize the data by separating the name of the virus signature from its signature. We accomplish this by using a regular expression on the “=” sign when performing the string split. This is then set as the new virus object parameters. Last we store each virus object in an array list of VirusData.

Tokenizing the Hexadecimal String
   According to our system specifications, we require the file hexadecimal representation, as well as each virus signature, to be tokenized with equal length. In order to achieve that we implement the string split( ) method together with a regular expression where N states the length of each token. As a result the whole string is tokenized and stored in the respective object class.

Filtering clutter tokens
   In order to reduce false positive matches when performing the heuristics given many tokens are mainly zeroes, a method called zerosFilter( ) was implemented. Due to the way our Grading framework works, having a token containing mostly zeroes will result in that somewhat meaningless token being graded highly due to high matches and therefore reducing the accuracy of the proposed system. 
   The mentioned method stops the storage of tokens with more than 5 zeroes (recommended value).

Grading Framework
   Once we have organized and tokenized all the necessary data needed, the process to find the similarity between tokens begins. As extensively explained; this process first proceeds to evaluate each of the tokens in the suspect file/string against all of the tokens of each virus signature. The first algorithm to take place is The Longest Common Subsequence. Depending on the token match length, this will be either discarded (less than 70% the original token length) or it will proceed for further examination by means of the Longest Common Substring and the Edit Distance. Once the process has finished for a particular virus signature, the token grade average is calculated and the tokens are stored as a string array on the virus object. This process is repeated until all signatures have been evaluated against the suspect file.

Displaying Heuristic matches
   After the above process has been completed, the program proceeds to iterate through the virus database displaying (if possible) in the matches table the five highest graded viruses. The execution time of this process has been reduced by sorting and reversing the order of the virus elements of the array list based on their total grade. If no matches were found program executions terminates, otherwise it continues to signature evolution through the GA.

GA signature evolution
   Regardless of whether the evolution has been forced (low fidelity token matches) or started automatically (high fidelity matches) the genetic algorithm process remains the same. This process has already been explained on detail under the chapter “Proposed System” sections 5.1 and 5.3.

Evolved signature heuristic evaluation 
   Once the genetic algorithm has finished and the best evolved chromosome identified, upon user request, the signature is re-evaluated using the Heuristic Grading Framework to corroborate that the evolution process has returned an equally high fidelity match for both the suspect file and the initially signature matches. The outcome of this evaluation can be either; unsuccessful, low fidelity or high fidelity. An unsuccessful evolutive signature is that which does not return a match for any of the initial heuristic variants, low fidelity are those with an average grade of over 40% but less than 65%. All matches above 65% are high fidelity and it can be considered as a successful detection and evolution of the polymorphic virus.
  



6.3.	Problems Encountered & Solutions 
  During the development of the proposed system several problems arose and decisions on how to approach each problem where achieved by performing further background reading on the topics in question. All through this section we will expand on such pitfalls and the solutions proposed to resolve them.

String Pattern Search algorithms
   As explained earlier, this is one of the most important aspects of the proposed system; therefore extensive research was performed on the area, more specifically on the performance, efficiency and accuracy of the metrics suitable.
Problem Approach: On the bases of our research and observing the results of the initial prototypes, we modified the specifications of the system to implement multiple string matching algorithms and therefore increase the accuracy of virus detection. 

Clutter tokens
   Closely related to the above problem, the return of low relevance tokens was also an undesired result of the string comparison algorithm. Although, it does not directly affect the achievement of the desired results by the proposed system, it does reduce the performance of the system if not discarded, given more operations are performed when storing and accessing such tokens. 
Problem Approach: For those reason, the system was modified only to store in the tokens with higher statistical relevance – where length is >= 70% of the original token.  

Swing Progress Bar
   Another frustrating problem encountered was the difficulty to make the progress bar update in real time according to the progress of the execution. After further reading, it was learned that the problem causing this was the lack of multithreading as in java the UI will not be updated until the current method process has completed.
Problem Approach: We implemented multi-threading programming into the program by creating an additional swing worker thread that constantly (in parallel) examines the current progress of the method and resets the values of the progress bar accordingly.

7.	EXPERIMENTAL RESULTS
  A number of experiments were conducted with the aim to verify the accuracy and efficiency of the system to solve the problem in hand. On this section we provide the individual experimental results of the heuristic framework, the genetic algorithm and of the system as a whole. Subsequently, we will discuss whether or not these results support our theory and approach for detecting polymorphic viruses.
7.1.	Polymorphic variants test-cases
  Table 1 contains a set of randomly selected polymorphic virus variants for testing each of the main components of the system. On all of these variants one or more forms of polymorphism techniques have been used. 

Virus Name
Polymorphic Variants





Austr
Austr.152, Austr.155, Austr.217, Austr.221,
Camel
Camel.402, Camel.443, Camel.496, Camel.514
Dumb
Dumb.218, Dumb.579, Dumb.227, Dumb.192
Brigit
Brigit.399, Brigit.425, Brigit.301, Brigit.70
MacGyver
MacGyver.1098, MacGyver.4112, MacGyver.4643
Table 1: Malware and variants used for tests

7.2.	Heuristic Matching evaluation
  Using the above illustrated knowledge-base we proceeded to test a new polymorphic variant of each malware in order to test the efficiency of our string grading framework. The table below shows the average string match grade for each known variant against the new strain.
  It is important to remark that a grade less than 40% is not considered a match, above that number but below 65% is low fidelity match, and above 65% is considered as a potential variant of the virus.

Virus Name
Heuristic Avrg

Test against Austr.338
Austr.152
51%
Austr.155
51%
Austr.217
<  40%
Austr.221
<  40%
Test against Camel.443
Camel.402
63%
Camel.500
<  40%
Camel.496
92%
Camel.514
92%
Test against Dumb.193
Dumb.217
62%
Dumb.579
<  40%
Dumb.227
<  40%
Dumb.192
97%
Test against Brigit.88
Brigit.399
86%
Brigit.425
76%
Brigit.301
<  40%
Brigit.70
76%
Test against MacGyver.41B
MacGyver.1098
<  40%
MacGyver.4112
<  40%
MacGyver.4643
<  40%
TOTAL MATCHES
10/19
Table 2: Heuristic Matches
7.3.	Genetic Evolution Efficiency
  Based on the dataset shown on table 1 and following the results of the Heuristic evaluation illustrated on table 2, whenever possible the process of evolution was carried out with the aim of observing the success rate of the GA for evolving a signature using string matching algorithms as a fitness evaluator. 
  Elements of the table set to bold font, are the malware variants that were detected either as a low or high potential match during the heuristic stage. The evaluation fidelity range equals to the limits set on the grading framework.


Virus Name
Evolution Fidelity

Test against evolved Austr.338
Austr.152
-
Austr.155
-
Austr.217
-
Austr.221
-
Test against evolved Camel.443
Camel.402
-
Camel.500
-
Camel.496
Low (56%)
Camel.514
-
Test against evolved Dumb.193
Dumb.217
-
Dumb.579
-
Dumb.227
-
Dumb.192
Low (61%)
Test against evolved Brigit.88
Brigit.399
-
Brigit.425
-
Brigit.301
-
Brigit.70
Low (47%)
Test against evolved MacGyver.41B
MacGyver.1098
-
MacGyver.4112
-
MacGyver.4643
-
TOTAL MATCHES
3/10
Table 3: Evolution Success rate using GA

8.	DISCUSSION & CONCLUSION
  The results obtained from the initial evaluation of the tokens for common patterns, always returned as a minimum 2 matches for each variant, with the exception of MacGyver.n. This is quite a successful achievement as it shows the potential as well as a respectable accuracy level of the combination of various string pattern matching algorithms. With the research performed to date, no strong grounds where found on the actual use of these algorithms, even less, the combination of the three to analyse and detect potential polymorphic malware. If these techniques were to be fine-tuned and implemented using suffix trees rather than dynamic programing both the accuracy and performance of this heuristic process could be improved. 
  A down side to this implementation is the computational cost to examine even the smallest of files, which sadly, and at least at this current stage does not facilitate its use in real world applications. 
  When evaluating the other important part of our proposed system (Genetic Algorithm) we obtained rather disappointing results for the test cases used, and for the particular settings configured. Only three out of ten matches (detected by heuristics) returned some level of plausible evolution, more specifically; the matches found not only had a low fidelity, but also returned a maximum of 1 for all the variants of a virus. 
  After further evaluation on why is was happening, a trend in the results started to become clear. Due to the fact the GA implements string matching for all the variants, the resulting evolved signature becomes somewhat of an “average signature” rather than an evolutionary one. This can be seen in table 3 where all of the low fidelity matches have around 50% less of a grade than when compared to the initial heuristics.
  Based on that reasoning, it is possible that by only evolving usnig one of the string matching algorithms, we could slightly increase the accuracy of the evolved signature. Nevertheless, for these and many other reasons such as; computational cost and time complexity, the current implementation of a genetic algorithms using string Substring and Subsequence algorithms as fitness functions for evolution do not seem as a viable way for detecting malware just yet. 


