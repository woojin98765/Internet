import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String args[]) {
        //https://pubgesports.com/ko/tournament/109?detailType=match&NEWS_SIZE=10&MATCH_BIG=234&STAT_TYPE=player&STAT_TOP5_TYPE=kill-top
        String address = "https://ddragon.leagueoflegends.com/cdn/15.22.1/data/ko_KR/champion.json";

        try {
            URL url = new URL(address);
            URLConnection conn = url.openConnection();
            System.out.println("conn.toString():" + conn);
            System.out.println("getAllowUserInteraction():" + conn.getAllowUserInteraction());
            System.out.print("\tgetConnectTimeout():" + conn.getConnectTimeout());
            System.out.println("getContent():" + conn.getContent());
            System.out.println("getContentEncoding():" + conn.getContentEncoding());
            System.out.print("\tgetContentLength():" + conn.getContentLength());
            System.out.println("getContentType():" + conn.getContentType());
            System.out.print("\tgetDate():" + conn.getDate());
            System.out.println("getDefaultAllowUserInteraction():" + conn.getDefaultAllowUserInteraction());
            System.out.println("getDefaultUseCaches():" + conn.getDefaultUseCaches());
            System.out.print("\tgetDoInput():" + conn.getDoInput());
            System.out.println("getDoOutput():" + conn.getDoOutput());
            System.out.print("\tgetExpiration():" + conn.getExpiration());
            System.out.println("getHeaderFields():" + conn.getHeaderFields());
            System.out.println("getIfModifiedSince():" + conn.getIfModifiedSince());
            System.out.print("\tgetLastModified():" + conn.getLastModified());
            System.out.println("getReadTimeout():" + conn.getReadTimeout());
            System.out.println("getURL():" + conn.getURL());
            System.out.println("getUseCaches():" + conn.getUseCaches());
            System.out.println("getInputStream():" + conn.getInputStream().toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF8"));
            String inputString;
            while ((inputString = in.readLine()) != null) {
                System.out.println(inputString);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}