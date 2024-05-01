import java.util.LinkedList;
public class HashMap {
    private final LinkedList<Entry>[] map;
    private int count;

    public HashMap(){
        map = new LinkedList[103];
        count = 0;
    }

    private int hashFunction(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % map.length;
        return slot;
    }

    public Patient remove(String key) {
        int slot = hashFunction(key);
        if (map[slot] == null) {
            return null;
        }

        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                Patient toBeDeleted = entry.value;
                map[slot].remove(entry);
                count--;
                return toBeDeleted;
            }
        }

        return null;
    }

    public Patient get(String key){
        if(key == null){
            throw new IllegalArgumentException("Null cannot be used as a key");
        }
        if(count == 0){
            return null;
        }

        int slot = hashFunction(key);
        if(map[slot] == null){
            return null;
        }
        for(Entry e: map[slot]) {
            if (e.key.equals(key))
                return e.value;
        }

        return null;
    }


    public Patient put(String key, Patient value){
        int slot = hashFunction(key);
        if(map[slot] == null){
            LinkedList<Entry> slotList = new LinkedList<Entry>();
            map[slot] = slotList;
        }

        for(Entry e: map[slot]){
            if(e.key.equals(key)){
                Patient oldValue = e.value;
                e.value.equals(value);
                return oldValue;
            }
        }
        Entry newEntry = new Entry(key, value);
        map[slot].add(newEntry);
        count++;

        return null;
    }

    private static class Entry{
        protected String key;
        protected Patient value;

        public Entry(String key, Patient value){
            this.key = key;
            this.value = value;
        }
    }
}
