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

    }
    @Override
    public void update(Observable o, Object arg)
    {
        List list = (List) arg;
        pieces.clear();
        pieces.addAll(list);
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

    }
}