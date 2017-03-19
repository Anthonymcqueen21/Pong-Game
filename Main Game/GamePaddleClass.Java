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
      
