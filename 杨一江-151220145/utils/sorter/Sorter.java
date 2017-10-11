package utils.sorter;

import utils.position.BasePosition;

public interface Sorter {
    void Sort(BasePosition[] array, ComparingInterface cmpInterface);
    BasePosition sHead(BasePosition[] array, ComparingInterface cmpInterface);
    BasePosition sTail(BasePosition[] array, ComparingInterface cmpInterface);
    BasePosition sCar(BasePosition[] array, ComparingInterface cmpInterface);
    BasePosition[] sCdr(BasePosition[] array, ComparingInterface cmpInterface);
}
