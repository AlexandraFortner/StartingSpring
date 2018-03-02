package com.example.hello2;
import java.util. *;
//import package.ArraysAndLoopsController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Objects {
    @GetMapping("/readInventory")
    public HashMap<String, item> readInventory(@RequestParam String inventory) {
        if (inventory.equals("")) {
            HashMap empty = new HashMap();
            return empty;
        }
        String[] splitOnNewLine = inventory.split("\n");
        HashMap<String, item> entry = new HashMap();
        for (int i = 0; i < splitOnNewLine.length; i++) {
            String[] splitOnNewTab = splitOnNewLine[i].split("\t");
            String productName = splitOnNewTab[0];
            double paid = Double.parseDouble(splitOnNewTab[1]);
            double charging = Double.parseDouble(splitOnNewTab[2]);
            item items = new item(productName, paid, charging);
            entry.put(productName, items);
        }
        return entry;
    }

    @PostMapping("/isDollarStore")
    public boolean isDollarStore(@RequestBody HashMap<String, item> inventory) {
        for (item i : inventory.values()){
            if (i.charged > 1) {
                return false;
            }
        }
        return true;
    }

//    @GetMapping("/arrayEquals")
//    public boolean arrayEquals(l, r) {
//        if (l.length !== r.length) return false;
//        for (var i = l.length; i--;) {
//            if (l[i] !== r[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @GetMapping("/movie")
//    public  Movie(title, director, genre, cast) {
//        this.title = title;
//        this.director = director;
//        this.genre = genre;
//        this.cast = cast;
//        this.toString = function toString() {
//            return [
//            'Title: ' + this.title,
//                    'Director: ' + this.director,
//                    'Genre: ' + this.genre,
//                    'Cast:',
//                    this.cast
//                            .map(function (c) {
//                return '- ' + c;
//            })
//                .join('\n')
//        ].join('\n');
//        };
//        this.equals = function equals(other) {
//            return this.toString() === other.toString();
//        };
//    }
//    @GetMapping("/fmdb")
//    public ArrayList<> FMDB(movies) {
//        this.movies = movies;
//        this.moviesByCastMember = function moviesByCastMember(member) {
//            var list = [];
//            for (i = 0; i < this.movies.length; i++) {
//                if (this.movies[i].cast.includes(member)) {
//                    list.push(this.movies[i]);
//                }
//            }
//            return list;
//        };
//    @GetMapping("/arrayEquals")
//        this.moviesByDirector = function moviesByDirector(director) {
//            var list = [];
//            for (i = 0; i < this.movies.length; i++) {
//                if (this.movies[i].director == director) {
//                    list.push(this.movies[i]);
//                }
//            }
//            return list;
//        };
}
