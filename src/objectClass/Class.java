package objectClass;

import java.awt.*;

public class Class extends BasicClass {
    @Override
    public void draw(Graphics g) {
//        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawRect(200,200,160,180);
        g2D.drawLine(200,260,360,260);
        g2D.drawLine(200,320,360,320);
        g2D.setFont(new Font("Serif", Font.BOLD,30));
        g2D.drawString("Word", 235,250);
    }

    @Override
    public void rename() {

    }

    @Override
    public void inside(int px, int py) {

    }


}
