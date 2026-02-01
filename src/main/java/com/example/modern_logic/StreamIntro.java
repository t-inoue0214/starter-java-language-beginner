package com.example.modern_logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream APIの基礎を学ぶクラスです。
 * 「偶数だけ選んで、2倍にして、リストに集める」という処理を、
 * 昔ながらの for文 と Stream API で書き比べます。
 */
public class StreamIntro {

    public static void main(String[] args) {
        
        // 元データ（1から10までの数字）
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("元データ: " + numbers);

        // =========================================================
        // 1. 昔ながらの書き方 (for文)
        // 手順を全部自分で書く必要がある（命令型）。
        // =========================================================
        System.out.println("\n=== for文の場合 ===");
        
        List<Integer> evenDoubledFor = new ArrayList<>();
        
        for (Integer num : numbers) {
            // 1. 選別する（偶数のみ）
            if (num % 2 == 0) {
                // 2. 加工する（2倍にする）
                int doubled = num * 2;
                // 3. 集める
                evenDoubledFor.add(doubled);
            }
        }
        
        System.out.println("結果: " + evenDoubledFor);


        // =========================================================
        // 2. モダンな書き方 (Stream API)
        // 「やりたいこと」を宣言するように繋げて書く（宣言型）。
        // =========================================================
        System.out.println("\n=== Stream APIの場合 ===");
        
        List<Integer> evenDoubledStream = numbers.stream() // ベルトコンベアに流す
            .filter(n -> n % 2 == 0)      // 【選別】偶数だけ通す
            .map(n -> n * 2)              // 【加工】2倍に変換する
            .collect(Collectors.toList()); // 【箱詰め】リストにまとめる
            // ※ Java 16以降なら .toList() だけでOKですが、今は基本形で書きます
        
        System.out.println("結果: " + evenDoubledStream);
        
        System.out.println("\n【ポイント】");
        System.out.println("Streamを使うと、ロジック（偶数？2倍？）だけが際立ち、");
        System.out.println("「リストを作ってaddする」といった雑用コードが消えます。");
    }
}