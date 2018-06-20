// Задача 2
// Создать англо-русский словарь. Пользователь вводит слово. Если слово есть в словаре, то на экран выводится
//перевод слова. Если слова в словаре нет, то появляется надпись “Слово отсутствует в словаре. Хотите добавить?”.
//Если ответ “да”, то пользователь вводит перевод слова, и оно добавляется в словарь.
//При последующем вводе этого слова программа выдаст введенный ранее перевод.
//Словарь работает, пока пользователь не введет ключ выхода.

package qa.workshops;

import java.util.*;

public class Dictionary {

    public void dictionaryWithHashMap() {
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("Apple", "Яблоко");
        dictionary.put("Apricot", "Абрикос");
        dictionary.put("Orange", "Апельсин");
        dictionary.put("Banana", "Банан");
        dictionary.put("Pineapple", "Ананас");

        Scanner scanner = new Scanner(System.in);

        char wantToContinue;
        String word;

        do {
            System.out.println("Напишите слово для поиска в словаре:");

            word = String.valueOf(scanner.next());
            if (dictionary.containsKey(word))
                System.out.println(dictionary.get(word));
            else {
                System.out.println("Слово отсутствует в словаре. Хотите добавить?");
                System.out.println("Вы хотите его добавить? y - Да, n - Нет");
                wantToContinue = scanner.next().charAt(0);

                if (wantToContinue == 'Y' || wantToContinue == 'y') {
                    System.out.print("Введите перевод: ");
                    String translation = scanner.next();

                    dictionary.put(word, translation);
                    System.out.println(dictionary);
                }
            }

            System.out.println("Вы хотите продолжить? y - Да, n - Нет");
            wantToContinue = scanner.next().charAt(0);
        }
        while (wantToContinue == 'Y' || wantToContinue == 'y');

        System.out.println("Спасибо за просмотр! ");
    }
}




