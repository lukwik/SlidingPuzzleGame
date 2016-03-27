package lukwik.cba.pl.model;

import javafx.beans.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Alvaro on 03.01.2016.
 */
public class SlidingPuzzleModel extends java.util.Observable
{
    private int[][] board;
    private int boardSize;
    private int emptyPlaceVerticalCoordination;
    private int emptyPlaceHorizontalCoordination;

    public SlidingPuzzleModel()
    {

      boardSize = 4;
      board = new int[boardSize][boardSize];
    }

    public void intitialize()
    {
        setPiecesInOrder();
        setEmptyPlace();
    }

    public void setPiecesInOrder()
    {
        int counter = 1;
        for (int i=0; i<boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = counter++;
            }
        }
        board[boardSize-1][boardSize-1] = 0;

    }

    public void shakePieces()
    {
        setPiecesInOrder();
        Collections.shuffle(Arrays.asList(board));
    }

    public void setEmptyPlace()
    {
        for (int i=0; i<boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if( board[i][j] == 0 )
                {
                    emptyPlaceVerticalCoordination = i;
                    emptyPlaceHorizontalCoordination = j;
                }
            }
        }
    }

    public void moveFromPlace(int vertical, int horizontal)
    {

    }

    public boolean isMovePossible(int vertical, int horizontal)
    {
        return false;
    }

    public void swap(int vertical, int horizontal)
    {

    }
    public boolean arePiecesInOrder()
    {
      return false;
    }

    public  void print()
    {
        for(int i=0; i<boardSize; i++)
        {
            System.out.println(Arrays.toString(board[i]));
        }

    }
}
