
package objectClass;

import java.awt.*;

public abstract class ObjectClass {
    protected int x;
    protected int y;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
