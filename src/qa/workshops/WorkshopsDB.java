//Задача 1.
// Создать программу, которая будет имитировать базу данных воркшопов.
//Программа позволяет: просмотреть все воркшопы, добавить новый воркшоп, удалить существующий,
//вывести воркшопы определенного автора, найти воркшоп с максимальной посещаемостью.
//Воркшоп хранит следующие данные: дата, тема, автор, количество присутствующих.

package qa.workshops;

import java.util.*;

public class WorkshopsDB extends Workshop{

  public void workshopsWithArrayList(){

    ArrayList<Workshop> workshops = new ArrayList<>();

    workshops.add(new Workshop("10.10.2017", "Влияние отца во время становления личности", "Джон Сноу", 5));
    workshops.add(new Workshop("12.07.2018", "Честность - лучшая политика?", "Эддард Старк", 8));
    workshops.add(new Workshop("07.05.2018", "Роль матери в управлении государством", "Кэйтилин Старк", 11));
    workshops.add(new Workshop("12.10.2017", "Тонкости организации свадеб", "Уолдер Фрей", 6));
    workshops.add(new Workshop("11.07.2018", "Как выйти замуж по расчету", "Серсея Ланнистер", 14));

    showWorkshops(workshops);

    Scanner scanner = new Scanner(System.in);

      do {
      System.out.println("Выберите действие: " +
              "\n 1 - Посмотреть все воркшопы, 2 - Добавить новый, 3 - Удалить выбранный, 4 - Поиск по автору, 5 - Отобразить по количеству посетителей");
      try {
        sign = scanner.nextInt();
      } catch (InputMismatchException ex) {
        System.out.println(ex.toString());
      }

      switch (sign) {
        case 1:
          System.out.println(workshops);
          break;
        case 2:
            addWorkshop(workshops, scanner);
          break;
        case 3:
            removeAuthor(workshops, scanner);
          break;
        case 4:
            searchAuthor(workshops, scanner);
          break;
        case 5:
          System.out.println("Сортировка по возрастанию: ");
          Collections.sort(workshops);
          break;
      }
      System.out.println("Вы хотите продолжить? y - Да, n - Нет");
      wantToContinue = scanner.next().charAt(0);
    }
    while (wantToContinue == 'Y' || wantToContinue == 'y');

    System.out.println("Спасибо за просмотр! ");
  }

    private void searchAuthor(ArrayList<Workshop> workshops, Scanner scanner) {
        System.out.println("Введите имя автора воркшопа для поиска");
        String search = scanner.next();
        if(workshops.contains(search)){
          System.out.println("Вот и результат" + search);
        }else
          System.out.println("Упс! Поиск не дал результатов :-(");
    }

    private void removeAuthor(ArrayList<Workshop> workshops, Scanner scanner) {
        System.out.println("Введите имя автора для удаления воркшопа");
        String author = scanner.next();
        workshops.remove(author);
    }

    private void addWorkshop(ArrayList<Workshop> workshops, Scanner scanner) {
        System.out.println("Введите дату проведению воркшопа");
        String date = scanner.next();
        System.out.println("Введите название воркшопа");
        String title = scanner.next();
        System.out.println("Введите имя автора воркшопа");
        String author = scanner.next();
        System.out.println("Введите количество посетителей воркшопа");
        int visitors = scanner.nextInt();

        //
        Workshop w1 = new Workshop(date, title, author, visitors);
        workshops.add(w1);
        System.out.println("Новый воркшоп успешно добавлен!");
        System.out.println(workshops);
    }

}

 
