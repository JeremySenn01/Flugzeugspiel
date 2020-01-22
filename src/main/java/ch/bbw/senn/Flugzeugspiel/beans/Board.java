package ch.bbw.senn.Flugzeugspiel.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private HashMap<Coordinates, Card> fields;

    public Board() {
        fields = new HashMap<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                fields.put(new Coordinates(x, y), null);
            }
        }
    }

    public List<Coordinates> getEmptyFields() {
        List<Coordinates> emptyFields = new ArrayList<>();

        for (Coordinates c : fields.keySet()) {
            Card card = fields.get(c);
            if (card == null) {
                emptyFields.add(c);
            }
        }

        return emptyFields;
    }

    public Board copy() {
        Board newBoard = new Board();

        for (Coordinates c : fields.keySet()) {
            Card card = fields.get(c);

            if (card != null) {
                card = card.copy();
            }

            newBoard.getFields().put(c.copy(), card);
        }

        return newBoard;
    }

    /**
     * This method checks if the board is complete and correct
     * @return
     */
    public Boolean isValid() {
        for (Coordinates coordinates : fields.keySet()) {
            Card card = fields.get(coordinates);

            if (card != null) {
                Card topCard = fields.get(new Coordinates(coordinates.getX(), coordinates.getY() + 1));
                if (topCard != null) {
                    if (topCard.getPlane(Direction.Down).getColor() != card.getPlane(Direction.Up).getColor()
                            || topCard.getPlane(Direction.Down).isFront() == card.getPlane(Direction.Up).isFront()) {
                        return false;
                    }

                }
                Card leftCard = fields.get(new Coordinates(coordinates.getX() - 1, coordinates.getY()));
                if (leftCard != null) {
                    if (leftCard.getPlane(Direction.Right).getColor() != card.getPlane(Direction.Left).getColor()
                            || leftCard.getPlane(Direction.Right).isFront() == card.getPlane(Direction.Left).isFront()) {
                        return false;
                    }

                }
                Card rightCard = fields.get(new Coordinates(coordinates.getX() + 1, coordinates.getY()));
                if (rightCard != null) {
                    if (rightCard.getPlane(Direction.Left).getColor() != card.getPlane(Direction.Right).getColor()
                            || rightCard.getPlane(Direction.Left).isFront() == card.getPlane(Direction.Right).isFront()) {
                        return false;
                    }

                }
                Card bottomCard = fields.get(new Coordinates(coordinates.getX(), coordinates.getY() - 1));
                if (bottomCard != null) {
                    if (bottomCard.getPlane(Direction.Up).getColor() != card.getPlane(Direction.Down).getColor()
                            || bottomCard.getPlane(Direction.Up).isFront() == card.getPlane(Direction.Down).isFront()) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    /**
     * Sort Cards to prepare for displaying results
     * @return List of Cards
     */
    public List<Card> sortFieldsByCoordinates() {
        List<Card> sortedFields = new ArrayList<>();
        for (int y = 2; y >= 0; y--) {
            for (int x = 0; x < 3; x++) {
                Coordinates coords = new Coordinates(x, y);
                sortedFields.add(fields.get(coords));
            }
        }
        return sortedFields;
    }

    public HashMap<Coordinates, Card> getFields() {
        return fields;
    }

    public void setFields(HashMap<Coordinates, Card> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Board{" +
                "fields=" + fields +
                '}';
    }
}
