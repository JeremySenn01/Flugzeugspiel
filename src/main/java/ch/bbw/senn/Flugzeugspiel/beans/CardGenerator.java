package ch.bbw.senn.Flugzeugspiel.beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CardGenerator {

	private List<Card> generatedCards;

	public void generateCards() {
		for (int i = 0; i < 9; i++) {
			Card card = new Card();

			card.setDown(generatePlane());
			card.setUp(generatePlane());
			card.setLeft(generatePlane());
			card.setRight(generatePlane());

			generatedCards.add(card);
		}
	}

	private Plane generatePlane() {
		boolean isFront = new Random().nextBoolean();
		int num = new Random().nextInt(2);
		Color color;

		if (num == 0) {
			color = Color.RED;
		} else if (num == 1) {
			color = Color.BLUE;
		} else {
			color = Color.GREEN;
		}
		return new Plane(isFront, color);
	}

	public void writePlanes() {
		File f = new File("files/cards.txt");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));

			for (Card c : generatedCards) {
				writer.write(c.toString());
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
