package world.enemyMoveset;

import java.util.ArrayList;

public class RandomMoveSet extends MoveSet{
    public RandomMoveSet(){
        moveSet = new ArrayList<>();
        curMove = 0;
    }
    public void useMove(){
        curMove = (int) (Math.random() * moveSet.size());
        moveSet.get(curMove).action();
    }
}
