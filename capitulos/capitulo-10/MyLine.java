import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

    
    public MyLine(){
        super(0, 0, 0, 0, Color.BLACK);
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color ){
        super(x1, y1, x2, y2, color);        
    }   

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
  
    
}