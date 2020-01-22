package ch.bbw.senn.Flugzeugspiel;

import ch.bbw.senn.Flugzeugspiel.beans.Board;
import ch.bbw.senn.Flugzeugspiel.beans.Card;
import ch.bbw.senn.Flugzeugspiel.beans.Direction;
import ch.bbw.senn.Flugzeugspiel.beans.Plane;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Printer {

    /**
     * Write generated Cards to a file
     */
    public void writeCardsToFile(List<Card> generatedCards) {
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

    /**
     * Prints all Solutions to console
     *
     * @param solutions - List with boards
     */
    public void printSolutionsToConsole(List<Board> solutions) {
        for (Board board : solutions) {
            List<Card> sortedCards = board.sortFieldsByCoordinates();
            System.out.println();
            printCardRowToConsole(sortedCards.get(0), sortedCards.get(1), sortedCards.get(2));
            printCardRowToConsole(sortedCards.get(3), sortedCards.get(4), sortedCards.get(5));
            printCardRowToConsole(sortedCards.get(6), sortedCards.get(7), sortedCards.get(8));
            System.out.println();
            System.out.println("----------------------------------------------------------------------------");
        }
    }

    public String getText(Plane plane) {
        return plane.getColor().toString().toLowerCase() + " " + (plane.isFront() ? "x" : "y");
    }

    /**
     * Prints a row of 3 Cards to console
     *
     * @param first  - first card in row
     * @param second - second card in row
     * @param third  - third card in row
     */
    public void printCardRowToConsole(Card first, Card second, Card third) {
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

    /**
     * Writes a row of 3 Cards to file
     *
     * @param first  - first card in row
     * @param second - second card in row
     * @param third  - third card in row
     */
    public void writeCardRowToFile(Card first, Card second, Card third, BufferedWriter writer) {
        try {
            writer.write("  ----- " + getText(first.getPlane(Direction.Up)) + " -----       ----- " + getText(second.getPlane(Direction.Up)) + " -----       ----- " + getText(third.getPlane(Direction.Up)) + " -----\n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write(" " + getText(first.getPlane(Direction.Left)) + "        " + getText(first.getPlane(Direction.Right)) + "    " + getText(second.getPlane(Direction.Left)) + "        " + getText(second.getPlane(Direction.Right)) + "    " + getText(third.getPlane(Direction.Left)) + "        " + getText(third.getPlane(Direction.Right)) + "   \n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write("  |                  |      |                  |      |                  |\n");
            writer.write("  ----- " + getText(first.getPlane(Direction.Down)) + " -----       ----- " + getText(second.getPlane(Direction.Down)) + " -----       ----- " + getText(third.getPlane(Direction.Down)) + " -----\n");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the formatted solutions to file
     *
     * @param solutions - List with boards
     */
    public void writeSolutionsToFile(List<Board> solutions) {
        File output = new File("files/solutions.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            for (Board board : solutions) {
                List<Card> sortedCards = board.sortFieldsByCoordinates();
                writeCardRowToFile(sortedCards.get(0), sortedCards.get(1), sortedCards.get(2), writer);
                writeCardRowToFile(sortedCards.get(3), sortedCards.get(4), sortedCards.get(5), writer);
                writeCardRowToFile(sortedCards.get(6), sortedCards.get(7), sortedCards.get(8), writer);
                writer.newLine();
                writer.write("----------------------------------------------------------------------------\n");
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}