import java.util.Scanner;

public class blockCipher {
    public static StringBuilder oprationFun(StringBuilder one,StringBuilder two,StringBuilder key){
        char[] twos = two.toString().toCharArray();
        int a =0;
        int b=0;
        int temp=0;
        char[] keys = key.toString().toCharArray();
        StringBuilder andOperation = new StringBuilder();
        for(int i =0; i<twos.length; i++){
            a = Integer.parseInt(String.valueOf(twos[i]));
            b = Integer.parseInt(String.valueOf(keys[i]));
            temp = (a&b);
            andOperation.append(temp);
        }
        char[] ones = one.toString().toCharArray();
        char[] andd = andOperation.toString().toCharArray();
        StringBuilder out = new StringBuilder();
        for(int i =0; i<andOperation.length(); i++){
            a = Integer.parseInt(String.valueOf(ones[i]));
            b = Integer.parseInt(String.valueOf(andd[i]));
            temp = (a^b);
            out.append(temp);
        }
        return out;

    }
    public static String binaryToString(StringBuilder binary) {
        if (binary.length() % 8 != 0) {
            throw new IllegalArgumentException("Binary length must be multiple of 8");
        }

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 8) {
            String byteStr = binary.substring(i, i + 8);
            int ascii = Integer.parseInt(byteStr, 2);
            text.append((char) ascii);
        }

        return text.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String st = scn.nextLine();
        StringBuilder bi = new StringBuilder();

        for(char ch : st.toCharArray()){
            int asciiValue = (int) ch;
            bi.append(String.format("%8s",Integer.toBinaryString(asciiValue)).replace(' ', '0'));
        }
        System.out.println("real string: "+st);
        System.out.println("binary string: "+bi);

        
        StringBuilder bt = new StringBuilder(bi);
        boolean padded = false;
        if (bt.length() % 2 != 0) {
            bt.append('0');
            padded = true;
        }
        int mid = bt.length()/2;
        // System.out.println(mid);
        bt.insert(mid, " ");
        StringBuilder first = new StringBuilder(bt.substring(0, mid));//as it is
        StringBuilder second = new StringBuilder(bt.substring(mid+1, bt.length()));//one with operations
        System.out.println("First: "+bt);
        System.out.println("ONE Part: "+first);
        System.out.println("TWO Part: "+second);
        bt.replace(0, mid, second.toString());
        System.out.println("After Replace: "+bt);
        int randomNum = (int)(Math.random() * 2);
        char[] chars = first.toString().toCharArray();
        StringBuilder key = new StringBuilder();
        for(char ch : chars){
            int a = Integer.parseInt(String.valueOf(ch));
            int temp = (a ^ randomNum);
            key.append(temp);
        }
        StringBuilder combo = oprationFun(first, second, key);
        bt.replace(mid+1, bt.length(), combo.toString());
        System.out.println("After Function: "+bt);
        
        //decreption
        StringBuilder first2 = new StringBuilder(bt.substring(0, mid));//as it is
        StringBuilder second2 = new StringBuilder(bt.substring(mid+1, bt.length()));//one with operations
        bt.replace(mid+1, bt.length(), first2.toString());
        StringBuilder combo2 = oprationFun(second2, first2, key);
        bt.replace(0, mid, combo2.toString());
        bt.deleteCharAt(mid);
        if (padded) {
            bt.deleteCharAt(bt.length() - 1);
        }
        System.out.println("Final: "+bt);
        String recoveredText = binaryToString(bt);
        System.out.println("Recovered String: " + recoveredText);
        scn.close();
    }
}
