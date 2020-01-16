package ch.bbw.senn.Flugzeugspiel.beans;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardReader {

    public List<Card> readCards() {
        List<Card> generatedCards = new ArrayList<>();
        File input = new File("files/cards.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(input));

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (!line.isEmpty()) {
                    generatedCards.add(this.generateCard(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generatedCards;
    }

    private Card generateCard(String line) {
        Card card = new Card();
        String[] planeString = line.split("/");
        card.getPlanes().put(Direction.Up, new Plane(Boolean.parseBoolean(planeString[0].split(",")[0]), Color.valueOf(planeString[0].split(",")[1])));
        card.getPlanes().put(Direction.Right, new Plane(Boolean.parseBoolean(planeString[1].split(",")[0]), Color.valueOf(planeString[1].split(",")[1])));
        card.getPlanes().put(Direction.Down, new Plane(Boolean.parseBoolean(planeString[2].split(",")[0]), Color.valueOf(planeString[2].split(",")[1])));
        card.getPlanes().put(Direction.Left, new Plane(Boolean.parseBoolean(planeString[3].split(",")[0]), Color.valueOf(planeString[3].split(",")[1])));
        return card;
    }
}
