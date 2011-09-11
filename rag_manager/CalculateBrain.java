package rag_manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;


public class CalculateBrain
{
  public static Date checkDateJSpinner(JSpinner spinner, String format)
  {
    Date dateJSpinner = null;

    String string = "";

    SimpleDateFormat df = new SimpleDateFormat(format);

    JFormattedTextField stringFormatted1 = new JFormattedTextField();

    JComponent editor1 = spinner.getEditor();

    if ((editor1 instanceof JSpinner.DefaultEditor))
    {
      stringFormatted1 = ((JSpinner.DefaultEditor)editor1).getTextField();
    }
    string = stringFormatted1.getText();
    try
    {
      dateJSpinner = df.parse(string); } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "The date is not valid. Try again.", "Error", 0);
    }

    return dateJSpinner;
  }

  public static String checkStringJSpinner(JSpinner spinner)
  {
    String string = "";

    JFormattedTextField stringFormatted1 = new JFormattedTextField();
    JComponent editor1 = spinner.getEditor();

    if ((editor1 instanceof JSpinner.DefaultEditor))
    {
      stringFormatted1 = ((JSpinner.DefaultEditor)editor1).getTextField();
    }
    string = stringFormatted1.getText();

    return string;
  }

  public static Date newRagnagna(String[][] array, Date forecast)
  {
    long CONVERSION = 86400000L;

    Date newDate = new Date();

    long avarageRagnagna = (long) (avaragePeriodRagnagna(array) * 86400000.0F);

    Date lastDay = FileManager.findLastDateArray(Main.FILEDATABASE);

    newDate.setTime(lastDay.getTime() + avarageRagnagna);

    while (forecast.getTime() > newDate.getTime()) {
      newDate.setTime(newDate.getTime() + avarageRagnagna);
    }
    return newDate;
  }

  public static float avaragePeriodRagnagna(String[][] array) {
    int sumPeriods = 0;
    try
    {
      for (int i = 0; i < array.length - 1; i++)
        sumPeriods += Integer.parseInt(array[i][1]); 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error " + e);
    }
    return sumPeriods / (array.length - 1);
  }
}