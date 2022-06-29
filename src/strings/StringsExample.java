package strings;

import java.util.ArrayList;

public class StringsExample {

    public static void main(String[] args) {


        String s = "hello everyone! It's nice to meet you";

        ArrayList<String> words = new ArrayList<>();

        String word = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z' || ch == '\'') {
                word += ch;
            } else {
                words.add(word);
                word = "";
            }
        }
        if (!"".equals(word)) {
            words.add(word);
        }

        System.out.println(words);


    }



}
