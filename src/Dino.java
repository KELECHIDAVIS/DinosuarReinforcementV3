import java.awt.*;

public class Dino
{
    Color color ;
    int x, y , width , height ;
    private float grav = .65f;
    private float vely=0 , jumpHeight = -12;
    private NeuralNetwork brain ;
    Dino parent ;
    int originalsize;



    private boolean crouching =false;
    Dino(int x, int y , int width , int height , Dino parent, Color color )
    {

        this.x = x ;
        this.y  = y;
        this.width = width ;
        this.height = height ;
        this.color= color;
        this.parent = parent ;
        originalsize = height;
    }

    void draw(Graphics g )
    {
        g.setColor(color );
        g.fillRect(x,y,width,height);
    }

    void update()
    {
        vely+=grav;
        y+=vely;
        if(y>Main.height-height)
        {
            vely =0;
            y=Main.height-height;
        }
        for(Obstacle o : Panel.obstacles)
        {
            Rectangle bounds = new Rectangle(x,y,width, height);

            if(bounds.intersects(o.bounds))
            {
                Panel.dinos.remove(this);
            }

        }
    }
    void jump()
    {
        vely+=jumpHeight;
    }
    void crouch()
    {
        height/=2;
        crouching = true;
        y= Main.height- height;
    }
    void uncrouch()
    {
        height= originalsize;
        crouching = false;
        y = Main.height-height;
    }

    void decide()
    {
        //inputs
        // outputs: jump, crouch, nothing
    }


    public boolean isCrouching()
    {
        return crouching;
    }

    public void setCrouching(boolean crouching)
    {
        this.crouching = crouching;
    }

}
