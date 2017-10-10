package character.hero;

import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.Position;

abstract public class Huluwa {
        private Position where;

    static private int TotalBrother = 0;

    public Huluwa(){
        TotalBrother++;
    }

    final public int TellBrotherNumber(){
        return TotalBrother;
    }

    final public void JumpTO(Position toPosition){
        if(toPosition == null)  throw null;
        if(where != null) {
            if (where.ConsistencyCheck(this))
                where.checkout();
            else
                throw null;
        }
        where = toPosition;
    }

    final public Position JumpOut(){
        Position fromPosition = where;
        if(where != null && !where.ConsistencyCheck(this))  throw null;
        where = null;
        return fromPosition;
    }

    final public Position TellPosition(){
        return where;
    }

    abstract public String TellMyName();
    abstract public HLW_COLOR TellMyColor();
    abstract public HLW_SENIORITY TellMySeniority();

    static public void main(String[] argv){
        Huluwa tested = new Huluwa() {
            @Override
            public String TellMyName() {
                return "tested";
            }

            @Override
            public HLW_COLOR TellMyColor() {
                return HLW_COLOR.BLUE;
            }

            @Override
            public HLW_SENIORITY TellMySeniority() {
                return HLW_SENIORITY.FIRST;
            }
        };

        System.out.println("Total Brothers " + tested.TellBrotherNumber());
        System.out.println("Name " + tested.TellMyName());
        System.out.println("Seniority " + tested.TellMySeniority());
        System.out.println("Color " + tested.TellMyColor());
        Position position = new Position(1, 1);

        position.checkin(tested);
        System.out.println("Position " + tested.TellPosition());

        position.checkout();
        System.out.println("Position " + position);
    }
}
