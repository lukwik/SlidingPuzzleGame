package lukwik.cba.pl.model;

import java.util.*;

/**
 * Created by Alvaro on 03.01.2016.
 */
public class SlidingPuzzleBoard extends Observable implements SlidingPuzzleModelInterface {

 //   private List<Observer> observers = new LinkedList();
    private Elements elements;

    public SlidingPuzzleBoard()
    {
        initialize();
    }

    @Override
    public void initialize()
    {
        setPiecesInOrder();
        notifyObservers();

    }
    @Override
    public void notifyObservers()
    {
        setChanged();
        notifyObservers(elements.get());
        clearChanged();
    }
    protected List getPiecesInOrder()
    {

        return elements.getOrdered();
    }

    @Override
    public void setPiecesInOrder()
    {
        elements = new Elements();
        elements.setInOrder();
    }

    @Override
    public void shakePieces()
    {
        elements.shake();
        notifyObservers();
    }

    @Override
    public int getEmptyPiecePosition()
    {

        return elements.get().indexOf(0);
    }

    @Override
    public int getBoardSize()
    {
        return (int) Math.sqrt( (double) elements.get().size());
    }

    @Override
    public void moveFromPlace(int position)
    {
        if (isMovePossible(position))
        {

            elements.swap( (Integer)elements.get().get(position));
            notifyObservers();
        }

//        if (isMovePossible(position))
//        {
//            int emptyPos, requestedPiece;
//            emptyPos = getEmptyPiecePosition();
//            requestedPiece = (Integer) pieces.get(position);
//            pieces.set(position, 0);
//            pieces.set(emptyPos, requestedPiece);
//            notifyObservers();
//        }

    }

    @Override
    public boolean isMovePossible(int position)
    {
        Move move = new Move(elements.get());
        int element;
        element = (Integer) elements.get().get(position);
        return  move.isPossibleForElement(element);
    }

//    private boolean isPositionCorrect(int position) {
//        if(position > pieces.size()-1)
//        {
//            return false;
//        }
//        return true;
//    }

    @Override
    public boolean arePiecesInOrder()
    {
        return elements.areOrdered();
    }

}
