package simulation;
import java.util.Random;
public class MyOwnProject extends javax.swing.JFrame {
    public MyOwnProject() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        MeanInterrival_boyler = new javax.swing.JTextField();
        meanService_boyler = new javax.swing.JTextField();
        meanService_Puresteel = new javax.swing.JTextField();
        meanService_SteelRod = new javax.swing.JTextField();
        meanService_IronRod = new javax.swing.JTextField();
        meanService_CustIron = new javax.swing.JTextField();
        meanService_Sediment = new javax.swing.JTextField();
        meanService_Pitch = new javax.swing.JTextField();
        meanService_Wastage = new javax.swing.JTextField();
        MyownProject_Simulate_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fild_area = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        total_sim_time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Steel Factory Management System Simulation");

        jLabel2.setText("Mean Interraival of  Boyler");

        jLabel3.setText("Mean Service Time For Boyler");

        jLabel4.setText("Mean Service Time For PureSteel");

        jLabel5.setText("Mean Service Tme For Steel Rod");

        jLabel6.setText("Mean Service Tme For Iron Rod");

        jLabel7.setText("Mean Service Tme For Cust Iron");

        jLabel8.setText("Mean Service Tme For Sediment");

        jLabel9.setText("Mean Service Tme For Pitch");

        jLabel10.setText("Mean Service Tme For Wastage");

        MyownProject_Simulate_btn.setText("Simulate");
        MyownProject_Simulate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyownProject_Simulate_btnActionPerformed(evt);
            }
        });

        fild_area.setColumns(20);
        fild_area.setRows(5);
        jScrollPane1.setViewportView(fild_area);

        jLabel11.setText("Simulation Resutl");

        jLabel12.setText("Enter Total Simulation Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(MyownProject_Simulate_btn))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(MeanInterrival_boyler)
                                    .addComponent(meanService_boyler)
                                    .addComponent(meanService_Puresteel)
                                    .addComponent(meanService_SteelRod)
                                    .addComponent(meanService_IronRod)
                                    .addComponent(meanService_CustIron)
                                    .addComponent(meanService_Sediment)
                                    .addComponent(meanService_Pitch)
                                    .addComponent(meanService_Wastage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(total_sim_time, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(134, 134, 134))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MeanInterrival_boyler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meanService_boyler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(meanService_Puresteel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(meanService_SteelRod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(meanService_IronRod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(meanService_CustIron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(meanService_Sediment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(meanService_Pitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(meanService_Wastage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(total_sim_time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(MyownProject_Simulate_btn)
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void MyownProject_Simulate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyownProject_Simulate_btnActionPerformed
        // TODO add your handling code here:
        //project work
        MyProject server =new MyProject();

		server.mean_interarrival_1st_Server=Double.parseDouble(MeanInterrival_boyler.getText());
		server.mean_service[1]=Double.parseDouble(meanService_boyler.getText());
                server.mean_service[2]=Double.parseDouble(meanService_Puresteel.getText());
                server.mean_service[3]=Double.parseDouble(meanService_Puresteel.getText());
                server.mean_service[4]=Double.parseDouble(meanService_SteelRod.getText());
                server.mean_service[5]=Double.parseDouble(meanService_IronRod.getText());
                server.mean_service[6]=Double.parseDouble(meanService_CustIron.getText());
                server.mean_service[7]=Double.parseDouble(meanService_Pitch.getText());
                server.mean_service[8]=Double.parseDouble(meanService_Wastage.getText());
                
                
		double totlatime =Integer.valueOf(total_sim_time.getText());
		server.initialize();
		
		while(server.sim_time<totlatime)
		{
			server.timing();
			switch (server.next_event_type)
			{
				case 1: server.arrive(server.time_next_event[1],1);
						server.update_time_avg_stats(1);
						break;
				case 2: server.depart(1);
						server.update_time_avg_stats(1);
						break;
				case 3: server.depart(2);
						server.update_time_avg_stats(2);
						break;
				case 4: server.depart(3);
						server.update_time_avg_stats(3);
						break;
				case 5: server.depart(4);
						server.update_time_avg_stats(4);
						break;
				case 6: server.depart(5);
						server.update_time_avg_stats(5);
						break;
				case 7: server.depart(6);
						server.update_time_avg_stats(6);
						break;
				case 8: server.depart(7);
						server.update_time_avg_stats(7);
						break;
				case 9: server.depart(8);
						server.update_time_avg_stats(8);
							break;
			}
		}
	
		
		server.time_next_event[1] = Math.pow(10, +30);
		while(server.num_in_q[1]>0||server.num_in_q[2]>0||server.num_in_q[3]>0||server.num_in_q[4]>0||server.num_in_q[5]>0||server.num_in_q[6]>0||server.num_in_q[7]>0||server.num_in_q[8]>0)
		{
			server.timing();
			switch (server.next_event_type)
			{
                                case 1: break;
				case 2: server.depart(1);
				server.update_time_avg_stats(1);
				break;
				case 3: server.depart(2);
				server.update_time_avg_stats(2);
				break;
				case 4: server.depart(3);
				server.update_time_avg_stats(3);
				break;
				case 5: server.depart(4);
				server.update_time_avg_stats(4);
				case 6: server.depart(5);
				server.update_time_avg_stats(5);
				break;
				case 7: server.depart(6);
				server.update_time_avg_stats(6);
				break;
				case 8: server.depart(7);
				server.update_time_avg_stats(7);
				break;
				case 9: server.depart(8);
				server.update_time_avg_stats(8);
					break;
			}
		}
		
                String str;
		for(int i=1;i<server.num_events;i++)
                {
                    str=server.Report(i);
                    fild_area.append("result from Server "+i);
                    fild_area.append(str);
                    
                }
                str ="\n Simulation Ends at Time : "+server.sim_time+"\n\n\n";
                fild_area.append(str);  
    }//GEN-LAST:event_MyownProject_Simulate_btnActionPerformed

    
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
            java.util.logging.Logger.getLogger(MyOwnProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyOwnProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyOwnProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyOwnProject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyOwnProject().setVisible(true);
            }
        });
    }
    static Random random = new Random();
    public static double expon(double mean_interarrival) {
		 return (-mean_interarrival*Math.log(random.nextDouble()));
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MeanInterrival_boyler;
    private javax.swing.JButton MyownProject_Simulate_btn;
    private javax.swing.JTextArea fild_area;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField meanService_CustIron;
    private javax.swing.JTextField meanService_IronRod;
    private javax.swing.JTextField meanService_Pitch;
    private javax.swing.JTextField meanService_Puresteel;
    private javax.swing.JTextField meanService_Sediment;
    private javax.swing.JTextField meanService_SteelRod;
    private javax.swing.JTextField meanService_Wastage;
    private javax.swing.JTextField meanService_boyler;
    private javax.swing.JTextField total_sim_time;
    // End of variables declaration//GEN-END:variables
}
