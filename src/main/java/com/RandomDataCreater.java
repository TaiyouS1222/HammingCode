package main.java.com;

import java.util.Random;

public class RandomDataCreater {
    Random random = new Random();
    void createData(Boolean[] b){
        //創建隨機數據
        for (int i = 0;i<b.length;i++){
            b[i] = random.nextBoolean();
        }
    }
}
