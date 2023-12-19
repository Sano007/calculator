package sk.daniela.calculator.backend;

import java.util.ArrayList;
import java.util.List;

public class Tokenization {
	
	private enum LastState {
		NULL,
		CHARACTER,
		DIGIT;
	}
	
	private static boolean isDigit(char character){
		return character >= '0' && character <= '9' ? true : false;
	}
	
	public static ArrayList<Token> getTokens(String input){
		ArrayList<Token> tokens = new ArrayList<>();
		String value = "";
		LastState lastCharacter = LastState.NULL;
		
		for (char character : input.toCharArray()){
			switch (character){
				case '+':
					if(lastCharacter != LastState.NULL){
						tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
								TokenType.NUMBER : TokenType.SQRT,
								value));
						value = "";
						lastCharacter = LastState.NULL;
					}
					tokens.add(new Token(TokenType.ADD_SUB, "+"));
					break;
				case '-':
					if(lastCharacter != LastState.NULL){
						tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
								TokenType.NUMBER : TokenType.SQRT,
								value));
						value = "";
						lastCharacter = LastState.NULL;
					}
					tokens.add(new Token(TokenType.ADD_SUB, "-"));
					break;
				case '*':
					if(lastCharacter != LastState.NULL){
						tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
								TokenType.NUMBER : TokenType.SQRT,
								value));
						value = "";
						lastCharacter = LastState.NULL;
					}
					tokens.add(new Token(TokenType.MULTIPLY, "*"));
					break;
				case '^':
					if(lastCharacter != LastState.NULL){
						tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
								TokenType.NUMBER : TokenType.SQRT,
								value));
						value = "";
						lastCharacter = LastState.NULL;
					}
					tokens.add(new Token(TokenType.SQUARE, "*"));
					break;
				case '/':
					if(lastCharacter != LastState.NULL){
						tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
								TokenType.NUMBER : TokenType.SQRT,
								value));
						value = "";
						lastCharacter = LastState.NULL;
					}
					tokens.add(new Token(TokenType.DIVISION, "/"));
					break;
				default:
					if(isDigit(character) || character == '.'){
						if(lastCharacter == LastState.CHARACTER){
							tokens.add(new Token(TokenType.SQRT, "SQRT"));
							value = "";
						}
						
						lastCharacter = LastState.DIGIT;
						value += character;
					} else {
						if(lastCharacter == LastState.DIGIT){
							tokens.add(new Token(TokenType.NUMBER, value));
							value = "";
						}
						
						lastCharacter = LastState.CHARACTER;
						value += character;
					}
			}
		}
		
		tokens.add(new Token((lastCharacter == LastState.DIGIT) ?
				TokenType.NUMBER : TokenType.SQRT,
				value));
		return tokens;
	}
}
