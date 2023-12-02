import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class player extends Actor
{
    int _idleImageNum = 8;
    int _walksImageNum = 8;

    String state = "idle";
    
    public String getState()
    {
        return this.state;    
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public player()
    {
        this.setImage(new GreenfootImage("/player/idle/1.png"));
    }
    int _animationDelay = 10;
    int _animationTimer = 0;
    int _lastSpriteNo = 0;
    Boolean moveFoward = true;
    void animate()
    {
        if (_animationTimer<_animationDelay)
        {
            _animationTimer++;
            return;
        }
        _animationTimer = 0;
        String path = "";
        switch(this.state)
        {
            case "idle" : {path = "/player/idle/"+_lastSpriteNo%_idleImageNum+".png"; break;}
            case "walks" : {path = "/player/walks/"+_lastSpriteNo%_walksImageNum+".png"; break;}
            default: {path = "/player/idle/"; break;}
        }
        _lastSpriteNo++;
        GreenfootImage img = (new GreenfootImage(path));
        if(moveFoward)
        {
            this.setImage(new GreenfootImage(path));
            return;
        }
        img.mirrorHorizontally();
        this.setImage(img);
    }
    
    void controlplayer()
    {
        if(Greenfoot.isKeyDown("right")) 
        {
            this.moveFoward = true;
            this.state = "walks";
            this.setLocation(this.getX()+2, this.getY());
            return;
        }
        if(Greenfoot.isKeyDown("left")) 
        {
            this.moveFoward = false;
            this.state = "walks";
            this.setLocation(this.getX()-2, this.getY());
            return;
        }
        this.state = "idle";
    }
    
    public void act()
    {
        controlplayer();
        animate();
    }
}
