package sk.daniela.calculator.backend;

import java.util.ArrayList;
import java.util.List;

public class Calculate {

	public static double start(List<Token> tokens){
		double output = multiply(tokens);
		Token token = tokens.get(0);
		tokens.remove(0);
		if(token.getType() == TokenType.ADD_SUB) {
			if (token.getValue().equals("+"))
				output += multiply(tokens);
			else
				output -= multiply(tokens);
		}
		
		
		return output;
	}
	
	private static double multiply(List<Token> tokens) {
		double output = divide(tokens);
		
		return output;
	}
	
	private static double divide(List<Token> tokens) {
		double output = sqrtc(tokens);
		
		return output;
	}
	
	private static double sqrtc(List<Token> tokens) {
		double output = square(tokens);
		
		return output;
	}
	
	private static double square(List<Token> tokens) {
		double output = number(tokens);
		
		return output;
	}
	
	private static double number(List<Token> tokens) {
		Token token = tokens.get(0);
		tokens.remove(0);
		
		double output = 0.;
		if(token.getType() == TokenType.NEGATIVE)
			output = - number(tokens);
		else
			output = number(token.getValue());
		
		return output;
	}
	
	public static double number(String input){
		if(input.contains(".")) {
			var numbers = input.split("\\.");
			var afterDot = number(numbers[1]);
			while ((afterDot % 10) != 0)
				afterDot /= 10;
			return number(numbers[0]) + afterDot;
		}
		long output = 0;
		for (char character : input.toCharArray()){
			output = (output * 10) + (character - '0');
		}
		return (double) output;
	}
}
