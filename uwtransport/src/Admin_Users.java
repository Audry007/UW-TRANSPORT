/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author audry
 */
public class Admin_Users extends javax.swing.JFrame {

    /**
     * Creates new form Admin_Users
     */
    private databaseMapper dbm;
    public Admin_Users() {
        initComponents();
        dbm=new databaseMapper();
        setTitle("UW-Transport");
        
        count_user();
        count_role();
        count_exercer();
        
        display_users();
        display_role();
        display_exercer();
    }

     //============================ void pour clear users ==========================
     public void clearInput(utilisateur t){
         matricule.setText("");
         nom.setText("");
         prenom.setText("");
         telephone.setText("");
         email.setText("");
         username.setText("");
         password.setText("");
     }
     
     //============================ void pour clear users ==========================
     public void clearRole(role t){
         id_r.setText("");
         nom_r.setText("");
     }
     
     //============================ void pour clear users ==========================
     public void clearExercer(exercer t){
         id_e.setText("");
         date_e.setText("");
         id_ro.setText("");
         matricule_e.setText("");
     }
     
    //======================== void pour count ticket ===============================
     public void count_user(){
         int total=dbm.count_utilisateur();
         found_u.setText(""+total+"");
         count_u.setText(""+total+"");
     }
     
    //======================== void pour count chaufeur ===============================
     public void count_role(){
         int total=dbm.count_role();
         count_r.setText(""+total+"");
         found_r.setText(""+total+"");
     } 
    //======================== void pour count chaufeur ===============================
     public void count_exercer(){
         int total=dbm.selectcount_exercer();
         count_e.setText(""+total+"");
         found_e.setText(""+total+"");
     } 
     
   //========================== void pour l'affichage du ticket ==========================
     public void display_users(){
        List<utilisateur> found = dbm.select_utilisateur();
        DefaultTableModel df = (DefaultTableModel) table_u.getModel();
        df.setRowCount(0);

        Vector v2;
        for (utilisateur p : found) {
            v2 = new Vector();
            
            v2.add(p.getMatricule());
            v2.add(p.getNom_user());
            v2.add(p.getPrenom_user());
            v2.add(p.getTelephone_user());
            v2.add(p.getEmail_user());
            v2.add(p.getUsername());
            v2.add(p.getMotdepasse());

            df.addRow(v2);
        }

     }
     
   //==================== void pour affichage Reservation =====================
    public void display_role(){
        List<role> found = dbm.select_role();
        DefaultTableModel df = (DefaultTableModel) table_r.getModel();
        df.setRowCount(0);

        Vector v2;
        for (role p : found) {
            v2 = new Vector();
            
            v2.add(p.getId_role());
            v2.add(p.getNom_role());
            
            df.addRow(v2);

      }
    }
   //==================== void pour affichage Reservation =====================
    public void display_exercer(){
        List<exercer> found = dbm.select_exercer();
        DefaultTableModel df = (DefaultTableModel) table_e.getModel();
        df.setRowCount(0);

        Vector v2;
        for (exercer p : found) {
            v2 = new Vector();
            
            v2.add(p.getId_exercer());
            v2.add(p.getDate_debut());
            v2.add(p.getId_role());
            v2.add(p.getMatricule());
            
            df.addRow(v2);

      }
    }
     
      //========================== void pour search ticket ==========================
           public void Search_user(String txt){
                DefaultTableModel model=(DefaultTableModel) table_u.getModel();
                TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<>(model);
                table_u.setRowSorter(sorter);

                sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txt));
           }

      //========================== void pour search ticket ==========================
           public void Search_role(String txt){
                DefaultTableModel model=(DefaultTableModel) table_r.getModel();
                TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<>(model);
                table_r.setRowSorter(sorter);

                sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txt));
           }

      //========================== void pour search ticket ==========================
           public void Search_exercer(String txt){
                DefaultTableModel model=(DefaultTableModel) table_e.getModel();
                TableRowSorter<DefaultTableModel> sorter= new TableRowSorter<>(model);
                table_e.setRowSorter(sorter);

                sorter.setRowFilter(RowFilter.regexFilter("(?i)"+txt));
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Dashbord = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        prenom = new javax.swing.JTextField();
        matricule = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_u = new javax.swing.JTable();
        btn_u = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        input_u = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        found_u = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        count_u = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_e = new javax.swing.JTable();
        btn_e = new javax.swing.JButton();
        input_e = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        found_e = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        found_e1 = new javax.swing.JLabel();
        found_e2 = new javax.swing.JLabel();
        count_e = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        id_r = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        nom_r = new javax.swing.JTextField();
        clear = new javax.swing.JButton();
        add_r = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_r = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        found_r = new javax.swing.JLabel();
        input_r = new javax.swing.JTextField();
        btn_r = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        c = new javax.swing.JLabel();
        count_r = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        add_e = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        matricule_e = new javax.swing.JTextField();
        id_ro = new javax.swing.JTextField();
        id_e = new javax.swing.JTextField();
        date_e = new javax.swing.JTextField();
        clear2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 1000));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(200, 197, 197));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/uwtransportLog_200px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(200, 197, 197));

        jPanel7.setBackground(new java.awt.Color(200, 197, 197));

        Dashbord.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Dashbord.setForeground(new java.awt.Color(82, 81, 81));
        Dashbord.setText("Dashboard");
        Dashbord.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        Dashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashbordMouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Dashboard_27px.png"))); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(82, 81, 81));
        jButton1.setText("Client");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Client_27px.png"))); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(82, 81, 81));
        jButton3.setText("Reservation");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reservation_27px.png"))); // NOI18N

        jButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(82, 81, 81));
        jButton4.setText("Vehicule");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Vehicule_27px.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        jButton5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(82, 81, 81));
        jButton5.setText("Ticket");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Ticket_27px.png"))); // NOI18N

        jButton6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(82, 81, 81));
        jButton6.setText("Chaufeur");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Chauffeur_27px.png"))); // NOI18N

        jButton7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(82, 81, 81));
        jButton7.setText("Voyage");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Voyage_27px.png"))); // NOI18N

        jButton8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(82, 81, 81));
        jButton8.setText("User");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Trajectoire_27px.png"))); // NOI18N

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Client_27px.png"))); // NOI18N

        jButton10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(82, 81, 81));
        jButton10.setText("Trajectoire");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(Dashbord, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dashbord, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 200, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(200, 197, 197));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 70));
        jPanel3.setRequestFocusEnabled(false);

        Logout.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        Logout.setForeground(new java.awt.Color(82, 81, 81));
        Logout.setText("Log Out");
        Logout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logout_27px.png"))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 38)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(34, 97, 168));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Users Interface");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(147, 147, 147));

        jPanel8.setBackground(new java.awt.Color(200, 197, 197));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(82, 81, 81));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Formulaire Users");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(82, 81, 81));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Matricule");

        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        add.setForeground(new java.awt.Color(82, 81, 81));
        add.setText("Add+");
        add.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(82, 81, 81));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nom");

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(82, 81, 81));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Prenom");

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(82, 81, 81));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Telephone");

        telephone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telephone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        prenom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prenom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        matricule.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matricule.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        nom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });

        username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        username.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(82, 81, 81));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Email");

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(82, 81, 81));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Usernamr");

        clear1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        clear1.setForeground(new java.awt.Color(82, 81, 81));
        clear1.setText("Clear");
        clear1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel24.setText("Password");

        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prenom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(prenom, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telephone, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(200, 197, 197));

        table_u.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        table_u.setForeground(new java.awt.Color(82, 81, 81));
        table_u.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Matricule", "Nom", "Prenom", "Telephone", "Email", "Username", "Password"
            }
        ));
        table_u.setToolTipText("");
        table_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_uMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_u);

        btn_u.setBackground(new java.awt.Color(200, 197, 197));
        btn_u.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_u.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        btn_u.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_uMouseClicked(evt);
            }
        });
        btn_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(82, 81, 81));
        jButton11.setText("Delete");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(82, 81, 81));
        jButton12.setText("Update");
        jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        input_u.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_u.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        input_u.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_uActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel22.setText("Search found :");

        found_u.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        found_u.setForeground(new java.awt.Color(255, 51, 0));
        found_u.setText("15");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(found_u, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(found_u, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Client_27px.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(82, 81, 81));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Users");

        count_u.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        count_u.setForeground(new java.awt.Color(255, 51, 51));
        count_u.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        count_u.setText("11");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_u, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_u, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(count_u, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_u)
                    .addComponent(btn_u, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(count_u, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel11.setBackground(new java.awt.Color(200, 197, 197));
        jPanel11.setPreferredSize(new java.awt.Dimension(450, 299));

        table_e.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        table_e.setForeground(new java.awt.Color(82, 81, 81));
        table_e.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Date_debut", "id_Role", "Matricule"
            }
        ));
        table_e.setToolTipText("");
        table_e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_eMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_e);

        btn_e.setBackground(new java.awt.Color(200, 197, 197));
        btn_e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        btn_e.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eMouseClicked(evt);
            }
        });
        btn_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eActionPerformed(evt);
            }
        });

        input_e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        input_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_eActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel26.setText("Search found :");

        found_e.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        found_e.setForeground(new java.awt.Color(255, 51, 0));
        found_e.setText("15");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(found_e, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(found_e, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(82, 81, 81));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Exerces");

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel21.setText("Number of user in fonction :");

        found_e1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        found_e1.setForeground(new java.awt.Color(255, 51, 0));
        found_e1.setText("15");

        found_e2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        found_e2.setForeground(new java.awt.Color(255, 51, 0));
        found_e2.setText("15");

        count_e.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        count_e.setForeground(new java.awt.Color(255, 51, 51));
        count_e.setText("15");

        jButton15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(82, 81, 81));
        jButton15.setText("Update");
        jButton15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 2, true));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(input_e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_e, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_e, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(found_e1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(218, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(218, 218, 218)
                    .addComponent(found_e2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(218, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(166, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(count_e, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jLabel21)))
                .addGap(2, 2, 2)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(input_e, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_e, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(135, 135, 135)
                    .addComponent(found_e1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(found_e2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(137, Short.MAX_VALUE)))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(85, Short.MAX_VALUE)))
        );

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(34, 97, 168));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("UW-TRANSPORT");

        jPanel10.setBackground(new java.awt.Color(200, 197, 197));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(82, 81, 81));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Formulaire role");

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(82, 81, 81));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("id");

        id_r.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(82, 81, 81));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Nom");

        nom_r.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom_r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        clear.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(82, 81, 81));
        clear.setText("Clear");
        clear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        add_r.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        add_r.setForeground(new java.awt.Color(82, 81, 81));
        add_r.setText("Add+");
        add_r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        add_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_rActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_r, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(nom_r)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(add_r, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_r, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom_r, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(185, Short.MAX_VALUE)
                    .addComponent(add_r, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );

        jPanel14.setBackground(new java.awt.Color(200, 197, 197));

        table_r.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        table_r.setForeground(new java.awt.Color(82, 81, 81));
        table_r.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nom"
            }
        ));
        table_r.setToolTipText("");
        table_r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_r);

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(82, 81, 81));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Role");

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel23.setText("Search found :");

        found_r.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        found_r.setForeground(new java.awt.Color(255, 51, 0));
        found_r.setText("15");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(found_r, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(found_r, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        input_r.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        input_r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        input_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_rActionPerformed(evt);
            }
        });

        btn_r.setBackground(new java.awt.Color(200, 197, 197));
        btn_r.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        btn_r.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        btn_r.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_rMouseClicked(evt);
            }
        });
        btn_r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(82, 81, 81));
        jButton13.setText("Update");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(82, 81, 81));
        jButton14.setText("Delete");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        c.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        c.setText("Number of fonction we have :");

        count_r.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        count_r.setForeground(new java.awt.Color(255, 0, 0));
        count_r.setText("14");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(27, 27, 27)
                        .addComponent(c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(count_r, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input_r)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_r, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(c)
                    .addComponent(count_r))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_r)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_r, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(200, 197, 197));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(82, 81, 81));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Formulaire Exerces");

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(82, 81, 81));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("id");

        add_e.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        add_e.setForeground(new java.awt.Color(82, 81, 81));
        add_e.setText("Add+");
        add_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        add_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_eActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(82, 81, 81));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Date_debut");

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(82, 81, 81));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("id_Role");

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(82, 81, 81));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Matricule");

        matricule_e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        matricule_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        id_ro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_ro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        id_e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));

        date_e.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date_e.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        date_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_eActionPerformed(evt);
            }
        });

        clear2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        clear2.setForeground(new java.awt.Color(82, 81, 81));
        clear2.setText("Clear");
        clear2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 97, 168), 2, true));
        clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id_e, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id_ro, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(add_e, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(matricule_e, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_e, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_e, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id_ro, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricule_e, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_e, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DashbordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashbordMouseClicked
        // TODO add your handling code here:
        this.setVisible(true);
    }//GEN-LAST:event_DashbordMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        // TODO add your handling code here:
        index log_out=new index();
        log_out.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        String matricul=matricule.getText();
        String num1=nom.getText();
        String prenon=prenom.getText();

        utilisateur del=new utilisateur(matricul);

        int confirm = JOptionPane.showConfirmDialog(
            rootPane,
            "Do you want to delete this User ? ",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            if(dbm.delete_utilisateur(del)>0){
                JOptionPane.showMessageDialog(rootPane, "Users "+num1+" "+prenon+" is deleted very well!");

                        add.setVisible(true);
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
                        clearInput(del);
            }else{
                JOptionPane.showMessageDialog(rootPane, "User not deleted try again!");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "you refused to delete User "+" "+num1);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void input_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_uActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_uActionPerformed

    private void btn_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eActionPerformed

    private void input_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_eActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(id_r.getText());
        String non=nom_r.getText();
        
        role del=new role(id,non);
        
        if(non.isEmpty()){
            JOptionPane.showMessageDialog(prenom, "the inputs are requide");
          }else{
            if(dbm.update_role(del)>0){
             JOptionPane.showMessageDialog(prenom, "You Modify a role in UW-Transport");   
             count_role();
             display_role();
             clearRole(del);
             add_r.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(prenom, "Your Modification get wrong try again ");
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(id_r.getText());
        String non=nom_r.getText();
        
        role del=new role(id);
        
            int confirm = JOptionPane.showConfirmDialog(
            rootPane,
            "Do you want this role "+non+" in UW-Transport ? ",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if(dbm.delete_role(del)>0){
                JOptionPane.showMessageDialog(prenom, "A role "+non+" is removed in UW-transport");
                count_role();
                display_role();
                clearRole(del);
                add_r.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(prenom, "A role "+non+"is not removed something went wrong try again");
            }
        }else{
            JOptionPane.showMessageDialog(prenom, "You cancel to remove this "+non+" Role in UW-Transport");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(id_r.getText());
        String non=nom.getText();
        
        role del=new role(id,non);
        clearRole(del);
        add_r.setVisible(true);
    }//GEN-LAST:event_clearActionPerformed

    private void date_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_eActionPerformed

    private void btn_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rActionPerformed

    private void input_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_rActionPerformed

    private void add_rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_rActionPerformed
        // TODO add your handling code here:
        String non=nom_r.getText();
        
        role del=new role(non);
        
        if(non.isEmpty()){
            JOptionPane.showMessageDialog(prenom, "the inputs are requide");
          }else{
            if(dbm.add_role(del)>0){
             JOptionPane.showMessageDialog(prenom, "You add a role or function");   
             count_role();
             display_role();
             clearRole(del);
            }else{
                JOptionPane.showMessageDialog(prenom, "You didn't add a role or function try again");
            }
        }
    }//GEN-LAST:event_add_rActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
        // TODO add your handling code here:
        String matricul=matricule.getText();
        String num1=nom.getText();
        String prenon=prenom.getText();
        String tel=telephone.getText();
        String email1=email.getText();
        String user=username.getText();
        String passwd=password.getText();

        utilisateur del=new utilisateur(matricul,num1,prenon,tel,email1,user,passwd);
        clearInput(del);
    }//GEN-LAST:event_clear1ActionPerformed

    private void clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear2ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(id_e.getText());
        String date=date_e.getText();
        int idd =Integer.parseInt(id_ro.getText());
        String matr=matricule_e.getText();
        
        exercer del=new exercer(id,date,idd,matr);
        clearExercer(del);
        add_e.setVisible(true);
    }//GEN-LAST:event_clear2ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void table_uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_uMouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) table_u.getModel();
        int selected = table_u.getSelectedRow();
        matricule.setText(df.getValueAt(selected, 0).toString());
        nom.setText(df.getValueAt(selected, 1).toString());
        prenom.setText(df.getValueAt(selected, 2).toString());
        telephone.setText(df.getValueAt(selected, 3).toString());
        email.setText(df.getValueAt(selected, 4).toString());
        username.setText(df.getValueAt(selected, 5).toString());
        password.setText(df.getValueAt(selected, 6).toString());
         
        add.setVisible(false);
        count_user();
        count_role();
        count_exercer();
        
        display_users();
        display_role();
        display_exercer();
    }//GEN-LAST:event_table_uMouseClicked

    private void table_rMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rMouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) table_r.getModel();
        int selected = table_r.getSelectedRow();
        id_r.setText(df.getValueAt(selected, 0).toString());
        nom_r.setText(df.getValueAt(selected, 1).toString());
         
        add_r.setVisible(false);
        count_user();
        count_role();
        count_exercer();
        
        display_users();
        display_role();
        display_exercer();
    }//GEN-LAST:event_table_rMouseClicked

    private void table_eMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_eMouseClicked
        // TODO add your handling code here:
        DefaultTableModel df = (DefaultTableModel) table_e.getModel();
        int selected = table_e.getSelectedRow();
        id_e.setText(df.getValueAt(selected, 0).toString());
        date_e.setText(df.getValueAt(selected, 1).toString());
        id_ro.setText(df.getValueAt(selected, 2).toString());
        matricule_e.setText(df.getValueAt(selected, 3).toString());
         
        add_e.setVisible(false);
        count_user();
        count_role();
        count_exercer();
        
        display_users();
        display_role();
        display_exercer();
    }//GEN-LAST:event_table_eMouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
        String matricul=matricule.getText();
        String num1=nom.getText();
        String prenon=prenom.getText();
        String tel=telephone.getText();
        String email1=email.getText();
        String user=username.getText();
        String passwd=password.getText();

        utilisateur del=new utilisateur(matricul,num1,prenon,tel,email1,user,passwd);
        if(matricul.isEmpty()&&num1.isEmpty()&&prenon.isEmpty()&&tel.isEmpty()&&email1.isEmpty()&&user.isEmpty()&&passwd.isEmpty()){
           JOptionPane.showMessageDialog(prenom, "the inputs are requide");
         }else{
            if(dbm.update_utilisateur(del)>0){
                JOptionPane.showMessageDialog(prenom, "User of "+matricul+" is updated very well");
                        add_e.setVisible(true);
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
                        clearInput(del);
            }else{
                JOptionPane.showMessageDialog(prenom, "User of "+matricul+" isn't updated try again");
            }
        }      
    }//GEN-LAST:event_jButton12MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        String matricul=matricule.getText();
        String num1=nom.getText();
        String prenon=prenom.getText();
        String tel=telephone.getText();
        String email1=email.getText();
        String user=username.getText();
        String passwd=password.getText();

        utilisateur del=new utilisateur(matricul,num1,prenon,tel,email1,user,passwd);
        if(matricul.isEmpty()&&num1.isEmpty()&&prenon.isEmpty()&&tel.isEmpty()&&email1.isEmpty()&&user.isEmpty()&&passwd.isEmpty()){
           JOptionPane.showMessageDialog(prenom, "the inputs are requide");
         }else{
            if(dbm.add_utilisateur(del)>0){
                JOptionPane.showMessageDialog(prenom, "User of "+ matricul+" is added very well");
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
            }else{
                JOptionPane.showMessageDialog(prenom, "User of "+matricul+" isn't added try again");
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void add_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_eActionPerformed
        // TODO add your handling code here:
        String date=date_e.getText();
        int idd =Integer.parseInt(id_ro.getText());
        String matr=matricule_e.getText();
        
        exercer del=new exercer(date,idd,matr);
        if(date.isEmpty()){
           JOptionPane.showMessageDialog(prenom, "the inputs are requide");
         }else{
            if(dbm.addexercer(del)>0){
                JOptionPane.showMessageDialog(prenom, "A user of "+matr+" get a function");
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
                        clearExercer(del);
            }else{
                JOptionPane.showMessageDialog(prenom, "A user of "+matr+" doesn't get a function try again");
            }
        }

    }//GEN-LAST:event_add_eActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(id_e.getText());
        String date=date_e.getText();
        int idd =Integer.parseInt(id_ro.getText());
        String matr=matricule_e.getText();
        
        exercer del=new exercer(id,date,idd,matr);
        if(date.isEmpty()){
           JOptionPane.showMessageDialog(prenom, "the inputs are requide");
         }else{
            if(dbm.updateexercer(del)>0){
                JOptionPane.showMessageDialog(prenom, "A user of "+matr+" change his fonction ");
                        add.setVisible(true);
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
                        clearExercer(del);
            }else{
                JOptionPane.showMessageDialog(prenom, "A user of "+matr+" doesn't change his fonction  try again");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int idd =Integer.parseInt(id_e.getText());
        String matr=matricule_e.getText();
        
        exercer del=new exercer(idd);
        
        int confirm = JOptionPane.showConfirmDialog(
            rootPane,
            "Do you want to Remove a fonction this User "+matr+" ? ",
            "Confirmation",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {    

            if(dbm.deleteexercer(del)>0){
                JOptionPane.showMessageDialog(prenom, "A function is removed to user of "+matr);
                        add_e.setVisible(true);
                        count_user();
                        count_role();
                        count_exercer();

                        display_users();
                        display_role();
                        display_exercer();
                        clearExercer(del);
            }else{
                JOptionPane.showMessageDialog(prenom, "A function isn't removed to user of "+matr);
            }
        }else{
           JOptionPane.showMessageDialog(prenom, "you refused to Remove a fonction to User of "+matr);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void btn_uActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_uActionPerformed

    private void btn_uMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uMouseClicked
        // TODO add your handling code here:
        String txtt = input_u.getText();
        List<utilisateur> search =dbm.search_utilisateur(txtt);

        // Update table with the results
        DefaultTableModel df = (DefaultTableModel) table_u.getModel();
        df.setRowCount(0); 

        for (utilisateur p : search) {
            df.addRow(new Object[]{p.getMatricule(),p.getNom_user(),p.getPrenom_user(),p.getTelephone_user(),p.getEmail_user(),p.getUsername(),p.getMotdepasse()});
        }

        // Affiche le nombre de résultats trouvés
        found_u.setText("" + search.size()+"");
    }//GEN-LAST:event_btn_uMouseClicked

    private void btn_rMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_rMouseClicked
        // TODO add your handling code here:
        String txtt = input_r.getText();
        List<role> search =dbm.search_role(txtt);

        // Update table with the results
        DefaultTableModel df = (DefaultTableModel) table_u.getModel();
        df.setRowCount(0); 

        for (role p : search) {
            df.addRow(new Object[]{p.getId_role(),p.getNom_role()});
        }

        // Affiche le nombre de résultats trouvés
        found_r.setText("" + search.size()+"");
    }//GEN-LAST:event_btn_rMouseClicked

    private void btn_eMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eMouseClicked
        // TODO add your handling code here:
        String txtt = input_e.getText();
        List<exercer> search =dbm.searchexercer(txtt);

        // Update table with the results
        DefaultTableModel df = (DefaultTableModel) table_e.getModel();
        df.setRowCount(0); 

        for (exercer p : search) {
            df.addRow(new Object[]{p.getId_exercer(),p.getDate_debut(),p.getId_role(),p.getMatricule()});
        }

        // Affiche le nombre de résultats trouvés
        found_e.setText("" + search.size()+"");
    }//GEN-LAST:event_btn_eMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dashbord;
    private javax.swing.JButton Logout;
    private javax.swing.JButton add;
    private javax.swing.JButton add_e;
    private javax.swing.JButton add_r;
    private javax.swing.JButton btn_e;
    private javax.swing.JButton btn_r;
    private javax.swing.JButton btn_u;
    private javax.swing.JLabel c;
    private javax.swing.JButton clear;
    private javax.swing.JButton clear1;
    private javax.swing.JButton clear2;
    private javax.swing.JLabel count_e;
    private javax.swing.JLabel count_r;
    private javax.swing.JLabel count_u;
    private javax.swing.JTextField date_e;
    private javax.swing.JButton delete;
    private javax.swing.JTextField email;
    private javax.swing.JLabel found_e;
    private javax.swing.JLabel found_e1;
    private javax.swing.JLabel found_e2;
    private javax.swing.JLabel found_r;
    private javax.swing.JLabel found_u;
    private javax.swing.JTextField id_e;
    private javax.swing.JTextField id_r;
    private javax.swing.JTextField id_ro;
    private javax.swing.JTextField input_e;
    private javax.swing.JTextField input_r;
    private javax.swing.JTextField input_u;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField matricule;
    private javax.swing.JTextField matricule_e;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField nom_r;
    private javax.swing.JTextField password;
    private javax.swing.JTextField prenom;
    private javax.swing.JTable table_e;
    private javax.swing.JTable table_r;
    private javax.swing.JTable table_u;
    private javax.swing.JTextField telephone;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
