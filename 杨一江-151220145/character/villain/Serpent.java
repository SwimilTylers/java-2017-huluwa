package character.villain;

import character.Beings;
import utils.coordinate._2Coordinate;

public class Serpent extends Beings{
    private boolean DUPLICATED_LOCK = false;

    public Serpent(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    @Override
    public String TellMyName(){
        return "蛇精";
    }

    @Override
    protected void AfterMeetingBeings(){
        throw null;
    }

    @Override
    public boolean isHero(){
        return false;
    }
}
