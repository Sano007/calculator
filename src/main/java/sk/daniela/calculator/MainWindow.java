package sk.daniela.calculator;

import com.formdev.flatlaf.FlatLaf;
import sk.daniela.calculator.backend.Calculate;
import sk.daniela.calculator.backend.Tokenization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
	private JPanel mainPanel;
	private JButton aACButton;
	private JButton cButton;
	private JButton SQRTButton;
	private JButton aDIVIDEButton;
	private JButton a7Button;
	private JButton a8Button;
	private JButton a9Button;
	private JButton aMULTIPLYButton;
	private JButton a4Button;
	private JButton a5Button;
	private JButton a6Button;
	private JButton aMINUSButton;
	private JButton a1Button;
	private JButton a2Button;
	private JButton a3Button;
	private JButton aPLUSButton;
	private JLabel display;
	private JButton a0Button;
	private JButton aDotButton;
	private JButton aCalcButton;
	private JButton xButton;

	public MainWindow() {
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		// Numbers
		{
			aDotButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '.');
				}
			});
			a1Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '1');
				}
			});
			a2Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '2');
				}
			});
			a3Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '3');
				}
			});
			a4Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '4');
				}
			});
			a5Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '5');
				}
			});
			a6Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '6');
				}
			});
			a7Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '7');
				}
			});
			a8Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '8');
				}
			});
			a9Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '9');
				}
			});
			a0Button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '0');
				}
			});
		}
		// Operators
		{
			aPLUSButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '+');
				}
			});
			aMINUSButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '-');
				}
			});
			aMULTIPLYButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '*');
				}
			});
			aDIVIDEButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '/');
				}
			});
			xButton.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + '^');
				}
			});
			SQRTButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText(display.getText() + "SQRT");
				}
			});
		}
		// Functions
		{
			aACButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					display.setText("");
				}
			});
			cButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!display.getText().isEmpty() && !display.getText().isBlank()){
						if (display.getText().endsWith("SQRT"))
							display.setText(display.getText().substring(0, display.getText().length() - 4));
						else
							display.setText(display.getText().substring(0, display.getText().length() - 1));
					}
				}
			});
			aCalcButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!display.getText().isEmpty() && !display.getText().isBlank())
						display.setText(new String().formatted(Calculate.start(Tokenization.getTokens(display.getText()))));
				}
			});
		}
	}

	public static void main(String[] args) {
		try {
			// Set the Look and Feel to the system default
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName().contains("Dark") ?
//					"com.formdev.flatlaf.FlatDarculaLaf" :
//					"com.formdev.flatlaf.FlatIntelliJLaf");
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		FlatLaf.setUseNativeWindowDecorations(false);
		
		JFrame frame = new JFrame("Code Reviewer");
		try {
			frame.setContentPane(new MainWindow().mainPanel);
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createUIComponents() {
		// TODO: place custom component creation code here
	}
}
