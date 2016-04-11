package lukwik.cba.pl.controller;

/**
 * Created by Alvaro on 10.04.2016.
 */
public interface SlidingPuzzleControllerInterface {

    public void newGame();
    public void start();
    public void handleUserPieceSelection( int selectedPiecePosition );

}
