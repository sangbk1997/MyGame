import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Index extends JFrame {
    private DrawObjectGame drawObjectGame = new DrawObjectGame();
    private Bird bird = new Bird();
    public Index(){
        setSize(1000,500);
        setVisible(true);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(drawObjectGame);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(bird.getY() > 0){
                    bird.decreaseY();
                    DrawObjectGame.setKeyPress(true);
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                DrawObjectGame.setKeyPress(false);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(bird.getY() > 0){
                    bird.decreaseY();
                    DrawObjectGame.setKeyPress(true);
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                DrawObjectGame.setKeyPress(false);
            }
        });

    }

    public static void main(String[] args) {
        Index obj = new Index();
    }
}
