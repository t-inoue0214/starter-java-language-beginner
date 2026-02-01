package com.example.exceptions_handling;

/**
 * 「スタックトレース（エラーログ）」を読む練習をするクラスです。
 * メソッドが A -> B -> C と呼ばれていく中で、Cでエラーが起きたとき、
 * ログがどのように表示されるかを確認します。
 */
public class StackTraceReading {

    public static void main(String[] args) {
        System.out.println("mainメソッド開始");
        
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("\n!!!! エラーを捕まえました !!!!");
            System.out.println("以下の「赤い文字」を読んで、どこでエラーが起きたか探してください。\n");
            
            // 実際にコンソールに赤い文字を出力する
            e.printStackTrace();
        }
    }

    // methodA は methodB を呼ぶ
    public static void methodA() {
        System.out.println(" methodA 実行中...");
        methodB();
    }

    // methodB は methodC を呼ぶ
    public static void methodB() {
        System.out.println("  methodB 実行中...");
        methodC();
    }

    // methodC でわざとエラーを起こす
    public static void methodC() {
        System.out.println("   methodC 実行中... ここで事件が起きます！");
        
        String nullString = null;
        
        // null なのに length() を呼ぼうとした -> NullPointerException 発生！
        int length = nullString.length(); 
    }
}

/* * 【実行後のログの読み方】
 * * java.lang.NullPointerException  <-- エラーの種類（ぬるぽ）
 * at ...StackTraceReading.methodC(StackTraceReading.java:42) <-- 犯行現場！(42行目)
 * at ...StackTraceReading.methodB(StackTraceReading.java:36) <-- methodCを呼んだ人
 * at ...StackTraceReading.methodA(StackTraceReading.java:30) <-- methodBを呼んだ人
 * at ...StackTraceReading.main(...)
 * * 一番上の「at ... methodC」を見れば、場所が特定できます。
 */