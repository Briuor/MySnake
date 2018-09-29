
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args){
        Game game = new Game();
        JFrame window = new JFrame();
        window.add(game);
        window.setSize(game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
