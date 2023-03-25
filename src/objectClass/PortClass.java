package objectClass;

import java.awt.*;
import java.util.ArrayList;

public class PortClass {
    ArrayList<LineClass> line_arr = new ArrayList();
    public int x;
    public int y;
    public int width = 5;
    public int height = 5;

    PortClass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // public void draw(Graphics g){
    //     Graphics2D g2D = (Graphics2D) g;
    //     g2D.setPaint(Color.white);
    //     g2D.fillRect(x,y,width,height);
    //     // g2D.setFont(new Font("Serif", Font.BOLD, 30));
    //     // g2D.drawString(text, x + 35, y + 50);
    // }

    public void display(){

    }

    public void add_line(LineClass line){
        line_arr.add(line);
    }
    public void remove_line(){

    }
    public void move_lines(){
        line_arr.forEach((l)->{
            l.move();
        });
    }
}
