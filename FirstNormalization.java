import java.io.*;
import java.util.*;

public class FirstNormalization {

    public static void main(String[] args) {
        // 入力ファイルと出力ファイルのパスを指定
        String inputFile = "input.tsv";
        String outputFile = "output.tsv";

        try {
            normalizeTSV(inputFile, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void normalizeTSV(String inputFilePath, String outputFilePath) throws IOException {
        // ファイルの読み込み用BufferedReaderを設定
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        // ファイルの書き込み用BufferedWriterを設定
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        String line;
        // ファイルの各行を読み込む
        while ((line = reader.readLine()) != null) {
            // タブで区切られた列を配列に変換
            String[] columns = line.split("\t");

            // 各列に対して処理を行う
            List<String[]> expandedRows = new ArrayList<>();
            expandedRows.add(new String[columns.length]); // 最初の行の雛形を追加

            for (int i = 0; i < columns.length; i++) {
                String[] values = columns[i].split(":"); // コロンで区切られた値のリストを取得

                List<String[]> newExpandedRows = new ArrayList<>();
                for (String value : values) {
                    for (String[] expandedRow : expandedRows) {
                        // 既存の行をコピーして新しい値を追加
                        String[] newRow = Arrays.copyOf(expandedRow, expandedRow.length);
                        newRow[i] = value.trim(); // 値を追加
                        newExpandedRows.add(newRow);
                    }
                }
                expandedRows = newExpandedRows; // 更新された行リストを反映
            }

            // 展開された行を出力
            for (String[] expandedRow : expandedRows) {
                writer.write(String.join("\t", expandedRow));
                writer.newLine();
            }
        }

        // リソースを閉じる
        reader.close();
        writer.close();
    }
}

