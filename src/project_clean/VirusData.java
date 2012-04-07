
package project_clean;


public class VirusData implements Comparable<VirusData> {                           
//..............................................................................
    protected String name;                                                          
    protected String signature;                                                     
    protected String []tokens;                                                      
    protected String []tLCS;
    protected float grade;
    protected float gradeAVRG;
//..............................................................................

//------------------------------------------------------------------------------
    public VirusData(String vName, String vSignature) {
        name = vName;
        signature = vSignature;
    }

//------------------------------------------------------------------------------
    public int compareTo(VirusData other) {
        int gradeCompared = (int) (this.grade - other.grade);
        return gradeCompared;
    }

//------------------------------------------------------------------------------
    protected String getName(){
        return name;
    }

//------------------------------------------------------------------------------
    protected String getSignature(){
        return signature;
    }

//------------------------------------------------------------------------------
    protected String[] getTokens(){
        return tokens;
    }

//------------------------------------------------------------------------------
    protected void tLCS_setSize(int size){
        tLCS = new String[size];
    }

//------------------------------------------------------------------------------
    protected String[] getMatchesLCS(){
        return tLCS;
    }

//------------------------------------------------------------------------------
    protected float getGrade(){
        return grade;
    }

//------------------------------------------------------------------------------
    protected void calculateGrade_AVRG(int length){                                  
        if(length > 0){
            gradeAVRG = grade/length;
        }
        else{
            gradeAVRG = 0;
        }
    }

//------------------------------------------------------------------------------
    protected int getGradeAVRG(){
        return (int) gradeAVRG;
    }
}
