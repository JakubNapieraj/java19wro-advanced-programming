package HashSet;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringHashSet implements Set<String> {

    private List<List<String>> buckets;

    public StringHashSet() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {


        return false;
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public int size() {
        int index1 =0;
        for (int i = 0; i <buckets.size() ; i++) {
           index1++;
        }
        return index1 ;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i <buckets.size() ; i++) {
            if(buckets.get(i).isEmpty()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {

        int index = o.hashCode()%this.buckets.size();
        if(buckets.get(index).contains(o)){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        int hash = s.hashCode();
        int index = Math.abs(hash % this.buckets.size()) ;
        List<String> bucket = this.buckets.get(index);
        if (bucket.contains(s)) {
            return false;
        }
        bucket.add(s);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()%this.buckets.size());
        if(buckets.get(index).contains(o)){
            buckets.get(index).remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean changed = false;
        for (String s : c) {
            int hash = s.hashCode();
            int index = Math.abs(hash % this.buckets.size());
            List<String> bucket = this.buckets.get(index);
            if (!bucket.contains(s)) {
                this.add(s);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i <buckets.size() ; i++) {
            for (int j = 0; j <buckets.get(i).size() ; j++) {
                buckets.get(i).clear();
            }
        }
    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public Stream<String> stream() {
        return null;
    }

    @Override
    public Stream<String> parallelStream() {
        return null;
    }

    @Override
    public String toString() {
        return "{ " + this.buckets.stream()
                .flatMap(buckets -> buckets.stream())
                .collect(Collectors.joining(", ")) + "}";
    }
}
