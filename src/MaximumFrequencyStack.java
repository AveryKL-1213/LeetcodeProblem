import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack obj = new FreqStack();
        int[] nums = {5, 7, 5, 7, 4, 5};
        for (int tmp : nums) {
            obj.push(tmp);
        }
        int popTimes = 4;
        for (int i = 0; i < popTimes; i++) {
            System.out.println("Pop: " + obj.pop());
        }
    }
}

class FreqStack {
    Map<Integer, ArrayList<Integer>> order;
    Map<Integer, Integer> frequency;
    int maxFreq;

    public FreqStack() {
        order = new HashMap<>();
        frequency = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        frequency.put(val, frequency.getOrDefault(val, 0) + 1);
        int freq = frequency.get(val);
        order.putIfAbsent(freq, new ArrayList<>());
        order.get(freq).add(val);
        maxFreq = Math.max(freq, maxFreq);
    }

    public int pop() {
        ArrayList<Integer> list = order.get(maxFreq);
        int popNum = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        frequency.put(popNum, frequency.get(popNum) - 1);
        if (list.isEmpty()) {
            order.remove(maxFreq);
            maxFreq--;
        }
        return popNum;
    }
}