import edu.duke.*;
import java.util.*;
import java.io.*;

public class Multy {
    
    public void countWordsMap(){
        HashMap<String,Integer> map2 = new HashMap<String,Integer>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int total = 0,large=0,ic=0,t4,t7;
        String g="";
        String[] fhand={"caesar.txt","confucius.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};

        for(int i=0;i<7;i++){
            HashMap<String,Integer> map3 = new HashMap<String,Integer>();
            FileResource fr = new FileResource("data/"+fhand[i]);    
            for(String w : fr.words()){
                w = w.toLowerCase();
                
                if (!map.containsKey(w))map.put(w,1);
                else map.put(w,map.get(w)+1);
                
                if (!map3.containsKey(w))map3.put(w,1);
                else map3.put(w,map3.get(w)+1);
                
                if(w.equals("laid"))System.out.println(map.get(w)+"\t"+w+"\t"+fhand[i]);
            }
            for(String w : map3.keySet()){
                int value = map3.get(w);
                if (!map2.containsKey(w))map2.put(w,1);
                else map2.put(w,map2.get(w)+1);
                /*if(value>500)System.out.println(w+":  "+value);
                if(large<value){
                    large=value;
                    g=w.toString()+": "+fhand[i];
                }*/
            }
                
            System.out.println("\t\t\t\t"+(i+1)+")Done with: \t\t"+fhand[i]);
        }
        large=0;total=0;t4=0;t7=0;
        for(String w : map2.keySet()){
            int value = map2.get(w);
            if(value>4)System.out.println(w+"\t"+value);
            if(value==7){
                t7++;
//                System.out.print(t7+") "+w+"\t");
//                if((t7)%5==0)System.out.println("");
            }
            if(value==4){
                t4++;
                //System.out.print(t4+") "+w+"\t");
                //if((t4)%5==0)System.out.println("");
            }
        }
        for(String w : map.keySet()){
            int value = map.get(w);
            if(large<value){
                large=value;
                g=w.toString();
            }
            total += value;
        }
        System.out.println("\n\n\ntotal count: "+total+" different = "+map.keySet().size()
        +"\nMax occur: "+g+", "+large+" times"+"\nNumbers of words in 7 and 4 files: "+t7+" and "+t4);
    }
}