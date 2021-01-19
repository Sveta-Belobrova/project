import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
public class okno4 extends JFrame {
  private static final long serialVersionUID = 1L;

  private JButton button2;
  private  JFileChooser fileChooser = null;

  private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
    {"pdf" , "Adobe Reader(*.pdf)"}};
  public okno4() {
    final JPanel panel1 = new JPanel();
    // Кнопка создания диалогового окна для сохранения файла
   button2 = new JButton();
   button2.setText("Сохранить файл");

    panel1.add(button2);
    // panel1.add(button2);
    addFileChooserListeners();
// Создание экземпляра JFileChooser
    fileChooser = new JFileChooser();
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    this.getContentPane().add(button2);
    // this.getContentPane().add(button2);
    setVisible(true);
  }
  private void addFileChooserListeners() {

      button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          fileChooser.setDialogTitle("Сохранение файла");
          // Определение режима - только файл
          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
          int result = fileChooser.showSaveDialog(okno4.this);
          // Если файл выбран, то представим его в сообщении
          if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(okno4.this,
              "Файл '" + fileChooser.getSelectedFile() +
                " ) сохранен");
        }
      });

  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }

  // Фильтр выбора файлов определенного типа
  class FileFilterExt extends javax.swing.filechooser.FileFilter
  {
    String extension  ;  // расширение файла
    String description;  // описание типа файлов

    FileFilterExt(String extension, String descr)
    {
      this.extension = extension;
      this.description = descr;
    }
    @Override
    public boolean accept(java.io.File file)
    {
      if(file != null) {
        if (file.isDirectory())
          return true;
        if( extension == null )
          return (extension.length() == 0);
        return file.getName().endsWith(extension);
      }
      return false;
    }
    // Функция описания типов файлов
    @Override
    public String getDescription() {
      return description;
    }
  }
  public static void main(String[] args) {

    // Локализация компонентов окна JFileChooser
    UIManager.put(
      "FileChooser.saveButtonText", "Сохранить");
    UIManager.put(
      "FileChooser.cancelButtonText", "Отмена");
    UIManager.put(
      "FileChooser.fileNameLabelText", "Наименование файла");
    UIManager.put(
      "FileChooser.filesOfTypeLabelText", "Типы файлов");
    UIManager.put(
      "FileChooser.lookInLabelText", "Директория");
    UIManager.put(
      "FileChooser.saveInLabelText", "Сохранить в директории");
    UIManager.put(
      "FileChooser.folderNameLabelText", "Путь директории");
    okno4 app = new okno4();
    app.pack();
  }
}
