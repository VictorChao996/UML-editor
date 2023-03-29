package objectClass;

import java.awt.*;
import java.util.ArrayList;

public class PortClass {
    public int x;
    public int y;
    public int width = 5;
    public int height = 5;

    PortClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
