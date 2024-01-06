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
		
		l1 = new JLabel("<html><body>\"게임을 좋아하는<br><center>오구입니당\"</center></body></html>");
		l1.setOpaque(true);
		l1.setBounds(10,10,220,200);
		l1.setFont(new Font("Monospaceds", Font.BOLD, 20));
		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setBackground(new Color(141,250,190));
		p1.add(l1);
		
		img = tk.getImage("Image/오구.jpg");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	// paint() 호출 시점 3가지
	// 1. 화면이 처음 보여지는 순간
	// 2. 화면이 다른 화면에 가려졌다가 다시 보여지는 순간
	// 3. 최소화에서 다시 화면에 보여지는 순간
	public void paint(Graphics g) {
		g.drawImage(img, 240, 240, this);
	}
}