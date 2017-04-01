package lukwik.cba.pl.model;

import java.util.List;

/**
 * Created by Lukas on 25.03.2017.
 */
public class Move {

    private List elements;
    public Move(List argElements)
    {
        elements = argElements;
    }

    public boolean isPossibleForElement(int argElement)
    {
        if (!elements.contains(argElement))
        {
            return false;
        }
        int sourceRow, sourceCol,emptyPos, rowEmpty, colEmpty;
        Position position = new Position(elements.size());
        sourceRow = position.getRowFor(elements.indexOf(argElement));
        sourceCol = position.getColFor(elements.indexOf(argElement));
        emptyPos = elements.indexOf(0);
        rowEmpty = position.getRowFor(emptyPos);
        colEmpty = position.getColFor(emptyPos);

        if ( Math.abs(sourceRow-rowEmpty)+Math.abs(sourceCol-colEmpty) == 1)
        {
            return true;
        }else
        {
            return false;
        }
    }

}
