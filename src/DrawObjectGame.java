import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawObjectGame extends JPanel implements  Runnable{

    private Thread threadT;
    private static boolean gameover= false, keyPress = false;
    private Bird bird = new Bird();
    private Barrier barrier = new Barrier();
    private Score score = new Score();
    private int level = 1;
    private BufferedImage gameoverImg, bg, ground, topBarrier, bottomBarrier, playGame, bubbles;

    public static void setKeyPress(boolean keyPress) {
        DrawObjectGame.keyPress = keyPress;
    }

    public DrawObjectGame(){
        threadT = new Thread(this);
        threadT.start();
    }
    public void paint(Graphics g){
//        g.setColor(Color.cyan);
//        g.fillRect(0,0,getWidth(),getHeight());
        try {
            bg = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\BG.png"));
            ground = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\NenDat.png"));
            playGame = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\playgame.png"));
            bubbles = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\bongbay.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg,0,0,getWidth(),getHeight(),null);
//        g.drawImage(playGame,50,50,100,50,null);
        bird.paint(g);
        g.drawImage(bubbles,bird.getX()+10, bird.getY()-10,20,20,null);
        barrier.paint(g);
//        g.setColor(Color.orange);
//        g.fillRect(0,400,getWidth(),getHeight());
//        g.setColor(Color.green);
//        g.fillRect(0,420,getWidth(),getHeight());
        g.drawImage(ground,0,400,getWidth(),getHeight(),null);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("Điểm số: " + score.getScore(),20,30);
        level = (score.getScore() / 4) +1;
        g.setColor(Color.BLACK);
        g.drawString("Level: " + level,200,30);
        g.setFont(new Font("Magneto Bold",Font.BOLD,20));
        g.setColor(Color.blue);
        g.drawString("Sang Tigo", 20,60);
        g.setColor(Color.GREEN);
        g.drawString("Hang's Kokoro", 200,60);
        if(gameover == true){
            try {
                gameoverImg = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\gameover.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(gameoverImg,50,100,null);
        }
    }
    @Override
    public void run() {

        while (true){
            repaint();
            if(bird.isDeath()){
                gameover = true;
                repaint();
                threadT.stop();
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            barrier.moveLeft(level);
            barrier.comeBack();
            if(keyPress == false){
                bird.increaseY(3);
            }
            score.plusScore();
        }
    }
}
