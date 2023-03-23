package UI;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements MouseListener {
    private ButtonType buttonType;

    public void mouseClicked(MouseEvent e) {
        System.out.println("Hello World");
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public MyFrame() {
        JPanel buttonPanel = this.setUpButtonPanel();
        MyCustomPanel canvasPanel = new MyCustomPanel(Color.lightGray, 1200, 700, "canvasPanel");
        MyCustomPanel topPanel = new MyCustomPanel(150, 10, "topPanel");
        MyCustomPanel bottomPanel = new MyCustomPanel(150, 10, "bottomPanel");
        this.setDefaultCloseOperation(3);
        this.setTitle("UML Editor");
        this.setLayout(new BorderLayout(10, 20));
        this.add(buttonPanel, "West");
        this.add(canvasPanel, "Center");
        this.add(topPanel, "North");
        this.add(bottomPanel, "South");
        JMenuBar menuBar = this.setUpMenuBar();
        this.setJMenuBar(menuBar);
        this.setExtendedState(6);
        this.setVisible(true);
    }

    private JMenuBar setUpMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem groupItem = new JMenuItem("Group");
        JMenuItem ungroupItem = new JMenuItem("Ungroup");
        JMenuItem changeNameItem = new JMenuItem("Change objectClass.Object Name");
        editMenu.add(groupItem);
        editMenu.add(ungroupItem);
        editMenu.add(changeNameItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        return menuBar;
    }

    private JPanel setUpButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(150, 100));
        buttonPanel.setLayout(new GridLayout(6, 1, 0, 30));
        MyButton selectBtn = new MyButton("select", "img/selectBtn.png", MyFrame.ButtonType.Select);
        MyButton assocButton = new MyButton("Association", "img/associationBtn.png", MyFrame.ButtonType.Association);
        MyButton generBtn = new MyButton("Generalization", "img/generalizationBtn.png", MyFrame.ButtonType.Generalization);
        MyButton compoBtn = new MyButton("Composition", "img/compositionBtn.png", MyFrame.ButtonType.Composition);
        MyButton classBtn = new MyButton("Class", "img/classBtn.png", MyFrame.ButtonType.Class);
        MyButton useCaseBtn = new MyButton("UseCase", "img/useCaseBtn.png", MyFrame.ButtonType.UseCase);
        buttonPanel.add(selectBtn);
        buttonPanel.add(generBtn);
        buttonPanel.add(compoBtn);
        buttonPanel.add(assocButton);
        buttonPanel.add(classBtn);
        buttonPanel.add(useCaseBtn);
        return buttonPanel;
    }

    public static enum ButtonType {
        Null,
        Select,
        Association,
        Generalization,
        Composition,
        Class,
        UseCase;

        private ButtonType() {
        }
    }
}
