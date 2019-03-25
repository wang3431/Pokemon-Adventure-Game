package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Inhabitants extends Object{
	private int direction;
	private boolean isFemale;
	private String dialogue;
	private String name;
	BufferedImage Male_UP;
	BufferedImage Male_DOWN;
	BufferedImage Male_LEFT;
	BufferedImage Male_RIGHT;
	BufferedImage Female_UP;
	BufferedImage Female_DOWN;
	BufferedImage Female_LEFT;
	BufferedImage Female_RIGHT;
	
	public Inhabitants(int dir, String dia, boolean female, String n) {
		super(null, false, "person");
		isFemale = female;
		direction = dir;
		dialogue = dia;
		try {
			Male_UP = ImageIO.read(new File("images/Male_UP.png"));
			Male_DOWN = ImageIO.read(new File("images/Male_DOWN.png"));
			Male_LEFT = ImageIO.read(new File("images/Male_LEFT.png"));
			Male_RIGHT = ImageIO.read(new File("images/Male_RIGHT.png"));
			Female_UP = ImageIO.read(new File("images/Female_UP.png"));
			Female_DOWN = ImageIO.read(new File("images/Female_DOWN.png"));
			Female_LEFT = ImageIO.read(new File("images/Female_LEFT.png"));
			Female_RIGHT = ImageIO.read(new File("images/Female_RIGHT.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name = n;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getDialogue() {
		return dialogue;
	}

	public void setDialogue(String dialogue) {
		this.dialogue = dialogue;
	}

	@Override
	public String interact() {
		return dialogue;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public BufferedImage getImg() {
		if(isFemale) {
			if(direction == Adventure_Game_Model.UP) {
				return Female_UP;
			} else if(direction == Adventure_Game_Model.DOWN) {
				return Female_DOWN;
			} else if(direction == Adventure_Game_Model.RIGHT) {
				return Female_RIGHT;
			} else if(direction == Adventure_Game_Model.LEFT) {
				return Female_LEFT;
			}
		} else {
			if(direction == Adventure_Game_Model.UP) {
				return Male_UP;
			} else if(direction == Adventure_Game_Model.DOWN) {
				return Male_DOWN;
			} else if(direction == Adventure_Game_Model.RIGHT) {
				return Male_RIGHT;
			} else if(direction == Adventure_Game_Model.LEFT) {
				return Male_LEFT;
			}
		}
		return null;
	}
	
}
