module sk.daniela.calculator {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires com.formdev.flatlaf;
	
	
	opens sk.daniela.calculator to javafx.fxml;
	exports sk.daniela.calculator;
}