package com.example.collections_advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * リストの並べ替え（ソート）を学ぶクラスです。
 * Javaには「並べ替えロボット（Comparator）」が用意されています。
 */
public class SortLogic {

    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // 1. 基本データ（数値）のソート
        // ---------------------------------------------------------
        System.out.println("=== 数字のソート ===");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        System.out.println("ソート前: " + numbers);

        // Collections.sort() という魔法のメソッドを使う
        Collections.sort(numbers);
        
        System.out.println("ソート後: " + numbers); // 小さい順(昇順)になる

        // ---------------------------------------------------------
        // 2. カスタムクラス（勇者たち）のソート
        // 「レベル順」や「名前順」など、ルールを決める必要があります。
        // ---------------------------------------------------------
        System.out.println("\n=== オブジェクトのソート（レベル順） ===");
        
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("戦士", 5));
        heroes.add(new Hero("勇者", 1));
        heroes.add(new Hero("魔法使い", 10));

        // ルール: 「レベル(level)が小さい順」に並べたい
        // Comparator（審判）を作って sort メソッドに渡す
        heroes.sort(new Comparator<Hero>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                // h1のレベルからh2のレベルを引く
                // 結果がマイナスならh1が先、プラスならh2が先、というルール
                return h1.level - h2.level;
            }
        });
        
        // (参考) Java 8以降の書き方だとこうなります:
        // heroes.sort((h1, h2) -> h1.level - h2.level);

        for (Hero h : heroes) {
            System.out.println(h.name + " (Lv." + h.level + ")");
        }
    }

    // ソート実験用の簡易クラス（内部クラス）
    static class Hero {
        String name;
        int level;

        Hero(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
}