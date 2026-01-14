package Lesson_4;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        System.out.println("Неотсортированный массив: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1); // начальные границы массива первый и последний элемент
        System.out.println("Отсортированный массив: " + Arrays.toString(array));;

        int[] array1 = {17};
        System.out.println("Неотсортированный массив: " + Arrays.toString(array1));
        quickSort(array1, 0, array1.length - 1); // начальные границы массива первый и последний элемент
        System.out.println("Отсортированный массив: " + Arrays.toString(array1));;

        int[] array2 = {1, 5, 4, 3, 7};
        System.out.println("Неотсортированный массив: " + Arrays.toString(array2));
        quickSort(array2, 0, array2.length - 1); // начальные границы массива первый и последний элемент
        System.out.println("Отсортированный массив: " + Arrays.toString(array2));;

    }

    static void quickSort(int[] arr, int l, int h) {

        // если массива нет, он пустой или состоит из одного элемента, то сортировать нечего
        if (arr == null || arr.length == 0 || l >= h)
            return;

        // хранить границы неотсортированных частей массива будем в стеке
        Stack stack = new Stack<>();
        // помещаем в стек начальные границы массива
        stack.push(l);
        stack.push(h);

        // цикл выполняется до тех пор, пока есть неотсортированные части массива
        while (!stack.isEmpty()) {
            // извлекаем границы из стека
            h = (int) stack.pop();
            l = (int) stack.pop();

            // перераспределяем элементы массива так, что элементы больше опорного будут справа от него, а элементы
            // меньше - слева. При этом получаем индекс опорного элемента, который получился в результате перераспределения
            int pivotIndex = partition(arr, l, h);

            // если слева от опорного элемента больше одного элемента, то эти элементы надо отсортировать
            if (pivotIndex - 1 > l) {
                // левая граница остаётся без изменений
                stack.push(l);
                // правая граница начинается сразу перед опорным элементом
                stack.push(pivotIndex - 1);
            }

            // если справа от опорного элемента больше одного элемента, то эти элементы надо отсортировать
            if (pivotIndex + 1 < h) {
                // левая граница начинается сразу после опорного элемента
                stack.push(pivotIndex + 1);
                // правая граница остаётся без изменений
                stack.push(h);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // в качестве опорного элемента возьмём последний
        int pivot = arr[high];

        // фиксируем индекс, который будет использоваться для помещения сюда элемента меньшего, чем опорный
        int i = low;

        // проходим во всем элементам, кроме опорного
        for (int j = low; j < high; j++) {
            // если элемент меньше опорного, то перемещаем его на место i
            // при этом не забываем увеличивать i, чтобы слева от этого индекса оставались элементы меньше опорного
            // если мы наткнемся на элемент больше опорного, то i останется на месте и будет хранить индекс элемента
            // большего, чем опорный
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // не забываем о том, чтобы поместить опорный элемент сразу после элементов меньше него
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        // возвращаем индекс опорного элемента
        return i;
    }
}
