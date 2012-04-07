package project_clean;


public class Grader {

//------------------------------------------------------------------------------
    public int gradeTotal(String fileT, String virusT,
                          String matchT, int tLength){
        int finalGrade = 0;
        if(matchT.length() == tLength) {
            return 100;
        }
        else {
            finalGrade = testA_Lenght(matchT, tLength) +
                         testB_LCSubstring(fileT, matchT) +
                         testC_Levenshtein(fileT, virusT);
            return finalGrade;
        }
    }

//------------------------------------------------------------------------------
    private int testA_Lenght(String matchT, int tLength){                     
        if(matchT.length() == tLength)
            return 100;
        else if(matchT.length() == tLength-1)
            return 40;
        else if(matchT.length() == tLength-2)
            return 30;
        else if(matchT.length() == tLength-3)
            return 20;
        else if(matchT.length() == tLength-4)
            return 10;
        else if(matchT.length() == tLength-5)
            return 5;
        else
            return 0;
    }

//------------------------------------------------------------------------------
    protected int testB_LCSubstring(String fileT, String matchT){               
        int lcsLength = 0;
        int grade = 0;
        int mT_Length = matchT.length();
        int fT_Length = fileT.length();
        int[][] matrix = new int[mT_Length][fT_Length];

        for (int i = 0; i < mT_Length; i++) {
            for (int j = 0; j < fT_Length; j++) {
                if (matchT.charAt(i) == fileT.charAt(j)) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    }
                    else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    if (matrix[i][j] > lcsLength) {
                        lcsLength = matrix[i][j];
                    }
                }
            }
        }
        grade = (lcsLength/mT_Length)*40;
        return grade;
    }

//------------------------------------------------------------------------------
    protected int testC_Levenshtein(String fileT, String virusT){               
        int[][] distance;
        int cost = 0;
        int grade = 0;
        int vT_Length = virusT.length();
        int fT_Length = fileT.length();

        distance = new int[vT_Length + 1][fT_Length + 1];
        for (int i = 0; i <= vT_Length; i++){
            distance[i][0] = i;
        }
        for (int j = 0; j <= fT_Length; j++){
            distance[0][j] = j;
        }
        for (int i = 1; i <= vT_Length; i++){
            for (int j = 1; j <= fT_Length; j++) {
                if(virusT.charAt(i - 1) == fileT.charAt(j - 1)){
                    cost = 0;
                }
                else{
                    cost = 1;
                }
                distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1,
                                                   distance[i][j - 1] + 1)
                                          , distance[i - 1][j - 1] + cost);
            }
        }
        grade = 10-(distance[vT_Length][fT_Length]);
        return grade;
    }
}
