package test_fword_reporter;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FwordsJsonDuplicateCheckTest {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("fwords.json"));
            JsonNode array = root.get("fwords");
            Set<String> uniqueWords = new HashSet<>();
            boolean hasDuplicates = false;
            for (JsonNode node : array) {
                String word = node.asText();
                if (!uniqueWords.add(word)) {
                    System.out.println("重複検出: " + word);
                    hasDuplicates = true;
                }
            }
            if (!hasDuplicates) {
                System.out.println("重複なし");
            }
        } catch (Exception e) {
            System.err.println("エラー: " + e.getMessage());
        }
    }
}

