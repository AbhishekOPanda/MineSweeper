package com.maincode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class Minesweeper extends JFrame {

	private JLabel statusbar;
	static JFrame window;
	static JFrame frame = new JFrame("NEW GAME"); 

	static JLabel counterLabel;
	static Timer timer;
	static int second;
	static int minute;
	static String ddSecond;
	static String ddMinute;
	static DecimalFormat dFormat = new DecimalFormat("00");	
	static JLabel time;
	static JButton home = new JButton("HOME");

	public Minesweeper() {

		initUI();
	}

	public void initUI() {
		
			statusbar = new JLabel("Time");
			add(statusbar, BorderLayout.SOUTH);
			add(home,BorderLayout.EAST);

			add(new Board(statusbar, time));
			//add(new Board(time));
				
			setResizable(false);
			pack();

			setTitle("Minesweeper");
			setLocationRelativeTo(null);
			
			home.setBounds (10, 0, 300, 70);
			
			home.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent arg0) { 
					frame.setVisible(true);
				}});

	}

	public static void normalTimer() {

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				second++;

				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				counterLabel.setText(ddMinute + ":" + ddSecond);

				if (second == 60) {
					second = 0;
					minute++;

					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
			}
		});
	}	

	public static void main(String[] args) {
		window = new JFrame();
		window.setSize(200, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);

		counterLabel = new JLabel("TIMER");
		counterLabel.setBounds(8, 10, 200, 100);
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		// counterLabel.setFont(font1);

		window.add(counterLabel);
		window.setVisible(true);
		
		JButton easy = new JButton("Easy");
		easy.setBounds (10, 0, 300, 70);
		
		easy.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) { 
				EventQueue.invokeLater(() -> {
					Board.N_MINES = 10;
					Board.N_ROWS = 10;
					Board.N_COLS = 10;
					Board.BOARD_WIDTH = 10 * 15 + 1;
					Board.BOARD_HEIGHT = 10 * 15 + 1;
					var ex = new Minesweeper();
					counterLabel.setText("00:00");
					second = 0;
					minute = 0;
					normalTimer();
					timer.start();
					ex.setVisible(true);
				});
				frame.dispose();
			}});
		JButton medium = new JButton("Medium");
		medium.setBounds (10, 70, 300, 70);
		medium.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg1) {
				EventQueue.invokeLater(() -> {
					Board.N_MINES = 40;
					Board.N_ROWS = 15;
					Board.N_COLS = 15;
					Board.BOARD_WIDTH = 15 * 15 + 1;
					Board.BOARD_HEIGHT = 15 * 15 + 1;
					var ex = new Minesweeper();
					counterLabel.setText("00:00");
					second = 0;
					minute = 0;
					normalTimer();
					timer.start();
					ex.setVisible(true);
				});
				frame.dispose();
			}});

		JButton hard = new JButton("Hard");
		hard.setBounds (10, 140, 300, 70);
		hard.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg1) {
				EventQueue.invokeLater(() -> {
					Board.N_MINES = 100;
					Board.N_ROWS = 20;
					Board.N_COLS = 20;
					Board.BOARD_WIDTH = 20 * 15 + 1;
					Board.BOARD_HEIGHT = 20 * 15 + 1;
					var ex = new Minesweeper();
					counterLabel.setText("00:00");
					second = 0;
					minute = 0;
					normalTimer();
					timer.start();
					ex.setVisible(true);
				});
			frame.dispose();
			}});
		frame.setBounds (100,100,335,255);
		frame.getLayeredPane().setLayout(null);
		frame.getLayeredPane().add(easy); 
		frame.getLayeredPane().add(medium);
		frame.getLayeredPane().add(hard); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	
}
