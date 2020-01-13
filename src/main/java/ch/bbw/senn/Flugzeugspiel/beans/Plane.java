package ch.bbw.senn.Flugzeugspiel.beans;

public class Plane {

	private boolean isFront;
	private Color color;

	public Plane(boolean isFront, Color color) {
		this.isFront = isFront;
		this.color = color;
	}

	public boolean isFront() {
		return isFront;
	}

	public void setFront(boolean isFront) {
		this.isFront = isFront;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.isFront) + "," + String.valueOf(this.color);
	}

}
