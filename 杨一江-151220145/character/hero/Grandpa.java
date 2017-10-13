package character.hero;

import character.Beings;
import utils.coordinate._2Coordinate;

public class Grandpa extends Beings{

    private boolean DUPLICATED_LOCK = false;

    public Grandpa(_2Coordinate birthplace){
        super(birthplace);
        if(DUPLICATED_LOCK)
            throw null;
        DUPLICATED_LOCK = true;
    }

    public void Seed(){
        throw null;
    }

    @Override
    public String TellMyName(){
        return "爷爷";
    }

    @Override
    protected void AfterMeetingBeings(){
        throw null;
    }

    @Override
    public boolean isHero(){
        return true;
    }
}
