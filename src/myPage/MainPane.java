package myPage;

// 메인 레이아웃
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainPane extends JFrame{
	//CardLayout card = new CardLayout();	
	JTabbedPane tp = new JTabbedPane();
	JPanel northPane = new JPanel(new BorderLayout());
		JPanel eastPane = new JPanel(new BorderLayout());
			JTextField searchTf = new JTextField(20);
			JButton searchBtn = new JButton("검색");
	
	JPanel moviePane = new JPanel();
	JPanel ticketPane = new JPanel();
	JPanel timePane = new JPanel();
	JPanel Pane = new JPanel();
	JPanel schedulePane = new JPanel();
	JPanel myPagePane = new JPanel();
	JPanel loginPane = new JPanel();
	JPanel signUpPane = new JPanel();
	JPanel servicePane = new JPanel();
	
	JPanel infoPane = new JPanel();
	JLabel infoLbl = new JLabel("호스팅사업자 : 4CINEMA Group  책임자 : G4 대표이메일 : dropthebit@bit.net  고객센터 : 1544-1100");
	
	
	JoinMem rm = new JoinMem();
	LoginForm lf = new LoginForm();
	MyPageForm mpf = new MyPageForm();
	MemEditForm mef = new MemEditForm ();
	

	
	public MainPane() {
		super("4Cinema");
		add(tp);
		add("North", northPane);
		
		northPane.add("East", eastPane);		
			eastPane.add(searchTf);
			eastPane.add("East",searchBtn);
				searchBtn.setFont(new Font("맑은 고딕",Font.BOLD,12));
				
	
		
		tp.setFont(new Font("맑은 고딕",Font.BOLD,14));
		tp.addTab("      영화       ", moviePane);
		tp.addTab("     예매     ", ticketPane);
		tp.addTab("    상영시간표    ", timePane);
		tp.addTab("    상영예정작    ", schedulePane);
		tp.addTab("   마이페이지   ", mpf);
		tp.addTab("   로그인   ", lf.pane);
		tp.addTab("  회원가입  ", rm );
		tp.addTab("  고객센터  /  오시는 길   ", servicePane);
		
		//하단 고객센터
		infoLbl.setFont(new Font("맑은고딕", 0, 9));
		infoPane.add(infoLbl);
		add("South", infoPane);

	
		setSize(1000,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainPane();
	}

}
