/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ananda Mohon Ghosh
 */
import java.util.*;
import java.awt.*;
public class AdaptiveDecisionBoundaryJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdaptiveDecisionBoundaryJFrame
     */
    public AdaptiveDecisionBoundaryJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        numberOfDatajTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ExecuteADBjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        w0_jTextField = new javax.swing.JTextField();
        w1_jTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        W2_jTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Series_X1_jTextField = new javax.swing.JTextField();
        Series_X2_jTextField = new javax.swing.JTextField();
        Series_d_jTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        c_value_jTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        k_value_jTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Adaptive Decission Boundary");

        jLabel2.setText("Length");

        ExecuteADBjButton.setText("Execute");
        ExecuteADBjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecuteADBjButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("W 0");

        jLabel4.setText("W1");

        jLabel5.setText("W2");

        jLabel6.setText("X1 Series");

        jLabel7.setText("X2 Series");

        jLabel8.setText("d Series");

        jLabel9.setText("C");

        jLabel10.setText("K");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ExecuteADBjButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(120, 120, 120)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Series_X1_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Series_d_jTextField)
                                        .addComponent(Series_X2_jTextField))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(W2_jTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(w1_jTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(w0_jTextField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(8, 8, 8)
                                        .addComponent(numberOfDatajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(c_value_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(k_value_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberOfDatajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(c_value_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(w0_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(k_value_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(w1_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(W2_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Series_X1_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Series_X2_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Series_d_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExecuteADBjButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Scanner sc = new Scanner(System.in);
    float dataMatrix[][];
    boolean isError[];
    float old_w0=0, old_w1=0, old_w2=0,d,D,C,K;
    private void ExecuteADBjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExecuteADBjButtonActionPerformed
        // TODO add your handling code here:
        int dataLenth = Integer.parseInt(numberOfDatajTextField.getText());
        isError = new boolean[dataLenth];
        dataMatrix = new float[dataLenth][3];
        old_w0 = Integer.parseInt(w0_jTextField.getText());
        old_w1 = Integer.parseInt(w1_jTextField.getText());
        C= Integer.parseInt(c_value_jTextField.getText());
        K= Integer.parseInt(k_value_jTextField.getText());
        String str = "2,3,5,50,65,35,-3";
        System.out.println(str);
        int count = 0;
        StringTokenizer st = new StringTokenizer(str,"," );
     while (st.hasMoreTokens()) {
         dataMatrix[count][0]=Float.valueOf(st.nextToken());
         //System.out.println((st.nextToken()));
         count++;
     } 
    
      for (int i = 0; i < dataLenth; i++) {
            System.out.println(dataMatrix[i][0]);
            
        }
       
      str = "10,8,2,25,30,40,-40";
      count = 0;
      st = new StringTokenizer(str, "," );
     while (st.hasMoreTokens()) {
         dataMatrix[count][1]=Integer.parseInt(st.nextToken());
         count++;
     } 
     str = "1,1,1,-1,-1,-1,1";
      count = 0;
      st = new StringTokenizer(str,"," );
     while (st.hasMoreTokens()) {
         dataMatrix[count][2]=Integer.parseInt(st.nextToken());
         count++;
     } 
        for (int i = 0; i < dataLenth; i++) {
            System.out.println(dataMatrix[i][0]+" "+dataMatrix[i][1]+" "+dataMatrix[i][2]+" ");
            
        }
        
        for (int i = 0; i < dataLenth; i++) {
           isError[i]=true; 
        }
        
        for (;;) 
        {
            for(int i = 0; i<dataLenth;i++)
            {
               float x1 = dataMatrix[i][0];
               float x2 = dataMatrix[i][1];
               d =dataMatrix[i][2];
               D = old_w0+old_w1*x1+old_w2*x2;
               if(D>=0)
                   D = 1;
               else
                   D =-1;
                       
               if(d!=D)
               {
                   old_w0 = old_w0+d*C*K;
                   old_w1 = old_w1 + d*x1*C;
                   old_w2 = old_w2+d*x2;
                   isError[i] =true;
               }
               else
                   isError[i] =false;
               
               
               
            }
            boolean flag = false;
                for (int j = 0; j <isError.length; j++) {
                    if(isError[j]==true)
                        flag =true;
                     System.out.println(isError[j]);             
                }
                if(flag ==false)
                    break;
           System.out.println("W0:  " + old_w0+"  W1:  "+old_w1+"  W2:  "+old_w2); 
        } 
        
        // input
        ///2,3,5,50,65,35    10,8,2,25,30,40    1,1,1,-1,-1,-1
        
        //D = w0+W1X1+W2x2
        //0 = w0+W1X1+W2x2
        
        int locY1= Math.round((-old_w0-old_w1*(-20))/old_w2)+300;
        int locY2 =Math.round((-old_w0-old_w1*200)/old_w2)+300;
        System.out.println(locY1+"  "+locY2);
        
      OutputDesignNewJFrame out_j = new OutputDesignNewJFrame(300-20, 600-locY1, 500, 600-locY2, dataMatrix,dataLenth);
    }//GEN-LAST:event_ExecuteADBjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdaptiveDecisionBoundaryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdaptiveDecisionBoundaryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdaptiveDecisionBoundaryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdaptiveDecisionBoundaryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdaptiveDecisionBoundaryJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExecuteADBjButton;
    private javax.swing.JTextField Series_X1_jTextField;
    private javax.swing.JTextField Series_X2_jTextField;
    private javax.swing.JTextField Series_d_jTextField;
    private javax.swing.JTextField W2_jTextField;
    private javax.swing.JTextField c_value_jTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField k_value_jTextField;
    private javax.swing.JTextField numberOfDatajTextField;
    private javax.swing.JTextField w0_jTextField;
    private javax.swing.JTextField w1_jTextField;
    // End of variables declaration//GEN-END:variables
}
