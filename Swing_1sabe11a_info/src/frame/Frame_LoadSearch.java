package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;


public class Frame_LoadSearch extends JFrame implements ActionListener {
	private JButton btn_LoadSearch;
	private JTextField txtf_LoadNickName;
	private JSpinner spi_LoadServerName;
	private JLabel lbl_LoadNickName;
	private String[] server = {"카인","디레지에","시로코","프레이","카시야스","힐더","바칼"};
	public Frame_LoadSearch(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setResizable(false);
		set_Rightjpanel();
		set_Centerjpanel();
		
		setVisible(true);	
	}
	public void set_Centerjpanel( ) {
		JPanel center_Panel = new JPanel();
		center_Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		lbl_LoadNickName = new JLabel("이름 :");
		center_Panel.add(lbl_LoadNickName);
		txtf_LoadNickName = new JTextField(8);
		center_Panel.add(txtf_LoadNickName);
		SpinnerListModel spilst_Servername = new SpinnerListModel(server);
//		SpinnerNumberModel spinum_Servernumber = new SpinnerNumberModel();
		
		spi_LoadServerName = new JSpinner(spilst_Servername);
		center_Panel.add(spi_LoadServerName);
		
		
		add(center_Panel,BorderLayout.CENTER);
	}
	public void set_Rightjpanel() {
		JPanel right_Panel = new JPanel();
		right_Panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,33));
		btn_LoadSearch = new JButton("검색");
		btn_LoadSearch.addActionListener(this);
//		btn_LoadSearch.setPreferredSize(new Dimension(50,50));
		right_Panel.add(btn_LoadSearch);
		add(right_Panel,BorderLayout.EAST);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frame_LoadSearch("검색", 250, 150);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
