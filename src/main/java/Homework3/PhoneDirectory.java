package Homework3;
import java.util.ArrayList;
import java.util.List;
public class PhoneDirectory
{
    List<String> surnameList = new ArrayList<>();
    List<String> phoneList = new ArrayList<>();
    public void add(String surname, String phone)
    {
        surnameList.add(surname);
        phoneList.add(phone);
    }
    public void get(String surname)
    {
        for (int i = 0; i < surnameList.size(); i++)
        {
            if (surnameList.get(i).equals(surname))
            {
                System.out.println(surname + ":" + phoneList.get(i));
            }
        }
    }
}