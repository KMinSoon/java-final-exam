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
		setIconImage(new ImageIcon("Image/�ʽð�.png").getImage());
		
		l1 = new JLabel();
		l1.setOpaque(true);
		l1.setBackground(new Color(255,255,255));
		l1.setBounds(12,35,376,200);
		l1.setText("<html><body>1. �̰��� 59:59:99���� �۵��˴ϴ�.<br>"
				+ "2. �Ʒ��� Ű���� �Է� �ÿ��� �ش�˴ϴ�.<br>"
				+ "- ���۹�ư(a)�� ������ ������ ���� �� ������ �����ּ���.<br>"
				+ "- ���۹�ư�� ���� ������ ������ư�� ������ �ʽ��ϴ�.<br>"
				+ "- ���� �̷��� �ƴٸ�, �̺�Ʈ�� ���� �� ����� ���ּ���.<br>" 
				+ "- �� â�� ����дٸ� ��ư �Է��� ���� �ʽ��ϴ�.<br>"
				+ "- ���(d)��ư�� �������� �Է��ؼ� ����� �� �ֽ��ϴ�.<br>(���ǻ��� â ����� ���� ���� X)<br>"
				+ "3. ���콺�� ��ư�� Ŭ���Ͻø� Ű���� �Է��� ���� �ʽ��ϴ�.<br>(���ǻ��� ����)<br>" 
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