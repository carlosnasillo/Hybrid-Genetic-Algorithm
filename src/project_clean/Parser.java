package project_clean;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Parser {

//------------------------------------------------------------------------------
    public String binaryFileToHexString(final String path)
        throws FileNotFoundException, IOException {
            final int bufferSize = 512;                                             
            final byte[] buffer = new byte[bufferSize];
            final StringBuilder FileHexFormat = new StringBuilder();
            FileInputStream stream = new FileInputStream(path);
            int bytesRead;

            while ((bytesRead = stream.read(buffer)) > 0) {
                for (int i = 0; i < bytesRead; i++) {
                    FileHexFormat.append(String.format("%02X", buffer[i]));
                }
            }
            stream.close();
            return FileHexFormat.toString();                                                       
    }

//------------------------------------------------------------------------------
    public String[] readVirusDatabase(final String filename) throws IOException {
        List<String> vListRaw = new ArrayList<String>();
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String vSignature = null;

        while ((vSignature = bufferedReader.readLine()) != null) {
            vListRaw.add(vSignature);
        }
        bufferedReader.close();
        String []definitionsListDirty = vListRaw.toArray(new String[vListRaw.size()]);
        return definitionsListDirty;
    }

    public String[] cleanDefinitionList(String rawDefinition){                                       
        String []cleaned = rawDefinition.split("=");
        return cleaned;
    }

//------------------------------------------------------------------------------
    public String removeSpaces(String dirtyStr) {
        StringTokenizer string = new StringTokenizer(dirtyStr," ",false);               
        String cleanStr="";
        while (string.hasMoreElements()) {
            cleanStr += string.nextElement();
        }
        return cleanStr;
    }
}
