package Lesson_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 2, 7, 3, 5, 6, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int pivot = arr[arr.length - 1];

        ArrayList<ArrayList<Number>> arrays = new ArrayList<ArrayList<Number>>(Arrays.asList(new ArrayList<>(Arrays.asList(pivot))));
        ArrayList<Number> leftArray = new ArrayList<Number>();
        ArrayList<Number> rightArray = new ArrayList<Number>();;

        for (int item: arr) {
            if (item < pivot) {
                leftArray.add(item);
            } else if (item > pivot) {
                rightArray.add(item);
            }
        }

        arrays.addFirst((ArrayList<Number>) leftArray.clone());
        arrays.addLast((ArrayList<Number>) rightArray.clone());

        int i = 0;
        ArrayList currentList;
        int add;

        do {
            add = 0;
            currentList = arrays.get(i);
            if (currentList.size() != 1) {
                int currPivot = (int) currentList.getLast();
                leftArray = new ArrayList<>();
                rightArray = new ArrayList<>();
                for (int j = 0; j < currentList.size(); j++) {
                    int item = (int) currentList.get(j);
                    if (item < currPivot) {
                        leftArray.add(item);
                    } else if (item > currPivot) {
                        rightArray.add(item);
                    }
                }
                arrays.set(i, new ArrayList<Number>(List.of(currPivot)));
                if (leftArray.size() > 0) {
                    arrays.add(i, (ArrayList<Number>) leftArray.clone());
                    add = 1;
                }
                if (rightArray.size() > 0) {
                    arrays.add(i + 1 + add, (ArrayList<Number>) rightArray.clone());
                }
            } else {
                i++;
            }
            System.out.println(arrays);
            System.out.println(i);
        } while (i < arr.length);

        for (int j = 0; j < arr.length; j++) {
            arr[j] = (int) arrays.get(j).getFirst();
        }
    }
}
