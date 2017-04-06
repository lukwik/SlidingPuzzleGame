package lukwik.cba.pl.model;

/**
 * Created by Lukas on 06.04.2017.
 */
public class Size {

    public Size()
    {

    }
    public int toBoardSize( int size )
    {
        return  new Double(Math.sqrt( size )).intValue();
    }
}
