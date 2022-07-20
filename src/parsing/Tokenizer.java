package parsing;

public class Tokenizer {

    private String source;
    private int index = 0;

    public Tokenizer(String source) {
        this.source = source;
    }

    // есть ли следующий токен
    public boolean hasNext() {
        skipWhitespaces();

        if (index == source.length()) {
            return false;
        }

        char ch = source.charAt(index);

        if (ch == '(' || ch == ')' || ch == '+' || ch == '-' || ch == '/' || ch == '*') {
            return true;
        }

        String num = "";

        int j = index;

        while (j != source.length() && '0' <= source.charAt(j) && source.charAt(j) <= '9') {
            num += source.charAt(j);
            j++;
        }

        if (!num.equals("")) {
            return true;
        }

        return false;
    }

    // следующий токен
    public Token nextToken() {
        if (hasNext()) {
            char ch = source.charAt(index);
            if (ch == '(') {
                index++;
                return Token.LEFT_PR;
            }
            if (ch == ')') {
                index++;
                return Token.RIGHT_PR;
            }
            if (ch == '+') {
                index++;
                return Token.PLUS;
            }
            if (ch == '-') {
                index++;
                return Token.MINUS;
            }
            if (ch == '*') {
                index++;
                return Token.MUL;
            }
            if (ch == '/') {
                index++;
                return Token.DIV;
            }
            while(index != source.length() && '0' <= source.charAt(index) && source.charAt(index) <= '9') {
                index++;
            }
            return Token.NUMBER;
        }
        return Token.NONE;
    }

    private void skipWhitespaces() {
        while (index != source.length() && source.charAt(index) == ' ') {
            index++;
        }
    }

    public static void main(String[] args) {
        String raw = "1 + 2 + 3 () + 2 - 1";
        Tokenizer tokenizer = new Tokenizer(raw);
        while (tokenizer.hasNext()) {
            System.out.print(tokenizer.nextToken() + " ");
        }
    }


}
