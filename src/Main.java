import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    private static HashMap<String, String> nameToHex = new HashMap<>();

    public static void main(String[] args) {

        File curDir = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\"); //curDir = current dir, TODO: user inputs the directory
            try {
                //getAllFiles(curDir); //fills fileNames with names of all files
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("IO Exception");
                System.exit(0);
            }
        curDir = null;


        File one = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\newtwo.txt");
        System.out.println(one.canWrite());
        File newFile = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\new.txt");

        boolean success = one.renameTo(newFile);
        System.out.println(success);

        /*
        for (String path : nameToHex.keySet()) {
            File file = new File(path);
            System.out.println(path);
            //File newName = new File(path.substring(0, path.lastIndexOf('.')) + "png");
            File newName = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\newfile.png");
            System.out.println(file.getPath());
            boolean flag = file.renameTo(newName);
            System.out.println(flag);
            //file = changeExtension(file, ".txt");

            //file = changeExtension(nameToHex.keySet())

            //System.out.println(path);
            //System.out.println(nameToHex.get(path));
            //System.out.println();
        }

         */





    }
    public static File changeExtension(File f, String newExtension) {
        int i = f.getName().lastIndexOf('.');
        String name = f.getName().substring(0,i);
        return new File(f.getParent(), name + newExtension);
    }

    //gets every file in a specified folder recursively
    //fills dictionary with file name and first line of hex
    private static void getAllFiles(File curDir) throws IOException {

        File[] filesList = curDir.listFiles();
        assert filesList != null;
        for(File f : filesList){
            if(f.isDirectory())
                getAllFiles(f);
            if(f.isFile()){
                nameToHex.put(f.getAbsolutePath(), asHex(f));
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
        input.close();
        return firstLine.toString();

    }


}

























