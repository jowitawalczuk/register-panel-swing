/*import java.awt.*;
import javax.swing.*;



public class GuiSwing {

    public GuiSwing() {
        // ustalenie tytułu okna
        //setTitle("Rejestracja");

        // ustalenie rozkładu - jeśli trzeba, np:
        //setLayout(new FlowLayout());

        // tworzenie komponentów np.
        JFrame f= new JFrame("Rejsetracja");

        JLabel l1 = new JLabel("Nazwa użytkownika: ");
        JLabel l2 = new JLabel("Imię: ");
        JLabel l3 = new JLabel("Nazwisko: ");
        JLabel l4 = new JLabel("Gmail: ");
        JLabel l5 = new JLabel("Hasło: ");
        JLabel l6 = new JLabel("Powtórz hasło: ");
        JButton b = new JButton("Przycisk");

        // Ustalenie własciwości komponentów,
        // np:
        l1.setForeground(Color.red);
        b.setForeground(Color.blue);

        // ustalenie rozmiarów okna, np.:
        //np.pack();
        f.setSize(600,800);

        l2.setBounds(900,200,200,200);
        b.setBounds(9,2,2,2);
        // ustalenie położenia okna np. wycentrowanie

        //wyśrodkowanie okna
        //f.setLocationRelativeTo(null);

        // Dodanie komponentów do okna np.
        f.getContentPane().add(BorderLayout.EAST,l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(l5);
        f.getContentPane().add(l6);
        f.getContentPane().add(b);

        // Po zamknięciu okna, aplikacja ma zakończyc działanie
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // pokazanie okna
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new GuiSwing();
        // Po zamknięciu okna, aplikacja ma zakończyc działanie

    }

}*/