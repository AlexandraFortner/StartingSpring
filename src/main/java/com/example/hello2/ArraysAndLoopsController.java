package com.example.hello2;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.*;


@RestController
public class ArraysAndLoopsController {

    // Returns the last three elements in L.
    @GetMapping("/lastThree")
    public ArrayList<String> lastThree(@RequestParam String x) {
        String[] words = x.split("\\s");
        String[] lastThree;
        lastThree = Arrays.copyOfRange(words, words.length - 3, words.length);
        ArrayList<String> list = new ArrayList<>();
        for (String w : lastThree) {
            list.add(w);
        }
        return list;
    }

    // Returns the sum of everything in L.
    @GetMapping("/sum")
    public Integer sum(@RequestParam int[] l) {
        int total = 0;
        for (int i : l) total += i;
            return total;
        }

    // Returns the sum of the longer Array.
    // If both Arrays are the same length, returns the sum of both Arrays.
    @GetMapping("/sumOfLonger")
    public Integer sumOfLonger(int[] l1, int[] l2) {
        if (l1.length > l2.length){
            return sum(l1);
        } else if (l1.length < l2.length){
            return sum(l2);
        } else if (l1.length == l2.length){
            return sum(l1) + sum(l2);
        } else {
            return null;
        }
    }


    // Array[Float] -> Array[Float]
    // Returns the difference between each cost and the minimum cost.
    //
    // For example, if our options were [1, 3, 3, 2, 5].
    // The minimum cost would be 1, and the differences from that
    // minimum would be [0, 2, 2, 1, 4]
    @GetMapping("/differenceFromMiniumum")
    public ArrayList<Double> Min (@RequestParam String x) {
        String[] List = x.split("\\s");
        ArrayList<Double> num_list = new ArrayList<>();
        for(String num : List) {
            num_list.add(Double.parseDouble(num));
        }
        double minimum = Collections.min(num_list);
        ArrayList<Double> new_list = new ArrayList<>();
        for (double numbers: num_list) {
            new_list.add(numbers - minimum);
        } return  new_list;
    }
}