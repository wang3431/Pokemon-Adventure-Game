package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Controller.Adventure_Game_Controller;

public class Adventure_Game_View {
	
	JFrame frame;
	gamePanel panel;
	JMenuItem save;
	JMenuItem load;
	JMenuItem exit;
	JMenuItem howToPlay;
	JMenuItem about;
	JTextArea dialogue;
	Timer timer;
	Adventure_Game_Controller gameControl;
	BufferedImage Character_UP;
	BufferedImage Character_DOWN;
	BufferedImage Character_LEFT;
	BufferedImage Character_RIGHT;
	public boolean inConvo = false;
	
	public Adventure_Game_View(Adventure_Game_Controller controller){
		gameControl = controller;
		try {
			Character_UP = ImageIO.read(new File("Images/Character_UP.png"));
			Character_DOWN = ImageIO.read(new File("Images/Character_DOWN.png"));
			Character_LEFT = ImageIO.read(new File("Images/Character_LEFT.png"));
			Character_RIGHT = ImageIO.read(new File("Images/Character_RIGHT.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame = new JFrame("Adventure Game");
		frame.setBounds(100, 100, 410, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new gamePanel();
		panel.setBounds(5, 5, 400, 400);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu options = new JMenu("Options");
		menuBar.add(options);
		
		JMenu game = new JMenu("Game");
		menuBar.add(game);
		
		howToPlay = new JMenuItem("How To Play");
		game.add(howToPlay);
		
		about = new JMenuItem("About");
		game.add(about);
		
		save = new JMenuItem("Save");
		options.add(save);
		
		load = new JMenuItem("Load");
		options.add(load);
		
		exit = new JMenuItem("Exit");
		options.add(exit);
		
		frame.setLayout(null);
		frame.add(panel);
		frame.setVisible(true);
		
		dialogue = new JTextArea();
		dialogue.setBounds(5,415,400,110);
		Font font = new Font("Courier", Font.BOLD,15);
		dialogue.setFont(font);
		dialogue.setEditable(false);
		dialogue.setWrapStyleWord(true);
		dialogue.setLineWrap(true);
		frame.add(dialogue);
		frame.requestFocus();
	}
	
	public void displayDialogue(String s){
		dialogue.setText(s);
		timer = new Timer(4000, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dialogue.setText("");
				timer.stop();
				inConvo = false;
			}
		});
		timer.start();
		inConvo = true;
	}
	
	public void updateBoard(){
		panel.repaint();
	}
	
	public JTextArea getDialogueBox() {
		return dialogue;
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public void addButtonListeners(ActionListener a){
		save.addActionListener(a);
		load.addActionListener(a);
		exit.addActionListener(a);
		howToPlay.addActionListener(a);
		about.addActionListener(a);
	}
	
	public void addKeyListeners(KeyListener k){
		frame.addKeyListener(k);
	}
	
	public void addMouseListeners(MouseListener m){
		frame.addMouseListener(m);
		dialogue.addMouseListener(m);
	}
	
	private class gamePanel extends JPanel{
		public void paintComponent(Graphics g) {
			int gridSpace = panel.getWidth()/10;
			int y = 0, x = 0;
			for(int row=gameControl.playerRow() - 5; row <= gameControl.playerRow() + 4; row++){
				for (int col=gameControl.playerCol() - 5; col<=gameControl.playerCol() + 4; col++){
					g.drawImage(gameControl.getTileImage(row, col), x*gridSpace, y*gridSpace, gridSpace, gridSpace, null);
					g.drawImage(gameControl.getNPCImage(row, col), x*gridSpace, y*gridSpace, gridSpace, gridSpace, null);
					g.drawImage(gameControl.getObstacleImage(row, col), x*gridSpace, y*gridSpace, gridSpace, gridSpace, null);
					x++;
				}
				y++;
				x=0;
			}
			if(gameControl.getDirection() == 0){
				g.drawImage(Character_UP, 5*gridSpace, 5*gridSpace, gridSpace, gridSpace, null);
			}else if(gameControl.getDirection() == 1){
				g.drawImage(Character_RIGHT, 5*gridSpace, 5*gridSpace, gridSpace, gridSpace, null);
			}else if(gameControl.getDirection() == 2){
				g.drawImage(Character_DOWN, 5*gridSpace, 5*gridSpace, gridSpace, gridSpace, null);
			}else if(gameControl.getDirection() == 3){
				g.drawImage(Character_LEFT, 5*gridSpace, 5*gridSpace, gridSpace, gridSpace, null);
			}
		}
	}
}