package files;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Files {


    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("../input.txt");

        Scanner scan = new Scanner(reader);

        System.out.println(scan.nextLine());

        reader.close();
    }
}

// char -- 'a'
// String -- "hello"

