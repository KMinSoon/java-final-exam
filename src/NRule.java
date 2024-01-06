import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NRule extends Frame{
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	JLabel rule;
	
	NRule(String title) {
		
		super(title);
		
		setIconImage(new ImageIcon("Image/9.png").getImage());
		setBounds(screenSize.width/2-700, screenSize.height/2-400, 400, 250);
		setBackground(new Color(231,254,255));
		setLayout(null);
		setResizable(false);
		
		rule = new JLabel();
		rule.setOpaque(true);
		rule.setBackground(new Color(255,255,255));
		rule.setBounds(12,35,376,200);
		rule.setText("<html><body>1. 0~9������ ���ڿ��� 3���� ��� �Է��ϼ���.<br>"
				+ "2. �Է��� �� Ȯ�ι�ư�� �����ּ���.<br>"
				+ "3. ��ü ����⸦ ������ �Է��� ���� �� �������ϴ�.<br>"
				+ "3. ���ڴ� ������ ��ġ�� Ʋ���� ��(B).<br>"
				+ "4. ���ڿ� ��ġ�� ���� ������ ��Ʈ����ũ(S).<br>5. ���ڿ� ��ġ�� �� Ʋ���� �ƿ�(O).<br>" 
				+ "6. ������ ���̰� ��Ʈ����ũ�̸� �ƿ������� �˷����� �ʽ��ϴ�.<br>7. ��ȸ�� �� 9���Դϴ�.<br>" 
				+ "8. ������� �Ѱ�� ���콺 Ŭ���� �����մϴ�. (Ű���� ���ϰ�����)" + "</body></html>");
		add(rule);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				NumBase.help.setEnabled(true);
			}
		});
		
		setVisible(true);
	}
}