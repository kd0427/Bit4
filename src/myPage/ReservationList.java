package myPage;
//예매내역 페이지
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class ReservationList extends JPanel implements ActionListener, MouseListener{
JPanel btnPane = new JPanel();
JButton allListBtn = new JButton("전체목록");
JButton dayListBtn = new JButton("예매일순");
JButton cancelBtn = new JButton("예매취소");
JButton returnBtn = new JButton("마이페이지 돌아가기");


//JLabel allListBtn = new JLabel("전체");
//JLabel dayListBtn = new JLabel("예매일순");
//JLabel cancelBtn = new JLabel("예매취소");
//JLabel returnBtn = new JLabel("마이페이지 돌아가기");


JPanel pane = new JPanel();
JTable reservTb;
JScrollPane sp;
DefaultTableModel model;
String tableLbl[]= {"영화", "날짜", "시간","상영관","예매인원","좌석","금액","결제정보","예매상태"};
String statusLbl[] = {"예매완료", "상영완료","예매취소"};


JPanel reservSearchPane = new JPanel();
JLabel reservSearchLbl = new JLabel("예매 내역");
JTextField reservSearchTf = new JTextField(20);
JButton reservSearchBtn = new JButton("검색");

Font font= new Font("맑은 고딕",0, 16);
Font font1 = new Font("맑은 고딕",0, 12);
Font font2 = new Font("맑은 고딕",Font.BOLD, 10);

DefaultListCellRenderer celhead = new DefaultListCellRenderer();
DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();

Object test[][] = {
		{"예매","21/02/10","03:00","3관", "성인 3명", "A1,A2,A3","30,000원", "비씨카드 결제","예매완료"},
		{"테스트","21/02/10","03:00","3관", "성인 3명", "A1,A2,A3","40,000원" ,"비씨카드 결제","상영완료"},
		{"테스트","21/02/10","03:00","3관", "성인 3명", "A1,A2,A3","0원", "비씨카드 결제","예매취소"}
};


	public ReservationList() {
		setFrame();
		setComponentSize();
		setLayout();
		setStatus();
		setColor();
		setFont();
	 
		// 이벤트 등록	
		allListBtn.addMouseListener(this);
		dayListBtn.addMouseListener(this);
		cancelBtn.addMouseListener(this);
		returnBtn.addMouseListener(this);
		reservSearchBtn.addActionListener(this);
	}

	public void setFrame() {
		setVisible(true);
		setBounds(10,10,1000,700);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void setComponentSize() {
		btnPane.setBounds(30,30,800,40);
	     pane.setBounds(30,90,300,300);
	    reservSearchPane.setBounds(30,500,900,40);
	}
	public void setLayout() {
		setLayout(new BorderLayout());
		
		
		btnPane.add(allListBtn); btnPane.add(dayListBtn); btnPane.add(cancelBtn); btnPane.add(returnBtn);
		
		add("North",btnPane);
		
		pane.setLayout(new FlowLayout());
		setTable();
		pane.add(sp);

		add("Center",pane);
		
		
		reservSearchPane.add(reservSearchLbl);
		reservSearchPane.add(reservSearchTf);
		reservSearchPane.add(reservSearchBtn);
		
		
		add("South",reservSearchPane);
	}
	public void setFont() {
		allListBtn.setFont(font1);
		dayListBtn.setFont(font1);
		cancelBtn.setFont(font1);

		
		allListBtn.setFont(font); 
		dayListBtn.setFont(font); 
		cancelBtn.setFont(font); 
		returnBtn.setFont(font); 
		
		for (int i = 0; i < tableLbl.length; i++) {
//		     tableLbl[i].
//			setFont(font1);
		}
	}
	public void setTable() {
	
		model = new DefaultTableModel(test,tableLbl);
		this.reservTb= new JTable(model);
		this.sp = new JScrollPane(reservTb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//스크롤 패널 사이즈
		sp.setPreferredSize(new Dimension(800,450));
	
		// 가운데 정렬, 넓이 조정
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		reservTb.getColumnModel().getColumn(3).setPreferredWidth(20);
		reservTb.getColumnModel().getColumn(2).setPreferredWidth(30);
		// 컬럼 가운데 정렬 
		for (int i = 0; i < tableLbl.length; i++) {
			this.reservTb.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
		celhead.setBackground(Color.WHITE);
		}
		// 높이 조절
		reservTb.setRowHeight(30);

	}
	public void setStatus() {
		for (int i = 0; i < statusLbl.length; i++) {	
		
		TableColumn statusColumn = reservTb.getColumnModel().getColumn(8);
		JTextField statusTf = new JTextField(statusLbl[i]);
		 statusColumn.setCellEditor(new DefaultCellEditor(statusTf));
		 
		 if(statusTf.getText().equals("예매완료")) {
			 statusTf.setForeground(Color.BLUE);
			 statusTf.setFont(font2);
		
		 }else if(statusTf.getText().equals("상영완료")) {
			 statusTf.setForeground(Color.GRAY);
			 
		 }else if(statusTf.getText().equals("예매취소")) {
			 statusTf.setForeground(Color.RED);
		 }

		} 


	}
	public void setColor() {
	
		btnPane.setBackground(Color.BLACK);
		pane.setBackground(Color.BLACK);
		reservTb.setBackground(Color.BLACK); reservTb.setForeground(Color.WHITE);
		sp.setBackground(Color.BLACK); 
		allListBtn.setBackground(Color.BLACK); allListBtn.setForeground(Color.WHITE);
		dayListBtn.setBackground(Color.BLACK); dayListBtn.setForeground(Color.WHITE);
		cancelBtn.setBackground(Color.BLACK); cancelBtn.setForeground(Color.WHITE);
		returnBtn.setBackground(Color.BLACK); returnBtn.setForeground(Color.WHITE);
		
		reservSearchPane.setBackground(Color.BLACK);
		reservSearchLbl.setForeground(Color.WHITE);
		reservSearchBtn.setBackground(Color.BLACK); reservSearchBtn.setForeground(Color.WHITE);
		
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == allListBtn) {
			
		}else if(obj == dayListBtn) {
			
		}else if(obj == cancelBtn) {
			int result = JOptionPane.showConfirmDialog(null, 
					"예매를 취소하시겠습니까?", "예매 취소", 
					JOptionPane.OK_CANCEL_OPTION);
			 if(result == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(this, "예매가 취소되었습니다.");
			}
		}else if(obj == returnBtn) {
			setVisible(false);
			MyPageForm.myPagePane.setVisible(true);
			
		}else if(obj ==reservSearchBtn) {
			
		}
		
	}
	public static void main(String[] args) {
		new ReservationList();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == allListBtn) {
			
		}else if(obj == dayListBtn) {
			
		}else if(obj == cancelBtn) {
			int result = JOptionPane.showConfirmDialog(null, 
					"예매를 취소하시겠습니까?", "예매 취소", 
					JOptionPane.OK_CANCEL_OPTION);
			 if(result == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(this, "예매가 취소되었습니다.");
			}
		}else if(obj == returnBtn) {
			setVisible(false);
			MyPageForm.myPagePane.setVisible(true);
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
