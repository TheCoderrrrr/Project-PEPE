package world.levels;

import java.util.ArrayList;

import core.Main;
import world.entity.Entity;
import world.entity.EnemyUnit;
public class Levels {
    public static void generateLevel(int level, ArrayList<Entity> units) {
        int num = (int) (Math.random() * 4);
        for(int i=0; i<num; i++) {
            units.add(new EnemyUnit(Main.getScreenWidth()*3/4, Main.getScreenHeight()*2/3));
        }
    }
}
