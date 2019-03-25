package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Adventure_Game_Model {
	public static int UP = 0;
	public static int RIGHT = 1;
	public static int DOWN = 2;
	public static int LEFT = 3;
	private MainCharacter player;
	private Tile[][] world;
	private Object[][] topWorld;
	private Inhabitants[][] personGrid;
	private ArrayList<BufferedImage> tiles;
	private ArrayList<Inhabitants> people;
	private int GameState;
	
	public static BufferedImage CELL_FLOOR;
	public static BufferedImage CELL_WALL_UP;
	public static BufferedImage CELL_WALL_RIGHT;
	public static BufferedImage CELL_WALL_LEFT;
	public static BufferedImage CELL_WALL_DOWN;
	public static BufferedImage CELL_CORNER_1;
	public static BufferedImage CELL_CORNER_2;
	public static BufferedImage CELL_CORNER_3;
	public static BufferedImage CELL_CORNER_4;
	public static BufferedImage CELL_CORNER_5;
	public static BufferedImage CELL_CORNER_6;
	public static BufferedImage CELL_CORNER_7;
	public static BufferedImage CELL_CORNER_8;
	public static BufferedImage EMPTY;
	public static BufferedImage CLEAR;
	public static BufferedImage JAIL_BARS_VERTICAL;
	public static BufferedImage JAIL_BARS_HORIZONTAL;
	public static BufferedImage GRASS;
	public static BufferedImage CELL_ENTRANCE;
	public static BufferedImage FLOWER;
	public static BufferedImage SMALL_TREE;
	public static BufferedImage BIG_TREE_1;
	public static BufferedImage BIG_TREE_2;
	public static BufferedImage BIG_TREE_3;
	public static BufferedImage BIG_TREE_4;
	public static BufferedImage BIG_TREE_5;
	public static BufferedImage BIG_TREE_6;
	public static BufferedImage BIG_TREE_7;
	public static BufferedImage BIG_TREE_8;
	public static BufferedImage FENCE_1;
	public static BufferedImage FENCE_2;
	public static BufferedImage FENCE_3;
	public static BufferedImage FENCE_4;
	public static BufferedImage FENCE_5;
	public static BufferedImage FENCE_6;
	public static BufferedImage FENCE_7;
	public static BufferedImage FENCE_8;
	public static BufferedImage FLOOR_TILE;
	public static BufferedImage TALL_GRASS;
	public static BufferedImage CELL_ROOF;
	public static BufferedImage CELL_EXIT_1;
	public static BufferedImage CELL_EXIT_2;
	public static BufferedImage CELL_EXIT_3;
	public static BufferedImage WATER;
	public static BufferedImage WATER_1;
	public static BufferedImage WATER_2;
	public static BufferedImage WATER_3;
	public static BufferedImage WATER_4;
	public static BufferedImage WATER_5;
	public static BufferedImage WATER_6;
	public static BufferedImage WATER_7;
	public static BufferedImage WATER_8;
	public static BufferedImage DOOR;
	public static BufferedImage ROOF_1;
	public static BufferedImage ROOF_2;
	public static BufferedImage HOUSE_1;
	public static BufferedImage HOUSE_2;
	public static BufferedImage HOUSE_3;
	public static BufferedImage BOULDER_1;
	public static BufferedImage BOULDER_2;
	public static BufferedImage BOULDER_3;
	public static BufferedImage BOULDER_4;
	
	
	public Adventure_Game_Model() {
		GameState = 0;
		tiles = new ArrayList<BufferedImage>();
		people = new ArrayList<Inhabitants>();
		try {
			 EMPTY = ImageIO.read(new File("Images/Empty.png"));
			 tiles.add(EMPTY);
			 CELL_FLOOR = ImageIO.read(new File("Images/Cell_Floor.png"));
			 tiles.add(CELL_FLOOR);
			 CELL_WALL_UP = ImageIO.read(new File("Images/Cell_Wall_Up.png"));
			 tiles.add(CELL_WALL_UP);
			 CELL_WALL_RIGHT = ImageIO.read(new File("Images/Cell_Wall_Right.png"));
			 tiles.add(CELL_WALL_RIGHT);
			 CELL_WALL_DOWN = ImageIO.read(new File("Images/Cell_Wall_Down.png"));
			 tiles.add(CELL_WALL_DOWN);
			 CELL_WALL_LEFT = ImageIO.read(new File("Images/Cell_Wall_Left.png"));
			 tiles.add(CELL_WALL_LEFT);
			 CELL_CORNER_1 = ImageIO.read(new File("Images/Cell_Wall_Corner_1.png"));
			 tiles.add(CELL_CORNER_1);
			 CELL_CORNER_2 = ImageIO.read(new File("Images/Cell_Wall_Corner_2.png"));
			 tiles.add(CELL_CORNER_2);
			 CELL_CORNER_3 = ImageIO.read(new File("Images/Cell_Wall_Corner_3.png"));
			 tiles.add(CELL_CORNER_3);
			 CELL_CORNER_4 = ImageIO.read(new File("Images/Cell_Wall_Corner_4.png"));
			 tiles.add(CELL_CORNER_4);
			 CELL_CORNER_5 = ImageIO.read(new File("Images/Cell_Wall_Corner_5.png"));
			 tiles.add(CELL_CORNER_5);
			 CELL_CORNER_6 = ImageIO.read(new File("Images/Cell_Wall_Corner_6.png"));
			 tiles.add(CELL_CORNER_6);
			 CELL_CORNER_7 = ImageIO.read(new File("Images/Cell_Wall_Corner_7.png"));
			 tiles.add(CELL_CORNER_7);
			 CELL_CORNER_8 = ImageIO.read(new File("Images/Cell_Wall_Corner_8.png"));
			 tiles.add(CELL_CORNER_8);
			 CLEAR = ImageIO.read(new File("Images/Clear.gif"));
			 JAIL_BARS_HORIZONTAL = ImageIO.read(new File("Images/Cell_Gate_Horizontal.png"));
			 JAIL_BARS_VERTICAL = ImageIO.read(new File("Images/Cell_Gate_Vertical.png"));
			 CELL_ENTRANCE = ImageIO.read(new File("Images/Cell_Entrance.png"));
			 tiles.add(CELL_ENTRANCE);
			 GRASS = ImageIO.read(new File("Images/Grass.png"));
			 tiles.add(GRASS);
			 FLOWER = ImageIO.read(new File("Images/Flowers.png"));
			 tiles.add(FLOWER);
			 SMALL_TREE = ImageIO.read(new File("Images/Small_Tree.png"));
			 tiles.add(SMALL_TREE);
			 BIG_TREE_1 = ImageIO.read(new File("Images/Big_Tree_1.png"));
			 tiles.add(BIG_TREE_1);
			 BIG_TREE_2 = ImageIO.read(new File("Images/Big_Tree_2.png"));
			 tiles.add(BIG_TREE_2);
			 BIG_TREE_3 = ImageIO.read(new File("Images/Big_Tree_3.png"));
			 tiles.add(BIG_TREE_3);
			 BIG_TREE_4 = ImageIO.read(new File("Images/Big_Tree_4.png"));
			 tiles.add(BIG_TREE_4);
			 BIG_TREE_5 = ImageIO.read(new File("Images/Big_Tree_5.png"));
			 tiles.add(BIG_TREE_5);
			 BIG_TREE_6 = ImageIO.read(new File("Images/Big_Tree_6.png"));
			 tiles.add(BIG_TREE_6);
			 BIG_TREE_7 = ImageIO.read(new File("Images/Big_Tree_7.png"));
			 tiles.add(BIG_TREE_7);
			 BIG_TREE_8 = ImageIO.read(new File("Images/Big_Tree_8.png"));
			 tiles.add(BIG_TREE_8);
			 FENCE_1 = ImageIO.read(new File("Images/Fence_1.png"));
			 tiles.add(FENCE_1);
			 FENCE_2 = ImageIO.read(new File("Images/Fence_2.png"));
			 tiles.add(FENCE_2);
			 FENCE_3 = ImageIO.read(new File("Images/Fence_3.png"));
			 tiles.add(FENCE_3);
			 FENCE_4 = ImageIO.read(new File("Images/Fence_4.png"));
			 tiles.add(FENCE_4);
			 FENCE_5 = ImageIO.read(new File("Images/Fence_5.png"));
			 tiles.add(FENCE_5);
			 FENCE_6 = ImageIO.read(new File("Images/Fence_6.png"));
			 tiles.add(FENCE_6);
			 FENCE_7 = ImageIO.read(new File("Images/Fence_7.png"));
			 tiles.add(FENCE_7);
			 FENCE_8 = ImageIO.read(new File("Images/Fence_8.png"));
			 tiles.add(FENCE_8);
			 FLOOR_TILE = ImageIO.read(new File("Images/Floor_Tile.png"));
			 tiles.add(FLOOR_TILE);
			 CELL_ROOF = ImageIO.read(new File("Images/Cell_Roof.png"));
			 tiles.add(CELL_ROOF);
			 CELL_EXIT_1 = ImageIO.read(new File("Images/Cell_Exit_1.png"));
			 tiles.add(CELL_EXIT_1);
			 CELL_EXIT_2 = ImageIO.read(new File("Images/Cell_Exit_2.png"));
			 tiles.add(CELL_EXIT_2);
			 CELL_EXIT_3 = ImageIO.read(new File("Images/Cell_Exit_3.png"));
			 tiles.add(CELL_EXIT_3);
			 WATER = ImageIO.read(new File("Images/Water.png"));
			 tiles.add(WATER);
			 WATER_1 = ImageIO.read(new File("Images/Water_1.png"));
			 tiles.add(WATER_1);
			 WATER_2 = ImageIO.read(new File("Images/Water_2.png"));
			 tiles.add(WATER_2);
			 WATER_3 = ImageIO.read(new File("Images/Water_3.png"));
			 tiles.add(WATER_3);
			 WATER_4 = ImageIO.read(new File("Images/Water_4.png"));
			 tiles.add(WATER_4);
			 WATER_5 = ImageIO.read(new File("Images/Water_5.png"));
			 tiles.add(WATER_5);
			 WATER_6 = ImageIO.read(new File("Images/Water_6.png"));
			 tiles.add(WATER_6);
			 WATER_7 = ImageIO.read(new File("Images/Water_7.png"));
			 tiles.add(WATER_7);
			 WATER_8 = ImageIO.read(new File("Images/Water_8.png"));
			 tiles.add(WATER_8);
			 DOOR = ImageIO.read(new File("Images/Door.png"));
			 tiles.add(DOOR);
			 ROOF_1 = ImageIO.read(new File("Images/Roof_1.png"));
			 tiles.add(ROOF_1);
			 ROOF_2 = ImageIO.read(new File("Images/Roof_2.png"));
			 tiles.add(ROOF_2);
			 HOUSE_1 = ImageIO.read(new File("Images/House_1.png"));
			 tiles.add(HOUSE_1);
			 HOUSE_2 = ImageIO.read(new File("Images/House_2.png"));
			 tiles.add(HOUSE_2);
			 HOUSE_3 = ImageIO.read(new File("Images/House_3.png"));
			 tiles.add(HOUSE_3);
			 BOULDER_1 = ImageIO.read(new File("Images/Boulder_1.png"));
			 tiles.add(BOULDER_1);
			 BOULDER_2 = ImageIO.read(new File("Images/Boulder_2.png"));
			 tiles.add(BOULDER_2);
			 BOULDER_3 = ImageIO.read(new File("Images/Boulder_3.png"));
			 tiles.add(BOULDER_3);
			 BOULDER_4 = ImageIO.read(new File("Images/Boulder_4.png"));
			 tiles.add(BOULDER_4);
			 TALL_GRASS = ImageIO.read(new File("Images/Tall_Grass.png"));
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public boolean canWalk(int direction) {
		
		int row = player.getRow();
		int col = player.getCol();
		player.setDirection(direction);
		if(direction == Adventure_Game_Model.UP && row > 0) {
			if(getTileInFrontOfPlayer().isWalkable() && (getObjectInFrontOfPlayer() == null || !getObjectInFrontOfPlayer().isBlocking()) && getPersonInFrontOfPlayer() == null) {
				return true;
			}
		} else if(direction == Adventure_Game_Model.RIGHT && col < world[0].length - 1) {
			if(getTileInFrontOfPlayer().isWalkable() && (getObjectInFrontOfPlayer() == null || !getObjectInFrontOfPlayer().isBlocking()) && getPersonInFrontOfPlayer() == null) {
				return true;
			}
		} else if(direction == Adventure_Game_Model.DOWN && row < world.length - 1) {
			if(getTileInFrontOfPlayer().isWalkable() && (getObjectInFrontOfPlayer() == null || !getObjectInFrontOfPlayer().isBlocking()) && getPersonInFrontOfPlayer() == null) {
				return true;
			}
		} else if(direction == Adventure_Game_Model.LEFT && col > 0) {
			if(getTileInFrontOfPlayer().isWalkable() && (getObjectInFrontOfPlayer() == null || !getObjectInFrontOfPlayer().isBlocking()) && getPersonInFrontOfPlayer() == null) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * precondtion: there is a tile in front of the player; player is not at edge
	 */
	private Tile getTileInFrontOfPlayer() {
		int direction = player.getDirection();
		int row = player.getRow();
		int col = player.getCol();
		if(direction == Adventure_Game_Model.UP) {
			return world[row - 1][col];
		} else if(direction == Adventure_Game_Model.RIGHT) {
			return world[row][col + 1];
		} else if(direction == Adventure_Game_Model.DOWN) {
			return world[row + 1][col];
		} else if(direction == Adventure_Game_Model.LEFT) {
			return world[row][col - 1];
		}
		return null;
	}
	
	private Object getObjectInFrontOfPlayer() {
		int direction = player.getDirection();
		int row = player.getRow();
		int col = player.getCol();
		if(direction == Adventure_Game_Model.UP) {
			return topWorld[row - 1][col];
		} else if(direction == Adventure_Game_Model.RIGHT) {
			return topWorld[row][col + 1];
		} else if(direction == Adventure_Game_Model.DOWN) {
			return topWorld[row + 1][col];
		} else if(direction == Adventure_Game_Model.LEFT) {
			return topWorld[row][col - 1];
		}
		return null;
	}
	
	private Inhabitants getPersonInFrontOfPlayer() {
		int direction = player.getDirection();
		int row = player.getRow();
		int col = player.getCol();
		if(direction == Adventure_Game_Model.UP) {
			return personGrid[row - 1][col];
		} else if(direction == Adventure_Game_Model.RIGHT) {
			return personGrid[row][col + 1];
		} else if(direction == Adventure_Game_Model.DOWN) {
			return personGrid[row + 1][col];
		} else if(direction == Adventure_Game_Model.LEFT) {
			return personGrid[row][col - 1];
		}
		return null;
	}
	
	public boolean personInFront() {
		if(getPersonInFrontOfPlayer() == null) {
			return false;
		}
		return true;
	}
	
	public String talk() {
		Inhabitants person = getPersonInFrontOfPlayer();
		if(person != null) {
			progessStory(person);
			person.setDirection((player.getDirection() + 2)%4);
			return person.interact();
		}
		return null;
	}
	
	public void playerWalk(int dir) {
		player.walk(dir);
		int r = player.getRow();
		int c = player.getCol();
		if(world[r][c].canTeleport()) {
			player.setCol(world[r][c].teleportCol());
			player.setRow(world[r][c].teleportRow());
			player.walkForward();
		}
	}
	
	private void progessStory(Inhabitants i) {
		if(GameState == 0 && i.getName().equals("mentor")) {
			topWorld[4][6] = null;
			topWorld[5][6] = null;
			GameState++;
		} else if(GameState == 1 && i.getName().equals("old")) {
			personGrid[4][7].setDialogue("He didn't see the kidnapper? Then the only way to be set free is to find the kidnapper. Good luck Link.");
			personGrid[50][22].setDialogue("Hey kid I'm very hungry. If you can get me some food, I will give you my climbing license.");
			personGrid[35][8].setDialogue("Do you want some fish? I'd love to give you one using my manly fishing skills, but I have no worms for bait.");
			personGrid[54][18] = null;
			personGrid[58][18] = new Inhabitants(0, "You need a climbing license to continue on this path.", false, "mountainGuard");
			personGrid[58][19] = new Inhabitants(0, "The path ahead is dangerous.", false, "mountainGuard");
			GameState++;
		} else if(GameState == 2) {
			if(i.getName().equals("climber")) {
				if(player.hasItem("fish")) {
					i.setDialogue("Thanks for the food. Here's the license.");
					player.addToInventory("Climbing License");
					personGrid[58][18] = null;
					personGrid[58][19].setDialogue("Good, you have your license now. This path is dangerous so be careful.");
					GameState++;
				}
			} else if(i.getName().equals("fisher")) {
				if(player.hasItem("worms")) {
					i.setDialogue("I'll take those worms... here take this fish. It very nutritious");
					player.removeItem("worms");
					player.addToInventory("fish");
				}
			} else if(i.getName().equals("house1")) {
				if(player.hasItem("worms")) {
					i.setDialogue("I hope those worms come in handy.");
				} else {
					i.setDialogue("I have so many worms in my backyard. Why don't you take some. Ugh why am I giving you worms? I can't think straight with the news. Just take the worms.");
					player.addToInventory("worms");
					player.addToInventory("worms");
					player.addToInventory("worms");
				}
			}
			
		}
	}
	
	public void animatePeople() {
		Random r = new Random();
		for(int i = 0; i < people.size(); i++) {
			if(r.nextBoolean()) {
				people.get(i).setDirection(r.nextInt(4));
			}
		}
	}
	
	public int getPlayerRow() {
		return player.getRow();
	}
	
	public int getPlayerCol() {
		return player.getCol();
	}
	
	public int getPlayerDirection() {
		return player.getDirection();
	}
	
	public int getPlayerHealth() {
		return player.getHealth();
	}
	
	public int[] getPlayerInfo() {
		return player.getInfo();
	}
	
	/*
	 * returns the image to be displayed at a certain index
	 */
	public BufferedImage getTileImage(int r, int c) {
		if(r > 0 && r < world.length && c > 0 && c < world[0].length) {
			return world[r][c].getTileImage();
		} else {
			return EMPTY;
		}
	}
	
	public BufferedImage getObstacleImage(int r, int c) {
		if(r > 0 && r < world.length && c > 0 && c < world[0].length && topWorld[r][c] != null) {
			return topWorld[r][c].getImg();
		} else {
			return CLEAR;
		}
	}
	
	public BufferedImage getPersonImage(int r, int c) {
		if(r > 0 && r < world.length && c > 0 && c < world[0].length && personGrid[r][c] != null) {
			return personGrid[r][c].getImg();
		} else {
			return CLEAR;
		}
	}
	
	/*
	 * Reads a file to upload level data
	 */
	public void readFile(String filePath) {
		Scanner input = null;
		try {
			input = new Scanner(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		world = new Tile[input.nextInt()][input.nextInt()];
		topWorld = new Object[world.length][world[0].length];
		personGrid = new Inhabitants[world.length][world[0].length];
		int[][] img = new int[world.length][world[0].length];
		boolean[][] walk = new boolean[world.length][world[0].length];
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				img[i][j] = input.nextInt();
			}
		}
		for (int i = 0; i < walk.length; i++) {
			for (int j = 0; j < walk[0].length; j++) {
				if(input.nextInt() == 1) {
					walk[i][j] = true;
				} else {
					walk[i][j] = false;
				}
			}
		}
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				world[i][j] = new Tile(getImg(img[i][j]), walk[i][j]);
			}
		}
		player = new MainCharacter(input.nextInt(), input.nextInt(), input.nextInt());
		
		img = new int[world.length][world[0].length];
		walk = new boolean[world.length][world[0].length];
		
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				img[i][j] = input.nextInt();
			}
		}
		for (int i = 0; i < walk.length; i++) {
			for (int j = 0; j < walk[0].length; j++) {
				if(input.nextInt() == 1) {
					walk[i][j] = true;
				} else {
					walk[i][j] = false;
				}
			}
		}
				
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				topWorld[i][j] = new Object(getObjImg(img[i][j]), walk[i][j], "Obstacle");
			}
		}
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			//System.out.println(s);
			if(s.length() > 0) {
				if(s.charAt(0) != 't') {
					break;
				}
				Scanner scan = new Scanner(s);
				scan.next();
				int r1 = scan.nextInt();
				int c1 = scan.nextInt();
				int r2 = scan.nextInt();
				int c2 = scan.nextInt();
				world[r1][c1].setTeleport(r2, c2);
				world[r2][c2].setTeleport(r1, c1);
			}
		}
		
		while(input.hasNext()) {
			boolean isF = true;
			String gender = input.next().toLowerCase();
			if(gender.equals("male")) {
				isF = false;
			}
			String name = input.next();
			boolean turns = false;
			if(input.next().equals("t")) {
				turns = true;
			}
			int r = input.nextInt();
			int c = input.nextInt();
			int d = input.nextInt();
			String dia = input.nextLine();
			personGrid[r][c] = new Inhabitants(d, dia, isF, name);
			if(turns)
				people.add(personGrid[r][c]);
		}
	}
	
	private BufferedImage getImg(int imageNum) {
		return tiles.get(imageNum);
		/*switch(imageNum) {
		case 0:
			return EMPTY;
			
		case 1:
			return CELL_FLOOR;
			
		case 2:
			return CELL_WALL_UP;
			
		case 3:
			return CELL_WALL_RIGHT;
			
		case 4:
			return CELL_WALL_DOWN;
			
		case 5:
			return CELL_WALL_LEFT;
			
		case 6:
			return CELL_CORNER_1;
			
		case 7:
			return CELL_CORNER_2;
			
		case 8:
			return CELL_CORNER_3;
			
		case 9:
			return CELL_CORNER_4;
			
		case 10:
			return CELL_CORNER_5;
			
		case 11:
			return CELL_CORNER_6;
			
		case 12:
			return CELL_CORNER_7;
			
		case 13:
			return CELL_CORNER_8;
			
		case 14:
			return CELL_ENTRANCE;
			
		case 15:
			return GRASS;
			
		case 16:
			return FLOWER;
			
		case 17:
			return SMALL_TREE;
			
		case 18:
			return BIG_TREE_1;
			
		case 19:
			return BIG_TREE_2;
			
		case 20:
			return BIG_TREE_3;
			
		case 21:
			return BIG_TREE_4;
			
		case 22:
			return BIG_TREE_5;
			
		case 23:
			return BIG_TREE_6;
			
		}
		
		return EMPTY;*/
	}
	
	public BufferedImage getObjImg(int i) {
		switch(i) {
		case 1:
			return JAIL_BARS_VERTICAL;
		case 2:
			return JAIL_BARS_HORIZONTAL;
		case 3:
			return TALL_GRASS;
		}
		return null;
	}
	
	public void printWorld(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
