import edu.duke.*;
import java.util.Scanner;
public class CaesarCipher {
    public String encrypt(String input, int key){
        StringBuilder enc=new StringBuilder(input);
        String alph1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alph2=alph1.toLowerCase();
        //System.out.println(alph2);
        String shift1=alph1.substring(key)+alph1.substring(0,key);
        String shift2=alph2.substring(key)+alph2.substring(0,key);
        
        for(int i=0;i<enc.length();i++){
            char curr=enc.charAt(i);
                
            int idx=alph1.indexOf(curr);
            if(idx!=-1){
                    char ch=shift1.charAt(idx);
                    enc.setCharAt(i,ch);
            }
            else{
                idx=alph2.indexOf(curr);
                if(idx!=-1){
                    char ch2=shift2.charAt(idx);
                    enc.setCharAt(i,ch2);
                }
            }
        }
        return enc.toString();
    }
    public String twokey(String input, int key1, int key2){
        StringBuilder enc=new StringBuilder(input);
        String alph1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alph2=alph1.toLowerCase();
        //System.out.println(alph2);
        String shift1=alph1.substring(key1)+alph1.substring(0,key1);
        String shift2=alph2.substring(key1)+alph2.substring(0,key1);
        
        String shift3=alph1.substring(key2)+alph1.substring(0,key2);
        String shift4=alph2.substring(key2)+alph2.substring(0,key2);
        
        for(int i=0;i<enc.length()-1;i+=2){
            char curr=enc.charAt(i);
            int idx=alph1.indexOf(curr);
            if(idx!=-1){
                    char ch=shift1.charAt(idx);
                    enc.setCharAt(i,ch);
            }
            else{
                idx=alph2.indexOf(curr);
                if(idx!=-1){
                    char ch2=shift2.charAt(idx);
                    enc.setCharAt(i,ch2);
                }
            }
               
            curr=enc.charAt(i+1);
            idx=alph1.indexOf(curr);
            if(idx!=-1){
                    char ch=shift3.charAt(idx);
                    enc.setCharAt(i+1,ch);
            }
            else{
                idx=alph2.indexOf(curr);
                if(idx!=-1){
                    char ch2=shift4.charAt(idx);
                    enc.setCharAt(i+1,ch2);
                }
            }
        }
        return enc.toString();
    }
    
    
    public void test(){
        int key=11;
        FileResource fr=new FileResource("ENC.txt");
        String message=fr.asString();
        String enc=encrypt(message,key);
        String dec=encrypt(enc,26-key);
        //System.out.println("Encrypted: "+enc+"\nDecrypted: "+dec);
        System.out.println(enc);
        
    }
    public void test2(){
        Scanner s = new Scanner(System.in); 
        //int key2=s.nextInt();
        int key1=17,i=0,key2=4;
        FileResource fr=new FileResource("ENC.txt");
        String message=fr.asString(),enc="";
//        for(key1=1;key1<26;key1++){
            enc=twokey(message,key1,key2);
            System.out.println((key1)+": " + enc);
//        }
        
    }
    
}
