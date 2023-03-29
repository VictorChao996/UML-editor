package objectClass;
import java.awt.*;

public class CompositionLineClass extends LineClass {

    private int diamondW = 10, diamondH = 10;


    public CompositionLineClass(PortClass port_1, PortClass port_2) {
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

        g.drawLine(x1, y1, x2, y2);
        int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - diamondW, xn = xm, ym = diamondH, yn = -diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;
        
        // 分點公式算出線上的點, 三角形的三個點與這個點連線即為一個菱形
        double xq = (diamondH*2/D)*x1 + ((D-diamondH*2)/D)*x2;
        double yq = (diamondH*2/D)*y1 + ((D-diamondH*2)/D)*y2;
   
        int[] xpoints = {x2, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yq, (int) yn};

        g.fillPolygon(xpoints, ypoints, 4);
    }

    @Override
    public void rename(String text){
    }

    @Override
    public void inside(int px, int py){
    }
}
