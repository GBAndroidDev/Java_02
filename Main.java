/*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать сколько раз встречается каждое слово.

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании
(т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать
(в том числе Scanner), тестировать просто из метода main() прописывая add() и get().

'* Создать свой односвязный список. Добавить n элементов. Перевернуть его.
'** Создать свой интерфейс MultiMap и имлементировать его.
MultiMap {
void put(key1,key2, value);
//
value get(key1,key2)
}*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        uniqueWordsList();
        System.out.println();

        TelNumbersList telNumbersList = new TelNumbersList();
        telNumbersList.add("Garry","79115000000");
        telNumbersList.add("Garry","79115000001");
        telNumbersList.add("Sally","79125000000");
        telNumbersList.add("","79125000000");
        telNumbersList.get("Garry");
        telNumbersList.get("Sally");
        telNumbersList.get("Jane");
    }

    public static void uniqueWordsList() {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> uniqueList = new HashSet<>();
        list.add("Привет!");
        list.add("Привет!");
        list.add("как");
        list.add("дела");
        list.add("Все");
        list.add("нормально");
        list.add("нормально");
        list.add("Понедельник");
        list.add("Вторник");
        list.add("Вторник");
        list.add("Среда");
        for (String str: list) {
            uniqueList.add(str);
        }
        System.out.println(uniqueList.size() + ": " + uniqueList);
    }

    public static class TelNumbersList {
        private HashMap<String, HashSet<String>> mainList = new HashMap<String, HashSet<String>>();

        public void add(String name, String telNumber) {
            HashSet<String> telNumbers = new HashSet<>();
            if ((mainList.get(name) == null) && !name.isEmpty() && !telNumber.isEmpty()) {
                telNumbers.add(telNumber);
                mainList.put(name, telNumbers);
            } else if ((mainList.get(name) != null) && !name.isEmpty() && !telNumber.isEmpty()) {
                mainList.get(name).add(telNumber);
            } else {
                System.out.println("Введите корректные данные.");
            }
        }

        public void get(String name) {
            if (mainList.get(name) != null) {
                System.out.println(name +": " + mainList.get(name));
            } else {
                System.out.println("По вашему запросу ничего не найдено.");
            }

        }
    }
}
