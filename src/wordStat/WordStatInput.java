package wordStat;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordStatInput {
    public static void main(String[] args) throws IOException {


        FileReader reader = new FileReader("C:\\Users\\Владимир\\IdeaProjects\\lessons_vl\\src\\input.txt");


        ArrayList<String> rawList = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scan = new Scanner(reader);
        String raw = scan.nextLine().toLowerCase();
        String word = "";



        for (int i = 0; i < raw.length(); i++) {
            char ch = raw.charAt(i);
            if ('a' <= ch && ch <= 'z' || ch == '\'' || 'а' <= ch && ch <= 'я' || ch == '-') {
                word += ch;
            } else if (!word.isEmpty()){
                rawList.add(word);
                word = "";
            }
        }
        if (!"".equals(word)) {
            rawList.add(word);
        }

        System.out.println(rawList);



        for (int i = 0; i < rawList.size(); i++) {
            boolean flag = false;
            int j = 0;
            for (j = 0; j < words.size(); j++) {

                if (words.get(j).equals(rawList.get(i))) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                numbers.set(j, numbers.get(j) + 1);
            } else {
                words.add(rawList.get(i));
                numbers.add(1);
            }
        }
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " " + numbers.get(i));
        }

    }
}
