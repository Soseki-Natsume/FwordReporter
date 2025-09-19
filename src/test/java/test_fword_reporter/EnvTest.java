package test_fword_reporter;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * トークン設定テスト
 */
public class EnvTest {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("TOKEN"));
    }
}
