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
		rule.setText("<html><body>1. 0~9까지의 숫자에서 3개를 골라 입력하세요.<br>"
				+ "2. 입력한 후 확인버튼을 눌러주세요.<br>"
				+ "3. 전체 지우기를 누르면 입력한 수가 다 지워집니다.<br>"
				+ "3. 숫자는 맞지만 위치가 틀리면 볼(B).<br>"
				+ "4. 숫자와 위치가 전부 맞으면 스트라이크(S).<br>5. 숫자와 위치가 다 틀리면 아웃(O).<br>" 
				+ "6. 무엇이 볼이고 스트라이크이며 아웃인지는 알려주지 않습니다.<br>7. 기회는 총 9번입니다.<br>" 
				+ "8. 기술력의 한계로 마우스 클릭만 지원합니다. (키보드 못하겠음ㅠ)" + "</body></html>");
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