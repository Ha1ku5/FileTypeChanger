import java.io.File;

public class FileList {

    public static void main(String[] args) {
        File toEdit = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\renameMe.txt");
        File rename = new File("C:\\Users\\4l3x0\\Desktop\\testFolder\\success.txt");

        boolean result = toEdit.renameTo(rename);
        System.out.println(result  );
    }









}
