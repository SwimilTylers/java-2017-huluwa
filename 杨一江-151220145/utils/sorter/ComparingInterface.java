package utils.sorter;

public interface Comparable {
    boolean _isGreater(Comparable cmp);
    boolean _isSmaller(Comparable cmp);
    boolean _isEqual(Comparable cmp);
    boolean _isForward(Comparable cmp);
    boolean _isBackward(Comparable cmp);
}
