import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    public Main()
    {
        JFrame frame = new JFrame("HelloWorldSwing");
        JButton b = new JButton("Event Source");
        b.addActionListener(new ButtonListener());
        frame.getContentPane().add(b);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

    private static class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event) {
            JButton source = (JButton)event.getSource();
            System.out.println(source.getText() + " activated");
        }
    }

    public static void main(String[] args)
    {
        new Main();

    }
}