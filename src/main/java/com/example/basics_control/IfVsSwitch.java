package com.example.basics_control;

/**
 * 分岐（Branching）の基本を学ぶクラスです。
 * if文とswitch文の書き方の違いを比較します。
 */
public class IfVsSwitch {

    public static void main(String[] args) {

        // ---------------------------------------------------------
        // 1. if-else文を使った分岐
        // 条件が「範囲」や「複雑な組み合わせ」の場合に適しています。
        // ---------------------------------------------------------
        int score = 85; // テストの点数が入った箱を用意（85点）

        System.out.println("=== if文による判定 ===");

        // もし、点数が80点以上なら
        if (score >= 80) {
            // このブロックの中が実行される
            System.out.println("素晴らしい！合格です。");
        }
        // そうではなく、もし点数が60点以上なら
        else if (score >= 60) {
            // このブロックの中が実行される
            System.out.println("あと少し！追試はありません。");
        }
        // どの条件にも当てはまらない場合（60点未満）
        else {
            // このブロックの中が実行される
            System.out.println("残念、不合格です...");
        }

        // ---------------------------------------------------------
        // 2. switch文（Java 21 Modern Style）を使った分岐
        // 値が「決まったパターン」のどれに当てはまるか見るのに適しています。
        // ---------------------------------------------------------
        String rank = "A"; // ランク（S, A, B, C）が入った箱

        System.out.println("\n=== switch文による判定 ===");

        // rankの中身によって、処理を切り替える（昔からある記述方式。breakを書かないと次のcaseも実行することになる）
        switch (rank) {
            case "S":
                // rankが "S" の場合
                System.out.println("景品：金のトロフィー");
                break;
            case "A":
                // rankが "A" の場合
                System.out.println("景品：銀の盾");
                break; // ここをコメントアウトすると"A"の場合は、AとBの両方を実行する
            case "B":
                // rankが "B" の場合
                System.out.println("景品：銅メダル");
                break;
            default:
                // どのケースにも当てはまらない場合
                System.out.println("景品：参加賞");
                break;
        }

        // rankの中身によって、処理を切り替える（矢印 -> を使うとbreakを書かなくて良い）
        switch (rank) {
            case "S" -> {
                // rankが "S" の場合
                System.out.println("景品：金のトロフィー");
            }
            case "A" -> {
                // rankが "A" の場合
                System.out.println("景品：銀の盾");
            }
            case "B" -> {
                // rankが "B" の場合
                System.out.println("景品：銅メダル");
            }
            default -> {
                // どのケースにも当てはまらない場合
                System.out.println("景品：参加賞");
            }
        }
    }
}