package platform.plate;

import character.Beings;
import character.hero.Grandpa;
import character.villain.Serpent;
import utils.COORD;
import utils.coordinate._2Coordinate;
import utils.layout.Layout;
import utils.layout.LayoutBrief;
import utils.position.Position;

public class Plate{
    final public PlateMapModule MapModule;
    final public PlateLayoutManipModule LayoutManip;

    final private _2Coordinate granularity;
    final private _2Coordinate start;
    final private int[] size;

    private Plate(_2Coordinate granularity, _2Coordinate start, int XNum, int YNum){
        MapModule = new PlateMapModule(granularity, start, XNum, YNum);
        LayoutManip = new PlateLayoutManipModule(granularity, start, XNum, YNum);
        this.granularity = granularity;
        this.start = start;
        size = new int[2];
        size[COORD.X.d()] = XNum;
        size[COORD.Y.d()] = YNum;
    }

    static public Plate CreateRealm(_2Coordinate granularity, _2Coordinate start,
                                    int XNum, int YNum, Beings... Characters){
        Plate land = new Plate(granularity, start, XNum, YNum);
        for (Beings creature:Characters
             ) {
            Position respond = land.BirthplaceSection(creature.TellMyBirthplace());
            if(respond == null)  break;
            creature.Birth(respond);
        }
        return land;
    }

    static public Plate CreateRealm(PlateSettings Settings, Beings... Characters){
        return CreateRealm(Settings.granularity(), Settings.start(), Settings.XNum(), Settings.YNum(),Characters);
    }

    private Position BirthplaceSection(_2Coordinate coord){
        Position temp = MapModule.Location(coord);
        if(temp.isOccupied())   throw null;
        else    return temp;
    }

    @Override
    public String toString(){
        return MapModule.MakeEveryoneResponse();
    }

    public static void main(String[] argv){
        Grandpa grandpa = new Grandpa(new _2Coordinate(6,2));
        Serpent serpent = new Serpent(new _2Coordinate(9,12));
        Plate world = Plate.CreateRealm(PlateSettings.Regularized, grandpa, serpent);

        grandpa.DefaultConstituents(new LayoutBrief(world.MapModule, Layout.Changshe));
        serpent.DefaultConstituents(new LayoutBrief(world.MapModule, Layout.Heyi));

        System.out.println("初始：");
        System.out.println(world.MapModule.MakeEveryoneResponse());

        serpent.RangeConstituents(new LayoutBrief(world.MapModule, Layout.Fanggang));

        System.out.println("阵型 1：");
        System.out.println(world.MapModule.MakeEveryoneResponse());

        serpent.RangeConstituents(new LayoutBrief(world.MapModule, Layout.Fengshi));

        System.out.println("阵型 2：");
        System.out.println(world.MapModule.MakeEveryoneResponse());

        serpent.RangeConstituents(new LayoutBrief(world.MapModule, Layout.Yanyue));

        System.out.println("阵型 3：");
        System.out.println(world.MapModule.MakeEveryoneResponse());

        serpent.RangeConstituents(new LayoutBrief(world.MapModule, Layout.Yanxing));

        System.out.println("阵型 4：");
        System.out.println(world.MapModule.MakeEveryoneResponse());
    }
}
