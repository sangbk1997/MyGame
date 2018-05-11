import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {
    private static int score =0;
    public static boolean isPlus1 = true, isPlus2 = true, isPlus3 = true, isPlus4 = true;
    private Barrier barrier = new Barrier();
    private Bird bird = new Bird();

    public int getScore() {
        return score;
    }
    public void plusScore(){
        int birdY = bird.getY();
        int birdX = bird.getX();
        if( isPlus1 == true && (birdX > barrier.getX1()+70)){
            if( (birdY > barrier.getH1()) && (birdY+20 < barrier.getH1()+70)){
                score ++;
                isPlus1 = false;
            }
        }
        if( isPlus2 == true && (birdX > barrier.getX2()+70)){
            if( (birdY > barrier.getH2()) && (birdY+20 < barrier.getH2()+70)){
                score ++;
                isPlus2 = false;
            }
        }
        if( isPlus3 == true && (birdX > barrier.getX3()+70)){
            if( (birdY > barrier.getH3()) && (birdY+20 < barrier.getH3()+70)){
                score ++;
                isPlus3 = false;
            }
        }
        if( isPlus4 == true && (birdX > barrier.getX4()+70)){
            if( (birdY > barrier.getH4()) && (birdY+20 < barrier.getH4()+70)){
                score ++;
                isPlus4 = false;
            }
        }

    }

}
