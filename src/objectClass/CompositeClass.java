package objectClass;

import java.awt.*;
import objectClass.*;
import java.util.ArrayList;

public class CompositeClass extends ObjectClass{


    private ArrayList<ObjectClass> selectedObjects;

    // public CompositeClass(int x1, int y1, int x2, int y2) {
    //     this.x1 = x1;
    //     this.y1 = y1;
    //     this.x2 = x2;
    //     this.y2 = y2;    
    // }
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int width;
    private int height;

    public CompositeClass(ArrayList<ObjectClass> selectedObjects) {
        this.selectedObjects = selectedObjects;
        findRange();
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

        x1 = x;
        y1 = y;
        for(int i=0; i<selectedObjects.size(); i++){
            selectedObjects.get(i).draw(g);
        }
        // int width = Math.abs(x1-x2);
        // int height = Math.abs(y1-y2);
        int alpha = 85;
        g.setColor(new Color(110, 219, 181, alpha));
        g.fillRect(x1, y1, width, height);
        g.drawRect(x1, y1, width, height);
        System.out.println("x: " + x1 + " y: " + y1 + " width: " + width + " height: " + height);
    }

    @Override
    public void rename(String text) {
        selectedObj.rename(text);
    }

    // @Override
    // public void inside(int px, int py) {
    //     System.out.println("composite inside");
    //     System.out.println("width: " + width + " " +"height: "+ height);
    //     if(px >= x && px <= x+width && py >= y && py <= y+height){
    //         System.out.println(this);
    //         System.out.println("inside");
    //         isSelected = true;
    //     }else{
    //         System.out.println("outside");
    //         isSelected = false;
    //     }
    // }
    @Override
    public void inside(int px, int py) {
        System.out.println("composite inside");
        // System.out.println("width: " + width + " " +"height: "+ height);
        if((px >= x1 && px <= x2) && (py >= y1 && py <= y2)){
            System.out.println(this);
            System.out.println("inside");
            isSelected = true;
        }else{
            System.out.println("outside");
            isSelected = false;
        }
    }

    public void setX(int x1){
        this.x1 = x1;
        x = x1;
    }
    public void setY(int y1){
        this.y1 = y1;
        y = y1;
    }

    public void setX2(int x2){
        this.x2 = x2;
    }

    public void setY2(int y2){
        this.y2 = y2;
    }


    public void findRange(){
        int x1 = selectedObjects.get(0).x;
        int y1 = selectedObjects.get(0).y;
        int x2 = selectedObjects.get(0).x + selectedObjects.get(0).width;
        int y2 = selectedObjects.get(0).y + selectedObjects.get(0).height;
        for(int i=0; i<selectedObjects.size(); i++){
            if(selectedObjects.get(i).x < x1)
                x1 = selectedObjects.get(i).x;
            if(selectedObjects.get(i).y < y1)
                y1 = selectedObjects.get(i).y;
            if(selectedObjects.get(i).x + selectedObjects.get(i).width > x2)
                x2 = selectedObjects.get(i).x + selectedObjects.get(i).width;;
            if(selectedObjects.get(i).y + selectedObjects.get(i).height > y2)
                y2 = selectedObjects.get(i).y + selectedObjects.get(i).height;
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        width = Math.abs(x1-x2);
        height = Math.abs(y1-y2);
        this.width = width;
        this.height = height;
    }

}
