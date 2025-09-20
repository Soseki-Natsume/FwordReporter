[README.md](https://github.com/user-attachments/files/22439430/README.md)
# Fword Reporter 
Discord Bot
ユーザーの発言中に禁止用語を含む場合、ブブゥーーーーーー!!!!!!!と発し(無音、メッセージのみ)含まれていた禁止用語を教えてくれる。
元ネタはゲーム『ウーマンコミュニケーション』(元ネタの明記でありステルスマーケティング等のプロモーションではない)

## 使用技術
- Java 21
- [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA)
- [Jackson（JSON処理）](https://github.com/FasterXML/jackson)
- dotenv-java（環境変数管理）


## 使い方

1. `.envファイル`を作成し、あなたのDiscord Bot のトークンを記述

```
TOKEN=your_token
```
余計なスペースは要れない方がよい

2. `fwords.json`をプロジェクトルートに配置し、任意のFwordsを記述

```
{
  "fwords": [
    "ばか", "まぬけ", etc...
  ]
}
```

3. ビルドにはGradleを使用

```bash
./gradlew build
```

4. Bot 起動

```bash
./gradlew run
```

3,4は各自IDEからビルド、実行を行ってもよい
