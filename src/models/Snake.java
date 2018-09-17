package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;

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
    private static final int size = 20;  

    //Contructor
    public Snake(){
        
        b = new ArrayList<Body>();
        b.add(new Body(0,0)); //initialize the snake head at 1,1 , so b[0] is at 1,1
    }
    
    //draw each body element
    public void draw(Graphics g){
        
        for(int i = 0; i < b.size(); i++){
            if(i == 0)
                g.setColor(Color.green);
            else
                g.setColor(Color.black);
            g.fillRect(b.get(i).x, b.get(i).y, size, size);
        }
    }
    
    
    public void move(){
        Body head = b.get(0);
        int previousX, previousY;
        //move the rest of the body, each body element will take the previous element position
        for(int i = b.size()-1; i > 0; i--){
            b.get(i).x = b.get(i-1).x;
            b.get(i).y = b.get(i-1).y;
        }
        
        if(direction == "LEFT")
            head.x -= size;
        else if(direction == "RIGHT")
            head.x += size;
        else if(direction == "UP")
            head.y -= size;
        else if(direction == "DOWN")
            head.y += size;

        System.out.println("X: " + head.x + "Y : " + head.y);
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
        
        if(direction == "LEFT")       b.add(new Body(previousX+size, previousY));
        else if(direction == "RIGHT") b.add(new Body(previousX-size, previousY));
        else if(direction == "UP")    b.add(new Body(previousX, previousY+size));
        else if(direction == "DOWN")  b.add(new Body(previousX, previousY-size));
        System.out.println(b.size());
           
    }
    public boolean checkColisionBody(){
        
        for(int i = 1;i < b.size(); i++)
            if( b.get(0).x == b.get(i).x && b.get(0).y == b.get(i).y )
                return true;
        
        return false;
    }
    public boolean checkColisionWall(int sw, int sh){
        
        if(b.get(0).x >= sw-size || b.get(0).x < 0 || b.get(0).y >= sh-size || b.get(0).y < 0)
            return true;
        return false;
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
