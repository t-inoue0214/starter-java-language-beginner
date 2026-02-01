package com.example.collections_advanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 実務で重要な4種類のMapの違いと、効率的なループ方法を学ぶクラスです。
 * 特徴を理解して、適切な場面で適切なMapを選べるようになりましょう。
 */
public class MapVariations {

    public static void main(String[] args) {
        
        // =========================================================
        // 1. HashMap と「上書き」のルール
        // =========================================================
        System.out.println("=== 1. HashMap (基本・最速) ===");
        Map<String, Integer> hashMap = new HashMap<>();
        
        hashMap.put("Apple", 100);
        hashMap.put("Banana", 200);
        
        // 【重要】同じキー("Apple")でputすると、値が上書きされる
        hashMap.put("Apple", 9999); 
        
        System.out.println("Appleの値: " + hashMap.get("Apple")); // -> 9999
        // 順序は保証されません
        System.out.println("中身: " + hashMap);


        // =========================================================
        // 2. LinkedHashMap (順序の制御)
        // 現場では「LRUキャッシュ(最近使ったものを残す)」として使われることがあります。
        // =========================================================
        System.out.println("\n=== 2. LinkedHashMap (アクセス順モード) ===");
        
        // コンストラクタ引数: (初期容量, 負荷係数, アクセス順にするか?)
        // 第3引数を true にすると「アクセス順(Access Order)」、falseだと「挿入順(Insertion Order)」
        Map<String, Integer> lruMap = new LinkedHashMap<>(16, 0.75f, true);
        
        lruMap.put("A", 1);
        lruMap.put("B", 2);
        lruMap.put("C", 3);
        System.out.println("アクセス前: " + lruMap); // [A, B, C]
        
        // ここで "A" を使う（getする）と、Aが「最近使った」ことになるので、一番後ろに移動する
        lruMap.get("A");
        
        System.out.println("アクセス後: " + lruMap); // [B, C, A] に変わる！
        // これを利用して「古いもの(先頭)から消す」仕組みを作れます。


        // =========================================================
        // 3. TreeMap (自動ソート)
        // 便利ですが、データを追加・削除するたびに「並べ替えコスト」がかかります。
        // 単に保存したいだけなら使わないのがベターです。
        // =========================================================
        System.out.println("\n=== 3. TreeMap (ソート済み) ===");
        Map<String, Integer> treeMap = new TreeMap<>();
        
        treeMap.put("Charlie", 30);
        treeMap.put("Alice", 10);
        treeMap.put("Bob", 20);
        
        // キーの辞書順(アルファベット順)に勝手に並ぶ
        System.out.println("中身: " + treeMap); // {Alice=10, Bob=20, Charlie=30}


        // =========================================================
        // 4. ConcurrentHashMap (スレッドセーフ)
        // 今は詳しくやりませんが、「Webアプリなどで同時にアクセスされても壊れないMap」です。
        // =========================================================
        System.out.println("\n=== 4. ConcurrentHashMap (安全) ===");
        Map<String, Integer> safeMap = new ConcurrentHashMap<>();
        safeMap.put("User1", 100);
        // 使い方はHashMapと同じですが、裏側で排他制御(ロック)をしてくれています。


        // =========================================================
        // 5. 【推奨】Entryを使った効率的なループ
        // =========================================================
        System.out.println("\n=== Entryを使ったループ ===");
        
        // entrySet() は「キーと値のペア(Entry)」のセットを返します。
        // keySet()で回して何度も get() するより、こちらの方が高速で推奨されます。
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            
            String key = entry.getKey();   // キーを取り出す
            Integer val = entry.getValue(); // 値を取り出す
            
            System.out.println("Key: " + key + ", Value: " + val);
        }
    }
}