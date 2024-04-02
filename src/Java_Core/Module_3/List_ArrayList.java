package Java_Core.Module_3;

//для List
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//для LinkedList
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

//для HashSet
import java.util.*;

//для TreeSet
import java.util.*;



public class List_ArrayList {

}


class MainArrayList {
    public static void main(String[] args) {
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(42);
        myNumbers.add(7);
        myNumbers.add(13);

        Collections.sort(myNumbers);

        myNumbers.remove(2);

        for (int i : myNumbers) {
            System.out.println(i);
        }
    }
}


class MainLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> myNumbers = new LinkedList<>();
        myNumbers.add(42);
        myNumbers.addLast(7);
        myNumbers.addFirst(13);

        myNumbers.removeFirst();
        myNumbers.removeLast();
        for (int i : myNumbers) {
            System.out.println(i);
        }
    }
}

//HashSet
class HashSetDemo {
    public static void main(String args[]) {

        HashSet<String> set = new HashSet();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");

        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

//TreeSet
class Element {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                '}';
    }
}

class TreeSetDemo {
    public static void main(String args[]) {
        Comparator<Element> comparator = (ele1, ele2) -> {
            return ele1.getId().compareTo(ele2.getId());
        };

        Set<Element> treeSet = new TreeSet<>(comparator);
        Element ele1 = new Element();
        ele1.setId(42);
        Element ele2 = new Element();
        ele2.setId(13);

        treeSet.add(ele1);
        treeSet.add(ele2);

        System.out.println(treeSet);
    }
}