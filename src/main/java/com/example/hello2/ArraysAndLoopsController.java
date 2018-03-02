package com.example.hello2;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.*;
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


    // Returns the hashtags used in the provided tweet.
    @GetMapping("/hashtags")
    public ArrayList<String> hashtags(@RequestParam String tweet) {
        String[] words = tweet.split("\\s");
        ArrayList<String> result = new ArrayList<>();
        for (String t : words) {
            if (t.contains("#")) {
                result.add(t);
            }
        }
        return result;
    }

    // Returns the mentions used in the provided tweet.
    @GetMapping("/mentions")
    public ArrayList<String> mentions(@RequestParam String tweet) {
        String[] words = tweet.split("\\s");
        ArrayList<String> result = new ArrayList<>();
        for (String t : words) {
            if (t.contains("@")) {
                result.add(t);
            }
        }
        return result;
    }


    // String -> Item
    // Return an inventory item encoded in the provided string.
    // An Item is a array of 3 elements:
    //     - name
    //     - price we paid
    //     - price we are charging
    // The provided string seperates each of these pieces with a tab.
    @GetMapping("/parseInventoryString")
    public ArrayList<String> parseInventoryString(@RequestParam String s) {
        String[] words = s.split("\\s");
        ArrayList<String> result = new ArrayList<>();
        for (String t : words) {
            result.add(s);
        }
        return result;
    }
}