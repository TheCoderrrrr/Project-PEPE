package world.enemyMoveset;

import world.entity.EnemyUnit;
import world.entity.Entity;

public class BasicAttack extends Move{
    private int damage;

    public BasicAttack() {
        super();
    }
    public void action(Entity entity)
    {

    }

    public int getDamage() {
        return damage;
    }
}
