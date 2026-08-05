import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BigDot extends Actor
{
    static boolean crazed = false;
    public void act() 
    {
        Actor pm = getOneIntersectingObject(Pacman.class);
        if(pm != null){
            Dot dot = getWorld().getObjects(Dot.class).get(0);
            dot.score += 50;
            if(dot.score > dot.highScore){
                dot.highScore = dot.score;
                getWorld().showText(dot.highScore + "", 24, 2);
            }
            getWorld().showText(dot.score + "", 13, 2);
            Pacman pacman = getWorld().getObjects(Pacman.class).get(0);
            pacman.ghostsEaten = 0;
            crazed = true;
            Red red = getWorld().getObjects(Red.class).get(0);
            Pink pink = getWorld().getObjects(Pink.class).get(0);
            Cyan cyan = getWorld().getObjects(Cyan.class).get(0);
            Orange orange = getWorld().getObjects(Orange.class).get(0);
            red.crazeTimer = 0;
            red.setImage("tile098.png");
            pink.setImage("tile098.png");
            cyan.setImage("tile098.png");
            orange.setImage("tile098.png");
            getWorld().removeObject(this);
        }
    }
}
