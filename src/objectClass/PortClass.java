package objectClass;

import java.util.ArrayList;

public class PortClass {
    ArrayList<LineClass> line_arr = new ArrayList();
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
