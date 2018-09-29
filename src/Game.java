
import models.Food;
import models.Snake;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener{
    
    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;
    private static final int DELAY = 100;
    
    private boolean pause;
    private int score;
    
    private Timer t;
    private KeyListener keyListener;
    private Snake snake;
    private Food food;
    
    public Game(){
        initEntities();
        createKeyListener();
        initGamePanel();
        start();
    }
    
    public void initEntities(){
        snake = new Snake();
        food = new Food((int)(SCREEN_WIDTH * Math.random()), (int)(SCREEN_HEIGHT * Math.random()));
    }
    
    public void initGamePanel(){
        addKeyListener(keyListener);
        setFocusable(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    //Starts the Thread that perform the actionPerformed method each DEALY(5 ns)
    public void start(){
        pause = false;
        score = 0;
        t = new Timer(DELAY, this);
        t.start();
    }
    
    //Draw entities and score
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Score: " + score, 480, 20);
        food.draw(g);
        snake.draw(g); 
    }
    
    //check collision with the wall and snake body
    public boolean checkColision(){
        return snake.checkColisionWall(SCREEN_WIDTH, SCREEN_HEIGHT) || snake.checkColisionBody();
    }
    
    //This method represents the game loop
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(snake.verifyEat(food)) {
            food.generate(SCREEN_WIDTH, SCREEN_HEIGHT);
            score += 10;
        }
        
        snake.move();
        
        if(checkColision() || pause)
            t.stop();
        
        repaint();
    }
    
    //initialize the keyListener 
    public void createKeyListener(){
        
        keyListener = new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {  }
            
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch(keyCode){
                    case KeyEvent.VK_LEFT:
                        snake.setDirection("LEFT");
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.setDirection("RIGHT");
                        break;
                    case KeyEvent.VK_UP:
                        snake.setDirection("UP");
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.setDirection("DOWN");
                        break;
                    case KeyEvent.VK_SPACE:
                        if(!pause) pause = true;
                        else {
                            t.restart();
                            pause = false;
                        }
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) { }
        };
    }
}
