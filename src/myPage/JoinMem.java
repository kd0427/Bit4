package myPage;
//회원가입 페이지
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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

public class JoinMem extends JPanel implements ActionListener{
	
	JPanel eastPane = new JPanel();		
	JLabel regiLbl = new JLabel("회원가입");
	
	JPanel topPane = new JPanel();
	JLabel inputLbl = new JLabel ("개인정보 입력");
	
	JPanel inputPane = new JPanel();
	JLabel idLbl = new JLabel("아이디");
	JLabel nameLbl = new JLabel("이   름");
	JLabel telLbl = new JLabel("휴대전화");
	JLabel birthLbl = new JLabel ("생년월일");
	JLabel genderLbl = new JLabel ("성  별");
	JLabel emailLbl = new JLabel("이메일");
	JLabel pwLbl = new JLabel("비밀번호");
	JLabel atLbl = new JLabel("@");
	
	
	JTextField idTf = new JTextField();
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
	 
	JButton regiBtn = new JButton("회원가입");
	
	Font font1 = new Font("맑은 고딕",Font.BOLD,15);
	
	// 라디오 버튼을 그룹화 하기위한 객체 생성
	JPanel radioPane = new JPanel();
	ButtonGroup genderRd = new ButtonGroup();



	public JoinMem() {
		setFrame();
		setComponentSize();
		setLayout() ;
		setDomain();
		setFont();
		setColor();
		
		regiBtn.addActionListener(this);
		showPassword.addActionListener(this);
	
	}
	public void setFrame() {
		setVisible(true);
		setBounds(10,10,1000,700);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setComponentSize() {
		eastPane.setBounds(30,60,200,400);
		topPane.setBounds(250,60,100,30);
		inputPane.setBounds(250,70,450,450);
		
		idLbl.setBounds(40,40,100,30);
		idTf.setBounds(110,40,100,30);
		nameLbl.setBounds(40,80,100,30);
		nameTf.setBounds(110,80,200,30);
		telLbl.setBounds(40,120,100,30);
		telTf.setBounds(110,120,200,30);
		birthLbl.setBounds(40,160,200,30);
		birthTf.setBounds(110,160,200,30);
		
		genderLbl.setBounds(40,200,100,30);
		femaleBtn.setBounds(110,200,50,30);
		maleBtn.setBounds(160,200,50,30);
		
		
		emailLbl.setBounds(40, 240, 100, 30);
		emailTf.setBounds(110,240,90,30);
		atLbl.setBounds(200,240,30,30);
		
		domainCombo.setBounds(220, 240, 150, 30);
		
		pwLbl.setBounds(40,280,100,30);
		pwPf.setBounds(110,280,200,30);
		showPassword.setBounds(110,310,150,20);
		
		regiBtn.setBounds(130,370,150,30);
	}
	public void setLayout() {
		setLayout(null);
		eastPane.add(regiLbl);
		topPane.add(inputLbl);
		
		inputPane.setLayout(null);
		
		inputPane.add(idLbl);
		inputPane.add(idTf);
		
		inputPane.add(nameLbl);
		inputPane.add(nameTf);
		
		inputPane.add(birthLbl);
		inputPane.add(birthTf);
		
		inputPane.add(telLbl);
		inputPane.add(telTf);
		
		inputPane.add(genderLbl);
		setGenderGroup() ;
		inputPane.add(femaleBtn);
		inputPane.add(maleBtn);
		
		
		inputPane.add(emailLbl);
		inputPane.add(emailTf);
		inputPane.add(atLbl);
		inputPane.add(domainCombo);
		
		
		inputPane.add(pwLbl);
		inputPane.add(pwPf);
		inputPane.add(showPassword);
		
		inputPane.add(regiBtn);

		
		add(eastPane);
		add(topPane);
		add(inputPane);
	}
	public void setFont() {
		regiLbl.setFont(font1);
		inputLbl.setFont(font1);
	}
	public void setDomain() {
		for (String domain : domain) {			
			domainCombo.addItem(domain);
		}
		
	}
	public void setColor() {
		// 패널색상
		setBackground(Color.BLACK);
		eastPane.setBackground(Color.BLACK);
		topPane.setBackground(Color.BLACK);
		inputPane.setBackground(Color.BLACK);
		// 라벨색상
		regiLbl.setForeground(Color.RED); // 회원가입 라벨
		inputLbl.setForeground(Color.RED); // 개인정보 입력 라벨
		// 라벨 색상
		idLbl.setForeground(Color.WHITE);	
		nameLbl.setForeground(Color.WHITE);	
		telLbl .setForeground(Color.WHITE);	
		birthLbl.setForeground(Color.WHITE);	
		genderLbl.setForeground(Color.WHITE);	
		emailLbl.setForeground(Color.WHITE);	
		pwLbl.setForeground(Color.WHITE);	
		atLbl.setForeground(Color.WHITE);	
		
		
		//기타 버튼, 라벨 색상	
		showPassword.setBackground(Color.BLACK); showPassword.setForeground(Color.WHITE);		
		femaleBtn.setBackground(Color.BLACK);	femaleBtn.setForeground(Color.WHITE);
		maleBtn.setBackground(Color.BLACK);	maleBtn.setForeground(Color.WHITE);
		
		
		// 회원가입 버튼 색상
		regiBtn.setBackground(Color.BLACK); regiBtn.setForeground(Color.WHITE);
		// 선
		LineBorder lineBorder = new LineBorder(Color.WHITE); 		
		inputPane.setBorder(lineBorder);
		LineBorder lineBorder1 = new LineBorder(Color.RED); 	
		regiBtn.setBorder(lineBorder1);
		
		
	}
	
	public void setGenderGroup() {
		// 그룹에 라디오 버튼 포함시킨다.
		genderRd.add(femaleBtn);
		genderRd.add(maleBtn);
		this.add(femaleBtn);
		this.add(maleBtn);
		this.setBounds(100, 200, 200, 30);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == regiBtn) {
//			JOptionPane.showMessageDialog(this,"회원가입 되었습니다.\n 4CINEMA 가입을 환영합니다.");
//			if(obj.equals("OK")) {
//				setVisible(false);
//				MyPageForm.myPagePane.setVisible(true);
//			
			int result = JOptionPane.showInternalConfirmDialog(null, "회원가입 되었습니다. \n 4CINEMA 가입을 환영합니다", "회원가입완료", 
					JOptionPane.YES_OPTION);

				if(result == JOptionPane.YES_OPTION) { //ok 버튼 누르면 마이페이지 또는 영화예매 화면으로 이동하기
					setVisible(false);
					MyPageForm.myPagePane.setVisible(true);
				}
		
		}else if(obj ==	showPassword) { // showPassword JCheckBox
			if(showPassword.isSelected()) {
				pwPf.setEchoChar((char)0);
			}else {
				pwPf.setEchoChar('*');
			}
		}// else if end
		
	}// method end
	public static void main(String[] args) {
		new JoinMem();

	}
	

}
