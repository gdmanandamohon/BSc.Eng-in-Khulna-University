/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulation;

import java.util.Random;

/**
 *
 * @author Ananda Mohon Ghosh
 */
public class CrRepair_Form extends javax.swing.JFrame {

   
    public CrRepair_Form() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cr_Mean_Interrival = new javax.swing.JTextField();
        cr_MeanService_inspectation_UP = new javax.swing.JTextField();
        cr_meanServicetime_repair_up = new javax.swing.JTextField();
        cr_MeanService_Inspectation_down = new javax.swing.JTextField();
        cr_MeanService_repair_down = new javax.swing.JTextField();
        StartSimulation_CarRepair_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fild_chart = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        cr_TotalSimulationTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Multi Server Car Repair");

        jLabel2.setText("Mean Interrival Of First Server");

        jLabel3.setText("Uniform Service Time Inspectation");

        jLabel4.setText("Uniform Service Time For Repair");

        StartSimulation_CarRepair_btn.setText("Simulate");
        StartSimulation_CarRepair_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartSimulation_CarRepair_btnActionPerformed(evt);
            }
        });

        jLabel5.setText("Simulation Result");

        fild_chart.setColumns(20);
        fild_chart.setRows(5);
        jScrollPane2.setViewportView(fild_chart);

        jLabel6.setText("Total Simulation Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(StartSimulation_CarRepair_btn)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(cr_Mean_Interrival, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                .addComponent(cr_MeanService_inspectation_UP))
                                            .addComponent(cr_meanServicetime_repair_up, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cr_MeanService_Inspectation_down, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                            .addComponent(cr_MeanService_repair_down)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(cr_TotalSimulationTime))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(203, 203, 203))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cr_Mean_Interrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cr_MeanService_inspectation_UP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cr_MeanService_Inspectation_down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cr_meanServicetime_repair_up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cr_MeanService_repair_down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cr_TotalSimulationTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StartSimulation_CarRepair_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartSimulation_CarRepair_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartSimulation_CarRepair_btnActionPerformed
        // TODO add your handling code here:
        //car repair codes goen here
        
        MultiServerCarREp server =new MultiServerCarREp();
	server.mean_interarrival=Double.parseDouble(cr_Mean_Interrival.getText());
	server.inspection_dis_down=Double.parseDouble(cr_MeanService_Inspectation_down.getText());
	server.inspection_dis_up=Double.parseDouble(cr_MeanService_inspectation_UP.getText());
	server.repair_dis_down = Double.parseDouble(cr_MeanService_repair_down.getText());
	server.repair_dis_up = Double.parseDouble(cr_meanServicetime_repair_up.getText());
	server.initialize();
	int totalTime =Integer.parseInt(cr_TotalSimulationTime.getText());
	while(server.sim_time<=totalTime)
	{
		double randomslect=random.nextFloat();
		server.timing();
		switch(server.next_event_type)
		{
                    case 1:server.update_time_avg_stats_inspection();
                            server.arrive_inspectation(server.sim_time+expon(server.mean_interarrival));
                            break;
                    case 2:server.depart_inspectation();
                            server.update_time_avg_stats_inspection();
                            if( randomslect<=.3)
                            {
				server.start_repair_station(server.sim_time);
                            }
                            break;
                    case 3:server.depart_repair();
                            server.update_time_avg_stats_repair();
                            break;
						
							
                }
        }
				
        server.time_next_event[1]=(float) Math.pow(10, +30);
        while(server.num_in_q_ins>0||server.num_in_q_rep>0)
        {
            server.timing();
            server.update_time_avg_stats_inspection();
            switch (server.next_event_type)
            {
                case 1: break;
                case 2: server.depart_inspectation();
                        server.update_time_avg_stats_inspection();
                        if( random.nextFloat()<=.3)
                            {
                                server.start_repair_station(server.sim_time);
									
                            }
                case 3: server.depart_repair();
                        server.update_time_avg_stats_repair();
            }
							
								
						
        }     
        String result =server.report_inspectation();
        fild_chart.append(result);
        result =server.report_repair();
        fild_chart.append(result);
    }//GEN-LAST:event_StartSimulation_CarRepair_btnActionPerformed

    
    static Random random=new Random();
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
            java.util.logging.Logger.getLogger(CrRepair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrRepair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrRepair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrRepair_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrRepair_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StartSimulation_CarRepair_btn;
    private javax.swing.JTextField cr_MeanService_Inspectation_down;
    private javax.swing.JTextField cr_MeanService_inspectation_UP;
    private javax.swing.JTextField cr_MeanService_repair_down;
    private javax.swing.JTextField cr_Mean_Interrival;
    private javax.swing.JTextField cr_TotalSimulationTime;
    private javax.swing.JTextField cr_meanServicetime_repair_up;
    private javax.swing.JTextArea fild_chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private double expon(double mean_interarrival) {
        return -mean_interarrival*Math.log(random.nextDouble());
    }
}
