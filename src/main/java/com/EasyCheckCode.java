package main.java.com;

import java.util.Arrays;
import java.util.Random;

import static main.java.com.BoolToInt.boolToInt;

public class EasyCheckCode {
    public static void main(String[] args) {
        Random random = new Random();
        RandomDataCreater rdc = new RandomDataCreater();
        Boolean dataA[] = new Boolean[16];
        rdc.createData(dataA);
        //隨機數據內容
        System.out.println("隨機數據內容:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
        System.out.println();
        //複製兩組相同數據
        Boolean dataB[] = Arrays.copyOf(dataA, dataA.length);
        Boolean dataC[] = Arrays.copyOf(dataA, dataA.length);
        //隨機更改一位數據內容
        int r = random.nextInt(dataB.length);
        if (dataB[r]) {
            dataB[r] = false;
        } else {
            dataB[r] = true;
        }
        //三組數據內容
        System.out.println("三組數據內容:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataB).forEach(x -> System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataC).forEach(x -> System.out.print(boolToInt(x)));
        //比較三組數據
        for (int k = 0; k < dataA.length; k++) {
            if (dataA[k].booleanValue() == dataB[k].booleanValue() == dataC[k].booleanValue()) {
                continue;
            }
            if (dataA[k].booleanValue() == dataB[k].booleanValue()) {
                dataC[k] = !dataC[k];
                continue;
            }
            if (dataB[k].booleanValue() == dataC[k].booleanValue()) {
                dataA[k] = !dataA[k];
                continue;
            }
            if (dataC[k].booleanValue() == dataA[k].booleanValue()) {
                dataB[k] = !dataB[k];
            }
        }
        //三組數據內容
        System.out.println("\n");
        System.out.println("轉換後三組數據內容:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataB).forEach(x -> System.out.print(boolToInt(x)));
        System.out.println();
        Arrays.stream(dataC).forEach(x -> System.out.print(boolToInt(x)));
    }
  }
