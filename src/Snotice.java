import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snotice extends Frame {
	JLabel l1;
	
	Snotice(String title) {
		super(title);
		
		setBounds(250,300, 400, 250);
		setLayout(null);
		setBackground(new Color(204, 248, 255));
		setIconImage(new ImageIcon("Image/초시계.png").getImage());
		
		l1 = new JLabel();
		l1.setOpaque(true);
		l1.setBackground(new Color(255,255,255));
		l1.setBounds(12,35,376,200);
		l1.setText("<html><body>1. 이것은 59:59:99까지 작동됩니다.<br>"
				+ "2. 아래는 키보드 입력 시에만 해당됩니다.<br>"
				+ "- 시작버튼(a)를 여러번 누르지 말고 한 번씩만 눌러주세요.<br>"
				+ "- 시작버튼을 많이 누르면 중지버튼이 먹히지 않습니다.<br>"
				+ "- 만약 이렇게 됐다면, 이벤트를 종료 후 재실행 해주세요.<br>" 
				+ "- 이 창을 띠워둔다면 버튼 입력이 먹지 않습니다.<br>"
				+ "- 기록(d)버튼은 언제든지 입력해서 사용할 수 있습니다.<br>(유의사항 창 띠워져 있을 때는 X)<br>"
				+ "3. 마우스로 버튼을 클릭하시면 키보드 입력이 되지 않습니다.<br>(유의사항 제외)<br>" 
				+ "</body></html>");
		
		add(l1);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				StopWatch.r.setEnabled(true);
				StopWatch.p1.requestFocus();
			}
		});

		setVisible(true);
	}
}