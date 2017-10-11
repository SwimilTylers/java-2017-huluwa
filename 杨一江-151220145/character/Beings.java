package character;

import utils.coordinate._2Coordinate;
import utils.position.BasePosition;

abstract public class Beings {
    private BasePosition where;
    private _2Coordinate birthplace;

    final public void ChangeBirthplace(_2Coordinate wt){
        birthplace = wt;
    }

    final public _2Coordinate TellMyBirthplace(){
        return birthplace;
    }

    final public boolean Birth(BasePosition p_birthplace){
        if(p_birthplace.isOccupied())   return false;
        JumpTO(p_birthplace);
        return true;
    }

    final public BasePosition TellBasePosition(){
        return where;
    }

    final public void JumpTO(BasePosition toBasePosition){
        if(toBasePosition == null)  throw null;
        if(toBasePosition.isOccupied()) {
            AfterMeetingBeings();
            return;
        }
        if(where != null) {
            if (where.ConsistencyCheck(this)) {
                JumpOut();
            }
            else
                throw null;
        }
        where = toBasePosition;
    }

    final public BasePosition JumpOut(){
        BasePosition fromBasePosition = where;
        if(where != null) {
            if (!where.ConsistencyCheck(this)) throw null;
            where.checkout();
            where = null;
        }
        return fromBasePosition;
    }

    final static public void ExchangeOurPosition(Beings a, Beings b){
        BasePosition temp = b.JumpOut();
        b.JumpTO(a.JumpOut());
        a.JumpTO(temp);
    }

    abstract public String TellMyName();
    abstract protected void AfterMeetingBeings();
}
