package main.java.com;

import java.util.Arrays;
import java.util.Random;
import static main.java.com.BoolToInt.boolToInt;

public class ParityCheck {
    public static void main(String[] args){
        //生成隨機數據
        RandomDataCreater rdc = new RandomDataCreater();
        BoolToInt boolToInt = new BoolToInt();
        Boolean dataA[] = new Boolean[16];
        rdc.createData(dataA);
        //原數據內容
        System.out.print("原數據:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
        //計算數據且更改效驗碼
        int count = 0;
        for (int i = 1;i<dataA.length;i++){
            if(dataA[i] == true){
                count++;
            }
        }
        if (count%2 == 0){
            dataA[0] = false;
        }else {
            dataA[0] = true;
        }
        //輸出新數據
        System.out.print("\n新數據:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
    }
}
