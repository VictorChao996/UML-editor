

package objectClass;

import java.awt.*;

public class LineClass extends ObjectClass {
    // public int x1 = x;
    // public int y1 = y;
    // public int x2;
    // public int y2;
    PortClass[] connected_ports = new PortClass[2];

    public LineClass() {
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Line Draw");
    }

    @Override
    public void rename(String text) {
        System.out.println("Line Rename");
    }

    @Override
    public void inside(int px, int py) {
        System.out.println("Line Inside");
    }


    // /**
    //  * * 設定與這條線相連的兩個Port
    //  */
    // public void setConnectPorts(PortClass port_1, PortClass port_2){
    //     this.connected_ports[0] = port_1;
    //     this.connected_ports[1] = port_2;
    // }
}
