package sk.daniela.calculator;

import com.formdev.flatlaf.FlatLaf;

import javax.swing.*;

public class MainWindow {
	private JPanel mainPanel;
	private JButton a7Button;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton a7Button1;
	private JButton a8Button;
	private JButton a9Button;
	private JButton button12;
	private JButton a4Button;
	private JButton a5Button;
	private JButton a6Button;
	private JButton button16;
	private JButton a1Button;
	private JButton a2Button;
	private JButton a3Button;
	private JButton button20;
	private JLabel display;
	private JButton a0Button;
	private JButton button2;
	private JButton button3;
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void createUIComponents() {
		// TODO: place custom component creation code here
	}
}
