package character;

import utils.position.BasePosition;

abstract public class Beings {
    private BasePosition where;

    final public BasePosition TellBasePosition(){
        return where;
    }

    final public void JumpTO(BasePosition toBasePosition){
        if(toBasePosition == null)  throw null;
        if(where != null) {
            if (where.ConsistencyCheck(this))
                where.checkout();
            else
                throw null;
        }
        where = toBasePosition;
    }

    final public BasePosition JumpOut(){
        BasePosition fromBasePosition = where;
        if(where != null && !where.ConsistencyCheck(this))  throw null;
        where = null;
        return fromBasePosition;
    }

    abstract public String TellMyName();
}
