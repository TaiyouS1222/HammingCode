package main.java.com;

import java.util.Arrays;
import java.util.Random;

public class EasyCheckCode {
    public static void main(String[] args){
        Random random = new Random();
        Boolean dataA[] = new Boolean[16];
        //創建隨機數據
        for (int i = 0;i<dataA.length;i++){
            dataA[i] = random.nextBoolean();
        }
        //隨機數據內容
        System.out.println("隨機數據內容:");
        Arrays.stream(dataA).forEach(x ->System.out.print(boolToInt(x)));
        System.out.println();
        //複製兩組相同數據
        Boolean dataB[] =Arrays.copyOf(dataA, dataA.length);
        Boolean dataC[] = Arrays.copyOf(dataA, dataA.length);
        //隨機更改一位數據內容
        dataB[random.nextInt(dataB.length)] = dataB[]
        //三組數據內容
        System.out.println("三組數據內容:");
        Arrays.stream(dataA).forEach(x ->System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataB).forEach(x ->System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataC).forEach(x ->System.out.print(boolToInt(x)));
        //比較三組數據
        for (int k = 0;k<dataA.length;k++){
            if(dataA[k] && dataB[k] && dataC[k]){
                continue;
            }else if(dataA[k].equals(dataB[k]) && dataA.equals(dataC)){
                dataA[k] = !dataA[k];
            }
        }
    }
    public static int boolToInt(boolean b){
        return b ? 1 : 0;
    }
}
