
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class board extends JPanel{
    Timer timer;
    BufferedImage backgroundImage;
    player player;
    enemy enemies[] = new enemy[3];
    public board(){
     setSize(1500,920);
     loadBackgroundImage();
     player = new player();
     loadEnemies();
     gameLoop();
     bindEvents();
     setFocusable(true);

    }
    private void gameOver(Graphics pen)
    {
        if(player.outOfScreen()){
            pen.setFont(new Font("times",Font.BOLD,30));
                pen.setColor(Color.RED);
                pen.drawString("Game Win",1500/2,900/2);
                timer.stop();
                return;
        }
        for(enemy enemy : enemies){
            if(isCollide(enemy)){
                pen.setFont(new Font("times",Font.BOLD,30));
                pen.setColor(Color.RED);
                pen.drawString("Game Over",1500/2,900/2);
                timer.stop();
            }
        }
    }
    private boolean isCollide(enemy enemy){
        {
             int xDistance = Math.abs(player.x - enemy.x);
             int yDistance = Math.abs(player.y - enemy.y);
             int maxH = Math.max(player.h,enemy.h);
             int maxW = Math.max(player.w,enemy.w);
             return xDistance <= maxW-80 && yDistance <= maxH-80;
        }
    }
    private void bindEvents()
    {
        addKeyListener( new KeyListener() {
            public void keyTyped(KeyEvent e)
            {

            }
            public void keyReleased(KeyEvent e)
            {
                player.speed = 0;
            }
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                player.speed = 10;
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    player.speed = -10;
                }
            }
         
        });
    }
    private void loadEnemies(){
        int x = 400;
        int gap = 300;
        int speed = 5;
        for(int i=0; i<enemies.length;i++){
        enemies[i] = new enemy(x,speed);
        x = x + gap;
        speed = speed + 5;
        }
    }
    private void gameLoop()
    {
        timer = new Timer(50,(e)->repaint());
        timer.start();
    }
    private void loadBackgroundImage(){
        try {
           backgroundImage =  ImageIO.read(board.class.getResource("game-bg.jpeg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Background-Image Not Found.....");
            System.exit(1);
            e.printStackTrace();
        }
    }
    private void printEnemies(Graphics pen)
    {
        for(enemy enemy : enemies){
            enemy.draw(pen);
            enemy.move();
        }
    }

    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);
        pen.drawImage(backgroundImage,0,0,1500,920,null);
        player.draw(pen);
        player.move();
        printEnemies(pen);
        gameOver(pen);
    }
}
