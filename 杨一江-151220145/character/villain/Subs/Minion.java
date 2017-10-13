package character.villain.Subs;

import character.Subordinate;
import utils.coordinate._2Coordinate;

public class Minion extends Subordinate {
    public Minion(_2Coordinate birthplace){
        super(birthplace);
    }

    @Override
    public String TellMyName(){
        return "喽啰";
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
