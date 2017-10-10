package utils;

import character.hero.Huluwa;

public class Position {
    double[] coord;
    final int dimension = 2;
    Huluwa content;

    public Position(double x, double y){
        coord = new double[dimension];
        coord[COORD.X.d()] = x;
        coord[COORD.Y.d()] = y;
    }

    public boolean isOccupied(){
        if (content == null)
            return false;
        else
            return true;
    }

    public int TellDimensionality(){
        return dimension;
    }

    public boolean ConsistencyCheck(Huluwa chk){
        if (isOccupied()){
            return content == chk;
        }
        else
            return false;
    }

    final public boolean checkin(Huluwa standin){
        if(isOccupied())
            return false;
        else{
            standin.JumpTO(this);
            content = standin;
            return true;
        }
    }

    final public Huluwa checkout(){
        if (isOccupied()){
            Huluwa reside = content;
            content.JumpOut();
            content = null;
            return reside;
        }
        return null;
    }

    @Override
    public String toString(){
        if(content == null)
            return "[" + coord[COORD.X.d()] + "," + coord[COORD.Y.d()] + "] {empty}";
        else
            return "[" + coord[COORD.X.d()] + "," + coord[COORD.Y.d()] + "] {"
                    + content.TellMyName() + " " + content.TellMyColor() + " " + content.TellMySeniority() + "}";
    }
}
