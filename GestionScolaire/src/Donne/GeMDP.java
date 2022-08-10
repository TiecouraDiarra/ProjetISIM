/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Donne;

import static Donne.Classes.url;
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
public class GeMDP extends javax.swing.JFrame {

    /**
     * Creates new form GeMDP
     */
    //CONSTRUCTEUR PAR DEFAUT
    public GeMDP() {
        initComponents();
        Table();
        Table2();
        
    }
    //IMPORTER LES BIBLIOTHEQUES DE CONNECTION
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    static String url = "jdbc:mysql://localhost/gestion";
    static String user = "root";
    static String password = "";
    
    //METHODE CONNECTION
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //==================METHODDE POUR ACTUALISER LES CHAMPS====================================
     public void Actualiser() {
        txtiden.setText("");
        txtnom.setText("");
        txtmdp.setText("");
        txtruser.setText("");
        txtradmin.setText("");
    }
     
     //==================METHODDE POUR AFFICHER LA LISTE DANS UN TABLEAU(UTILISATEUR)====================================
     public void Table2() {
        String[] login = {"ID", "NOM UTILISTATEUR", "MOT DE PASSE"};
        String[] afficher = new String[4];

        DefaultTableModel model = new DefaultTableModel(null, login);
        String sql = "select * from login";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                afficher[0] = rs.getString("ref");
                afficher[1] = rs.getString("nom");
                afficher[2] = rs.getString("mdp");
                model.addRow(afficher);
            }
            jTable2.setModel(model);
            con.close();
        } catch (Exception e) {

        }
    }
     //==================METHODDE POUR RECHERCHER UN ADMINISTRATEUR====================================
     private void RechercherAdmin(String recherche){
        String util[] = {
            "ID", 
            "NOM UTILISTATEUR", 
            "MOT DE PASSE"
        };
        String vue[] = new String[4];
        DefaultTableModel model = new DefaultTableModel(null, util);
        String sql = "select * from login where ref like '%"+recherche+"%'";
        try {
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                vue[0] = rs.getString("ref");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("mdp");
                model.addRow(vue);
            }
            jTable2.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     //==================METHODDE POUR AFFICHER LA LISTE DANS UN TABLEAU(ADMINISTRATEUR)====================================
     public void Table() {
        String[] users = {"ID", "NOM UTILISTATEUR", "MOT DE PASSE"};
        String[] afficher = new String[4];

        DefaultTableModel model = new DefaultTableModel(null, users);
        String sql = "select * from users";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                afficher[0] = rs.getString("id");
                afficher[1] = rs.getString("nom");
                afficher[2] = rs.getString("mdp");
                model.addRow(afficher);
            }
            jTable1.setModel(model);
            con.close();
        } catch (Exception e) {

        }
    }
     //==================METHODDE POUR RECHERCHER UN UTILISATEUR====================================
     private void RechercherUser(String recherche){
        String util[] = {
            "ID", 
            "NOM UTILISTATEUR", 
            "MOT DE PASSE"
        };
        String vue[] = new String[4];
        DefaultTableModel model = new DefaultTableModel(null, util);
        String sql = "select * from users where id like '%"+recherche+"%'";
        try {
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                vue[0] = rs.getString("id");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("mdp");
                model.addRow(vue);
            }
            jTable1.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtiden = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtmdp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtruser = new javax.swing.JTextField();
        txtradmin = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Identifiant");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nom");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mot de passe");

        txtiden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtnom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtmdp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Inserer dans Utulisateur");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Inserer dans Administrateur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Supprimer dans Utulisateur");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Supprimer dans Administrateur");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 153, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Modifier dans Administrateur");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 153, 51));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Modifier dans Utulisateur");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Recherche dans USER");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Recherhce dans Administrateur");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtruser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtruser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtruserActionPerformed(evt);
            }
        });
        txtruser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtruserKeyReleased(evt);
            }
        });

        txtradmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtradmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtradminKeyReleased(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Actualiser");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtradmin)
                    .addComponent(txtruser)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtiden, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(txtnom)
                            .addComponent(txtmdp)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtiden, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmdp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtruser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtradmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Gestion des mots de passe");

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mots de passe des utilisateurs");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mots de passe des administrateurs");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(972, 572));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //=========================== BOUTTON AJOUTER UN ADMINISTRATEUR=================================
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Inserer dans admin
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires!");

        } else {
            try {
                Connect();
                String sql = "insert into login (ref,nom,mdp) value(?,?,?)"; //La requete pour faire appel aux imformations dans la base
                pst = con.prepareStatement(sql);
                pst.setString(1, txtiden.getText());
                pst.setString(2, txtnom.getText());
                pst.setString(3, txtmdp.getText());
                pst.execute(); // EXECUTION DE LA REQUETE

                //con.close();
                JOptionPane.showMessageDialog(null, "Enregistrement réussi");
                Table2();
                Actualiser();
                //Badd.setEnabled(false);
            } catch (Exception e) {
                //e.printStackTrace(); //POUR GERER LES ERREURS 
                JOptionPane.showMessageDialog(null, "L'Adminatrateur " + txtiden.getText() + " " + "est deja enregistré");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //=========================== BOUTTON SUPPRIMER UN ADMINISTRATEUR=================================
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un admin");

        } else {

            try {
                if (JOptionPane.showConfirmDialog(null, "Attention, Voulez-vous vraiment supprimer",
                        "Supprimer Admin", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Connect();
                    pst = con.prepareStatement("delete from login where ref=?");
                    pst.setString(1, txtiden.getText());
                    pst.execute(); // EXECUTION DE LA REQUETE
                    System.out.println("Supprimer");
                    JOptionPane.showMessageDialog(null, "Admin Supprimé avec succés");
                    con.close();
                    Table2();
                    Actualiser();
                    //Bdelete.setEnabled(false);
                }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    //=========================== BOUTTON MODIFIER UN ADMINISTRATEUR=================================
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune modification, s'il vous plaît veuillez selectionner un admin à modifier ");
        } else {
            try {
                Connect();
                pst = con.prepareStatement("update login set nom=?, mdp=? where ref=?");
                pst.setString(3, txtiden.getText());
                pst.setString(1, txtnom.getText());
                pst.setString(2, txtmdp.getText());
                pst.executeUpdate(); // EXECUTION DE LA REQUETE
                con.close();
                JOptionPane.showMessageDialog(null, "Admin modifié avec succès");
                Table2();
                // }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int selct = jTable2.getSelectedRow();
        txtiden.setText(model.getValueAt(selct, 0).toString());
        txtnom.setText(model.getValueAt(selct, 1).toString());
        txtmdp.setText(model.getValueAt(selct, 2).toString());
    }//GEN-LAST:event_jTable2MouseReleased

    //=========================== BOUTTON AJOUTER UN UTILISATEUR=================================
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Inserer dans user
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires!");

        } else {
            try {
                Connect();
                String sql = "insert into users (id,nom,mdp) value(?,?,?)"; //La requete pour faire appel aux imformations dans la base
                pst = con.prepareStatement(sql);
                pst.setString(1, txtiden.getText());
                pst.setString(2, txtnom.getText());
                pst.setString(3, txtmdp.getText());
                pst.execute(); // EXECUTION DE LA REQUETE

                //con.close();
                JOptionPane.showMessageDialog(null, "Enregistrement réussi");
                Table();
                Actualiser();
                //Badd.setEnabled(false);
            } catch (Exception e) {
                //e.printStackTrace(); //POUR GERER LES ERREURS 
                JOptionPane.showMessageDialog(null, "L'utilisateur " + txtiden.getText() + " " + "est deja enregistré");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    //=========================== BOUTTON SUPPRIMER UN UTILISATEUR=================================
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // supprimer user
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un user");

        } else {

            try {
                if (JOptionPane.showConfirmDialog(null, "Attention, Voulez-vous vraiment supprimer",
                        "Supprimer User", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    Connect();
                    pst = con.prepareStatement("delete from users where id=? and nom=? and mdp=?");
                    pst.setString(1, txtiden.getText());
                    pst.setString(2, txtnom.getText());
                    pst.setString(3, txtmdp.getText());
                    pst.execute(); // EXECUTION DE LA REQUETE
                    System.out.println("Supprimer");
                    JOptionPane.showMessageDialog(null, "User Supprimé avec succés");
                    con.close();
                    Table();
                    Actualiser();
                    //Bdelete.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(null, "IMPOSSIBLE");
                }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //=========================== BOUTTON MODIFIER UN UTILISATEUR=================================
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Modifier user
        if (txtiden.getText().trim().isEmpty() || txtnom.getText().trim().isEmpty() || txtmdp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucune modification, s'il vous plaît veuillez selectionner un user à modifier ");
        } else {
            try {
                Connect();
                pst = con.prepareStatement("update users set nom=?, mdp=? where id=?");
                pst.setString(3, txtiden.getText());
                pst.setString(1, txtnom.getText());
                pst.setString(2, txtmdp.getText());
                pst.executeUpdate(); // EXECUTION DE LA REQUETE
                con.close();
                JOptionPane.showMessageDialog(null, "User modifié avec succès");
                Table();
                // }
            } catch (Exception e) {
                e.printStackTrace(); //POUR GERER LES ERREURS 
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selct = jTable1.getSelectedRow();
        txtiden.setText(model.getValueAt(selct, 0).toString());
        txtnom.setText(model.getValueAt(selct, 1).toString());
        txtmdp.setText(model.getValueAt(selct, 2).toString());
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Actualiser();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtruserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtruserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtruserActionPerformed

    //=========================== BOUTTON RECHERCHER UN UTILISATEUR=================================
    private void txtruserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtruserKeyReleased
        // TODO add your handling code here:
        RechercherUser(txtruser.getText());
    }//GEN-LAST:event_txtruserKeyReleased

    //=========================== BOUTTON RECHERCHER UN ADMINISTRATEUR=================================
    private void txtradminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtradminKeyReleased
        // TODO add your handling code here:
        RechercherAdmin(txtradmin.getText());
    }//GEN-LAST:event_txtradminKeyReleased

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
            java.util.logging.Logger.getLogger(GeMDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeMDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeMDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeMDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeMDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtiden;
    private javax.swing.JTextField txtmdp;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtradmin;
    private javax.swing.JTextField txtruser;
    // End of variables declaration//GEN-END:variables
}
