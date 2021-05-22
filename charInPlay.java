import edu.duke.*;
import java.util.ArrayList;
public class charInPlay{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public charInPlay() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findUnique(){
        FileResource resource = new FileResource("data/errors.txt");
        int cnt=1;
        for(String s1 : resource.lines()){
            int wd=s1.indexOf(". ");
            if(wd==-1)continue;
            String s=s1.substring(0,wd+1);
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
            cnt++;
        }
        
    }
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int index = findMax();
        System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));
        
        for(int i=0;i<myWords.size();i++){
            System.out.println(i+")"+myWords.get(i)+"Counts: "+myFreqs.get(i));
        }
    }
    public int findMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
}
