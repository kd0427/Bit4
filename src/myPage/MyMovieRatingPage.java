package myPage;
//나의 평점 리뷰 페이지
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class MyMovieRatingPage extends JPanel implements ActionListener{
	JPanel allPane = new JPanel();
	JPanel btnPane = new JPanel();
	
	JButton allListBtn = new JButton("전체");
	JButton dayListBtn = new JButton("예매일순");
	JButton ratingBtn = new JButton("평점 입력");
	JButton reviewEditBtn = new JButton("평점 / 리뷰 수정");
	JButton reviewDeleteBtn = new JButton("평점 / 리뷰 삭제");
	JButton returnBtn = new JButton("마이페이지 돌아가기");

	JPanel pane = new JPanel();
	
	JTable reviewTb;
	JScrollPane sp;
	DefaultTableModel model;
	
	DefaultListCellRenderer celhead = new DefaultListCellRenderer();
	DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
	
	String tableLbl[] = {"예매 영화","날짜","시간","상영관","평점","리뷰"};
	Object test[][] = {
			{"1","2","3"},
			{"4","5","sysdate"}
	};
	JComboBox<String> movieRatingCombo = new JComboBox<>();
	String comboLbl[] = {"평점 선택","1","2","3","4","5"};
	
	JPanel reservSearchPane = new JPanel();
	JLabel reservSearchLbl = new JLabel("예매 내역");
	JTextField reservSearchTf = new JTextField(20);
	JButton reservSearchBtn = new JButton("검색");
	Font font1 = new Font("맑은 고딕",0, 12);
	Font font= new Font("맑은 고딕",0, 16);
	
	//다른 클래스 호출
	JFrame f = new JFrame();
	Container con = f.getContentPane();
	
	
	
	
	public MyMovieRatingPage() {
		setFrame();
		setComponentSize();
		setLayout();
		setComboBox();
		setColor();
		//이벤트 등록
		allListBtn.addActionListener(this);
		dayListBtn.addActionListener(this);
		ratingBtn.addActionListener(this);
		reviewEditBtn.addActionListener(this);
		reviewDeleteBtn.addActionListener(this);
		returnBtn.addActionListener(this);
		reservSearchBtn.addActionListener(this);

	}
	public void setFrame() {
		setVisible(true);

	}
	public void setComponentSize() {
		allPane.setBounds(150,100,700,500);
		btnPane.setBounds(95,20,800,300);
		pane.setBounds(500,320,800,450);
		
		}
	public void setLayout() {
		//setLayout(null);
		setLayout(new BorderLayout());
		btnPane.add(allListBtn); btnPane.add(dayListBtn); btnPane.add(ratingBtn); 
		btnPane.add(reviewEditBtn); btnPane.add(reviewDeleteBtn); btnPane.add(returnBtn);
		//add("North", btnPane);
		
		setTable();

		pane.add(sp);
		
		//add("Center",pane);
		
		reservSearchPane.add(reservSearchLbl);
		reservSearchPane.add(reservSearchTf);
		reservSearchPane.add(reservSearchBtn);
		
		
		//add("South",reservSearchPane);
		
		allPane.setLayout(new BorderLayout());
		allPane.add("North", btnPane);
		allPane.add("Center",pane);
		allPane.add("South",reservSearchPane);
		
	
		add(allPane);
	}
	public void setComboBox() {
		for (String num : comboLbl) {
			movieRatingCombo.addItem(num);
		}
		// 테이블에 콤보박스 추가하기
		
		TableColumn testColumn = reviewTb.getColumnModel().getColumn(4);
		 testColumn.setCellEditor(new DefaultCellEditor(movieRatingCombo));
		 //reviewTb.getColumn("COMBOBOX가 들어갈 컬럼").setCellRenderer((TableCellRenderer) movieRatingCombo);
	}
	public void setTable() {
		model = new DefaultTableModel(test,tableLbl);
		//this.reviewTb= new JTable(model);
		reviewTb= new JTable(model) {
			public Component preparedRenderer(TableCellRenderer ren, int row, int column) {
				JComponent component= (JComponent)super.prepareRenderer(ren, row, column);
				component.setBackground(Color.BLACK);
				
				return component;
			}
			
			
		};
		
		this.sp = new JScrollPane(reviewTb,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setSize(200, 200);
		sp.setPreferredSize(new Dimension(800,450));
//		reviewTb.getColumnModel().getColumn(3).setPreferredWidth(10);
//		reviewTb.getColumnModel().getColumn(4).setPreferredWidth(10);
		reviewTb.getColumnModel().getColumn(5).setPreferredWidth(150);
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < tableLbl.length-1; i++) {
			this.reviewTb.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
			celhead.setBackground(Color.WHITE);		
			reviewTb.setRowHeight(30);
			reviewTb.getColumnModel().getColumn(i).setPreferredWidth(10);
		}
	}
	public void setColor() {
		
		btnPane.setBackground(Color.BLACK);
		allPane.setBackground(Color.BLACK);
		pane.setBackground(Color.BLACK);
		
		sp.setBackground(Color.BLACK);		sp.setForeground(Color.WHITE);
		reviewTb.setBackground(Color.BLACK); reviewTb.setForeground(Color.WHITE);
		
		allListBtn.setBackground(Color.BLACK);		allListBtn.setForeground(Color.WHITE);  allListBtn.setFont(font);
		dayListBtn.setBackground(Color.BLACK); 		dayListBtn.setForeground(Color.WHITE);	dayListBtn.setFont(font);
		ratingBtn.setBackground(Color.BLACK); 		ratingBtn.setForeground(Color.WHITE);	ratingBtn.setFont(font);
		reviewEditBtn.setBackground(Color.BLACK); 	reviewEditBtn.setForeground(Color.WHITE);	reviewEditBtn.setFont(font);
		reviewDeleteBtn.setBackground(Color.BLACK); reviewDeleteBtn.setForeground(Color.WHITE);	reviewDeleteBtn.setFont(font);
		returnBtn.setBackground(Color.BLACK); 		returnBtn.setForeground(Color.WHITE);	returnBtn.setFont(font);
		reservSearchBtn.setBackground(Color.BLACK); reservSearchBtn.setForeground(Color.WHITE);
		
		reservSearchPane.setBackground(Color.BLACK);
		reservSearchLbl.setForeground(Color.WHITE);
		reservSearchBtn.setBackground(Color.BLACK);	reservSearchBtn.setForeground(Color.WHITE);
		
		LineBorder lineBorder = new LineBorder(Color.BLACK); 
		sp.setBorder(lineBorder);
//		btnPane.setBorder(lineBorder);
		
		allPane.setBackground(Color.WHITE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == allListBtn) {
			
		}else if(obj == dayListBtn ) {
			
		}else if(obj == ratingBtn ) {
			
		}else if(obj == reviewEditBtn) {
			
		}else if(obj == reviewDeleteBtn) {
			
		}else if(obj == returnBtn) {
			setVisible(false);
			allPane.setVisible(false);
			allPane.removeAll();
			
			MyPageForm.myPagePane.setVisible(true);
			
		}
		
	}
	//main
	public static void main(String[] args) {
	new MyMovieRatingPage();

	}
	

}
