import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuStart extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize(); // 화면 너비, 높이 정보를 대입함
	Image img;
	
	MenuStart(String title) {
		super(title);
		
		setLocation(screenSize.width/2-350, screenSize.height/2-350);
		setSize(700, 700);
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		img = tk.getImage("Image/오리.jpg");
		
		MenuBar mb = new MenuBar();
		
		Menu mFile = new Menu("File");
		MenuItem miJoin = new MenuItem("Join", new MenuShortcut('J', true)); // shift같이 누르기
		MenuItem miExit = new MenuItem("Exit", new MenuShortcut('E'));
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}	
		});
		
		Menu mEvent1 = new Menu("Event");
		MenuItem miCoffee = new MenuItem("커피 선택");
		miCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Coffee("커피 선택");
			}	
		});
		
		MenuItem miBlood = new MenuItem("혈액형 선택");
		miBlood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BloodTest("혈액형 선택");
			}	
		});
		
		MenuItem miLocation = new MenuItem("마우스 이동");
		miLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Location("마우스 이동");
			}	
		});
		
		MenuItem miChange = new MenuItem("바탕색 변경");
		miChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Change("바탕색 변경");
			}	
		});
		
		Menu mEvent2 = new Menu("AddEvent");
		MenuItem miEvent1 = new MenuItem("이벤트1", new MenuShortcut('G'));
		miEvent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NumBase("숫자 야구");
			}	
		});
		
		MenuItem miEvent2 = new MenuItem("이벤트2", new MenuShortcut('G', true));
		miEvent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StopWatch("스톱워치");
			}	
		});
		
		Menu mHelp = new Menu("Help");
		MenuItem miHelp = new MenuItem("프로그램 설명", new MenuShortcut('H'));
		miHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Help("프로그램 설명");
			}	
		});
		
		MenuItem miDev = new MenuItem("개발자 소개", new MenuShortcut('D'));
		miDev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dev("개발자 소개");
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
	
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, -5, 25, this);
	}
	
	public static void main(String[] args) {
		new MenuStart("JavaProject 김민순");
	}
}