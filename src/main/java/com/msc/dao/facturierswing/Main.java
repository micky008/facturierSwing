/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msc.dao.facturierswing;

import com.google.gson.reflect.TypeToken;
import com.msc.dao.facturierswing.webservice.Request;
import com.msc.dao.facturierswing.webservice.Response;
import com.msc.dao.facturierswing.webservice.WebService;
import static com.msc.dao.facturierswing.webservice.WebService.METHOD.GET;
import com.msc.facturierws.entity.Client;
import com.msc.facturierws.entity.Facture;
import com.msc.facturierws.entity.LigneFacture;
import com.msc.facturierws.entity.MoyenDePaiement;
import com.msc.rest.tokenrestjersey.helper.Helper;
import com.msc.rest.tokenrestjersey.helper.ListHelper;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author micky
 */
public class Main extends javax.swing.JFrame {

    /**
     * Detect si c'est MonEntreprise est crée. Si non on force l'affichage de la
     * fenetre MonEntreprise.
     */
    static boolean firstTime;

    public final List<Client> clients;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        if (firstTime) {
            EditMoi.doClick();
        }
        clients = getAllClient();
        addMoyenDePaiement();
        jPanelReglement.setVisible(false);
        jLabelNoFacture.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        DateDuJour = new javax.swing.JMenuItem();
        jComboBoxClient = new javax.swing.JComboBox<>();
        idClient = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldDateFacture = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelNoFacture = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAddLine = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotaux = new javax.swing.JLabel();
        jCheckBoxRegler = new javax.swing.JCheckBox();
        jButtonSave = new javax.swing.JButton();
        jButtonCalculeTotaux = new javax.swing.JButton();
        jPanelReglement = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JTextFieldDateReglement = new javax.swing.JFormattedTextField();
        jTextFieldMoyenPaiementAutre = new javax.swing.JTextField();
        jComboBoxMoyenPaiement = new javax.swing.JComboBox<>();
        jButtonClore = new javax.swing.JButton();
        jButtonRemoveLine = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFichier = new javax.swing.JMenu();
        FileSave = new javax.swing.JMenuItem();
        FilePrint = new javax.swing.JMenuItem();
        FileQuitter = new javax.swing.JMenuItem();
        jMenuFacture = new javax.swing.JMenu();
        NewFacture = new javax.swing.JMenuItem();
        SearchFacture = new javax.swing.JMenuItem();
        jMenuEdition = new javax.swing.JMenu();
        EditMoi = new javax.swing.JMenuItem();
        EditClient = new javax.swing.JMenuItem();
        jMenuAjout = new javax.swing.JMenu();
        AddClient = new javax.swing.JMenuItem();

        DateDuJour.setText("jMenuItem1");
        jPopupMenu1.add(DateDuJour);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturier");

        jComboBoxClient.setEditable(true);

        idClient.setText("Client");

        jLabel1.setText("Date de la facture");

        jTextFieldDateFacture.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jTextFieldDateFacture.setToolTipText("");

        jLabel2.setText("No de la Facture");

        jLabelNoFacture.setText(" ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Type de Formation", "Nombre d'heure", "Prix Unitaire", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonAddLine.setText("Add Line");
        jButtonAddLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLineActionPerformed(evt);
            }
        });

        jLabel3.setText("TOTAL");

        jLabelTotaux.setText("0");

        jCheckBoxRegler.setText("Réglé ?");
        jCheckBoxRegler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxReglerActionPerformed(evt);
            }
        });

        jButtonSave.setText("Sauvegarder");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCalculeTotaux.setText("Calcule");
        jButtonCalculeTotaux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculeTotauxActionPerformed(evt);
            }
        });

        jLabel4.setText("Réglé quand ?");

        JTextFieldDateReglement.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jTextFieldMoyenPaiementAutre.setEditable(false);
        jTextFieldMoyenPaiementAutre.setText("Autre moyen de paiment");

        jButtonClore.setText("Clore");
        jButtonClore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelReglementLayout = new javax.swing.GroupLayout(jPanelReglement);
        jPanelReglement.setLayout(jPanelReglementLayout);
        jPanelReglementLayout.setHorizontalGroup(
            jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelReglementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReglementLayout.createSequentialGroup()
                        .addComponent(jComboBoxMoyenPaiement, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldMoyenPaiementAutre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelReglementLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(JTextFieldDateReglement, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClore)
                        .addGap(45, 45, 45))))
        );
        jPanelReglementLayout.setVerticalGroup(
            jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelReglementLayout.createSequentialGroup()
                .addGroup(jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelReglementLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(JTextFieldDateReglement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelReglementLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButtonClore)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelReglementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMoyenPaiement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMoyenPaiementAutre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRemoveLine.setText("Remove Line");
        jButtonRemoveLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveLineActionPerformed(evt);
            }
        });

        jMenuFichier.setText("Fichier");

        FileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        FileSave.setText("Sauvegarder");
        FileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileSaveActionPerformed(evt);
            }
        });
        jMenuFichier.add(FileSave);

        FilePrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        FilePrint.setText("Imprimer");
        FilePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilePrintActionPerformed(evt);
            }
        });
        jMenuFichier.add(FilePrint);

        FileQuitter.setText("Quitter");
        FileQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileQuitterActionPerformed(evt);
            }
        });
        jMenuFichier.add(FileQuitter);

        jMenuBar1.add(jMenuFichier);

        jMenuFacture.setText("Facture");

        NewFacture.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewFacture.setText("Nouvelle");
        NewFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFactureActionPerformed(evt);
            }
        });
        jMenuFacture.add(NewFacture);

        SearchFacture.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        SearchFacture.setText("Rechercher");
        SearchFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFactureActionPerformed(evt);
            }
        });
        jMenuFacture.add(SearchFacture);

        jMenuBar1.add(jMenuFacture);

        jMenuEdition.setText("Edition");
        jMenuEdition.setActionCommand("");

        EditMoi.setText("Mon Entreprise");
        EditMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMoiActionPerformed(evt);
            }
        });
        jMenuEdition.add(EditMoi);

        EditClient.setText("Client");
        EditClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditClientActionPerformed(evt);
            }
        });
        jMenuEdition.add(EditClient);

        jMenuBar1.add(jMenuEdition);

        jMenuAjout.setText("Ajout");

        AddClient.setText("Client");
        AddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientActionPerformed(evt);
            }
        });
        jMenuAjout.add(AddClient);

        jMenuBar1.add(jMenuAjout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(idClient, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelNoFacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDateFacture, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveLine)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddLine))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelReglement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jCheckBoxRegler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTotaux, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCalculeTotaux, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonSave, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(idClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDateFacture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelNoFacture, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddLine)
                    .addComponent(jButtonRemoveLine))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotaux)
                    .addComponent(jLabel3)
                    .addComponent(jCheckBoxRegler))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelReglement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCalculeTotaux)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMoiActionPerformed
        MonEntrepriseFrame mef = new MonEntrepriseFrame(this, true, firstTime);
        mef.setVisible(true);
    }//GEN-LAST:event_EditMoiActionPerformed

    private void AddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientActionPerformed
        ClientFrame mef = new ClientFrame(this, true);
        mef.setVisible(true);
    }//GEN-LAST:event_AddClientActionPerformed

    private void EditClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditClientActionPerformed
        try {
            RechercheClient rc = new RechercheClient(this, true);
            rc.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EditClientActionPerformed

    private void SearchFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFactureActionPerformed
        try {
            RechercheFacture rf = new RechercheFacture(this, true);
            rf.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SearchFactureActionPerformed

    private void jButtonAddLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLineActionPerformed
        ((DefaultTableModel) (jTable1.getModel())).addRow(new Object[4]);
    }//GEN-LAST:event_jButtonAddLineActionPerformed

    private Client getClientById(int idClient) {
        for (Client c : clients) {
            if (c.getId() == idClient) {
                return c;
            }
        }
        return null;
    }


    private void NewFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFactureActionPerformed
        if (jComboBoxClient.getModel().getSize() == 0) {
            for (Client c : clients) {
                jComboBoxClient.addItem(c);
            }
        }

        jTextFieldDateFacture.setText("");
        jLabelNoFacture.setText("");

        for (int i = jTable1.getModel().getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) (jTable1.getModel())).removeRow(i);
        }

        jCheckBoxRegler.setSelected(false);

        jTextFieldMoyenPaiementAutre.setText("");

        addMoyenDePaiement();

        JTextFieldDateReglement.setText("");
        cloreFactureOrNot(false);
    }//GEN-LAST:event_NewFactureActionPerformed

    private void FileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileSaveActionPerformed
        jButtonSave.doClick();
    }//GEN-LAST:event_FileSaveActionPerformed

    private void FilePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilePrintActionPerformed
        try {
            Facture f = createFacture(jLabelNoFacture.getText().isEmpty());
            f.setClient(getClientById(f.getIdClient()));
            Request r = new Request("facture", "print");
            Response res = r.sendRequest(f, WebService.METHOD.POST);
            java.lang.reflect.Type fooType = new TypeToken<Helper<String>>() {
            }.getType();
            Helper<String> h = (Helper<String>) res.getObject(null, fooType);
            res.setToken(h.getToken());
            byte[] pdf = Base64.decodeBase64(h.getMyObject());
            File file = new File(".", f.getClient().toString() + "-" + f.getNoFacture() + ".pdf");
            FileOutputStream fos = new FileOutputStream(file);
            IOUtils.write(pdf, fos);
            IOUtils.closeQuietly(fos);
            Desktop.getDesktop().open(file.getAbsoluteFile());

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_FilePrintActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        try {
            boolean creaton = jLabelNoFacture.getText().isEmpty();
            Facture f = createFacture(creaton);
            jLabelNoFacture.setText(f.getNoFacture());
            Request r = new Request("facture", creaton ? "insert" : "update");
            Response res = r.sendRequest(f, WebService.METHOD.POST);
            res.consumeToken();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void FileQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileQuitterActionPerformed
        dispose();
    }//GEN-LAST:event_FileQuitterActionPerformed

    private void jCheckBoxReglerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxReglerActionPerformed
        if (jCheckBoxRegler.isSelected()) {
            jPanelReglement.setVisible(true);
        } else {
            jPanelReglement.setVisible(false);
        }

    }//GEN-LAST:event_jCheckBoxReglerActionPerformed

    public void simuleCalculeClick() {
        jButtonCalculeTotaux.doClick();
    }

    private void jButtonCalculeTotauxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculeTotauxActionPerformed
        Double total = 0d;
        DecimalFormat df = new DecimalFormat("#####.##");
        
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Double qte = (Double) jTable1.getValueAt(i, 1);
            Double pu = (Double) jTable1.getValueAt(i, 2);
            if (qte == null || pu == null) {
                return;
            }
            jTable1.getModel().setValueAt(new Double(df.format(qte * pu).replace(",", ".")), i, 3);
            total += qte * pu;
        }
        
        jLabelTotaux.setText(df.format(total));
    }//GEN-LAST:event_jButtonCalculeTotauxActionPerformed

    private void jButtonRemoveLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveLineActionPerformed
        ((DefaultTableModel) (jTable1.getModel())).removeRow(jTable1.getRowCount() - 1);
    }//GEN-LAST:event_jButtonRemoveLineActionPerformed

    private void jButtonCloreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloreActionPerformed
        String resI = JOptionPane.showInputDialog(this, "Clore la facture (n'est plus editable) tappez OUI", "ATTENTION", JOptionPane.INFORMATION_MESSAGE);
        if (resI.equals("OUI")) {
            try {
                Request r = new Request("facture", "ferme/" + jLabelNoFacture.getText());
                Response res = r.sendRequest(null, GET);
                res.consumeToken();
                cloreFactureOrNot(true);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonCloreActionPerformed

    private void cloreFactureOrNot(boolean cloreFacture) {
        jButtonClore.setEnabled(!cloreFacture);
        jButtonSave.setEnabled(!cloreFacture);
        jButtonAddLine.setEnabled(!cloreFacture);
        jButtonRemoveLine.setEnabled(!cloreFacture);
        jTable1.setEnabled(!cloreFacture);
        jTextFieldDateFacture.setEnabled(!cloreFacture);
        JTextFieldDateReglement.setEnabled(!cloreFacture);
        jTextFieldMoyenPaiementAutre.setEnabled(!cloreFacture);
    }

    private Facture createFacture(boolean isCreate) {

        try {
            Facture facture = new Facture();
            Client c = (Client) jComboBoxClient.getSelectedItem();
            facture.setIdClient(c.getId());
            facture.setIdModele(1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            facture.setDateDuJour(sdf.parse(jTextFieldDateFacture.getText()));
            facture.setIsRegle(jCheckBoxRegler.isSelected());
            if (jCheckBoxRegler.isSelected()) {
                facture.setAutreMoyenDePaiment(jTextFieldMoyenPaiementAutre.getText());
                facture.setCommentRegle(MoyenDePaiement.valueOf(jComboBoxMoyenPaiement.getSelectedItem().toString()));
                facture.setDateRegle(sdf.parse(JTextFieldDateReglement.getText()));
            }
            if (isCreate) {
                Request r = new Request("facture", "number/" + Request.formatDate(jTextFieldDateFacture.getText(), "dd/MM/yyyy"));
                Response res = r.sendRequest();
                java.lang.reflect.Type fooType = new TypeToken<Helper<Integer>>() {
                }.getType();
                Helper<Integer> hi = (Helper<Integer>) res.getObject(null, fooType);
                facture.setNumber(hi.getMyObject());
                facture.genereNoFacture();
                jLabelNoFacture.setText(facture.getNoFacture());
            } else {
                String tst = jLabelNoFacture.getText();
                facture.setNoFacture(tst);
            }
            LigneFacture lf;
            List<LigneFacture> lfs = new ArrayList<>(jTable1.getModel().getRowCount());
            for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
                lf = new LigneFacture();
                lf.setNoFacture(facture.getNoFacture());
                lf.setDesignation(jTable1.getValueAt(i, 0).toString());
                lf.setQuantite(Double.parseDouble(jTable1.getValueAt(i, 1).toString()));
                lf.setPuHt(Double.parseDouble(jTable1.getValueAt(i, 2).toString()));
                lfs.add(lf);
            }
            facture.setLignes(lfs);
            facture.generateLinesStr();
            return facture;
        } catch (ParseException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        Reader r = new FileReader("./config.properties");
        prop.load(r);
        r.close();
        WebService.prop = prop;
        WebService.setDebugMode(Boolean.parseBoolean(prop.getProperty("debugMode")));
        Request request = new Request("login", "login");
        try {
            Response s = request.sendRequest();
            s.consumeToken();
            request.setEndpoint("moi");
            request.setUrlSuite("existe");
            s = request.sendRequest();
            java.lang.reflect.Type fooType = new TypeToken<Helper<Boolean>>() {
            }.getType();
            Helper<Boolean> b = (Helper<Boolean>) s.getObject(null, fooType);
            firstTime = !b.getMyObject();
        } catch (MalformedURLException | IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddClient;
    private javax.swing.JMenuItem DateDuJour;
    private javax.swing.JMenuItem EditClient;
    private javax.swing.JMenuItem EditMoi;
    private javax.swing.JMenuItem FilePrint;
    private javax.swing.JMenuItem FileQuitter;
    private javax.swing.JMenuItem FileSave;
    private javax.swing.JFormattedTextField JTextFieldDateReglement;
    private javax.swing.JMenuItem NewFacture;
    private javax.swing.JMenuItem SearchFacture;
    private javax.swing.JLabel idClient;
    private javax.swing.JButton jButtonAddLine;
    private javax.swing.JButton jButtonCalculeTotaux;
    private javax.swing.JButton jButtonClore;
    private javax.swing.JButton jButtonRemoveLine;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxRegler;
    private javax.swing.JComboBox<Client> jComboBoxClient;
    private javax.swing.JComboBox<String> jComboBoxMoyenPaiement;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNoFacture;
    private javax.swing.JLabel jLabelTotaux;
    private javax.swing.JMenu jMenuAjout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdition;
    private javax.swing.JMenu jMenuFacture;
    private javax.swing.JMenu jMenuFichier;
    private javax.swing.JPanel jPanelReglement;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField jTextFieldDateFacture;
    private javax.swing.JTextField jTextFieldMoyenPaiementAutre;
    // End of variables declaration//GEN-END:variables

    private List<Client> getAllClient() {
        try {
            Request req = new Request("client", "all");
            Response res = req.sendRequest();
            java.lang.reflect.Type fooType = new TypeToken<ListHelper<Client>>() {
            }.getType();
            ListHelper<Client> lc = (ListHelper<Client>) res.getObject(null, fooType);
            res.setToken(lc.getToken());
            return lc.getList();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void addMoyenDePaiement() {
        if (jComboBoxMoyenPaiement.getItemCount() > 0) {
            return;
        }
        MoyenDePaiement mps[] = MoyenDePaiement.values();
        for (MoyenDePaiement mdp : mps) {
            jComboBoxMoyenPaiement.addItem(mdp.toString());
        }

    }

    void setFacture(Facture facture) {
        for (Client c : clients) {
            jComboBoxClient.addItem(c);
            if (c.getId().intValue() == facture.getIdClient().intValue()) {
                jComboBoxClient.setSelectedItem(c);
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jTextFieldDateFacture.setText(sdf.format(facture.getDateDuJour()));
        jLabelNoFacture.setText(facture.getNoFacture());

        Object obj[] = null;
        for (int i = jTable1.getModel().getRowCount() - 1; i >= 0; i--) {
            ((DefaultTableModel) (jTable1.getModel())).removeRow(i);
        }
        for (LigneFacture line : facture.getLignes()) {
            obj = new Object[4];

            obj[0] = line.getDesignation();
            obj[1] = line.getQuantite();
            obj[2] = line.getPuHt();
            obj[3] = line.getQuantite() * line.getPuHt();

            ((DefaultTableModel) (jTable1.getModel())).addRow(obj);
        }
        jCheckBoxRegler.setSelected(facture.getIsRegle());

        jTextFieldMoyenPaiementAutre.setText(facture.getAutreMoyenDePaiment());

        MoyenDePaiement mps[] = MoyenDePaiement.values();
        int pos = 0;
        int tmp = 0;
        for (MoyenDePaiement mdp : mps) {
            if (mdp == facture.getCommentRegle()) {
                tmp = pos;
                break;
            }
            pos++;
        }

        jComboBoxMoyenPaiement.setSelectedIndex(tmp);
        if (facture.getDateRegle() != null) {
            JTextFieldDateReglement.setText(sdf.format(facture.getDateRegle()));
        }
        if (facture.getIsFinish()) {
            cloreFactureOrNot(true);
        } else {
            cloreFactureOrNot(false);
        }
    }

}
