package com.example.hello2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class BasicsController {

    //Starting with duplicate of Starting-JS but with Java and SpringSecurity
    @GetMapping("/add")
    public int add(@RequestParam int x, @RequestParam int y) {
        return x + y;
    }

    @GetMapping("/doubleThis")
    public int doubleThis(@RequestParam int x) {
        return x * 2;
    }

    @GetMapping("/multiplyByThree")
    public int multiplyByThree(@RequestParam int x, @RequestParam int y, @RequestParam int z) {
        return x * y * z;
    }

    // (int, int, int) -> int
    // Returns the total earnings provided the number of A, B, and C class seats sold.
    // important information:
    //     Class A seats cost $15.
    //     Class B seats cost $12.
    //     Class C seats cost $9.
    @GetMapping("/earnings")
    public int earnings(@RequestParam int x, @RequestParam int y, @RequestParam int z) {
        return x * 15 + y * 12 + z * 9;

    }
    // return True if both x and y are true
    @GetMapping("/both")
    public boolean both(@RequestParam boolean x, @RequestParam boolean y) {
        return x && y;
    }

    // (Int, Bool) -> String
    // Returns 'walk' if the user should walk
    // and 'drive' if the user should drive to their destination.
    // The user should walk if it is nice weather
    // and the distance is less than a quarter mile.
    @GetMapping("/walkOrDrive")
    public String walkOrDrive(@RequestParam float miles, @RequestParam boolean isNiceWeather) {
        if (miles < 0.25 && isNiceWeather) {
            return "walk";
        } else {
            return "drive";
        }
    }

    // Return 'Densely Populated' if the land density is greater than 100,
    // otherwise return 'Sparsely Populated'.
    @GetMapping("/howPopulated")
    public String howPopulated(@RequestParam double population, @RequestParam double landArea) {
        if (population / landArea > 100) {
            return "Densely Populated";
        } else {
            return "Sparsely Populated";
        }
    }

    // Int -> String
    // Return the appropriate number of stars for the users score.
    // 1 stars for scores less than 1000 points
    // 2 stars for scores less than 5000 points
    // 3 stars for scores less than 8000 points
    // 4 stars for scores less than 10000 points
    // 5 stars for anything 10000+
    @GetMapping("/stars")
    public String stars(@RequestParam int points) {
        if (points < 1000) {
            return "*";
        } else if (points < 5000) {
            return "**";
        } else if (points < 8000) {
            return "***";
        } else if (points < 10000) {
            return "****";
        } else if (points > 10000) {
            return "*****";
        } else {
            return null;
        }
    }

    // (String) -> Int
    // Returns the number of points for the corresponding
    // scoring action in American football.
    // An extra point kick is worth 1 point.
    // An extra point conversion is worth 2 points.
    // A safety is worth 2 points.
    // A field goal is worth 3 points.
    // A touchdown is worth 6 points.
    @GetMapping("/footballPoints")
    public int footballPoints(@RequestParam String scoringAction) {
        if (scoringAction.equals("eKick")) {
            return 1;
        } else if (scoringAction.equals("eConv")) {
            return 2;
        } else if (scoringAction.equals("safety")) {
            return 2;
        } else if (scoringAction.equals("fg")) {
            return 3;
        } else if (scoringAction.equals("td")) {
            return 6;
        } else {
            return 0;
        }
    }
}
