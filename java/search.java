import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
public class search {
     static int linearSearch(int[] ar, int target){
         for (int i = 0; i < ar.length; i++) {
            if(ar[i]==target){
                return i;             
            }          
         }
         return -1;
     }
     static int findFinalValue(int[] nums, int original) {
        Set<Integer> s=new HashSet<>();
        for(int i : nums){
            s.add(i);
        }
        while(s.contains(original)){
            original*=2;
        }
        return original;
    }
     static boolean binarySearch(int[] ar,int target){
        int l=0;
        int h=ar.length-1;
        int mid=0;
        while(l<=h){
            mid=(l+h)/2;
             if(ar[mid]==target){
                return true;
             }
             else if(ar[mid]>target){
                h=mid-1;
             }
             else{
                l=mid+1;
             }
        }
        return false;
     }
     static int span(int[] ar){
        int max=ar[0];
        int min=ar[0];
        for (int i = 0; i < ar.length; i++) {
            if(max<ar[i]){
                  max=ar[i];
            }
            if(min>ar[i]){
                min=ar[i];
            }            
        }
        return max-min;
     }
     static int max2nd(int[] ar){
        int max1=0;
        int max2=0;
        if(ar[0]>ar[1]){
            max1=ar[0];
            max2=ar[1];
        }
        else{
            max1=ar[1];
            max2=ar[0];
        }
        for (int i = 2; i < ar.length; i++) {
            if(max1<ar[i]){
                max2=max1;
                max1=ar[i];
            }
            else if(max2<ar[i]){
                max2=ar[i];
            }
        }
        return max2;

     }
     static int  ceilproblem(int ar[], int target){
                 int l=0;
                 int h=ar.length-1;
                 int mid=0;
                 while(l<=h){
                    mid=(l+h)/2;
                    if(ar[mid]==target){
                        return ar[mid];
                    }
                    else if(ar[mid]>target){
                        h=mid-1; 
                    }
                    else{
                        l=mid+1;
                    }
                 }
                 if(l<ar.length){
                    return ar[l];
                 }
                 return -1;               
     }
     static int ascBinary(int ar[],int target,int range){
        int l=0;
        int h=range;
        int mid=0;
        while(l<=h){
            mid=(l+h)/2;
             if(ar[mid]==target){
                return mid;
             }
             else if(ar[mid]>target){
                h=mid-1;

             }
             else{
                l=mid+1;
             }

        }
        return -1;
     }
     static int descBinary(int[] ar,int target,int range){
        int l=range;
        int h=ar.length-1;
        int mid=0;
        while(l<=h){
            mid=(l+h)/2;
             if(ar[mid]==target){
                return mid;
             }
             else if(ar[mid]>target){
                l=mid+1;

             }
             else{
                h=mid-1;
             }

        }
        return -1;
     }
     static int maxvalue(int ar[]){
        // int l=0;int r=ar.length-1;
        // int mid=0;
        // while(l<=r){
        //     mid=(l+r)/2;
        //     if(ar[mid]>ar[mid-1] && ar[mid]>ar[mid+1]){
        //         return mid;
        //     }
        //     else if(ar[mid]>ar[mid-1] && ar[mid]<ar[mid+1]){
        //         l=mid;
        //     }
        //     else{
        //         r=mid;
        //     }
        // }
        // return -1;      
            int l=0;int r=ar.length-1;
           int mid=0;
           while(l<r){
               mid=l+(r-l)/2;
               if( ar[mid]>ar[mid+1]){
                   r= mid;
               }
               else{
                   l=mid +1;
               }
           }
           return l;
     }
     static int fintInBitonic(int ar[],int target){
        int bindex=maxvalue(ar);
        if(ar[bindex]==target){
            return bindex;
        }
        else if(target> ar[bindex]){
            return -1;
        }   
          int res1=  ascBinary(ar, target, bindex);
          if(res1!=-1){
            return res1;
          }
          int res2= descBinary(ar, target, bindex);
          if(res2!=-1){
            return res2;
          }
        
        return -1;
     }
     static int countOfsmallnumber(int ar[],int target){
        int l=0;
        int h=ar.length;
        int mid=0;
        while(l<h){
            mid=(l+h)/2;
             if(ar[mid]==target){
                while(mid +1<ar.length && ar[mid+1]==target){
                mid ++;
             }
             break;
            }
             else if(ar[mid]>target){
                h=mid-1;

             }

             else{
                l=mid+1;
             }

        }
        if(target < ar[mid]){
            return mid;
        }
        return mid +1;
    }
     static int[] searchRange(int[] ar, int target) {
        int l=0;int r=ar.length-1;int mid=0;
        int[] res={-1,-1};
          while(l<=r){
            mid=(l+r)/2;
            if(ar[mid]==target){
                res[0]= mid;
                r=mid-1;
            }
            else if(ar[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
          }
         l=0;r=ar.length-1;mid=0;
          while(l<=r){
            mid=(l+r)/2;
            if(ar[mid]==target){
                res[1]=mid;
                l=mid+1;
                
            }
            else if(ar[mid]>target){
                  r=mid-1;
            }
            else{
                l=mid+1;
            }
         
     }
         return res;
}
     static int searchRotatearray(int[] ar, int target){
            int l=0;int r=ar.length-1;int mid=0;
              while(l<=r){
                mid=(l+r)/2;
                if(ar[mid]==target){
                     return mid;
                }
                else if(ar[l]<=ar[mid]){
                    if(target>=ar[l] && target < ar[mid]){
                    r=mid-1;
                    }
                    else{
                      l=mid +1;
                    }
                }   
                else {
                    if(target<=ar[r] && target > ar[mid]){
                    l=mid+1;
                    }
                    else{
                    r=mid-1;
                    }
                }   
              }
              return -1; 
     }
     static int findPivotInRotatedarray(int ar[]){
        int l=0;
        int r=ar.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(mid < r && ar[mid]>ar[mid+1]){
                return mid;
            }
            if( mid>l && ar[mid]<ar[mid-1]){
                return mid-1;
            }
            if(ar[l]==ar[mid] && ar[mid]==ar[r]){
                if(l<ar.length-1 && ar[l]>ar[l+1]){
                    return l;
                }
                l++;
                if(r>0&&ar[r]<ar[r-1]){
                    return r-1;
                }
                r--;
            }
            else if(ar[l]<=ar[mid] && ar[mid]>ar[r]){
                  l=mid+1;
            }
            else{
                 r=mid-1;
            }
        }
        return -1;
     }
     static boolean search1(int[] nums, int target) {
        int pivot=findPivotInRotatedarray(nums);
        if(pivot==-1){
            return binarySearch(nums, 0, nums.length-1, target); 
        }
        if(nums[pivot]==target){
            return true;
        }
        else{
            if(target>=nums[0]){
                return binarySearch(nums, 0, pivot-1, target); 
            }
            return binarySearch(nums,  pivot+1,nums.length-1, target);
        }
        
    
}  
     static int minNumbersorted(int arr[], int low, int high){
        int pivot=findPivotInRotatedarray(arr);
        if(pivot==-1){
          return arr[0];
         }
         return arr[pivot+1];
}    
     static int foundcount(int[] ar ,int mid){
        int wc=0;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>mid){
                wc+=(ar[i]-mid);
            }
        }
        return wc;
     }
     static int woodcut(int ar[],int b){
        int max=0;
        for (int i = 0; i < ar.length; i++) {
             if(ar[i]> max){
                max=ar[i];
             }
        }
        int l=0;
        int h=max;
        int mid=0;
        while (l<=h) {
            mid=(l+h)/2;
            int wc=foundcount(ar ,mid);
            if(wc==b || l==mid){
                return mid;
            }
            else if(b<wc){
                l=mid;
            }
            else{
                h=mid;
            }
        }
        return -1;
     }
     static float median(int ar1[],int ar2[]){
        int i=0;
        int j=0;
        int k=0;
        int[] ar3=new int[ar1.length+ar2.length];
        while(i<ar1.length && j<ar2.length){
         if(ar1[i]<=ar2[j]){
            ar3[k]=ar1[i];
            i++;
            k++;
         }
         else{
            ar3[k]=ar2[j];
            j++;
            k++;
         }
     }
     while (i<ar1.length){
        ar3[k]=ar1[i];
        i++;
        k++;
    }
    while (j<ar2.length){
        ar3[k]=ar2[j];
        j++;
        k++;
    }
    if(ar3.length%2==0){
        int mid=ar3.length/2;
        return  (float)(ar3[mid]+ar3[mid-1])/2;
    }
    return ar3[ar3.length/2];
    }
     static float median2(int ar1[],int ar2[]){
        if(ar1.length>ar2.length){
            return median2(ar2, ar1);
        }
        int l=0;
        int h=ar1.length;
        while(l<=h){
            int m1=(l+h)/2;
            int m2=((ar1.length+ar2.length+1)/2)-m1;
            int l1=(m1==0) ?Integer.MIN_VALUE :ar1[m1-1];
            int l2=(m2==0) ? Integer.MIN_VALUE:ar2[m2-1];
            int r1=(m1==ar1.length)? Integer.MAX_VALUE:ar1[m1];
            int r2=(m2==ar2.length)? Integer.MAX_VALUE:ar2[m2];
            if(l1<=r2 && l2<=r1){
                if((ar1.length+ar2.length)%2==0){
                    return (float)(Math.max(l1, l2)+Math.min(r1, r2)/2);
                }
                else{
                    return Math.max(l1, l2);
                }
            }
            else if(l2>r1){
                l=m1+1;
            }
            else{
                h=m1-1;
            }
        }
        return 0.0f;
     }
     static long kthElement(int k, int ar1[], int ar2[]) {
        if(ar1.length>ar2.length){
            return kthElement(k,ar2, ar1);
        }
        int left=k;
         int l = Math.max(0, k - ar2.length), h = Math.min(k, ar1.length);
        while(l<=h){
            int m1 = (l + h)/2;
            int m2 = left - m1;
            int l1=(m1==0) ?Integer.MIN_VALUE :ar1[m1-1];
            int l2=(m2==0) ? Integer.MIN_VALUE:ar2[m2-1];
            int r1=(m1==ar1.length)? Integer.MAX_VALUE:ar1[m1];
            int r2=(m2==ar2.length)? Integer.MAX_VALUE:ar2[m2];
            if(l1<=r2 && l2<=r1){
                return Math.max(l1, l2);
            }
            else if(l2>r1){
                l=m1+1;
            }
            else{
                h=m1-1;
            }
        }  
        return 0;   
     }
     static int painter(int ar[],int p,int t){//array splt
        int l=0;
        int h=0;
        for (int i = 0; i < ar.length; i++) {
             h=h+ar[i];            
        } 
        int res=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(ispossible(ar,p,m)==true){
                res=m;
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return res*t;
    }
     static boolean ispossible(int[] ar, int p, int m) {
        int painters=1;
        int pbc=0;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>m){
                return false;
            }
            if(pbc + ar[i]<=m){
                pbc=pbc+ar[i];
            }
            else{
                painters++;
                if(painters>p){
                    return false;
                }
                pbc=ar[i];
            }
            
        }
        return true;
    }    
     static int bouquets(int ar[],int boq,int flower){
        if(boq*flower>ar.length){
            return -1;
        }
        int l=ar[0];
        int h=ar[0];
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>h){
                h=ar[i];
            }
            if(ar[i]<l){
                l=ar[i];
            }
        }
        int res=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(ispos(ar,boq,flower,m)==true){
                res=m;
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return res;
    }
     static boolean ispos(int[] ar, int boq, int flower, int m) {
       
        int adj=0;
        int bc=0;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]<=m){
                  adj++;
                  if(adj==flower){
                    bc++;
                    if(bc==boq){
                        return true;
                    }
                    adj=0; 
                  }
            }
            adj=0;
            
        }
        return false;
       
    }
     static boolean ispos(int ar[],int b,int mid){
        int student=1;
        int spc=0;
        for(int i=0;i<ar.length;i++){
            if(mid<ar[i]){
                return false;
            }
            if(spc+ar[i]<=mid){
                spc+=ar[i];
            }
            else{
                student++;
                if(student>b){
                    return false;
                }
                spc=ar[i];
            }
        }
        return true;
    }
     static long bookalocation(int n, int[] ar, int m) {
         int l=ar[0];
         int h=0;
         for(int i=0;i<n;i++){
             if(ar[i]<l){
                 l=ar[i];
             }
             h+=ar[i];
         }
         int res=-1;
         if(n<m){
             return res;
         }
         while(l<=h){
             int mid=l+(h-l)/2;
             if(ispos(ar,m,mid)){
                 res=mid;
                 h=mid-1;
             }
             else{
                 l=mid+1;
             }
         }
         return res;
         
    } 
    static boolean ispos2(int ar[],int b,int mid){
      int cow=1;
      int last=ar[0];
      for(int i=1;i<ar.length;i++){
          if(ar[i]-last >=mid){
              cow++;
              last=ar[i];
          }
          if(cow>=b){
              return true;
          } 
      }
      return false;
    }
     static int cow(int n, int m, int[] ar) {
        Arrays.sort(ar);
        int l=1;
         int h=ar[n-1] -ar[0];
         int res=-1;
         while(l<=h){
             int mid=l+(h-l)/2;
             if(ispos2(ar,m,mid)){
                 res=mid;
                 l=mid+1;
             } 
             else{
                 h=mid-1;
             }
         }
         return res;
    }
    static boolean isposible(int ar[],int day,int mid){
        int d=1;
        int wsum=0;
        for(int i=0;i<ar.length;i++){
            if(wsum+ar[i]>mid){
                d++;
                if(d>day){
                    return false;
                }
                wsum=ar[i];
            }
            else{
                wsum+=ar[i];
            }
        }
        return true;
    }
    static int leastWeightCapacity(int[] ar, int n, int d) {
        int l=0;
        int h=0;
        for(int i=0;i<n;i++){
             h+=ar[i];
             l=Math.max(l,ar[i]);
        }
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isposible(ar,d,mid)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    static int isposible4(int ar[],int d,int mid){
           int count=0;
           int j=0;
           for(int i=1;i<ar.length;i++){
            while(ar[i]-ar[j]>mid){
               j++;
            }
            count+=i-j;
          }
       return count;
       }      
    static int smallestDistancePair(int[] ar, int d) {
           Arrays.sort(ar);
           int l=0;
           int h=ar[ar.length-1]-ar[0];
           while(l<h){
               int mid=l+(h-l)/2;
               if(isposible4(ar,d,mid)<d){
                   l=mid+1;
               }
               else{
                   h=mid;
               }
           }
           return l;
       }
    static boolean isposible2(int ar[],int hour,int mid){
        double totalsum=0;
        for(int i=0;i<ar.length;i++){
         totalsum+=Math.ceil((double)ar[i]/mid);
         if(totalsum>hour){
            return false;
         }
       }
    return true;
    }      
    static int minEatingSpeed(int[] ar, int d) { //same as thrashold 
        int l=0;
        int h=0;
        for(int i=0;i<ar.length;i++){
             h=Math.max(h,ar[i]);
             l=Math.min(l,ar[i]);
        }
        int res=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isposible2(ar,d,mid)){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
    static double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length; // size of the array
        double low = 0;
        double high = 0;

        //Find the maximum distance:
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }

        //Apply Binary search:
        double diff = 1e-6 ;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = numberOfGasStationsRequired(mid, arr);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
    static  String convert(String s, int numRows) {
        if(numRows==1 || numRows >=s.length())
         {
            return s;
         }
        String[] rows = new String[numRows];
        for(int i=0;i<numRows;i++)
        {
            rows[i] = "";
        }
        int currentRow = 0;
        boolean goingDown = false;

        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
           rows[currentRow]+=c;
           if(currentRow==0 ||currentRow==numRows-1)
           {
            goingDown = !goingDown;
           }
           currentRow += goingDown ? 1:-1;
        }
       String result ="";
       for(int i=0;i<rows.length;i++)
       {
        result+=(rows[i]);
       }
      return result;
    }
    static int contanerwthmostwater(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;        
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            // Use binary search to find the correct position in tails
            int left = 0, right = tails.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // If left == tails.size(), append the number to the end
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);  // Replace the element at position left
            }
        }
        
        return tails.size();  // The size of the tails list gives the length of the LIS
    }
    static int checks(int m,int n,int mid){
        int count=0;
           for(int i=1;i<=m;i++){
             count+=  Math.min(mid/i,n);
           }
           return count;
         }
    static int findKthNumbermultable(int m, int n, int k) {
            int l=1;
            int h=k;
            while(l<=h){
                int mid=l+(h-l)/2;
                if(checks(m,n,mid)<k){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
            return l;
        }
    static int sqroot(int n){
        if(n==0 || n==1){
            return n;
        }
        int l=2;
        int res=1;
        int h=n/2;
              while(l<=h){
                int m=(l+h)/2;
                if(m*m==n){
                   return m;
                 }
                 else if(m*m >n){
                    h=m-1;
                 }
                 else{
                    l=m+1;
                    res=m;
                 }   
        }
        return res;
    }
    static int NthRoot(int n, int m)
    {
        int l=1;
        int h=m;
       while(l<=h){
           int mid=l+(h-l)/2;
           if(Math.pow(mid,n)==m){
               return mid;
           }
            else if(Math.pow(mid,n)>m){
               h=mid-1;
           }
           else{
               l=mid+1;
           }
       }
       return -1;
    }
     static boolean isPerfectSquare(int num) {
        int l = 0, h = num, mid = 0;
         while (l <= h) {
             mid = l + (h - l) / 2;
             long pow = (long)mid * mid;
             if (pow == num)
                 return true;
             else if (pow < num)
                 l = mid + 1;
             else
                 h = mid - 1;
         }
         return false;
     }
     static char nextGreatestLetter(char[] letters, char target) {
        int l=0;
        int h=letters.length-1;
        int mid=0;
        while(l<=h){
            mid=l+(h-l)/2;
            if(letters[mid]>target){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return letters[l%letters.length];
    }
     static boolean binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
    
          int mid = (low + high) / 2;
          if (arr[mid] < key) {
            low = mid + 1;
          } else if (arr[mid] > key) {
            high = mid - 1;
          } else {
            return true;
          }
    
        }
        return false;
      }
     static int binarySearch3(int[] arr, int low, int high, int key) {
        while (low <= high) {
    
          int mid = (low + high) / 2;
          if (arr[mid] < key) {
            low = mid + 1;
          } else if (arr[mid] > key) {
            high = mid - 1;
          } else {
            return mid;
          }
    
        }
        return -1;
      }
     static int findIndex(int[] arr, int key) { //nfnte
        int low = 0;
        int high = 1;
        while (arr[high] < key) {
          low = high;
          high = 2 * high;
        }
        return binarySearch3(arr, low, high, key);
      }
     static int arrangeCoins(int n) {
        int l=0;
        int r=Integer.MAX_VALUE;
        while(l<=r){
            int mid=l+(r-l)/2;
            long value=(long)mid*(mid+1)/2;
            if(value==n){
                return mid;
            }
            else if(value>n){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return r;
    }   
     static  int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = Integer.MAX_VALUE, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
     static int count(long num, long a, long b, long c) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }
     static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
     static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
     static boolean iseven(int mid){
        return mid%2==0;
    }
     static int singleNonDuplicate(int[] ar) {
       int l=0;
       int h=ar.length-1;
       while(l<h){
        int mid=l+(h-l)/2;
        if(iseven(mid)){
            if(ar[mid]==ar[mid+1]){
                l=mid+2;
            }
            else{
                h=mid-1;
            }
        }
        else{
            if(ar[mid]==ar[mid-1]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
       }
       return ar[l];
    }
     static int findKthPositive(int[] arr, int k) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid] -(mid+1)<k){
                l=mid+1;
            }
            else{
                h=mid-1;
            }    
        }
        return l+k;
    }
//  42 problems

   
   
   
   
   
   
   
   
   
   
   
   
   
    public static void main(String[] args) {
        int ar[]={4,5,6,6,6,6,1,2,3};
      System.out.println(findPivotInRotatedarray(ar));
    }
}
