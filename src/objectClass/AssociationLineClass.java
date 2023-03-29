package objectClass;

import java.awt.*;

public class AssociationLineClass extends LineClass {


    public AssociationLineClass(PortClass port_1, PortClass port_2){

        connected_ports[0] = port_1;
        connected_ports[1] = port_2;
    }
    
    @Override
    public void draw(Graphics g) {
        // System.out.println("AssociationLine draw");
        //根據兩個port的位置，決定線的起點和終點
        int x1 = connected_ports[0].x;
        int y1 = connected_ports[0].y;
        int x2 = connected_ports[1].x;
        int y2 = connected_ports[1].y;
        g.drawLine(x1, y1, x2, y2);
    }

    @Override
    public void rename(String text){
    }

    @Override
    public void inside(int px, int py){

    }
}
