import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumBase extends Frame {
	// 변수 선언
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	static Button number[] = new Button[10];
	static String answer[] = new String[3];
	static JLabel sheet[] = new JLabel[9];
	Label Input;
	static Button help, exam;
	Button ok, erase;
	Panel p1;
	char check[] = new char[3];
	static int x, count;
	static int r[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	NumBase(String title) {
		super(title);

		setIconImage(new ImageIcon("Image/9.png").getImage());
		
		NumBase.Blend();

		setBounds(screenSize.width/2-300, screenSize.height/2-400, 600, 800);
		setBackground(new Color(210,218,213));
		setLayout(null);
		setResizable(false);

		Input = new Label();
		Input.setBounds(200, 50, 200, 100);
		Input.setFont(new Font("SnaSerif", Font.BOLD, 40));
		Input.setBackground(new Color(163, 250, 255));
		Input.setAlignment(Label.CENTER);
		add(Input);

		help = new Button("규칙 설명");
		help.setBounds(65, 75, 70, 30);
		help.setFont(new Font("SansSerif", Font.BOLD, 13));
		help.addActionListener(new ButtonEvent2());
		add(help);
		
		exam = new Button("예시 사진");
		exam.setBounds(465, 75, 70, 30);
		exam.setFont(new Font("SansSerif", Font.BOLD, 13));
		exam.addActionListener(new ButtonEvent5());
		add(exam);
		
		p1 = new Panel();
		p1.setBounds(10, 160, 580, 400);
		p1.setBackground(new Color(0,0,0));
		p1.setLayout(new GridLayout(3, 3, 1, 1));
		add(p1);
		
		for(int i=0; i<sheet.length; ++i)
		{
			sheet[i] = new JLabel("Test " + Integer.toString(i+1));
			sheet[i].setOpaque(true);
			sheet[i].setBackground(new Color(255, 255, 255));
			sheet[i].setHorizontalAlignment(JLabel.CENTER);
			sheet[i].setFont(new Font("Monospaceds", Font.PLAIN, 25));
			p1.add(sheet[i]);
		}
		
		ok = new Button("확인");
		ok.setBounds(430, 565, 50, 30);
		ok.setFont(new Font("SansSerif", Font.BOLD, 15));
		ok.addActionListener(new ButtonEvent4());
		add(ok);
		
		erase = new Button("전체 지우기");
		erase.setBounds(490, 565, 100, 30);
		erase.setFont(new Font("SansSerif", Font.BOLD, 15));
		erase.addActionListener(new ButtonEvent3());
		add(erase);
		
		for(int i = 0; i < 5; ++i) {
			number[i] = new Button(Integer.toString(i)); // 정수 -> 문자열
			number[i].setBounds(120 * i, 600, 120, 100);
			number[i].setFont(new Font("Monospaceds", Font.BOLD, 30));
			number[i].setBackground(new Color(0, 123, 255));
			number[i].setForeground(new Color(255, 255, 255));
			number[i].addActionListener(new ButtonEvent1());
			add(number[i]);
		}
		for(int i = 0; i < 5; ++i) {
			number[i + 5] = new Button(Integer.toString(i + 5));
			number[i + 5].setBounds(120 * i, 700, 120, 100);
			number[i + 5].setFont(new Font("Monospaceds", Font.BOLD, 30));
			number[i + 5].setBackground(new Color(0, 123, 255));
			number[i + 5].setForeground(new Color(255, 255, 255));
			number[i + 5].addActionListener(new ButtonEvent1());
			add(number[i + 5]);
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
	}
	static void Blend() {
		for (int i = 0; i < r.length; ++i) {
			int j = (int) (Math.random() * 10);

			int temp = r[i];
			r[i] = r[j];
			r[j] = temp;
		}
	}

	// 이벤트 처리
	class ButtonEvent1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (answer[0] == null) {
				answer[0] = e.getActionCommand();
				number[Integer.parseInt(e.getActionCommand())].setEnabled(false);
				Input.setText(answer[0] + "   ");
			} else if (answer[1] == null) {
				answer[1] = e.getActionCommand();
				number[Integer.parseInt(e.getActionCommand())].setEnabled(false);
				Input.setText(Input.getText() + answer[1] + "   ");
			} else if(answer[2] == null){
				answer[2] = e.getActionCommand();
				number[Integer.parseInt(e.getActionCommand())].setEnabled(false);
				Input.setText(Input.getText() + answer[2]);
			}
		}
	}
	
	class ButtonEvent2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new NRule("게임 설명");
			help.setEnabled(false);
		}
	}
	
	class ButtonEvent3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<3; ++i)
				answer[i] = null;
			
			for(int i=0; i<10; ++i)
				number[i].setEnabled(true);
			Input.setText("");
		}
	}
	
	class ButtonEvent4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			char temp;
			
			if(Integer.parseInt(answer[0]) == r[0])
				check[0] = 'S';
			else if (Integer.parseInt(answer[0]) == r[1] || Integer.parseInt(answer[0]) == r[2])
				check[0] = 'B';
			else
				check[0] = 'O';
			
			if(Integer.parseInt(answer[1]) == r[1])
				check[1] = 'S';
			else if (Integer.parseInt(answer[1]) == r[0] || Integer.parseInt(answer[1]) == r[2])
				check[1] = 'B';
			else
				check[1] = 'O';
			
			if(Integer.parseInt(answer[2]) == r[2])
				check[2] = 'S';
			else if (Integer.parseInt(answer[2]) == r[0] || Integer.parseInt(answer[2]) == r[1])
				check[2] = 'B';
			else
				check[2] = 'O';
			
			if(check[0] == 'S' && check[1] == 'B' && check[2] == 'S') {
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'S' && check[1] == 'O' && check[2] == 'S') {
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'S' && check[1] == 'O' && check[2] == 'B') {
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'B' && check[1] == 'S' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'B' && check[1] == 'S' && check[2] == 'B') {
				temp = check[0];
				check[0] = check[1];
				check[1] = temp;
			} else if(check[0] == 'B' && check[1] == 'S' && check[2] == 'O') {
				temp = check[0];
				check[0] = check[1];
				check[1] = temp;
			} else if(check[0] == 'B' && check[1] == 'B' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'B' && check[1] == 'O' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
				
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'B' && check[1] == 'O' && check[2] == 'B') {
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'S' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'S' && check[2] == 'B') {
				temp = check[0];
				check[0] = check[1];
				check[1] = temp;
				
				temp = check[1];
				check[1] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'S' && check[2] == 'O') {
				temp = check[0];
				check[0] = check[1];
				check[1] = temp;
			} else if(check[0] == 'O' && check[1] == 'B' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'B' && check[2] == 'B') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'B' && check[2] == 'O') {
				temp = check[0];
				check[0] = check[1];
				check[1] = temp;
			} else if(check[0] == 'O' && check[1] == 'O' && check[2] == 'S') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			} else if(check[0] == 'O' && check[1] == 'O' && check[2] == 'B') {
				temp = check[0];
				check[0] = check[2];
				check[2] = temp;
			}
			
			sheet[x++].setText("<html>" + Input.getText() + "<br>" + check[0] + check[1] + check[2] + "</html>");
			
			if(check[0] == 'S' && check[1] == 'S' && check[2] == 'S') {
				count++;
				
				new NClear("게임 클리어!");
				dispose();
			}
			else {
				for(int i=0; i<10; ++i)
					number[i].setEnabled(true);
				
				for(int i=0; i<3; ++i)
					answer[i] = null;
				count++;
				
				if(count==9)
				{
					new NFail("Game Over");
					dispose();
				}
			}
			Input.setText("");
		}
	}
	
	class ButtonEvent5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new NExample("예시 사진");
			exam.setEnabled(false);
		}
	}
}