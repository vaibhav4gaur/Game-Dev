
import javax.swing.ImageIcon;
import java.awt.Graphics;



public class player extends sprite {
    // int x;
    // int y;
    // int w;
    // int h;
    // ImageIcon image;

    public player(){
         w = 200;
         h = 200;
         x = 50;
         y = 450;
         image = new ImageIcon(player.class.getResource("player.gif"));
    }
    public void move(){
        x = x + speed;
    }
    public boolean outOfScreen(){
        return x>1500;
    }
    public void draw(Graphics pen){
       pen.drawImage(image.getImage(), x,y,w,h, null);
    }
}
