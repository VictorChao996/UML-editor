package objectClass;

public class CompositeClass extends ObjectClass{

    ObjectClass selectedObj = null;
    @Override
    public void draw() {

    }

    @Override
    public void rename() {
        selectedObj.rename();
    }

    @Override
    public void inside(int px, int py) {

    }
}
