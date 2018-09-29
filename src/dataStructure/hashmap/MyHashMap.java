package dataStructure.hashmap;

public class MyHashMap {
    int size = 0;
    double loadFactor = 0.75;
    int capacity = 4;
    MapEntry[] buckets = new MapEntry[capacity];

    public void put(int key, int value) {
        double threshold = this.capacity * this.loadFactor;
        if (size >= (int)threshold) {
            resize();
        }

        ++size;
        int hashCode = getHashCode(key);

        MapEntry existingEntry = getEntry(key, hashCode);
        if (existingEntry != null) {
            existingEntry.value = value;
        } else if (buckets[hashCode] == null) {
            MapEntry newMapEntry = new MapEntry();
            newMapEntry.key = key;
            newMapEntry.value = value;
            buckets[hashCode] = newMapEntry;
        } else {
            MapEntry entry = buckets[hashCode];
            MapEntry temp = entry;
            while(temp.next != null) {
                temp = temp.next;
            }

            MapEntry newMapEntry = new MapEntry();
            newMapEntry.key = key;
            newMapEntry.value = value;
            temp.next = newMapEntry;
        }


    }

    private MapEntry getEntry(int key, int index) {
        if (buckets[index] == null) {
            return null;
        }

        MapEntry temp = buckets[index];
        while(temp != null && temp.key != key) {
            temp = temp.next;
        }

        if(temp == null) {
            return null;
        }

        return temp;
    }

    private void resize() {
        this.capacity *= 2;
        MapEntry[] newBuckets = new MapEntry[this.capacity];
        for (MapEntry item: buckets) {
            if (item != null) {
                int i = getHashCode(item.key);
                newBuckets[i] = item;
            }
        }

        buckets = newBuckets;
    }

    public int get(int key) {
        int index = getHashCode(key);
        MapEntry entry = buckets[index];
        if (entry == null) {
            throw new IllegalArgumentException("no element with key: " + key);
        }

        MapEntry temp = buckets[index];
        while(temp != null && temp.key != key) {
            temp = temp.next;
        }

        if (temp == null) {
            throw new IllegalArgumentException("no element with key: " + key);
        }

        return temp.value;
    }


    private int getHashCode(int key) {
        if(key < 0) {
            key *= -1;
        }
        return key % this.capacity;
    }

    private class MapEntry {
        int key;
        int value;
        MapEntry next;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(2, 10);
        map.put(3, 11);
        map.put(4, 10);
        map.put(10, 12);

        System.out.println(map.get(10));
    }
}
