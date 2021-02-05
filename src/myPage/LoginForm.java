package myPage;

//로그인 페이지
import java.awt.Color; // 
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JPanel implements ActionListener{

    //Container container=getContentPane();
    JPanel pane = new JPanel();
	JLabel loginMsgLbl = new JLabel("로그인 해주세요.");
	JLabel idLbl = new JLabel("회원 ID");
	JLabel pwLbl = new JLabel("비밀번호");
	JTextField idTf = new JTextField();
	JPasswordField pwPf = new JPasswordField();
	JButton loginBtn= new JButton("로그인");
	JCheckBox showPassword=new JCheckBox("비밀번호 보이기");
	
	JLabel memCheckLbl = new JLabel(" 회원이 아니십니까?");
	JButton nonMemBtn = new JButton("비회원 예매");
	JButton signBtn = new JButton("회원가입");
	
	Font font = new Font("맑은 고딕",Font.BOLD,15);
	Font font1 = new Font("맑은 고딕",0, 12);
	// constructor
	public LoginForm() {
		setLoginFrame();
		setLoginLayout();
		setComponentSize();
		setFont();
		
		//이벤트 등록
		loginBtn.addActionListener(this);
		nonMemBtn.addActionListener(this);
		signBtn.addActionListener(this);
		showPassword.addActionListener(this);
	}
	public void setFont() {
		loginMsgLbl.setFont(font);
		idLbl.setFont(font);
		pwLbl.setFont(font);
		loginBtn.setFont(font);
		showPassword.setFont(font1);
		memCheckLbl.setFont(font1);
		nonMemBtn.setFont(font1);
		signBtn.setFont(font1);
		
	}
	public void setComponentSize() { // setBonds method
		//Setting location and Size of each components using setBounds() method.
		   loginMsgLbl.setBounds(300,100,150,30);
	       idLbl.setBounds(300,150,100,30);
	       pwLbl.setBounds(300,190,100,30);
	       
	       idTf.setBounds(400,150,150,30);
	       pwPf.setBounds(400,190,150,30);
	       
	       showPassword.setBounds(400,220,150,30);
	       loginBtn.setBounds(420,260,100,30);
	       
	       memCheckLbl.setBounds(410,300,150,30);
	       nonMemBtn.setBounds(340,330,100,30);
	       signBtn.setBounds(490,330,100,30);
	       
	}
	public void setLoginLayout() { //set Component to container 
		 //Setting layout manager of Container to null
		pane.setBackground(Color.WHITE);
		showPassword.setBackground(Color.WHITE);
	       pane.setLayout(null);
	       pane.setBackground(Color.WHITE);
	       pane.add(loginMsgLbl);
	       pane.add(idLbl);
	       pane.add(pwLbl);
	       pane.add(idTf);
	       pane.add(pwPf);
	       pane.add(showPassword);
	       pane.add(loginBtn);
	       pane.add(memCheckLbl);
	       pane.add(nonMemBtn);
	       pane.add(signBtn);
	       
	       add(pane);
	}
	public void setLoginFrame() { // Frame setting
		//setTitle("로그인");
		setVisible(true);
		//setBounds(10,10,400,330);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setResizable(false);
	}
	public void addActionEvent() { // button action event
		loginBtn.addActionListener(this);
		nonMemBtn.addActionListener(this);
		signBtn.addActionListener(this);
		showPassword.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource(); 
		if(obj ==  loginBtn) { // 로그인 버튼
			String idText;
			String pwText;
			idText = idTf.getText();
			pwText = pwPf.getText();
//			데이터와 정보가 같으면 
//			if(idTf.getText() == ){
//				 JOptionPane.showMessageDialog(this, "로그인 성공");
// 				 idTf.setText("");
//				 pwPf.setText("");
//			}else {
//				  JOptionPane.showMessageDialog(this, "아이디 혹은 비밀번호를 \n 잘못 입력하였습니다. \n 로그인 정보를 확인해주세요.");
//			}
//			
			
			
		}
		if (obj == nonMemBtn) { // 비회원 예매 버튼
			removeAll();
			setVisible(false);
			
			NonMem nm = new NonMem();
			add(nm);
			setVisible(true);
		}
		if(obj == signBtn) { // 회원가입 버튼
			
		}
		
		// showPassword JCheckBox
		if(obj == showPassword) {
			if(showPassword.isSelected()) {
				pwPf.setEchoChar((char)0);
			}else {
				pwPf.setEchoChar('*');
			}
		}
	}	
	
	public static void main(String[] args) {
		new LoginForm();
	}

	
}
