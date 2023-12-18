package sk.daniela.calculator.backend;

import java.util.ArrayList;
import java.util.List;

public class Calculate {

	public static double start(ArrayList<Token> tokens){
		double output = multiply(tokens);
		if(!tokens.isEmpty()) {
			Token token = tokens.get(0);
			tokens.remove(0);
			if (token.getType() == TokenType.ADD_SUB) {
				if (token.getValue().equals("+"))
					output += multiply(tokens);
				else
					output -= multiply(tokens);
			}
		}
		
		
		return output;
	}
	
	private static double multiply(List<Token> tokens) {
		double output = divide(tokens);
		
		if (!tokens.isEmpty()) {
			Token token = tokens.get(0);
			if (token.getType() == TokenType.MULTIPLY) {
				tokens.remove(0);
				output *= sqrtc(tokens);
			}
		}
		
		return output;
	}
	
	private static double divide(List<Token> tokens) {
		double output = sqrtc(tokens);
		if (!tokens.isEmpty()) {
			Token token = tokens.get(0);
			if (token.getType() == TokenType.DIVISION) {
				tokens.remove(0);
				output /= sqrtc(tokens);
			}
		}
		
		return output;
	}
	
	private static double sqrtc(List<Token> tokens) {
		Token token = tokens.get(0);
		double output = 0.;
		if(token.getType() == TokenType.SQRT) {
			tokens.remove(0);
			output = Math.sqrt(square(tokens));
		} else
			output = square(tokens);
		
		return output;
	}
	
	private static double square(List<Token> tokens) {
		double output = numbers(tokens);
		if (!tokens.isEmpty()){
			Token token = tokens.get(0);
			if(token.getType() == TokenType.SQUARE) {
				tokens.remove(0);
				output = Math.pow(output, numbers(tokens));
			}
		}
		
		return output;
	}
	
	private static double numbers(List<Token> tokens) {
		Token token = tokens.get(0);
		tokens.remove(0);
		
		double output = 0.;
		if(token.getType() == TokenType.ADD_SUB)
			output = - numbers(tokens);
		else
			output = number(token.getValue());
		
		return output;
	}
	
	private static double number(String input){
		if(input.contains(".")) {
			var numbers = input.split("\\.");
			var afterDot = number(numbers[1]);
			
			for (int i = 0; i < numbers[1].length(); i++)
				afterDot /= 10;
			return number(numbers[0]) + afterDot;
		}
		double output = 0;
		for (char character : input.toCharArray()){
			output = (output * 10) + (character - '0');
		}
		return output;
	}
}
