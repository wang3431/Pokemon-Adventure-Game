package Model;

import java.awt.image.BufferedImage;

public class Tile {
	protected BufferedImage tileImage;
	protected boolean walkable;
	protected int goToRow;
	protected int goToCol;
	protected boolean teleport;
	
	public Tile(BufferedImage img, boolean canWalk) {
		tileImage = img;
		walkable = canWalk;
		teleport = false;
		goToRow = 0;
		goToCol = 0;
	}

	public BufferedImage getTileImage() {
		return tileImage;
	}

	public void setTileImage(BufferedImage tileImage) {
		this.tileImage = tileImage;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
	
	public void setTeleport(int r, int c) {
		teleport = true;
		goToCol = c;
		goToRow = r;
	}
	
	public boolean canTeleport() {
		return teleport;
	}
	
	public int teleportRow() {
		return goToRow;
	}
	
	public int teleportCol() {
		return goToCol;
	}
	
}
