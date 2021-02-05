package myPage;
//개인정보수정
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MemEditForm extends JPanel implements ActionListener {
static JPanel pane = new JPanel();
JPanel topPane = new JPanel();
JLabel editLbl = new JLabel ("개인정보 수정");

JPanel editPane = new JPanel();
JLabel idLbl = new JLabel("아이디");
JLabel nameLbl = new JLabel("이   름");
JLabel telLbl = new JLabel("휴대전화");
JLabel birthLbl = new JLabel ("생년월일");
JLabel genderLbl = new JLabel ("성  별");
JLabel emailLbl = new JLabel("이메일");
JLabel pwLbl = new JLabel("비밀번호");
JLabel atLbl = new JLabel("@");


JTextField nameTf = new JTextField();
JTextField telTf = new JTextField();
JTextField birthTf = new JTextField();
JTextField emailTf = new JTextField();
JPasswordField pwPf = new JPasswordField();

JCheckBox showPassword=new JCheckBox("비밀번호 보이기");

JRadioButton femaleBtn = new JRadioButton("여성");
JRadioButton maleBtn = new JRadioButton("남성");

JComboBox<String> domainCombo = new JComboBox<String>();
String[] domain = {"naver.com", "nate.com", "daum.net", "gmail.com", "kakao.com"};
 
JButton withdrawBtn = new JButton("회원 탈퇴");
JButton returnBtn = new JButton("마이페이지 돌아가기");
JButton editBtn = new JButton("수정정보저장");

Font font1 = new Font("맑은 고딕",Font.BOLD,15);

JoinMem rm = new JoinMem();

//다른 클래스 호출
thxPage thx = new thxPage();

	public MemEditForm() {
		setFrame();
		setComponentSize();
		setLayout() ;
		rm.setGenderGroup();
		setFont();
		setColor();
		
		
		//콤보박스에 도메인 넣기
		for (String domain : domain) {			
			domainCombo.addItem(domain);
		}
		
		// 이벤트 등록
		editBtn.addActionListener(this); // 수정
		showPassword.addActionListener(this); // 비밀번호 보이
		withdrawBtn.addActionListener(this); // 탈퇴버튼
		returnBtn.addActionListener(this); // 마이페이지 돌아가기
	}
	public void setFrame() {
		setVisible(true);
//		setSize(1000,700);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public void setComponentSize() {
		topPane.setBounds(190,80,100,30);
		editLbl.setBounds(400, 80, 100, 30);
		
		editPane.setBounds(190,120,560,400);
		idLbl.setBounds(40,10,100,30);
		nameLbl.setBounds(40,50,100,30);
		nameTf.setBounds(150,50,200,30);
		telLbl.setBounds(40,90,100,30);
		telTf.setBounds(150,90,200,30);
		birthLbl.setBounds(40,130,200,30);
		birthTf.setBounds(150,130,200,30);
		
		genderLbl.setBounds(40,170,100,30);
		femaleBtn.setBounds(150,170,50,30);
		maleBtn.setBounds(200,170,50,30);
		
		emailLbl.setBounds(40, 210, 100, 30);
		emailTf.setBounds(150,210,90,30);
		atLbl.setBounds(250,210,30,30);
		domainCombo.setBounds(280, 210, 150, 30);
		
		pwLbl.setBounds(40,250,100,30);
		pwPf.setBounds(150,250,200,30);
		showPassword.setBounds(150,280,150,30);
		withdrawBtn.setBounds(80,350,100,30);
		returnBtn.setBounds(200,350,150,30);
		editBtn.setBounds(360,350,120,30);
	}
	public void setLayout() {
		setLayout(new BorderLayout());
	
		pane.setLayout(null);
		topPane.add(editLbl);
		
		editPane.setLayout(null);
		
		editPane.add(idLbl);
		// 회원 DB에서 ID 받아서 라벨 옆에 입력한다.
		
		editPane.add(nameLbl);
		editPane.add(nameTf);
		
		editPane.add(birthLbl);
		editPane.add(birthTf);
		
		editPane.add(telLbl);
		editPane.add(telTf);
		
		editPane.add(genderLbl);
		rm.setGenderGroup();
		editPane.add(femaleBtn);
		editPane.add(maleBtn);
		
		editPane.add(emailLbl);
		editPane.add(emailTf);
		editPane.add(atLbl);
		editPane.add(domainCombo);
		
		
		editPane.add(pwLbl);
		editPane.add(pwPf);
		editPane.add(showPassword);
		editPane.add(withdrawBtn);
		editPane.add(returnBtn);
		editPane.add(editBtn);
	
		
		pane.add(topPane);
		pane.add(editPane);
		add(pane); // JPanel 은 BorderLayout, 모든 레이아웃이 담겨져있는 pane은 null
	}
	public void setFont() {
		editLbl.setFont(font1);
		
	}
	public void setColor() {
		
		pane.setBackground(Color.BLACK);
		topPane.setBackground(Color.BLACK);
		editLbl.setBackground(Color.BLACK);		editLbl.setForeground(Color.RED);
		
		editPane.setBackground(Color.BLACK);
		idLbl.setForeground(Color.RED);
		nameLbl.setForeground(Color.WHITE);
		//nameTf.setBackground(Color.GRAY);		//nameTf.setForeground(Color.WHITE);
		telLbl.setForeground(Color.WHITE);
		birthLbl.setForeground(Color.WHITE);
		
		genderLbl.setForeground(Color.WHITE);
		femaleBtn.setBackground(Color.BLACK);	femaleBtn.setForeground(Color.WHITE);		
		maleBtn.setBackground(Color.BLACK); 	maleBtn.setForeground(Color.WHITE);

		
		emailLbl.setForeground(Color.WHITE);
		atLbl.setForeground(Color.WHITE);
		
		pwLbl.setForeground(Color.WHITE);
		pwPf.setForeground(Color.GRAY);
		showPassword.setBackground(Color.BLACK); 	showPassword.setForeground(Color.WHITE); 
		withdrawBtn.setBackground(Color.BLACK);  	withdrawBtn.setForeground(Color.WHITE); 
		 returnBtn.setBackground(Color.BLACK);		returnBtn.setForeground(Color.WHITE);
		editBtn.setBackground(Color.BLACK);			editBtn.setForeground(Color.WHITE); 
		
		
		LineBorder lineBorder = new LineBorder(Color.GRAY); 		
		editPane.setBorder(lineBorder);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == editBtn) { // 수정버튼
			
			JOptionPane.showMessageDialog(this, "수정완료");
			
			
		}else if(obj == withdrawBtn) { //탈퇴버튼
			int result = JOptionPane.showInternalConfirmDialog(null, "정말 탈퇴하시겠습니까?", "회원 탈퇴", 
														JOptionPane.OK_CANCEL_OPTION);
			  
			 if(result == JOptionPane.OK_OPTION) { // ok버튼을 누르면,
				JOptionPane.showMessageDialog(this, "그동안 이용해주셔서 감사합니다.");
				
				//그동안이용해주셔서감사합니다 페이지 호출
				//thxPage thx = new thxPage();
				setVisible(false);
				pane.setVisible(false);
				thx.setVisible(true);
				
			}
			
			
		}else if(obj == returnBtn) { // 돌아가기 버튼
			setVisible(false);
			pane.setVisible(false);
			removeAll();
			MyPageForm.myPagePane.setVisible(true);
			
			
		}else if(obj == showPassword) { // showPassword JCheckBox
			if(showPassword.isSelected()) {
				pwPf.setEchoChar((char)0);
			}else {
				pwPf.setEchoChar('*');
			}
		}
		
	}
	public static void main(String[] args) {
	 new MemEditForm();

	}


}
