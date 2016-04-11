package lukwik.cba.pl.view;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alvaro on 10.04.2016.
 */
public class SlidingPuzzleView implements Observer
{
    List modelState;
    @Override
    public void update(Observable o, Object arg)
    {
        modelState = (List) arg;
    }
}
