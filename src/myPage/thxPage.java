package myPage;
// 탈퇴 후 감사합니다 페이지
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class thxPage extends JPanel{
JPanel pane = new JPanel();
JLabel withdrawLbl = new JLabel ("회원탈퇴 완료");
JLabel thxLbl = new JLabel("그동안 이용해주셔서 감사합니다.");

Font font = new Font("맑은 고딕",Font.BOLD,25);
Font font1 = new Font("맑은 고딕",Font.BOLD,15);
	public thxPage() {
		setFrame();
		setLayout();
		setFont();
	}
	public void setFrame() {
		//setSize(1000,710);
		setVisible(true);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setLayout() {

		setLayout(new BorderLayout());
		pane.setLayout(null);
		pane.setBounds(200,150,600,400);
		withdrawLbl.setBounds(350,200,200,100);
		thxLbl.setBounds(350,250,400,100);
		pane.add(withdrawLbl);
		pane.add(thxLbl);
		
		pane.setBackground(Color.BLACK);
		withdrawLbl.setForeground(Color.WHITE);
		thxLbl.setForeground(Color.WHITE);
		
		LineBorder lineBorder = new LineBorder(Color.WHITE); 
		pane.setBorder(lineBorder);
		
		add(pane);
	}
	public void setFont() {
		withdrawLbl.setFont(font);
		thxLbl.setFont(font1);
	}
	public static void main(String[] args) {
		new thxPage();

	}

}
