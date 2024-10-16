# DataNormalizationTSV

このプロジェクトは、TSV（タブ区切り）ファイルを扱う2つのJavaプログラムを提供します。データの第一正規化および逆変換を行うことで、一貫性のあるデータ形式を実現します。キーと値のデータを扱い、正規化と非正規化の両方に対応しています。

## 機能

1. **第一正規化**: 
   - TSVファイルを読み込み、セル内の値がコロンで区切られている場合、それを分割して複数の行に展開します。
   - 出力もTSV形式です。

2. **逆正規化**: 
   - キーと値のペアからなるTSVファイルを読み込み、同じキーを持つ値をコロン(`:`)で連結してグループ化します。
   - 出力された形式は、第一正規化プログラムの入力形式と互換性があります。

## はじめに

### 前提条件

- Java 8 以上
- Maven (オプション、ビルド管理に使用可能)

### ファイル構成

- `FirstNormalization.java`: 第一正規化を処理するプログラム。
- `ReverseFirstNormalization.java`: 逆正規化を処理するプログラム。
- `input.tsv`: プログラムで使用するサンプル入力ファイル。

### プログラムの実行方法

1. **第一正規化**:

   以下のコマンドで、第一正規化プログラムを実行します。
   ```bash
   javac FirstNormalization.java
   java FirstNormalization
1. **逆正規化**:

以下のコマンドで、逆正規化プログラムを実行します。
   ```bash
   javac ReverseFirstNormalization.java
   java ReverseFirstNormalization

