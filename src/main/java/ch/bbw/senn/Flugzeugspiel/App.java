package ch.bbw.senn.Flugzeugspiel;

import ch.bbw.senn.Flugzeugspiel.beans.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Create CardGenerator
        CardGenerator generator = new CardGenerator();
        //Generate 9 cards
        generator.generateCards();
        //Write Planes to Text-File
        generator.writePlanes();
        //Create CardReader
        CardReader reader = new CardReader();
        //Read cards from Created File
        List<Card> cards = reader.readCards();
        //Calculate solutions
        List<Board> solutions = SolutionCalculator.findAllSolutions(new Board(), cards);
        printSolutions(solutions);

        System.out.println("solutions = " + solutions.size());
    }

    public static void printSolutions(List<Board> solutions) {
        File output = new File("files/solutions.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            for (Board board : solutions) {
                List<Card> sortedCardsByCoordinates = board.sortFieldsByCoordinates();
                for (Card card : sortedCardsByCoordinates) {
                    writer.write(card.toString());
                    writer.newLine();
                }
                writer.write("------------");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
