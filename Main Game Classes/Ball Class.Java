import java.awt.Color;
import java.awt.Graphics;
import java.awt.JOptionPane;
public class Ball {
    private int x = Pong.WINDOW_WIDTH / 2;
    private int y = Pong.WINDOW_HEIGHT / 2;
    private int xVelocity = -4;
    private int xVelocity = 4;
    private int size = 5;
    private int playerScore = 0;
    private int computerScore = 0;
    public void update() {
        x = x + xVelocity;
        y = y + yVelocity;
        if (x < 0) {
            xVelocity = 4;
            computerScore = computerScore + 1;
        } else if (x + size > Pong.WINDOW_WIDTH - 6) {
            xVelocity = -4;
            playerScore = playerScore + 1;
        }
        if (y < 0) {
            yVelocity = 4;
        } else if (y + size > Pong.WINDOW_HEIGHT - 28) {
            yVelocity = -4;
        }
    }
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, size, size);
        g.drawString(toPlayer(), 5, 15);
        g.drawString(toComputer(), 280, 15);
    }
    private void reverseDirection() {
        xVelocity = -xVelocity;
    }
    private void reverseDirectionY() {
        yVelocity = -yVelocity;
    }
    public void checkCollisionWith(Player player) {
        if (this.x > player.getX() && this.x < player.getX() + player.getWidth()) {
            if (this.y > player.getY() && this.y < player.getY() + player.getHeight()) {
                //ball has collided with player
                reverseDirection();
            }
        }
    }
    public void hitWall() {
        if (this.y < 30) {
            reverseDirectionY();
        }
    }
    public void checkCollisionWith(Computer computer) {
        if (this.x > computer.getX() && this.x < computer.getX() + computer.getWidth()) {
            if (this.y > computer.getY() && this.y < computer.getY() + computer.getHeight()) {
                //ball has collided with computer
                reverseDirection();
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public String toPlayer() {
        String retVal = "";
        retVal = "Player Score: " + playerScore;
        return retVal;
    }

    public String toComputer() {
        String retVal = "";
        retVal = "Computer Score: " + computerScore;
        return retVal;
    }
}
       
