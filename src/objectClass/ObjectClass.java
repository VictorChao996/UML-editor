
package objectClass;

public abstract class ObjectClass {
    protected int x1;
    protected int y1;
    protected int x2;
    protected int y2;

    public ObjectClass() {
    }

    public abstract void draw();

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

    protected void getX1() {
    }

    protected void getY1() {
    }

    protected void getX2() {
    }

    protected void getY2() {
    }
}
