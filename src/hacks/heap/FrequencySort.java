package hacks.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

// https://leetcode.com/problems/sort-characters-by-frequency/
// https://leetcode.com/problems/top-k-frequent-elements/
// https://leetcode.com/problems/top-k-frequent-words/

public class FrequencySort {

    public static void main(String[] args) {
        var fc = new FrequencySort();
        var res = fc.frequencySort("tree");
        System.out.println(res); // eert
    }

    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        var arr = s.toCharArray();
        for (var c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        var pq = new PriorityQueue<Pair>();
        for (var entry : map.entrySet()) {
            var pair = new Pair(entry.getKey(), entry.getValue());
            pq.add(pair);
        }
        var builder = new StringBuilder();
        while (pq.size() > 0) {
            var pair = pq.poll();
            for (int i = 0; i < pair.value; i++) {
                builder.append(pair.key);
            }
        }
        return builder.toString();
    }
}

class Pair implements Comparable<Pair> {
    char key;
    int value;

    Pair(char key, int value) {
        this.key = key;
        this.value = value;
    }

    // Internally the sort method does call Compare method of the classes it is sorting.
    // To compare two elements, it asks “Which is greater?”
    // Compare method returns -1, 0, or 1 to say if it is less than, equal, or greater to the other.
    // It uses this result to then determine if they should be swapped for their sort.
    // By changing the return value inside the compare method, you can sort in any order that you wish to.
    // For example: For descending order just change the positions of instances.

    @Override
    public int compareTo(Pair p) {
        return p.value - this.value;
    }
}

// If you can't modify the class which you are using for comparison than you can create a comparator class
// and implement Comparator interface there and use that for sorting
// class SomeComparator implements Comparator<SomeClass> {
//    public int compare(SomeClass a, SomeClass b) {
//        return a.property.compareTo(b.property);
//    }
//}