import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab3_3 {
    public static void main(String[] args) {
        StringBuilder answer_string = new StringBuilder();
        Scanner scan3 = new Scanner(System.in);
        Pattern splitter = Pattern.compile("[^_]+");
        int count = 0;
        int capacity = 0;

        System.out.print("Размерность массива: ");
        try {
            capacity = scan3.nextInt();
        } catch (Exception e) {
            System.out.println("Ожидался ввод целого значения");
            System.exit(-1);
        }

        double[] source_array = new double[capacity];

        System.out.print("Массив: ");
        for (int i = 0; i < capacity; i++) {
            try {
                source_array[i] = scan3.nextDouble();
            } catch (Exception err) {
                System.out.println("Ожидался ввод числового значения");
                System.exit(-1);
            }
        }
        scan3.close();

        double last_value = source_array[0];

        for (double thing : source_array) {
            if (last_value <= thing) {
                answer_string.append(thing).append("_");
                last_value = thing;
                count += 1;
            }
        }

        double[] sorted_array = new double[count];
        Matcher valid = splitter.matcher(answer_string.toString());

        int j = 0;
        while (valid.find()){
            sorted_array[j] = Double.parseDouble(valid.group());
            j++;
        }

        System.out.printf("Исходный массив: %s\n", format_arrays(source_array));
        System.out.printf("Массив после обработки: %s", format_arrays(sorted_array));
    }

    private static String format_arrays(double[] insert_array) {
        StringBuilder result_string = new StringBuilder();
        for (double item : insert_array) {
            result_string.append(item).append(", ");
        }

        int last = result_string.length() - 1;
        result_string.replace(last-1, last + 1, "");

        return result_string.toString();
    }
}
