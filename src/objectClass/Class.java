package objectClass;

import java.awt.*;

public class Class extends BasicClass {
    // private int x;
    // private int y;
    private int width = 160;
    private int height = 180;

    public Class(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
        System.out.println("new Class obj");
        create_ports(x,y,width,height);
        setHeight(height);
        setWidth(width);
    }
    @Override
    public void draw(Graphics g) {
        if(isSelected){
            // super.draw(g);
            show_selected(g);
        }
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawRect(x, y, width, height);
        g2D.drawLine(x, y + 60, x + width, y + 60);
        g2D.drawLine(x, y + 120, x + width, y + 120);
        g2D.setFont(new Font("Serif", Font.BOLD, 30));
        g2D.drawString(text, x + 35, y + 50);
        set_ports_pos(x,y,width,height);
    }

}
