package ngg;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TheGame {
	
	JFrame frame = new JFrame();
	JPanel directionPanel = new JPanel();
	JLabel directions = new JLabel();
	JPanel guessingPanel = new JPanel();
	JTextField guesser = new JTextField(10);
	JLabel guessLabel = new JLabel();
	JButton submitGuess = new JButton("Submit");
	JLabel historyLabel = new JLabel("<html>History of attempts: <br>");
	JPanel historyPanel = new JPanel();
	JButton restartButton = new JButton("Restart");
	
	int chosenNumber = (int)(Math.random()*100) + 1;
	
	
	public TheGame() {
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setTitle("Number Guessing Game");
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		directions.setBackground(Color.white);
		directions.setForeground(Color.black);
		directions.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		directions.setHorizontalAlignment(JLabel.CENTER);
		directions.setText("The program picked a number between 1 and 100. Try to guess it.");
		directions.setOpaque(true);
		directionPanel.setLayout(new BorderLayout());
		directionPanel.add(directions, BorderLayout.PAGE_START);
		frame.add(directionPanel, BorderLayout.NORTH);
		
		guessLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		guessLabel.setForeground(Color.black);
		guessLabel.setBackground(Color.white);
		guessLabel.setText("Type your number here: ");
		guessLabel.setHorizontalAlignment(JLabel.CENTER);
		
		guesser.setBackground(Color.white);
		guesser.setForeground(Color.black);
		guesser.setFont(new Font("Calibri", Font.PLAIN, 20));
		guesser.setLayout(new FlowLayout());
		guessingPanel.add(guessLabel);
		guessingPanel.add(guesser);
		
		historyLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		historyLabel.setForeground(Color.black);
		historyLabel.setBackground(Color.white);
		historyPanel.add(historyLabel);
		
		restartButton.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		restartButton.setBackground(Color.lightGray);
		restartButton.setForeground(Color.black);
		restartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				historyLabel.setText("<html>History of attempts: <br>");
				chosenNumber = (int)(Math.random()*100) + 1;
				guesser.setText("");
				
			}
			
		});
		
		submitGuess.setBackground(Color.lightGray);
		submitGuess.setForeground(Color.black);
		submitGuess.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		submitGuess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String s = guesser.getText();
				int n;
				 try {
	                    n = Integer.parseInt(s);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
	                    return;
	                }
				
				String s1 = historyLabel.getText();
				String s2 = "";
				
				if (n == chosenNumber) {
					s2 = String.format("Congratulations! The correct number is %d <br></html>", n);
				}
				else if (n < chosenNumber) {
					s2 = String.format("Attempted number %d is too low<br>", n);
				}
				else s2 = String.format("Attempted number %d is too high<br>", n);
				
				historyLabel.setText(s1 + s2);
				guesser.setText("");
				
			}
			
		});
		guessingPanel.add(submitGuess);
		historyPanel.add(historyLabel);
		guessingPanel.add(restartButton);
		frame.add(guessingPanel, BorderLayout.SOUTH);
		frame.add(historyPanel, BorderLayout.CENTER);
	}


	public static void main(String[] args) {
		new TheGame();
	}

}
