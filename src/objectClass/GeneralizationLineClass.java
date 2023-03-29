package objectClass;
import java.awt.*;

public class GeneralizationLineClass extends LineClass {
    private int arrowW = 10, arrowH = 10;

    public GeneralizationLineClass(PortClass port_1, PortClass port_2){
        connected_ports[0] = port_1;
        connected_ports[1] = port_2;
    }

    @Override
    public void draw(Graphics g) {
        //根據兩個port的位置，決定線的起點和終點
        int x1 = connected_ports[0].x;
        int y1 = connected_ports[0].y;
        int x2 = connected_ports[1].x;
        int y2 = connected_ports[1].y;
        
        // resetXY_by_ports();
        g.drawLine(x1, y1, x2, y2);
        int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - arrowW, xn = xm, ym = arrowH, yn = -arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.fillPolygon(xpoints, ypoints, 3);
    }

    @Override
    public void rename(String text){
        
    }

    @Override
    public void inside(int px, int py){
        
    }

}
