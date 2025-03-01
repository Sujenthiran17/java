import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
public class queuee {
    static public Queue<Integer> rev(Queue<Integer> queue){
         Stack<Integer> stack = new Stack<>();
     
        while(queue.size() > 0) {
           stack.push(queue.poll());
        }
        while(stack.size() > 0) {
           queue.add(stack.pop());
        }
        return queue;
    }
    static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st=new Stack<>();
       for (int i=0; i<k; i++){
           st.push(q.poll());
       }
       while(!st.empty()){
           q.add(st.pop());
       }
        int n=q.size();
       for(int i=0; i<n-k; i++){
           int element=q.peek();
           q.add(element);
           q.remove();
       }
       return q;
   }
    static String FirstNonRepeating(String A){
        Queue<Character> q=new LinkedList<>();
        String ans="";
        int freq[] = new int[26];
        for(int i=0;i<A.length();i++){
            freq[A.charAt(i)-'a']++;
            if(freq[A.charAt(i)-'a']==1){
                q.add(A.charAt(i));
            }
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.poll();
            }
            if(q.isEmpty()){
                ans+='#';
            }
            else{
                ans+=q.peek();
            }
        }
        return ans;
    }
    static int tour(int petrol[], int distance[]){
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentPetrol = 0;
        int startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentPetrol += petrol[i] - distance[i];

            // If current petrol balance goes negative
            if (currentPetrol < 0) {
                startIndex = i + 1; // Reset start index
                currentPetrol = 0; // Reset current petrol
            }
        }

        // Check if total petrol is sufficient for total distance
        return (totalPetrol >= totalDistance) ? startIndex : -1;
    }
    static void kSort(int[] arr, int n, int k){
        if (arr == null || arr.length == 0) {
            return;
        }
        // min heap
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();
        // if there are less than k + 1 elements present in
        // the array
        int minCount = Math.min(arr.length, k + 1);
        // add first k + 1 items to the min heap
        for (int i = 0; i < minCount; i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        // here even if size=k then n will be n=k,so i<n
        // works fine
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
        while (!priorityQueue.isEmpty()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    }
    static void printArray(int[] arr, int n){
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minheap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i]>minheap.peek()){
                minheap.remove();
                minheap.add(nums[i]);
            }
        }
        return minheap.peek();
    }
    static int findKthsmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap=new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < k; i++) {
            maxheap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i]<maxheap.peek()){
                maxheap.poll();
                maxheap.offer(nums[i]);
            }
        }
        return maxheap.peek();
    }
    static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a min-heap to keep track of the top k elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }

        // Step 3: Build the result array from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
    static List<String> topKFrequent(String[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list from the frequency map entries
        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());

        // Step 3: Sort the list by frequency (descending) and lexicographically (ascending)
        Collections.sort(frequencyList, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue().compareTo(a.getValue()); // Sort by frequency (high to low)
            }
            return a.getKey().compareTo(b.getKey()); // Sort by word (lexicographically)
        });

        // Step 4: Collect the top k elements
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(frequencyList.get(i).getKey());
        }

        return res;
    }
    static String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>(); 
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(hm.entrySet());
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
           Map.Entry<Character, Integer> entry = pq.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();  
            // Append the character `frequency` times
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        } 
        return result.toString();
    }
    static int[] kthLargest(int k, int[] arr, int n) {
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       int[] res=new int[n];
       for(int i=0;i<n;i++){
           pq.add(arr[i]);
           while(pq.size()>k){
               pq.poll();
           }
           res[i]=pq.size()==k? pq.peek():-1;
       }
       
       return res;
    }
    static String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
          for (char c : s.toCharArray()) {
              freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
          }
  
          PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) ->freqMap.get(b) - freqMap.get(a));
          maxHeap.addAll(freqMap.keySet());
  
          if (freqMap.get(maxHeap.peek()) > (s.length() + 1) / 2) {
              return "";
          }
          char[] result = new char[s.length()];
          int i = 0;
          while (!maxHeap.isEmpty()) {
              char c = maxHeap.poll();
              for (int j = 0; j < freqMap.get(c); j++) {
                  if (i >= s.length()) i = 1;
                  result[i] = c;
                  i += 2;
              }
          }
          return new String(result);
      } 
    static ArrayList<Integer> mergeKArrays(int[][] arr,int K){
        ArrayList<Integer> A=new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       for (int i = 0; i < arr[0].length; i++) {
         for (int j = 0; j < arr.length; j++) {
            pq.add(arr[i][j]);
         }
       }
       while (!pq.isEmpty()) {
        A.add(pq.poll());
       }
        return A;   
      }
    static int kthSmallest(int[][] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr[0].length; i++) {
          for (int j = 0; j < arr.length; j++) {
             pq.add(arr[i][j]);
             if (pq.size() > k) {
                     pq.poll();
                 }
          }
        }
        return pq.poll();
    }
    static double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        Map<Integer, Integer> outgoingNum = new HashMap<>();
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            smallList.offer(nums[i]);
        }

        for (int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        int balance = 0;
        int index = 0;

        for (int i = k;; i++) {
            if (k % 2 == 1) {
                medians[index] = smallList.peek();
            } else {
                medians[index] = ((double) smallList.peek() + largeList.peek()) / 2.0;
            }

            if (i >= nums.length)
                break;

            int outNum = nums[i - k];
            int inNum = nums[i];
            index++;

            balance = (outNum <= smallList.peek()) ? -1 : 1;

            outgoingNum.put(outNum, outgoingNum.getOrDefault(outNum, 0) + 1);

            if (inNum <= smallList.peek()) {
                balance++;
                smallList.offer(inNum);
            } else {
                balance--;
                largeList.offer(inNum);
            }

            if (balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0) {
                largeList.offer(smallList.poll());
            }

            balance = 0;

            while (outgoingNum.getOrDefault(smallList.peek(), 0) > 0) {
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.peek()) - 1);
                smallList.poll();
            }

            while (!largeList.isEmpty() && outgoingNum.getOrDefault(largeList.peek(), 0) > 0) {
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.peek()) - 1);
                largeList.poll();
            }
        }

        return medians;
    }
    static long minCost(long[] arr) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
       long res=0;
       for(int i=0;i<arr.length;i++){
           pq.add(arr[i]);
       }
       while(pq.size()!=1){
           long s1=pq.poll();
           long s2=pq.poll();
           res+=s1+s2;
           pq.add(s1+s2);
       }       
       return res;
    }
    static int leastInterval(char[] tasks, int n) { //621
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Step 1: Count the frequency of each task
        int maxCount = 0;
        for (char task : tasks) {
            int count = charCountMap.getOrDefault(task, 0) + 1;
            charCountMap.put(task, count);
            maxCount = Math.max(maxCount, count);
        }

        // Step 2: Calculate the number of tasks with the maximum frequency
        int maxCountTasks = 0;
        for (int count : charCountMap.values()) {
            if (count == maxCount) {
                maxCountTasks++;
            }
        }

        // Step 3: Calculate the number of chunks required for the task with the maximum frequency
        int chunkCount = (maxCount - 1) * (n + 1) + maxCountTasks;

        // Step 4: Return the maximum of chunkCount and the length of the tasks array
        return Math.max(chunkCount, tasks.length);
    }
    //1 problem 355
    static public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int max = Integer.MIN_VALUE; // Initialize max value
        int start = 0, end = Integer.MAX_VALUE; // To store the range

        // Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0}); // value, list index, element index
            max = Math.max(max, nums.get(i).get(0)); // Update max
        }

        while (minHeap.size() == nums.size()) {
            int[] minEntry = minHeap.poll(); // Get the smallest element
            int min = minEntry[0];
            int listIndex = minEntry[1];
            int elementIndex = minEntry[2];

            // Update the smallest range if the current range is smaller
            if (end - start > max - min) {
                start = min;
                end = max;
            }

            // Move to the next element in the same list
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextValue, listIndex, elementIndex + 1});
                max = Math.max(max, nextValue); // Update max if necessary
            }
        }

        return new int[]{start, end}; 
    }
     public boolean isNStraightHand(int[] hand, int groupSize) {
       if (hand.length % groupSize != 0) {
        return false;
    }

    // Frequency map to store card counts
    Map<Integer, Integer> countMap = new TreeMap<>();
    for (int card : hand) {
        countMap.put(card, countMap.getOrDefault(card, 0) + 1);
    }

    // Try to form groups
    for (int card : countMap.keySet()) {
        int count = countMap.get(card);
        if (count > 0) {
            // Try to form a group starting from this card
            for (int i = 1; i < groupSize; i++) {
                if (!countMap.containsKey(card + i) || countMap.get(card + i) < count) {
                    return false;
                }
                countMap.put(card + i, countMap.get(card + i) - count);
            }
        }
    }

    return true;
    }
    public int minOperations(int[] nums, int k) {//3066
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i : nums){
            pq.add((long)i);
        }
        int count=0;
        while(pq.peek()<k){
            if(pq.size()>=2){ 
              long x=pq.poll();
              long y=pq.poll();
              pq.add(Math.min(x, y) * 2 + Math.max(x, y));
              count++;
            }
            else{
                return -1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
 
        // function call
        System.out.println(findKthLargest(arr, k));
        printArray(arr, n);
    }
}
