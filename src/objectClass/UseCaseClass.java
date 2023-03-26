package objectClass;
import java.awt.*;

public class UseCaseClass extends BasicClass {
    private int x;
    private int y;
    private int width = 160;
    private int height = 80;

    public UseCaseClass(int x, int y, String text){
        // super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.text = text;
        System.out.println("new useCase obj");
        create_ports(x,y,width,height);
        setXY(x,y);
        setHeight(height);
        setWidth(width);
    }
    @Override
    public void draw(Graphics g) {
        if(isSelected)
            super.draw(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawOval(x,y,width,height);
        g2D.setFont(new Font("Serif", Font.BOLD, 30));
        g2D.drawString(text, x + 35, y + 50);
    }


//    @Override
//    public boolean inside(int px, int py, int x, int y, int width, int height, boolean isSelected) {
//        super.inside(px,py);
//        if(result)
//            isSelected = true;
//        else
//            isSelected = false;
//        return isSelected;
//    }


    //  @Override
    //  public void inside(int px, int py) {
    //      if(px >= x && px <= x+width && py >= y && py <= y+height){
    //          System.out.println(this);
    //          System.out.println("inside");
    //          isSelected = true;
    //      }else{
    //          System.out.println("outside");
    //          isSelected = false;
    //      }
    //  }


}
