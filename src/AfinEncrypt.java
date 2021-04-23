import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class AfinEncrypt {
    private static String alfEnd="abcdefghijklmnopqrstuvwxyz";
    private static String alfRu="абвгдежзийклмнопрстуфхцчшщъыьэюя";
    private static String alf =alfRu;

    public static void main(String[] args) {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {
            String str=reader.readLine();
            for(int i = 1; i< alf.length(); i+=2){
                for(int j = 0; j< alf.length(); j++){
                    try {
                        System.out.println(decryption(str,i,j));
                    } catch (KeyAException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i+" "+j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            System.out.println("Введите текст для шифрования");
            String str=reader.readLine();
            System.out.println("Введите ключ a");
            int a= Integer.parseInt(reader.readLine());
            System.out.println("Введите ключ b");
            int b= Integer.parseInt(reader.readLine());
            System.out.println("Шифр");
            System.out.println(encryption(str,a,b));
            System.out.println("Введите зашифрованный текст");
            str=reader.readLine();
            System.out.println("Введите ключ a");
            a= Integer.parseInt(reader.readLine());
            System.out.println("Введите ключ b");
            b= Integer.parseInt(reader.readLine());
            System.out.println("Текс");
            try {
                System.out.println(decryption(str,a,b));
            } catch (KeyAException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public static String encryption(String str,int a,int b){
        String string=str.toLowerCase();
        StringBuffer input=new StringBuffer();
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(alf.indexOf(chars[i])!=-1){
                Integer ind= (a* alf.indexOf(chars[i])+b)% alf.length();
                input.append(alf.charAt(ind));}

        }
        return input.toString().toUpperCase(Locale.ROOT).replace('Ё','Е');

    }
    public static String decryption(String str,int a,int b) throws KeyAException {
        String string=str.toLowerCase();
        StringBuffer input=new StringBuffer();
        int alflength= alf.length();
        char[] chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(alf.indexOf(chars[i])!=-1){
                Integer ind= (int)(modInverse(a,alflength))*(alf.indexOf(chars[i])+alflength-b)%alflength;

                input.append(alf.charAt(ind));}

        }
        return input.toString().toLowerCase(Locale.ROOT);

    }
    static int modInverse(int a, int m) throws KeyAException {
        if(a%2 == 0 && a<m){
        throw new KeyAException("Ключ А не валидный");
    }
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1)
            return 0;
        while (a > 1)
        {
            // q является частным
            int q = a / m;
            int t = m;
            // m осталось, процесс
            // То же, что и алгоритм Евклида
            m = a % m;
            a = t;
            t = y;
            // Обновляем x и y
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }

}
