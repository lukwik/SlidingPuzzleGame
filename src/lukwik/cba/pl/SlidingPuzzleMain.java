package lukwik.cba.pl;

import lukwik.cba.pl.model.SlidingPuzzleModel;

public class SlidingPuzzleMain {

    public static void main(String[] args) {
	SlidingPuzzleModel gameModel = new SlidingPuzzleModel();
 //       gameModel.setPiecesInOrder();
        gameModel.shakePieces();
        gameModel.print();
    }
}
