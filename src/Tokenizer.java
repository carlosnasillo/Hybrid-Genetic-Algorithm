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

import java.util.LinkedList;
import java.util.List;


public class Tokenizer {

//------------------------------------------------------------------------------
    public String []raw(String data, boolean isSignature, int tLength, int nZeros){
        List<String> L = new LinkedList<String>();
        String[] tokens;
        String[] filteredTokens = new String [L.size()];

        tokens = data.split("(?<=\\G.{" + tLength + "})");
        for(String s : tokens) {
            if(isSignature) {
                if(s.length() == tLength)                                                
                    L.add(s);
            }
            else if(!isSignature) {
                if(filterZeros(s, tLength, nZeros)) {
                    L.add(s);
                }
            }
        }
        return L.toArray(filteredTokens);
    }

//------------------------------------------------------------------------------
    private boolean filterZeros(String s, int tLength, int nZeros){
        int i = 0;
        int zeroCount = 0;                                                          
        while(i < s.length() && zeroCount < nZeros) {                                    
            if(s.charAt(i) == '0'){
                zeroCount++;
            }
            i++;
        }
        if(zeroCount >= nZeros || s.length() != tLength){                                     
            return false;                                                           
        }
        else
            return true;
    }
}
