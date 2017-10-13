package utils.layout;

import platform.PlatformBrowser;
import utils.coordinate.Coordinate;
import utils.position.BasePosition;

public class Layout {
    final public BasePosition[] nodes;
    final public PlatformBrowser platform;
    final public int length;

    public Layout(PlatformBrowser platform, Coordinate... obj){
        this.platform = platform;
        nodes = platform.Location(obj);
        length = nodes.length;
    }

    public BasePosition[] getOccupiedNodes(){
        int sizeShouldBe = 0;
        BasePosition[] notes = new BasePosition[length];
        for (int i = 0; i < length; i++) {
            if(nodes[i].isOccupied()){
                notes[sizeShouldBe] = nodes[i];
                sizeShouldBe++;
            }
        }
        BasePosition[] ret = new BasePosition[sizeShouldBe];
        for (int i = 0; i < sizeShouldBe; i++) {
            ret[i] = notes[i];
        }
        return ret;
    }

    public boolean isAvailable(){
        for (BasePosition i:nodes
             ) {
            if(!i.isOccupied())
                return true;
        }
        return false;
    }
}
