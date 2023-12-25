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
```
**優點:**
>奇偶效驗能夠簡單的發現數據出錯，透過一位糾錯為保護全部資料，總傳輸資料量達到x-1/x

**缺點:**
>如果同時發生兩位以上的比特翻轉，奇偶效驗便無法作用，且奇偶效驗只能發現錯誤，並不能糾正錯誤，發現錯誤只能重新傳輸數據


漢明碼
---
為了解決奇偶效驗的缺點及增加效率，理察·衛斯里·漢明在奇偶效驗的基礎上發明了漢明碼。
漢明碼透過在2的平方位增加更多糾錯位，不僅能找出錯誤，更能直接糾正錯誤，比起奇偶效驗是一種更為高效的方法。

### 漢明碼的工作原理
漢明碼的工作原理有三個步驟

1.檢查數據是否有發生錯誤
>檢查整組數據的1是否為偶數

2.交集和排除
>如果有錯誤透過演算法找出錯誤的位置

3.確認錯誤位置
>確認數據錯誤的位置並修正數據

#### 範例:

首先我們先建立一筆資料並用4X4矩陣表示(粗體字為糾錯碼，左上角為第0位)

***
**0**    **0**    **1**    1  
**0**    0    0    1  
**0**    0    0    0  
1    0    0    1  
***

第1位對2、4行做奇偶效驗  
第2位對3、4行做奇偶效驗  
第4位對2、4列做奇偶效驗  
第8位對3、4列做奇偶效驗  
第0位對整個矩陣做奇偶效驗

轉換結果如下:

***
**1**    **1**    **1**    1  
**1**    0    0    1  
**0**    0    0    0  
1    0    0    1
***

範例程式碼(Java):

```java
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
```

### 漢明碼的糾錯
當數據傳輸時，我們只需要依據漢明碼的構建原理再進行一次糾錯便能找出錯誤位置變更改錯誤。

#### 以上面的數據為例(錯誤以斜體字表示):
***
**1**    **1**    **1**    1  
**1**    0    0    1  
**0**    0    *1*    0  
1    0    0    1
***





