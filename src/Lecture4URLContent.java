import java.io.*;
import java.util.*;
import java.net.*;


public class Lecture4URLContent {

    public static boolean readContent(String urlAdress) {
        boolean readContentIsOk = false;
        try {
            URL url = new URL(urlAdress);
            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            readContentIsOk = true;
        } catch (MalformedURLException e) { // проверка протокола (http, etc)
            System.out.println(e.getMessage());
            // the URL is not in a valid form
        } catch (IOException e) { // отсутствие связи
            System.out.println(e.getMessage()+ " no connection.");
            // the connection couldn't be established
        } catch (Exception exception){
            System.out.println(exception.getMessage()+" : " + urlAdress);
        } finally {
            return  readContentIsOk;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(" Enter URL (or 'e' for exit): ");
            String str = scanner.next();
            if (str.toLowerCase().equals("e") || readContent(str)) {
                break;
            }
        }
        scanner.close();
    }
}