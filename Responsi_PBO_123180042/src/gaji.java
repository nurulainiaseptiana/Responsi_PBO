
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class gaji extends JFrame
{
    JButton home,gaji,data,petunjuk,admin,hitung,simpan;
    JLabel label,id,nama,posisi,alamat,hp,g_pokok,lembur,tunjangan,pajak,total;
    JTextField isiid,isinama,isialamat,isihp,isig_pokok,isilembur,isitunjangan,isipajak,isitotal;
    JComboBox isiposisi;
    Statement statement;
    
    public gaji()
    {
        label = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VERETAN JAYA");
        id = new JLabel("ID Pegawai");
        nama = new JLabel("Nama");
        posisi = new JLabel("Posisi");
        alamat = new JLabel("Alamat");
        hp = new JLabel("No.HP");
        g_pokok = new JLabel("Gaji Pokok");
        lembur = new JLabel("Jam Lembur");
        tunjangan = new JLabel("Tunjangan");
        pajak = new JLabel("Pajak");
        total = new JLabel("Gaji Total");
        
        isiid = new JTextField("");
        isinama = new JTextField("");
        isialamat = new JTextField("");
        isihp = new JTextField("");
        isig_pokok = new JTextField("");
        isilembur = new JTextField("");
        isitunjangan = new JTextField("");
        isipajak = new JTextField("");
        isitotal = new JTextField("");
        
        String[] nama_posisi = {" ", "Direktur", "Manajer", "Programmer", "Marketing", "Surveyor" };
        isiposisi = new JComboBox(nama_posisi);
        
        home = new JButton("Home");
        gaji = new JButton("Gaji");
        data = new JButton("Data");
        petunjuk = new JButton("Petunjuk");
        admin = new JButton("Admin");
        hitung = new JButton("Hitung");
        simpan = new JButton("Simpan");
        
        setLayout(null);
        add(label);

        add(home);
        add(gaji);
        add(data);
        add(petunjuk);
        add(admin);
        
        add(id);
        add(nama);
        add(posisi);
        add(alamat);
        add(hp);
        add(g_pokok);
        add(lembur);
        add(tunjangan);
        add(pajak);
        add(total);
        add(isiid);
        add(isinama);
        add(isiposisi);
        add(isialamat);
        add(isihp);
        add(isig_pokok);
        add(isilembur);
        add(isitunjangan);
        add(isipajak);
        add(isitotal);
        add(hitung);
        add(simpan);
        
        home.setBounds(10, 10, 100, 30);
        gaji.setBounds(10, 50, 100, 30);
        data.setBounds(10, 90, 100, 30);
        petunjuk.setBounds(10, 130, 100, 30);
        admin.setBounds(470, 10, 100, 30);
        label.setBounds(125, 530, 300, 30);
        
        id.setBounds(140, 80, 100, 30);
        nama.setBounds(140, 120, 100, 30);
        posisi.setBounds(140, 160, 100, 30);
        alamat.setBounds(140, 200, 100, 30);
        hp.setBounds(140, 240, 100, 30);
        g_pokok.setBounds(140, 280, 100, 30);
        lembur.setBounds(140, 320, 100, 30);
        tunjangan.setBounds(140, 360, 100, 30);
        pajak.setBounds(140, 400, 100, 30);
        total.setBounds(140, 440, 100, 30);
        isiid.setBounds(240, 80, 200, 30);
        isinama.setBounds(240, 120, 200, 30);
        isiposisi.setBounds(240, 160, 150, 30);
        isialamat.setBounds(240, 200, 300, 30);
        isihp.setBounds(240, 240, 150, 30);
        isig_pokok.setBounds(240, 280, 100, 30);
        isilembur.setBounds(240, 320, 100, 30);
        isitunjangan.setBounds(240, 360, 150, 30);
        isipajak.setBounds(240, 400, 150, 30);
        isitotal.setBounds(240, 440, 150, 30);
        hitung.setBounds(450, 400, 100, 30);
        simpan.setBounds(450, 440, 100, 30);
        
        setSize(600,600); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        hitung.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (isig_pokok.getText().equals("") ) 
                {
                    JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
                } 
                else 
                {
                    double Gajipokok, Jamlembur, Tunjangan, Pajak, Total;
                    Gajipokok = Long.valueOf(isig_pokok.getText());
                    Jamlembur = Long.valueOf(isilembur.getText());
                    Tunjangan = Jamlembur*1500;
                    Pajak = Gajipokok/100;
                    Total = Gajipokok+Tunjangan-Pajak;
                    isipajak.setText("Rp. "+String.valueOf(Pajak));
                    isitunjangan.setText("Rp. "+String.valueOf(Tunjangan));
                    isitotal.setText("Rp. "+String.valueOf(Total));
                }
            }
        });
        
        simpan.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    int a1 =  Integer.parseInt(isiid.getText());
                    String a2 = isinama.getText();
                    String a3 = isiposisi.getSelectedItem().toString();
                    String a4 = isialamat.getText();
                    String a5 = isihp.getText();
                    
                    double Gajipokok, Jamlembur, Tunjangan, Pajak, Total;
                    Gajipokok = Long.valueOf(isig_pokok.getText());
                    Jamlembur = Long.valueOf(isilembur.getText());
                    Tunjangan = Jamlembur*1500;
                    Pajak = Gajipokok/100;
                    Total = Gajipokok+Tunjangan-Pajak;
                    isipajak.setText("Rp. "+String.valueOf(Pajak));
                    isitunjangan.setText("Rp. "+String.valueOf(Tunjangan));
                    isitotal.setText("Rp. "+String.valueOf(Total));
                    
                    KoneksiDB koneksi = new KoneksiDB();
                    try 
                    {
                        statement = koneksi.getKoneksi().createStatement();
                        String sql = "INSERT INTO gaji VALUES ('"
                                    + a1 + "','" + a2 + "','" + a3 + "','" + a4 + "','" + a5 + "','" 
                                    + Gajipokok + "','" + Jamlembur + "','" + Tunjangan + "','" + Pajak + "','" + Total + "')";
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
                    } catch (ClassNotFoundException ex) 
                    {
                        Logger.getLogger(gaji.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) 
                    {
                        Logger.getLogger(gaji.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (NumberFormatException ex) 
                {
                 JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext)
                {
                 JOptionPane.showMessageDialog(rootPane,"SALAH");
                }
                       
            }
        });
        
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
                new menuadmin();
            }
            
        });
    }
    
}

