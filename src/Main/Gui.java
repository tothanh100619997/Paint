/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author totha
 */
public class Gui extends javax.swing.JFrame {
     public static ArrayList<Paint> paint2D = new ArrayList<Paint>();
     public static ArrayList<Paint> paint3D = new ArrayList<Paint>();
     public static boolean Draw3d = false;
     public static String selectButton ="";
     public static Color selectColor = Color.black;
     public static int X;
     public static int Y;
     public static int Z;
     public static float vanToc =0;
     public static  int bk = 50;
     public static  Point flag = new Point(-494+bk,0);
     public javax.swing.JPanel pnlInfomation;
     public  static int kc=5;
     public  static int duration=40;
    /**
     * Creates new form Gui
     */
   
    public Gui() {
        initComponents();
        setSize(1230,730);
        setResizable(false);
        setIconImage(new ImageIcon("Image/draw.png").getImage());
        //panel content//
        pnlContent.setLayout(new BorderLayout(0, 0));
        pnlContent.setBackground(Color.white);
        setContentPane(pnlContent);
        //paint//
        pnlOxy.add(new Paint_2D(),BorderLayout.CENTER);
        //show thong tin//
        Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {  
                  
                    if(paint2D.size()>0){
                        float vt = (float) (kc/(duration*0.001));
                        if("star".equals(selectButton)){
                        Paint pt = paint2D.get(0);
                        MyStar r = (MyStar) pt;
                         row1.setText("Rolling Ball Star");
                         row2.setText("Tọa độ tâm: "+"("+(r.getA().x+r.getB().x)*0.5+" , "+(r.getA().y+r.getB().y)*0.5 +")");
                         row3.setText("Bán kính: "+bk);
                         row4.setText("Vận Tốc:"+ vt+"px/s");
                        }
                        if("ball".equals(selectButton)){
                            Paint pt = paint2D.get(0);                     
                            MyEllip p = (MyEllip) pt;
                            float tVantoc = vanToc;
                            if(tVantoc<0) tVantoc=-tVantoc;
                            tVantoc = (float) (tVantoc/(duration*0.001));
                        
                         row1.setText("Drop Ball ");
                         row2.setText("Tọa độ tâm: "+"("+(p.getA().x+30)+" , "+p.getB().y*(-1)+")");
                         row3.setText("Bán kính: "+(p.getA().y-p.getC().y)/-2);
                         row4.setText("Vận Tốc:"+tVantoc+"px/s");
                        }
                     
                    }
                    if(paint3D.size()>0){
                        if("Cube".equals(selectButton)){
                            
                              Paint pt = paint3D.get(0);                     
                              MyCube p = (MyCube) pt;
                              row1.setText("Khoi Lap Phuong "); 
                              row2.setText("Tọa độ Tâm: "+"("+0+" , "+0 +" , "+ 0+ ")");
                              row3.setText("Tọa độ X: "+"("+p.getDt1().getB().x+" , "+0 +" , "+0 + ")");
                           
                              row4.setText("Tọa độ Y: "+"("+0+" , "+p.getDt5().getB().y +" , "+ 0+ ")");
                              row5.setText("Tọa độ Z: "+"("+0+" , "+0 +" , "+ p.getDt4().getB().y*-1+ ")");
                              selectButton="";
                        }
                        
                        if("Pyramid".equals(selectButton)){
                            
                              Paint pt = paint3D.get(0);                     
                              MyPyramid p = (MyPyramid) pt;
                              row1.setText("Hinh Chop "); 
                              row2.setText("Tọa độ Tâm: "+"("+0+" , "+0 +" , "+ 0+ ")");
                              row3.setText("Tọa độ X: "+"("+p.getDt1().getB().x+" , "+0 +" , "+0 + ")");
                           
                              row4.setText("Tọa độ Y: "+"("+0+" , "+p.getDt2().getA().y +" , "+ 0+ ")");
                              row5.setText("Tọa độ Đỉnh: "+"("+p.getDt5().getA().x+" , "+p.getDt5().getA().y +" , "+ p.getDt5().getB().y*(-1)+ ")");
                              selectButton="";
                        }
                    }
                 
                }
              }, 1000, 50);
             
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContent = new javax.swing.JPanel();
        pnlControl = new javax.swing.JPanel();
        btnSwitch = new javax.swing.JButton();
        btnStar = new javax.swing.JButton();
        btnBall = new javax.swing.JButton();
        btnPyramit = new javax.swing.JButton();
        btnCube = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        pnlInformation = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        row1 = new javax.swing.JLabel();
        row2 = new javax.swing.JLabel();
        row4 = new javax.swing.JLabel();
        row5 = new javax.swing.JLabel();
        row3 = new javax.swing.JLabel();
        pnlOxy = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vẽ hình cơ bản");
        setPreferredSize(new java.awt.Dimension(1230, 730));
        setSize(new java.awt.Dimension(1230, 730));

        pnlContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlContent.setToolTipText("");

        pnlControl.setPreferredSize(new java.awt.Dimension(1215, 75));

        btnSwitch.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\3D.png")); // NOI18N
        btnSwitch.setMaximumSize(new java.awt.Dimension(83, 59));
        btnSwitch.setPreferredSize(new java.awt.Dimension(85, 60));
        btnSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchActionPerformed(evt);
            }
        });

        btnStar.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\star.png")); // NOI18N
        btnStar.setPreferredSize(new java.awt.Dimension(85, 60));
        btnStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStarActionPerformed(evt);
            }
        });

        btnBall.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\ball.png")); // NOI18N
        btnBall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBallActionPerformed(evt);
            }
        });

        btnPyramit.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\pyramid.png")); // NOI18N
        btnPyramit.setEnabled(false);
        btnPyramit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPyramitActionPerformed(evt);
            }
        });

        btnCube.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\cube.png")); // NOI18N
        btnCube.setEnabled(false);
        btnCube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCubeActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon("D:\\Java\\KyThuatDoHoa\\Image\\clear.png")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlLayout = new javax.swing.GroupLayout(pnlControl);
        pnlControl.setLayout(pnlControlLayout);
        pnlControlLayout.setHorizontalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSwitch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBall, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPyramit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCube, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        pnlControlLayout.setVerticalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPyramit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSwitch, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(btnBall, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCube, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlInformation.setBackground(new java.awt.Color(153, 255, 102));
        pnlInformation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlInformation.setPreferredSize(new java.awt.Dimension(200, 580));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INFORMATION");

        jLabel2.setText("Loading...");

        row1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        row1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlInformationLayout = new javax.swing.GroupLayout(pnlInformation);
        pnlInformation.setLayout(pnlInformationLayout);
        pnlInformationLayout.setHorizontalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(row1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(row2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(row4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(row5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(row3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInformationLayout.setVerticalGroup(
            pnlInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(row1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(row2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(row3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(row4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(row5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 326, Short.MAX_VALUE))
        );

        pnlOxy.setBackground(new java.awt.Color(255, 255, 255));
        pnlOxy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnlOxyLayout = new javax.swing.GroupLayout(pnlOxy);
        pnlOxy.setLayout(pnlOxyLayout);
        pnlOxyLayout.setHorizontalGroup(
            pnlOxyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlOxyLayout.setVerticalGroup(
            pnlOxyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentLayout.createSequentialGroup()
                        .addComponent(pnlInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlOxy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOxy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");
        jMenu2.setName("menuBar"); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
      new Information("About", "             @author TO NGUYEN \n                   Copyright © 2019\n                   All rights reserved.", 80, 50);
    }//GEN-LAST:event_jMenu2MouseClicked
    int i=0;
    private void btnSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchActionPerformed
                // TODO add your handling code here:
        selectButton="switch";        
        i++;
        if(i%2==0){
                btnSwitch.setIcon(new ImageIcon("Image/3D.png"));
                paint3D.removeAll(paint3D);
                Draw3d = false;
                btnBall.setEnabled(true);
                btnStar.setEnabled(true);
                btnPyramit.setEnabled(false);
                btnCube.setEnabled(false);
                
        }else{
                paint2D.removeAll(paint2D);
                btnSwitch.setIcon(new ImageIcon("Image/2D.png"));
                Draw3d = true;
                btnBall.setEnabled(false);
                btnStar.setEnabled(false);
                btnPyramit.setEnabled(true);
                btnCube.setEnabled(true);
        }
         repaint();
         validate();
    }//GEN-LAST:event_btnSwitchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        selectButton="clear";  
        paint2D.clear();
        paint3D.clear();
        row1.setText("");
        row2.setText("");
        row3.setText("");
        row4.setText("");
        row5.setText("");
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStarActionPerformed
        // TODO add your handling code here:
          
          selectButton="star";  
          
    }//GEN-LAST:event_btnStarActionPerformed

    private void btnBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBallActionPerformed
        // TODO add your handling code here:
        selectButton="ball";
    }//GEN-LAST:event_btnBallActionPerformed

    private void btnCubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCubeActionPerformed
        // TODO add your handling code here:
        NhapToaDo3D hcn = new NhapToaDo3D("Cube");
        
    }//GEN-LAST:event_btnCubeActionPerformed

    private void btnPyramitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPyramitActionPerformed
        // TODO add your handling code here:
        
        NhapToaDo3D ht = new NhapToaDo3D("Pyramid");
    }//GEN-LAST:event_btnPyramitActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Gui().setVisible(true);
        });
    }

    private Image getIconImage(String imagedrawpng) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBall;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCube;
    private javax.swing.JButton btnPyramit;
    private javax.swing.JButton btnStar;
    private javax.swing.JButton btnSwitch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JPanel pnlOxy;
    private javax.swing.JLabel row1;
    private javax.swing.JLabel row2;
    private javax.swing.JLabel row3;
    private javax.swing.JLabel row4;
    private javax.swing.JLabel row5;
    // End of variables declaration//GEN-END:variables

    //phép quay
    public static Point rotateAround(Point p, float angle) {
        Point p2 = new Point();
        AffineTransform rotation = new AffineTransform();
        double angleInRadians = (angle * Math.PI / 180);
        rotation.rotate(angleInRadians, flag.x,flag.y );
        rotation.transform(p, p2);
        return p2;
    }

    public static void Ve4Diem(Graphics g, int xc, int yc, int x, int y, float a) {
        Point p1 = new Point(xc + x, yc + y);
        Point p2 = new Point(xc - x, yc + y);
        Point p3 = new Point(xc - x, yc - y);
        Point p4 = new Point(xc + x, yc - y);
       //vẽ đều ra hai bên
        p1 = rotateAround(p1, a);
        p2 = rotateAround(p2, a);
        p3 = rotateAround(p3, a);
        p4 = rotateAround(p4, a);
       // put pixel
        g.fillRect(p1.x, p1.y, 5, 5);
        g.fillRect(p2.x, p2.y, 5, 5);
        g.fillRect(p3.x, p3.y, 5, 5);
        g.fillRect(p4.x, p4.y, 5, 5);
    }
  public static double areaTriangle(Point A, Point B, Point C) {
		return Math.abs(A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y));
	}


}
