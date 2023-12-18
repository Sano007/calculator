package sk.daniela.calculator.backend;

import java.util.ArrayList;
import java.util.List;

public class Tokenization {
	
	public static List<Token> getTokens(String input){
		ArrayList<Token> tokens = new ArrayList<>();
		String value = "";
		
		for (char character : input.toCharArray()){
			switch (character){
				case '+':
					tokens.add(new Token(TokenType.ADD_SUB, "+"));
					break;
				case '-':
					tokens.add(new Token(TokenType.ADD_SUB, "-"));
					break;
				case '*':
					tokens.add(new Token(TokenType.MULTIPLY, "*"));
					break;
				case '/':
					tokens.add(new Token(TokenType.DIVISION, "/"));
					break;
				default:
					if(character != ' ')
						value += character;
					else {
						if(value.equals("SQRT"))
							tokens.add(new Token(TokenType.SQRT, "SQRT"));
						else {
							tokens.add(new Token(TokenType.NUMBER, value));
							value = "";
						}
					}
			}
		}
		return tokens;
	}
}
