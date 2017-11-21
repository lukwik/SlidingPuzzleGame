package lukwik.cba.pl.view;

import javax.swing.*;
import java.awt.*;

public class PieceGUI extends JPanel
{
    private int pieceId;
    public PieceGUI(int pieceID)
    {
        this.pieceId = pieceID;
    }

    @Override
    public void paintComponents(Graphics g)
    {
        super.paintComponents(g);

       // g.drawRect;
        //pieceId = (Integer) pieces.get(row*gameBoardSize+col);

        if(pieceId == 0)
        {
            g.drawString(Character.toString(' '),25,25);
        }else
        {
            g.drawString(String.valueOf(pieceId),25,25);
        }

    }
}
