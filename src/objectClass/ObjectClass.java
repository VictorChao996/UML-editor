
package objectClass;

import java.awt.*;

public abstract class ObjectClass {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;

    public ObjectClass() {
    }

    public abstract void draw(Graphics g);

    public abstract void rename();

    public abstract void inside(int var1, int var2);

    public void move() {
    }

    protected void setRange(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

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
