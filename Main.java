import java.util.ArrayList;

public class Main {
    public static void wordle(ArrayList<Wordle> letters, String attempt,String word) {
        if (word.equals(attempt)) {
            System.out.println("Correct");
            return;
        }
        else {
            for (int i = 0; i <= 4; i++) {
                if (letters.get(i).getLetter().equals(String.valueOf(word.charAt(i)))) {
                    letters.get(i).setColor("green");
                    letters.get(i).setLetter(".");
                    word=word.substring(0,i)+"!"+word.substring(i+1,5);
                   
                }
            }


            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 4; j++) {
                    if (letters.get(i).getLetter().equals(String.valueOf(word.charAt(j)))) {
                        letters.get(i).setColor("yellow");
                        letters.get(i).setLetter(".");
                        word=word.substring(0,i)+"!"+word.substring(i+1,5);
                    }
                }
            }
            for (int i=0;i<=4;i++){
                if(letters.get(i).getColor().equals("1")){
                    letters.get(i).setColor("black");
                }
            }
        }
        for (int i=0;i<=4;i++)
        {
            System.out.println(letters.get(i).getColor()+" "+attempt.charAt(i));
        }
        

        return;
    }
    public static void main(String[] args) {
       String word="world";
       String attempt="hello";
        ArrayList<Wordle> letters=new ArrayList<Wordle>();
       for (int i = 0; i<=4; i++)
       {
           Wordle letter=new Wordle(String.valueOf(attempt.charAt(i)),"1");
           letters.add(letter);
       }
       wordle(letters,attempt,word);
    }
    
    
}