package lukwik.cba.pl.model;

/**
 * Created by Lukas on 01.04.2017.
 */
public class Position {

    int boardSize;

    public Position( int argNumberOfElements )
    {
        setNumberOfElements( argNumberOfElements );
    }

    public void setNumberOfElements(int argNumberOfElements)
    {
        Size size = new Size();
        boardSize = size.toBoardSize(argNumberOfElements);
    }

    public int getRowFor( int position )
    {
        return position/boardSize;
    }

    public int getColFor( int position )
    {
        return position % boardSize;
    }

}
