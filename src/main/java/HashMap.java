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



    private static class Entry{
        protected String key;
        protected Patient value;

        public Entry(String key, Patient value){
            this.key = key;
            this.value = value;
        }
    }
}
