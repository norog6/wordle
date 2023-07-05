import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static Color[] wordle(String attempt, String word) {
        if((word == null || attempt == null || (attempt.length() != word.length()) || !Objects.equals(attempt.trim(), attempt)
                || !Objects.equals(word.trim(), word))) {
            throw new RuntimeException("Not Valid Input");
        }
        int length=attempt.length();
        Color[] color=new Color[length];
        for (int i=0;i<length;i++){
            color[i]=Color.GREEN;
        }
        if (Objects.equals(word,attempt)) {
            return color;
        } else {
            for (int i = 0; i < length; i++) {
                if (String.valueOf(attempt.charAt(i)).equals(String.valueOf(word.charAt(i)))) {
                    attempt = attempt.substring(0, i) + "." + attempt.substring(i + 1, 5);
                    word = word.substring(0, i) + "!" + word.substring(i + 1, 5);

                }
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (String.valueOf(attempt.charAt(i)).equals(String.valueOf(word.charAt(j)))) {
                        color[i] = Color.YELLOW;
                        attempt = attempt.substring(0, i) + "." + attempt.substring(i + 1, 5);
                        word = word.substring(0, j) + "!" + word.substring(j + 1, 5);
                    }
                }
            }
            for (int i = 0; i <length; i++) {
                if (!String.valueOf(attempt.charAt(i)).equals(".")) {
                    color[i] = Color.BLACK;
                }
            }
        }
        return color;
    }

    public static void main(String[] args) {
        var start=System.currentTimeMillis();
        String word = "hello";
        String attempt = "aaaaa";
        Color[] colors=wordle(attempt,word);
        var end=System.currentTimeMillis();
        System.out.println(end-start+" ms");
        Arrays.asList(colors).forEach(System.out::println);
    }


}