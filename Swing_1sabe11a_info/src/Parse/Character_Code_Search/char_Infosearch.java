package Parse.Character_Code_Search;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import encodeURI.encodeURI;
import frame.Frame_Search_nickname;

public class char_Infosearch {
	private Document doc2;
	private Document doc1;
	private Frame_Search_nickname Frame1;
	private char_Codesearch char_CodeSearch;
	private encodeURI encode_uri;
	private String dundam_url;
	private String dundam_url2;
	private String dundam_test;
	private Document doc3;
	private String dunoff_url;
	private String damage_upper;
	private String critical_upper;
	private String plus_upper;
	private String all_damage;
	private String con_damage;
	private String stat_upper;
	private String skill_upper;
	private String[] arr_data_value;
	private String Item_img;
	
	public char_Infosearch(String str_nickname, String str_servername) {
		Frame1 = new Frame_Search_nickname();
		try {
			char_CodeSearch = new char_Codesearch(str_nickname, str_servername);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		encode_uri = new encodeURI();
		String code_result;
		try {
			try {
				setSSL();			
			code_result = char_CodeSearch.get_charcode();
			dundam_url = "https://dundam.xyz/search?server="+str_servername+"&name="+encode_uri.encodeURIComponent(str_nickname);
			dundam_url2 = "https://dundam.xyz/view40s?image="+code_result+"&server="+str_servername;
			dunoff_url = "https://dunfaoff.com/SearchResult.df?server="+str_servername+"&characterid="+code_result;
			
			doc1 = Jsoup.connect(dundam_url).get();
			doc2 = Jsoup.connect(dundam_url2).get();
			doc3 = Jsoup.connect(dunoff_url).get();
			
			Elements dunoff_data_item_value = doc3.select("#dmgIncrement");
			String data_value = dunoff_data_item_value.text();
			arr_data_value = data_value.split(" ");
			
			} catch (KeyManagementException e) {
				
			} catch (NoSuchAlgorithmException e) {
				// TODO: handle exception
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getItem_text(int i) {
		Elements dunoff_Item_img = doc3.select("#equipTable .itemimg");
		String img_src = dunoff_Item_img.get(i).attr("src");
		return img_src;
	}
	public String getGuild_name() {
		Elements dunoff_data_guild_value = doc3.select("#char_guild");
		String data_value = dunoff_data_guild_value.text();
		String data[] = data_value.split(" ");
		return data[1];
	}
	public String getSkill_upper() {
		skill_upper = arr_data_value[14];// 스킬데미지증가
		return skill_upper;
	}
	public String getDamage_upper() { 
		damage_upper = arr_data_value[3];// 뎀증
		return damage_upper;
	}
    public String getCritical_upper() {
    	critical_upper = arr_data_value[7]; // 크증
		return critical_upper;
	}
	public String getPlus_upper() {
		plus_upper = arr_data_value[30]; // 추뎀
		return plus_upper;
	}
	public String getAll_damage() {
		all_damage = arr_data_value[18]; // 모공
		return all_damage;
	}
	public String getCon_damage() {
		con_damage = arr_data_value[22]; // 물마독공
		return con_damage;
	}
	public String getStat_upper() {
		stat_upper = arr_data_value[10]; // 스탯
		return stat_upper;
	}
	public String get1sinergeDmgTable(int i) {
    	Element dundam_data = doc1.select("div.pid").get(0);
    	String data_Table = dundam_data.text();
    	String[] result = data_Table.split(" ");
    	return result[i];
    }
	public static void main(String[] args) {
		char_Infosearch info = new char_Infosearch("부양딸내미", "cain");
		System.out.println(info.get1sinergeDmgTable(9));
	}
    public String getDmgTable(int i){
        Elements dmg = doc2.select(".adamage");
        String dmgTable = dmg.text();
        String[] result = dmgTable.split(" ");
        return result[i];
    }
    public String getBuffTable(int i) {
        Elements buff = doc2.select(".adamage");
        String buffTable = buff.text();
        String[] result = buffTable.split(" ");
        return result[i];
    }
    public String getRankTable(int i) {
        Elements rank = doc2.select(".num");
        String rankTable = rank.text();
        String[] result = rankTable.split(" ");
        return result[i];
    }
    
	public static void setSSL() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[]{
	            new X509TrustManager() {
	                @Override
	                public X509Certificate[] getAcceptedIssuers() {
	                    return null;
	                }
	                @Override
	                public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
	                        throws CertificateException {
	                }
	                @Override
	                public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
	                        throws CertificateException {
	                }

	            }
	        };
	        SSLContext sc = SSLContext.getInstance("SSL");
	        sc.init(null, trustAllCerts, new SecureRandom());
	        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
	            @Override
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        });
	        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
}
