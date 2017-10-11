package utils.position;

import utils.COORD;

public class Position extends BasePosition{
    public Position(double x, double y){
        super(2);
        coord[COORD.X.d()] = x;
        coord[COORD.Y.d()] = y;
    }



    @Override
    public String toString(){
        if(content == null)
            return "[" + coord[COORD.X.d()] + "," + coord[COORD.Y.d()] + "] {empty}";
        else
            return "[" + coord[COORD.X.d()] + "," + coord[COORD.Y.d()] + "] {"
                    + content.TellMyName() + "}";
    }




}
