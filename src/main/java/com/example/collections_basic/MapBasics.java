package com.example.collections_basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Map（マップ）の基本操作を学ぶクラスです。
 * 「キー」を使って値を保存・検索する、「辞書」のような構造です。
 */
public class MapBasics {

    public static void main(String[] args) {
        
        System.out.println("=== Map (HashMap) の操作 ===");

        // ---------------------------------------------------------
        // 1. Mapの宣言
        // Map<キーの型, 値の型> 変数名 = new HashMap<>();
        // ここでは「名前(String)」から「年齢(Integer)」を引くMapを作ります。
        // ---------------------------------------------------------
        Map<String, Integer> userAges = new HashMap<>();

        // ---------------------------------------------------------
        // 2. データの保存 (put)
        // ---------------------------------------------------------
        userAges.put("Alice", 25);
        userAges.put("Bob", 30);
        userAges.put("Charlie", 20);

        System.out.println("現在のデータ: " + userAges);
        // -> {Bob=30, Alice=25, Charlie=20} 
        // ※HashMapは順序を保証しないので、入れた順に表示されるとは限りません。

        // ---------------------------------------------------------
        // 3. データの取得 (get)
        // キーを指定して、値を取り出します。
        // ---------------------------------------------------------
        int aliceAge = userAges.get("Alice");
        System.out.println("Aliceの年齢: " + aliceAge);

        // 存在しないキーを指定すると null が返ってきます
        System.out.println("Daveの年齢: " + userAges.get("Dave")); // -> null

        // ---------------------------------------------------------
        // 4. データの上書き
        // 同じキーで put すると、値が上書きされます。
        // ---------------------------------------------------------
        userAges.put("Alice", 26); // Aliceの誕生日！
        System.out.println("Aliceの更新後の年齢: " + userAges.get("Alice"));

        // ---------------------------------------------------------
        // 5. キーの存在確認 (containsKey)
        // nullチェックの代わりに使うことが多いです。
        // ---------------------------------------------------------
        if (userAges.containsKey("Bob")) {
            System.out.println("Bobは登録されています。");
        }
    }
}