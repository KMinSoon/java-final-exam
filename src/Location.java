import java.awt.*; // AWT 컨포넌트 사용하기 위해
import java.awt.event.*; // 이벤트 처리하기 위해
import javax.swing.ImageIcon;

public class Location extends Frame {
	Label l1;

	Location(String title) {
		
		super(title);
		setLayout(null);
		setBounds(200, 200, 400, 300);
		setBackground(Color.yellow);
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		
		l1 = new Label("마우스 포인터 위치: ");
		l1.setBounds(7, 30, 200, 20);
		l1.setBackground(Color.yellow);
		
		addMouseMotionListener(new MouseMotionListener() { // 2. 이벤트 리스너(감지기)
			public void mouseDragged(MouseEvent e) {}
			public void mouseMoved(MouseEvent e) {
				l1.setText("마우스 포인터 위치: (" + e.getX() + ", " + e.getY() + ")");	
			}
		});
		
		addWindowListener(new WindowAdapter() { // 프레임 닫기 이벤트 처리
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		add(l1);
		setVisible(true);
	}
}




