package objectClass;

import java.awt.*;

public class CompositeClass extends ObjectClass{

    ObjectClass selectedObj = null;
    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void rename() {
        selectedObj.rename();
    }

    @Override
    public void inside(int px, int py) {

    }
}
