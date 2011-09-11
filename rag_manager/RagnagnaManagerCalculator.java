package rag_manager;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;

public class RagnagnaManagerCalculator extends JFrame
{
  private JButton jButton1;
  private JButton jButton3;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JSpinner jSpinner1;

  public RagnagnaManagerCalculator()
  {
    initComponents();

    this.jLabel3.setVisible(false);
    this.jLabel4.setVisible(false);
    this.jLabel5.setVisible(false);
    this.jLabel6.setVisible(false);
    this.jLabel7.setVisible(false);

    this.jSpinner1.setEditor(new JSpinner.DateEditor(this.jSpinner1, "MMM / yyyy "));
  }

  private void initComponents()
  {
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jLabel2 = new JLabel();
    this.jLabel3 = new JLabel();
    this.jLabel4 = new JLabel();
    this.jButton3 = new JButton();
    this.jSpinner1 = new JSpinner();
    this.jLabel5 = new JLabel();
    this.jLabel6 = new JLabel();
    this.jLabel7 = new JLabel();

    setDefaultCloseOperation(3);
    setTitle("Ragnagna Manager");

    this.jLabel1.setFont(new Font("DejaVu Sans", 0, 18));
    this.jLabel1.setText("Calculate your next Ragnagna");

    this.jButton1.setText("Back");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaManagerCalculator.this.jButton1ActionPerformed(evt);
      }
    });
    this.jLabel2.setText("Insert Month and Year");

    this.jLabel3.setFont(new Font("DejaVu Sans", 2, 16));
    this.jLabel3.setText("Your next ragnagna will be on");

    this.jLabel4.setFont(new Font("DejaVu Sans", 1, 16));
    this.jLabel4.setText("jLabel4");

    this.jButton3.setText("OK");
    this.jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaManagerCalculator.this.jButton3ActionPerformed(evt);
      }
    });
    this.jSpinner1.setModel(new SpinnerDateModel());
    this.jSpinner1.setFocusable(false);

    this.jLabel5.setFont(new Font("DejaVu Sans", 2, 16));
    this.jLabel5.setText("Your avarage period is ");

    this.jLabel6.setFont(new Font("DejaVu Sans", 1, 16));
    this.jLabel6.setText("000");

    this.jLabel7.setFont(new Font("DejaVu Sans", 2, 16));
    this.jLabel7.setText("days");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.jLabel2).addGap(75, 75, 75).addComponent(this.jSpinner1, -2, 113, -2)).addGroup(layout.createSequentialGroup().addGap(41, 41, 41).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(82, 82, 82).addComponent(this.jButton1, -2, 72, -2).addGap(71, 71, 71).addComponent(this.jButton3, -2, 80, -2)).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4, -2, 174, -2)))).addGroup(layout.createSequentialGroup().addGap(104, 104, 104).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel7)).addGroup(layout.createSequentialGroup().addGap(99, 99, 99).addComponent(this.jLabel1))).addContainerGap(-1, 32767)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jLabel1).addGap(33, 33, 33).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jSpinner1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel3)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel5)).addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton3).addComponent(this.jButton1)).addGap(26, 26, 26)));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width - 458) / 2, (screenSize.height - 307) / 2, 458, 307);
  }

  private void jButton1ActionPerformed(ActionEvent evt)
  {
    Main.calculateWindow.setVisible(false);
    dispose();
    Main.mainWindow.setVisible(true);
  }

  private void jButton3ActionPerformed(ActionEvent evt)
  {
    Date newRagnaGuessed = new Date();

    Date dateNextRagnagna = CalculateBrain.checkDateJSpinner(Main.calculateWindow.jSpinner1, "MMM / yyyy ");

    if (dateNextRagnagna == null) return;

    if (FileManager.findLastDateArray(Main.FILEDATABASE) == null) {
      JOptionPane.showMessageDialog(null, "The Ragnagna database is empty. Update tha database first");
      return;
    }

    if (!FileManager.findLastDateArray(Main.FILEDATABASE).after(dateNextRagnagna))
    {
      String[][] array = FileManager.convertToArray(Main.FILEDATABASE);
      if (array.length == 1) {
        JOptionPane.showMessageDialog(null, "You do not have enough information to calculate new Ragnagna. Please update tha database.");
        return;
      }

      newRagnaGuessed = CalculateBrain.newRagnagna(array, dateNextRagnagna);

      String giornoEsatto = newRagnaGuessed.toString().substring(0, 3) + " " + newRagnaGuessed.getDate() + " " + newRagnaGuessed.toString().substring(4, 8) + Integer.toString(newRagnaGuessed.getYear() + 1900);

      int period = (int)CalculateBrain.avaragePeriodRagnagna(array);

      Main.calculateWindow.jLabel3.setVisible(true);
      Main.calculateWindow.jLabel4.setText(giornoEsatto);
      Main.calculateWindow.jLabel4.setVisible(true);
      Main.calculateWindow.jLabel5.setVisible(true);

      Main.calculateWindow.jLabel6.setText(Integer.toString(period));
      Main.calculateWindow.jLabel6.setVisible(true);
      Main.calculateWindow.jLabel7.setVisible(true);
    }
    else {
      JOptionPane.showMessageDialog(null, "Error: date not valid! Please insert a month after the last Ragnagna");
    }
  }
}