import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test{

    public static void main(String[] args){
        JFrame f = new Test1();
        f.setVisible(true);
        f.setSize(500, 500);
        //f.setLocationRelativeTo(null);
    }

  }

class Test1 extends JFrame{

    JTextField nazwa_uzytkownika;

    Test1(){
        JPanel p = new JPanel();
        nazwa_uzytkownika = new JTextField(10);
        JButton b  = new JButton("Dodaj");
        //b.setBounds(100,50,12,95);
        JLabel l1 = new JLabel("Nazwa użytkownika: ");
        JLabel l2 = new JLabel("Imię: ");
        JLabel l3 = new JLabel("Nazwisko: ");
        JLabel l4 = new JLabel("Gmail: ");
        JLabel l5 = new JLabel("Hasło: ");
        JLabel l6 = new JLabel("Powtórz hasło: ");




        b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
         //       Client al = new Client(clientNameTextField.getText());
         //       l.setText(al.getClient());
            }

        });
        // Po zamknięciu okna, aplikacja ma zakończyc działanie
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(b);
        p.add(nazwa_uzytkownika);
      //  p.add(l);

        setContentPane(p);
    }
}


class Client {
    String name = new String();

    public Client(String name){
        this.name = name;
    }
    public String getKlient(){
        return name;
    }

}