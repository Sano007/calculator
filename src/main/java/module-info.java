module sk.daniela.calculator {
	requires javafx.controls;
	requires javafx.fxml;
	
	
	opens sk.daniela.calculator to javafx.fxml;
	exports sk.daniela.calculator;
}