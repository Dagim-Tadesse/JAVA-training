package GUI;

//package swinglab;
import java.awt.*;
import javax.swing.*;

public class Calc extends JFrame {
    private JPanel entryPanel;
    private JPanel answerPanel;

    public Calc() {
        Container cp = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp.setLayout(new FlowLayout());
        cp.setBackground(Color.white);
        setTitle("My Funky Calculator");
        setSize(1000, 700);
        entryPanel = new JPanel();
        entryPanel.setBackground(Color.black);
        entryPanel.setSize(500, 400);
        entryPanel.s
        answerPanel = new JPanel();
        answerPanel.setBackground(Color.yellow);
        // . . .

        cp.add(entryPanel);
        cp.add(answerPanel);
    }

    public static void main(String[] args) {
        Calc trial = new Calc();
        trial.setVisible(true);
    }
}
