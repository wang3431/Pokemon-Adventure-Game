package Model;


public class Person {
	protected int row;
	protected int col;
	protected int direction;
	
	public Person(int r, int c, int d) {
		row = r;
		col = c;
		direction = d;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	
	
}
