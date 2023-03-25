package objectClass;

import java.awt.*;

public class Class extends BasicClass {
    private int x;
    private int y;
    private int width = 160;
    private int height = 180;

    public Class(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
        System.out.println("new Class obj");
        create_ports(x,y,width,height);
    }
    @Override
    public void draw(Graphics g) {
        if(isSelected)
            super.draw(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawRect(x, y, width, height);
        g2D.drawLine(x, y + 60, x + width, y + 60);
        g2D.drawLine(x, y + 120, x + width, y + 120);
        g2D.setFont(new Font("Serif", Font.BOLD, 30));
        g2D.drawString(text, x + 35, y + 50);
    }

    @Override
    public void rename() {

    }

    // @Override
    // public void inside(int px, int py) {
    //     if(px >= x && px <= x+width && py >= y && py <= y+height){
    //         System.out.println(this);
    //         System.out.println("inside");
    //         isSelected = true;
    //     }else{
    //         System.out.println("outside");
    //         isSelected = false;
    //     }
//    }


}
