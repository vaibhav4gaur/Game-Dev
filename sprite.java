import javax.swing.ImageIcon;
import java.awt.Graphics;


public abstract class sprite {
    public int speed;
    public int x;
    public int y;
     public int w;
    public int h;
    public ImageIcon image;
    public void draw(Graphics pen)
    {
        pen.drawImage(image.getImage(),x,y,w,h,null);
    }
}
