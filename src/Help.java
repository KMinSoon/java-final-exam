import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Help extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Label l1, l2, l3, l4, l5;
	Image img1, img2, img3, img4;
	
	Help(String title) {
		super(title);
		
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		setLocation(screenSize.width/2-300, screenSize.height/2-225);
		setBackground(new Color(197,222,218));
		setSize(600, 450);
		setLayout(null);
		
		l1 = new Label("�̺�Ʈ1: ���� �߱�");
		l1.setAlignment(Label.CENTER);
		l1.setBounds(100, 50, 400, 50);
		l1.setBackground(new Color(146,190,169));
		l1.setFont(new Font("SansSerif", Font.BOLD,30));
		add(l1);
		
		l2 = new Label("��̰� �Ӹ��� �����!");
		l2.setAlignment(Label.CENTER);
		l2.setBounds(100, 100, 400, 50);
		l2.setBackground(new Color(146,190,169));
		l2.setFont(new Font("SansSerif", Font.PLAIN,20));
		add(l2);
		
		l3 = new Label("�̺�Ʈ2: �����ġ");
		l3.setAlignment(Label.CENTER);
		l3.setBounds(100, 200, 400, 50);
		l3.setBackground(new Color(146,190,169));
		l3.setFont(new Font("SansSerif", Font.BOLD,30));
		add(l3);
		
		l4 = new Label("�ð��� ����غ���! / ��:��.�и�������");
		l4.setAlignment(Label.CENTER);
		l4.setBounds(100, 250, 400, 50);
		l4.setBackground(new Color(146,190,169));
		l4.setFont(new Font("SansSerif", Font.PLAIN,20));
		add(l4);
		
		l5 = new Label("���� ���� �̺�Ʈ�� ������ �Ŀ� �ٸ� �̺�Ʈ�� ������ �ֽʽÿ�.");
		l5.setAlignment(Label.CENTER);
		l5.setBounds(50, 350, 500, 50);
		l5.setBackground(new Color(146,190,169));
		l5.setFont(new Font("SansSerif", Font.ITALIC + Font.BOLD,16));
		add(l5);
		
		img1 = tk.getImage("Image/�߱�.jpg");
		img2 = tk.getImage("Image/����.png");
		img3 = tk.getImage("Image/�ð�.png");
		img4 = tk.getImage("Image/�ʽð�.png");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	public void paint(Graphics g) { // �������̵�
		g.drawImage(img1, 500, 50, this);
		g.drawImage(img2, 0, 50, this);
		g.drawImage(img3, 0, 200, this);
		g.drawImage(img4, 500, 200, this);
	}
}