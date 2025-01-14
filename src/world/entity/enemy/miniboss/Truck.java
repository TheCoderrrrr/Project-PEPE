package world.entity.enemy.miniboss;

import resources.Images;
import world.entity.enemy.EnemyUnit;

public class Truck extends EnemyUnit {
    public Truck(int x, int y) {
        super(x, y);
        image = Images.TRUCKENEMY;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 2;
    }
}
