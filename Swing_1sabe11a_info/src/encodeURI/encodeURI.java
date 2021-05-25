package encodeURI;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class encodeURI {
    public static String encodeURIComponent(String component) {
        String result = null;
        try {
            result = URLEncoder.encode(component, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
