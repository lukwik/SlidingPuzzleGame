package lukwik.cba.pl;

import lukwik.cba.pl.model.SlidingPuzzleBoard;

public class SlidingPuzzleMain {

    public static void main(String[] args) {
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
