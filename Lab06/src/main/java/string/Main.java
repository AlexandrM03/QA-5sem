package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
        String quote = "так, которые нарушают правила — плохие ниндзя, это Ниндзя. " +
                "хуже те, которые бросают друзей — гораздо Но";
        String[] sentences = quote.split("(?<=[.!?])");
        for (String str : sentences) {
            String newSentence = str.trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)", "$3$2$1$4");
            System.out.println(newSentence);
        }

        System.out.println("--------------------------------------------------");

        // В каждом предложении текста исключить подстроку максимальной длины,
        // начинающуюся и заканчивающуюся заданными символами.
        String text = "а+б а++б +а+++б+ ++а++++б++";
        String regexPattern = "(?<=а)\\S+(?=б)";
        Matcher matcher = Pattern.compile(regexPattern).matcher(text);
        int maxLength = 0;
        int startIndex = -1;
        int endIndex = -1;
        while (matcher.find()) {
            int length = matcher.end() - matcher.start();
            if (length > maxLength) {
                startIndex = matcher.start();
                endIndex = matcher.end();
            }
        }
        if (startIndex > 0)
            text = text.substring(0, startIndex) + text.substring(endIndex);
        System.out.println(text);

        System.out.println("--------------------------------------------------");

        // Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
        String[] messages = ("Не судите других просто из-за их предрассудков и не выносите " +
                "суждений на основе внешнего вида. Вы предположили, что у меня есть терпение. " +
                "Вы не смогли измерить свои способности и мои способности. " +
                "Следовательно, вы лежите здесь, побежденные.").split("[.;!?]");
        for (int i = 0; i < messages.length - 1; i++) {
            for (int j = i + 1; j < messages.length; j++) {
                if (messages[i].split(" ").length > messages[j].split(" ").length) {
                    String tmp = messages[i];
                    messages[i] = messages[j];
                    messages[j] = tmp;
                }
            }
        }
        for (String sentence: messages) {
            System.out.println(sentence.trim());
        }
    }
}
