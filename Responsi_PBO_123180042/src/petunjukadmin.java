
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NIA
 */
public class petunjukadmin extends JFrame
{
    JButton home;
    JLabel label1,label2,label3;
    
    public petunjukadmin()
    {
        JButton home = new JButton("Home");
        
        JLabel label1= new JLabel("Klik tombol Gaji Untuk Menghitung Gaji");
        JLabel label2 = new JLabel("Klik tombol Data untuk Cek Data Sudah Masuk atau Belum");
        JLabel label3 = new JLabel("PETUNJUK KARYAWAN");
        
        setLayout(null);
        add(label1);
        add(label2);
        add(label3);
        add(home);
        
        label3.setBounds(170, 20, 200,30);
        label1.setBounds(50, 100, 300,30);
        label2.setBounds(50, 140, 400,30);
        home.setBounds(180, 200, 100,30);
        
        setSize(500,300); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        home.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new menuadmin();
            }
            
        });
    }
}
