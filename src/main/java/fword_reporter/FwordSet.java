package fword_reporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FwordSet {
    private static final Set<String> FWORDS = loadFwords();

    private static Set<String> loadFwords() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File("fwords.json"));
            JsonNode array = root.get("fwords");
            Set<String> result = new HashSet<>();
            for (JsonNode node : array) {
                result.add(node.asText());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Set.of();
        }
    }
    public List<String> searchFwords (String word) {
    	String normalized = WordMethods.normalizeText(word);
    	List<String> detectedFwords = new ArrayList<>();
        for (String rawFword : FWORDS) {
            String normalizedFword = WordMethods.normalizeText(rawFword);
            Pattern pattern = Pattern.compile(Pattern.quote(normalizedFword));
            Matcher matcher = pattern.matcher(normalized);
            while (matcher.find()) {
                detectedFwords.add(rawFword);
            }
        }
        return detectedFwords;
    }
}    