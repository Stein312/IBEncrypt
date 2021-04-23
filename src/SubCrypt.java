import java.util.*;

public class SubCrypt {
    private static final String alfEng="abcdefghijklmnopqrstuvwxyz";
    private static final String alfRu="абвгдежзийклмнопрстуфхцчшщъыьэюя";
    private static String alf =alfRu;
    private static boolean langEng=false;


    public static void changeLangRU(){
        langEng=true;
        alf=alfRu;
    }
    public static void changeLangENG(){
        langEng=true;
        alf=alfEng;
    }
    public static String encrypt(String str){
        return encrypt(str,generateKey());
    }
    public static String encrypt(String str,String key){
        String strKey=key.toLowerCase(Locale.ROOT);
        Integer[] intKey=new Integer[key.length()];
        int a=(int)'а';
        if(langEng)
            a=(int)'a';
        for(int i=0;i<strKey.length();i++){
            intKey[i]=(int) strKey.charAt(i)-a;
        }
        return encrypt(str,intKey);

    }
    public static String encrypt(String str,Integer[] key){
        String string=str.toLowerCase().replace('Ё','Е');
        StringBuffer input=new StringBuffer();
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(alf.indexOf(chars[i])!=-1){
                int ind=key[alf.indexOf(chars[i])];
                input.append(alf.charAt(ind));
            }
        }
        writeKey(key);
        return input.toString().toUpperCase(Locale.ROOT);

    }
    private static void writeKey(Integer[] key){
        StringBuffer input=new StringBuffer();
        for(int i=0;i<key.length;i++){
            input.append(alf.charAt(key[i]));
        }
        System.out.println(input.toString().toUpperCase(Locale.ROOT));


    }
    private static Integer[] generateKey(){
        LinkedHashSet<Integer> key=new LinkedHashSet<Integer>();
        Random random=new Random();
        int size=32;
        if(langEng){
            size=26;
        }
        while(key.size()<size){
            int i=random.nextInt(size);

                key.add(i);

        }
        return key.toArray(new Integer[key.size()]);

    }

}
