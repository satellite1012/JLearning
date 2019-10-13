package d_2019_02_16;

import java.util.Scanner;
import java.util.HashMap;

public class WordCount
{
    static Scanner in = new Scanner(System.in);
    static HashMap<String,Integer> mapWord = new HashMap<>();
    static HashMap<String,Integer> mapChar = new HashMap<>();
    
    public static void main(String[] args)
    {
        String content;
        
        System.out.println("Enter your content:");
        content = in.nextLine();
        
        String[] content_words = content.split("\\s");
        for (String word : content_words)
        {
            if (!mapWord.containsKey(word))
                mapWord.put(word, 1);
            else
                mapWord.replace(word, mapWord.get(word) + 1);
            for (String chr : word.split(""))
            {
                if (!mapChar.containsKey(chr))
                    mapChar.put(chr, 1);
                else
                    mapChar.replace(chr, mapChar.get(chr) + 1);
            }
        }
        System.out.println(mapWord.toString());
        System.out.println(mapChar.toString());
    }
}
