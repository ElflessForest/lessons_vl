package files;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
public class Task {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("C:\\Users\\Владимир\\IdeaProjects\\lessons_vl\\src\\input.txt");


        Scanner scan = new Scanner(reader);

        ArrayList<Integer> array = new ArrayList<>();

        while (scan.hasNextInt()) {
            array.add(scan.nextInt());
        }


        int x = Math.abs(array.get(0) - array.get(1));

        for (int i = 1; i < array.size() - 1; i++) {
            int a = Math.abs(array.get(i) - array.get(i + 1));
            if (a < x) {
                x = a;
            }
        }
        System.out.println(x);


        reader.close();
    }
}
