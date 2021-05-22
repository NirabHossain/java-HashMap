import edu.duke.*;
import java.util.*;

public class dnaMy {
    public void countWordsMap(){
        FileResource fr = new FileResource("data/dnaMystery2.txt");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
        for(String word : fr.words()){
            word = word.toUpperCase().trim();
            for(int i=2;i<word.length()-3;i+=3){
                String w=word.substring(i,i+3);                
                if(!map.containsKey(w)){
                    map.put(w,1);
                }
                else {
                    map.put(w,map.get(w)+1);
                }
                //System.out.println(i+3);
            }
            int total = 0,ic=0;
            for(String w : map.keySet()){
                int value = map.get(w);
                System.out.println((++ic)+")"+value+"\t"+w);
                total += value;
            }
            System.out.println("total count: "+total+" different = "+map.keySet().size());
        }
    }
}





/*    
    public void tester(){
        double start, end, time;
        String filename = "data/kjv10.txt";
        
        start = System.currentTimeMillis();
        countWordsMap(filename);
        end = System.currentTimeMillis();
        time = (end-start)/1000;
        System.out.println("time = "+time);
    }
}
*/