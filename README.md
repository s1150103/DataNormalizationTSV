# DataNormalizationTSV

このプロジェクトは、TSV（タブ区切り値）ファイルを対象とした2つのプログラムを提供します。これらのプログラムは、データの第一正規化と逆正規化を行うためのものです。それぞれのプログラムはJavaで実装されており、LinuxおよびWindowsで動作します。

## 機能

1. **第一正規化 (First Normalization)**:
   - TSV形式のファイルを読み込み、コロン(`:`)で区切られた複数の値を持つセルを個別の行に展開します。
   - すべての出力はTSV形式で、正規化後のデータを出力します。
  
2. **逆正規化 (Reverse Normalization)**:
   - キーと値のペアからなるTSVファイルを読み込み、同じキーを持つ値をコロンで連結して1行にまとめます。
   - 出力フォーマットは第一正規化プログラムの入力形式に対応しています。

## 評価基準に基づく設計

### ソースコードの可読性
- ソースコードは適切にインデントすることで、誤読につながるインデントのミスがないように注意しています。
- 各関数および重要なコードブロックには、何を行うのか、何の目的で書かれているかを示すコメントを適切に追加しています。
- コマンドライン引数やファイル入出力の説明もコメントに記載しています。

### 入出力方法の設計
- ファイル入出力を採用しています。標準入力やネットワーク通信は使用していません。
- プログラムは2つの独立したJavaファイルとして設計されており、それぞれの機能に対応するコードを分離しています。

### 動作環境
- このプログラムは、WindowsおよびLinux環境で動作するように設計されています。Java 8以上のバージョンがインストールされていることが前提です。

## 使用方法javac ReverseFirstNormalization.java
java ReverseFirstNormalization

### 前提条件

- Java 8 以上
- Maven (オプション、ビルド管理に使用可能)
- 必要に応じて、プログラムがアクセスするディレクトリに対する読み書き権限

### ファイル構成

- `FirstNormalization.java`: 第一正規化を処理するプログラム。
- `ReverseFirstNormalization.java`: 逆正規化を処理するプログラム。
- `input.tsv`: サンプルの入力ファイル。
- `output.tsv`: 結果の出力ファイル。

### プログラムの実行方法

1. **第一正規化**:

   以下のコマンドで、第一正規化プログラムを実行します。

   ```bash
   javac FirstNormalization.java
   java FirstNormalization
   
2. **逆正規化**:
   以下のコマンドで、逆正規化プログラムを実行します。
   
  javac ReverseFirstNormalization.java 
  java ReverseFirstNormalization
