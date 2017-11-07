package Exceptions.position;

import utils.position.Position;

public class LackingCoordinatesException extends Exception{
    Position problemPoint;

    public LackingCoordinatesException(Position problemPoint){
        this.problemPoint = problemPoint;
    }

    public Position getProblemPoint(){
        return problemPoint;
    }
}
