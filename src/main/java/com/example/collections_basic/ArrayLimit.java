package com.example.collections_basic;

import java.util.Arrays;

/**
 * 配列(Array)の限界を知るためのクラスです。
 * 「サイズが変えられない」「便利メソッドがない」という不便さを体験します。
 */
public class ArrayLimit {

    public static void main(String[] args) {
        
        System.out.println("=== 配列の限界 ===");

        // 1. サイズの固定
        // 「3個入る配列」を作ります。これ以上は絶対に入りません。
        String[] members = new String[3];
        
        members[0] = "勇者";
        members[1] = "戦士";
        members[2] = "魔法使い";
        
        System.out.println("現在のメンバー: " + Arrays.toString(members));

        // 2. 追加の限界
        // 「僧侶」を追加したい！と思っても、枠がないのでエラーになります。
        // members[3] = "僧侶"; // -> ArrayIndexOutOfBoundsException (枠外エラー)

        // もし追加したいなら、
        // (1) もっと大きい新しい配列を作って、
        // (2) 古いデータを全部コピーして、
        // (3) 新しいデータを追加する... という面倒な作業が必要です。

        // 3. 削除の限界
        // 「戦士」がいなくなったので消したい...
        members[1] = null; // nullを入れて「空」にするしかない
        
        System.out.println("削除(null化)後: " + Arrays.toString(members));
        // -> [勇者, null, 魔法使い]
        // 穴ボコ（null）が残ってしまい、魔法使いが2番目に詰められるわけではありません。
        
        System.out.println("結論: データの数が増減する場合は、配列は不便！");
    }
}