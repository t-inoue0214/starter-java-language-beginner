package com.example.basics_control;

/**
 * メソッド（Method）の定義と使い方を学ぶクラスです。
 * 引数（材料）と戻り値（完成品）の関係を理解しましょう。
 */
public class MethodSignature {

    public static void main(String[] args) {
        // --- ここはメインの司令塔（mainメソッド）です ---

        // 1. 引数なし、戻り値なし（void）のメソッドを呼ぶ
        // 「挨拶しておいて！」と命令するだけ
        sayHello();

        // 2. 引数あり、戻り値なし（void）のメソッドを呼ぶ
        // 「この名前（引数）を使って挨拶して！」と命令する
        greetUser("新人エンジニア");

        // 3. 引数あり、戻り値ありのメソッドを呼ぶ
        // 「1000円と80円（引数）を渡すから、合計金額（戻り値）を計算して教えて！」
        int result = calculatePrice(1000, 80);
        
        // カウンターに戻ってきた料理（計算結果）を表示する
        System.out.println("計算結果は " + result + " 円です。");
        
        // メソッドの結果をそのまま使うこともできる
        // 「500+50」の結果が直接 println に渡される
        System.out.println("別の計算: " + calculatePrice(500, 50));
    }

    // =========================================================
    // 以下は「特製レシピ（メソッド）」の定義エリアです
    // =========================================================

    /**
     * パターン1: 何も受け取らないし、何も返さないメソッド
     * void は「空っぽ（戻り値なし）」という意味です。
     */
    public static void sayHello() {
        System.out.println("こんにちは！");
    }

    /**
     * パターン2: データを受け取るが、結果は返さないメソッド
     * @param name 呼び出し元から渡される名前（材料）
     */
    public static void greetUser(String name) {
        // 受け取った name を使って処理をする
        System.out.println(name + "さん、ようこそJavaの世界へ！");
        // return; がなくても、最後まで行けばメソッドは終わる
    }

    /**
     * パターン3: データを受け取り、計算結果を返すメソッド
     * int は「このメソッドは最終的に int型のデータを返すよ」という約束
     * * @param price 価格（材料1）
     * @param tax 消費税（材料2）
     * @return 計算済みの合計金額（完成した料理）
     */
    public static int calculatePrice(int price, int tax) {
        // 計算処理を行う
        int total = price + tax;
        
        // return（リターン）: 
        // 処理を終了し、呼び出し元に値を渡して戻る
        return total;
    }
}