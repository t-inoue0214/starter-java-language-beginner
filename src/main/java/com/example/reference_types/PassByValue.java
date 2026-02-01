package com.example.reference_types;

import java.util.Arrays;

/**
 * 「値渡し」と「参照値渡し」の違いを実験するクラスです。
 * メソッドにデータを渡したとき、元の変数が影響を受けるかを確認します。
 */
public class PassByValue {

    public static void main(String[] args) {
        
        // ---------------------------------------------------------
        // 実験1: プリミティブ型 (int) をメソッドに渡す
        // コピーされた「値」が渡されるだけなので、元の変数は無事。
        // ---------------------------------------------------------
        System.out.println("=== 実験1: プリミティブ型 ===");
        int originalNum = 10;
        System.out.println("渡し前: " + originalNum);
        
        // メソッド呼び出し（コピーを渡す）
        changePrimitive(originalNum);
        
        System.out.println("渡し後: " + originalNum); 
        // -> 10のまま変わらない！

        // ---------------------------------------------------------
        // 実験2: 参照型 (配列) をメソッドに渡す
        // コピーされた「住所(リモコン)」が渡される。
        // 同じ住所のデータを操作するので、元の変数の中身も変わる！
        // ---------------------------------------------------------
        System.out.println("\n=== 実験2: 参照型 (配列) ===");
        int[] originalArray = {10, 20, 30}; // 配列というオブジェクト
        System.out.println("渡し前: " + Arrays.toString(originalArray));
        
        // メソッド呼び出し（住所のコピーを渡す）
        changeReference(originalArray);
        
        System.out.println("渡し後: " + Arrays.toString(originalArray));
        // -> {999, 20, 30} に変わってしまっている！ (副作用)
    }

    // プリミティブ型を受け取るメソッド
    public static void changePrimitive(int number) {
        // ここで number は originalNum のコピー。
        // コピーを書き換えても、呼び出し元には影響しない。
        number = 999;
        System.out.println("  (メソッド内で 999 に変更しました)");
    }

    // 参照型を受け取るメソッド
    public static void changeReference(int[] array) {
        // ここで array は originalArray と「同じ住所」を指している。
        // なので、この array を使って中身を書き換えると、実体が変わる。
        array[0] = 999;
        System.out.println("  (メソッド内で [0] を 999 に変更しました)");
    }
}