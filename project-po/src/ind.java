import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
public class ind extends JFrame {
  private static final long serialVersionUID = 1L;
  private  JFileChooser fileChooser = null;
  private JMenu file;
  private JMenuItem open;
  private JMenuItem av;
  private JMenuItem save;
  private JMenuItem poil;
  // Пункт меню из команды с выходом из программы

  //--------------------------------------------------------
  /**
   * Конструктор класса
   */
  public  ind() {

    final JPanel panel1 = new JPanel();
    //super("Системное меню");
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    // Создание строки главного меню
    JMenuBar menuBar = new JMenuBar();
    // Добавление в главное меню выпадающих пунктов меню
    menuBar.add(createFileMenu());
    menuBar.add(createViewMenu());
    // Подключаем меню к интерфейсу приложения
    setJMenuBar(menuBar);
    // Открытие окна
    setSize(300, 200);
    setVisible(true);
  }
  private JMenu createFileMenu() {
    // Создание выпадающего меню
    file = new JMenu("Файл");
    // Пункт меню "Открыть" с изображением
     open = new JMenuItem("Открыть",
      new ImageIcon("images/open.png"));
    // Пункт меню из команды с выходом из программы
    JMenuItem exit = new JMenuItem(new ExitAction());
    // Добавление к пункту меню изображения
    exit.setIcon(new ImageIcon("images/exit.png"));
     av = new JMenuItem("авторизация",
      new ImageIcon("images/open.png"));
    save = new JMenuItem("сохранение",
      new ImageIcon("images/open.png"));
    poil = new JMenuItem("поиск",
      new ImageIcon("images/open.png"));
    // Добавим в меню пункта open
    file.add(open);
    // Добавление разделителя
    file.addSeparator();
    file.add(exit);
    file.addSeparator();
    file.add(av);
    file.addSeparator();
    file.add(save);
    file.addSeparator();
    file.add(poil);
    fileChooser = new JFileChooser();
    setDefaultCloseOperation( EXIT_ON_CLOSE );
        this.getContentPane().add(file);
    addFileChooserListeners();
    return file;

  }
    private void addFileChooserListeners() {
    open.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        fileChooser.setDialogTitle("Выбор директории");
        // Определение режима - только каталог
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(ind.this);
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION)
          JOptionPane.showMessageDialog(ind.this,
            fileChooser.getSelectedFile());
      }
    });
      av.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
          index form = new index();
          dispose();
          form.setVisible(true);
        }
      });
      save.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
          okno4 form = new okno4();
          dispose();
          form.setVisible(true);
        }
      });
      poil.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
          okno1 form = new okno1();
          dispose();
          form.setVisible(true);
        }
      });
  }

  //--------------------------------------------------------
  // создадим забавное меню
  /**
   * Функция создания меню
   * @return
   */
  private JMenu createViewMenu()
  {
    // создадим выпадающее меню
    JMenu viewMenu = new JMenu("Вид");
    // меню-флажки
    JCheckBoxMenuItem line  = new JCheckBoxMenuItem("Линейка");
    JCheckBoxMenuItem grid  = new JCheckBoxMenuItem("Сетка");
    JCheckBoxMenuItem navig = new JCheckBoxMenuItem("Навигация");
    // меню-переключатели
    JRadioButtonMenuItem one = new JRadioButtonMenuItem("Одна страница");
    JRadioButtonMenuItem two = new JRadioButtonMenuItem("Две страницы");
    // организуем переключатели в логическую группу
    ButtonGroup bg = new ButtonGroup();
    bg.add(one);
    bg.add(two);
    // добавим все в меню
    viewMenu.add(line);
    viewMenu.add(grid);
    viewMenu.add(navig);
    // разделитель можно создать и явно
    viewMenu.add( new JSeparator());
    viewMenu.add(one);
    viewMenu.add(two);
    return viewMenu;
  }
  //--------------------------------------------------------
  /**
   * Вложенный класс завершения работы приложения
   */
  class ExitAction extends AbstractAction
  {
    private static final long serialVersionUID = 1L;
    ExitAction() {
      putValue(NAME, "Выход");
    }
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
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
    ind app = new ind();
    app.pack();
  }
}
