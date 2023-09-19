package co.edu.escuelaing.sparkdockerdemolive;
import static spark.Spark.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get ("/sin/:numero", (request, response) -> {
            return Math.sin(Double.parseDouble(request.params(":numero")));
                });

        get ("/cos/:numero", (request, response) -> {
            return Math.cos(Double.parseDouble(request.params(":numero")));
        });
        get ("/palindrome/:cadena", (request, response) -> {
            return isPalindrome(request.params(":cadena"));
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


}
