/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jakata
 */
public class DictionaryTest {

    public static void main(String[] args) {
        String sentence = "I want to be a better programmer";
        Map<Character, Integer> dictionary = new HashMap<>();
        for (Character ch : sentence.toCharArray()) {
            dictionary.putIfAbsent(ch, 0);
            dictionary.put(ch, dictionary.get(ch) + 1);
        }
        dictionary.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(System.out::println);
    }

}
