package UI;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintStream;
import javax.swing.JPanel;

public class MyCustomPanel extends JPanel implements MouseListener {
    private String panelName;

    MyCustomPanel(Color bgColor, int width, int height, String panelName) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
        this.panelName = panelName;
    }

    MyCustomPanel(int width, int height, String panelName) {
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
        this.panelName = panelName;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(this.panelName);
        PrintStream var10000 = System.out;
        int var10001 = e.getX();
        var10000.println("" + var10001 + " " + e.getY());
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
