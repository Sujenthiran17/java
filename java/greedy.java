import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class greedy {
    static public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0;
        int r=0;
        while(l< s.length && r< g.length){
            if(g[r]<=s[l]){
                r++;
            }
            l++;
        }
        return r;
    }
    static  public boolean lemonadeChange(int[] ar) {
        int change5=0;
        int change10=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]==5){
                change5++;
            }
            if(ar[i]==10){
                change10++;
                if(change5>0){
                    change5--;
                }
                else{
                    return false;
                }
            }
            if(ar[i]==20){
                if(change5>0 && change10>0){
                    change5--;
                    change10--;
                }
                else if(change5>=3){
                    change5-=3;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    static public boolean canJump(int[] nums) {
        int maxi=0;
        for(int i=0;i<nums.length;i++){
           if(i>maxi){
            return false;
           }
           maxi=Math.max(maxi,nums[i]+i);
        }
        return true;
    }
    static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        
        int jumps = 0;
        int currentEnd = 0; // The end of the current range
        int farthest = 0;   // The farthest point that can be reached
        
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest point that can be reached
            farthest = Math.max(farthest, i + nums[i]);
            
            // When we reach the end of the current range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // If we can reach or exceed the last index, return the result
                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }
        
        return jumps;
    }
    static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
          int maxi=0;
          for(int i : deadline){
              maxi=Math.max(maxi,i);
          }
          int[] res=new int[maxi+1];
          Arrays.fill(res,-1);
          res[0]=0;
          int all[][]=new int[id.length][2];
          for(int i=0;i<all.length;i++){
              all[i][0]=deadline[i];
              all[i][1]=profit[i];
          }
          Arrays.sort(all,(a,b)->{
              return b[1]-a[1];
          });
          int count=0;
          int prof=0;
          for(int i=0;i<id.length;i++){
              for(int j=all[i][0];j>0;j--){
                  if(res[j]==-1){
                      res[j]=i;
                      count++;
                      prof+=all[i][1];
                      break;
                  }
              }
          }
          ArrayList<Integer> ans=new ArrayList<>();
          ans.add(count);
          ans.add(prof);
          return ans;
    }
    static int maxMeetings(int start[], int end[]) {
        int all[][]=new int[start.length][2];
        for(int i=0;i<start.length;i++){
            all[i][0]=start[i];
            all[i][1]=end[i];
        }
        Arrays.sort(all,(a,b)->a[1]-b[1]);
        int count=1;
        int freetime=all[0][1];
        for(int i=1;i<all.length;i++){
            if(freetime< all[i][0]){
                count++;
                freetime=all[i][1];
            }
        }
        return count;
   }
    static  public int[][] insert(int[][] nums, int[] newone) {
        int n=nums.length;
        List<int[]> l=new ArrayList<>();
        int i=0;
        while(i<n && nums[i][1]<newone[0]){
            l.add(nums[i]);
            i++;
        }
        int start=newone[0];
        int end=newone[1];
        while(i<n && nums[i][0]<=newone[1]){
            start=Math.min(nums[i][0],start);
            end=Math.max(nums[i][1],end);
            i++;
        }
        l.add(new int[] {start,end});
        while(i<n){
            l.add(nums[i]);
            i++;
        }
        return l.toArray(new int[l.size()][]);

    }
    static int findPlatform(int arr[], int dep[]) {
        int count=1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1;
        int j=0;
        int res=1;
        while(i<arr.length && j<dep.length){
            if(arr[i]<=dep[j]){
                count++;
                i++;
                res=Math.max(res,count);
            }
            else{
                count--;
                j++;
            }
        }
        return res;
    }
    static public boolean checkValidString(String s) {
        int min=0;
        int max=0;
        for(char i : s.toCharArray()){
            if(i=='('){
                min++;
                max++;
            }
            else if(i==')'){
                if(min>0){
                    min--;
                }
                max--;
                if(max<0){
                    return false;
                }
                
            }
            else{
               if(min>0){
                    min--;
                }
                max++;
            }
        }
        return min==0;
    }
    static  public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
           return 0;
         }
       int sum=1;
       int i=1;
       while(i<ratings.length){
           if(i<ratings.length && ratings[i]==ratings[i-1]){
               sum++;
               i++;
               continue;
           }
           int peak=1;
           while(i<ratings.length && ratings[i]>ratings[i-1]){
               peak++;
               sum+=peak;
               i++;
           }
           int down=0;
           while(i<ratings.length && ratings[i]<ratings[i-1]){
               down++;
               sum+=down;
               i++;
           }
           down++;
           if(peak<down){
              sum+=(down-peak);
           }
       }
       return sum;
   }
   static int sjf(int bt[] ) {
    Arrays.sort(bt);
    int t =0;
    int sum=0;
    for(int i=0;i<bt.length;i++){
        sum+=t;
        t+=bt[i];
    }
    return sum/bt.length;

}
   public int minCoins(int coins[], int V) {
    Arrays.sort(coins);
    int count=0;
    int n=coins.length;
    for (int i = n - 1; i >= 0; i--) {
      while (V >= coins[i]) {
        V -= coins[i];
        count++;
      }
    }
    return V==0? count:-1;
}  
class Item{
    int value;
    int weight;
    double ratio;
    Item(int value,int weight){
        this.value=value;
        this.weight=weight;
        this.ratio= value/ (double) weight;
    }
}
// Function to get the maximum total value in the knapsack.
   double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
    // code here
    List<Item> items = new ArrayList<>();
    for (int i = 0; i < val.size(); i++) {
        items.add(new Item(val.get(i), wt.get(i)));
    }

    items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

    double profit = 0.0;
    for (Item item : items) {
        if (capacity == 0) break;

        if (item.weight <= capacity) {
            profit += item.value;
            capacity -= item.weight;
        } else {
            profit += item.ratio * capacity;
            capacity = 0;
        }
    }

    return profit;
}
class pair{
    int s;
    int e;
    pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}
public int activitySelection(List<Integer> start, List<Integer> end) {
    if(start.isEmpty() || end.isEmpty()){
        return 0;
    }
    int count=1;
    int j=0;
    List<pair> l=new ArrayList<>();
    for (int i = 0; i < start.size(); i++) {
    l.add(new pair(start.get(i), end.get(i)));
   }
   Collections.sort(l,(a,b)->a.e-b.e);
   for(int i=1;i<l.size();i++){
    if(l.get(j).e<l.get(i).s){
        count++;
        j=i;;
    }
   }
   return count;
}   
 public int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:arr){
            pq.offer(i);
        }
        int cost=0;
        while(pq.size()>1){
            if(pq.size()>=2){
                int s1=pq.poll();
                int s2=pq.poll();
                cost+=(s2+s1);
                pq.offer(s2+s1);
            }
        }
        return cost;
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int[] ar=new int[26];
        for(int i=0;i<s.length();i++){
           ar[s.charAt(i)-'a']=i;
        }
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
            r=Math.max(r,ar[s.charAt(i)-'a']);
            if(r==i){
                ans.add(r-l+1);
                l=i+1;
            }
        }
        return ans;
    }
    static int sumExceptFirstLast(int[] arr) {
        if(arr.length<=2){
            return 0;
        }
        int ans=0;
        for(int i=1;i<arr.length-1;i++){
            ans+=arr[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        
    }
    
}
