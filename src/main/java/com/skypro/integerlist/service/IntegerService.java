package com.skypro.integerlist.service;
import com.skypro.integerlist.exception.*;
import java.util.Arrays;

public class IntegerService implements IntegerList{
    private final Integer[] integers;
    private int size;

    public IntegerService(int size) {
        this.integers = new Integer[size];
    }


    @Override
    public Integer add(Integer item) {
        if (size >= integers.length) {
            throw new FullListException("Массив заполнен.");
        }
        if (item == null) {
            throw new InCorrectElementException("Вы ввели пустую строку");
        }
        integers[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= integers.length || index > size){
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        if (size == integers.length) {
            throw new FullListException("Массив заполнен.");
        }
        integers[index] = item;
        return integers[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index > size || index > integers.length) {
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        integers[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new InCorrectElementException("Вы ввели пустую строку");
        }
        if (indexOf(item) == -1) {
            throw new NotElementException("Элемент не найден");
        }
        if (indexOf(item) != size) {
            System.arraycopy(integers, indexOf(item) + 1,integers, indexOf(item), size - indexOf(item));
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index == -1){
            throw new NotElementException("Элемент не найден");
        }
        Integer item = integers[size];
        if (index != size){
            System.arraycopy(integers, index + 1,integers, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size -1; i >= 0; i--) {
            if (integers[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= integers.length || index > size) {
            throw new ExceedsLengthException("Выходит за пределы массива");
        }
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new EmptyListException("Пустой массив");
        }
        if (this.size == otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!integers[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return integers[0] == null;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(integers, size);
    }
}
