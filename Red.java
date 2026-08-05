import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Red extends Actor
{
    int dir = 0;
    int timer = 0;
    int crazeTimer = 0;
    int oldX = 0;
    int oldY = 0;
    public void act() 
    {
        Pacman pm = getWorld().getObjects(Pacman.class).get(0);
        BigDot bigDot = getWorld().getObjects(BigDot.class).get(0);
        Pink pink = getWorld().getObjects(Pink.class).get(0);
        Cyan cyan = getWorld().getObjects(Cyan.class).get(0);
        Orange orange = getWorld().getObjects(Orange.class).get(0);
        timer++;
        if(pm.dying == false && bigDot.crazed == false){
            oldX = this.getX();
            oldY = this.getY();
            if(dir == 1 && timer >= 6){  //up
                this.setLocation(this.getX(), this.getY() - 1);
                timer = 0;
                setImage("tile006.png");
            }

            if(dir == 2 && timer >= 6){  //left
                this.setLocation(this.getX() - 1, this.getY());
                timer = 0;
                setImage("tile004.png");
            }

            if(dir == 3 && timer >= 6){  //right
                this.setLocation(this.getX() + 1, this.getY());
                timer = 0;
                setImage("tile000.png");
            }

            if(dir == 4 && timer >= 6){  //down
                this.setLocation(this.getX(), this.getY() + 1);
                timer = 0;
                setImage("tile002.png");
            }

            Actor borderH = getOneIntersectingObject(BorderH.class);
            Actor borderV = getOneIntersectingObject(BorderV.class);
            Actor black = getOneIntersectingObject(Black.class);
            if(borderH != null || borderV != null || black != null){
                this.setLocation(oldX, oldY);
                setDir();
            }
        }
        else if(pm.dying == false && bigDot.crazed == true){
            crazeTimer++;
            oldX = this.getX();
            oldY = this.getY();
            if(dir == 1 && timer >= 9){  //up
                this.setLocation(this.getX(), this.getY() - 1);
                timer = 0;
                //setImage("tile098.png");
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
            if(crazeTimer == 200){//flash image for all ghosts
                this.setImage("tile100.png");
                if(pink.started == true){
                    pink.setImage("tile100.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile100.png");
                }
                if(orange.started == true){
                    orange.setImage("tile100.png");
                }
            }
            else if(crazeTimer == 215){
                this.setImage("tile098.png");
                if(pink.started == true){
                    pink.setImage("tile098.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile098.png");
                }
                if(orange.started == true){
                    orange.setImage("tile098.png");
                }
            }
            else if(crazeTimer == 230){
                this.setImage("tile100.png");
                if(pink.started == true){
                    pink.setImage("tile100.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile100.png");
                }
                if(orange.started == true){
                    orange.setImage("tile100.png");
                }
            }
            else if(crazeTimer == 245){
                this.setImage("tile098.png");
                if(pink.started == true){
                    pink.setImage("tile098.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile098.png");
                }
                if(orange.started == true){
                    orange.setImage("tile098.png");
                }
            }
            else if(crazeTimer == 260){
                this.setImage("tile100.png");
                if(pink.started == true){
                    pink.setImage("tile100.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile100.png");
                }
                if(orange.started == true){
                    orange.setImage("tile100.png");
                }
            }
            else if(crazeTimer == 275){
                this.setImage("tile098.png");
                if(pink.started == true){
                    pink.setImage("tile098.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile098.png");
                }
                if(orange.started == true){
                    orange.setImage("tile098.png");
                }
            }
            else if(crazeTimer == 290){
                this.setImage("tile100.png");
                if(pink.started == true){
                    pink.setImage("tile100.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile100.png");
                }
                if(orange.started == true){
                    orange.setImage("tile100.png");
                }
            }
            else if(crazeTimer == 305){
                this.setImage("tile098.png");
                if(pink.started == true){
                    pink.setImage("tile098.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile098.png");
                }
                if(orange.started == true){
                    orange.setImage("tile098.png");
                }
            }
            else if(crazeTimer == 320){
                this.setImage("tile100.png");
                if(pink.started == true){
                    pink.setImage("tile100.png");
                }
                if(cyan.started == true){
                    cyan.setImage("tile100.png");
                }
                if(orange.started == true){
                    orange.setImage("tile100.png");
                }
            }
            else if(crazeTimer == 335){
                bigDot.crazed = false;
                crazeTimer = 0;
            }
        }
        if(getX() == 4 && getY() == 18){
            this.setLocation(31,18);
        }
        if(getX() == 32 && getY() == 18){
            this.setLocation(5,18);
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
}
