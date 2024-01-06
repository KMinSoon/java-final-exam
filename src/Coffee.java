import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Coffee extends Frame {
	
	Coffee(String title) {
		super(title);
		
		Font f1 = new Font("Serif", Font.BOLD, 20);
		
		// ������ ��ġ ���� (�߾ӿ� ��ġ ��Ű��)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize(); // ȭ���� �ʺ�, ���� ������ screenSize�� ����!
		setBounds(screenSize.width/2-200, screenSize.height/2-200, 400, 400);	
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		setBackground(new Color(210,250,234));
		setLayout(null);
		
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1,3));
		p1.setBounds(25, 80, 350, 160);
		
		Button b1 = new Button("�Ƹ޸�ī��");
		Button b2 = new Button("ī���");
		Button b3 = new Button("īǪġ��");

		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		
		Label l1 = new Label("Ŀ�Ǹ� �����ϼ���", Label.CENTER);
		l1.setBackground(Color.pink);
		l1.setBounds(25, 285, 350, 50);
		l1.setFont(f1);
		
		// ��ư 3�� �̺�Ʈ ó��
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText(b1.getLabel() + "�� �����ϼ̽��ϴ�.");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText(b2.getLabel() + "�� �����ϼ̽��ϴ�.");
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l1.setText(b3.getLabel() + "�� �����ϼ̽��ϴ�.");
			}
		});
		
		
		// Panel�� ��ư 3�� ���̱�
		p1.add(b1); p1.add(b2); p1.add(b3);
		
		// �����ӿ� ���̱�
		add(p1); add(l1);
	
		// ������ �ݱ� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); // �޸𸮿��� ����
			}
		});
		
		setVisible(true);
	}	
}
