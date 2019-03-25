package Model;

import java.awt.image.BufferedImage;

public class Object {
	private boolean blocks;
	private BufferedImage img;
	private String name;
	
	public Object(BufferedImage i, boolean blocking, String n) {
		blocks = blocking;
		img = i;
		name = n;
	}

	public boolean isBlocking() {
		return blocks;
	}

	public void setBlocking(boolean blocks) {
		this.blocks = blocks;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}
	
	public String interact() {
		return null;
	}
	
	public String getName() {
		return name;
	}
	
	
}
