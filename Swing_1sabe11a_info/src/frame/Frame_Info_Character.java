package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Parse.Character_Code_Search.char_Codesearch;
import Parse.Character_Code_Search.char_Infosearch;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Frame_Info_Character extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_Nickname;
	private char_Infosearch char_info;
	private char_Codesearch char_code;
	private Frame_Search_nickname Frame1;
	private BufferedImage char_img;
	private URL url;
	private BufferedImage weapon_img;
	private URL url_weapon;
	private URL url_shoulder;
	private URL url_top;
	private URL url_bottom;
	private URL url_shoes;
	private URL url_belt;
	private URL url_bracelet;
	private URL url_neckless;
	private URL url_ring;
	private URL url_auxiliary;
	private URL url_magicstone;
	private URL url_earing;
	private URL url_symbol;
	private URL url_creature;
	private URL arr_url[];
	
	private BufferedImage shoulder_img;
	private BufferedImage arr_img[];
	private BufferedImage top_img;
	private BufferedImage symbol_img;
	private BufferedImage creature_img;
	private BufferedImage earing_img;
	private BufferedImage magicstone_img;
	private BufferedImage auxiliary_img;
	private BufferedImage ring_img;
	private BufferedImage neckless_img;
	private BufferedImage bracelet_img;
	private BufferedImage shoes_img;
	private BufferedImage belt_img;
	private BufferedImage bottom_img;
	

	public Frame_Info_Character(String str_nickname, String str_servername) {
//		Frame1 = new Frame_Search_nickname();
		char_info = new char_Infosearch(str_nickname, str_servername);
		
		try {
			char_code = new char_Codesearch(str_nickname, str_servername);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			url = new URL("https://img-api.neople.co.kr/df/servers/"+str_servername+"/characters/"+char_code.get_charcode()+"?zoom=1");
			char_img = ImageIO.read(url);
			arr_url = new URL[14]; //배열순서 : 무기->어깨->상의->바지->벨트->신발->팔찌->목걸이->반지->보조장비->마법석->귀걸이->칭호->크리처
			arr_img = new BufferedImage[14];  //배열순서 : 무기->어깨->상의->바지->벨트->신발->팔찌->목걸이->반지->보조장비->마법석->귀걸이->칭호->크리처
			for (int j = 0; j < 14; j++) {
				arr_url[j] = new URL(char_info.getItem_text(j));
				arr_img[j] = ImageIO.read(arr_url[j]);
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		Frame1.getStr_Nickname();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 608, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 5, 200, 185);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_character_image = new JLabel(new ImageIcon(char_img));
		lbl_character_image.setBounds(0, 0, 200, 185);
		panel_3.add(lbl_character_image);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(224, 5, 372, 185);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbl_ass_Nickname = new JLabel("닉네임 :");
		lbl_ass_Nickname.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lbl_ass_Nickname.setBounds(12, 0, 128, 59);
		panel_4.add(lbl_ass_Nickname);
		
		JLabel lbl_ass_Charcode = new JLabel("케릭터코드 :");
		lbl_ass_Charcode.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lbl_ass_Charcode.setBounds(12, 65, 128, 59);
		panel_4.add(lbl_ass_Charcode);
		
		JLabel lbl_ass_Guildname = new JLabel("길드명 :");
		lbl_ass_Guildname.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lbl_ass_Guildname.setBounds(12, 126, 128, 59);
		panel_4.add(lbl_ass_Guildname);
		
		lbl_Nickname = new JLabel("");
		lbl_Nickname.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lbl_Nickname.setBounds(152, 0, 208, 59);
		lbl_Nickname.setText(str_nickname);
		panel_4.add(lbl_Nickname);
		
		JLabel lbl_Charcode = new JLabel("");
		lbl_Charcode.setFont(new Font("HY견고딕", Font.PLAIN, 10));
		lbl_Charcode.setBounds(152, 65, 208, 59);
		lbl_Charcode.setText(char_code.get_charcode());
		panel_4.add(lbl_Charcode);
		
		JLabel lbl_Guildname = new JLabel("");
		lbl_Guildname.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lbl_Guildname.setBounds(152, 126, 208, 59);
		lbl_Guildname.setText(char_info.getGuild_name());
		panel_4.add(lbl_Guildname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 208, 608, 200);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 5, 264, 185);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("장비");
		lblNewLabel_2.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(21, 10, 98, 31);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_2);
		//배열순서 : 0.무기->1.어깨->2.상의->3.바지->4.벨트->5.신발->6.팔찌->7.목걸이->8.반지->9.보조장비->10.마법석->11.귀걸이->12.칭호->13.크리처
		
		JButton btn_icon_weapon = new JButton(new ImageIcon(arr_img[0]));
		btn_icon_weapon.setBackground(Color.WHITE);
		btn_icon_weapon.setBounds(159, 10, 40, 40);
		panel_5.add(btn_icon_weapon);
		
		JButton btn_icon_cloth_shoulder = new JButton(new ImageIcon(arr_img[1]));
		btn_icon_cloth_shoulder.setBounds(21, 51, 40, 40);
		panel_5.add(btn_icon_cloth_shoulder);
		
		JButton btn_icon_cloth_top = new JButton(new ImageIcon(arr_img[2]));
		btn_icon_cloth_top.setBounds(63, 51, 40, 40);
		panel_5.add(btn_icon_cloth_top);
		
		JButton btn_icon_cloth_bottom = new JButton(new ImageIcon(arr_img[3]));
		btn_icon_cloth_bottom.setBounds(21, 92, 40, 40);
		panel_5.add(btn_icon_cloth_bottom);
		
		JButton btn_icon_cloth_belt = new JButton(new ImageIcon(arr_img[4]));
		btn_icon_cloth_belt.setBounds(63, 92, 40, 40);
		panel_5.add(btn_icon_cloth_belt);
		
		JButton btn_icon_cloth_shoes = new JButton(new ImageIcon(arr_img[5]));
		btn_icon_cloth_shoes.setBounds(21, 132, 40, 40);
		panel_5.add(btn_icon_cloth_shoes);
		
		JButton btn_icon_accessories_bracelet = new JButton(new ImageIcon(arr_img[6]));
		btn_icon_accessories_bracelet.setBounds(159, 51, 40, 40);
		panel_5.add(btn_icon_accessories_bracelet);
		
		JButton btn_icon_accessories_necklace = new JButton(new ImageIcon(arr_img[7]));
		btn_icon_accessories_necklace.setBounds(201, 51, 40, 40);
		panel_5.add(btn_icon_accessories_necklace);
		
		JButton btn_icon_accessories_ring = new JButton(new ImageIcon(arr_img[8]));
		btn_icon_accessories_ring.setBounds(201, 92, 40, 40);
		panel_5.add(btn_icon_accessories_ring);
		
		JButton btn_icon_auxiliary = new JButton(new ImageIcon(arr_img[9]));
		btn_icon_auxiliary.setBounds(159, 92, 40, 40);
		panel_5.add(btn_icon_auxiliary);
		
		JButton btn_icon_magicstone = new JButton(new ImageIcon(arr_img[10]));
		btn_icon_magicstone.setVerticalAlignment(SwingConstants.TOP);
		btn_icon_magicstone.setBounds(201, 132, 40, 40);
		panel_5.add(btn_icon_magicstone);
		
		JButton btn_icon_earing = new JButton(new ImageIcon(arr_img[11]));
		btn_icon_earing.setBounds(159, 132, 40, 40);
		panel_5.add(btn_icon_earing);
		
		JButton btn_icon_symbol = new JButton(new ImageIcon(arr_img[12]));
		btn_icon_symbol.setBounds(201, 10, 40, 40);
		panel_5.add(btn_icon_symbol);
		
		JButton btn_icon_creature = new JButton(new ImageIcon(arr_img[13]));
		btn_icon_creature.setBounds(63, 132, 40, 40);
		panel_5.add(btn_icon_creature);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(288, 5, 298, 185);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("데미지");
		lblNewLabel_3.setFont(new Font("HY견고딕", Font.PLAIN, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 274, 24);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("데미지증가");
		lblNewLabel_6.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(12, 44, 70, 15);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("크리증가");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1.setBounds(12, 69, 70, 15);
		panel_6.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("추가데미지");
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1_1.setBounds(12, 94, 70, 15);
		panel_6.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel("모든공격력");
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1_1_1.setBounds(12, 119, 70, 15);
		panel_6.add(lblNewLabel_6_1_1_1);
		
		JLabel lblNewLabel_6_1_1_2 = new JLabel("물마독공");
		lblNewLabel_6_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1_1_2.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1_1_2.setBounds(142, 44, 70, 15);
		panel_6.add(lblNewLabel_6_1_1_2);
		
		JLabel lblNewLabel_6_1_1_2_1 = new JLabel("힘지능증가");
		lblNewLabel_6_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1_1_2_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1_1_2_1.setBounds(142, 69, 70, 15);
		panel_6.add(lblNewLabel_6_1_1_2_1);
		
		JLabel lbl_Dmgup = new JLabel("0");
		lbl_Dmgup.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Dmgup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Dmgup.setBounds(86, 44, 55, 15);
		lbl_Dmgup.setText(char_info.getDamage_upper());
		panel_6.add(lbl_Dmgup);
		
		JLabel lbl_Criup = new JLabel("0");
		lbl_Criup.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Criup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Criup.setBounds(86, 68, 55, 15);
		lbl_Criup.setText(char_info.getCritical_upper());
		panel_6.add(lbl_Criup);
		
		JLabel lbl_Plusdmg = new JLabel("0");
		lbl_Plusdmg.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Plusdmg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Plusdmg.setBounds(86, 93, 55, 15);
		lbl_Plusdmg.setText(char_info.getPlus_upper());
		panel_6.add(lbl_Plusdmg);
		
		JLabel lbl_Alldmg = new JLabel("0");
		lbl_Alldmg.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Alldmg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Alldmg.setBounds(86, 118, 55, 15);
		lbl_Alldmg.setText(char_info.getAll_damage());
		panel_6.add(lbl_Alldmg);
		
		JLabel lbl_phy_mag_upper = new JLabel("0");
		lbl_phy_mag_upper.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_phy_mag_upper.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_phy_mag_upper.setBounds(213, 43, 55, 15);
		lbl_phy_mag_upper.setText(char_info.getCon_damage());
		panel_6.add(lbl_phy_mag_upper);
		
		JLabel lbl_Statup = new JLabel("0");
		lbl_Statup.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Statup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Statup.setBounds(213, 69, 55, 15);
		lbl_Statup.setText(char_info.getStat_upper());
		panel_6.add(lbl_Statup);
		
		JLabel lblNewLabel_6_1_1_2_1_1 = new JLabel("스킬데미지");
		lblNewLabel_6_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6_1_1_2_1_1.setFont(new Font("HY견고딕", Font.PLAIN, 12));
		lblNewLabel_6_1_1_2_1_1.setBounds(142, 94, 70, 15);
		panel_6.add(lblNewLabel_6_1_1_2_1_1);
		
		JLabel lbl_Skilldmg = new JLabel("0");
		lbl_Skilldmg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Skilldmg.setFont(new Font("HY견고딕", Font.PLAIN, 14));
		lbl_Skilldmg.setBounds(213, 94, 55, 15);
		lbl_Skilldmg.setText(char_info.getSkill_upper());
		panel_6.add(lbl_Skilldmg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 408, 608, 143);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(10, 5, 138, 133);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5_2 = new JLabel("시로코 40초");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lblNewLabel_5_2.setBounds(12, 10, 114, 50);
		panel_7.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("시로코 25초");
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_2_1.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		lblNewLabel_5_2_1.setBounds(12, 68, 114, 50);
		panel_7.add(lblNewLabel_5_2_1);
		
		Panel panel_7_1 = new Panel();
		panel_7_1.setBounds(154, 5, 444, 133);
		panel_1.add(panel_7_1);
		panel_7_1.setLayout(null);
		
		JLabel lbl_Siroco = new JLabel("0");
		lbl_Siroco.setFont(new Font("HY견고딕", Font.PLAIN, 37));
		lbl_Siroco.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Siroco.setBounds(12, 10, 420, 50);
		lbl_Siroco.setText(char_info.get1sinergeDmgTable(13));
		panel_7_1.add(lbl_Siroco);
		
		JLabel lbl_Rozen = new JLabel("0");
		lbl_Rozen.setFont(new Font("HY견고딕", Font.PLAIN, 37));
		lbl_Rozen.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Rozen.setBounds(12, 75, 420, 48);
		lbl_Rozen.setText(char_info.get1sinergeDmgTable(9));
		panel_7_1.add(lbl_Rozen);
		setVisible(true);
	}
}
