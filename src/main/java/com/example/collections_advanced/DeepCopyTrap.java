package com.example.collections_advanced;

import java.util.ArrayList;
import java.util.List;

/**
 * 「シャローコピー（浅いコピー）」の罠を実験するクラスです。
 * リスト自体をコピーしても、中に入っている「オブジェクトの住所」までコピーされるため、
 * コピー先での変更がオリジナルに影響する（副作用）様子を確認します。
 */
public class DeepCopyTrap {

    public static void main(String[] args) {
        
        System.out.println("=== シャローコピーの実験 ===");

        // 1. オリジナルのリストを作る
        // 中身は「書き換え可能な文字列 (StringBuilder)」を入れる
        List<StringBuilder> originalList = new ArrayList<>();
        originalList.add(new StringBuilder("A"));
        originalList.add(new StringBuilder("B"));

        // 2. リストをコピーする
        // new ArrayList<>(originalList) は、
        // 「リストという外側の袋」は新しくなるが、中身の「StringBuilderの住所」は同じまま！
        List<StringBuilder> copyList = new ArrayList<>(originalList);

        System.out.println("変更前 オリジナル: " + originalList);
        System.out.println("変更前 コピー    : " + copyList);

        // 3. コピーした方のリストの、0番目の要素を書き換える
        // "A" という文字に "!!!" を追加してみる
        copyList.get(0).append("!!!");

        System.out.println("\n--- コピーの方だけ書き換えたつもり ---");

        // 4. 結果確認
        System.out.println("変更後 コピー    : " + copyList);
        // -> [A!!!, B] 当然変わっている

        System.out.println("変更後 オリジナル: " + originalList);
        // -> [A!!!, B] ！！！！なんと、オリジナルも変わってしまった！！！！
        
        System.out.println("\n【解説】");
        System.out.println("リストは別物になっても、中に入っている「参照（住所）」は共有されたままです。");
        System.out.println("これを「シャローコピー（浅いコピー）」と呼びます。");
        System.out.println("完全に切り離したい場合は、中身の要素一つ一つも new してコピーする必要があります（ディープコピー）。");
    }
}