package UI;

import objectClass.*;
import objectClass.Class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {

    //! 所有創立的obj記錄到一個陣列中 (用於重新繪製)
    private ArrayList<ObjectClass> Objs = new ArrayList<>();
    private int mode = 0;
    private boolean dragMode = false;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    private PortClass firstPortToConnect = null;
    private PortClass secondPortToConnect = null;
    private CompositeClass currentCompositeObj = null;

    CanvasPanel(Color bgColor, int width, int height) {
        this.setBackground(bgColor);
        this.setPreferredSize(new Dimension(width, height));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
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
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            if(obj.isSelected){
                System.out.println("X: " + obj.getX());
                System.out.println("Y: " + obj.getY());
                // dragMode = true;
            }
        }
        System.out.println("Obj length: " + Objs.size());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        x1 = x;
        y1 = y;
        firstPortToConnect = null;
        //*尋找第一個需要連接的port */
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            obj.inside(x,y);
            if(obj.isSelected == true){
                firstPortToConnect = obj.getPort(x,y);
            }
        }
        switch(mode){
            case 1:
                currentCompositeObj = null;
                if(firstPortToConnect == null){
                    CompositeClass compositeObj = new CompositeClass(x,y,x,y);
                    Objs.add(compositeObj);
                    currentCompositeObj = compositeObj;
                }
                break;
            case 2:
                // for(int i = Objs.size()-1 ;i>=0; i--){
                //     ObjectClass obj = Objs.get(i);
                //     obj.inside(x,y);
                //     if(obj.isSelected == true){
                //         firstPortToConnect = obj.getPort(x,y);
                //     }
                // }
                break;
            case 3:
                // for(int i = Objs.size()-1 ;i>=0; i--){
                //     ObjectClass obj = Objs.get(i);
                //     obj.inside(x,y);
                //     if(obj.isSelected == true){
                //         firstPortToConnect = obj.getPort(x,y);
                //     }
                // }
                break;
            case 4:
                // for(int i = Objs.size()-1 ;i>=0; i--){
                //     ObjectClass obj = Objs.get(i);
                //     obj.inside(x,y);
                //     if(obj.isSelected == true){
                //         firstPortToConnect = obj.getPort(x,y);
                //     }
                // }
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
        int x = e.getX();
        int y = e.getY();
        x2 = x;
        y2 = y;
        secondPortToConnect = null;
        //*尋找第二個需要連接的port
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            obj.inside(x,y);
            if(obj.isSelected == true){
                secondPortToConnect = obj.getPort(x,y);
            }
        }
        switch(mode){
            case 2:
                GeneralizationLineClass glObj = new GeneralizationLineClass(firstPortToConnect,secondPortToConnect);
                Objs.add(glObj);
                break;
            case 3:
                CompositionLineClass clObj = new CompositionLineClass(firstPortToConnect, secondPortToConnect);
                Objs.add(clObj);
                break;
            case 4:
                AssociationLineClass alObj = new AssociationLineClass(firstPortToConnect, secondPortToConnect);
                Objs.add(alObj);
                break;

        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("canvas in");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // System.out.println("canvas out");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(mode == 1){
            int x = e.getX();
            int y = e.getY();
            x2 = x;
            y2 = y;
//            System.out.println("drag x: " +  x + ", drag y: " + y);
            boolean isOnObject = checkInside(x,y);
            if(isOnObject) {
                for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                    if(obj.isSelected){
                        obj.setX(x);
                        obj.setY(y);
                        repaint();
                    }
                }
            }else{
                currentCompositeObj.setX2(x);
                currentCompositeObj.setY2(y);
            }
            
            // ObjectClass selectedObject = null;
            // for(int i = Objs.size()-1 ;i>=0; i--){
            //     ObjectClass obj = Objs.get(i);
            //     if(obj.isSelected){
            //         selectedObject = obj;
            //         obj.setX(x);
            //         obj.setY(y);
            //         repaint();
            //     }
            //     else{
            //         selectedObject = null;
            //     }
            // }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public boolean checkInside(int x, int y){
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            obj.inside(x,y);
            if(obj.isSelected){
                return true;
            }
        }
        return false;
    }
}
