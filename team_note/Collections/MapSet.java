// No duplicated. Unordered
// Only judges the existence of data
class HashSetTest {
    public HashSetTest(){
        HashSet<Integer> set = new HashSet<>();
        set.add(10);                            // O(1)
        System.out.println(set.contains(10));   // O(1)
    }
}

// No duplicated. Unordered
// store {key : value} data
class HashMapTest {
    HashMap<String, Integer> map = new HashMap<>();

    public HashMapTest(String[] books) {
        for(String book : books){
            if(map.containsKey(book)){              // O(1)
                map.replace(book, map.get(book)+1); // O(1)
            } else {
                map.put(book, 1);                   // O(1)
            }
        }

        int max = 0;
        String book = "";
        for(String key : map.keySet()) {
            int val = map.get(key);
            if(max < val || (max == val && book.compareTo(key) > 0)){
                book = key;
                max = val;
            }
        }
        System.out.print(book);
    }
}