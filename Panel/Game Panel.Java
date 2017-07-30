import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel
implements ActionListener, KeyListener {
       Player player = new Player();
       Ball ball = new Ball();
       Computer computer = new Computer(this);
       public GamePanel() {
          Timer time = new Timer(50, this);
          time.start();
          this.addKeyListener(this);
          this.setFocusable(true);
       }
       private void update() {
          player.update();
          ball.update();
          computer.update();
          ball.checkCollisionWith(player);
          ball.checkCollisionWith(computer);
          ball.hitWall();
      }
      public void paintComponent(Graphics g) {
          g.setColor(Color.black);
          g.fillRect(0, 0, Pong.WINDOW_WIDTH, Pong.WINDOW_HEIGHT);
          player.paint(g);
          ball.paint(g);
          computer.paint(g);
          g.setColor(Color.blue);
          g.drawLine(0, 30, Pong.WINDOW_WIDTH, 30);
          g.drawLine(Pong.WINDOW_WIDTH / 2, 30, Pong.WINDOW_WIDTH / 2, Pong.WINDOW_HEIGHT);
          g.drawOval((Pong.WINDOW_WIDTH / 2) - 30, Pong.WINDOW_HEIGHT / 2 - 30, 60, 60);
          g.setColor(Color.yellow);
          
     }
     public Ball getBall() {
         return ball;
     }
     public void actionPerformed(ActionEvent e) {
         update();
         repaint();
     }
     public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setYVelocity(-5);
            if (player.getY() < 30) {
                player.setYVelocity(0);
            }
         } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setYVelocity(5);
            if (player.getY() + 40 > Pong.WINDOW_HEIGHT - 28) {
                player.setYVelocity(0);
            }
         }
     }
    public void keyReleased(KeyEvent e) {
         int keyCode = e.getKeyCode();
         if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
             player.setYVelocity(0);
         }
     }
     public void keyTyped(KeyEvent e) {
     }
}
