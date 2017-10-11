package utils.sorter;

abstract public class ComparingInterface {

    private Object ego = null;

    final public void setEgo(Object ego){
        this.ego = ego;
    }

    final public Object getEgo(){
        return ego;
    }

    abstract public boolean _isGreater(Object cmp);
    abstract public boolean _isSmaller(Object cmp);
    abstract public boolean _isEqual(Object cmp);
    abstract public boolean _isForward(Object cmp);
    abstract public boolean _isBackward(Object cmp);
    abstract public boolean _isStill(Object cmp);
}
