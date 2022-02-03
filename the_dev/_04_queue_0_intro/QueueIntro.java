package me.whiteship.interview._04_queue_0_intro;

import java.util.Deque;
import java.util.LinkedList;

public class QueueIntro {

    public static void main(String[] args) {
        Deque<Integer> numbers = new LinkedList<>();
        numbers.addFirst(1);
        numbers.addFirst(2);
        numbers.addFirst(3);

        System.out.println(numbers.getLast());
    }
}
