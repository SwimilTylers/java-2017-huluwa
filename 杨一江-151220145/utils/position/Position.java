package utils.position;

import Exceptions.position.LackingCoordinatesException;
import utils.coordinate._2Coordinate;

public class Position extends BasePosition{


    public Position() throws LackingCoordinatesException{
        super(2);
        throw new LackingCoordinatesException(this);
    }



    public Position(double x, double y){
        super(2);
        coord = new _2Coordinate(x, y);
    }

    public void setPosition(double x, double y){
        coord = new _2Coordinate(x,y);
    }

    @Override
    public String toString(){
        if(content == null)
            return coord + "{empty} ";
        else
            return coord + " {" + content.TellMyName() + "}";
    }




}
