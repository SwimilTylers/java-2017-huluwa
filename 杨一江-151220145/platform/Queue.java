package platform;

import utils.HLW_COLOR;
import utils.Position;
import utils.sorter.Sorter;

public class Queue {
    private int szQueue = 0;
    private Position[] queue;

    public Queue(int szQueue){
        this.szQueue = szQueue;
        queue = new Position[szQueue];

        for(int i = 0; i < this.szQueue; i++){
            Position p = new Position(i, 0);
            queue[i] = p;
        }
    }

    public Position getPoint(int idx){
        if(idx < 0 || idx >= szQueue)
            return null;
        else
            return queue[idx];
    }

    public void Sort(Sorter sorter){
        sorter(queue, HLW_COLOR);
    }
}
