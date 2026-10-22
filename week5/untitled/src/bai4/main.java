package bai4;

import java.util.*;

public class main {

    public static String chuanHoa(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-z\\s]", " ");
        text = text.trim().replaceAll("\\s+", " ");
        return text;
    }

    public static ArrayList<String> demTuArrayList(String text) {
        ArrayList<String> list = new ArrayList<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            list.add(word);
        }

        return list;
    }

    public static HashMap<String, Integer> demTuHashMap(String text) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        return map;
    }

    public static void inArrayList(ArrayList<String> list) {
        System.out.println("ArrayList: " + list);
    }

    public static void inHashMap(HashMap<String, Integer> map) {
        System.out.println("HashMap: " + map);
    }

    public static void main(String[] args) {
        String text = "Hello world. This is a java program. "
                + "Hello java, hello world.";

        text = chuanHoa(text);

        ArrayList<String> list = demTuArrayList(text);
        HashMap<String, Integer> map = demTuHashMap(text);

        inArrayList(list);
        inHashMap(map);
    }
}
