import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class NClear extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Label l1, l2, l3;
	Image img1, img2;
	Button restart;

	NClear(String title) {
		super(title);

		setIconImage(new ImageIcon("Image/9.png").getImage());
		setBounds(screenSize.width / 2 - 300, screenSize.height / 2 - 200, 600, 400);
		setBackground(new Color(127, 255, 240));
		setLayout(null);
		setResizable(false);

		l1 = new Label("축하합니다!");
		l1.setBounds(150, 50, 300, 100);
		l1.setFont(new Font("Diolog", Font.ITALIC + Font.BOLD, 50));
		l1.setAlignment(Label.CENTER);
		l1.setBackground(new Color(255, 183, 238));
		add(l1);

		l2 = new Label("당신은  " + NumBase.count + "번 만에 통과했습니다!");
		l2.setBounds(100, 160, 400, 50);
		l2.setFont(new Font("Diolog", Font.ITALIC + Font.PLAIN, 20));
		l2.setAlignment(Label.CENTER);
		l2.setBackground(new Color(255, 183, 238));
		add(l2);
		
		l3 = new Label("(종료를 원하시면 X를 눌러주세요.)");
		l3.setBounds(170, 300, 260, 35);
		l3.setFont(new Font("Diolog", Font.PLAIN, 15));
		l3.setAlignment(Label.CENTER);
		l3.setBackground(new Color(255, 183, 238));
		add(l3);

		img1 = tk.getImage("Image/폭죽.jpg");
		img2 = tk.getImage("Image/폭죽2.png");

		restart = new Button("다시 하기");
		restart.setBounds(220, 230, 150, 40);
		restart.setFont(new Font("SansSerif", Font.BOLD, 15));
		restart.addActionListener(new Re());
		add(restart);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}

	class Re implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int i;
			
			dispose();

			for(i = 0; i < 3; ++i)
				NumBase.answer[i] = null;
			
			NumBase.x = 0;
			NumBase.count = 0;
			
			new NumBase("숫자 야구");
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img1, 450, 25, this);
		g.drawImage(img2, 10, 25, this);
	}
}