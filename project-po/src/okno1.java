import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import javax.swing.text.JTextComponent;
public class okno1 extends JFrame  {
  public JTextField tfpoi;
  public JButton    btnOk, btnCancel;
  private  JFileChooser fileChooser = null;
  public okno1()
  {
    super("поиск");
    // При выходе из диалогового окна работа заканчивается
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        dispose();
        System.exit(0);
      }
    });


    // добавляем расположение в центр окна
    getContentPane().add(createGUI());
    // задаем предпочтительный размер
    pack();
    // выводим окно на экран
    setVisible(true);
  }
  // этот метод будет возвращать панель с созданным расположением
  private JPanel createGUI()
  {
    // Создание панели для размещение компонентов
    JPanel panel = BoxLayoutUtils.createVerticalPanel();
    // Определение отступов от границ ранели. Для этого используем пустую рамку
    panel.setBorder (BorderFactory.createEmptyBorder(12,12,12,12));
    // Создание панели для размещения метки и текстового поля логина
    JPanel name = BoxLayoutUtils.createHorizontalPanel();
    JLabel nameLabel = new JLabel("поиск:");
    name.add(nameLabel);
    name.add(Box.createHorizontalStrut(12));
    tfpoi = new JTextField(15);
    name.add(tfpoi);
    // Создание панели для размещения метки и текстового поля пароля

    // Создание панели для размещения кнопок управления
    JPanel flow = new JPanel( new FlowLayout( FlowLayout.RIGHT, 0, 0) );
    JPanel grid = new JPanel( new GridLayout( 1,2,5,0) );
    btnOk = new JButton("OK");
    btnCancel = new JButton("Отмена");

    grid.add(btnOk    );
    grid.add(btnCancel);
    flow.add(grid);
    // Выравнивание вложенных панелей по горизонтали
    BoxLayoutUtils.setGroupAlignmentX(new JComponent[] { name, panel, flow },
      Component.LEFT_ALIGNMENT);
    // Выравнивание вложенных панелей по вертикали
    BoxLayoutUtils.setGroupAlignmentY(new JComponent[] { tfpoi, nameLabel},
      Component.CENTER_ALIGNMENT);
    // Определение размеров надписей к текстовым полям
    GUITools.makeSameSize(new JComponent[] { nameLabel,  } );
    // Определение стандартного вида для кнопок
    GUITools.createRecommendedMargin(new JButton[] { btnOk, btnCancel } );
    // Устранение "бесконечной" высоты текстовых полей
    GUITools.fixTextFieldSize(tfpoi   );

    // Сборка интерфейса
    panel.add(name);
    panel.add(Box.createVerticalStrut(12));
    panel.add(flow);
    addFileChooserListeners();
    fileChooser = new JFileChooser();
    getContentPane().add(panel);
    // готово
    return panel;
  }
  private void addFileChooserListeners() {
    btnOk.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        ind form = new ind();
        dispose();
        form.setVisible(true);
      }
    });
  }
  // тестовый метод для проверки диалогового окна
  public static void main(String[] args) {
    okno1 app = new okno1();
    app.pack();
  }
}
