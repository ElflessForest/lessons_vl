package strings;

import java.util.ArrayList;

public class Splitter {


    private static ArrayList<Integer> split(String string) {
        String word = "";
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch >= '0' && ch <= '9' || ch == '-') {
                word += ch;
            } else if (!word.isEmpty()){
                int num = Integer.parseInt(word);
                word = "";
                arrayList.add(num);
            }

        }
        if (!word.isEmpty()) {
            int num = Integer.parseInt(word);
            word = "";
            arrayList.add(num);
        }
        return arrayList;
    }



    public static void main(String[] args) {
        String string = "-11---  ----              2       3 4 5         \t   6 7                               8 8";
        System.out.println(split(string));
    }


}
