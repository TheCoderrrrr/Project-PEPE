package world.entity;

import world.enemyMoveset.BABA;
import world.enemyMoveset.BasicAttack;
import world.enemyMoveset.MoveSet;
import world.managers.EntityManager;

import java.util.ArrayList;

public class EnemyUnit extends Entity{
    private MoveSet moveSet;
    public EnemyUnit(int x, int y) {
        super(x, y);
        moveSet = new MoveSet();
        moveSet.addMove(new BasicAttack());
        moveSet.addMove(new BABA());
    }
    public void action(Entity e)
    {
        e.takeDamage(10);
    }
}
