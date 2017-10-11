package character.hero;

import character.Beings;
import utils.HLW_COLOR;
import utils.HLW_SENIORITY;
import utils.position.*;

abstract public class Huluwa extends Beings{


    static private int TotalBrother = 0;

    public Huluwa(){
        TotalBrother++;
    }

    final public int TellBrotherNumber(){
        return TotalBrother;
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
        System.out.println("BasePosition " + tested.TellBasePosition());

        position.checkout();
        System.out.println("BasePosition " + position);
    }
}
