import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode next;
         TreeNode() {}
         TreeNode(int val){
             this.val = val;
             }
         TreeNode(int val, TreeNode left, TreeNode right){
             this.val = val;
             this.left = left;
             this.right = right;
         }
         TreeNode(int val, TreeNode left, TreeNode right,TreeNode next){
            this.val = val;
            this.left = left;
            this.right = right;
            this.next=next;
        }
        public boolean isBalanced(TreeNode root) {
            if(root==null){
                return true;
            }
            if(Math.abs(height(root.left)-height(root.right))>=2 &&Math.abs(height(root.left)-height(root.right))>=-2 ){
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        static int height(TreeNode root){
            if(root==null){
                return 0;
            }
            return Math.max(height(root.left),height(root.right))+1;
        }
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
             if (root.left == null) {
                return minDepth(root.right) + 1;
             }
            if (root.right == null) {
               return minDepth(root.left) + 1;
            }
            return 1+ Math.min(minDepth(root.left),minDepth(root.right));
        }
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        }
         public TreeNode find(TreeNode root,int key){
            if(root==null){
                return null;
            }
            if(root.val==key){
                return root;
            }
            TreeNode findLeft=find(root.left, key);
            if(findLeft!=null){
                return findLeft;
            }
            return find(root.right,key);
         }
         public int level(TreeNode root,TreeNode key,int lev){
            if(root==null){
                return 0;
            }
            if(root==key){
                return lev;
            }
            int l=level(root.left, key,lev+1);
            if(l!=0){
                return l;
            }
            return level(root.right, key, lev+1);
         }
         public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            if (root == null) {
            return new ArrayList<>();
            }
            q.add(root);
            while (!q.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                res.add(level);
            }
            return res; 
         }
         public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res=new ArrayList<>();
            Deque<TreeNode> q=new LinkedList<>();
            if (root == null) {
            return new ArrayList<>();
            }
            q.add(root);
            boolean flag=true;
            while (!q.isEmpty()){
                List<Integer> level = new ArrayList<>();
                int size = q.size();
               if(flag){
                for(int i=0;i<size;i++){
                    TreeNode node=q.pollFirst();
                    level.add(node.val);
                    if (node.left != null) {
                        q.addLast(node.left);
                    }
                    if (node.right != null) {
                        q.addLast(node.right);
                    }
                }
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode node=q.pollLast();
                    level.add(node.val);
                    if (node.left != null) {
                        q.addFirst(node.left);
                    }
                    if (node.right != null) {
                        q.addFirst(node.right);
                    }
                }
            }
            flag=!flag;
            res.add(level);
            }
            return res; 
    }
         public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res=new ArrayList<>();
            Queue<TreeNode> q=new LinkedList<>();
            if (root == null) {
            return new ArrayList<>();
            }
            q.add(root);
            while (!q.isEmpty()){
                double avg=0;
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeNode node=q.poll();
                    avg+=node.val;
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
                avg/=size;
                res.add(avg);
            }
            return res; 
    }
         public TreeNode Succecer(TreeNode root,int key) {
            Queue<TreeNode> q=new LinkedList<>();
            if (root == null) {
            return null;
            }
            q.add(root);
        while (!q.isEmpty()){
                TreeNode node=q.poll();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.val==key) {
                    break;
                }
        }
        return q.peek(); 
     }
         public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
        // One of the nodes is null, or their values are different
            if (p == null || q == null || p.val != q.val) return false;
         
            // Recursively check the left and right subtrees
           return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
           }
         public TreeNode connect(TreeNode root) {
           if(root==null){
               return root;
           }
           TreeNode LeftNode=root;
           while(LeftNode.left!=null){
              TreeNode current=LeftNode;
              while(current!=null){
                 current.left.next=current.right;
                 if(current.next!=null){
                    current.right.next=current.next.left;
                 }
                 current=current.next;                                
            }
            LeftNode=LeftNode.left;
        }
        return root;
    }
         public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if (root == null) {
        return new ArrayList<>();
        }
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(i==size-1){
                    res.add(node.val);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return res; 
}
         public Boolean isSiblings(TreeNode root,TreeNode x,TreeNode y){
             if(root==null){
                return false;
             }
             return ( root.left==x && root.right==y) || (root.right==x && root.left==y) || isSiblings(root.left, x, y) || isSiblings(root.right, x, y);
         }
         public boolean isCousins(TreeNode root, int x, int y) {
                TreeNode xx=find(root, x);
                TreeNode yy=find(root, y);
                return  (level(root,xx,0)==level(root, yy, 0)) && !isSiblings(root, xx, yy);
         } 
         public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            Queue<TreeNode> q=new LinkedList<>();
            q.add(root.left);
            q.add(root.right);
            while(!q.isEmpty()){
                TreeNode left=q.poll();
                TreeNode right=q.poll();
                if(left==null && right==null){
                    continue;
                }
                if(left==null || right==null){
                    return false;
                } 
                if(left.val!=right.val){
                    return false;
                }
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);
            }       
             return true;         
        }
         public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null) return false;
            if(root.left == null && root.right == null) return targetSum == root.val;
            boolean leftSum = hasPathSum(root.left, targetSum - root.val);
            boolean rightSum = hasPathSum(root.right, targetSum - root.val);
            return leftSum || rightSum;
        }
         public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> res=new ArrayList<>();
            helper(root,targetSum,ans,res);
            return ans;
        }
         static void helper(TreeNode root,int target,List<List<Integer>> ans,List<Integer> temp){
            if(root==null){
                return;
            } 
            temp.add(root.val);
            if(root.left == null && root.right == null){
                if(target==root.val){
                ans.add(new ArrayList<>(temp));
                }
            }
            helper(root.left,target-root.val,ans,temp);
            helper(root.right,target-root.val,ans,temp);
            temp.remove(temp.size()-1);
            
    
        }
         public TreeNode invertTree(TreeNode root) {
            if (root == null) {
               return null;
           }
           
           TreeNode temp = root.left;
           root.left = root.right;
           root.right = temp;
           
           invertTree(root.left);
           invertTree(root.right);
           return root;  
       }
         public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
           return null;
       }
        if (root1 == null) {
           return root2;
       }
        if (root2 == null) {
           return root1;
       }
         TreeNode sumroot = new TreeNode(root1.val + root2.val);
         sumroot.left = mergeTrees(root1.left, root2.left);
         sumroot.right = mergeTrees(root1.right, root2.right);
         return sumroot;

   }
         public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
       int sum = 0;
   
       // Check if the left child is a leaf
       if (root.left != null && root.left.left == null && root.left.right == null) {
           sum += root.left.val; // Add value of left leaf
       }
       // Recur for left and right children
       sum += sumOfLeftLeaves(root.left);
       sum += sumOfLeftLeaves(root.right);
       return sum;
       }
         public List<Integer> inorderTraversal(TreeNode root) {
            if(root==null){
                return new ArrayList<>();
            }
            List<Integer> s=new ArrayList<>();
            inorderRec(root,s);
            return s;
    
        }
         private void inorderRec(TreeNode root, List<Integer> list)
        {
            if(root != null){
                inorderRec(root.left,list);
                list.add(root.val);
                inorderRec(root.right,list);
            }
        }
         public List<Integer> preorderTraversal(TreeNode root) {
            if(root==null){
               return new ArrayList<>();
           }
           List<Integer> s=new ArrayList<>();
           preorderRec(root,s);
           return s;
   
       }
         private void preorderRec(TreeNode root, List<Integer> list)
       {
           if(root != null){
               list.add(root.val);
               preorderRec(root.left,list);
               preorderRec(root.right,list);
           }
       }
         public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> s=new ArrayList<>();
        postorderRec(root,s);
        return s;
    }
         private void postorderRec(TreeNode root, List<Integer> list)
    {
        if(root != null){
            postorderRec(root.left,list);
            postorderRec(root.right,list);
            list.add(root.val);
        }
    }
         public int diameter=0;
         public int diameterOfBinaryTree(TreeNode root) {
             helper(root);
             return diameter;
         }
         private int helper(TreeNode root){
               if(root==null){
                 return 0;
             } 
             int left1=helper(root.left);
             int right1=helper(root.right);
             int dia=left1+right1;
             diameter=Math.max(diameter,dia);
             return Math.max(left1,right1)+1;
         }
         public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0, nums.length - 1);
        }
         private TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right) {
                return null; // Base case: no elements to form a node
            }
    
            // Find the middle index
            int mid = left + (right - left) / 2;
    
            // Create a TreeNode with the middle element
            TreeNode node = new TreeNode(nums[mid]);
    
            // Recursively build the left and right subtrees
            node.left = buildBST(nums, left, mid - 1);
            node.right = buildBST(nums, mid + 1, right);
    
            return node;
        }
         public boolean isValidBST(TreeNode root) {
            return helper(root,null,null);
        }
         public boolean helper(TreeNode root,Integer low,Integer high){
            if(root==null){
                return true;
            }
            if(low!=null && root.val<=low ){
                return false;
    
            }
            if(high!=null && root.val>=high ){
                return false;
            }
            boolean left1=helper(root.left, low,root.val);
            boolean right1=helper(root.right,root.val,high);
            return left1 && right1;
        }
         public void flattentolinkedlist(TreeNode root) {
            TreeNode current=root;
            while(current!=null){
                if(current.left!=null){
                    TreeNode temp=current.left;
                    while(temp.right!=null){
                        temp=temp.right;
                    }
                    temp.right=current.right;
                    current.right=current.left;
                    current.left=null;
                }
                 current=current.right;
            }
        }
         public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1; // or handle the case as needed
        }

        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add the level sum to the min-heap
            if (minHeap.size() < k) {
                minHeap.add(levelSum);
            } else if (levelSum > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest sum
                minHeap.add(levelSum);
            }
        }

        // If we have fewer than k level sums
        if (minHeap.size() < k) {
            return -1; // or throw an exception as per requirement
        }

        return minHeap.peek(); 
    }
         public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         return checker(root1, root2);
         }
         private boolean checker(TreeNode node1, TreeNode node2) {
             if (node1 == null && node2 == null) {
                return true;
             }
             if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            return (checker(node1.left, node2.left) || checker(node1.left, node2.right)) &&
               (checker(node1.right, node2.right) || checker(node1.right, node2.left));
        }    
         private int BFS(TreeNode root){
            int ind=0;
            int ans=0;
            Queue<TreeNode> q=new LinkedList<>();
            int maxsum=Integer.MIN_VALUE;
            q.add(root);
            while(!q.isEmpty()){
               int l=q.size();
                ind++;
                int value=0;
                for(int i=0;i<l;i++){
                    TreeNode r=q.poll();
                    value+=r.val;
                    if(r.left!=null){
                        q.add(r.left);
                    }
                    if(r.right!=null){
                        q.add(r.right);
                    }
                }
                if(maxsum<value){
                    maxsum=value;
                    ans=ind;
                }
            }
            return ans;
        }
         public int maxLevelSum(TreeNode root) {
            if(root.left==null && root.right==null){
                return 1;
            }
            return BFS(root);
        }
         public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        return (left!=null)?left:right;        
    }
         public TreeNode lowestCommonAncestorbst(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorbst(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorbst(root.right, p, q);
        } else {
            return root;
        }
        }     
         private int count=0;
         public int kthSmallest(TreeNode root, int k) {
        return solve(root,k).val;
    }
         public TreeNode solve(TreeNode root,int k){
        if(root==null){
            return null;
        }
        TreeNode left=solve(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return root;
        }
        return solve(root.right,k);
    }
         int pre=0;
         Map<Integer, Integer> map=new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
           for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
           return build(0, preorder.length-1, preorder);
        }
        private TreeNode build(int left, int right, int[] preorder){
        if(pre>=preorder.length) return null;
        if(right<left) return null;
        TreeNode root=new TreeNode(preorder[pre]);
        int in=map.get(preorder[pre++]);
        root.left=build(left, in-1, preorder);
        root.right=build(in+1, right, preorder);
        return root;
    }
        public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }
        public TreeNode deserialize(String data){
           if (data.isEmpty()) return null;
           String[] values = data.split(",");
           TreeNode root = new TreeNode(Integer.parseInt(values[0]));
           Queue<TreeNode> queue = new LinkedList<>();
           queue.offer(root);
           int i = 1;
           while (!queue.isEmpty()) {
              TreeNode node = queue.poll();
              if (!values[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftNode;
                queue.offer(leftNode);
              }
              i++;
              if (!values[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightNode;
                queue.offer(rightNode);
              }
              i++;
           }
           return root;
        }
        public int sumNumbers(TreeNode root) {
        return help(root,0);
    }
        int help(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        sum=sum*10+root.val;
        if(root.left==null && root.right==null){
           return sum;
        }
        return help(root.left,sum)+help(root.right,sum);
    }
        int ans=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
          helps(root);
          return ans;
        }
        int helps(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helps(root.left);
        int right=helps(root.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int pathsum=left+right+root.val;
        ans=Math.max(ans,pathsum);
        return Math.max(left,right)+root.val;
    }
    public  TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return root;
        }
        if(root.val==val){
            return root;
        }
        else if(root.val>val) 
           return searchBST(root.left,val);
        else   
           return searchBST(root.right,val);

    }
     int i=0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public  TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
          
          // If the endWord is not in the wordList, return 0
          if (!wordSet.contains(endWord)) {
              return 0;
          }
          
          // Set to track visited words
          Set<String> visited = new HashSet<>();
          // Queue for BFS
          Queue<String> queue = new LinkedList<>();
          
          // Initialize the queue with the beginWord
          queue.add(beginWord);
          visited.add(beginWord);
          
          // Initialize the step count
          int length = 1; // Starting from beginWord
          
          while (!queue.isEmpty()) {
              int size = queue.size();
              
              for (int i = 0; i < size; i++) {
                  String curr = queue.poll();
                  
                  // Try changing each character of the current word
                  for (int j = 0; j < curr.length(); j++) {
                      char[] arr = curr.toCharArray();
                      
                      // Try every letter from 'a' to 'z' at the current position
                      for (char ch = 'a'; ch <= 'z'; ch++) {
                          arr[j] = ch;
                          String newWord = new String(arr);
                          
                          // If we reach the endWord, return the current length + 1
                          if (newWord.equals(endWord)) {
                              return length + 1;
                          }
                          
                          // If the new word is valid and not visited, add it to the queue
                          if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                              queue.add(newWord);
                              visited.add(newWord);
                          }
                      }
                  }
              }
              
              // Increment the length after processing one level
              length++;
          }
          
          return 0; // If no transformation sequence is found
      }
      public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return find(root, k, seen);
    }

    private boolean find(TreeNode node, int k, Set<Integer> seen) {
        if (node == null) {
            return false; // Base case: if the node is null
        }

        if (seen.contains(k - node.val)) {
            return true; // Found two values that add up to k
        }

        // Add the current node's value to the set
        seen.add(node.val);
        
        // Recursively search in the left and right subtrees
        return find(node.left, k, seen) || find(node.right, k, seen);
    }
    
    
    
    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            TreeNode obj = new TreeNode();
            System.out.println(obj.isSiblings(root, root.left, root.left.right));
            TreeNode result=obj.find(root,5);    
            // Print the result
            System.out.println(result.val);

         }
}
