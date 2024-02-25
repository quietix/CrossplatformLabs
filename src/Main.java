// 8. Видалити в тексті всі символи або послідовності символів, які не є
// словами: керуючі символи (зі слешем), числа, знаки пунктуації, зайві
// пробіли, абзацні відступи. Слова у маркованих та нумерованих списках
// вивести у рядок з комами між ними.

import java.util.regex.*;

public class Main {

    public static String replaceAllExceptFirst(String text, String regex, String replacement) {
        String replacedText = text.replaceAll(regex, replacement);
        replacedText = replacedText.replaceFirst(replacement, " ");
        return replacedText;
    }

    public static String processText(String text) {
        String cleanedText = text.replaceAll("[\\\\()#$%&,^]", "");
        cleanedText = replaceAllExceptFirst(cleanedText, "\n(\\s*[*-]) ", ", ");
        cleanedText = replaceAllExceptFirst(cleanedText, "\n(\\s*[0-9].) ", ", ");
        cleanedText = cleanedText.replaceAll("[0-9:;!?*-]", "");
        cleanedText = cleanedText.replaceAll("\\s+", " ");

        return cleanedText;
    }

    public static void main(String[] args) {
        System.out.println("КП-11, Защик Іван, Варіант 8");
        String text = """
                За допомогою нашого інструменту для заповнення тексту , окрім налаштування тексту за допомогою HTML -елементів , у вас є можливість створити новий, починаючи безпосередньо з тексту!
                         
                         Таким чином ви уникнете індексування веб -сайту за допомогою ключових слів , що містяться в класичному Lorem Ipsum.
                         Деякий список:
                         1. Предмет1;
                         2. Предмет2!
                         3. Предмет,123,)
                         
                         За допомогою інструменту Lorem Ipzum , ви можете вставляти тексти безпосередньо з ключовими словами, які слугуватимуть для індексування вашого веб -сайту. Спробуйте!""";
        System.out.println(text + "\n");
        System.out.println("-----------------------" + "\n");

        String processedText = processText(text);

        System.out.println(processedText);
    }
}
