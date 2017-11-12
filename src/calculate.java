import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class calculate
{
    public double calc(double fNum , double sNum , String whatToDo)
    {
        double res = 0;
        switch (whatToDo)
        {
            case "+":
                res = fNum + sNum;
                break;
            case "-":
                res = fNum - sNum;
                break;
            case "*":
                res = fNum * sNum;
                break;
            case "/":
                res = fNum / sNum;
                break;
        }
        return res;
    }

    public String sendPost(int fNum , int sNum , String whatToDo )
            throws Exception
    {

        String url = "http://localhost:8080";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        final String USER_AGENT = "Mozilla/5.0";

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String num1 = String.valueOf(fNum);
        String num2 = String.valueOf(sNum);
        String act = whatToDo;

        String urlParameters = "num1=" + num1 +"&num2=" + num2 + "&opr="+act;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();

    }
}

