import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Panel extends GamePanel
{
    int dinoHeight = 55, dinoWidth =25;
    Dino dino = new Dino(Main.width/4,Main.height-dinoHeight, dinoWidth, dinoHeight,null, Color.black);
    int tracker =0  ;
    boolean cactus = true, flyer= true,spawn = true ;
    long time ;
    static ArrayList<Obstacle> obstacles = new ArrayList<>();
    char[] possible = {'o', 'c','f', 'b'};
    static ArrayList<Dino> dinos = new ArrayList();
    static int score =0 ;




    Panel()
    {
        this.setBackground(Color.white);
        dinos.add(dino);

        time = (System.currentTimeMillis()/1000)%10;
        this.start();
    }

    public void spawn()
    {
        if(time!=(System.currentTimeMillis()/1000)%10)
        {
            time = (System.currentTimeMillis()/1000)%10;
            if(tracker <3)
                tracker++;
            else
                score++;
            int index = (int)((Math.random()*possible.length));
            switch(index)
            {
                case 0:
                    obstacles.add(new Obstacle());
                    break;
                case 1:
                    obstacles.add(new Cactus());
                    break;
                case 2 :
                    obstacles.add(new Flyer());
                    break;
                case 3:
                    obstacles.add((new Blimp()));
                    break;
            }
        }
    }

    @Override
    public void update()
    {
        spawn();
        



        for(int i =0; i<dinos.size(); i++)
        {
            dinos.get(i).update();
        }

        for(int i =0; i<obstacles.size();i++ )
        {
            obstacles.get(i).update();
        }

    }

    @Override
    public void paint(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;
        g1.setFont(new Font("DialogInput",Font.BOLD,30));
        g1.drawString(String.valueOf(score),15,20);
        for(int i =0; i<dinos.size(); i++)
        {
            dinos.get(i).draw(g);
        }

        for(int i =0; i<obstacles.size(); i++)
        {
            obstacles.get(i).draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_SPACE&&dino.y==Main.height-dino.height)
        {
            dino.jump();
        }
        if(e.getKeyCode()==KeyEvent.VK_S&&dino.y==Main.height-dino.height&&!dino.isCrouching())
        {
            dino.crouch();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode()==KeyEvent.VK_S)
        {
            dino.uncrouch();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
