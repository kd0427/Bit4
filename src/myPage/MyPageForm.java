package myPage;
import java.awt.BorderLayout;
import java.awt.CardLayout;
//마이페이지
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

public class MyPageForm extends JPanel implements ActionListener {


	
static JPanel myPagePane = new JPanel();
JPanel memPane = new JPanel();
JPanel btnPane = new JPanel();

JLabel helloLbl = new JLabel("\t 회원님(아이디) \n 안녕하세요.\n");
JLabel numLbl = new JLabel("\t 회원번호");
JLabel levelLbl = new JLabel("\t Level");
JLabel pointLbl = new JLabel("\t 포인트");
JLabel accumulatedPoint = new JLabel("\t 누적포인트");

// 회원 VO에 따라 변경되서 입력될 값
JLabel memNumLbl;
JLabel memLevelLbl;
JLabel memPointLbl;
JLabel memAccumulatedPoint;


JButton memEditBtn = new JButton("개인정보 수정");

JButton reservBtn = new JButton("영화 예매");
JButton reservListBtn = new JButton("예매 내역");
JButton reviewBtn = new JButton("나의 평점 / 리뷰");
JButton infoBtn = new JButton("회원등급 & 포인트 정보");

Font font = new Font("맑은 고딕",Font.BOLD,20);
Font font1 = new Font("맑은 고딕",Font.BOLD,13);


//다른 클래스 호출

MemEditForm mef = new MemEditForm(); // 개인정보 수정
MyMovieRatingPage mmrp = new MyMovieRatingPage(); // 나의 평점리뷰 
ReservationList rl = new ReservationList();	//영화예매 목록

CardLayout card = new CardLayout();	
	public MyPageForm() {
		setMyPageFrame();
		setComponentSize();
		setMyPage();
		setFontColor();
		
		
		//이벤트 등록
		reservBtn.addActionListener(this);
		reservListBtn.addActionListener(this);
		reviewBtn.addActionListener(this);
		infoBtn.addActionListener(this);
		memEditBtn.addActionListener(this);
		
	}
	public void setMyPageFrame() {
		
		setVisible(true);
		setBounds(10,10,1000,700);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

	}
	public void setComponentSize() {
		memPane.setBounds(200,100,300,400);
//		memEditBtn.setBounds(50,410,100,30);
//		helloLbl.setBounds(50,50,200,200);
//		NumLbl.setBounds(50,100,100,30);
//		levelLbl.setBounds(50,150,100,30);
//		pointLbl.setBounds(50,200,100,30);
//		accumulatedPoint.setBounds(50,250,100,30);
	
		btnPane.setBounds(550,170,200,250);
//		memEditBtn.setBounds(600,120,200,30);
//		reservBtn .setBounds(600,160,200,30);
//		reservListBtn.setBounds(600,200,200,30);
//		reviewBtn .setBounds(600,240,200,30);
//		infoBtn.setBounds(600,280,200,30);
		
	}
	public void setMyPage() {
	setLayout(new BorderLayout());
	myPagePane.setLayout(null);

//		myPagePane.add(helloLbl);
//		myPagePane.add(NumLbl);
//		myPagePane.add(levelLbl);
//		myPagePane.add(pointLbl);
//		myPagePane.add(accumulatedPoint);
//		myPagePane.add(memEditBtn);
//		myPagePane.add(reservBtn);
//		myPagePane.add(reservListBtn);
//		myPagePane.add(infoBtn);
		
		memPane.setLayout(new GridLayout(6,2));
		memPane.add(helloLbl);
		memPane.add(numLbl);
		memPane.add(levelLbl);
		memPane.add(pointLbl);
		memPane.add(accumulatedPoint);
	

		btnPane.setLayout(new GridLayout(5,1));
		
		btnPane.add(reservBtn);
		btnPane.add(reservListBtn);
		btnPane.add(reviewBtn);
		btnPane.add(infoBtn);
		btnPane.add(memEditBtn);

		

		
		myPagePane.add(memPane);
		myPagePane.add(btnPane);
		
		add(myPagePane);
	}
	public void setFontColor() {
		helloLbl.setFont(font);
		memEditBtn.setFont(font1);
		reservBtn .setFont(font1);
		reservListBtn.setFont(font1);
		reviewBtn .setFont(font1);
		infoBtn.setFont(font1);
		memEditBtn.setFont(font1);
	
		numLbl.setFont(font1);
		levelLbl.setFont(font1);
		pointLbl.setFont(font1);
		accumulatedPoint.setFont(font1);
		
		
		setBackground(Color.BLACK);
		btnPane.setBackground(Color.BLACK);
		myPagePane.setBackground(Color.BLACK);
		memPane.setBackground(Color.BLACK);
		
		helloLbl.setForeground(Color.WHITE);
		numLbl.setForeground(Color.RED);
		levelLbl.setForeground(Color.RED);
		pointLbl.setForeground(Color.RED);
		accumulatedPoint.setForeground(Color.RED);

		
		memEditBtn.setBackground(Color.BLACK);
		reservBtn.setBackground(Color.BLACK);
		reservListBtn.setBackground(Color.BLACK);
		reviewBtn.setBackground(Color.BLACK);
		infoBtn.setBackground(Color.BLACK);
		
		memEditBtn.setForeground(Color.WHITE);
		reservBtn.setForeground(Color.WHITE);
		reservListBtn.setForeground(Color.WHITE);
		reviewBtn.setForeground(Color.WHITE);
		infoBtn.setForeground(Color.WHITE);
		
		
		LineBorder lineBorder = new LineBorder(Color.BLACK); 
//		memPane.setBorder(lineBorder);
		btnPane.setBorder(lineBorder);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if(obj==reservBtn) { //예약하기 버튼
			
			
		}else if(obj == reservBtn) { //영화 예매 버튼
			
		}else if(obj == reservListBtn) { // 예매내역 버튼	
			myPagePane.setVisible(false);
			add(rl);
			rl.setVisible(true);
			
		}else if(obj==reviewBtn) {  //나의 평점 리뷰 버튼
			myPagePane.setVisible(false);
			add(mmrp);// 나의 평점/리뷰 페이지
			mmrp.setVisible(true);
			
		}else if(obj==infoBtn) {  //포인트 레벨 정보
			
		}else if(obj == memEditBtn) { // 개인젇보 수정
			myPagePane.setVisible(false);
			add(mef.pane);
			mef.pane.setVisible(true);
	
            }
        }
		
		
	

	public static void main(String[] args) {
		new MyPageForm();

	}


}
