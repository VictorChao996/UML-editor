package objectClass;

import java.awt.*;

public class CompositeClass extends ObjectClass{

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public CompositeClass(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;    
    }

    ObjectClass selectedObj = null;
    
    @Override
    public void draw(Graphics g) {
        System.out.println("x1: "+x1+" y1: "+y1+" x2: "+x2+" y2: "+y2);
        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);
        int alpha = 85;
        g.setColor(new Color(110, 219, 181, alpha));
        g.fillRect(x1, y1, width, height);
        // g.drawRect(x1, y1, width, height);
    }

    @Override
    public void rename(String text) {
        selectedObj.rename(text);
    }

    @Override
    public void inside(int px, int py) {

    }

    public void setX2(int x2){
        this.x2 = x2;
    }

    public void setY2(int y2){
        this.y2 = y2;
    }
}
