import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Orange extends Actor
{
    int dir = 0;
    int timer = 0;
    int oldX = 0;
    int oldY = 0;
    boolean started = false;
    boolean movingUp =  true;
    public void act() 
    {
        Pacman pm = getWorld().getObjects(Pacman.class).get(0);
        BigDot bigDot = getWorld().getObjects(BigDot.class).get(0);
        if(pm.dying == false){
            Dot dot = getWorld().getObjects(Dot.class).get(0);
            timer++;
            oldX = this.getX();
            oldY = this.getY();
            if(started == false && dot.dotsEaten < 130){
                bounce();
            }
            else if(started == false && dot.dotsEaten >= 130){
                start();
            }
            else if (started == true && bigDot.crazed == false){
                if(dir == 1 && timer >= 6){  //up
                    this.setLocation(this.getX(), this.getY() - 1);
                    timer = 0;
                    setImage("tile030.png");
                }

                if(dir == 2 && timer >= 6){  //left
                    this.setLocation(this.getX() - 1, this.getY());
                    timer = 0;
                    setImage("tile028.png");
                }

                if(dir == 3 && timer >= 6){  //right
                    this.setLocation(this.getX() + 1, this.getY());
                    timer = 0;
                    setImage("tile024.png");
                }

                if(dir == 4 && timer >= 6){  //down
                    this.setLocation(this.getX(), this.getY() + 1);
                    timer = 0;
                    setImage("tile026.png");
                }

                Actor borderH = getOneIntersectingObject(BorderH.class);
                Actor borderV = getOneIntersectingObject(BorderV.class);
                Actor black = getOneIntersectingObject(Black.class);
                if(borderH != null || borderV != null || black != null){
                    this.setLocation(oldX, oldY);
                    setDir();
                }
            }
            else if(started == true && bigDot.crazed == true){
                if(dir == 1 && timer >= 9){  //up
                    this.setLocation(this.getX(), this.getY() - 1);
                    timer = 0;
                }

                if(dir == 2 && timer >= 9){  //left
                    this.setLocation(this.getX() - 1, this.getY());
                    timer = 0;
                    setImage("tile098.png");
                }

                if(dir == 3 && timer >= 9){  //right
                    this.setLocation(this.getX() + 1, this.getY());
                    timer = 0;
                    setImage("tile098.png");
                }

                if(dir == 4 && timer >= 9){  //down
                    this.setLocation(this.getX(), this.getY() + 1);
                    timer = 0;
                }

                Actor borderH = getOneIntersectingObject(BorderH.class);
                Actor borderV = getOneIntersectingObject(BorderV.class);
                Actor black = getOneIntersectingObject(Black.class);
                if(borderH != null || borderV != null || black != null){
                    this.setLocation(oldX, oldY);
                    setRandDir();
                }
            }
            if(getX() == 4 && getY() == 18){
                this.setLocation(31,18);
            }
            if(getX() == 32 && getY() == 18){
                this.setLocation(5,18);
            }
        }
    }

    public void setDir()
    {
        Pacman pm = getWorld().getObjects(Pacman.class).get(0);
        if(dir != 2 && this.getX() >= pm.getX()){
            dir = 2;
        }
        else if (dir != 3 && this.getX() < pm.getX()){
            dir = 3;
        }
        else if(dir != 1 && this.getY() >= pm.getY()){
            dir = 1;
        }
        else if(dir != 4 && this.getY() < pm.getY()){
            dir = 4;
        }
    }

    public void setRandDir()
    {
        dir = Greenfoot.getRandomNumber(4) + 1;
    }

    public void start()
    {
        if((this.getX() == 20 && this.getY() == 17) || (this.getX() == 20 && this.getY() == 19)){
            this.setLocation(20, 18);
        }
        if((this.getX() == 20 && this.getY() == 18) || (this.getX() == 19 && this.getY() == 18)){
            dir = 0;
            if(timer >= 6){  //left
                this.setLocation(this.getX() - 1, this.getY());
                timer = 0;
                setImage("tile028.png");
            }
        }
        else if((this.getX() == 18 && this.getY() == 18) || (this.getX() == 18 && this.getY() == 17) || (this.getX() == 18 && this.getY() == 16) && timer >= 6){
            this.setLocation(this.getX(), this.getY() - 1);
            timer = 0;
            setImage("tile030.png");
        }
        else if(this.getX() == 18 && this.getY() == 15){
            started = true;
            dir = 2;
        }
    }

    public void bounce()
    {
        if(this.getX() == 20 && this.getY() == 18){
            if(timer >= 6 && movingUp == true){  //up
                this.setLocation(this.getX(), this.getY() - 1);
                timer = 0;
                setImage("tile030.png");
            }
            else if(timer >= 6 && movingUp == false){  //down
                this.setLocation(this.getX(), this.getY() + 1);
                timer = 0;
                setImage("tile026.png");
            }
        }
        else if(this.getX() == 20 && this.getY() == 17 ){
            if(timer >= 6){  //down
                this.setLocation(this.getX(), this.getY() + 1);
                timer = 0;
                setImage("tile026.png");
                movingUp = false;
            }
        }
        else if(this.getX() == 20 && this.getY() == 19 ){
            if(timer >= 6){  //up
                this.setLocation(this.getX(), this.getY() - 1);
                timer = 0;
                setImage("tile030.png");
                movingUp = true;
            }
        }
        Dot dot = getWorld().getObjects(Dot.class).get(0);
        if (dot.dotsEaten >= 130){
            this.setLocation(20, 18);
        }
    }
}
