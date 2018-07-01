package main.java.com.learningcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;
//            }
//        });
//
//        set.add(1);
//        set.add(2);
//        set.add(1);
//        System.out.println(set);

//        Map<Integer, String> m = new HashMap<>();

//        Map<Integer, String> m = new LinkedHashMap<>();

//        Map<Integer, String> m = new LinkedHashMap<>(5,1, true);
//        m.put(5, "a");
//        m.put(4, "b");
//        m.put(3, "c");
//        m.put(2, "d");
//        m.put(1, "e");
//
//        m.get(3);
//        m.get(5);
//        m.get(1);
//        System.out.println(m);

//        Map<Integer, String> m = new SimpleLRUCache<>(2);
//        m.put(1, "e");
//        m.put(2, "d");
//        m.put(3, "c");
//        m.get(2);
//        m.put(9, "j");
//        System.out.println(m.keySet());

//        Map<Object, String> map = new WeakHashMap<>();
//        Object data = new Object();         //some object
//        map.put(data, "information");
//
//        data = null;        //make available for gc()
//        System.gc();
//
//        for (int i = 1; i<10000; i++){
//            if (map.isEmpty()){
//                System.out.println("Empty! Iteration: " + i);
//                break;
//            }
//        }

//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 5; i > 0; i--) {
//            q.add(i);
//        }
//        while (!q.isEmpty()) {
//            System.out.println(q.poll());
//        }
//        System.out.println();
//        Queue<Integer> queue = new PriorityQueue<>();
//        for (int i = 5; i > 0; i--) {
//            queue.add(i);
//        }
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }

//        Object data = new Object();         //some object
//        map.put(data, "information");
//
//        data = null;        //make available for gc()
//        System.gc();
//
//        for (int i = 1; i<10000; i++){
//            if (map.isEmpty()){
//                System.out.println("Empty! Iteration: " + i);
//                break;
//            }
//        }

//        List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());
//        List<Integer> list2 = new CopyOnWriteArrayList<>();
//        fillList(list1, 100);
//        fillList(list2, 100);
//        System.out.println("List synchronized:");
//        checklist(list1);
//        System.out.println("CopyOnWriteArrayList:");
//        checklist(list2);

        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();
        rawList = list;
        rawList.add(8);
        String s = list.get(0);
    }

    private static void checklist(List<Integer> list) throws ExecutionException, InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        Future<Long> f1 = ex.submit(new ListRunner(0, 50, list, latch));
        Future<Long> f2 = ex.submit(new ListRunner(50, 100, list, latch));
        latch.countDown();
        System.out.println("Thread 1:" + f1.get()/1000);
        System.out.println("Thread 2:" + f2.get()/1000);
    }

    private static void fillList(List<Integer> list, int size) {
        for (int i = 0; i <= size; i++) {
            list.add(i);
        }
    }
}
