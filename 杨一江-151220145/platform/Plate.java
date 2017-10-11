package platform;

import character.Beings;
import utils.COORD;
import utils.coordinate._2Coordinate;
import utils.position.Position;

public class Plate {
    final static public int dimensionality = 2;
    final private _2Coordinate granularity;
    final private _2Coordinate start;
    final private int[] size;

    final private Position[][] Map;

    private Plate(_2Coordinate granularity, _2Coordinate start, int XNum, int YNum){
        this.granularity = new _2Coordinate(granularity);
        this.start = new _2Coordinate(start);
        size = new int[2];
        size[COORD.X.d()] = XNum;
        size[COORD.Y.d()] = YNum;

        Map = new Position[YNum][XNum];

        for (int i = 0; i < YNum; i++) {
            for (int j = 0; j < XNum; j++) {
                Map[i][j] = new Position(start.X() + granularity.X() * j, start.Y() + granularity.Y() * i);
            }
        }
    }

    static public void CreateRegion(Plate land, _2Coordinate granularity, _2Coordinate start,
                                    int XNum, int YNum, Beings... Characters){
        land = new Plate(granularity, start, XNum, YNum);
        for (Beings creature:Characters
             ) {
            Position respond = land.BirthplaceSection(creature.TellMyBirthplace());
            if(respond == null)  break;
            creature.Birth(respond);
        }
    }

    public Position Location(_2Coordinate coord){
        int[] idx = {0, 0};
        idx[0] = (int)((coord.Y() - start.Y())/granularity.Y());
        idx[1] = (int)((coord.X() - start.X())/granularity.X());

        if(idx[0] < 0 || idx[0] >= size[COORD.Y.d()]
                || idx[1] < 0 || idx[1] >= size[COORD.X.d()])
            return null;
        return Map[idx[0]][idx[1]];
    }

    private Position BirthplaceSection(_2Coordinate coord){
        Position temp = Location(coord);
        if(temp.isOccupied())   throw null;
        else    return temp;
    }
}
