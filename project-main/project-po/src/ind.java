import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
public class ind extends JFrame {
  private static final long serialVersionUID = 1L;
  private  JFileChooser fileChooser = null;
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
  private JMenu createFileMenu()
  {
    // Создание выпадающего меню
    JMenu file = new JMenu("Файл");
    // Пункт меню "Открыть" с изображением
    JMenuItem open = new JMenuItem("Открыть",
      new ImageIcon("images/open.png"));
    // Пункт меню из команды с выходом из программы
    JMenuItem exit = new JMenuItem(new ExitAction());
    // Добавление к пункту меню изображения
    exit.setIcon(new ImageIcon("images/exit.png"));
    // Добавим в меню пункта open
    file.add(open);
    // Добавление разделителя
    file.addSeparator();
    file.add(exit);

    open.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        fileChooser.setDialogTitle("Выбор директории");
        // Определение режима - только каталог
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(ind.this);
        // Если директория выбрана, покажем ее в сообщении
        if (result == JFileChooser.APPROVE_OPTION )
          JOptionPane.showMessageDialog(ind.this,
            fileChooser.getSelectedFile());
      }
    });

    return file;
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
  public static void main(String[] args) {
    ind app = new ind();
    app.pack();
  }
}
