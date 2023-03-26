
package objectClass;

import java.awt.*;

public abstract class ObjectClass {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;
    public boolean isSelected = false;

    public ObjectClass() {
    }

    public abstract void draw(Graphics g);

    public abstract void rename(String text);

    public abstract void inside(int px, int py);
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
