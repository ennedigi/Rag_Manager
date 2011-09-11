package rag_manager;

import java.io.File;

public class Main
{
  public static MainWindow mainWindow;
  public static RagnagnaManagerCalculator calculateWindow;
  public static RagnagnaManagerAdd addWindow;
  public static RagnagnaView viewWindow;
  public static final String FILEDATABASE = "." + File.separator + "ragn.rgr";

  public static void main(String[] args)
  {
    mainWindow = new MainWindow();
    mainWindow.setVisible(true);
  }
}