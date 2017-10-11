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

    final private ComparingInterface ColorSorting_r2p = new ComparingInterface() {
        @Override
        public boolean _isGreater(Object cmp){
            throw null;
        }

        @Override
        public boolean _isSmaller(Object cmp){
            throw null;
        }

        @Override
        public boolean _isEqual(Object cmp){
            throw null;
        }

        @Override
        public boolean _isForward(Object _cmp){
            Huluwa base = (Huluwa)getEgo();
            Huluwa cmp = (Huluwa)_cmp;
            return HLW_COLOR.isGreater(base.TellMyColor(), cmp.TellMyColor());
        }

        @Override
        public boolean _isBackward(Object _cmp){
            Huluwa base = (Huluwa)getEgo();
            Huluwa cmp = (Huluwa)_cmp;
            return HLW_COLOR.isSmaller(base.TellMyColor(), cmp.TellMyColor());
        }

        @Override
        public boolean _isStill(Object _cmp){
            Huluwa base = (Huluwa)getEgo();
            Huluwa cmp = (Huluwa)_cmp;
            return HLW_COLOR.isEqual(base.TellMyColor(), cmp.TellMyColor());
        }
    };

    final public ComparingInterface ColorSorting_r2p(){
        ColorSorting_r2p.setEgo(content);
        return ColorSorting_r2p;
    }
}
