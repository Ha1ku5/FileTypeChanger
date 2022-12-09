import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Dictionary;

public class Main {
    private static StringBuilder fileNames = new StringBuilder();
    private static Dictionary<String, String> pathToHex;//key: filepath value: first line of file as hex

    public static void main(String[] args) throws IOException {

        File curDir = new File("."); //curDir = current dir, TODO: user inputs the directory
        getAllFiles(curDir); //fills fileNames with names of all files







    }
    private static void getAllFiles(File curDir) {

        File[] filesList = curDir.listFiles();
        assert filesList != null;
        for(File f : filesList){
            if(f.isDirectory())
                getAllFiles(f);
            if(f.isFile()){
                //System.out.println(f.getName());
                fileNames.append(f.getName()).append(", ");
            }
        }

    }







    public static String asHex(File file) throws IOException {
        //sets file to file
        //file = new File(fileName);
        //sets input stream to file input stream
        InputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (input == null) {
            System.out.println("Error, file is null");
            System.exit(0);
        }
        int byteIndex = 0;
        boolean run = true;
        StringBuilder firstLine = new StringBuilder();
        for (int byteCount = 0; byteCount < 16; byteCount++) {
            firstLine.append(String.format("%1$02x ", input.read()));
        }
        return firstLine.toString();
    }


}

























