import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dev extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	JLabel l1;
	Panel p1;
	Image img;
	
	Dev(String title) {
		super(title);
		
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		setLocation(screenSize.width/2-200, screenSize.height/2-200);
		setBackground(new Color(231,237,218));
		setLayout(null);
		setSize(400, 400);
		
		p1 = new Panel();
		p1.setLayout(null);
		p1.setBounds(10,32,240,220);
		p1.setBackground(new Color(41,250,190));
		add(p1);
		
		l1 = new JLabel("<html><body>\"������ �����ϴ�<br><center>�����Դϴ�\"</center></body></html>");
		l1.setOpaque(true);
		l1.setBounds(10,10,220,200);
		l1.setFont(new Font("Monospaceds", Font.BOLD, 20));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setBackground(new Color(141,250,190));
		p1.add(l1);
		
		img = tk.getImage("Image/����.jpg");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	// paint() ȣ�� ���� 3����
	// 1. ȭ���� ó�� �������� ����
	// 2. ȭ���� �ٸ� ȭ�鿡 �������ٰ� �ٽ� �������� ����
	// 3. �ּ�ȭ���� �ٽ� ȭ�鿡 �������� ����
	public void paint(Graphics g) {
		g.drawImage(img, 240, 240, this);
	}
}