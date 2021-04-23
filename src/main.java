import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;

public class main {
    private static String alfEng="abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите текст");
            String str=reader.readLine();
            System.out.println(SubCrypt.encrypt(str));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void zDShifr(){
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите текст для шифрования");
            String str=reader.readLine();
            System.out.println("Введите ключ");
            int key= Integer.parseInt(reader.readLine());
            System.out.println("Шифр");
            System.out.println(encryption(str,key));
            System.out.println("Введите зашифрованный текст");
            str=reader.readLine();
            System.out.println("Введите ключ");
            key= Integer.parseInt(reader.readLine());
            System.out.println("Текс");
            System.out.println(decryption(str,key));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String encryption(String str,int key){
        String string=str.toLowerCase();
        StringBuffer input=new StringBuffer();
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(alfEng.indexOf(chars[i])!=-1){
                Integer ind= (alfEng.indexOf(chars[i])+key)%alfEng.length();
                input.append(alfEng.charAt(ind));}

        }
        return input.toString().toUpperCase(Locale.ROOT);
    }
    public static String decryption(String str,int key){
        String string=str.toLowerCase();
        StringBuffer input=new StringBuffer();
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(alfEng.indexOf(chars[i])!=-1){
                Integer ind= (alfEng.indexOf(chars[i])-key+alfEng.length())%alfEng.length();

                input.append(alfEng.charAt(ind));}

        }
        return input.toString().toUpperCase(Locale.ROOT);
    }

    public static void countChar(String str){

            String string=str;
            char[] chars=string.toLowerCase().toCharArray();
            HashMap<Character,Integer> countChar=new HashMap<>();

            for(int i=0;i<chars.length;i++){
                if(!countChar.containsKey(chars[i])){
                    countChar.put(chars[i],1);
                }
                else{
                    countChar.put(chars[i],countChar.get(chars[i])+1);
                }
            }
            for(Character ch:countChar.keySet()){
                System.out.println(ch+" "+countChar.get(ch));
            }
    }
}
