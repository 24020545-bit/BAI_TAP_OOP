package bai3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class main {
    public static String chuanHoa(String s){
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z\\s]","");
        return s;
    }
    public static HashMap<String,Integer> demTu(String text) {
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
    public static void SX_TK(HashMap<String,Integer> map){
        List<String> list = new ArrayList<>();
        String maxWord = "";
        int maxCount=0;
        for(String word: map.keySet()){
            if(map.get(word)==1){
                list.add(word);
            }
            if(map.get(word)>maxCount){
                maxCount = map.get(word);
                maxWord=word;
            }
        }
        System.out.println("Tu xuat hien nhieu nhat: "+maxWord);
        System.out.println("Cac tu xuat hien dung mot lan: "+list);
    }
    public static void main(String[] args) {
        String text = """
                Java is a popular programming language.
                Java is used to build many applications.
                Programming with Java is interesting.
                Many students learn Java and programming.
                """;

        text = chuanHoa(text);

        HashMap<String, Integer> map = demTu(text);
        SX_TK(map);
    }
}

