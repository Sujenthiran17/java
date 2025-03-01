import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class sorting {
    static void mergesort1(int ar[],int l,int r){
        
        if(l<r){
         int mid=(l+r)/2;            
        mergesort1(ar, l, mid);
        mergesort1(ar, mid+1, r);
        merge1(ar,l,mid,r);
      }  
    }
    static void merge1(int[] ar, int l, int mid, int r) {
        int n1=mid - l +1;
        int n2=r-mid;
        int lar[]=new int[n1];
        int rar[]=new int[n2];
        System.arraycopy(ar,l,lar,0,n1);
        System.arraycopy(ar, mid +1, rar, 0, n2);
        // for (int i = 0; i < n1; i++) {
        //     lar[i]=ar[l+i];         
        // }
        // for (int j = 0; j < n2; j++) {
        //     rar[j]=ar[mid+1+j];
        // }
        int i=0;
        int j=0;
        int k=l;
        while (i<n1 && j<n2) {
            if(lar[i]<=rar[j]){
                ar[k]=lar[i];
                i++;
            }
            else{
                ar[k]=rar[j];
                j++;
            }
            k++;            
        }
        while (i<n1){
            ar[k]=lar[i];
            i++;
            k++;
        }
        while (j<n2){
            ar[k]=rar[j];
            j++;
            k++;
        }
    }
    static void swap(int[] ar,int first,int second){
        int temp=ar[first];
        ar[first]=ar[second];
        ar[second]=temp;
    }
    static void bublesort(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar.length-i; j++) {
                if(ar[j]<ar[j-1]){
                    swap(ar, j, j-1);
                }
            }     
        }
    }
    static void selectionsort(int ar[]){
               for (int i = 0; i < ar.length; i++) {
                 int maxindex= getmax(ar, 0, ar.length-i-1);
                     swap(ar,maxindex,ar.length-i-1);
               }
    }
    static int getmax(int[] ar,int start,int end){
        int max=start;
        for (int i = start; i <= end; i++) {
                if(ar[max]<ar[i]){
                    max=i;
                }
        }
        return max;
    }
    static void insertionsort(int ar[]){
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if(ar[j]<ar[j-1]){
                    swap(ar, j, j-1);
                }
                else{
                     break;   
                }
        }
        }
    } 
    static void quicksort(int[] ar,int low,int hi){
        if(low>=hi){
            return;
        }
        int s=low;
        int e=hi;
        int m=low+(hi-low)/2;
        int pivot=ar[m];
        while(s<=e){
            while (ar[s]<pivot) {
                s++;  
            }
            while (ar[e]>pivot) {
                e--;  
            }
            if(s<=e){
                swap(ar, s, e);
                s++;
                e--;
            }
        }
        quicksort(ar, low, e);
        quicksort(ar, s, hi);
    }
    static void cyclicsort(int ar[]){
        int i=0;
        while(i<ar.length){
            int correct=ar[i];
            if(ar[i]!=ar[correct]){
                swap(ar,i,correct);
            }
            else{
                i++;
            }
        }
    }
    static int missingNumber(int[] ar) {
    // int i=0;
    //   while( i<ar.length){
    //       int correct=ar[i];
    //       if(ar[i]<ar.length &&ar[i]!=ar[correct]){
    //           swap(ar,i,correct);
    //       }
    //       else{
    //           i++;
    //       }
    //   }
    //   for(int j=0;j<ar.length;j++){
    //       if(ar[j]!=j){
    //           return j;
    //       }
    //   }
    //   return ar.length;
    int n=ar.length;
        int sum=0;
        for(int i : ar){
            sum+=i;
        }
        return (n*(n+1)/2)-sum;
  }
    static List<Integer> findDisappearedNumbers(int[] ar) {
          int i=0;
        while( i<ar.length){
            int correct=ar[i]-1;
            if(ar[i]!=ar[correct]){
                swap(ar,i,correct);
            }
            else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<ar.length;j++){
            if(ar[j]!=j+1){
                ans.add(j+1);
            }
        }
        return ans;
    }
    static int findDuplicate(int[] ar) {
        int i=0;
        while( i<ar.length){
            int correct=ar[i]-1;
            if(ar[i]!=ar[correct]){
                swap(ar,i,correct);
            }
            else{
                i++;
            }
        }
    
        for(int j=0;j<ar.length;j++){
            if(ar[j]!=j+1){
                  return ar[j];
            }
        }
        return ar.length;
        
    }
    static List<Integer> findDuplicates(int[] ar){
        int i=0;
        while( i<ar.length){
            int correct=ar[i]-1;
            if(ar[i]!=ar[correct]){
                swap(ar,i,correct);
            }
            else{
                i++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<ar.length;j++){
            if(ar[j]!=j+1){
                ans.add(ar[j]);
            }
        }
        return ans;    
}
    static int[] findErrorNums(int[] ar) {
    int i=0;
  while( i<ar.length){
      int correct=ar[i]-1;
      if(ar[i]!=ar[correct]){
          swap(ar,i,correct);
      }
      else{
          i++;
      }
  }

  for(int j=0;j<ar.length;j++){
      if(ar[j]!=j+1){
            return new int[] { ar[j] , j+1};
      }
  }
  return null;
}
    static int firstMissingPositive(int[] ar) {
    int i=0;
while( i<ar.length){
  int correct=ar[i]-1;
  if(ar[i]>0 && ar[i]<ar.length && ar[i]!=ar[correct]){
      swap(ar,i,correct);
  }
  else{
      i++;
  }
}
for(int j=0;j<ar.length;j++){
  if( ar[j]!=j+1){
      return j+1;
  }
}
return ar.length+1;

}
    static int[] frequencySort(int[] ar) {
        Map<Integer,Integer> m=new HashMap<>();
       for (int i = 0; i < ar.length; i++) {
           m.put(ar[i], m.getOrDefault(ar[i], 0)+1);
       } 
       List<Integer> l=new ArrayList<>(m.keySet());
       Collections.sort(l,(a,b)-> m.get(a)-m.get(b));
       int res[]=new int[ar.length];
       int index=0;
       for(int i:l){
           for(int j=0;j<m.get(i);j++){
               res[index]=i;
               index++;
           }
       }
       return res;      
       }
    static void sort012(int a[], int n){
    int low=0,mid=0;int high=n-1;
    while(mid<=high){
    if(a[mid]==0){
       swap(a,low,mid);
       low++;
       mid++;
    }
    else if(a[mid]==1){
        mid++;
    }
    else{
        swap(a,mid,high);
        high--;
    }
    }
    }
    static boolean twoequalOrnot(int ar1[],int ar2[]){
        Map<Integer,Integer> m=new HashMap<>();
        if(ar1.length!=ar2.length){
            return false;
        }
        for (int i = 0; i < ar1.length; i++) {
            m.put(ar1[i], m.getOrDefault(ar1[i], 0)+1);
        }
        for(int i=0;i<ar1.length;i++){
            if(!m.containsKey(ar2[i])){
                return false;
            }
            if(m.containsKey(ar2[i])){
                if(m.get(ar2[i])==1){
                    m.remove(ar2[i]);
                }
                else{
                    m.put(ar2[i], m.getOrDefault(ar2[i], 0)-1);
                }
            }
        }
        return true;
    }
    static  String isSubset( long ar1[], long ar2[], long n, long s) {
        
        Map<Long,Long> m=new HashMap<>();
        for (int i = 0; i <n; i++) {
            m.put(ar1[i], m.getOrDefault(ar1[i], (long) 0)+1);
        }
        for(int i=0;i<s;i++){
            if(!m.containsKey(ar2[i])){
                return "No" ;
            }
            if(m.containsKey(ar2[i])){
                if(m.get(ar2[i])==1){
                    m.remove(ar2[i]);
                }
                else{
                    m.put(ar2[i], m.getOrDefault(ar2[i], (long) 0)-1);
                }
            }
        }
        return "Yes";
    }
    // static int doUnion(int arr1[], int arr2[]){
    // //     Set<Integer> a=new HashSet<>();
    // //     for (int i : arr1) {
    // //         a.add(i);
    // //     }
    // //     for (int i : arr2) {
    // //         a.add(i);
    // //     }
    // //     return a.size();
    //  }
    static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse both arrays and add unique elements to result
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                }
                j++;
            } else {
                // Both elements are equal
                if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        
        // Add remaining elements of arr1
        while (i < n) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }
        
        // Add remaining elements of arr2
        while (j < m) {
            if (result.isEmpty() || result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        
        return result;
    }
    static int findmerge2(int[] arr1, int[] arr2, int m, int n, int k) {
        int d = 0, i = 0, j = 0;

        // Traverse both arrays until we reach the k-th element
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                d++;
                if (d == k)
                    return arr1[i];
                i++;
            } else {
                d++;
                if (d == k)
                    return arr2[j];
                j++;
            }
        }

        // If arr2 is completely traversed
        while (i < m) {
            d++;
            if (d == k)
                return arr1[i];
            i++;
        }

        // If arr1 is completely traversed
        while (j < n) {
            d++;
            if (d == k)
                return arr2[j];
            j++;
        }

        // Return -1 if k is out of the bounds of the merged array
        return -1;
    }
    static ArrayList<Integer> findIntersection(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse both arrays and add unique elements to result
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // Both elements are equal
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        return result;
    }
    static List<Integer> findIntersection(int[] arr1, int[] arr2) {
        // Ensure arr1 is the smaller array to minimize space usage
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        // Add all elements of the smaller array to set1
        for (int num : arr1) {
            set1.add(num);
        }

        // Find common elements in the larger array
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // Convert the set to a list and return it
        return new ArrayList<>(intersection);
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    static long  mergesort(long ar[],int l,int r){
        long count=0;
        if(l<r){
         int mid=(l+r)/2;            
       count+= mergesort(ar, l, mid);
       count+= mergesort(ar, mid+1, r);
       count+= merge(ar,l,mid,r);
      } 
       return count;
    }
    static long merge(long[] ar, int l, int mid, int r) {
        int n1=mid - l +1;
        int n2=r-mid;
        long lar[]=new long[n1];
        long rar[]=new long[n2];
        System.arraycopy(ar,l,lar,0,n1);
        System.arraycopy(ar, mid +1, rar, 0, n2);
        int i=0;
        int j=0;
        int k=l;
        long count=0;
        while (i<n1 && j<n2) {
            if(lar[i]<=rar[j]){
                ar[k]=lar[i];
                i++;
                k++; 
            }
            else{
                ar[k]=rar[j];
                count+= n1- i;
                j++;
                k++; 
            }
                       
        }
        while (i<n1){
            ar[k]=lar[i];
            i++;
            k++;
        }
        while (j<n2){
            ar[k]=rar[j];
            j++;
            k++;
        }
        return count;
    }
    static long inversionCount(long arr[], int n) {
        return mergesort(arr, 0, n-1);
    } 
    public boolean canSortArray(int[] nums) {
        int n = nums.length;

        // Copy the original array to values
        int[] values = Arrays.copyOf(nums, n);

        // First Pass: Iterate from left to right
        // Goal: Move the maximum value of each segment as far right as possible
        for (int i = 0; i < n - 1; i++) {
            if (values[i] <= values[i + 1]) {
                continue;
            } else {
                // Count the number of set bits using Integer.bitCount
                if (Integer.bitCount(values[i]) == Integer.bitCount(values[i + 1])) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i + 1];
                    values[i + 1] = temp;
                } else {
                    return false; // Return false if they cannot be swapped
                }
            }
        }

        // Second Pass: Iterate from right to left
        // Goal: Move the minimum value of each segment as far left as possible
        for (int i = n - 1; i >= 1; i--) {
            if (values[i] >= values[i - 1]) {
                continue;
            } else {
                // Count the number of set bits using Integer.bitCount
                if (
                    Integer.bitCount(values[i]) ==
                    Integer.bitCount(values[i - 1])
                ) {
                    // Swap them if they have the same number of set bits
                    int temp = values[i];
                    values[i] = values[i - 1];
                    values[i - 1] = temp;
                } else {
                    return false; // Return false if they cannot be swapped
                }
            }
        }

        // If both passes complete without returning false, the array can be sorted
        return true;
    }















    
    public static void main(String[] args) {
        // int[] ar={1,2,4,3,3};
        // System.out.println("before swapping");
        // for (int n : ar) {
        //     System.out.print( n + " ");
        // }
        // System.out.println();
        // System.out.println(findDisappearedNumbers(ar));
        // System.out.println("after swapping");
        // for (int n : ar) {
        //     System.out.print(n + " ");
        // }
         int ar2[]={1,1,9,6,7};
         System.out.println(Arrays.toString(frequencySort(ar2)));
     }
}
