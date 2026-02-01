package com.example.collections_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * コレクションとループ処理を組み合わせるクラスです。
 * 「リストの中身を全部表示する」「マップの中身を全部チェックする」
 * といった、実務で頻出するパターンの練習です。
 */
public class LoopingCollections {

    public static void main(String[] args) {
        
        // データの準備
        List<String> items = new ArrayList<>();
        items.add("薬草");
        items.add("毒消し");
        items.add("世界樹の葉");

        Map<String, Integer> scores = new HashMap<>();
        scores.put("国語", 80);
        scores.put("数学", 95);
        scores.put("英語", 60);

        // ---------------------------------------------------------
        // 1. Listのループ（拡張for文）
        // 一番よく使う形です。「itemsの中から1つずつ item に取り出す」
        // ---------------------------------------------------------
        System.out.println("=== Listのループ ===");
        
        for (String item : items) {
            System.out.println("所持品: " + item);
        }

        // ---------------------------------------------------------
        // 2. Mapのループ（entrySetを使う）
        // Mapは「キー」と「値」がセットなので、少し特殊です。
        // entrySet() は「キーと値のペア(Entry)」のセットを返します。
        // ---------------------------------------------------------
        System.out.println("\n=== Mapのループ ===");
        
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String subject = entry.getKey();   // キー（科目名）
            Integer score = entry.getValue();  // 値（点数）
            
            System.out.println(subject + "の点数は " + score + "点です");
        }
        
        // (参考) キーだけ欲しい場合は scores.keySet() を使います
        // (参考) 値だけ欲しい場合は scores.values() を使います
        
        // ---------------------------------------------------------
        // 3. (応用) List.forEach (Java 8以降の書き方)
        // ラムダ式を使ったモダンな書き方ですが、まずは上のfor文を覚えればOKです。
        // ---------------------------------------------------------
        System.out.println("\n=== (参考) forEachメソッド ===");
        items.forEach(item -> System.out.println("forEachで表示: " + item));
    }
}