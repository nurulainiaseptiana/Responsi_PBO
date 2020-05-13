
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class tampilanutama extends JFrame
{
    JButton home,gaji,data,petunjuk,admin;
    JLabel label1,label2,label3,label4,label5;
    
    public tampilanutama ()
    {
        label1 = new JLabel("Selamat Datang.");
        label2 = new JLabel("Silahkan Masuk ke Menu Gaji untuk melakukan");
        label3 = new JLabel("Perhitungan Gaji");
        label4 = new JLabel("Jika Mengalami Kesulitan, Klik Menu Petunjuk");
        label5 = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VERETAN JAYA");
        
        home = new JButton("Home");
        gaji = new JButton("Gaji");
        data = new JButton("Data");
        petunjuk = new JButton("Petunjuk");
        admin = new JButton("Admin");
        
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(home);
        add(gaji);
        add(data);
        add(petunjuk);
        add(admin);
        
        home.setBounds(10, 10, 100, 30);
        gaji.setBounds(10, 50, 100, 30);
        data.setBounds(10, 90, 100, 30);
        petunjuk.setBounds(10, 130, 100, 30);
        admin.setBounds(370, 10, 100, 30);
        label1.setBounds(150, 80, 300, 30);
        label2.setBounds(150, 100, 300, 30);
        label3.setBounds(150, 120, 300, 30);
        label4.setBounds(150, 140, 300, 30);
        label5.setBounds(125, 230, 300, 30);
        
        setSize(500,300); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        home.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new tampilanutama();
            }
            
        });
        
        gaji.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new gaji();
            }
            
        });
        
        data.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
                new data();
            }
            
        });
        
        petunjuk.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
                new petunjuk();
            }
            
        });
        
        admin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                setVisible(false);
                new login();
            }
            
        });
    }
}

