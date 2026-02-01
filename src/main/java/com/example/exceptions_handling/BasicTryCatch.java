package com.example.exceptions_handling;

/**
 * 基本的な例外処理（try-catch）を学ぶクラスです。
 * エラーが起きてもプログラムを強制終了させず、「復旧」させる方法を学びます。
 */
public class BasicTryCatch {

    public static void main(String[] args) {
        
        System.out.println("=== 処理開始 ===");

        // ---------------------------------------------------------
        // パターン1: 0除算のエラー (ArithmeticException)
        // ---------------------------------------------------------
        try {
            int number = 10;
            int divisor = 0; // 0で割ろうとしている
            
            // ここでエラー発生！この下の行は実行されずに catch へ飛びます
            int result = number / divisor; 
            
            System.out.println("計算結果: " + result); // 実行されません

        } catch (ArithmeticException e) {
            // エラーをキャッチしたときに実行されるブロック
            System.out.println("【エラー】0で割ることはできません！");
            // e.printStackTrace(); // 詳細なエラーログを見たい場合はこれを使う
        }

        // ---------------------------------------------------------
        // パターン2: 数値変換のエラー (NumberFormatException)
        // ---------------------------------------------------------
        String text = "100円"; // "円" という文字が入っているので数字にできない

        try {
            // 文字列を数字に変換しようとする
            int price = Integer.parseInt(text);
            System.out.println("価格: " + price);

        } catch (NumberFormatException e) {
            System.out.println("【エラー】「" + text + "」は数字に変換できません。");
        } finally {
            // finallyブロックは、成功しても失敗しても必ず実行されます
            System.out.println("--- 変換処理終了 ---");
        }

        // ---------------------------------------------------------
        // 重要: try-catch があるおかげで、ここまで到達できる
        // ---------------------------------------------------------
        System.out.println("=== 全ての処理が完了しました（正常終了） ===");
    }
}