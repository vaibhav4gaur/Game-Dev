import javax.swing.JFrame;

public class GameFrame extends JFrame
{
    public GameFrame(){
        board board = new board();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Dev in Java");

        setSize(1500,920);
        setResizable(false);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);


    }
    public static void main(String[] args)
     {
         new GameFrame();
    
    }
}