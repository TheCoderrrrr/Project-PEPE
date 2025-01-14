package world.entity.enemy.miniboss;

import resources.Images;
import world.entity.enemy.EnemyUnit;

public class Stack extends EnemyUnit {
    public Stack(int x, int y) {
        super(x, y);
        image = Images.STACKENEMY;
        width = image.getWidth();
        height = image.getHeight();
        maxHealth *= 2;
    }
}
