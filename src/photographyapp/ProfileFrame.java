package photographyapp;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ethan
 */

public class ProfileFrame extends javax.swing.JFrame {

    /**
     * Creates new form JTableWithImage
     */
    
    public static int MemberID;
    
    public ProfileFrame(int id) throws ClassNotFoundException {
        MemberID = id;
        initComponents();
        populateJTable();
    }
    
    private Map<ImageIcon, ImageIcon> imageMap = new HashMap<>();  // Mapping from resized images to original images

    public void populateJTable() throws ClassNotFoundException{
        MyQuery mq = new MyQuery();
         ArrayList<Photos> photoList = mq.BindProfilePhotos(MemberID);  // Needs to be mapped to the current logged in user
        ArrayList<Members> memberList = mq.BindMembers();
        ArrayList<Albums> albumList = mq.BindAlbums();
        ArrayList<Locations> locationList = mq.BindLocations();
        String[] columnName = {"Album","Location","Member","Title","Description","Uploaded","Image"};
        Object[][] rows = new Object[photoList.size()][7];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        for(int i = 0; i < photoList.size(); i++){
            rows[i][0] = albumList.get(photoList.get(i).getAlbum()-1).getTitle();
            rows[i][1] = locationList.get(photoList.get(i).getLocation()-1).getName();
            rows[i][2] = memberList.get(photoList.get(i).getMember()-1).getName();
            rows[i][3] = photoList.get(i).getTitle();
            rows[i][4] = photoList.get(i).getDescription();
            rows[i][5] = photoList.get(i).getUploadDate().format(formatter);
            
            if (photoList.get(i).getImagePath() != null) {
                ImageIcon image = new ImageIcon(photoList.get(i).getImagePath());
                ImageIcon resizedImage = new ImageIcon(image.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                rows[i][6] = resizedImage;
                imageMap.put(resizedImage, image);  // Add to the mapping
            } else {
                rows[i][6] = null;
            }
        }
        
        TheModel model = new TheModel(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = jTable1.columnAtPoint(e.getPoint()); // get the column number where mouse clicked
                int row = jTable1.rowAtPoint(e.getPoint()); // get the row number where mouse clicked

                if (column == 6) {
                    ImageIcon resizedImage = (ImageIcon) jTable1.getValueAt(row, column);  // Get the resized image
                    ImageIcon originalImage = imageMap.get(resizedImage);  // Look up the original image
                    if (originalImage != null) {
                        JFrame imageFrame = new JFrame();
                        JLabel imageLabel = new JLabel(originalImage);
                        imageFrame.setLayout(new GridLayout());
                        imageFrame.add(imageLabel);
                        imageFrame.pack();
                        imageFrame.setLocationRelativeTo(null);
                        imageFrame.setVisible(true);
                    }
                }
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profile Page");

        uploadButton.setText("Upload");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton)
                    .addComponent(uploadButton)
                    .addComponent(editButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // Create an instance of your JFrame class
        JTableWithImage home = null;
        try {
            home = new JTableWithImage(MemberID);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JTableWithImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        home.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        home.setVisible(true);
        
        // Dispose the current JFrame
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        // Create an instance of your JFrame class
        Upload upload = new Upload(MemberID);
        upload.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        upload.setVisible(true);
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // Create an instance of your JFrame class
        Edit edit = null;
        try {
            edit = new Edit(MemberID);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfileFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        edit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        edit.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ProfileFrame(MemberID).setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProfileFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
