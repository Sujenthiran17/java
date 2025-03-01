import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class matrix {
    static int findmax(int mat[][] ,int mid){
        int index=0;
        int maxi=0;
        for(int i=0;i<mat.length;i++){
              if(mat[i][mid]>maxi){
                maxi=mat[i][mid];
                index=i;
              }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int l=0;
        int h=mat[0].length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            int index=findmax(mat,mid);
            int left=((mid-1)>=0)? mat[index][mid-1] : -1;
            int right=((mid+1)<mat[0].length)? mat[index][mid+1] : -1;
            if(mat[index][mid]>left && mat[index][mid]>right){
                return new int[] {index,mid};
            }
            else if(mat[index][mid]<left){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return new int[] {-1,-1};
    }
      static void printmatrix(int[][] ar){
        // int ar[][]=new int[3][3];
        // for (int i = 0; i < ar.length; i++) {
        //     for (int j = 0; j < ar[i].length; j++) {
        //         ar[i][j]=(int)(Math.random()*10);
        //     }       
        // }
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                System.out.print(ar[i][j]+ " ");
            } 
            System.out.println();       
        }
      }
      static void addsubMat(int ar1[][],int ar2[][]){
        int arr3[][]=new int[3][3];
        int arr4[][]=new int[3][3];
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[i].length; j++) {
                 arr3[i][j]=ar1[i][j]+ar2[i][j];
                 System.out.print(arr3[i][j]+ " ");
            } 
            System.out.println();       
        }
        System.out.println();
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[i].length; j++) {
                 arr4[i][j]=ar1[i][j]-ar2[i][j];
                 System.out.print(arr4[i][j]+ " ");
            } 
            System.out.println();       
        }
   }
      static void matrixmul(int ar1[][],int ar2[][]){
        int arr3[][]=new int[3][3];
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[i].length; j++) {
                for(int k=0;k<ar1.length;k++){
                    arr3[i][j]+=ar1[i][k]*ar2[k][j];
                } 
            System.out.print( arr3[i][j] + " ");     
        }
        System.out.println();
    }
      }
      static void transpose(int ar1[][]) {
        int[][] trans=new int[3][3];
        // for (int i = 0; i < trans.length; i++) {
        //     for (int j = 0; j < trans.length; j++) {
        //         trans[i][j]=ar1[j][i];
        //         System.out.print(trans[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < trans.length-1; i++) {
            for (int j = i+1; j < trans.length; j++) {
                int temp=ar1[i][j];
                ar1[i][j]=ar1[j][i];
                ar1[j][i]=temp;
            }
        }
      }         
      static void zigzag(int ar1[][]){
        for (int i = 0; i < ar1.length; i++) {
            if(i%2==0){
                    for (int j = 0; j < ar1[i].length; j++) {
                        System.out.print(ar1[i][j]+ " ");
                    } 
                    System.out.println();       
                }
            else{
                    for (int j = ar1[i].length-1; j >=0; j--) {
                        System.out.print(ar1[i][j]+ " ");
                    } 
                    System.out.println();       
                }
        }
      }
      static void boundaryOfMat(int[][] ar1){
        int i=0;
        int j=0;
        for ( j = 0; j < ar1.length; j++) {
            System.out.print(ar1[i][j] + " ");
        }
        System.out.println();
        j=ar1.length-1;
        for ( i= 1; i < ar1.length; i++) {
            System.out.print(ar1[i][j] + " ");
        }
        System.out.println();
        i=ar1.length-1;
        for ( j = ar1.length-2; j >=0; j--) {
            System.out.print(ar1[i][j] + " ");
        }
        System.out.println();
        j=0;
        for ( i = ar1.length-2; i >0; i--) {
            System.out.print(ar1[i][j] + " ");
        }

      }
      static boolean searchMatrix(int[][] ar, int target) {
        int i=0, j=ar[0].length-1;
        while(i<ar.length && j>=0){
            if(ar[i][j]==target){
                return true;
            }
            else if(target<ar[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }
      static boolean searchMatrix2(int[][] matrix, int target) { 
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right-left)  / 2;
            int mid_val = matrix[mid / n][mid % n];

            if (mid_val == target)
                return true;
            else if (mid_val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
      static  List<Integer> spiralOrder(int[][] ar) {
        ArrayList<Integer> res=new ArrayList<>();
        int l=0;int r=ar[0].length-1;
        int top=0;int bottom=ar.length-1;
        while (l<=r && top<=bottom) {
            for (int i = l; i <=r; i++) {
                res.add(ar[top][i]);
            }
            top++;
            for ( int i= top; i <= bottom; i++) {
                res.add(ar[i][r]);
            }
            r--;
            if(l<=r && top<=bottom) {
           for (int i = r; i >= l; i--) {
                    res.add(ar[bottom][i]);
           }
           bottom--;
           for (int i = bottom; i >= top; i--) {
             res.add(ar[i][l]);
           }
           l++;
        }
        }
        return res;    
    }
      static boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i++) {
                for (int j = 0; j < matrix[i].length - 1; j++) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
                }
            }
            return true;
        }
      static int diagsum(int[][] ar){
        int sum=0;
        int sum1=0;
        for (int i = 0; i < ar.length; i++) {
            sum=sum + ar[i][i];
            sum1=sum1+ ar[i][ar.length-(i+1)];
        }
        return sum +sum1;
      }
      static int[][] reversemat(int ar[][]){
        for (int i = 0; i < ar.length; i++) {
            int l=0;
            int r=ar[0].length-1;
            while(l<=r){
                int temp=ar[i][l];
                ar[i][l]=ar[i][r];
                ar[i][r]=temp;
                l++;
                r--;
            }
        }
        return ar;
      }
      static void rotate(int[][] ar) {
        for (int i = 0; i < ar.length-1; i++) {
             for (int j = i+1; j < ar.length; j++) {
                 int temp=ar[i][j];
                 ar[i][j]=ar[j][i];
                 ar[j][i]=temp;
             }
         }
         for (int i = 0; i < ar.length; i++) {
                int l=0;
                int r=ar[0].length-1;
             while(l<r){
                 int temp=ar[i][l];
                 ar[i][l]=ar[i][r];
                 ar[i][r]=temp;
                 l++;
                 r--;
             }
         }
     }
      static ArrayList<Integer> snakePattern(int matrix[][]){
         ArrayList<Integer> L=new ArrayList<>();
         for (int i = 0; i < matrix.length; i++) {
            if(i%2==0){
                for (int j = 0; j < matrix[0].length; j++) {
                    L.add(matrix[i][j]);
                }
            }
            else{
                for (int j = matrix[0].length-1; j >=0; j--) {
                    L.add(matrix[i][j]);
                }
            }
         }
         return L;
     }
      static int[][] mergeintervals(int[][] s) {
       Arrays.sort(s,(a,b)->Integer.compare(a[0], b[0])); 
       List<int[]> m=new ArrayList<>();
       for (int i = 0; i < s.length; i++) {
        if(m.isEmpty() || s[i][0]>m.get(m.size()-1)[1]){
            m.add(s[i]);
        }
        else{
            m.get(m.size()-1)[1]=Math.max(m.get(m.size()-1)[1],s[i][1]);
        }
       }
       return  m.toArray(new int[m.size()][]);
     }
      static int countNegatives(int[][] grid) {
        int l=0;
        int r=grid[0].length-1;
        int count=0;
        while(l<grid.length && r>=0){
            if(grid[l][r]<0){
                count+=grid.length-l;
                r--;
            }
            else{
                l++;
            }
        }
        return count;
    }
      static  boolean isValidSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] boxIdx = new boolean[9][9];
    
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    char ch = board[i][j];
                    if(ch == '.')
                        continue;
                    int num = ch - '1'; //converts character to integer.
                    int box = (i/3)*3 + j/3;
                    if(rows[i][num] || cols[j][num] || boxIdx[box][num])
                        return false;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxIdx[box][num] = true;
                }
            }
            return true;
        }
    // 16 problem
       static  public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == 1) { // If it's land
                   perimeter += 4; // Start with 4 sides
                   // Reduce perimeter for adjacent land
                   if (i > 0 && grid[i - 1][j] == 1) perimeter--; // Up
                   if (i < grid.length - 1 && grid[i + 1][j] == 1) perimeter--; // Down
                   if (j > 0 && grid[i][j - 1] == 1) perimeter--; // Left
                   if (j < grid[0].length - 1 && grid[i][j + 1] == 1) perimeter--; // Right

                   // Early exit if perimeter is fully counted (if needed)
                   // return perimeter; // Uncomment if you want to exit early after finding the first land
               }
           }
       }

       return perimeter;
   }
   static int upperBound(int[] arr, int x, int n) {
    int low = 0, high = n - 1;
    int ans = n;

    while (low <= high) {
        int mid = (low + high) / 2;
        // maybe an answer
        if (arr[mid] > x) {
            ans = mid;
            // look for a smaller index on the left
            high = mid - 1;
        } else {
            low = mid + 1; // look on the right
        }
    }
    return ans;
}
static int countSmallEqual(int[][] matrix, int m, int n, int x) {
    int cnt = 0;
    for (int i = 0; i < m; i++) {
        cnt += upperBound(matrix[i], x, n);
    }
    return cnt;
}
static int median(int[][] matrix, int m, int n) {
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

    // point low and high to right elements
    for (int i = 0; i < m; i++) {
        low = Math.min(low, matrix[i][0]);
        high = Math.max(high, matrix[i][n - 1]);
    }

    int req = (n * m) / 2;
    while (low <= high) {
        int mid = (low + high) / 2;
        int smallEqual = countSmallEqual(matrix, m, n, mid);
        if (smallEqual <= req) low = mid + 1;
        else high = mid - 1;
    }
    return low;
}
public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return;

int rows = matrix.length;
int cols = matrix[0].length;
boolean[] zeroRows = new boolean[rows];
boolean[] zeroCols = new boolean[cols];

// First pass: find all the zero positions
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == 0) {
            zeroRows[i] = true;
            zeroCols[j] = true;
        }
    }
}

// Second pass: set the rows and columns to zero
for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        if (zeroRows[i] || zeroCols[j]) {
            matrix[i][j] = 0;
        }
    }
}
}
     public static void main(String[] args) {
       int matrix[][]={{1,3},{2,6},{7,9}}; 
       int n[][]=mergeintervals(matrix);
       for(int i=0;i<n.length;i++){
        for(int j=0;j<n.length;j++){
            System.out.println(n[i][j]);
        }
        System.out.println();
       }
           
    }    
}