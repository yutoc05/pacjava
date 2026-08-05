import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Dot extends Actor
{
    static int score = 0;
    static int highScore = 0;
    static int dotsEaten = 0;
    public void act() 
    {
        Actor pm = getOneIntersectingObject(Pacman.class);
        if(pm != null){
            dotsEaten++;
            score += 10;
            if(score > highScore){
                highScore = score;
                getWorld().showText(highScore + "", 24, 2);
            }
            getWorld().showText(score + "", 13, 2);
            getWorld().removeObject(this);
        }    
    }
}
