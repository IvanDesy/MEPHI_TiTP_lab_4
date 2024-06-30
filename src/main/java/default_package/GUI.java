package default_package;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class GUI extends javax.swing.JFrame {
    private Manager manager;
    
    
    public GUI(Manager manager) {
        try {
            this.manager = manager;
            initComponents();
            treeConfiguration();
            
            File currentDirectory = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
            fileChooser.setCurrentDirectory(currentDirectory);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON, YAML, XML", "json", "yaml", "xml");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            
            
            radioButtonGroup.add(radioButtonCountry);
           radioButtonGroup.add(radioButtonRegion);
            radioButtonGroup.add(radioButtonCompany);
            radioButtonGroup.add(radioButtonReactor);
            try {
                manager.connectToDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        radioButtonGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        treeScrollPane = new javax.swing.JScrollPane();
        reactorsTree = new javax.swing.JTree();
        loadBtn = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        consumptionTable = new javax.swing.JTable();
        radioButtonReactor = new javax.swing.JRadioButton();
        radioButtonRegion = new javax.swing.JRadioButton();
        radioButtonCountry = new javax.swing.JRadioButton();
        radioButtonCompany = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        treeScrollPane.setViewportView(reactorsTree);

        loadBtn.setText("Загрузить файл");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        consumptionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane.setViewportView(consumptionTable);

        radioButtonReactor.setText("Реактор");
        radioButtonReactor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonReactorActionPerformed(evt);
            }
        });

        radioButtonRegion.setText("Регион");
        radioButtonRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonRegionActionPerformed(evt);
            }
        });

        radioButtonCountry.setText("Страна");
        radioButtonCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCountryActionPerformed(evt);
            }
        });

        radioButtonCompany.setText("Компания");
        radioButtonCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(treeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(radioButtonCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonCompany)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonRegion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonReactor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioButtonCountry)
                        .addComponent(radioButtonCompany)
                        .addComponent(radioButtonRegion)
                        .addComponent(radioButtonReactor)))
                .addGap(18, 33, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(treeScrollPane)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                manager.processingFile(file);
                treeConfiguration();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Ошибка чтения", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            
        }    
    }//GEN-LAST:event_loadBtnActionPerformed

    private void radioButtonCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCompanyActionPerformed
        try {
            drawTable();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioButtonCompanyActionPerformed

    private void radioButtonRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonRegionActionPerformed
        try {
            drawTable();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioButtonRegionActionPerformed

    
    private void radioButtonCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCountryActionPerformed

        try {
            drawTable();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_radioButtonCountryActionPerformed

    private void radioButtonReactorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonReactorActionPerformed
        try {
            drawTable();
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_radioButtonReactorActionPerformed
    private void treeConfiguration() {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Реакторы");
        
           List<Reactor> listReactors = manager.getStorage().getReactorStorage();
        for(Reactor reactor: listReactors) {
            DefaultMutableTreeNode reactorNode = new DefaultMutableTreeNode(
                    reactor.getName());
            reactorNode.add(new DefaultMutableTreeNode("Class: "+ reactor.getClasse()));
            reactorNode.add(new DefaultMutableTreeNode("Burnup: "+ reactor.getBurnup()));
            reactorNode.add(new DefaultMutableTreeNode("KPD: " + reactor.getKpd()));
            reactorNode.add(new DefaultMutableTreeNode("Enrichment: " +reactor.getEnrichment()));
            reactorNode.add(new DefaultMutableTreeNode("Termal Capacity: " + reactor.getTermalCapacity()));
            reactorNode.add(new DefaultMutableTreeNode("Electrical Capacity: " + reactor.getElectricalCapacity()));
            reactorNode.add(new DefaultMutableTreeNode("Life time: " + reactor.getLifeTime()));
            reactorNode.add(new DefaultMutableTreeNode("First load: " +reactor.getFirstLoad()));
            reactorNode.add(new DefaultMutableTreeNode("Source: " + reactor.getFileType()));
            
            rootNode.add(reactorNode);
        }
        
        reactorsTree.setModel(new javax.swing.tree.DefaultTreeModel(rootNode));
        
        

        
    }
    
    private void drawTable() throws SQLException, ClassNotFoundException {
        JRadioButton[] btns = {radioButtonCountry,
                                                radioButtonRegion,
                                                radioButtonCompany,
                                                radioButtonReactor};
        
        DefaultTableModel model = null;
        for(JRadioButton btn: btns) {
            if(btn.isSelected()){
               model = manager.getStatementManager().doStatement(btn.getText());
                
                
            }
        }
        consumptionTable.setModel(model);
        consumptionTable.setDefaultEditor(Object.class, null);
    }

      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable consumptionTable;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton loadBtn;
    private javax.swing.JPanel panel;
    private javax.swing.JRadioButton radioButtonCompany;
    private javax.swing.JRadioButton radioButtonCountry;
    private javax.swing.ButtonGroup radioButtonGroup;
    private javax.swing.JRadioButton radioButtonReactor;
    private javax.swing.JRadioButton radioButtonRegion;
    private javax.swing.JTree reactorsTree;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane treeScrollPane;
    // End of variables declaration//GEN-END:variables
}
