package fword_reporter;

import java.util.Set;

public class FwordSet {
    public static final Set<String> FWORDS = Set.of("何か","良くない","言葉","例えば","バカ");
    public String searchFword (String word) {
        for (String fword : FWORDS) {
            if (word.equals(fword)) {
                return fword;
            }
        }
        return "";
    }
}    