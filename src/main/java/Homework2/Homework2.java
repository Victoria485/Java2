package Homework2;
public class Homework2
{
    public static void main(String[] args)
    {
        String[][] array =
                {
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "1"},
                        {"1", "1", "1", "a"},
                        {"1", "1", "1", "1"},
                };
        sumArray4x4(array);
    }
    private static void sumArray4x4(String[][] array)
    {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4) throw new MySizeArrayException("Массив должен быть размером 4х4");
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                try
                {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e)
                {
                    throw new MyArrayDataException("Невозможно преобразовать в int содержимое элемента массива с индексом " + i + " " + j);
                }
            }
        }
        System.out.println(sum);
    }
    public static class MySizeArrayException extends RuntimeException
    {
        public MySizeArrayException(String message)
        {
            super(message);
        }
    }
    public static class MyArrayDataException extends RuntimeException
    {
        public MyArrayDataException(String message)
        {
            super(message);
        }
    }
}