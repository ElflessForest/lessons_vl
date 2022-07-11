package parsing;

import java.util.Scanner;

public class ArithmeticParsing {

    private static int evaluate(String raw) {
        String word = "";
        int sum = 0;
        for (int i = 0; i < raw.length(); i++) {
            char ch = raw.charAt(i);
            if (ch >= '0' && ch <= '9' || ch == '-') {
                word += ch;
            } else if (!word.isEmpty() && !word.equals("-")){
                sum += Integer.parseInt(word);
                word = "";
            }

        }
        if (!word.isEmpty() && !word.equals("-")) {
            sum += Integer.parseInt(word);
            word = "";

        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String raw = scan.nextLine();
        System.out.println(evaluate(raw));
    }
}
