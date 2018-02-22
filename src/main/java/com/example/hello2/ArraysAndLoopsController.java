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
    }