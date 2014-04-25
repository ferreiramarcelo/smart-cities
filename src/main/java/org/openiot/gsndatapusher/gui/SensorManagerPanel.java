/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openiot.gsndatapusher.gui;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingbinding.JTableBinding;
import org.openiot.gsndatapusher.core.SensorManager;
import org.openiot.gsndatapusher.core.SensorState;
import static org.openiot.gsndatapusher.core.SensorState.CREATING;
import static org.openiot.gsndatapusher.core.SensorState.DELETING;
import static org.openiot.gsndatapusher.core.SensorState.NOT_CREATED;
import static org.openiot.gsndatapusher.core.SensorState.RUNNING;
import static org.openiot.gsndatapusher.core.SensorState.STARTING;
import static org.openiot.gsndatapusher.core.SensorState.STOPPED;
import static org.openiot.gsndatapusher.core.SensorState.STOPPING;
import static org.openiot.gsndatapusher.core.SensorState.UNDEFINED;
import org.openiot.gsndatapusher.core.SensorStatusChangedEvent;
import org.openiot.gsndatapusher.core.SensorStatusChangedListener;

/**
 *
 * @author admin-jacoby
 */
public class SensorManagerPanel extends javax.swing.JPanel implements SensorStatusChangedListener {

    private final SensorManager sensorManager;
    private SensorRemoveListener removeListener;
    private ScheduledThreadPoolExecutor internalThreadPool;
    JTableBinding tb;

    /**
     * Creates new form SensorManagerPanel
     */
    public SensorManagerPanel(SensorManager sensorManager, SensorRemoveListener removeListener) {
        this.removeListener = removeListener;
        this.sensorManager = sensorManager;
        internalThreadPool = new ScheduledThreadPoolExecutor(1);
        initComponents();
        this.sensorManager.addListener(this);
        tblConfig.setModel(new ReflectionTableModel(sensorManager.getConfig()));
        setButtonStates(sensorManager.getStatus().getState());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlState = new javax.swing.JPanel();
        lblType = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblMultiplicity = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblGsnAddress = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConfig = new javax.swing.JTable();
        pnlControl = new javax.swing.JPanel();
        btnSendData = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRemoveFromList = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtStatus = new javax.swing.JTextArea();
        pnlRuntimeInfo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        edtThreadCount = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        lblAvgExecutionTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        edtConnectionCount = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        lblAvgSendDuration = new javax.swing.JLabel();
        pnlDetails = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        pnlDetailInfo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        setMaximumSize(new java.awt.Dimension(5000, 5000));
        setLayout(new java.awt.GridBagLayout());

        pnlState.setMaximumSize(new java.awt.Dimension(40, 40));
        pnlState.setMinimumSize(new java.awt.Dimension(40, 40));
        pnlState.setPreferredSize(new java.awt.Dimension(40, 40));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.status.state}"), pnlState, org.jdesktop.beansbinding.BeanProperty.create("background"));
        binding.setConverter(new org.openiot.gsndatapusher.gui.StateToColorConverter());
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlStateLayout = new javax.swing.GroupLayout(pnlState);
        pnlState.setLayout(pnlStateLayout);
        pnlStateLayout.setHorizontalGroup(
            pnlStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlStateLayout.setVerticalGroup(
            pnlStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        add(pnlState, gridBagConstraints);

        lblType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.displayName}"), lblType, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("SensorType");
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(lblType, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("x");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(jLabel1, gridBagConstraints);

        lblMultiplicity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.multiplicity}"), lblMultiplicity, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("0");
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(lblMultiplicity, gridBagConstraints);

        jLabel3.setText("GSN address");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(jLabel3, gridBagConstraints);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.gsnAddress}"), lblGsnAddress, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("gsn address");
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        add(lblGsnAddress, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.01;
        add(jSeparator1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(220, 150));

        tblConfig.setFocusable(false);
        tblConfig.setMinimumSize(new java.awt.Dimension(30, 30));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${sensorManager.myData}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, eLProperty, tblConfig);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblConfig);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        pnlControl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        java.awt.GridBagLayout pnlControlLayout = new java.awt.GridBagLayout();
        pnlControlLayout.columnWidths = new int[] {0, 5, 0};
        pnlControlLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        pnlControl.setLayout(pnlControlLayout);

        btnSendData.setText("send data");
        btnSendData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendDataActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnSendData, gridBagConstraints);

        btnStart.setText("start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnStart, gridBagConstraints);

        btnStop.setText("stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnStop, gridBagConstraints);

        btnCreate.setText("create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnCreate, gridBagConstraints);

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnDelete, gridBagConstraints);

        btnRemoveFromList.setText("remove from list");
        btnRemoveFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlControl.add(btnRemoveFromList, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel1.add(pnlControl, gridBagConstraints);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Status");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBar(null);

        txtStatus.setEditable(false);
        txtStatus.setBorder(null);
        txtStatus.setFocusable(false);
        txtStatus.setOpaque(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.status.message}"), txtStatus, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(txtStatus);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        pnlRuntimeInfo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        pnlRuntimeInfo.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("# Threads");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlRuntimeInfo.add(jLabel5, gridBagConstraints);

        edtThreadCount.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        edtThreadCount.setMaximumSize(new java.awt.Dimension(32767, 200));
        edtThreadCount.setMinimumSize(new java.awt.Dimension(50, 20));
        edtThreadCount.setPreferredSize(new java.awt.Dimension(50, 20));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.threadCount}"), edtThreadCount, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlRuntimeInfo.add(edtThreadCount, gridBagConstraints);

        jLabel6.setText("avg exec time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlRuntimeInfo.add(jLabel6, gridBagConstraints);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.averageExecutionTime}"), lblAvgExecutionTime, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("0");
        binding.setConverter(new DoubleToStringConverter(2));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        pnlRuntimeInfo.add(lblAvgExecutionTime, gridBagConstraints);

        jLabel8.setText("# connections");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        pnlRuntimeInfo.add(jLabel8, gridBagConstraints);

        edtConnectionCount.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.connectionCount}"), edtConnectionCount, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlRuntimeInfo.add(edtConnectionCount, gridBagConstraints);

        jLabel9.setText("avg send duration");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        pnlRuntimeInfo.add(jLabel9, gridBagConstraints);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, this, org.jdesktop.beansbinding.ELProperty.create("${sensorManager.averageDuration}"), lblAvgSendDuration, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("0");
        binding.setConverter(new DoubleToStringConverter(2));
        bindingGroup.addBinding(binding);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        pnlRuntimeInfo.add(lblAvgSendDuration, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel1.add(pnlRuntimeInfo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(jPanel1, gridBagConstraints);

        pnlDetails.setLayout(new java.awt.BorderLayout());

        jToggleButton1.setText("...");
        jToggleButton1.setMinimumSize(new java.awt.Dimension(300, 23));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        pnlDetails.add(jToggleButton1, java.awt.BorderLayout.PAGE_START);

        pnlDetailInfo.setPreferredSize(new java.awt.Dimension(350, 227));
        pnlDetailInfo.setLayout(new java.awt.BorderLayout());

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${sensorManager.sensors}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("status");
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${averageDuration}"));
        columnBinding.setColumnName("avg duration");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${averageExecutionTime}"));
        columnBinding.setColumnName("avg exec");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lastData}"));
        columnBinding.setColumnName("last data");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setCellRenderer(new StateCellRenderer());
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);

        pnlDetailInfo.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        pnlDetails.add(pnlDetailInfo, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        add(pnlDetails, gridBagConstraints);

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            internalThreadPool.submit(sensorManager.start());
        } catch (Exception ex) {
            Logger.getLogger(SensorManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            internalThreadPool.submit(sensorManager.create());
        } catch (Exception ex) {
            Logger.getLogger(SensorManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        try {
            internalThreadPool.submit(sensorManager.stop());
        } catch (Exception ex) {
            Logger.getLogger(SensorManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            internalThreadPool.submit(sensorManager.delete());
        } catch (Exception ex) {
            Logger.getLogger(SensorManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSendDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendDataActionPerformed
        try {
            sensorManager.sendDataOnce().call();
        } catch (Exception ex) {
            Logger.getLogger(SensorManagerPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendDataActionPerformed

    private void btnRemoveFromListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromListActionPerformed
        removeListener.onSensorRemove(sensorManager, this);
    }//GEN-LAST:event_btnRemoveFromListActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        pnlDetailInfo.setVisible(!pnlDetailInfo.isVisible());
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRemoveFromList;
    private javax.swing.JButton btnSendData;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JSpinner edtConnectionCount;
    private javax.swing.JSpinner edtThreadCount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblAvgExecutionTime;
    private javax.swing.JLabel lblAvgSendDuration;
    private javax.swing.JLabel lblGsnAddress;
    private javax.swing.JLabel lblMultiplicity;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlDetailInfo;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlRuntimeInfo;
    private javax.swing.JPanel pnlState;
    private javax.swing.JTable tblConfig;
    private javax.swing.JTextArea txtStatus;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the sensorManager
     */
    public SensorManager getSensorManager() {
        return sensorManager;
    }

    @Override
    public void onSensorStateChangedListener(SensorStatusChangedEvent e) {
        // toggle buttons enabled
        setButtonStates(e.getNewStatus().getState());
    }

    private void setButtonStates(SensorState state) {
        switch (state) {
            case CREATING:
            case DELETING:
            case STARTING:
            case STOPPING:
                btnCreate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnSendData.setEnabled(false);
                btnStart.setEnabled(false);
                btnStop.setEnabled(false);
                edtThreadCount.setEnabled(false);
                edtConnectionCount.setEnabled(false);
                break;
            case NOT_CREATED:
                btnCreate.setEnabled(true);
                btnDelete.setEnabled(false);
                btnSendData.setEnabled(false);
                btnStart.setEnabled(false);
                btnStop.setEnabled(false);
                edtThreadCount.setEnabled(true);
                edtConnectionCount.setEnabled(true);
                break;
            case RUNNING:
                btnCreate.setEnabled(false);
                btnDelete.setEnabled(false);
                btnSendData.setEnabled(false);
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                edtThreadCount.setEnabled(false);
                edtConnectionCount.setEnabled(false);
                break;
            case STOPPED:
                btnCreate.setEnabled(false);
                btnDelete.setEnabled(true);
                btnSendData.setEnabled(true);
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
                edtThreadCount.setEnabled(true);
                edtConnectionCount.setEnabled(true);
                break;
            case UNDEFINED:
                btnCreate.setEnabled(true);
                btnDelete.setEnabled(true);
                btnSendData.setEnabled(true);
                btnStart.setEnabled(true);
                btnStop.setEnabled(true);
                edtThreadCount.setEnabled(true);
                edtConnectionCount.setEnabled(true);
                break;
        }

    }
}
