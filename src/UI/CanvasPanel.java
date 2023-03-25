package UI;

import objectClass.Class;
import objectClass.ObjectClass;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CanvasPanel extends JPanel {

    //! 所有創立的obj記錄到一個陣列中 (用於重新繪製)
    private ArrayList<ObjectClass> Objs = new ArrayList<>();

    CanvasPanel(Color bgColor, int width, int height) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(width, height));
//        this.addMouseListener(this);
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        Objs.add(new Class());
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            obj.draw(g);
        }
//        g2D.drawRect(200,200,160,180);
//        g2D.drawLine(200,260,360,260);
//        g2D.drawLine(200,320,360,320);
//        g2D.setFont(new Font("Serif", Font.BOLD,30));
//        g2D.drawString("Word", 235,250);

    }
}
