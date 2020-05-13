
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class data extends JFrame
{
    JTable tabel;
    JButton home,gaji,data,petunjuk,admin,lihat;
    JLabel label;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID", "Nama", "Posisi", "Gaji Pokok","Jam Lembur","Tunjangan","Total Gaji"};
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public data()
    {
        label = new JLabel("APLIKASI PERHITUNGAN GAJI PT. VERETAN JAYA");
        
        home = new JButton("Home");
        gaji = new JButton("Gaji");
        data = new JButton("Data");
        petunjuk = new JButton("Petunjuk");
        admin = new JButton("Admin");
        lihat = new JButton("Show");
        
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setLayout(null);
        add(label);

        add(home);
        add(gaji);
        add(data);
        add(petunjuk);
        add(admin);
        add(lihat);
        add(scrollPane);
        
        home.setBounds(10, 10, 100, 30);
        gaji.setBounds(10, 50, 100, 30);
        data.setBounds(10, 90, 100, 30);
        petunjuk.setBounds(10, 130, 100, 30);
        admin.setBounds(1070, 10, 100, 30);
        label.setBounds(500, 510, 300, 30);
        lihat.setBounds(580, 430, 100, 30);
        
        scrollPane.setBounds(140, 80, 900, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setSize(1200,600); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        lihat.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
               KoneksiDB koneksi = new KoneksiDB();
               int jmlData = 0;
               String data[][] = new String[getJmldata()][7];
               try 
               {
                    statement = koneksi.getKoneksi().createStatement();
                    String sql = "SELECT * FROM gaji";
                    resultSet = statement.executeQuery(sql);
                    while(resultSet.next())
                    {
                        data[jmlData][0] = resultSet.getString("id");
                        data[jmlData][1] = resultSet.getString("nama");
                        data[jmlData][2] = resultSet.getString("posisi");
                        data[jmlData][3] = resultSet.getString("gaji_pokok");
                        data[jmlData][4] = resultSet.getString("jam_lembur");
                        data[jmlData][5] = resultSet.getString("tunjangan");
                        data[jmlData][6] = resultSet.getString("gaji_total");
                        jmlData++;
                    }
                    statement.close();
                } catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!","Hasil",JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) 
                {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!","Hasil",JOptionPane.ERROR_MESSAGE);
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
    
    public int getJmldata()
    {
        int jmlData = 0;
        try
        {
            String query = "SELECT * FROM gaji";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
}
