import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Pacman extends Actor
{
    int dir = 0;
    int timer = 0;
    int checkX = 0;
    int checkY = 0;
    int lives = 3;
    int ghostsEaten = 0;
    boolean dying = false;
    boolean hitRed = false;
    boolean hitPink = false;
    boolean hitCyan = false;
    boolean hitOrange = false;
    public void act() 
    {
        //BigDot bigDot = getWorld().getObjects(BigDot.class).get(0);
        timer++;
        if(dying == false){
            if(Greenfoot.isKeyDown("up")){
                dir = 1;
            }
            else if(Greenfoot.isKeyDown("left")){
                dir = 2;
            }
            else if(Greenfoot.isKeyDown("right")){
                dir = 3;
            }
            else if(Greenfoot.isKeyDown("down")){
                dir = 4;
            }

            int oldX = this.getX();
            int oldY = this.getY();

            if(dir == 1 && timer >= 6){  //up
                this.setLocation(this.getX(), this.getY() - 1);
                timer = 0;
                setImage("tile042.png");
            }

            if(dir == 2 && timer >= 6){  //left
                this.setLocation(this.getX() - 1, this.getY());
                timer = 0;
                setImage("tile052.png");
            }

            if(dir == 3 && timer >= 6){  //right
                this.setLocation(this.getX() + 1, this.getY());
                timer = 0;
                setImage("tile045.png");
            }

            if(dir == 4 && timer >= 6){  //down
                this.setLocation(this.getX(), this.getY() + 1);
                timer = 0;
                setImage("tile049.png");
            }

            if(getX() == 4 && getY() == 18){
                this.setLocation(31,18);
            }
            if(getX() == 32 && getY() == 18){
                this.setLocation(5,18);
            }

            if(this.getX() != checkX || this.getY() != checkY){
                animate();
            }

            Actor borderH = getOneIntersectingObject(BorderH.class);
            Actor borderV = getOneIntersectingObject(BorderV.class);
            Actor black = getOneIntersectingObject(Black.class);
            if(borderH != null || borderV != null || black != null){
                checkX = this.getX();
                checkY = this.getY();
                this.setLocation(oldX, oldY);
            }
        }
        Actor red = getOneIntersectingObject(Red.class);
        Actor pink = getOneIntersectingObject(Pink.class);
        Actor cyan = getOneIntersectingObject(Cyan.class);
        Actor orange = getOneIntersectingObject(Orange.class);
        if(red != null){
            hitRed = true;
            if(!BigDot.crazed){
                red.setLocation(18,15);
            }
        }
        if(pink != null){
            hitPink = true;
            if(!BigDot.crazed){
                pink.setLocation(18,15);
            }
        }
        if(cyan != null){
            hitCyan = true;
            if(!BigDot.crazed){
                cyan.setLocation(18,15);
            }
        }
        if(orange != null){
            hitOrange = true;
            if(!BigDot.crazed){
                orange.setLocation(18,15);
            }
        }
        if(hitRed){
            if(BigDot.crazed && red != null){
                red.setImage("tile039.png");
            }
            death();
        }
        if(hitPink){
            if(BigDot.crazed && pink != null){
                pink.setImage("tile039.png");
            }
            death();
        }
        if(hitCyan){
            if(BigDot.crazed && cyan != null){
                cyan.setImage("tile039.png");
            }
            death();
        }
        if(hitOrange){
            if(BigDot.crazed && orange != null){
                orange.setImage("tile039.png");
            }
            death();
        }
        if(lives == 0){
            gameOver();
        }

    }

    public void animate()
    {
        if(dir == 1 && timer == 2){  //up
            setImage("tile041.png");
        }

        if(dir == 2 && timer == 2){  //left
            setImage("tile053.png");
        }

        if(dir == 3 && timer == 2){  //right
            setImage("tile044.png");
        }

        if(dir == 4 && timer == 2){  //down
            setImage("tile050.png");
        }

        if(timer == 4){
            setImage("tile040.png");
        }
    }

    public void death()
    {
        Red red = getWorld().getObjects(Red.class).get(0);
        Pink pink = getWorld().getObjects(Pink.class).get(0);
        Cyan cyan = getWorld().getObjects(Cyan.class).get(0);
        Orange orange = getWorld().getObjects(Orange.class).get(0);
        dying = true;
        if(BigDot.crazed){
            ghostsEaten++;
            if(ghostsEaten == 1){
                Dot.score += 200;
            }
            else if(ghostsEaten == 2){
                Dot.score += 400;
            }
            else if(ghostsEaten == 3){
                Dot.score += 800;
            }
            else if(ghostsEaten == 4){
                Dot.score += 1600;
            }
            if(Dot.score > Dot.highScore){
                Dot.highScore = Dot.score;
                getWorld().showText(Dot.highScore + "", 24, 2);
            }
            getWorld().showText(Dot.score + "", 13, 2);
            if(hitRed){
                red.setLocation(18,15);
            }
            else if(hitPink){
                pink.setLocation(18,15);
            }
            else if(hitCyan){
                cyan.setLocation(18,15);
            }
            else if(hitOrange){
                orange.setLocation(18,15);
            }
            dying = false;
            hitRed = false;
            hitPink = false;
            hitCyan = false;
            hitOrange = false;
            return;
        }

        if(timer == 6){
            setImage("tile057.png");
        }
        if(timer == 12){
            setImage("tile058.png");
        }
        if(timer == 18){
            setImage("tile059.png");
        }
        if(timer == 24){
            setImage("tile060.png");
        }
        if(timer == 30){
            setImage("tile061.png");
        }
        if(timer == 36){
            setImage("tile062.png");
        }
        if(timer == 42){
            setImage("tile063.png");
        }
        if(timer == 48){
            setImage("tile064.png");
        }
        if(timer == 54){
            setImage("tile065.png");
        }
        if(timer == 60){
            setImage("tile066.png");
        }
        if(timer == 66){
            setImage("tile067.png");
        }
        if(timer == 72){
            setImage("tile068.png");
        }
        if(timer >= 73){
            lives--;
            this.setLocation(18,27);
            setImage("tile040.png");
            if(lives == 0){
                setImage("tile068.png");
            }
            if(!getWorld().getObjects(Lives.class).isEmpty()){
                Lives life = getWorld().getObjects(Lives.class).get(0);
                getWorld().removeObject(life);
            }
            dying = false;
            hitRed = false;
            hitPink = false;
            hitCyan = false;
            hitOrange = false;
            dir = 0;
            timer = 0;
        }
    }

    public void gameOver(){
        getWorld().showText("GAME OVER", 18, 18);
        getWorld().showText("SCORE " + Dot.score, 18, 20);
        Greenfoot.stop();
    }
}
