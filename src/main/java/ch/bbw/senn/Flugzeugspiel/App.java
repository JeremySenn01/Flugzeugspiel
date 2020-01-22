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
        writeSolutionsToFile(solutions);
        printSolutionsToConsole(solutions);

        System.out.println("solutions = " + solutions.size());
    }

    public static void printSolutionsToConsole(List<Board> solutions) {
//        for (Board board : solutions) {
            List<Card> sortedCards = solutions.get(0).sortFieldsByCoordinates();
            printCardRow(sortedCards.get(0), sortedCards.get(1), sortedCards.get(2));
            printCardRow(sortedCards.get(3), sortedCards.get(4), sortedCards.get(5));
            printCardRow(sortedCards.get(6), sortedCards.get(7), sortedCards.get(8));
//        }
    }

    public static String getText(Plane plane) {
        return plane.getColor().toString().toLowerCase() + " " + (plane.isFront() ? "x" : "y");
    }

    public static void printCardRow(Card first, Card second, Card third) {
        System.out.format("  ----- %s -----       ----- %s -----       ----- %s -----\n", getText(first.getPlane(Direction.Up)), getText(second.getPlane(Direction.Up)), getText(third.getPlane(Direction.Up)));
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.format(" %s        %s    %s        %s    %s        %s   \n", getText(first.getPlane(Direction.Left)), getText(first.getPlane(Direction.Right)), getText(second.getPlane(Direction.Left)), getText(second.getPlane(Direction.Right)), getText(third.getPlane(Direction.Left)), getText(third.getPlane(Direction.Right)));
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.println("  |                  |      |                  |      |                  |");
        System.out.format("  ----- %s -----       ----- %s -----       ----- %s -----\n", getText(first.getPlane(Direction.Down)), getText(second.getPlane(Direction.Down)), getText(third.getPlane(Direction.Down)));
        System.out.println();

    }

    public static void writeSolutionsToFile(List<Board> solutions) {
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
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
