import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch extends Frame {
	Toolkit tk = Toolkit.getDefaultToolkit();
	Dimension screenSize = tk.getScreenSize();
	static Button b[] = new Button[4];
	static Button r;
	static Panel p1;
	TextArea ta1;
	Label l1;
	Timer timer;
	int time[] = new int[3];
	char v, d;
	int val;

	StopWatch(String title) {
		super(title);

		setLocation(screenSize.width / 2 - 200, screenSize.height / 2 - 250);
		setSize(400, 500);
		setLayout(null);
		setBackground(new Color(204, 248, 255));
		setIconImage(new ImageIcon("Image/초시계.png").getImage());

		for (int i = 0; i < 3; ++i) {
			time[i] = 0;
		}

		v = ':';
		d = '.';
		val = 1;

		l1 = new Label(Integer.toString(time[0]) + v + Integer.toString(time[1]) + d + Integer.toString(time[2]));
		l1.setAlignment(Label.CENTER);
		l1.setBounds(100, 50, 200, 50);
		l1.setFont(new Font("Dialog", Font.BOLD, 50));
		add(l1);
		
		p1 = new Panel();
		p1.setLayout(null);
		p1.setBounds(0, 130, 400, 280);
		p1.addKeyListener(new kset());
		p1.setFocusable(true);
		p1.setBackground(new Color(0, 0, 0));
		add(p1);
		
		r = new Button("유의사항");
		r.setBounds(20,60,80,30);
		r.setBackground(new Color(186, 209, 230));
		r.setFont(new Font("Dialog", Font.BOLD, 10));
		r.addActionListener(new Notice());
		add(r);
		
		ta1 = new TextArea("	      횟수 / 기록시간", 10, 2, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta1.setBounds(10, 5, 380, 270);
		ta1.setFont(new Font("Monospaceds", Font.PLAIN, 23));

		ta1.setEditable(false);
		p1.add(ta1);

		b[0] = new Button("시작(a)");
		b[0].addActionListener(new start());

		b[1] = new Button("중지(s)");
		b[1].addActionListener(new stop());
		b[1].setEnabled(false);

		b[2] = new Button("기록(d)");
		b[2].addActionListener(new write());
		b[2].setEnabled(false);

		b[3] = new Button("초기화(f)");
		b[3].addActionListener(new reset());

		for (int i = 0; i < b.length; ++i) {
			b[i].setBounds(25 + 90 * i, 425, 80, 50);
			b[i].setBackground(new Color(186, 209, 230));
			b[i].setFont(new Font("Dialog", Font.BOLD, 15));
			add(b[i]);
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		setVisible(true);
	}

	///// 이벤트 처리 //////////////
	class Notice implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Snotice("유의사항");
			r.setEnabled(false);
		}
	}
	
	class start implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			b[0].setEnabled(false);
			b[3].setEnabled(false);
			b[1].setEnabled(true);
			b[2].setEnabled(true);

			timer = new Timer(true);

			TimerTask task = new TimerTask() {
				public void run() {
					l1.setText(
							Integer.toString(time[0]) + v + Integer.toString(time[1]) + d + Integer.toString(time[2]));

					time[2]++;

					if (time[2] == 100) {
						time[1]++;
						time[2] = 0;
					}

					if (time[1] == 60) {
						time[0]++;
						time[1] = 0;
					}

					if (time[0] == 60)
						new stop();
				}
			};

			timer.scheduleAtFixedRate(task, 0, 10); // 속도조절

		}
	}

	class stop implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			b[0].setEnabled(true);
			b[3].setEnabled(true);
			b[1].setEnabled(false);
			b[2].setEnabled(false);

			if (time != null) {
				timer.cancel();
			}

		}
	}

	class write implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (val >= 1 && val < 10)
				ta1.append("\n		 " + 0 + val + "      " + l1.getText());
			else
				ta1.append("\n		 " + val + "      " + l1.getText());

			val++;
		}
	}

	class reset implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 3; ++i) {
				time[i] = 0;
			}

			l1.setText(Integer.toString(time[0]) + v + Integer.toString(time[1]) + d + Integer.toString(time[2]));

			ta1.setText("	      횟수 / 기록시간");

			val = 1;
		}
	}

	class kset extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			char o = e.getKeyChar();
			switch (o) {
			case 'a':
				b[0].setEnabled(false);
				b[3].setEnabled(false);
				b[1].setEnabled(true);
				b[2].setEnabled(true);

				timer = new Timer(true);

				TimerTask task = new TimerTask() {
					public void run() {
						l1.setText(Integer.toString(time[0]) + v + Integer.toString(time[1]) + d
								+ Integer.toString(time[2]));

						time[2]++;

						if (time[2] == 100) {
							time[1]++;
							time[2] = 0;
						}

						if (time[1] == 60) {
							time[0]++;
							time[1] = 0;
						}

						if (time[0] == 60) {
							b[0].setEnabled(true);
							b[3].setEnabled(true);
							b[1].setEnabled(false);
							b[2].setEnabled(false);

							if (time != null) {
								timer.cancel();
							}
						}
					}
				};

				timer.scheduleAtFixedRate(task, 0, 10); // 속도조절
				
				break;

			case 's':
				b[0].setEnabled(true);
				b[3].setEnabled(true);
				b[1].setEnabled(false);
				b[2].setEnabled(false);

				if (time != null) {
					timer.cancel();
				}
				break;

			case 'd':
				if (val >= 1 && val < 10)
					ta1.append("\n		 " + 0 + val + "      " + l1.getText());
				else
					ta1.append("\n		 " + val + "      " + l1.getText());

				val++;
				break;

			case 'f':
				for (int i = 0; i < 3; ++i) {
					time[i] = 0;
				}

				l1.setText(Integer.toString(time[0]) + v + Integer.toString(time[1]) + d + Integer.toString(time[2]));

				ta1.setText("	      횟수 / 기록시간");

				val = 1;
				break;
			}

		}
	}
}
