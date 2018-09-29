package models;


import java.awt.Color;
import java.awt.Graphics;


public class Food {
    private int x;
    private int y;
    private static final int SIZE = 20;
    
    public Food(int x, int y){
        this.x = 40;
        this.y = 100;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, SIZE, SIZE);
    }
    
    public void generate(int sw, int sh){
        sw -= SIZE;
        sh -= SIZE;
        this.x = (int)((Math.random() * (sw/SIZE))) * SIZE - SIZE;
        this.y = (int)((Math.random() * (sh/SIZE))) * SIZE - SIZE;
        if(this.x < 0) this.x += SIZE;
        else if(this.x < 0 ) this.x += SIZE;
        else if(this.y < 0 ) this.y += SIZE;
        System.out.println("X: " + this.x + " Y: " +this.y);
    }
    
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
        return SIZE;
    }

}
