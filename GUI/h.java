package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class h extends JFrame implements ActionListener {

    JButton btnCyan;
    JButton btnBlack;
    JButton btnCancel;

    h(String str) {
        btnCyan = new JButton("Cyan");
        btnBlack = new JButton("Black");
        btnCancel = new JButton("Exit");
        Container cp = getContentPane();
        setSize(200, 300);
        cp.setLayout(new FlowLayout());
        cp.add(btnCyan);
        cp.add(btnBlack);
        cp.add(btnCancel);
        btnCancel.addActionListener(this);
        btnBlack.addActionListener(this);
        btnCyan.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCyan)
            getContentPane().setBackground(Color.cyan);
        else if (ae.getSource() == btnBlack)
            getContentPane().setBackground(Color.black);
        else {
            dispose(); // causes the JFrame window to be destroyed
            // and cleaned up by the operating system
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        h b = new h("My Frame");
        b.setVisible(true);
    }
}