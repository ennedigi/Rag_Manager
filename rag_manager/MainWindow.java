package rag_manager;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainWindow extends JFrame
{
  private JButton jButton1;
  private JButton jButton2;
  private JButton jButton3;
  private JDialog jDialog1;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JOptionPane jOptionPane1;

  public MainWindow()
  {
    initComponents();
  }

  private void initComponents()
  {
    this.jDialog1 = new JDialog();
    this.jOptionPane1 = new JOptionPane();
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    this.jButton3 = new JButton();
    this.jLabel3 = new JLabel();

    GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
    this.jDialog1.getContentPane().setLayout(jDialog1Layout);
    jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));

    jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));

    setDefaultCloseOperation(3);
    setTitle("Ragnagna Manager");

    this.jLabel1.setFont(new Font("DejaVu Sans", 0, 20));
    this.jLabel1.setHorizontalAlignment(0);
    this.jLabel1.setText("Welcome to");

    this.jLabel2.setFont(new Font("DejaVu Sans", 3, 22));
    this.jLabel2.setText("Ragnagna Manager!!!");

    this.jButton1.setText("Calculate a new Ragnagna");
    this.jButton1.setToolTipText("You can calculate the day of your next Ragnagna");
    this.jButton1.setCursor(new Cursor(0));
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainWindow.this.Handler(evt);
      }
    });
    this.jButton2.setText("Update Database");
    this.jButton2.setToolTipText("Update the database with your recent Ragnagna to make the program more accurate");
    this.jButton2.setCursor(new Cursor(0));
    this.jButton2.setFocusable(false);
    this.jButton2.setHorizontalTextPosition(0);
    this.jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainWindow.this.jButton2ActionPerformed(evt);
      }
    });
    this.jButton3.setText("Quit");
    this.jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        MainWindow.this.jButton3ActionPerformed(evt);
      }
    });
    this.jLabel3.setIcon(new ImageIcon(getClass().getResource("tulips.png")));

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jLabel3, -1, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel2)).addGroup(layout.createSequentialGroup().addGap(85, 85, 85).addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(38, 38, 38).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1).addComponent(this.jButton2, -2, 230, -2)))).addGap(85, 85, 85)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(219, 32767).addComponent(this.jButton3, -2, 83, -2).addGap(195, 195, 195)));

    layout.linkSize(0, new Component[] { this.jButton1, this.jButton2 });

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jLabel2).addGap(39, 39, 39).addComponent(this.jButton1).addGap(18, 18, 18).addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767).addComponent(this.jButton3, -2, 21, -2).addGap(28, 28, 28)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addContainerGap(163, 32767)));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width - 490) / 2, (screenSize.height - 333) / 2, 490, 333);
  }

  private void Handler(ActionEvent evt)
  {
    Main.mainWindow.setVisible(false);
    Main.calculateWindow = new RagnagnaManagerCalculator();
    Main.calculateWindow.setVisible(true);
  }

  private void jButton3ActionPerformed(ActionEvent evt)
  {
    Main.mainWindow.setVisible(false);
    dispose();
    System.exit(0);
  }

  private void jButton2ActionPerformed(ActionEvent evt)
  {
    Main.mainWindow.setVisible(false);

    Main.addWindow = new RagnagnaManagerAdd();
    Main.addWindow.setVisible(true);
  }
}