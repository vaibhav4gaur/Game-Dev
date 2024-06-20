
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class enemy extends sprite{
    int x;
    int y;
    int w;
    int h;
    ImageIcon image;
    public enemy(int x, int speed){
        y = 30;
        this.x = x;
        this.speed = speed;
        w = 200;
        h = 200;
        image = new ImageIcon(enemy.class.getResource("spiderimage.gif"));
    }
    public   void draw(Graphics pen)
    {
        pen.drawImage(image.getImage(),x,y,w,h,null);
    }
    public void move()
    {
        if(y>900){
            y = 0;
        }
        y = y + speed;
    }
}
