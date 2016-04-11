package lukwik.cba.pl.model;

import java.util.Observer;

/**
 * Created by Alvaro on 08.04.2016.
 */
public interface SlidingPuzzleModelInterface {
    void initialize();

    void setPiecesInOrder();

    void shakePieces();

    int getEmptyPiecePosition();

    int getBoardSize();

    void moveFromPlace(int position);

    boolean isMovePossible(int position);

    boolean arePiecesInOrder();

}
