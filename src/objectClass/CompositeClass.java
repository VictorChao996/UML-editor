package objectClass;

import java.awt.*;
import objectClass.*;
import java.util.ArrayList;

public class CompositeClass extends ObjectClass{

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private ArrayList<ObjectClass> selectedObjects;

    public CompositeClass(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;    
    }

    public CompositeClass(ArrayList<ObjectClass> selectedObjects) {
        this.selectedObjects = selectedObjects;
        System.out.println("selectedObjects.size(): "+selectedObjects.size());
    }

    ObjectClass selectedObj = null;

    @Override
    public void draw(Graphics g) {
        // System.out.println("x1: "+x1+" y1: "+y1+" x2: "+x2+" y2: "+y2);
        // int width = Math.abs(x1-x2);
        // int height = Math.abs(y1-y2);
        // int alpha = 85;
        // g.setColor(new Color(110, 219, 181, alpha));
        // g.fillRect(x1, y1, width, height);
        // g.drawRect(x1, y1, width, height);

        for(int i=0; i<selectedObjects.size(); i++){
            selectedObjects.get(i).draw(g);
        }
    }

    @Override
    public void rename(String text) {
        selectedObj.rename(text);
    }

    @Override
    public void inside(int px, int py) {

    }

    public void setX2(int x2){
        this.x2 = x2;
    }

    public void setY2(int y2){
        this.y2 = y2;
    }

    //判斷物件是否在範圍內
    public boolean objIsInside(int x, int y, int width, int height){
        if(x1<x && x<x2 || x1>x && x>x2){
            if(y1<y && y<y2 || y1>y && y>y2)
                return true;
        }
        return false;
    }

}
