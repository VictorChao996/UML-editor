package UI;

import objectClass.Class;
import objectClass.ObjectClass;
import objectClass.UseCaseClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CanvasPanel extends JPanel implements MouseListener {

    //! 所有創立的obj記錄到一個陣列中 (用於重新繪製)
    private ArrayList<ObjectClass> Objs = new ArrayList<>();
    private int mode = 0;

    CanvasPanel(Color bgColor, int width, int height) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
    }

    /**
     * * set the canvas mode
     */
    public void setMode(int mode){
        this.mode = mode;
        System.out.println("mode: " + mode);
    }

    /**
     * * Paint all the objects in the Objs array
     */
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
//        Objs.add(new Class(100,100));
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            obj.draw(g);
        }

    }

    /**
     * * clear all the objects in the Objs array
     */
    public void clearObjs(){
        Objs.clear();
        repaint();
    }

    /**
     * * rename the selected object
     */
    public void renameObj(String newName){
        for(int i=0; i<Objs.size(); i++){
            ObjectClass obj = Objs.get(i);
            if(obj.isSelected){
                obj.rename(newName);
            }
        }
        repaint();
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        int x = e.getX();
        int y = e.getY();
        switch(mode){
            case 1:
                for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                Class classObj = new Class(x,y, "class");
                Objs.add(classObj);
                break;
            case 6:
                UseCaseClass useCaseObj = new UseCaseClass(x,y, "useCase");
                Objs.add(useCaseObj);
                break;
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("canvas in");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("canvas out");
    }
}
