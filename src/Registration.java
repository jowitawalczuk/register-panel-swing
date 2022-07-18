import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Registration implements ActionListener {

    public JTextField lf1 = new JTextField();
    public JTextField lf2 = new JTextField();
    public JTextField lf3 = new JTextField();
    public JTextField lf4 = new JTextField();
    public JPasswordField fp1 = new JPasswordField();
    public JPasswordField fp2 = new JPasswordField();
    public JComboBox df1;
    public JComboBox df2;
    public JComboBox df3;
    public JButton b;
    public JToggleButton k;
    public JToggleButton m;
    public JCheckBox ch;

    public Registration() throws IOException {
        //Utworzenie background panel
        //BackgroundPanel BP = new BackgroundPanel();
        //Utworzenie nowego okna
        JFrame f = new JFrame("Panel Rejestracyjny");
        //Wymiary okna i tło
        f.setSize(500, 1000);
        Image img = Toolkit.getDefaultToolkit().getImage("@../../mikro1.jpeg");
        f.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null/*this.getWidth(),this.getHeight(),this*/);
            }
        });
        //Wyświetlenie okna
        f.setVisible(true);
        //usunięcie rozkładu kontenerta w celu zastosowania pozycjownowania absolutnego
        f.setLayout(null);
        // Po zamknięciu okna, aplikacja ma zakończyc działanie
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Utworzenie tekstów
        JLabel l1 = new JLabel("Nazwa użytkownika: ");
        JLabel l2 = new JLabel("Imię: ");
        JLabel l3 = new JLabel("Nazwisko: ");
        JLabel l4 = new JLabel("Email: ");
        JLabel p1 = new JLabel("Hasło: ");
        JLabel p2 = new JLabel("Powtórz hasło: ");
        JLabel d = new JLabel("Data urodzenia: ");
        JLabel km = new JLabel("Płeć:  ");
        JLabel acc = new JLabel("Oświadczam, iż zapoznałem/am się");
        JLabel acc2 = new JLabel("i akceptuję warunki regulaminu. ");
        acc.setForeground(Color.pink);
        acc2.setForeground(Color.pink);
        acc.setFont(new Font("HANGING_BASELINE", (Font.BOLD | Font.ITALIC), 13));
        acc2.setFont(new Font("HANGING_BASELINE", (Font.BOLD | Font.ITALIC), 13));
        //Listy do pola tekstowego
        String miesiac[] = {"styczeń", "luty", "marzec", "kwiecień", "maj", "czarwiec", "lipiec", "sierpień", "wrzesień", "październik", "listopad", "grudzień"};
        String dzien[] = new String[31];
        for (int i = 0; i < 31; i++) {
            int x = i + 1;
            dzien[i] = Integer.toString(x);
        }
        String rok[] = new String[200];
        for (int j = 0; j < 200; j++) {
            int y = 2021 - j;
            rok[j] = Integer.toString(y);
        }
        df1 = new JComboBox(dzien);
        df2 = new JComboBox(miesiac);
        df3 = new JComboBox(rok);
        JPasswordField bf = new JPasswordField();
        //Utworzenie przycisków
        b = new JButton("Zarejestruj");
        k = new JToggleButton("Kobieta");
        m = new JToggleButton("Mężczyzna");

        ch = new JCheckBox();
        //Rozmieszczenie komponentów poprzez pozycjownowanie absolutne
        //tekstów
        l1.setBounds(15, 10, 150, 20);
        l2.setBounds(15, 50, 150, 20);
        l3.setBounds(15, 100, 150, 20);
        l4.setBounds(15, 150, 150, 20);
        p1.setBounds(15, 200, 150, 20);
        p2.setBounds(15, 250, 150, 20);
        d.setBounds(15, 300, 150, 20);
        km.setBounds(15, 350, 150, 20);
        acc.setBounds(185, 400, 205, 20);
        acc2.setBounds(185, 420, 205, 20);
        //pól tekstowych
        lf1.setBounds(155, 10, 250, 20);
        lf2.setBounds(155, 50, 250, 20);
        lf3.setBounds(155, 100, 250, 20);
        lf4.setBounds(155, 150, 250, 20);
        df1.setBounds(155, 300, 40, 20);
        df2.setBounds(210, 300, 100, 20);
        df3.setBounds(325, 300, 80, 20);
        //haseł
        fp1.setBounds(155, 200, 250, 20);
        fp2.setBounds(155, 250, 250, 20);
        //przycisków
        b.setBounds(200, 600, 150, 40);
        k.setBounds(155, 350, 120, 20);
        m.setBounds(285, 350, 120, 20);
        ch.setBounds(155, 400, 20, 20);
        //Dodanie komponentów do kontenera
        //tekstów
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(l4);
        f.getContentPane().add(p1);
        f.getContentPane().add(p2);
        f.getContentPane().add(d);
        f.getContentPane().add(km);
        f.getContentPane().add(acc);
        f.getContentPane().add(acc2);

        //pól tekstowych
        f.getContentPane().add(lf1);
        f.getContentPane().add(lf2);
        f.getContentPane().add(lf3);
        f.getContentPane().add(lf4);
        f.getContentPane().add(fp1);
        f.getContentPane().add(fp2);
        f.getContentPane().add(bf);
        f.getContentPane().add(df1);
        f.getContentPane().add(df2);
        f.getContentPane().add(df3);

        //przycisków
        f.getContentPane().add(b);
        f.getContentPane().add(k);
        f.getContentPane().add(m);

        f.getContentPane().add(ch);
        //przyłączenie słuchacza do źródła zdarzenia
        b.addActionListener(this);
        ch.addActionListener(this);
        k.addActionListener(this);
        m.addActionListener(this);

    }

    public static void main(String[] args) throws IOException {
        new Registration();
    }

    private void save(String user_name, String name, String surname, String email, String password, int day, int month, int year, String sex) throws IOException {

        //otworzenie arkusza w excelu
        String excelFilePath = "@../../Rejestr.xlsx";
        FileInputStream inputted=new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputted);
        XSSFSheet sheet = workbook.getSheetAt(0);

        //zapis użytkowników pomyślnie zarejestrowanych
        User uzytkownik = new User(user_name, name, surname, email, password, day, month, year,sex);
        ArrayList<User[]> uzytkownicy = new ArrayList<User[]>();
        uzytkownicy.add(new User[]{uzytkownik});
        FileOutputStream outputted = new FileOutputStream(excelFilePath);

        for (User[] us : uzytkownicy) {
            int rownum =3;

            XSSFRow row = sheet.createRow(rownum++);
            int cellnum = 0;
            XSSFCell cell = row.createCell(cellnum++);
            cell.setCellValue(user_name);
            XSSFCell cell1 = row.createCell(cellnum++);
            cell1.setCellValue(name);
            XSSFCell cell2 = row.createCell(cellnum++);
            cell2.setCellValue(surname);
            XSSFCell cell3 = row.createCell(cellnum++);
            cell3.setCellValue(email);
            XSSFCell cell4 = row.createCell(cellnum++);
            cell4.setCellValue(password);
            XSSFCell cell5 = row.createCell(cellnum++);
            cell5.setCellValue(day+1);
            XSSFCell cell6 = row.createCell(cellnum++);
            cell6.setCellValue(month+1);
            XSSFCell cell7 = row.createCell(cellnum++);
            cell7.setCellValue(2021-year);
            XSSFCell cell8 = row.createCell(cellnum++);
            cell8.setCellValue(sex);

            try {
                outputted = new FileOutputStream(excelFilePath);
                workbook.write(outputted);
                outputted.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String pas1 = String.valueOf(fp1.getPassword());
        String pas2 = String.valueOf(fp2.getPassword());
        if (event.getSource() == b) {
            if (ch.isSelected() == true) {
                if (lf1.getText().isEmpty() || lf2.getText().isEmpty() || lf3.getText().isEmpty() || lf4.getText().isEmpty() || fp1.getPassword().length < 6 || (fp2.getPassword() != fp1.getPassword())) {
                    if (lf1.getText().isEmpty()) {
                        System.out.println("Niepoprawna nazwa użytkownika");
                    }
                    if (lf2.getText().isEmpty()) {
                        System.out.println("Niepoprawne imię");
                    }
                    if (lf3.getText().isEmpty()) {
                        System.out.println("Niepoprawne nazwisko");
                    }
                    if (lf4.getText().isEmpty()) {
                        System.out.println("Niepoprawny adres email");
                    }
                    if (fp1.getPassword().length < 6) {
                        System.out.println("Hasło zbyt krótkie");
                    }
                    if (!pas1.equals(pas2)) {
                        System.out.println("Wprowadzone hasła nie są kompatybilne");
                    } else {
                        System.out.println("Rejestracja przebiegła pomyślnie");
                        if (k.isSelected() == true) {
                            try {
                                String sex = "kobieta";
                                save(lf1.getText(), lf2.getText(), lf3.getText(), lf4.getText(), pas1, df1.getSelectedIndex(), df2.getSelectedIndex(), df3.getSelectedIndex(), sex);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (m.isSelected() == true) {
                            try {
                                String sex = "mężczyzna";
                                save(lf1.getText(), lf2.getText(), lf3.getText(), lf4.getText(), pas1, df1.getSelectedIndex(), df2.getSelectedIndex(), df3.getSelectedIndex(), sex);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Wybierz płeć");
                        }
                    }

                }
            } else {
                System.out.println("Proszę zaakceptować regulamin !");
            }
        }

    }
    }

class User {
    private String nazwa_uzytkownika;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private int dzien;
    private int miesiac;
    private int rok;
    private String plec;

    public User(String nazwa_uzytkownika, String imie, String nazwisko, String email, String haslo, int dzien, int miesiac, int rok, String plec){
        this.nazwa_uzytkownika=nazwa_uzytkownika;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
        this.haslo=haslo;
        this.dzien=dzien;
        this.miesiac=miesiac;
        this.rok=rok;
        this.plec=plec;
    }
    //Settery
    public void setNazwa_uzytkownika(String nazwa_uzytkownika) {
        this.nazwa_uzytkownika = nazwa_uzytkownika;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setDzien(int dzien) { this.dzien = dzien; }

    public void setEmail(String email) {  this.email = email; }

    public void setHaslo(String haslo) { this.haslo = haslo; }

    public void setMiesiac(int miesiac) { this.miesiac = miesiac; }

    public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

    public void setPlec(String plec) { this.plec = plec; }

    public void setRok(int rok) { this.rok = rok; }

    //Gettery
    public String getNazwa_uzytkownika(){
        return nazwa_uzytkownika;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public String getHaslo(){
        return haslo;
    }

    public int getDzien() {
        return dzien;
    }

    public int getRok() {
        return rok;
    }

    public int getMiesiac() {
        return miesiac;
    }

    public String getEmail() {
        return email;
    }

    public String getPlec() { return plec;  }
}
