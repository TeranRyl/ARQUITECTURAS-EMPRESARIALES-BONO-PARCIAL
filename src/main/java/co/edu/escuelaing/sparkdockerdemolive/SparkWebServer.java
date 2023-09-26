package co.edu.escuelaing.sparkdockerdemolive;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static spark.Spark.*;
public class SparkWebServer {

    public static void main(String... args) throws IOException {
        port(getPort());
        get("/sin/:numero", (request, response) -> {
            return Math.sin(Double.parseDouble(request.params(":numero")));
        });
        get("/cos/:numero", (request, response) -> {
            return Math.cos(Double.parseDouble(request.params(":numero")));
        });
        get("/palindrome/:cadena", (request, response) -> {
            return isPalindrome(request.params(":cadena"));
        });
        get("/magvec/:real1/:real2", (request, response) -> {
            return magnitudVector(request.params(":real1"), request.params(":real2"));
        });
        get("/index.html", (request, response) -> {
            return getIndex();
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static boolean isPalindrome(String str) {
        int n = str.length();
        str = str.toLowerCase();
        for (int i = 0; i < n; i++, n--)
        {
            if (str.charAt(i) != str.charAt(n - 1))
                return false;
        }
        return true;
    }

    public static double magnitudVector(String a, String b){
        double mag = Math.sqrt(Double.parseDouble(a) * Double.parseDouble(a) + Double.parseDouble(b) * Double.parseDouble(b));
        return mag;
    }

    public static String getIndex() throws IOException {
        String response;
        Path rutaIndex = Paths.get("src/main/resources/index.html");
        String leerIndex = Files.readString(rutaIndex);
        return response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                // +"Hola";*/
                + leerIndex;
    }


}
