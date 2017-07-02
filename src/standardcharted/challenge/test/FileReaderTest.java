package standardcharted.challenge.test;


import standardcharted.challenge.FileReader;

/**
 * Test if it properly reads the file.
 * Created by Harsha on 9/5/17.
 */
public class FileReaderTest {

    public static void main(String[] args){
        FileReader fileReader = new FileReader();
        fileReader.readFileX(args).stream().forEach(x -> System.out.println(x.getAccountId()));
    }

}
