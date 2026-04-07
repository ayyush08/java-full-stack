import java.util.*;

public class Test {
    public static void main(String[] args) {
        
        List<String> arr = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        arr.add("Hello");
        arr.add("World");
        arr.add("Java");


        map.put("name", 30);
        map.put("age", 30);         

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // Duplicate, will not be added
        for(Integer num: set){
            System.out.println(num);
        }

        // System.out.println(map.get("rohit")>10); //NullPointerException because "rohit" key does not exist in the map
        // To avoid NullPointerException, we can use Optional

        Optional<Integer> marks = Optional.ofNullable(map.get("rohit"));

        if(!marks.isPresent()){
            System.out.println("Marks not found for rohit");
        } else {
            System.out.println("Marks for rohit: " + marks.get());
        }
    }
}