package world.enemyMoveset;

import java.util.ArrayList;

public class RandomMoveSet extends MoveSet{
    public RandomMoveSet(){

    }
    public void useMove(){
        curMove = nextMove;
//        moveSet.get(curMove).action();
        nextMove = (int) (Math.random() * moveSet.size());
    }

    @Override
    public Move getNextMove() {
        return moveSet.get(nextMove);
    }
}
