import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class NFail extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	Image img1, img2;
	Label l1, l2, l3;
	Button restart;
	
	NFail(String title) {
		super(title);
		
		setIconImage(new ImageIcon("Image/9.png").getImage());
		setBounds(screenSize.width/2-300, screenSize.height/2-200, 600, 400);
		setBackground(new Color(0,0,0));
		setLayout(null);
		setResizable(false);
		
		l1 = new Label("아쉽습니다!");
		l1.setBounds(150, 50, 300, 100);
		l1.setFont(new Font("Diolog", Font.ITALIC + Font.BOLD, 50));
		l1.setAlignment(Label.CENTER);
		l1.setBackground(new Color(255, 248, 61));
		add(l1);
		
		l2 = new Label("당신은 기회를 모두 소진했습니다!");
		l2.setBounds(100, 160, 400, 50);
		l2.setFont(new Font("Diolog", Font.ITALIC + Font.PLAIN, 20));
		l2.setAlignment(Label.CENTER);
		l2.setBackground(new Color(255, 248, 61));
		add(l2);
		
		l3 = new Label("(종료를 원하시면 X를 눌러주세요.)");
		l3.setBounds(170, 300, 260, 35);
		l3.setFont(new Font("Diolog", Font.PLAIN, 15));
		l3.setAlignment(Label.CENTER);
		l3.setBackground(new Color(255, 248, 61));
		add(l3);
		
		restart = new Button("다시 하기");
		restart.setBounds(220, 230, 150, 40);
		restart.setFont(new Font("SansSerif", Font.BOLD, 15));
		restart.addActionListener(new Re());
		add(restart);
		
		img1 = tk.getImage("Image/실패2.png");
		img2 = tk.getImage("Image/실패.png");
		
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