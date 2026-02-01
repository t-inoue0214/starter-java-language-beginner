package com.example.reference_types;

/**
 * 文字列連結の効率を比較するクラスです。
 * Stringは「不変(Immutable)」であり、変更するたびに作り直しが発生することを学びます。
 */
public class StringVsBuilder {

    public static void main(String[] args) {
        
        // ループ回数
        int loopCount = 10000;

        System.out.println(loopCount + "回の文字列連結を行います...");

        // ---------------------------------------------------------
        // 1. 普通の String と += で連結（遅いパターン）
        // Stringは一度作ったら変更できないため、
        // 「古い文字 + 新しい文字」をコピーして「新しい文字オブジェクト」を作る処理が
        // 10000回繰り返されます。ゴミ（使わないメモリ）が大量発生します。
        // ---------------------------------------------------------
        long startTime = System.currentTimeMillis(); // ストップウォッチ開始
        
        String text = "";
        for (int i = 0; i < loopCount; i++) {
            text = text + "a"; // ここで毎回新しい String が生まれている
        }
        
        long endTime = System.currentTimeMillis(); // ストップウォッチ終了
        System.out.println("String (+演算子) の時間: " + (endTime - startTime) + "ms");

        // ---------------------------------------------------------
        // 2. StringBuilder で連結（速いパターン）
        // StringBuilderは「書き込み可能なノート」のようなもの。
        // 1つのオブジェクトに対して追記していくので、メモリを無駄にしません。
        // ---------------------------------------------------------
        startTime = System.currentTimeMillis(); // ストップウォッチ開始
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < loopCount; i++) {
            builder.append("a"); // 追記するだけ
        }
        String result = builder.toString(); // 最後にStringに変換
        
        endTime = System.currentTimeMillis(); // ストップウォッチ終了
        System.out.println("StringBuilder の時間: " + (endTime - startTime) + "ms");
        
        // 実行結果を比較すると、StringBuilderの方が圧倒的に速いはずです。
        // (回数を10万回などに増やすと、その差は歴然となります)
    }
}