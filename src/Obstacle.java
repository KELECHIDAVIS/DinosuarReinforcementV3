import java.awt.*;

public class Obstacle
{
    int x , y, width, height ;
    Color color ;
    float velx=0 , speed=4f; // speed increases after every level

    Rectangle bounds ;
    public Obstacle( int y, int width , int height )
    {
        this.y = y ;
        this.width = width ;
        this.height = height ;
        this.x = Main.width;
        this.color = Color.black ; //change for each
        bounds = new Rectangle(x,y,width,height);

    }
    Obstacle()
    {
        this(Main.height-30,25,30);
    }

    void draw(Graphics g)
    {
         g.setColor(color);
         g.fillRect(x,y,width,height);
    }

    void update()
    {

       x -=speed;

       if(x<-width-400)
       {
           // it should just delete itself from the list
           Panel.obstacles.remove(this);
       }

       bounds = new Rectangle(x,y,width,height);
    }

}
