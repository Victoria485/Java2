package Homework3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class Homework3
{
    public static void main(String[] args)
    {
        listExample();
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Петров", "8-800-555-35-35");
        phoneDirectory.add("Иванов", "8-800-555-35-36");
        phoneDirectory.add("Сидоров", "8-800-555-35-37");
        phoneDirectory.add("Козлов", "8-800-555-35-38");
        phoneDirectory.add("Иванов", "8-800-555-35-39");
        phoneDirectory.add("Иванов", "8-800-555-35-40");
        phoneDirectory.get("Иванов");
        phoneDirectory.get("Петров");
    }
    private static void listExample()
    {
        List<String> list = new ArrayList<>();
        list.add("Январь");
        list.add("Февраль");
        list.add("Март");
        list.add("Апрель");
        list.add("Май");
        list.add("Январь");
        list.add("Январь");
        list.add("Январь");
        list.add("Май");
        List<String> listWithoutDuplicates = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);
        System.out.println(listWithoutDuplicates);
        System.out.println("Всего дублей удалено: " + (list.size() - listWithoutDuplicates.size()));
        for (int i = 0; i < listWithoutDuplicates.size(); i++)
        {
            int freq = Collections.frequency(list, list.get(i));
            System.out.println("Слово \"" + list.get(i) + "\" встречается в списке "+ freq + " раз(a)");
        }
    }
}