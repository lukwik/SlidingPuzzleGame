package lukwik.cba.pl.view;

import lukwik.cba.pl.controller.SlidingPuzzleController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alvaro on 10.04.2016.
 */
public class SlidingPuzzleView implements Observer
{
    List pieces;
    SlidingPuzzleController controller;
    JFrame frameGame;
    JButton buttonNewGame;
    JButton buttonStart;
    PiecesPanel panelPieces;

    public  SlidingPuzzleView( SlidingPuzzleController c )
    {
        controller = c;
    }

    public void initialize()
    {
        pieces = new ArrayList();
        frameGame = new JFrame("Sliding puzzle game");
        buttonNewGame = new JButton("New Game");
        buttonStart = new JButton("Start");
        panelPieces = new PiecesPanel(pieces);
        panelPieces.setLayout( new GridLayout(3,1) );
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.getContentPane().setLayout( new GridLayout(3,1) );
        frameGame.getContentPane().add(panelPieces);
        frameGame.getContentPane().add(buttonNewGame);
        frameGame.getContentPane().add(buttonStart);
        frameGame.setSize( new Dimension(500,500) );
        frameGame.pack();
        frameGame.setVisible(true);
   //     frameGame.setLayout();

    }
    @Override
    public void update(Observable o, Object arg)
    {
        List list = (List) arg;
        pieces.clear();
        pieces.addAll(list);
        frameGame.repaint();
    }
}

class PiecesPanel extends JPanel
{
    List pieces;

    PiecesPanel(List p)
    {
        pieces = p;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int gameBoardSize;
        int pieceSize =50;
        gameBoardSize = getGameBoardSize();
        for (int row = 0; row < gameBoardSize; row++)
        {
            for (int col = 0; col < gameBoardSize; col++)
            {
                g.drawRect(row*pieceSize,col*pieceSize,pieceSize,pieceSize);
                g.drawString(String.valueOf(pieces.get(row*gameBoardSize+col)),row*(pieceSize/2),col*(pieceSize/2));
            }
        }
    }

    private int getGameBoardSize()
    {
        double sqrt;
        sqrt = Math.sqrt(pieces.size());
        return Integer.parseInt(String.valueOf(sqrt));
    }
}