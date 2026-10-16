package bai6;

import java.util.Arrays;

class  ArrayUtils{
    public static <T> void swap(T[] array, int i, int j){
        T a = array[i];
        array[i]=array[j];
        array[j]=a;
    }
    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i=0; i< array.length; i++){
            for(int j=1; j< array.length-i; j++){
                if(array[j-1].compareTo(array[j])>0){
                    swap(array,i,j);
                }
            }
        }
    }
}

public class main {
    public static void main(String[] args){
        Integer[] arrInt = {5,1,3,2};
        String[] arrSt = {"Java","C++","Python"};
        ArrayUtils.sort(arrInt);
        System.out.println(Arrays.toString(arrInt));
        ArrayUtils.sort(arrSt);
        System.out.println(Arrays.toString(arrSt));
    }
}
