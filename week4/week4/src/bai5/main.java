package bai5;

import org.w3c.dom.DOMImplementation;

import java.security.PublicKey;

class Pair<K, V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }

    public K getKey() {
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setKey(K key){
        this.key=key;
    }
    public void setValue(V value){
        this.value=value;
    }
    @Override
    public String toString(){
        return key+" - "+value;
    }
}

public class main {
    public static void main(String[] args){
        Pair<String, Integer> pair1 = new Pair<>("Tuoi",20);
        Pair<String, String> pair2 = new Pair<>("Ma SV","SV001");
        Pair<Integer, Double> pair3 = new Pair<>(105,21.5);
        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);
    }
}
