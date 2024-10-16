import java.io.*;
import java.util.*;

public class ReverseFirstNormalization {

    public static void main(String[] args) {
        // 入力ファイルと出力ファイルのパスを指定
        String inputFile = "input_reverse.tsv";
        String outputFile = "output_reverse.tsv";

        try {
            reverseNormalizeTSV(inputFile, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reverseNormalizeTSV(String inputFilePath, String outputFilePath) throws IOException {
        // ファイルの読み込み用BufferedReaderを設定
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        // ファイルの書き込み用BufferedWriterを設定
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        // キーごとに値をグループ化するためのMap
        Map<String, List<String>> map = new LinkedHashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] columns = line.split("\t");
            if (columns.length == 2) {
                String key = columns[0].trim();
                String value = columns[1].trim();

                // マップにキーがなければ初期化
                map.putIfAbsent(key, new ArrayList<>());

                // 値をリストに追加
                if (!value.isEmpty()) {
                    map.get(key).add(value);
                }
            }
        }

        // グループ化された結果を出力
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            String joinedValues = String.join(":", entry.getValue());
            writer.write(key + "\t" + joinedValues);
            writer.newLine();
        }

        // リソースを閉じる
        reader.close();
        writer.close();
    }
}

