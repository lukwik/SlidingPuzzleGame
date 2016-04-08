package lukwik.cba.pl;

import lukwik.cba.pl.model.SlidingPuzzleModel;

public class SlidingPuzzleMain {

    public static void main(String[] args) {
	SlidingPuzzleModel gameModel = new SlidingPuzzleModel();
        gameModel.setPiecesInOrder();
//        gameModel.shakePieces();
        gameModel.getEmptyPiecePosition();
        gameModel.getBoardSize();
        gameModel.arePiecesInOrder();
        gameModel.isMovePossible(3);
        gameModel.isMovePossible(11);
        gameModel.moveFromPlace(11);
    }
}
