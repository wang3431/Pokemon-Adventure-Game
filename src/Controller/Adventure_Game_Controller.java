package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import Model.Adventure_Game_Model;
import View.Adventure_Game_View;


public class Adventure_Game_Controller {
	Adventure_Game_Model model;
	Adventure_Game_View view;
	public Adventure_Game_Controller(){
		model = new Adventure_Game_Model();
		model.readFile("Level1.txt");
		view = new Adventure_Game_View(this);
		view.addButtonListeners(new MenuListener());
		view.addKeyListeners(new CustomKey());
		view.addMouseListeners(new MouseClickListener());
		javax.swing.Timer NPCMove = new javax.swing.Timer(2500, new ActionListener() {
			public void actionPerformed(ActionEvent e){
				model.animatePeople();
				view.updateBoard();
			}
		});
		NPCMove.start();
	}
	
	public BufferedImage getTileImage(int row, int col){
		return model.getTileImage(row, col);
	}
	public BufferedImage getNPCImage(int row, int col){
		return model.getPersonImage(row, col);
	}
	public BufferedImage getObstacleImage(int row, int col){
		return model.getObstacleImage(row, col);
	}
	
	public int playerRow(){
		return model.getPlayerRow();
	}
	public int playerCol(){
		return model.getPlayerCol();
	}
	public int getDirection(){
		return model.getPlayerDirection();
	}
	
	private void animateVillagers() {
		model.animatePeople();
	}
	
	
	class MouseClickListener extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
				view.getFrame().requestFocus();
			}
		}
		public void mouseReleased(MouseEvent e){
			if(e.getModifiersEx()==MouseEvent.BUTTON1_DOWN_MASK){
				view.getFrame().requestFocus();
			}
			view.getFrame().requestFocus();
		}
	}
	
	class MenuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Save")){
				
			}else if(e.getActionCommand().equals("Load")){
				
			}else if(e.getActionCommand().equals("Exit")){
				
			}else if(e.getActionCommand().equals("How To Play")){
				JEditorPane htp = null;
				try {
					htp = new JEditorPane(new URL("file:how to play.html"));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JScrollPane htpPane = new JScrollPane(htp);
				JOptionPane.showMessageDialog(null, htpPane, "How To Play", JOptionPane.PLAIN_MESSAGE, null);
			}
		}
	}
	class CustomKey implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_UP){
				if(model.canWalk(Adventure_Game_Model.UP)){
					model.playerWalk(Adventure_Game_Model.UP);
				}
				view.updateBoard();
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN){
				if(model.canWalk(Adventure_Game_Model.DOWN)){
					model.playerWalk(Adventure_Game_Model.DOWN);
				}
				view.updateBoard();
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT){
				if(model.canWalk(Adventure_Game_Model.LEFT)){
					model.playerWalk(Adventure_Game_Model.LEFT);
				}
				view.updateBoard();
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				if(model.canWalk(Adventure_Game_Model.RIGHT)){
					model.playerWalk(Adventure_Game_Model.RIGHT);
				}
				view.updateBoard();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_E){
				if(model.personInFront()){
					String dialogue = model.talk();
					view.updateBoard();
					if(dialogue != null){
						if(!view.inConvo){
							view.displayDialogue(dialogue);
						}
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
}
