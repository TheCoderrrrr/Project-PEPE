package world.enemyMoveset;

import world.entity.Entity;

import java.util.ArrayList;

public class RandomMoveSet extends MoveSet{
    public RandomMoveSet(){

    }
    public void useMove(Entity entity){
        curMove = nextMove;
//        moveSet.get(curMove).action();
        nextMove = (int) (Math.random() * moveSet.size());
    }

    @Override
    public Move getNextMove() {
        return moveSet.get(nextMove);
    }

    @Override
    public Move getCurMove() {
        return null;
    }
}
