package utils.position;

import character.Beings;
import character.hero.Huluwa;
import utils.HLW_COLOR;
import utils.sorter.ComparingInterface;

public class BasePosition {
    protected double[] coord;
    protected final int dimension;
    protected Beings content;

    BasePosition(int dimensionality){
        dimension = dimensionality;
        coord = new double[dimension];
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

    public boolean ConsistencyCheck(Beings chk){
        if (isOccupied()){
            return content == chk;
        }
        else
            return false;
    }

    final public boolean checkin(Beings standin){
        if(isOccupied())
            return false;
        else{
            standin.JumpTO(this);
            content = standin;
            return true;
        }
    }

    final public Beings checkout(){
        if (isOccupied()){
            Beings reside = content;
            content.JumpOut();
            content = null;
            return reside;
        }
        return null;
    }

    public Beings getContent() {
        return content;
    }

    static public void Swap(BasePosition bp_1, BasePosition bp_2){
        Beings temp = bp_1.content;
        bp_1.content = bp_2.content;
        bp_2.content = temp;
    }

    static final public ComparingInterface ColorSorting_r2p = new ColorSorting() {
        @Override
        public boolean _isForward(Object cmp){
            return _isGreater(cmp);
        }

        @Override
        public boolean _isBackward(Object cmp){
            return _isSmaller(cmp);
        }

        @Override
        public boolean _isStill(Object cmp){
            return _isEqual(cmp);
        }
    };
}

abstract class ColorSorting extends ComparingInterface{
    @Override
    public boolean _isGreater(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        return HLW_COLOR.isGreater(((Huluwa)base.getContent()).TellMyColor(),
                ((Huluwa)cmp.getContent()).TellMyColor());
    }

    @Override
    public boolean _isSmaller(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        return HLW_COLOR.isSmaller(((Huluwa)base.getContent()).TellMyColor(),
                ((Huluwa)cmp.getContent()).TellMyColor());
    }

    @Override
    public boolean _isEqual(Object _cmp){
        BasePosition base = (BasePosition)getEgo();
        BasePosition cmp = (BasePosition)_cmp;
        return HLW_COLOR.isEqual(((Huluwa)base.getContent()).TellMyColor(),
                ((Huluwa)cmp.getContent()).TellMyColor());
    }

    abstract public boolean _isForward(Object cmp);
    abstract public boolean _isBackward(Object cmp);
    abstract public boolean _isStill(Object cmp);
}
