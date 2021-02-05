package myPage;
//이건 xxxxx
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class PointLevelInfoPage extends JFrame{
	JSplitPane sp1;
	JPanel leftPane = new JPanel();
		JPanel topPane = new JPanel();
			JLabel gradeLbl = new JLabel("등급별 선정 기준 및 혜택 안내\r");
			JPanel btnPane = new JPanel(new FlowLayout());
			JButton normalBtn = new JButton("일반");
			JButton vipBtn = new JButton("VIP");
			JButton vvipBtn = new JButton("VVIP");
			
	JPanel centerPane = new JPanel();
		JLabel criteriaLbl = new JLabel("선정기준");
		JLabel benefitLbl = new JLabel("혜택");
		
		JLabel criteriaInfoLbl = new JLabel("선정 기준 어쩌구 저쩌구");
		JLabel benefitInfoLbl = new JLabel("혜택 어쩌구저쩌구 ㅈ");
	
	JPanel underPane = new JPanel();
		JLabel infoLbl = new JLabel("포인트 선정 기준");
		JLabel miniLbl = new JLabel("\r\n"
				+ "영화관람, 매점&무비기프트샵 구매로 적립하신 구매 누적 포인트 기준입니다.\r\n"
				+ "영화관람은 상영일 기준, 매점&무비 기프트샵은 적립일자 기준으로 누적 적립됩니다.\r\n"
				+ "포인트는 적립 후 반영까지 2~3일 소요됩니다.\r\n"
				+ "선정기준 및 혜택은 추후에 당사 사정에 따라 변경될 수 있습니다.\r\n"
				);
		
		
	JPanel rightPane = new JPanel();
	JLabel pointLbl = new JLabel();
	JLabel pointInfoLbl = new JLabel();

	
	public PointLevelInfoPage() {
		setFrame();
		setLayout() ;
	}
	public void setFrame() {
		setSize(1000,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftPane,rightPane);
		add(sp1, "Center");
		sp1.setDividerSize(1);
		sp1.setDividerLocation(500);
	}
	public void setComponentSize() {
		
		topPane.setBounds(20,20,400,200);
		gradeLbl.setBounds(30,230,200,30);
		normalBtn.setBounds(20,70,100,30);
		vipBtn.setBounds(60,70,100,30);
		vvipBtn.setBounds(100,70,100,30);
		
		centerPane.setBounds(20,230, 400,200);
		
		underPane.setBounds(20,450,400,200);
		
	}
	public void setLayout() {
	
		topPane.add(gradeLbl);

		topPane.add(normalBtn);
		topPane.add(vipBtn);
		topPane.add(vvipBtn);
	
		//
		centerPane.setLayout(new GridLayout(2,2));
		centerPane.add(criteriaLbl);
		centerPane.add(criteriaInfoLbl);
		centerPane.add(benefitLbl);
		centerPane.add(benefitInfoLbl);
		
		underPane.setLayout(new GridLayout(1,2));
		underPane.add(infoLbl);
		underPane.add(miniLbl);
		
		leftPane.setLayout(new BorderLayout());
		leftPane.add("North",topPane);
		leftPane.add("Center",centerPane);
		leftPane.add(underPane);
	}
	
	public void setFont() {
		
	}
	public static void main(String[] args) {
		new PointLevelInfoPage();

	}

}
