/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Donne;

import static Donne.Etudiants.url;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Professeurs extends javax.swing.JFrame {

    /**
     * Creates new form Professeurs
     */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    static String url = "jdbc:mysql://localhost/gestion";
    static String user = "root";
    static String password = "";
    public Professeurs() {
        initComponents();
        Table();
        TableCours();
        appelprof();
        appelMatiere();
        appelMatiere1();
    }
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Actualiser() {
        txtmat.setText("");
        txtnp.setText("");
        ComboSpe.setSelectedItem("");
        txtcontact.setText("");
        Badd.setEnabled(true);
    }
    public void ActualiserCours() {
        txtidcours.setText("");
        txtclassS.setSelectedItem("");
        ComboMat.setSelectedItem("");
        txtjour.setSelectedItem("");
        txtheure.setSelectedItem("");
        txtCombo.setSelectedItem("");
        BaddC.setEnabled(true);
    }
    public void Table() {
        String[] professeur = {"Matricules", "Noms & Prénoms", "Spécialités", "Contacts"};
        String[] afficher = new String[5];

        DefaultTableModel model = new DefaultTableModel(null, professeur);
        String sql = "select * from professeur";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                afficher[0] = rs.getString("matProf");
                afficher[1] = rs.getString("nomPrenom");
                afficher[2] = rs.getString("specialite");
                afficher[3] = rs.getString("contact");
                model.addRow(afficher);
            }
            jTable1.setModel(model);
            con.close();
        } catch (Exception e) {

        }
    }
    private void RechercherProf(String recherche){
        String util[] = {
            "Matricules", 
            "Noms & Prénoms", 
            "Spécialités", 
            "Contacts"
        };
        String vue[] = new String[5];
        DefaultTableModel model = new DefaultTableModel(null, util);
        String sql = "select * from professeur where matProf like '%"+recherche+"%'";
        try {
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                vue[0] = rs.getString("matProf");
                vue[1] = rs.getString("nomPrenom");
                vue[2] = rs.getString("specialite");
                vue[3] = rs.getString("contact");
                model.addRow(vue);
            }
            jTable1.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void TableCours() {
        String[] cours = {"ID", "Classes", "Matières", "Jours", "Heures", "Mat-Prof"};
        String[] afficher = new String[7];

        DefaultTableModel model = new DefaultTableModel(null, cours);
        String sql = "select * from cours";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                afficher[0] = rs.getString("id");
                afficher[1] = rs.getString("classe");
                afficher[2] = rs.getString("idmatiere");
                afficher[3] = rs.getString("jour");
                afficher[4] = rs.getString("heure");
                afficher[5] = rs.getString("matProf");
                model.addRow(afficher);
            }
            jTable2.setModel(model);
            con.close();
        } catch (Exception e) {

        }
    }
    private void RechercherCours(String recherche){
        String util[] = {
            "ID", 
            "Classes", 
            "Matières", 
            "Jours", 
            "Heures", 
            "Mat-Prof"
        };
        String vue[] = new String[7];
        DefaultTableModel model = new DefaultTableModel(null, util);
        String sql = "select * from cours where id like '%"+recherche+"%'";
        try {
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                vue[0] = rs.getString("id");
                vue[1] = rs.getString("classe");
                vue[2] = rs.getString("idmatiere");
                vue[3] = rs.getString("jour");
                vue[4] = rs.getString("heure");
                vue[5] = rs.getString("matProf");
                model.addRow(vue);
            }
            jTable2.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void appelprof(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from professeur";
            //PreparedStatement pst = con.prepareStatement(sql);
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                txtCombo.addItem(rs.getString("matProf"));
            }
        } catch (Exception e) {

        }
    }
    public void appelMatiere(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from matieres";
            //PreparedStatement pst = con.prepareStatement(sql);
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                ComboMat.addItem(rs.getString("idmatiere"));
            }
        } catch (Exception e) {

        }
    }
    public void appelMatiere1(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from matieres";
            //PreparedStatement pst = con.prepareStatement(sql);
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                ComboSpe.addItem(rs.getString("idmatiere"));
            }
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmat = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtnp = new javax.swing.JTextField();
        txtcontact = new javax.swing.JTextField();
        Badd = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Spécialité = new javax.swing.JLabel();
        ComboSpe = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtclassS = new javax.swing.JComboBox();
        txtjour = new javax.swing.JComboBox();
        txtheure = new javax.swing.JComboBox();
        BaddC = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtidcours = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        txtCombo = new javax.swing.JComboBox();
        ComboMat = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Matricule");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nom & Prénoms");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contact");

        txtmat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtmat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmatKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Recherche");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtnp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtcontact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Badd.setBackground(new java.awt.Color(102, 255, 102));
        Badd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Badd.setText("Ajouter");
        Badd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaddActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 153, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Modifier");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Actualiser");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Spécialité.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Spécialité.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Spécialité.setText("Spécialité");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Spécialité, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(txtnp)
                    .addComponent(txtcontact)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Badd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ComboSpe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Spécialité, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(ComboSpe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Badd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INFORMATIONS SEANCES DE COURS");

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Classe");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Matière");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Jour");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Heure");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Matricule Professeur");

        txtclassS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtclassS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Licence 1", "Licence 2", "Licence 3", "Master 1", "Master 2" }));

        txtjour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtjour.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LUNDI", "MARDI", "MERCREDI", "JEUDI", "VENDREDI", "SAMEDI" }));

        txtheure.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtheure.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 Heure", "2 Heures", "3 Heures", "4 Heures", "5 Heures" }));

        BaddC.setBackground(new java.awt.Color(102, 255, 102));
        BaddC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BaddC.setText("Ajouter");
        BaddC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaddCActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 51, 51));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Supprimer");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Actualiser");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Modifier");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("ID");

        txtidcours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtidcours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidcoursKeyReleased(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Recherche");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txtCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        ComboMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 65, Short.MAX_VALUE)
                                        .addComponent(jButton8))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ComboMat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtclassS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtjour, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtheure, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtidcours)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BaddC, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcours, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtclassS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(ComboMat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjour, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtheure, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txtCombo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BaddC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("INFORMATIONS PROFESSEURS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(888, 760));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaddActionPerformed
        // Ajouter un prof
        if (txtmat.getText().trim().isEmpty() || txtnp.getText().trim().isEmpty()
                || txtcontact.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires!");

        } else {
            try {
                Connect();
                String sql = "insert into professeur (matProf,nomPrenom,specialite,contact) value(?,?,?,?)"; //La requete pour faire appel aux imformations dans la base
                pst = con.prepareStatement(sql);
                pst.setString(1, txtmat.getText());
                pst.setString(2, txtnp.getText());
                pst.setString(3, ComboSpe.getSelectedItem().toString());
                pst.setString(4, txtcontact.getText());
                pst.execute(); // EXECUTION DE LA REQUETE

                con.close();
                JOptionPane.showMessageDialog(null, "Enregistrement réussi");
                Table();
                Actualiser();
                //Badd.setEnabled(false);
            } catch (Exception e) {
                //e.printStackTrace(); //POUR GERER LES ERREURS 
                JOptionPane.showMessageDialog(null, "Le professeur " + txtmat.getText() + " " + "est deja dans la base");
            }
        }
    }//GEN-LAST:event_BaddActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selct = jTable1.getSelectedRow();
        txtmat.setText(model.getValueAt(selct, 0).toString());
        txtnp.setText(model.getValueAt(selct, 1).toString());
        ComboSpe.setSelectedItem(model.getValueAt(selct, 2).toString());
        txtcontact.setText(model.getValueAt(selct, 3).toString());
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (txtmat.getText().trim().isEmpty() || txtnp.getText().trim().isEmpty()
                || txtcontact.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune modification, s'il vous plaît veuillez choisir un professeur à modifier ");
        } else {
            try {
                /*if(txtmatricule.getText().length()!=19){
                 JOptionPane.showMessageDialog(null, "Aucune modification\n S'il vous plaît, veuillez choisir un étudiant");
                 }else{*/
                Connect();
                pst = con.prepareStatement("update professeur set nomPrenom=?,specialite=?,contact=? where matProf=?");
                pst.setString(4, txtmat.getText());
                pst.setString(1, txtnp.getText());
                pst.setString(2, ComboSpe.getSelectedItem().toString());
                pst.setString(3, txtcontact.getText());
                pst.executeUpdate(); // EXECUTION DE LA REQUETE
                con.close();
                JOptionPane.showMessageDialog(null, "Professeur modifié avec succès");
                Table();
                // }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtmat.getText().trim().isEmpty() || txtnp.getText().trim().isEmpty()
                || txtcontact.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un professeur");

        } else {

            try {
                if (JOptionPane.showConfirmDialog(null, "Attention, Voulez-vous vraiment supprimer",
                        "Supprimer Professeur", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Connect();
                    pst = con.prepareStatement("delete from professeur where matProf=?");
                    pst.setString(1, txtmat.getText());
                    pst.execute(); // EXECUTION DE LA REQUETE
                    System.out.println("Supprimer");
                    JOptionPane.showMessageDialog(null, "Professeur Supprimé avec succés");
                    con.close();
                    Table();
                    Actualiser();
                    //Bdelete.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Actualiser();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BaddCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaddCActionPerformed
        // Ajouter un cours
        if (txtidcours.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires!");

        } else {
            try {
                Connect();
                String sql = "insert into cours (id,classe,idmatiere,jour,heure,matProf) value(?,?,?,?,?,?)"; //La requete pour faire appel aux imformations dans la base
                pst = con.prepareStatement(sql);
                pst.setString(1, txtidcours.getText());
                pst.setString(2, txtclassS.getSelectedItem().toString());
                pst.setString(3, ComboMat.getSelectedItem().toString());
                pst.setString(4, txtjour.getSelectedItem().toString());
                pst.setString(5, txtheure.getSelectedItem().toString());
                pst.setString(6, txtCombo.getSelectedItem().toString());
                pst.execute(); // EXECUTION DE LA REQUETE

                con.close();
                JOptionPane.showMessageDialog(null, "Enregistrement réussi");
                TableCours();
                ActualiserCours();
                //Badd.setEnabled(false);
            } catch (Exception e) {
                //e.printStackTrace(); //POUR GERER LES ERREURS 
                JOptionPane.showMessageDialog(null, "Le cours " + txtidcours.getText() + " " + "est deja enregistré");
            }
        }
    }//GEN-LAST:event_BaddCActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Supprimer un cours
        if (txtidcours.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un professeur");

        } else {

            try {
                if (JOptionPane.showConfirmDialog(null, "Attention, Voulez-vous vraiment supprimer",
                        "Supprimer Cours", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Connect();
                    pst = con.prepareStatement("delete from cours where id=?");
                    pst.setString(1, txtidcours.getText());
                    pst.execute(); // EXECUTION DE LA REQUETE
                    System.out.println("Supprimer");
                    JOptionPane.showMessageDialog(null, "Cours Supprimé avec succés");
                    con.close();
                    TableCours();
                    ActualiserCours();
                    //Bdelete.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Modifier un cours
        if (txtidcours.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune modification, s'il vous plaît veuillez choisir un cours à modifier ");
        } else {
            try {
                Connect();
                pst = con.prepareStatement("update cours set classe=?,idmatiere=?,jour=?,heure=?,matProf=? where id=?");
                pst.setString(6, txtidcours.getText());
                pst.setString(1, txtclassS.getSelectedItem().toString());
                pst.setString(2, ComboMat.getSelectedItem().toString());
                pst.setString(3, txtjour.getSelectedItem().toString());
                pst.setString(4, txtheure.getSelectedItem().toString());
                pst.setString(5, txtCombo.getSelectedItem().toString());
                pst.executeUpdate(); // EXECUTION DE LA REQUETE
                con.close();
                JOptionPane.showMessageDialog(null, "Cours modifié avec succès");
                TableCours();
                // }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // actualiser un cours
        ActualiserCours();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // Mousse pour la table cours 
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selct = jTable2.getSelectedRow();
        txtidcours.setText(model.getValueAt(selct, 0).toString());
        txtclassS.setSelectedItem(model.getValueAt(selct, 1).toString());
        ComboMat.setSelectedItem(model.getValueAt(selct, 2).toString());
        txtjour.setSelectedItem(model.getValueAt(selct, 3).toString());
        txtheure.setSelectedItem(model.getValueAt(selct, 4).toString());
        txtCombo.setSelectedItem(model.getValueAt(selct, 5).toString());
    }//GEN-LAST:event_jTable2MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        RechercherProf(txtmat.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        RechercherCours(txtidcours.getText());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtmatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmatKeyReleased
        // TODO add your handling code here:
        RechercherProf(txtmat.getText());
    }//GEN-LAST:event_txtmatKeyReleased

    private void txtidcoursKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidcoursKeyReleased
        // TODO add your handling code here:
        RechercherCours(txtidcours.getText());
    }//GEN-LAST:event_txtidcoursKeyReleased

    private void ComboMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Professeurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Professeurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Professeurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Professeurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Professeurs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Badd;
    private javax.swing.JButton BaddC;
    private javax.swing.JComboBox ComboMat;
    private javax.swing.JComboBox<String> ComboSpe;
    private javax.swing.JLabel Spécialité;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox txtCombo;
    private javax.swing.JComboBox txtclassS;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JComboBox txtheure;
    private javax.swing.JTextField txtidcours;
    private javax.swing.JComboBox txtjour;
    private javax.swing.JTextField txtmat;
    private javax.swing.JTextField txtnp;
    // End of variables declaration//GEN-END:variables
}
