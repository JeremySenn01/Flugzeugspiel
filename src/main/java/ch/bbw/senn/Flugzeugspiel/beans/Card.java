package ch.bbw.senn.Flugzeugspiel.beans;

public class Card {

	private Plane up;
	private Plane down;
	private Plane left;
	private Plane right;

	public Card(Plane up, Plane down, Plane left, Plane right) {
		super();
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	public Card() {
		
	}
	
	public void rotate90DegreesClockwise() {
		Plane tempUp = this.up;
		Plane tempDown = this.down;
		Plane tempLeft = this.left;
		Plane tempRight = this.right;
		
		this.up = tempLeft;
		this.right = tempUp;
		this.down = tempRight;
		this.left = tempDown;
	}

	public Plane getUp() {
		return up;
	}

	public void setUp(Plane up) {
		this.up = up;
	}

	public Plane getDown() {
		return down;
	}

	public void setDown(Plane down) {
		this.down = down;
	}

	public Plane getLeft() {
		return left;
	}

	public void setLeft(Plane left) {
		this.left = left;
	}

	public Plane getRight() {
		return right;
	}

	public void setRight(Plane right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return this.up + "/" + this.right + "/" + this.down + "/" + this.left; 
	}
	
}
