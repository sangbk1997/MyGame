import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends JPanel {

    private static int Y = 100;
    private static int X = 100;
    private static int range = 3;
    private BufferedImage bird;
    private Barrier barrier = new Barrier();

    @Override
    public int getY() {
        return Y;
    }
    public int getX(){return X;}

    public void paint(Graphics g){
//        g.setColor(Color.red);
//        g.fillRect(X, Y,20,20);
        try {
            bird = ImageIO.read(new File("F:\\Practice_JAVA\\MyFlappyBird\\res\\Bird.png"));
            g.drawImage(bird,X,Y,20,20,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void increaseY(int y){
        Y +=y;
    }
    public void decreaseY(){
        Y -=20;
    }

    public boolean isDeath(){
        // khi cham bay qua cao hoac cham dat
        if(Y <0 || (Y+20) > 405){
            return true;
        }

        // Kiem tra khi chim cham vao ong nuoc thu 1
        if(Y < (barrier.getH1()-range) && ((X+20) > barrier.getX1()+range) && (X< barrier.getX1()+60 -range)){
            return true;
        }
        if((Y+20) > (barrier.getH1()+70+range) && ((X+20) > barrier.getX1()+range) && (X < barrier.getX1()+60-range)){
            return true;
        }

        // Kiem tra khi chim cham vao ong nuoc 2
        if(Y < (barrier.getH2()-range) && ((X+20) > barrier.getX2()+range) && (X< barrier.getX2()+60 -range)){
            return true;
        }
        if((Y+20) > (barrier.getH2()+70+range) && ((X+20) > barrier.getX2()+range) && (X < barrier.getX2()+60-range)){
            return true;
        }
        // Kiem tra khi chim cham vao ong nuoc thu 3
        if(Y < (barrier.getH3()-range) && ((X+20) > barrier.getX3()+range) && (X< barrier.getX3()+60-range)){
            return true;
        }
        if((Y+20)> (barrier.getH3()+70+range) && ((X+20) > barrier.getX3()+range) && (X < barrier.getX3()+60-range)){
            return true;
        }
        // Kiem tra khi chim cham vao ong nuoc thu 4
        if(Y < (barrier.getH4()-range) && ((X+20) > barrier.getX4()+range) && (X< barrier.getX4()+60-range)){
            return true;
        }
        if((Y+20) > (barrier.getH4()+70+range) && ((X+20) > barrier.getX4()+range) && (X < barrier.getX4()+60-range)){
            return true;
        }

        return false;

    }

}
