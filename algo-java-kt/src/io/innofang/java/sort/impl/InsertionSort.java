package io.innofang.java.sort.impl;

import io.innofang.java.sort.ISort;
import io.innofang.java.utils.comparator.Comparator;

/**
 * Created by Inno Fang on 2017/3/30.
 */
public class InsertionSort extends ISort {

    public InsertionSort(Comparator comparable) {
        super(comparable);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T temp = arr[i];
            int j; // save the location where the element temp should be inserted.
            for (j = i; j > 0 && comparator.lessThan(temp, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
