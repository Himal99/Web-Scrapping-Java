import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class web{
    public static void main(String[] args) {
    try{

        String link="http://cybersansar.com/thumbnail_view.php?gal_id=2284";
        URL url=new URL(link);
        URLConnection conn=url.openConnection();
        StringBuilder content=new StringBuilder();
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()))){

            String line="";
            while((line=reader.readLine())!=null){
                content.append(line).append("\n");
            }
        }


        String data=content.toString();
        String regex="[a-z]*\\.jpg";
        Pattern pattern=Pattern.compile(regex);
        Matcher match= pattern.matcher(data);
        while(match.find()){
            System.out.println(match.group());
        }
        

    }catch(IOException ioe){
        ioe.printStackTrace();
    }
    }
}