package utils.position;

import Exceptions.position.LackingCoordinatesException;
import utils.BACKGROUNDS;

public class PositionWithBackground extends Position{

    BACKGROUNDS backgrounds;

    public PositionWithBackground() throws LackingCoordinatesException{
        this.backgrounds = BACKGROUNDS.Tree;
        throw new LackingCoordinatesException(this);
    }

    public PositionWithBackground(double x, double y, BACKGROUNDS backgrounds) {
        super(x, y);
        this.backgrounds = backgrounds;
    }

    public void setBackgrounds(BACKGROUNDS backgrounds){
        this.backgrounds = backgrounds;
    }

    @Override
    public String toString(){
        if(content == null)
            return coord + backgrounds.toString();
        else
            return coord + content.TellMyName();
    }
}
