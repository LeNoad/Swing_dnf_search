package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Parse.Character_Code_Search.char_Codesearch;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SpinnerListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Frame_Search_nickname extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtf_Nickname;
	private JButton btn_Search;
	private JComboBox cb_Serverlist;
	private String[] arr_Serverlist = {"cain","diregie","siroco","prey","casillas","hilder","anton","bakal"};
	private char_Codesearch char_CodeSearch;
	private String str_Servername;
	private String str_Nickname;
	private Frame_Info_Character Frame2;
	
	
	public String getStr_Servername() {
		return str_Servername;
	}
	
	public String getStr_Nickname() {
		return str_Nickname;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Search_nickname frame = new Frame_Search_nickname();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Frame_Search_nickname() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 59, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Nickname = new JLabel("닉네임");
		lbl_Nickname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Nickname.setFont(new Font("HY견고딕", Font.PLAIN, 16));
		lbl_Nickname.setBounds(0, 10, 59, 27);
		panel.add(lbl_Nickname);
		
		JLabel lbl_Server = new JLabel("서버");
		lbl_Server.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Server.setFont(new Font("HY견고딕", Font.PLAIN, 16));
		lbl_Server.setBounds(0, 58, 59, 27);
		panel.add(lbl_Server);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(59, 0, 256, 95);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtf_Nickname = new JTextField();
		txtf_Nickname.setBounds(12, 10, 133, 27);
		panel_1.add(txtf_Nickname);
		txtf_Nickname.setColumns(10);
		
		btn_Search = new JButton("검색");
		btn_Search.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		btn_Search.setBounds(157, 10, 78, 75);
		btn_Search.addActionListener(this);
		panel_1.add(btn_Search);
		
		cb_Serverlist = new JComboBox();
		cb_Serverlist.setFont(new Font("HY견고딕", Font.PLAIN, 15));
		cb_Serverlist.setModel(new DefaultComboBoxModel(new String[] {"카인", "디레지에", "시로코", "프레이", "카시야스", "힐더", "안톤", "바칼"}));
		cb_Serverlist.setToolTipText("");
		cb_Serverlist.setBounds(12, 58, 133, 27);
		panel_1.add(cb_Serverlist);
	}
	public String exchange_server(String str) {
		String api_Servername = null;
		switch(str){
			case "카인":
				api_Servername = arr_Serverlist[0];
				break;
			case "디레지에":
				api_Servername = arr_Serverlist[1];
				break;
			case "시로코":
				api_Servername = arr_Serverlist[2];
				break;
			case "프레이":
				api_Servername = arr_Serverlist[3];
				break;
			case "카시야스":
				api_Servername = arr_Serverlist[4];
				break;
			case "힐더":
				api_Servername = arr_Serverlist[5];
				break;
			case "안톤":
				api_Servername = arr_Serverlist[6];
				break;
			case "바칼":
				api_Servername = arr_Serverlist[7];
				break;
		}		
		return api_Servername;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == btn_Search) {
			str_Nickname = txtf_Nickname.getText();
			str_Servername = (String) cb_Serverlist.getSelectedItem();
				Frame2 = new Frame_Info_Character(str_Nickname, exchange_server(str_Servername));
				dispose();
		}
	}
}
