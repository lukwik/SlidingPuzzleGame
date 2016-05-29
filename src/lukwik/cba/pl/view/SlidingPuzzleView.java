package lukwik.cba.pl.view;

import lukwik.cba.pl.controller.SlidingPuzzleController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alvaro on 10.04.2016.
 */
public class SlidingPuzzleView implements Observer, ActionListener
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
//        frameGame.setSize( new Dimension(100,100) );
        buttonNewGame = new JButton("New Game");
        buttonNewGame.addActionListener(this);
        buttonStart = new JButton("Start");
        buttonStart.addActionListener(this);
        buttonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPieces = new PiecesPanel(pieces);
        panelPieces.setPreferredSize( new Dimension(700,700));
//        panelPieces.setLayout( new GridLayout(3,1) );
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.getContentPane().setLayout( new BoxLayout(frameGame.getContentPane(), BoxLayout.Y_AXIS) );
//        frameGame.getContentPane().setSize(800,800);
        frameGame.getContentPane().add(panelPieces);
        frameGame.getContentPane().add(buttonNewGame);
        frameGame.getContentPane().add(buttonStart);

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


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonStart)
        {
            controller.start();
        }
        else if (e.getSource() == buttonNewGame)
        {
            controller.newGame();
        }
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
        int pieceSize =150;
        int restOfDivision, offset;
        gameBoardSize = getGameBoardSize();
//        setPreferredSize(new Dimension( gameBoardSize * pieceSize, gameBoardSize * pieceSize));
        for (int row = 0; row < gameBoardSize; row++)
        {
            for (int col = 0; col < gameBoardSize; col++)
            {
                g.drawRect(row*pieceSize,col*pieceSize,pieceSize,pieceSize);
                restOfDivision = col % 2;
                offset = restOfDivision * (pieceSize/2);
                g.drawString(String.valueOf(pieces.get(col*gameBoardSize+row)),((row+1)*(pieceSize/2))+offset,((col+1)*(pieceSize/2))+offset);
            }
        }
    }

    private int getGameBoardSize()
    {
        Double sqrt;

        sqrt = new Double(Math.sqrt(pieces.size()));
        return sqrt.intValue();
    }
}