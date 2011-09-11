package rag_manager;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class RagnagnaView extends JFrame
{
  String[][] array;
  private JButton jButton1;
  private JButton jButton2;
  private JEditorPane jEditorPane1;
  private JLabel jLabel1;
  private JScrollPane jScrollPane2;

  public RagnagnaView()
  {
    initComponents();

    this.jEditorPane1.setEditable(false);
    printArrayFile(Main.FILEDATABASE);
  }

  private void printArrayFile(String filepath)
    throws HeadlessException
  {
    try
    {
      this.array = FileManager.convertToArray(filepath);

      if (this.array != null)
      {
        String stringa = "<br/><table border=\"0\" cellspacing=\"2\"><tr><td></td><td><strong>From</strong></td><td><strong>To</strong></td><td><strong>days</strong></td></tr>";

        for (int i = 0; i < this.array.length; i++) {
          if (i != this.array.length - 1)
            stringa = stringa + String.format("<tr><td>%s</td><td><strong>%s</strong></td><td>%s</td><td>%s</td></tr>", new Object[] { Integer.toString(i + 1), this.array[i][0], this.array[(i + 1)][0], this.array[i][1] });
          else {
            stringa = stringa + String.format("<tr><td>%s</td><td><strong>%s</strong></td><td></td><td></td></tr></table>", new Object[] { Integer.toString(i + 1), this.array[i][0] });
          }

          this.jEditorPane1.setText(stringa);
        }
      } else {
        this.jEditorPane1.setText("<br/><br/><br/><center>The database is EMPTY!</center>");
      }

    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }
  }

  private void initComponents()
  {
    this.jLabel1 = new JLabel();
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    this.jScrollPane2 = new JScrollPane();
    this.jEditorPane1 = new JEditorPane();

    setDefaultCloseOperation(3);
    setTitle("Ragnagna Manager");

    this.jLabel1.setFont(new Font("DejaVu Sans", 0, 18));
    this.jLabel1.setText("Ragnagna Database");

    this.jButton1.setText("Back");
    this.jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaView.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton2.setText("Delete a line");
    this.jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        RagnagnaView.this.jButton2ActionPerformed(evt);
      }
    });
    this.jEditorPane1.setContentType("text/html");
    this.jEditorPane1.setFont(new Font("DejaVu Sans", 0, 15));
    this.jScrollPane2.setViewportView(this.jEditorPane1);

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(this.jButton1, -2, 72, -2).addGap(108, 108, 108).addComponent(this.jButton2)).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.jScrollPane2, -2, 367, -2)).addGroup(layout.createSequentialGroup().addGap(121, 121, 121).addComponent(this.jLabel1))).addContainerGap(26, 32767)));

    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jScrollPane2, -2, 249, -2).addGap(28, 28, 28).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addContainerGap(36, 32767)));

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width - 420) / 2, (screenSize.height - 440) / 2, 420, 440);
  }

  private void jButton1ActionPerformed(ActionEvent evt) {
    Main.viewWindow.setVisible(false);
    dispose();
    Main.addWindow.setVisible(true);
  }

  private void jButton2ActionPerformed(ActionEvent evt)
  {
    String stringa = "";
    int lineToDelete = -1;

    if (this.array == null) {
      JOptionPane.showMessageDialog(null, "You cannot delete any line. The database is empty!");
      return;
    }

    stringa = JOptionPane.showInputDialog(null, "Insert the row number of the line that you want to delete: ");
    try
    {
      lineToDelete = Integer.parseInt(stringa);

      if ((lineToDelete > 0) && (lineToDelete <= this.array.length))
      {
        lineToDelete--;
        int x = 0;
        int i = 0;
        String[] newArray = new String[this.array.length];

        while (i < this.array.length) {
          if (i == lineToDelete) { i++; continue; }
          newArray[x] = this.array[i][0];
          x++;
          i++;
        }

        if (this.array.length == 1) FileManager.AddtoFile(Main.FILEDATABASE, null, false);
        else
          for (int t = 0; t < this.array.length - 1; t++)
            FileManager.AddtoFile(Main.FILEDATABASE, newArray[t], false);
      }
      else {
        JOptionPane.showMessageDialog(null, "Error: Input not valid. Try again");
      }
      this.jEditorPane1.setText("");

      printArrayFile(Main.FILEDATABASE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e + " Input not valid. Try again");
    }
  }
}