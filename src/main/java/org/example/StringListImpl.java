package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.ItemIsNullException;
import org.example.exceptions.ItemNotFoundExeption;
import org.example.exceptions.StorageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] strings;
    private int size;

    public StringListImpl() {
        strings = new String[10];
    }
    public StringListImpl(int initSize) {
        strings = new String[initSize];
    }

    @Override
    public String add(String item) {
        nullChek(item);
        sizeChek();
        strings[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        sizeChek();
        indexChek(index);
        nullChek(item);
        if(size != 0) {
            for (int i = size - 1; i <= index; i--) {
                strings[i + 1] = strings[i];
            }
        }
        strings[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        indexChek(index);
        nullChek(item);
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) throws ItemNotFoundExeption {
        nullChek(item);
        int index = indexOf(item);
        if(index == -1){
            throw new ItemNotFoundExeption();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        indexChek(index);
        String result = strings[index];
        for (int i = index; i < size - 1; i++) {
            strings[i] = strings[i + 1];
        }
        size--;
        return result;
    }

    @Override
    public boolean contains(String item) {
        nullChek(item);
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        nullChek(item);
        for (int i = 0; i < size; i++) {
            if(strings[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0 ; i--) {
            if(strings[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        indexChek(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(strings, size);
    }


    public void nullChek(String item) throws ItemIsNullException {
        if(item == null) {
            throw new ItemIsNullException();
        }
    }
    public void sizeChek() throws StorageIsFullException{
        if(size == strings.length) {
            throw new StorageIsFullException();
        }
    }
    public void indexChek(int index) throws InvalidIndexException{
        if(index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }
}
