package models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
        
    //Snake body structure , each body has coordinates x and y
    public class Body{
        public int x;
        public int y;
        
        public Body(int x, int y){
            this.x = x;
            this.y = y;
        }
    };
    
    private ArrayList<Body> b; // array of body, body[0] is the snake head
    private String direction;  // the snake direction left, top, right, bottom 
    private static final int SIZE = 20;  
    private static final int SPEED = 20;  

    //Contructor
    public Snake(){
        
        b = new ArrayList<Body>();
        b.add(new Body(0,0)); //initialize the snake head at 0,0 , so b[0] is at 0,0
    }
    
    //draw each body element
    public void draw(Graphics g){
        
        for(int i = 0; i < b.size(); i++){
            if(i == 0) // if body element is the head color is green
                g.setColor(Color.green);
            else
                g.setColor(Color.black);
            g.fillRect(b.get(i).x, b.get(i).y, SIZE, SIZE);
        }
    }
    
    public void move(){
        Body head = b.get(0);
        //move the rest of the body, each body element will take the previous element position
        for(int i = b.size()-1; i > 0; i--){
            b.get(i).x = b.get(i-1).x;
            b.get(i).y = b.get(i-1).y;
        }
        
        //Move snake head
        if(direction == "LEFT")        head.x -= SPEED;
        else if(direction == "RIGHT")  head.x += SPEED;
        else if(direction == "UP")     head.y -= SPEED;
        else if(direction == "DOWN")   head.y += SPEED;
    }
    
    public boolean verifyEat(Food food){
        Body head = b.get(0);

        if( head.x == food.getX() && head.y == food.getY() ){
            incrementBody();
            return true;
        }
        return false;
    }

    public void incrementBody(){
        int previousX = b.get(b.size() - 1).x;
        int previousY = b.get(b.size() - 1).y;
        
        if(direction == "LEFT")       b.add(new Body(previousX+SIZE, previousY));
        else if(direction == "RIGHT") b.add(new Body(previousX-SIZE, previousY));
        else if(direction == "UP")    b.add(new Body(previousX, previousY+SIZE));
        else if(direction == "DOWN")  b.add(new Body(previousX, previousY-SIZE));
    }
    
    public boolean checkColisionBody(){
        Body head = b.get(0);
        for(int i = 1;i < b.size(); i++) {
            if( head.x == b.get(i).x && head.y == b.get(i).y )
                return true;
        }
        return false;
    }
    
    public boolean checkColisionWall(int sw, int sh){
        Body head = b.get(0);
        return head.x >= sw-SIZE || head.x < 0 || head.y >= sh-2*SIZE || head.y < 0;
    }

    //-----------------------------------GETTERS AND SETTERS--------------------------------
    public ArrayList<Body> getB() {
        return b;
    }

    public void setB(ArrayList<Body> b) {
        this.b = b;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
