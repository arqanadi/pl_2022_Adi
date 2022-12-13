package com.adi.tokenizer;

import java.util.ArrayList;
//Arqan A. Adi
//3-BSCS-2
public class LexicalAnalyzer {
    public static void main(String[] args) {
        String SrcLangTest = "this is a test 123\n"+ "\r\t 123 + - \" this is a string\"";
        ArrayList<Token> listOfTokens = new LexicalAnalyzer().tokenize(SrcLangTest);
        for (Token token : listOfTokens){
            System.out.println(token.getValue());
            System.out.println(token.getType());
        }
    }
    public TokenType nextTokenType(String input, int marker){
        char nextChar = input.charAt(marker);
        if (Character.isAlphabetic(nextChar)){
            return TokenType.IDENTIFIER;
        } else if (Character.isDigit(nextChar) || nextChar == '.') {
            return TokenType.NUMBER;
        } else if (Character.isWhitespace(nextChar)) {
            return TokenType.WHITESPACE;
        } else if (nextChar == '"'){
            return TokenType.STRING;
        } else {
            return TokenType.OPERATOR;
        }
    }
    public ArrayList<Token> tokenize(String input){
        ArrayList<Token> result = new ArrayList<Token>();
        int marker = 0;
        while (marker < input.length()){
            TokenType nextTokenType = nextTokenType(input, marker);
            if (nextTokenType == TokenType.IDENTIFIER || nextTokenType == TokenType.NUMBER){
                String tokenValue = "";
                while (nextTokenType(input, marker) == nextTokenType && marker < input.length()){
                    tokenValue += input.charAt(marker);
                    marker++;
                }
                Token newToken = new Token(tokenValue, nextTokenType);
                result.add(newToken);
            } else if (nextTokenType == TokenType.WHITESPACE) {
                while (nextTokenType(input, marker) == TokenType.WHITESPACE && marker < input.length()) {
                    marker++;
                }
            } else if (nextTokenType == TokenType.STRING){
                String tokenValue = "";
                marker++;
                while (marker < input.length() && input.charAt(marker) != '"'){
                    tokenValue += input.charAt(marker);
                    marker++;
                }
                result.add(new Token(tokenValue, nextTokenType));
            } else {
                final String[] VALID_OPERATORS = {"==",">=","<=","!=","=","+","-","/","*"};
                for (String operator : VALID_OPERATORS){
                    if (input.substring(marker).startsWith(operator)){
                        result.add(new Token(operator, TokenType.OPERATOR));
                        marker += operator.length();
                        break;
                    }
                }
            }
        }
        return result;
    }
}