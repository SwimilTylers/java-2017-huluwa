package platform.plate;

import Exceptions.plate.MapExpansionFailure;
import utils.BACKGROUNDS;
import utils.coordinate._2Coordinate;
import utils.layout.Layout;
import utils.position.PositionWithBackground;


public class PlateMapModule_Background extends PlateMapModule{
    public PlateMapModule_Background(_2Coordinate granularity, _2Coordinate start, int XNum, int YNum) throws MapExpansionFailure{
        super(granularity, start, XNum, YNum, PositionWithBackground.class);
    }

    public void setBackground(BACKGROUNDS backgrounds, _2Coordinate... layout){
        setBackground(backgrounds, new Layout(this, layout));
    }

    public void setBackground(BACKGROUNDS backgrounds, Layout layout){
        if(backgrounds == null){
            return;
        }
        else if(layout == null){
            for (int i = 0; i < Map.length; i++) {
                for (int j = 0; j < Map[i].length; j++) {
                    ((PositionWithBackground) Map[i][j]).setBackgrounds(backgrounds);
                }
            }
        }
        else {
            for (int i = 0; i < layout.nodes.length; i++) {
                ((PositionWithBackground) layout.nodes[i]).setBackgrounds(backgrounds);
            }
        }
    }
}

