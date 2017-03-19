package lukwik.cba.pl.model;

import java.util.*;

/**
 * Created by Alvaro on 03.01.2016.
 */
public class SlidingPuzzleBoard extends Observable implements SlidingPuzzleModelInterface {

 //   private List<Observer> observers = new LinkedList();
    private List pieces;
    private int boardSize;

    public SlidingPuzzleBoard()
    {
        initialize();
    }

    @Override
    public void initialize()
    {
        boardSize = 4;
        setPiecesInOrder();
        notifyObservers();

    }
    @Override
    public void notifyObservers()
    {
        setChanged();
        notifyObservers(pieces);
        clearChanged();
    }
    protected List getPiecesInOrder()
    {
        int counter = 1;
        int lastIndex = boardSize * boardSize - 1;
        List pieces = new ArrayList();
        for (int i=0; i<boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                pieces.add(counter++);
            }
        }
        pieces.set(lastIndex, 0);
        return pieces;
    }

    @Override
    public void setPiecesInOrder()
    {
       pieces = getPiecesInOrder();
    }

    @Override
    public void shakePieces()
    {
        Collections.shuffle(pieces);
        notifyObservers();
    }

    @Override
    public int getEmptyPiecePosition()
    {
        int position;
        position = pieces.indexOf(0);
        return position;
    }

    @Override
    public int getBoardSize()
    {
        return boardSize;
    }

    @Override
    public void moveFromPlace(int position)
    {
        if (isMovePossible(position))
        {
            int emptyPos, requestedPiece;
            emptyPos = getEmptyPiecePosition();
            requestedPiece = (Integer) pieces.get(position);
            pieces.set(position, 0);
            pieces.set(emptyPos, requestedPiece);
            notifyObservers();
        }

    }

    @Override
    public boolean isMovePossible(int position)
    {
        int sourceRow, sourceCol,emptyPos, rowEmpty, colEmpty;
        sourceRow = position/boardSize;
        sourceCol = position % boardSize;
        emptyPos = getEmptyPiecePosition();
        rowEmpty = emptyPos/boardSize;
        colEmpty = emptyPos % boardSize;

        if (isPositionCorrect(position) && Math.abs(sourceRow-rowEmpty)+Math.abs(sourceCol-colEmpty) == 1)
        {
            return true;
        }
        return false;
    }

    private boolean isPositionCorrect(int position) {
        if(position > pieces.size()-1)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean arePiecesInOrder()
    {
      if (pieces.equals(getPiecesInOrder()))
      {
          return true;
      }else
      {
          return false;
      }

    }

}
