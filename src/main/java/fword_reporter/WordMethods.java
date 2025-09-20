package fword_reporter;

public class WordMethods {
	/**
	 * カタカナをひらがなにする
	 */
	private static String toHiragana(String input) {
	    StringBuilder hiragana = new StringBuilder();
	    for (char c : input.toCharArray()) {
	        if (c >= 'ァ' && c <= 'ン') {
	            hiragana.append((char)(c - 'ァ' + 'ぁ')); 
	        } else {
	            hiragana.append(c);
	        }
	    }
	    return hiragana.toString();
	}
	/**
	 * 句読点、記号を除去
	 */
	public static String normalizeText(String input) {
	    String hiragana = toHiragana(input);
	    return hiragana.replaceAll("[。、！？・（）［］｛｝「」『』…―ー\\-\\+\\*/\\^\\$@#%&=~|<>]", "");
	}
}
