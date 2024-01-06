import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuStart extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); // ȭ�� �ʺ�, ���� ������ ������
	Image img;
	
	MenuStart(String title) {
		super(title);
		
		setLocation(screenSize.width/2-350, screenSize.height/2-350);
		setSize(700, 700);
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		img = tk.getImage("Image/����.jpg");
		
		MenuBar mb = new MenuBar();
		
		Menu mFile = new Menu("File");
		MenuItem miJoin = new MenuItem("Join", new MenuShortcut('J', true)); // shift���� ������
		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		
		Menu mEvent1 = new Menu("Event");
		MenuItem miCoffee = new MenuItem("Ŀ�� ����");
		miCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Coffee("Ŀ�� ����");
			}	
		});
		
		MenuItem miBlood = new MenuItem("������ ����");
		miBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BloodTest("������ ����");
			}	
		});
		
		MenuItem miLocation = new MenuItem("���콺 �̵�");
		miLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Location("���콺 �̵�");
			}	
		});
		
		MenuItem miChange = new MenuItem("������ ����");
		miChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Change("������ ����");
			}	
		});
		
		Menu mEvent2 = new Menu("AddEvent");
		MenuItem miEvent1 = new MenuItem("�̺�Ʈ1", new MenuShortcut('G'));
		miEvent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NumBase("���� �߱�");
			}	
		});
		
		MenuItem miEvent2 = new MenuItem("�̺�Ʈ2", new MenuShortcut('G', true));
		miEvent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StopWatch("�����ġ");
			}	
		});
		
		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("���α׷� ����", new MenuShortcut('H'));
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("���α׷� ����");
			}	
		});
		
		MenuItem miDev = new MenuItem("������ �Ұ�", new MenuShortcut('D'));
		miDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dev("������ �Ұ�");
			}	
		});
		
		mb.add(mFile); mb.add(mEvent1); mb.add(mEvent2); mb.add(mHelp);
		mFile.add(miJoin); mFile.addSeparator(); mFile.add(miExit);
		mHelp.add(miHelp); mHelp.addSeparator(); mHelp.add(miDev);
		mEvent1.add(miCoffee); mEvent1.addSeparator(); mEvent1.add(miBlood); 
		mEvent1.addSeparator(); mEvent1.add(miLocation); mEvent1.addSeparator(); mEvent1.add(miChange);
		mEvent2.add(miEvent1); mEvent2.addSeparator(); mEvent2.add(miEvent2);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setMenuBar(mb);
		setVisible(true);
	}
	
	public void paint(Graphics g) { // �������̵�
		g.drawImage(img, -5, 25, this);
	}
	
	public static void main(String[] args) {
		new MenuStart("JavaProject ��μ�");
	}
}