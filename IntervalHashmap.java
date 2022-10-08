import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;


/**
 * TreeMap is a Red-Black tree based NavigableMap implementation 
 * and it is sorted according to the natural ordering of its keys.
 * The TreeMap has the expected time cost of log(n) for insertion, deletion, and access operations. 
 * TreeMap is not synchronized and it has to be done externally.
 * The insertion order is not retained.
 */
public class IntervalHashmap {


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {

        // **** initialization ****
        int val = 0;
        NavigableMap<String, Integer> nm = new TreeMap<String, Integer>();
        String key = "";
        Entry<String, Integer> entry = null;
    
        // **** open a buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

        // **** [0] read number of pairs ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** populate the map ****
        for (int i = 0; i < n; i++) {

            // **** split line ****
            String[] strs = br.readLine().trim().split(" ");
            strs[1] = strs[1].trim();

            // **** for ease of use ****
            key = strs[0];
            val = Integer.parseInt(strs[1]);

            // **** put pair in map ****
            nm.put(strs[0], Integer.parseInt(strs[1]));
        }

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** ???? ???? ****
        System.out.printf("main <<<                 nm: %s\n", nm);
        System.out.printf("main <<<                 nm: %s\n", nm.toString());

        System.out.printf("main <<<               size: %d\n", nm.size());
        System.out.printf("main <<< descending key set: %s\n", nm.descendingKeySet());
        System.out.printf("main <<<          first key: %s\n", nm.firstKey());
        System.out.printf("main <<<           last key: %s\n", nm.lastKey());
        System.out.printf("main <<<     descending map: %s\n", nm.descendingMap());


        // **** [1] prompt user ****
        System.out.print("\nmain >>> add key val: ");
        String strs[] = br.readLine().trim().split(" ");

        // **** for ease of use ****
        key = strs[0];
        val = Integer.parseInt(strs[1]);

        // ???? ????
        System.out.printf("main <<< key ==>%s<== val: %d\n", key, val);

        // **** put the pair in the hashmap (if needed) ****
        //nm.put(key, val);
        nm.putIfAbsent(key, val);

        // ???? ????
        System.out.printf("main <<<   nm: %s\n", nm.toString());
        System.out.printf("main <<< size: %d\n", nm.size());


        // **** [2] get floor key from user ****
        System.out.print("\nmain >>> floor key: ");
        key = br.readLine().trim();

        // ???? ????
        System.out.printf("main <<< floor key ==>%s<==\n", key);

        // **** get the floor entry ****
        entry = nm.floorEntry(key);

        // **** display the floor entry (if needed) ****
        if (entry != null)
            System.out.printf("main <<< floor entry: %s\n", entry.toString());
        else
            System.out.printf("main <<< entry not found for key ==>%s<==\n", key);

        // **** ****
        System.out.printf("main <<< first entry: %s\n", nm.firstEntry());
        System.out.printf("main <<<   lower key: %s\n", nm.lowerKey(key));
        System.out.printf("main <<<   floor key: %s\n", nm.floorKey(key));
        System.out.printf("main <<< ceiling key: %s\n", nm.ceilingKey(key));
        System.out.printf("main <<<  higher key: %s\n", nm.higherKey(key));

        // **** [3] ****
        System.out.print("\nmain >>> remove key: ");
        key = br.readLine();

        // ???? ????
        System.out.printf("main <<< key ==>%s<==\n", key);

        // **** ****
        if (!nm.containsKey(key))
            System.out.printf("main <<< key ==>%s<== NOT found\n", key);

        // **** remove element using remove() ****
        nm.remove(key);

        // **** display map ****
        System.out.printf("main <<<   nm: %s\n", nm.toString());
        System.out.printf("main <<< size: %d\n", nm.size());


        // **** [4] get key-value pair ****
        System.out.print("\nmain >>> get key: ");
        key = br.readLine();

        // ???? ????
        System.out.printf("main <<< key ==>%s<==\n", key);

        // **** check if key is in map ****
        if (nm.containsKey(key)) {

            // **** ****
            val = nm.get(key);
        
            // ???? ????
            System.out.printf("main <<< key ==>%s<== val: %d\n", key, val);
        } else
            System.out.printf("main <<< key ==>%s<== NOT found\n", key);


        // **** [5] to navigate through the map entries ****
        Iterator<NavigableMap.Entry<String, Integer>> it = nm.entrySet().iterator();

        // **** display all entries in the map ****
        System.out.println();
        while (it.hasNext()) {

            // **** get next entry ****
            entry = it.next();

            // **** display entry ****
            System.out.printf("main <<< entry: %s %d\n", entry.getKey(), entry.getValue());
        }


        // **** [6] traverse map using for-each ****
        System.out.println();
        for (Entry<String, Integer> ent : nm.entrySet())
            System.out.printf("main <<< ent: %s %d\n", ent.getKey(), ent.getValue());


        // **** [7] display head of map ****
        System.out.print("\nmain >>> head key: ");
        key = br.readLine();

        // ???? ????
        System.out.printf("main <<< key ==>%s<==\n", key);

        // **** head map ****
        NavigableMap<String, Integer> headNm = nm.headMap(key, true);

        // **** traverse the head map ****
        for (Entry<String, Integer> ent : headNm.entrySet())
            System.out.printf("main <<< ent: %s %d\n", ent.getKey(), ent.getValue());


        // **** [8] traverse tail of map ****
        System.out.print("\nmain >>> tail key: ");
        key = br.readLine();

        // ???? ????
        System.out.printf("main <<< key ==>%s<==\n", key);

        // **** head map ****
        NavigableMap<String, Integer> tailNm = nm.tailMap(key, true);

        // **** traverse the head map ****
        for (Entry<String, Integer> ent : tailNm.entrySet())
            System.out.printf("main <<< ent: %s %d\n", ent.getKey(), ent.getValue());

            
        // **** close the buffered reader ****
        br.close();  
    }
}