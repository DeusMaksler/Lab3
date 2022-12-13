import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab3_2 {
    public static void main(String[] args){
        Scanner scan2 = new Scanner(System.in);
        StringBuilder input_numbers = new StringBuilder();
        int size = 0;
        int x = 0;
        Pattern not_number = Pattern.compile("[\\D]");

        System.out.print("Массив: ");
        while (true){
            String console_line = scan2.next();
            if (console_line.equals("quit")) {
                break;
            } else {
                Matcher relevant = not_number.matcher(console_line); //обработка ввода недопустимых значений
                if (!relevant.find()) {
                    input_numbers.append(console_line).append("_"); // формируем строку со всеми введёнными элементами
                } else {
                    System.out.println("Ошибка, массив и число к удалению должны быть целыми");
                    System.exit(-1);
                }
            }
        }

        String[] input_array__string = input_numbers.toString().split("_"); //вспомогательный массив строк
        int n = input_array__string.length;
        int[] input_array__integer = new int[n];

        for (int i = 0; i < n; i++) {
            input_array__integer[i] = Integer.parseInt(input_array__string[i]); // получаем массив произвольного количества элементов
        }

        System.out.printf("\n Размерность массива: %d \n", n);
        System.out.print("Число к удалению: ");

        try { // обработка ошибки ввода
            x = scan2.nextInt();
        } catch (Exception e){
            System.out.println("Ошибка, массив и число к удалению должны быть целыми");
            System.exit(-1);
        }

        for (int el : input_array__integer) { //вычисляем размер искомого массива
            if (el != x){ size += 1;}
        }

        int[] changed_array = new int[size]; // формирование изменённого массива
        int index = 0;
        for (int current_element : input_array__integer) {
            if (current_element != x) {
                changed_array[index] = current_element;
                index += 1;
            }
        }

        System.out.printf("Исходный массив:%s\n", convert_to_string(input_array__integer));
        System.out.printf("Массив после обработки: %s", convert_to_string(changed_array));
    }

    private static String convert_to_string(int[] array) { // форматирование массива под заданный вид строки
        StringBuilder numbers__string = new StringBuilder();
        for(int number : array) {
            numbers__string.append(" ").append(number);
        }
        return numbers__string.toString();
    }
}
