package ch.bbw.senn.Flugzeugspiel.beans;

import java.util.HashMap;

public class Card {
    private HashMap<Direction, Plane> planes;

    public Card(Plane up, Plane down, Plane left, Plane right) {
        super();
        planes = new HashMap<>();
        planes.put(Direction.Up, up);
        planes.put(Direction.Down, down);
        planes.put(Direction.Left, left);
        planes.put(Direction.Right, right);
    }

    public Card() {
        super();
        planes = new HashMap<>();
    }

    public Card copy() {
        Card newCard = new Card();
        HashMap<Direction, Plane> newPlanes = newCard.getPlanes();

        for (Direction d : planes.keySet()) {
            Plane plane = planes.get(d);
            newPlanes.put(d, plane.copy());
        }
        return newCard;
    }

    public HashMap<Direction, Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(HashMap<Direction, Plane> planes) {
        this.planes = planes;
    }

    public void rotate90DegreesClockwise() {
        Plane tempUp = planes.get(Direction.Up);
        Plane tempDown = planes.get(Direction.Down);
        Plane tempLeft = planes.get(Direction.Left);
        Plane tempRight = planes.get(Direction.Right);

        planes.put(Direction.Up, tempLeft);
        planes.put(Direction.Down, tempRight);
        planes.put(Direction.Left, tempDown);
        planes.put(Direction.Right, tempUp);
    }

    public Plane getPlane(Direction direction) {
        return planes.get(direction);
    }

    @Override
    public String toString() {
        return this.getPlane(Direction.Up).toString() + "/" + this.getPlane(Direction.Right).toString() + "/" + this.getPlane(Direction.Down).toString() + "/" + this.getPlane(Direction.Left).toString();
    }
}
