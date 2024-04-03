package Java_Core.Module_3;
import java.util.*;

import java.util.EnumSet;

public class test {
}


class Cap {
    enum DAYS {
        THU, FRI, SAT, SUN, MON, TUE, WED;
    }
    public static void main(String[] args) {
        EnumSet es = EnumSet.range(DAYS.THU, DAYS.MON);
        System.out.println(es);
        es.add(DAYS.TUE);
        System.out.println(es);
    }
}



class Demo {
    public static void main(String[] args) {
        Deque<String> de = new ArrayDeque<>();
        de.push("Apple");
        de.push("Banana");
        de.push("Orange");
        for (Object element : de) {
            System.out.println(element);
        }
    }
}

class Demo1 {
    public static void main(String[] args) {
        Queue<String> bk = new PriorityQueue<>();
        bk.add("paper");
        bk.add("pen");
        bk.add("pencil");
        System.out.println(bk.peek() + "," + bk.poll());
    }
}

class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        Collections.unmodifiableList(list);
        //list = Collections.unmodifiableList(list);
        list.add("Three");
        for (String s : list)
            System.out.println(s);
    }
}

class Demo3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.poll();
        System.out.println(deque);
    }
}
