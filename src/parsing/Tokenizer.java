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

        return Token.NUMBER;
    }

    private void skipWhitespaces() {
        while (index != source.length() && source.charAt(index) == ' ') {
            index++;
        }
    }




}
