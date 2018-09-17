package models;


import java.awt.Color;
import java.awt.Graphics;


public class Food {
    private int x;
    private int y;
    private static final int size = 20;
    
    public Food(int x, int y){
        this.x = 40;
        this.y = 100;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, size, size);
    }
    
    public void generate(int sw, int sh){
        sw -= size;
        sh -= size;
        this.x = (int)((Math.random() * (sw/size))) * size - size;
        this.y = (int)((Math.random() * (sh/size))) * size - size;
        if(this.x < 0) this.x += size;
        else if(this.x < 0 ) this.x += size;
        else if(this.y < 0 ) this.y += size;
        System.out.println("X: " + this.x + " Y: " +this.y);
    }
    //(((1 * (480/20))*20) - 20) = ((24 * 20))-20= 480 - 20 = 460; 
    //(((1 * (640/20))*20) - 20) = ((24 * 20))-20= 640 - 20 = 660; 
    //(((0 * (480/20))*20) - 20) = ((0 * 20))-20= 480 - 20 = 460; 
    //(((0 * (640/20))*20) - 20) = ((0 * 20))-20= - 20 = -20 + 20; 
        
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public static int getSize() {
        return size;
    }

}
