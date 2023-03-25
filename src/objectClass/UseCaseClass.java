package objectClass;
import java.awt.*;

public class UseCaseClass extends BasicClass {
    private int x;
    private int y;
    private int width = 160;
    private int height = 80;
    private String text = "";
    private boolean isSelected = false;

    public UseCaseClass(int x, int y, String text){
        this.x = x;
        this.y = y;
        this.text = text;
        System.out.println("new useCase obj");
    }
    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.white);
        g2D.drawOval(x,y,width,height);
        g2D.setFont(new Font("Serif", Font.BOLD, 30));
        g2D.drawString(text, x + 35, y + 50);
    }

    @Override
    public void rename() {

    }

    @Override
    public void inside(int px, int py) {
        if(px >= x && px <= x+width && py >= y && py <= y+height){
            System.out.println(this);
            System.out.println("inside");
            isSelected = true;
        }else{
            System.out.println("outside");
            isSelected = false;
        }
    }

    public void rename(String text){
        this.text = text;
    }
}
