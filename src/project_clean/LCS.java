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
