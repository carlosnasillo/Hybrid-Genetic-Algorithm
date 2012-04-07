package project_clean;


public class LCS {

//------------------------------------------------------------------------------
    public String analyzeTokens(String vName, String vToken,
                                String fToken, int tLength) {
        int[][] opt = new int[tLength+1][tLength+1];                                        

        for (int i = tLength-1; i >= 0; i--) {
            for (int j = tLength-1; j >= 0; j--) {
                if (vToken.charAt(i) == fToken.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        int i = 0, j = 0;
        String lcsString = "";
        while(i < tLength && j < tLength) {
            if (vToken.charAt(i) == fToken.charAt(j)) {
                lcsString += vToken.charAt(i);
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1])
                i++;
            else
                j++;
        }
        if((100/tLength)*lcsString.length() >= 70) {                                           
            return lcsString;
        }
        return null;
    }
}
