package myPage;

// 메인 레이아웃
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class MainPane extends JFrame implements ActionListener{
	//CardLayout card = new CardLayout();	
	JTabbedPane tp = new JTabbedPane();
	JPanel northPane = new JPanel(new BorderLayout());
		JPanel eastPane = new JPanel(new BorderLayout());
			JTextField searchTf = new JTextField(20);
			JButton searchBtn = new JButton("검색");

	JMenu myPageMenu = new JMenu("My Page");
	
	JPanel moviePane = new JPanel();
	JPanel ticketPane = new JPanel();
	JPanel timePane = new JPanel();
	JPanel Pane = new JPanel();
	JPanel schedulePane = new JPanel();
	JPanel myPagePane = new JPanel();
	JPanel loginPane = new JPanel();
	JPanel signUpPane = new JPanel();
	JPanel servicePane = new JPanel();
	JPanel logoutPane = new JPanel();
	
	JPanel infoPane = new JPanel();
	JLabel infoLbl = new JLabel("호스팅사업자 : 4CINEMA Group  책임자 : G4 대표이메일 : dropthebit@bit.net  고객센터 : 1544-1100");
	
	
	JoinMem rm = new JoinMem();
	LoginForm lf = new LoginForm();
	MyPageForm mpf = new MyPageForm();
	MemEditForm mef = new MemEditForm ();
	
	ImageIcon img = new ImageIcon("myPage/img/map.png");
	
	
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
		//tp.addTab("   로그인   ", lf.pane);
		tp.addTab("  회원가입  ", rm );
		tp.addTab("  고객센터  /  오시는 길   ", servicePane);
		tp.addTab("   로그아웃   ",logoutPane);
		
		//하단 고객센터
		infoLbl.setFont(new Font("맑은고딕", 0, 9));
		infoPane.add(infoLbl);
		add("South", infoPane); 

		setLogout();
		setSize(1000,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(img.getImage());
		
	}
	public void setLogout() {
		if(tp.getSelectedIndex() == 7){
			//((tp.getSelectedComponent().equals("로그아웃")
		int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
		 if(result == JOptionPane.YES_OPTION) System.exit(0);
		}
	}	
	public static void main(String[] args) {
		new MainPane();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setLogout(); 
	}

}
