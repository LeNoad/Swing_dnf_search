package Parse.Character_Code_Search;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import encodeURI.encodeURI;
import neople_API.neople_Apikey;

public class char_Codesearch {
	private encodeURI encode_uri;
	private neople_Apikey set_Apikey;
	private String[] result;
	private URL url;
	private URLConnection conn;
	public char_Codesearch(String char_Nickname, String server_Name) throws IOException {
		encode_uri = new encodeURI();
    	set_Apikey = new neople_Apikey();
    	String url_Charcode = "https://api.neople.co.kr/df/servers/"+server_Name+"/characters?characterName="+encode_uri.encodeURIComponent(char_Nickname)+"&apikey="+set_Apikey.setapiKey();
        url = new URL(url_Charcode);
        conn = url.openConnection();
        InputStream is = conn.getInputStream();
        Scanner scan = new Scanner(is);
        String str = scan.nextLine();
        result = str.split("\"");
	}
    public String get_charcode() {
        return result[9];
    }
}
