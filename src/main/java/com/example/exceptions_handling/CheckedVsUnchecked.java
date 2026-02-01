package com.example.exceptions_handling;

/**
 * 「チェック例外」と「非チェック例外」の違いを知るクラスです。
 * Javaには「必ず try-catch しないと動かせない処理」があります。
 */
public class CheckedVsUnchecked {

    public static void main(String[] args) {

        // ---------------------------------------------------------
        // 1. 非チェック例外 (Unchecked Exception)
        // try-catch を書かなくてもコンパイルは通る（実行すると落ちる）。
        // プログラマーが気をつければ防げるバグ（バグ）です。
        // ---------------------------------------------------------
        // int result = 10 / 0; // これをコメント解除しても、実行するまでエラーって言われない

        
        // ---------------------------------------------------------
        // 2. チェック例外 (Checked Exception)
        // try-catch を書かないと、実行する前（コンパイル時）に怒られる。
        // 「失敗するかもしれないから準備しておけ」というJavaからの警告です。
        // ---------------------------------------------------------
        System.out.println("3秒間スリープします...");

        try {
            // Thread.sleep(ミリ秒): プログラムを一時停止させる命令
            // このメソッドは "InterruptedException" を投げる可能性があります。
            // そのため、try-catch なしではコンパイルエラーになります。
            Thread.sleep(3000); 

        } catch (InterruptedException e) {
            // スリープ中に誰かに叩き起こされた場合の処理
            System.out.println("スリープが中断されました！");
        }

        System.out.println("おはようございます！");
    }
}