package lukwik.cba.pl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lukas on 25.03.2017.
 */
public class Elements {

    private List elements;
    private int size = 16;
    public Elements()
    {
        elements = new ArrayList();
    }
    public void setInOrder()
    {
        List ordered;
        elements.clear();
        ordered = getOrdered();
        elements.addAll(ordered);

    }
    protected List getOrdered()
    {
        List ordered = new ArrayList();
        for (int i=0; i<size; i++)
        {
            ordered.add(i+1);
        }
        ordered.set(size-1,0);
        return ordered;
    }
    public boolean areOrdered()
    {
        List ordered;
        ordered = getOrdered();
        if (elements.equals(ordered))
        {
            return true;
        }
        return false;
    }
    public boolean isSwapPossible(int argElement)
    {
        if(elements.contains(argElement) && argElement != 0)
        {
            return true;
        }
        return false;
    }
    public void swap(int argElement)
    {
        int zeroIndex;
        int argumentIndex;
        zeroIndex = elements.indexOf(0);
        argumentIndex = elements.indexOf(argElement);
        elements.set(zeroIndex, argElement);
        elements.set(argumentIndex, 0);

    }
    public void shake()
    {
        Collections.shuffle(elements);
    }

    public List get()
    {
        return elements;
    }

}
