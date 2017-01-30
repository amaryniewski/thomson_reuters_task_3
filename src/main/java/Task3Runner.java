import java.io.*;
/**
 * Created by adrianmaryniewski on 22.01.2017.
 */
public class Task3Runner {

    /*
    Because of this kind of error, I was forced to cut the original file into the shorter one.
    "The file size (3230016 bytes) exceeds configured limit (2560000 bytes). Code insight features are not available."
    I parsed the shorter one and it seems it's working.
     */

    public static void main(String[] args) throws IOException {
        TableOfContents runner = new TableOfContents();
        String fileName = "src/hurricanes_2009_season.rtf";
        runner.parseTxtFile(fileName);
    }
}