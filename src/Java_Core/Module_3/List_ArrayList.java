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

//Класс EnumSet
// необходимо import java.util.*;

enum Heroes {GORDON, GERALT, LARA, GLADOS, PACMAN};

class FormatCourse {
    public static void main(String args[]) {
        // Creating a set
        EnumSet<Heroes> set1, set2, set3, set4;

        // Adding elements
        set1 = EnumSet.of(Heroes.GORDON, Heroes.GERALT,
                Heroes.LARA, Heroes.GLADOS);
        set2 = EnumSet.complementOf(set1);
        set3 = EnumSet.allOf(Heroes.class);
        set4 = EnumSet.range(Heroes.LARA, Heroes.PACMAN);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 4: " + set4);
    }
}

//Класс PriorityQueue
//нужно import java.util.*;

class PriorityQueueDemo {
    public static void main(String args[]) {
        // A custom comparator that compares two Strings by their length.
        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        // Create a Priority Queue with a custom Comparator
        Queue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);

        // Add items to a Priority Queue
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        // Remove items from the Priority Queue
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }
    }
}

//Класс ArrayDeque
//import java.util.*;

class ArrayDequeDemo {
    public static void main(String args[]) {
        Deque<String> arrayDeque = new ArrayDeque<>();
        // использовать класс ArrayDeque для организации стека
        arrayDeque.push("А");
        arrayDeque.push("В");
        arrayDeque.push("D");
        arrayDeque.push("Е");
        arrayDeque.push("F");

        System.out.print("Извлeчeниe из стека: ");

        while (arrayDeque.peek() != null)
            System.out.print(arrayDeque.pop() + " ");
        System.out.println();
    }
}