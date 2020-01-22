package ch.bbw.senn.Flugzeugspiel;

import ch.bbw.senn.Flugzeugspiel.beans.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Printer printer = new Printer();
        CardGenerator generator = new CardGenerator();

        //Generate 9 cards
        List<Card> generatedCards = generator.generateCards();
        //Write Planes to Text-File
        printer.writeCardsToFile(generatedCards);
        //Create CardReader
        CardReader reader = new CardReader();
        //Read cards from Created File
        List<Card> cards = reader.readCards();
        //Calculate solutions
        List<Board> solutions = SolutionCalculator.findAllSolutions(new Board(), cards);

        if (solutions.size() > 0) {
            //Print
            printer.writeSolutionsToFile(solutions);
            printer.printSolutionsToConsole(solutions);
            System.out.println("found " + solutions.size() + " solutions");
        } else {
            System.out.println("Found 0 solutions");
        }

        System.out.println("done!");
    }


}
