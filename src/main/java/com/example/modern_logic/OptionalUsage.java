package com.example.modern_logic;

import java.util.Optional;

/**
 * Optional（オプショナル）の使い方を学ぶクラスです。
 * 「値がないかもしれない」という状況を、nullを使わずに安全に扱います。
 */
public class OptionalUsage {

    public static void main(String[] args) {
        
        System.out.println("=== Optionalの実験 ===");

        // ---------------------------------------------------------
        // ケース1: 値が存在する場合
        // データベースから「ID:1」のユーザーを探したと想定
        // ---------------------------------------------------------
        Optional<String> user1 = findUserById(1);

        // 使い方A: 値がある場合だけ処理する (ifPresent)
        // nullチェック (if user != null) を書く必要がない！
        user1.ifPresent(name -> {
            System.out.println("ID:1 のユーザーが見つかりました: " + name);
        });


        // ---------------------------------------------------------
        // ケース2: 値が存在しない（空の）場合
        // データベースにない「ID:99」を探したと想定
        // ---------------------------------------------------------
        Optional<String> user99 = findUserById(99); // 中身は empty

        // 使い方B: 値がなければ「デフォルト値」を使う (orElse)
        // これが最強のメソッドです。「なければ名無し」と一行で書けます。
        String name = user99.orElse("名無しユーザー");
        
        System.out.println("ID:99 のユーザー名: " + name);


        // 使い方C: 値がなければ「例外」を投げる (orElseThrow)
        // 「絶対に見つかるはずだ！見つからないのは異常だ！」という場合
        try {
            String vitalData = user99.orElseThrow(() -> new RuntimeException("データがないぞ！"));
        } catch (RuntimeException e) {
            System.out.println("エラー発生: " + e.getMessage());
        }
    }

    /**
     * IDに応じてユーザー名を返すメソッド（検索機能のシミュレーション）
     * 戻り値を Optional<String> にすることで、
     * 「見つからないかもしれないよ！」と呼び出し元に伝えている。
     */
    public static Optional<String> findUserById(int id) {
        if (id == 1) {
            // 見つかったときは、箱に入れて返す
            return Optional.of("Alice");
        } else {
            // 見つからないときは、「空っぽの箱」を返す（nullではない!）
            return Optional.empty();
        }
    }
}