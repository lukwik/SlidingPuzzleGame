package lukwik.cba.pl.test;

import lukwik.cba.pl.model.SlidingPuzzleBoard;

/**
 * Created by Alvaro on 07.04.2016.
 */
public class ModelTest
{
    public static void main(String[] args)
    {
        SlidingPuzzleBoard gameBoard = new SlidingPuzzleBoard();
        gameBoard.setPiecesInOrder();
//        gameBoard.shakePieces();
        gameBoard.getEmptyPiecePosition();
        gameBoard.getBoardSize();
        gameBoard.arePiecesInOrder();
        gameBoard.isMovePossible(3);
        gameBoard.isMovePossible(11);
        gameBoard.moveFromPlace(11);
    }
}
