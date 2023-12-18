HammingCode
===
漢明碼為一種線性錯誤糾正碼，由Richard Wesley Hamming發明，用於檢查資料傳輸時所發生的錯誤(例如Bit flip)，現今大多於記憶體糾錯上。

奇偶糾錯
---
奇偶糾錯是在鎖鑰傳輸的數據前新增一位糾錯碼，用以計算數據中0與1的數量。
糾錯碼預設是0，當數據中1的數量為偶數時，糾錯碼會轉為1，維持數據中的1為偶數。

***
例:
**0**011000100001001
***
則:
**1**011000100001001
***
範例程式碼(Java):
```java
public class ParityCheck {
    public static void main(String[] args){
        Random random = new Random();
        RandomDataCreater rdc = new RandomDataCreater();
        BoolToInt boolToInt = new BoolToInt();
        Boolean dataA[] = new Boolean[16];
        rdc.createData(dataA);
        System.out.print("原數據:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
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
        System.out.print("\n新數據:");
        Arrays.stream(dataA).forEach(x -> System.out.print(boolToInt(x)));
    }
}
```
