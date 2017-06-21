import java.awt.Color;
import java.awt.Graphics;
public class Computer {
    private GamePanel field;
    private int y = Pong.WINDOW_HEIGHT / 2;
    private int yVelocity = 0;
    private int width = 10;
    private int height = 40;
    public Computer(GamePanel game) {
        this.field = game;
    }
    public void update() {
        if (field.getBall().getY() < this.y) {
            //ball is above a computer
            yVelocity = - 3;
        } else if (field.getBall().getY() > this.y) {
            yVelocity = 3;
        }
        y = y + yVelocity;
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(Pong.WINDOW_WIDTH - (35 + width), y, width, height);
    }
    public int getX() {
        return Pong.WINDOW_WIDTH - 6 - (35 + width);
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
