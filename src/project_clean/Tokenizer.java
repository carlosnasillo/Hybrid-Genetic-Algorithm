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
