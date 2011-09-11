package rag_manager;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;

public class RagnagnaManagerAdd extends JFrame
{
  private JButton jButton1;
  private JButton jButton2;
  private JButton jButton3;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JSeparator jSeparator1;
  private JSpinner jSpinner1;

  public RagnagnaManagerAdd()
  {
    initComponents();
  }

  private void initComponents()
  {
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jLabel2 = new JLabel();
    this.jButton3 = new JButton();
    this.jSpinner1 = new JSpinner();
    this.jButton2 = new JButton();
    this.jSeparator1 = new JSeparator();
    this.jLabel3 = new JLabel();

    setDefaultCloseOperation(3);
    setTitle("Ragnagna Manager");

    this.jLabel1.setFont(new Font("DejaVu Sans", 0, 18));
    this.jLabel1.setText("Update your Ragnagna Database");

    this.jButton1.setText("Back");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaManagerAdd.this.jButton1ActionPerformed(evt);
      }
    });
    this.jLabel2.setText("Insert the day of a new Ragnagna");

    this.jButton3.setText("View");
    this.jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaManagerAdd.this.jButton3ActionPerformed(evt);
      }
    });
    this.jSpinner1.setModel(new SpinnerDateModel());
    this.jSpinner1.setEditor(new JSpinner.DateEditor(this.jSpinner1, "dd/MM/yyyy"));
    this.jSpinner1.setFocusable(false);

    this.jButton2.setText("Add");
    this.jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaManagerAdd.this.jButton2ActionPerformed(evt);
      }
    });
    this.jSeparator1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

    this.jLabel3.setText("View the list of Ragnagna in the Database");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(51, 51, 51).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.jLabel3).addContainerGap(102, 32767)).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jSpinner1, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 79, 32767).addComponent(this.jButton2, -2, 68, -2).addContainerGap(84, 32767)).addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.jButton1, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, 32767).addComponent(this.jButton3, -2, 80, -2).addGap(83, 83, 83)))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -2, 323, -2).addGap(47, 47, 47)))).addGroup(layout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.jLabel1).addContainerGap(71, 32767)).addGroup(layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jSeparator1, -2, 377, -2).addContainerGap(27, 32767)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1).addGap(34, 34, 34).addComponent(this.jLabel2, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jSpinner1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSeparator1, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton3)).addContainerGap(35, 32767)));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width - 430) / 2, (screenSize.height - 307) / 2, 430, 307);
  }

  private void jButton1ActionPerformed(ActionEvent evt)
  {
    Main.addWindow.setVisible(false);
    dispose();
    Main.mainWindow.setVisible(true);
  }

  private void jButton3ActionPerformed(ActionEvent evt)
  {
    Main.addWindow.setVisible(false);

    Main.viewWindow = new RagnagnaView();
    Main.viewWindow.setVisible(true);
  }

  private void jButton2ActionPerformed(ActionEvent evt)
  {
    Date dateNewRagnagna = CalculateBrain.checkDateJSpinner(Main.addWindow.jSpinner1, "dd/MM/yyyy");
    if (dateNewRagnagna == null) return;

    String dateString = CalculateBrain.checkStringJSpinner(Main.addWindow.jSpinner1);

    if (FileManager.findLastDateArray(Main.FILEDATABASE) != null)
    {
      if ((dateNewRagnagna.equals(FileManager.findLastDateArray(Main.FILEDATABASE))) || (dateNewRagnagna.before(FileManager.findLastDateArray(Main.FILEDATABASE))))
      {
        int option = JOptionPane.showConfirmDialog(null, "The database contains already some infomation about that month. Continue anyway?");
        if ((option == 1) || (option == 2)) return;
      }
    }
    int checkDate = JOptionPane.showConfirmDialog(null, "The database will be updated with a new date: " + dateString + ". Are you sure?");

    if ((checkDate == 1) || (checkDate == 2)) return;
    FileManager.AddtoFile(Main.FILEDATABASE, dateString, true);
  }
}