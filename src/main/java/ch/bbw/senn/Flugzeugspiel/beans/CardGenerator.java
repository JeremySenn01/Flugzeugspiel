package ch.bbw.senn.Flugzeugspiel.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardGenerator {


    public List<Card> generateCards() {
        List<Card> generatedCards = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Card card = new Card();

            card.getPlanes().put(Direction.Up, generatePlane());
            card.getPlanes().put(Direction.Down, generatePlane());
            card.getPlanes().put(Direction.Left, generatePlane());
            card.getPlanes().put(Direction.Right, generatePlane());

            generatedCards.add(card);
        }
        return generatedCards;
    }

    /**
     * Generate a random plane
     * @return a new plane
     */
    private Plane generatePlane() {
        boolean isFront = new Random().nextBoolean();
        int num = new Random().nextInt(3);
        Color color;

        if (num == 0) {
            color = Color.WHITE;
        } else if (num == 1) {
            color = Color.BLACK;
        } else {
            color = Color.GREEN;
        }
        return new Plane(isFront, color);
    }

}
