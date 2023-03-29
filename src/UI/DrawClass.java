package UI;
import objectClass.ObjectClass;

import java.awt.*;
public class DrawClass extends ObjectClass {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public DrawClass(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    @Override
    public void draw(Graphics g){
        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);
        int alpha = 85;
        g.setColor(new Color(110, 219, 181, alpha));
        g.fillRect(x1, y1, width, height);
    }

    public void setX2(int x2){
        this.x2 = x2;
    }

    public void setY2(int y2){
        this.y2 = y2;
    }

    @Override
    public void rename(String text) {

    }

    @Override
    public void inside(int px, int py) {

    }
}
