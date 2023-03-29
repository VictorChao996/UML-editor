
package objectClass;

import java.awt.*;

public class BasicClass extends ObjectClass {

    PortClass[] ports = new PortClass[4];
    // private int x;
    // private int y;
    protected int width = 0;
    protected int height = 0;
    // protected boolean isSelected = false;
    protected String text = "obj" ;

    //draw ports 
    // public void draw(Graphics g) {
	// 	for(int i = 0; i < ports.length; i++) {
	// 		g.fillRect(ports[i].x, ports[i].y, ports[i].width, ports[i].height);
	// 	}
	// }
    public void draw(Graphics g) {

    }
    //draw ports 
    public void show_selected(Graphics g) {
		for(int i = 0; i < ports.length; i++) {
			g.fillRect(ports[i].x, ports[i].y, ports[i].width, ports[i].height);
		}
	}

    
    public void set_ports_pos(int x, int y, int width, int height) {
        ports[0].setXY(x + width / 2, y);
        ports[1].setXY(x + width, y + height / 2);
        ports[2].setXY(x + width / 2, y + height);
        ports[3].setXY(x, y + height / 2);
        // ports[0].setXY(x + width / 2, y);
        // ports[1].setXY(x + width, y + height / 2);
        // ports[2].setXY(x + width / 2, y + height);
        // ports[3].setXY(x, y + height / 2);
        
    }

    @Override
    public void inside(int px, int py) {
        System.out.println("width: " + width + " " +"height: "+ height);
        if(px >= x && px <= x+width && py >= y && py <= y+height){
            System.out.println(this);
            System.out.println("inside");
            isSelected = true;
        }else{
            System.out.println("outside");
            isSelected = false;
        }
    }

    public void create_ports(int x, int y, int width, int height) {
        System.out.println("create ports");
        ports[0] = new PortClass(x + width / 2, y);
        ports[1] = new PortClass(x + width, y + height / 2);
        ports[2] = new PortClass(x + width / 2, y + height);
        ports[3] = new PortClass(x, y + height / 2);
    }

    // public void setXY(int x, int y){
    //     this.x = x;
    //     this.y = y;
    // }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }

    @Override
    public void rename(String text){
        this.text = text;
    }

    /**
     * * 根據x,y座標找對最接近的的port
     */
    @Override
    public PortClass getPort(int x, int y){
        int distance = 10000000;
        int minDisPort = 0 ;
        for(int i = 0; i < ports.length; i++) {
            int temp = (int) Math.sqrt(Math.pow(ports[i].x - x, 2) + Math.pow(ports[i].y - y, 2));
            if(temp <= distance){
                minDisPort = i;
                distance = temp;
            }
        }
        System.out.println("return Port: " + minDisPort);
        return ports[minDisPort];
    }
}
