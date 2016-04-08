package lukwik.cba.pl.model;

import java.util.*;

/**
 * Created by Alvaro on 03.01.2016.
 */
public class SlidingPuzzleModel extends java.util.Observable
{
    private List pieces;
    private int boardSize;

    public SlidingPuzzleModel()
    {
        initialize();
    }

    public void initialize()
    {
        boardSize = 4;
        pieces = new ArrayList();
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

    public void setPiecesInOrder()
    {
       pieces = getPiecesInOrder();
    }

    public void shakePieces()
    {
/*        setPiecesInOrder();*/
        Collections.shuffle(pieces);
    }

    public int getEmptyPiecePosition()
    {
        int position;
        position = pieces.indexOf(0);
        return position;
    }

    public int getBoardSize()
    {
        return boardSize;
    }

    public void moveFromPlace(int position)
    {
        int emptyPos, requestedPiece;
        emptyPos = getEmptyPiecePosition();
        requestedPiece = (Integer) pieces.get(position);
        pieces.set(position, 0);
        pieces.set(emptyPos, requestedPiece);
    }

    public boolean isMovePossible(int position)
    {
        int sourceRow, sourceCol,emptyPos, rowEmpty, colEmpty;
        sourceRow = position/boardSize;
        sourceCol = position % boardSize;
        emptyPos = getEmptyPiecePosition();
        rowEmpty = emptyPos/boardSize;
        colEmpty = emptyPos % boardSize;

        if (Math.abs(sourceRow-rowEmpty)+Math.abs(sourceCol-colEmpty) == 1)
        {
            return true;
        }
        return false;
    }

    public void swap(int position)
    {

    }
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

    public  void print()
    {
        for(int i=0; i<boardSize; i++)
        {
//            System.out.println(Arrays.toString(board[i]));
        }

    }
}
