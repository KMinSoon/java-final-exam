import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class BloodTest extends Frame {
	
	Label l1, l2;
	Panel p1;
	CheckboxGroup cbg;
	Checkbox cb1, cb2, cb3, cb4;
	Font f1 = new Font("Serif", Font.BOLD, 20);

	BloodTest(String title) {
		super(title);
		
		// ������ ��ġ ���� (�߾ӿ� ��ġ ��Ű��)
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		setIconImage(new ImageIcon("Image/icon.png").getImage());
		setBounds(screenSize.width/2-200, screenSize.height/2-150, 400, 300);	
				
		setLayout(null);
		
		l1 = new Label("������ ���α׷�", Label.CENTER);
		l1.setBounds(50, 50, 300, 30);
		l1.setFont(f1);
		l1.setForeground(Color.blue);
		
		l2 = new Label("�������� �����ϼ���", Label.CENTER);
		l2.setBounds(50, 100, 300, 30);
		l2.setFont(f1);
		l2.setBackground(Color.black);
		l2.setForeground(Color.YELLOW);
		
		p1 = new Panel(); // �����̳�, Panel�� �⺻���̾ƿ��� FlowLayout(��->����, ��->�Ʒ�, �������)
		p1.setBounds(50, 150, 300, 100);
		p1.setBackground(Color.orange);
		
		cbg = new CheckboxGroup();
		cb1 = new Checkbox("A��", cbg, true); // 1. �̺�Ʈ ���(�ҽ�)
		cb2 = new Checkbox("B��", cbg, false);
		cb3 = new Checkbox("AB��", cbg, false);
		cb4 = new Checkbox("0��", cbg, false);
		
		cb1.setFont(f1);
		cb2.setFont(f1);
		cb3.setFont(f1);
		cb4.setFont(f1);
		
		// cb1�� ������ �ޱ�! 2. �̺�Ʈ ������(������)
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("����� �������� " + cb1.getLabel() + "�̱���");
				// System.out.println(cb1.getLabel());
			}
		});
		
		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("����� �������� " + cb2.getLabel() + "�̱���");
				// System.out.println(cb1.getLabel());
			}
		});
		
		cb3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("����� �������� " + cb3.getLabel() + "�̱���");
				// System.out.println(cb1.getLabel());
			}
		});
		
		cb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				l2.setText("����� �������� " + cb4.getLabel() + "�̱���");
				// System.out.println(cb1.getLabel());
			}
		});
				
		// �гο� üũ�ڽ� �߰�
		p1.add(cb1); p1.add(cb2); p1.add(cb3); p1.add(cb4);

		// �����ӿ� ���̱�
		add(l1); add(l2); add(p1);
		

		// ������ �ݱ� �̺�Ʈ ó��
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); // �޸𸮿��� ����
			}
		});
		
		setVisible(true);
	}
	
}
