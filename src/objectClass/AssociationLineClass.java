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

        //* 這邊是箭頭的繪製 */
            // Calculate the length and angle of the line
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double sin = dy / D, cos = dx / D;

        // Length of the arrow head lines
        double arrowHeadLength = 10;

        // Calculate the coordinates of the arrow head lines
        int x3 = (int) (x2 - arrowHeadLength * cos - arrowHeadLength * sin);
        int y3 = (int) (y2 - arrowHeadLength * sin + arrowHeadLength * cos);
        int x4 = (int) (x2 - arrowHeadLength * cos + arrowHeadLength * sin);
        int y4 = (int) (y2 - arrowHeadLength * sin - arrowHeadLength * cos);

        // Draw the arrow head lines
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }

    @Override
    public void rename(String text){
    }

    @Override
    public void inside(int px, int py){

    }
}
