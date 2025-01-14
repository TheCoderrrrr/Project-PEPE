package world.enemyMoveset;

import world.enemyMoveset.moves.Move;
import world.entity.Entity;

import java.util.ArrayList;

public class RandomMoveSet extends MoveSet{
    public RandomMoveSet(){

    }
    public void addMove(ArrayList<Move> m){
        super.addMove(m);
        nextMove = (int) (Math.random() * moveSet.size());
    }
    public void useMove(Entity entity){
        curMove = nextMove;
        moveSet.get(curMove).action(entity);
        System.out.println(moveSet.get(curMove).getClass().getSimpleName());
        nextMove = (int) (Math.random() * moveSet.size());
    }

    @Override
    public Move getNextMove() {
        return moveSet.get(nextMove);
    }

    @Override
    public Move getCurMove() {
        return moveSet.get(curMove);
    }
}
