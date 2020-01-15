package view;
import action.Actions;
import card.Poker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MyJframe extends JFrame {
	Actions actions = new Actions(); private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon icon;
	JLabel Lnum1 = new JLabel();
	JLabel Lnum2 = new JLabel();
	JLabel Linfo = new JLabel();
	JPanel CardColorUp = new JPanel();
	JPanel CardColorDown = new JPanel();
	JLabel CardUpImg = new JLabel();
	JLabel CardDownImg = new JLabel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyJframe frame = new MyJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}
	
	public MyJframe() {
		setResizable(false);
		setDefaultCloseOperation(3);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String gameName = "流氓十三张";
		JLabel label = new JLabel(gameName);
		label.setBackground(Color.PINK);
		label.setFont(new Font("思源黑体", 1, 23));
		label.setHorizontalAlignment(0);
		contentPane.add(label, "North");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(72, 209, 204));
		contentPane.add(panel, "Center");
		panel.setLayout((LayoutManager)null);
		
		String buttonName = "下一个玩家";
		JButton buttonNext = new JButton(buttonName);
		buttonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Poker poker = actions.nextCard();
				icon = new ImageIcon(getClass().getResource(ImgPath(poker)));
				CardUpImg.setIcon(icon);
				CardDownImg.setIcon(icon);
				Lnum1.setText(poker.getNum());
				Lnum2.setText(poker.getNum());
				Linfo.setText(poker.getInfo());
			}
		});
		buttonNext.setFont(new Font("SimSun", 1, 30));
		buttonNext.setBounds(106, 530, 212, 78);
		panel.add(buttonNext);
		
		Poker poker = actions.getCardCN();
		String num = poker.getNum();
		icon = new ImageIcon(getClass().getResource(ImgPath(poker)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 10, 406, 511);
		panel.add(panel_1);
		panel_1.setLayout((LayoutManager)null);
		
		
		CardColorUp.setBackground(new Color(255, 255, 255));
		CardColorUp.setBounds(10, 10, 86, 108);
		panel_1.add(CardColorUp);
		
		
		CardUpImg.setIcon(icon);
		CardDownImg.setIcon(icon);
		
		CardColorUp.add(CardUpImg);
		
		JPanel CardColorDown = new JPanel();
		CardColorDown.setBackground(new Color(255, 255, 255));
		CardColorDown.setBounds(310, 393, 86, 108);
		panel_1.add(CardColorDown);
		CardColorDown.add(CardDownImg);
		
		Lnum1.setFont(new Font("思源黑体", 1, 50));
		Lnum1.setHorizontalAlignment(0);
		Lnum1.setBounds(10, 121, 86, 62);
		Lnum1.setText(num);
		panel_1.add(Lnum1);
		
		
		Lnum2.setHorizontalAlignment(0);
		Lnum2.setFont(new Font("思源黑体", 1, 50));
		Lnum2.setBounds(310, 321, 86, 62);
		Lnum2.setText(num);
		panel_1.add(Lnum2);
		Linfo.setFont(new Font("SimSun", 0, 20));
		
		
		Linfo.setHorizontalAlignment(SwingConstants.CENTER);
		Linfo.setBounds(90, 128, 210, 255);
		Linfo.setText(poker.getInfo());
		panel_1.add(Linfo);
	}
	private String ImgPath(Poker poker) {
		String color = poker.getColor();
		StringBuffer sb = new StringBuffer("img/");
		if (color.equals("黑桃")) {
			sb.append("blackheart.png");
		} else if (color.equals("方块")) {
			sb.append("redFang.png");
		} else if (color.equals("红桃")) {
			sb.append("redheart.png");
		} else {
			sb.append("blackMei.png");
		} 
		return sb.toString();
	}
}
