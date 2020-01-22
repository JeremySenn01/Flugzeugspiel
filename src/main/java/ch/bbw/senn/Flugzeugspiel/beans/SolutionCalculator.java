package ch.bbw.senn.Flugzeugspiel.beans;

import java.util.ArrayList;
import java.util.List;

public class SolutionCalculator {

    /**
     * Recursive Method that is responsible for finding all Solutions.
     * Is takes one of the remaining Cards and tries to place it on one of the board's empty squares.
     * By rotating the card it computes every combination.
     * When no cards remain / every card is placed, all solutions are returned.
     * It is possible that none are found (depends on the randomly generated cards)
     *
     * @param board -- filled, empty or partially empty board
     * @param remainingCards -- list of unplaced cards
     * @return List of valid boards
     */
    public static List<Board> findAllSolutions(Board board, List<Card> remainingCards) {
        List<Board> solutionBoards = new ArrayList<>();

        if (remainingCards.size() == 0) {
            if (board.isValid()) {
                solutionBoards.add(board);
            }
        } else {
            List<Card> newRemainingCards = new ArrayList<>();
            for (Card c : remainingCards) {
                newRemainingCards.add(c.copy());
            }

            Card cardToPlace = newRemainingCards.get(0);
            newRemainingCards.remove(cardToPlace);

            for (Coordinates c : board.getEmptyFields()) {
                for (int i = 0; i < 4; i++) {
                    Board newBoard = board.copy();
                    newBoard.getFields().put(c.copy(), cardToPlace.copy());

                    if (newBoard.isValid()) {
                        solutionBoards.addAll(findAllSolutions(newBoard, newRemainingCards));
                    }
                    cardToPlace.rotate90DegreesClockwise();
                }
            }
        }
        return solutionBoards;
    }
}
