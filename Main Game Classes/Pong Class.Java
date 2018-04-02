import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JFrame {
     final static int WINDOW_WIDTH = 406;
     final static int WINDOW_HEIGHT = 278;
     
     public() {
          
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
        setVisible(true);
     }
     public static void main(String[] args) {
      new Pong();
          
     }
}
