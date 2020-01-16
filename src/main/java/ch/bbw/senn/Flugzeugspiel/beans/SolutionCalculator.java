package ch.bbw.senn.Flugzeugspiel.beans;

import java.util.ArrayList;
import java.util.List;

public class SolutionCalculator {
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
