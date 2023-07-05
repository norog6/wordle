import java.util.ArrayList;

public class Main {
    public static Color[] wordle(String attempt, String word) {
        Color color[]=new Color[5];
        for (int i=0;i<=4;i++){
            color[i]=Color.Black;
        }
        if (word.equals(attempt)) {
            System.out.println("Correct");
        } else {
            for (int i = 0; i <= 4; i++) {
                if (String.valueOf(attempt.charAt(i)).equals(String.valueOf(word.charAt(i)))) {
                    color[i] = Color.Green;
                    attempt = attempt.substring(0, i) + "." + attempt.substring(i + 1, 5);
                    word = word.substring(0, i) + "!" + word.substring(i + 1, 5);

                }
            }


            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (String.valueOf(attempt.charAt(i)).equals(String.valueOf(word.charAt(j)))) {
                        color[i] = Color.Yellow;
                        attempt = attempt.substring(0, i) + "." + attempt.substring(i + 1, 5);
                        word = word.substring(0, j) + "!" + word.substring(j + 1, 5);
                    }
                }
            }


        }
        return color;
    }

    public static void main(String[] args) {
        String word = "agaaa";
        String attempt = "aadag";
        Color colors[]=wordle(attempt,word);
        for (int i = 0; i <=4 ; i++) {
            System.out.println(colors[i]);

        }

    }


}