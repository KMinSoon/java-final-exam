import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class NExample extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Image img;
	
	NExample(String title) {
		super(title);
		
		setIconImage(new ImageIcon("Image/9.png").getImage());
		setBounds(screenSize.width/2+300, screenSize.height/2-400, 240, 240);
		setBackground(new Color(231,254,255));
		setLayout(null);
		setResizable(false);
		
		img = tk.getImage("Image/예시.png");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				NumBase.exam.setEnabled(true);
			}
		});

		setVisible(true);
	}
	
	public void paint(Graphics g) { // 오버라이딩
		g.drawImage(img, 20, 40, this);
	}
}