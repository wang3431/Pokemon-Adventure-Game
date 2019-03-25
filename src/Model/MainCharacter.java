package Model;

import java.util.ArrayList;

public class MainCharacter extends Person {
	private int health;
	private ArrayList<String> inventory;
	
	public MainCharacter(int r, int c, int d) {
		super(r, c, d);
		health = 0;
		inventory = new ArrayList<String>();
	}
	
	public void walk(int d) {
		direction = d;
		walkForward();
	}
	
	public void loseHealth(int loss) {
		health -= loss;
	}
	
	public void gainHealth(int gain) {
		health += gain;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void walkForward() {
		if(direction == Adventure_Game_Model.UP) {
			row--;
		} else if(direction == Adventure_Game_Model.RIGHT) {
			col++;
		} else if(direction == Adventure_Game_Model.DOWN) {
			row++;
		} else if(direction == Adventure_Game_Model.LEFT) {
			col--;
		}
	}
	
	public int[] getInfo() {
		int[] ret = new int[4];
		ret[0] = row;
		ret[1] = col;
		ret[2] = direction;
		ret[3] = health;
		return ret;
	}
	
	public ArrayList<String> getInventory() {
		return inventory;
	}
	
	public void addToInventory(String str) {
		inventory.add(str);
	}
	
	public boolean hasItem(String str) {
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	public void removeItem(String str) {
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i).equals(str)) {
				inventory.remove(i);
				break;
			}
		}
	}
	
}
