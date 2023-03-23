package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton implements MouseListener {
    private MyFrame.ButtonType buttonType;

    MyButton(String text) {
        this.setText(text);
    }

    MyButton(String text, String imgIconURL, MyFrame.ButtonType btnType) {
        URL url = MyButton.class.getResource(imgIconURL);
        ImageIcon imgIcon = new ImageIcon(url);
        this.setIcon(imgIcon);
        this.addActionListener((e) -> {
            this.buttonType = btnType;
        });
        this.setText(text);
        this.setHorizontalTextPosition(0);
        this.setVerticalTextPosition(3);
        this.setFocusable(false);
        this.addMouseListener(this);
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println("");
    }

    public void mousePressed(MouseEvent e) {
        this.setEnabled(false);
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}