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
    private ArrayList<CompositeClass> CompositeObjs = new ArrayList<>();
    private int mode = 0;
    private boolean selectGroupMode = false;
    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;

    private PortClass firstPortToConnect = null;
    private PortClass secondPortToConnect = null;
    private CompositeClass currentCompositeObj = null;
    private DrawClass currentDrawObj = null;

    //! 用於移動物件時的計算
    private int selectPosX = 0;
    private int selectPosY = 0;

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
                // selectGroupMode = true;
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
                boolean isOnObject = checkInside(x,y);
                currentCompositeObj = null;
                if(isOnObject == false){
                    // CompositeClass compositeObj = new CompositeClass(x,y,x,y);
                    // Objs.add(compositeObj);
                    // currentCompositeObj = compositeObj;
                    DrawClass drawObj = new DrawClass(x,y,x,y);
                    currentDrawObj = drawObj;
                    Objs.add(drawObj);
                    selectGroupMode = true;
                }else{
                    selectPosX = x;
                    selectPosY = y;
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
        countSelectedObjs();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        x2 = x;
        y2 = y;
        secondPortToConnect = null;
        
        //先不要把連接port的程式碼拉到這邊，mode 1 選取物件時會有問題
        
        switch(mode){
            case 1:
                selectGroupMode = false;
                countSelectedObjs();
                return;
            case 2:
                 //*尋找第二個需要連接的port
                for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                    if(obj.isSelected == true){
                        secondPortToConnect = obj.getPort(x,y);
                    }
                }
                GeneralizationLineClass glObj = new GeneralizationLineClass(firstPortToConnect,secondPortToConnect);
                Objs.add(glObj);
                break;
            case 3:
                  //*尋找第二個需要連接的port
                  for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                    if(obj.isSelected == true){
                        secondPortToConnect = obj.getPort(x,y);
                    }
                }
                CompositionLineClass clObj = new CompositionLineClass(firstPortToConnect, secondPortToConnect);
                Objs.add(clObj);
                break;
            case 4:
                  //*尋找第二個需要連接的port
                  for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                    if(obj.isSelected == true){
                        secondPortToConnect = obj.getPort(x,y);
                    }
                }
                AssociationLineClass alObj = new AssociationLineClass(firstPortToConnect, secondPortToConnect);
                Objs.add(alObj);
                break;

        }
        repaint();
        countSelectedObjs();
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
            // boolean isOnObject = checkInside(x,y);
            if(selectGroupMode == false) {
                System.out.println("mouseDragged - selectGroupMode == false");
                for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.inside(x,y);
                    if(obj.isSelected){
                        int distanceX = x - selectPosX;
                        int distanceY = y - selectPosY;
                        obj.setX(obj.x + distanceX);
                        obj.setY(obj.y + distanceY);

                        selectPosX = x;
                        selectPosY = y;
                        // repaint();
                    }
                }
            }else{
                // currentCompositeObj.setX2(x);
                // currentCompositeObj.setY2(y);
                // for(int i = Objs.size()-1 ;i>=0; i--){
                //     ObjectClass obj = Objs.get(i);
                //     boolean isInsideComposite = currentCompositeObj.objIsInside(obj.getX(),obj.getY(), obj.getWidth(), obj.getHeight());
                //     if(isInsideComposite)
                //         obj.isSelected = true;
                // }
                currentDrawObj.setX2(x);
                currentDrawObj.setY2(y);
                // drawSelectSquare(x1,y1,x2,y2);
                for(int i = Objs.size()-1 ;i>=0; i--){
                    ObjectClass obj = Objs.get(i);
                    obj.isSelected =  objIsInside(obj, x1, y1, x2, y2);
                    
                }
            }
        }
        repaint();
        countSelectedObjs();
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

    //劃出要group的範圍
    // public void drawSelectSquare(int x1, int y1, int x2, int y2){
    //     System.out.println("g" + g);
    //     int width = Math.abs(x1-x2);
    //     int height = Math.abs(y1-y2);
    //     int alpha = 85;
    //     g.setColor(new Color(110, 219, 181, alpha));
    //     g.fillRect(x1, y1, width, height);
    // }

     //判斷物件是否在範圍內
    public boolean objIsInside(ObjectClass obj, int x1, int y1, int x2, int y2){
        if(x1<obj.x && (obj.x+obj.width)<x2 || x2 < obj.x && (obj.x+obj.width) < x1){
            if(y1 < obj.y && (obj.y+obj.height) < y2 || y2 < obj.y && (obj.y+obj.height) < y1)
                return true;
        }
        return false;
    }

    public void groupObjs(){
        System.out.println("groupObjs");
        ArrayList<ObjectClass> selectedObjs = new ArrayList<ObjectClass>();
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            if(obj.isSelected){
                selectedObjs.add(obj);
            }
        }
        System.out.println("selectedObjs.size() " + selectedObjs.size());
        if(selectedObjs.size() > 1){
            CompositeClass compositeObj = new CompositeClass(selectedObjs);
            Objs.add(compositeObj);
        }
    }

    public void countSelectedObjs(){
        int count = 0;
        for(int i = Objs.size()-1 ;i>=0; i--){
            ObjectClass obj = Objs.get(i);
            if(obj.isSelected){
                count++;
            }
        }
        System.out.println("selected Count " + count);
    }
}
