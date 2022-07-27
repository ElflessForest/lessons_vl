package parsing;

public class Tokenizer {

    private String source;
    private int index = 0;
    private Token currentToken = Token.NONE;
    private String currentTokenValue = null;
    
    public Tokenizer(String source) {
        this.source = source;
    }

    public String getTokenValue() {
	return currentTokenValue;
    }
    
    // есть ли следующий токен
    public boolean hasNext() {

	    if (currentToken != Token.NONE) {
	        return true;
	    }
	
	    skipWhitespaces();

        if (index == source.length()) {
	        currentToken = Token.NONE;
            return false;
        }

        char ch = source.charAt(index);

	    if (ch == '(') {
	        currentToken = Token.LEFT_PR;
	        index++;
	        return true;
	    }

        if (ch == ')') {
            currentToken = Token.RIGHT_PR;
            index++;
            return true;
        }

        if (ch == '+') {
            currentToken = Token.PLUS;
            index++;
            return true;
        }

        if (ch == '-') {
            currentToken = Token.MINUS;
            index++;
            return true;
        }

        if (ch == '/') {
            currentToken = Token.DIV;
            index++;
            return true;
        }

        if (ch == '*') {
            currentToken = Token.MUL;
            index++;
            return true;
        }
	
	    String num = "";

        while (index != source.length() && '0' <= source.charAt(index) && source.charAt(index) <= '9') {
            num += source.charAt(index);
            index++;
        }

        if (!num.equals("")) {
	        currentTokenValue = num;
	        currentToken = Token.NUMBER;
            return true;
        }

        currentToken = Token.NONE;
        return false;
    }

    // следующий токен
    public Token nextToken() {
	    hasNext();
	    Token token = currentToken;
	    currentToken = Token.NONE;

	    return token;
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
	        Token token = tokenizer.nextToken();
	        if (token == Token.NUMBER) {
		        System.out.print(token + "(" + tokenizer.getTokenValue() + ") ");
	        } else {
		        System.out.print(token + " ");
	        }
        }
    }
}
