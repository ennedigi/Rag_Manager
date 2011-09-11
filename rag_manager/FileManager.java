package rag_manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FileManager
{
  public static File openFile(String filePath)
  {
    File file = new File(filePath);
    boolean nwFile = false;
    try
    {
      if (!file.isFile()) { JOptionPane.showMessageDialog(null, "Error: file not available");
        nwFile = file.createNewFile();
      }
      if (nwFile) JOptionPane.showMessageDialog(null, "A new file has been created!"); 
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: file not found");
    }
    return file;
  }

  public static int lengthFile(String filepath) throws IOException
  {
    int rowNumber = 0;
    BufferedReader inputFile = null;
    try {
      inputFile = new BufferedReader(new FileReader(openFile(filepath)));
      while (inputFile.readLine() != null)
        rowNumber++; 
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }inputFile.close();
    return rowNumber;
  }

  public static int periodRagnagna(String date1, String date2)
  {
    SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
    Date dayEnd = new Date();
    Date dayBegin = new Date();
    try {
      dayBegin = df2.parse(date1);
      dayEnd = df2.parse(date2); } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error parsing the date");
    }
    float differenceTime = (float)(dayEnd.getTime() - dayBegin.getTime());
    return (int)(differenceTime / 86400000.0F);
  }

  public static String[][] convertToArray(String filepath)
  {
    String[][] dateArray = (String[][])null;
    try
    {
      int rowNumber = lengthFile(filepath);
      if (rowNumber > 0)
      {
        dateArray = new String[rowNumber][2];
        BufferedReader inputFile = new BufferedReader(new FileReader(openFile(filepath)));
        int x = 0;
        String line;
        while ((line = inputFile.readLine()) != null) {
          dateArray[x][0] = line;
          x++;
        }

        for (int y = 0; y < dateArray.length - 1; y++)
          dateArray[y][1] = Integer.toString(periodRagnagna(dateArray[y][0], dateArray[(y + 1)][0]));
        dateArray[(dateArray.length - 1)][1] = null;
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error: " + e);
    }return dateArray;
  }

  public static Date findLastDateArray(String filepath) {
    Date LastDate = null;
    if (convertToArray(filepath) != null) {
      String[][] array = convertToArray(filepath);
      SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
      try
      {
        LastDate = df2.parse(array[(array.length - 1)][0]); } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e);
      }
    }
    return LastDate;
  }

  public static void AddtoFile(String filePath, String addLine, boolean append)
  {
    BufferedWriter outputFile = null;
    try {
      outputFile = new BufferedWriter(new FileWriter(filePath, append));
      if (addLine == null) return;
      outputFile.write(addLine);
      outputFile.newLine();
      outputFile.flush();
      outputFile.close(); } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error in AddToFile: " + e);
    }
  }
}