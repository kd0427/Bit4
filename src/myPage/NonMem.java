package myPage;
//비회원예매
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class NonMem extends JPanel{
	JPanel eastPane = new JPanel(new FlowLayout());		
	JLabel nonMemLbl = new JLabel("비회원 예매자 \n 정보입력");
	
	JPanel topPane = new JPanel();
	JLabel inputLbl = new JLabel ("개인정보 입력");
	
	JPanel inputPane = new JPanel();
	
	
	JLabel nameLbl = new JLabel("이 름");
	JLabel telLbl = new JLabel("휴대전화");
	JLabel birthLbl = new JLabel ("생년월일");
	JLabel pwLbl = new JLabel("비밀번호");
	
	JTextField nameTf = new JTextField();
	JTextField telTf = new JTextField();
	JTextField birthTf = new JTextField();
	JTextField pwTf = new JTextField();
	

	JButton nonMemReservBtn = new JButton("비회원 예매하기");
	Font font1 = new Font("맑은 고딕",Font.BOLD,13);
	public NonMem() {
		setFrame();
		setComponentSize();
		setLayout();
		setFont();
	}
	public void setFrame() {
		setVisible(true);
		setBounds(10,10,1000,700);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setComponentSize() {
		eastPane.setBounds(30,60,200,400);
		topPane.setBounds(250,60,100,30);
		inputPane.setBounds(250,90,400,400);
		
		nameLbl.setBounds(30,60,100,30);
		nameTf.setBounds(100,60,200,30);
		birthLbl.setBounds(30,120,200,30);
		birthTf.setBounds(100,120,200,30);
		telLbl.setBounds(30,180,100,30);
		telTf.setBounds(100,180,200,30);
		pwLbl.setBounds(30,240,100,30);
		pwTf.setBounds(100,240,200,30);
		
		nonMemReservBtn.setBounds(110,300,150,30);
	}
	public void setLayout() {
		setLayout(null);
		
//		eastPane.setLayout(null);
//		centerPane.setLayout(null);
		
		eastPane.add(nonMemLbl);
		topPane.add(inputLbl);
		
		inputPane.setLayout(null);
		inputPane.add(nameLbl);
		inputPane.add(nameTf);
		
		inputPane.add(birthLbl);
		inputPane.add(birthTf);
		
		inputPane.add(telLbl);
		inputPane.add(telTf);
		
		inputPane.add(pwLbl);
		inputPane.add(pwTf);
		
		inputPane.add(nonMemReservBtn);
		
		LineBorder lineBorder = new LineBorder(Color.BLACK); 
	
		inputPane.setBorder(lineBorder);
		
		add(eastPane);
		add(topPane);
		add(inputPane);
	}
	public void setFont(){
		nonMemLbl.setFont(font1);
		inputLbl.setFont(font1);
	}
	public static void main(String[] args) {
		new NonMem();

	}

}
