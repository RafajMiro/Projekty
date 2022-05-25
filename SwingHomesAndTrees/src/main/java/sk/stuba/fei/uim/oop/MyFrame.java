package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        JFrame window = new JFrame("Gate");
        JPanel menu = new JPanel(new GridLayout(1,6));
        Logic logic = new Logic(menu);

        window.setSize(700,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(new BorderLayout());
        window.setResizable(false);

        window.add("North", menu);
        window.add("Center",logic.getCan());

        window.setVisible(true);
    }


}
