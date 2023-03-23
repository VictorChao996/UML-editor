import objectClass.AssociationLineClass;
import objectClass.LineClass;
import objectClass.ObjectClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyFrame frame = new MyFrame();

        ObjectClass al = new AssociationLineClass();
        ObjectClass l = new LineClass();
        al.draw();
        l.draw();
    }
}