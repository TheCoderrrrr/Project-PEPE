package world.managers;

import core.Main;
import org.newdawn.slick.Graphics;
import world.entity.EnemyUnit;
import world.entity.Entity;
import world.entity.PlayerUnit;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> entities;
    public EntityManager()
    {
        entities = new ArrayList<>();
        entities.add(new PlayerUnit(Main.getScreenWidth()/4, Main.getScreenHeight()/2));
        entities.add(new EnemyUnit(Main.getScreenWidth()*3/4, Main.getScreenHeight()/3));
        entities.add(new EnemyUnit(Main.getScreenWidth()*3/4, Main.getScreenHeight()*2/3));
    }
    public void render(Graphics g){
        for(Entity e : entities)
        {
            e.render(g);
        }
    }
    public void update(){

    }
}