package main.java.com;

import java.util.Arrays;

import static main.java.com.BoolToInt.boolToInt;

public class HammingCodeTransfer {
    public static void main(String[] args){
        //生成隨機數據
        RandomDataCreater rdc = new RandomDataCreater();
        BoolToInt boolToInt = new BoolToInt();
        Boolean dataA[] = new Boolean[16];
        rdc.createData(dataA);
        //原數據內容(以4X4矩陣表示)
        System.out.print("原數據:");
        for (int i=0;i<16;i++){
            if(i%4==0){
                System.out.println();
            }
            System.out.print(boolToInt(dataA[i]));
        }
        System.out.println();
        //進行漢名碼轉換
        int count = 0;
        //第1位對2、4行做奇偶效驗
        for(int i=1;i<15;i+=2){
            if(boolToInt(dataA[i])==1){
                count++;
            }
        }
        if(count%2!=0 && dataA[1]==false){
            dataA[1] = true;
        }else{
            dataA[1] = false;
        }
        //第2位對3、4行做奇偶效驗
        count = 0;
        int s = 0;
        for(int i=2;i<15;i++){
            s++;
            if(s%2==0){
                i+=2;
            }
            if(boolToInt(dataA[i])==1){
                count++;
            }
        }
        if(count%2!=0 && dataA[2]==false){
            dataA[2] = true;
        }else{
            dataA[2] = false;
        }
        //第4位對2、4列做奇偶效驗
        count = 0;
        s = 0;
        for(int i=4;i<15;i++){
            s++;
            if(s%4==0){
                i+=4;
            }
            if(boolToInt(dataA[i])==1){
                count++;
            }
        }
        if(count%2!=0 && dataA[4]==false){
            dataA[4] = true;
        }else{
            dataA[4] = false;
        }
        //第8位對3、4列做奇偶效驗
        count = 0;
        for(int i=8;i<15;i++){
            if(boolToInt(dataA[i])==1){
                count++;
            }
        }
        if(count%2!=0 && dataA[8]==false){
            dataA[8] = true;
        }else{
            dataA[8] = false;
        }
        //第0位對整個矩陣做奇偶效驗
        count = 0;
        for(int i=0;i<15;i++){
            if(boolToInt(dataA[i])==1){
                count++;
            }
        }
        if(count%2!=0 && dataA[0]==false){
            dataA[0] = true;
        }else{
            dataA[0] = false;
        }
        //新數據內容(以4X4矩陣表示)
        System.out.print("新數據:");
        for (int i=0;i<16;i++){
            if(i%4==0){
                System.out.println();
            }
            System.out.print(boolToInt(dataA[i]));
        }
    }
}
