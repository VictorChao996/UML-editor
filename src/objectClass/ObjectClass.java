
package objectClass;

import java.awt.*;

public abstract class ObjectClass {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean isSelected = false;

    public ObjectClass() {
    }

    public abstract void draw(Graphics g);

    public abstract void rename(String text);

    public abstract void inside(int px, int py);
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    //method to override by basicObject Class
    public PortClass getPort(int x, int y){
        return null;
    }

}
