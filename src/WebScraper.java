import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        int specialNumber = 0;
        String specialWord = "Hamlet";
        String website = urlToString("http://erdani.com/tdpl/hamlet.txt");
        website = website.toLowerCase();
        String[] words = website.split("\\s+");
        System.out.println("the amount of words in http://erdani.com/tdpl/hamlet.txt is:");
        System.out.println(words.length);
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(specialWord.toLowerCase())) {
                specialNumber++;
            }
        }
        System.out.println("The number of times " + specialWord + " appears is:");
        System.out.println(specialNumber);
    }
}
