import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
public class okno2 extends JFrame {
  private static final long serialVersionUID = 1L;

  private JButton button1;
  private JButton button2;
  private  JFileChooser fileChooser = null;

    private final String[][] FILTERS = {{"docx", "Файлы Word (*.docx)"},
            {"pdf" , "Adobe Reader(*.pdf)"}};
    public okno2() {
        final JPanel panel1 = new JPanel();
      // Кнопка создания диалогового окна для сохранения файла
      //button2 = new JButton();
      //button2.setText("Сохранить файл");
        button1 = new JButton();
        button1.setText("Открыть директорию");
        panel1.add(button1);
     // panel1.add(button2);
        addFileChooserListeners();
// Создание экземпляра JFileChooser
        fileChooser = new JFileChooser();
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.getContentPane().add(button1);
     // this.getContentPane().add(button2);
        setVisible(true);
    }
    private void addFileChooserListeners() {
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                // Определение режима - только каталог
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(okno2.this);
                // Если директория выбрана, покажем ее в сообщении
                if (result == JFileChooser.APPROVE_OPTION )
                    JOptionPane.showMessageDialog(okno2.this,
                            fileChooser.getSelectedFile());
              //String fname = re.open();


      /*try {

        File pdfFile = new File(result);
        if (pdfFile.exists()) {
          //     Desktop.getDesktop().print(file);
          if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(pdfFile);

          } else {
            System.out.println("Awt Desktop is not supported!");
          }

        } else {
          System.out.println("File is not exists!");
        }

        System.out.println("Done");

      } catch (Exception ex) {
        ex.printStackTrace();
      */}});
    /*  button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          fileChooser.setDialogTitle("Сохранение файла");
          // Определение режима - только файл
          fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
          int result = fileChooser.showSaveDialog(okno2.this);
          // Если файл выбран, то представим его в сообщении
          if (result == JFileChooser.APPROVE_OPTION )
            JOptionPane.showMessageDialog(okno2.this,
              "Файл '" + fileChooser.getSelectedFile() +
                " ) сохранен");
        }
      });
*/
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
        okno2 app = new okno2();
        app.pack();
    }
}
