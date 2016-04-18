package lukwik.cba.pl;

import lukwik.cba.pl.controller.SlidingPuzzleController;
import lukwik.cba.pl.model.SlidingPuzzleBoard;

public class SlidingPuzzleMain {

    public static void main(String[] args) {

        SlidingPuzzleBoard model = new SlidingPuzzleBoard();
        SlidingPuzzleController controller = new SlidingPuzzleController(model);
    }
}
