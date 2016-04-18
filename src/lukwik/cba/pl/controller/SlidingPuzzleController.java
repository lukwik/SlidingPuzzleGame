package lukwik.cba.pl.controller;

import lukwik.cba.pl.model.SlidingPuzzleModelInterface;
import lukwik.cba.pl.view.SlidingPuzzleView;

import java.util.Observable;

/**
 * Created by Alvaro on 10.04.2016.
 */
public class SlidingPuzzleController implements SlidingPuzzleControllerInterface {

    SlidingPuzzleModelInterface model;
    SlidingPuzzleView view;

    public SlidingPuzzleController( Observable model )
    {
        view = new SlidingPuzzleView(this);
        model.addObserver(view);
        this.model = (SlidingPuzzleModelInterface)model;
        this.model.initialize();
        view.initialize();
    }

    @Override
    public void newGame() {

        model.initialize();
    }

    @Override
    public void start() {

        model.shakePieces();
    }

    @Override
    public void handleUserPieceSelection(int selectedPiecePosition) {

        model.moveFromPlace(selectedPiecePosition);
        if (model.arePiecesInOrder())
        {

        }
    }
}
