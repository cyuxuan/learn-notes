# 算法导论
## 第1章-算法在计算中的作用
### 1.1 算法
- 算法是什么
  - 算法是一种求解特定问题的计算过程。
- 数据结构是什么
  - 数据结构是一种存储和组织数据的方式。
  - 此处提到一个NP问题
    - 概念
      - NP问题是：多项式复杂程度的非确定性问题
      - 注：暂时不理解，后续更新
- 算法导论的作用
  - 教学一些算法设计与分析的技术，以便读者能自行设计算法、证明其正确性和理解其效率。

### 1.1 作为一种技术的算法


## 第2章 算法基础
### 2.1 插入排序
- 输入：n个数的一个序列(a1,a2,a3,...,an)。
- 输出：输入序列的一个排列(a1`,a2`,a3`,...,an`)。
- 插入排序
  - 简介
    - 对于少量元素的排序，它是一个有效的算法。
  - 过程
    1. 取出i位置上的值，将其与1到i位置上的值逐一进行比较，直到找到其正确位置。
    2. i指向下一个位置，重复1步骤。(i从第一个位置直到最后一个位置)
```伪代码
for j = 2 to A.length
    key = A[j]
    // 将A[j] 插入到A[1,j-1]中
    i = j - 1
    while i > 0 and A[i] > key
        A[i + 1] = A[i]
        i = i - 1
    A[i + 1] = key
```

### 2.2 分析算法

### 2.3 设计算法

#### 2.3.1 分治法
- 递归
  - 为了解决一个给定的问题，算法一次或者多次递归地调用其自身以解决紧密相关的若干子问题。
- 分治
  - 将原问题分解为几个规模较小但类似于原问题的子问题，递归地求解这些子问题，然后再合并这些子问题的解来建立原问题。
  - 分支模式再每层递归时都有三个步骤
    1. 分解原问题为若干子问题，这些子问题时原问题的规模较小的实例。
    2. 解决这些子问题。递归地求解各子问题。然而，若子问题的规模足够小，则直接求解。
    3. 合并这些子问题的解成原问题的解。
- 分支法例子
  - 归并排序(归并排序是严格的分治法)
  - 归并排序的简介


``` 伪代码 MERGE(A,p,q,r)
// 计算出第一个串的归并数量
n1 = q - p + 1
// 计算出第二个串的归并数量
n2 = r - q
// 重新赋值给新的数组-具体实现时操作下表即可
let L[1...n1+1] and R[1...n2+1] be new arrays
for i = 1 to n1
  L[i] = A[p + i - 1]
for j = 1 to n2
  R[i] = A[q + j]
// 末尾置为无穷大-方便对比  
L[n1 + 1] = MAX
R[n2 + 1] = MAX
// 开始归并
i = 1
j = 1
for k = p to r
  if L[i] <= R[j]
    A[k] = L[i]
    i = i + 1
  else
    A[k] = R[j]
```

``` 伪代码 MERGE-SORT(A,p,r)
if(p < r)
  q = (p + r) / 2 [向下取整]
  // 排序前一半
  MERGE-SORT(A, p, q)
  // 排序后一半
  MERGE-SORT(A, q + 1, r)
  // 排序全部
  MERGE(A, p, q, r)
```
#### 2.3.2 分治法分析

## 第3章 函数的增长(！！！暂缺！！！)

## 第4章 分治策略
### 4.1 最大子数组问题
- 例
  - 设存在数组
    - {110,113,110,85,,105,102,86,63,81,101,94,106,101,79,94,90,97}
    - 其中n[x],n[y]均属于该数组，且y>x，求xy为何值时n[y] - n[x]取最大值
  - 解法
    1. 暴力求解
    2. 递归(分治策略)
    - 分治策略解法
    - 该分治策略就是从每个位置开始找寻往左右两边进行探测，看能达到的最大数是多少。也是一种遍历。空间换了时间。
```伪代码
FIND-MAX-CROSSING-SUBArrAY(A, low, mid, high)
  // 初始化左边数组和为最小值
  left-sum = MIN
  // 初始化sum，记录当前数组中的最大值
  sum = 0
  // 从mid位置开始向左边进行探测，获取当前最大和的数组边界
  for i = mid downto low
    sum = sum + A[i]
    if(sum > left-sum) {
      // 如果新的探测和大于原本的和，则更新和
      left-sum = sum
      // 且充值下表
      max-left
    } 
  // 右边同理
  right-sum = MIN
  sum = 0
  for j = mid + 1 to high
    sum = sum + A[i]
    if sum > right-sum
      right-sum = sum
      max-right = j
return (max-left, max-right, left-sum + right-sum)
```
```伪代码
FIND-MAX-SUBARRAY(A, low, high)
  if high == low
    return (low, high, A[low])
  else mid = (low + high) / 2 (向下取整)
    // 找左边最大子数组
    (left-low, left-high, left-sum) = FIND-MAX-SUBARRAY(A, low, mid)
    // 找右边最大子数组
    (right-low, right-high, right-sum) = FIND-MAX-SUBARRAY(A, mid + 1, high)
    // 找以某个位置为起点向左右两边探测出的最大子数组
    (cross-low, cross-high, cross-sum) = FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
    // mid为起点向左边探测的和大于mid为起点向右边探测的和且大于mid为起点向左右探测的和
    if(left-sum >= right-sum and left-sum >= cross-sum)
      return (left-low, left-high, left-sum)
    // mid为起点向右边探测的和大于mid为起点向左边探测的和且大于mid为起点向左右探测的和
    elseif (right-sum >= left-sum and right-sum >= cross-sum)
      return (right-low, right-high, right-sum)
    // 否则为mid为起点向左右两边探测的值最大
    else
      return (cross-low, cross-hgih, cross-sum)
```

###  矩阵乘法的Strassen算法（暂缺）-原理就是分块矩阵乘法


## 第5章 概率分析和随机算法（暂缺）-概念之后再理解

## 第6章 堆排序
### 堆是什么
  - 堆（二叉堆）是一个以数组形式存储的完全二叉树，分为大根堆和小根堆。
  - 大根堆是指除了根以外的节点都满足：A[PARANT(i)] >= A[i] (即父节点的值大于等于其下子节点的值)。小根堆同理。
  - 该数组有两个属性，heap-size(有效元素数量)，length(当前数组元素个数)。注意：只有heap-size指定的才是当前堆的元素数量。
  - 一些必要的函数
```伪代码
// 获取当前元素的父元素
PARANT(i)
  return i/2 // 向下取整

// 获取当前元素的左孩子
LEFT(i)
  return 2i

// 获取当前元素的右孩子
RIGHT(i)
  return 2i + 1

```

### 维护堆的性质
  - 当堆中某元素不满足堆的定义时，需要对其进行维护，使得当前堆重新满足堆的性质
  - 使用其下函数
```伪代码
MAX-HEAPIFY(A,i) // i指当前的元素位置
  l = LEFT(i)
  r = RIGHT(i)
  if l <= A.heap-size and A[l] > A[i] // 左孩子大于当前节点
    largest = l
  else largest = i
  if r <= A.heap-size and A[r] > A[largest]
    largest = r
  if largest != i
    exchange A[i] with A[largest]
    MAX-HEAPIFY(A, largest)
```

### 建堆
  - 自底向上不断使用堆的性质维护函数来维护当前数据满足堆，最终形成一个堆。
```伪代码
BUILD-MAX-HEAP(A)
  A.heap-size = A.length
  for i = A.length / 2(向下取整) downto 1 // 从排在最后的一个父元素开始进行堆性质的维护
    MAX-HEAPIFY(A,i)
```

### 堆排序算法
  - 不断维护堆的性质生成最大(最小)堆，每次生成后取出最大或者最小值，剩下部分再次生成最大或者最小堆，直到排序完成
``` 伪代码
HEAPSORT(A)
  BUILD-MAX-HEAP(A)
  for i = A.length downto 2
    exchange A[1] with A[i]
    A.heap-size = A.heap-size - 1
    MAX-HEAPIFY(A, 1)
```

### 优先队列
  - 优先队列是一种用来维护由一组元素构成的集合S的数据结构，其中的每一个元素都有一个相关的值，称为关键字。一个最大优先队列支持以下操作：
    - INSERT(S, x): 把元素x插入集合S中。这一操作等价于 S=S并{x}
    - MAXIMUM(S): 返回S中具有最大关键字的元素
    - EXTRACT-MAX(S): 去掉并返回S中的具有最大关键字的元素
    - INCREASE-KEY(S, x, k): 将元素x的关键字值增加到k，这里假设k的值不小于x的原关键字。
  - 最大优先队列的应用举例
    - 共享计算机系统的作业调度
  - 关于实现
    - HEAP-MAXIMUM可以再O(1)时间内实现MAXIMUM操作
    - 过程 HEAP-EXTRACT-MAX 实现 EXTRACT-MAX 操作。它与 HEAPSORT 过程中的for循环体部分很相似
    - 过程 HEAP-INCREASE-KEY 能够实现 INCREASE-KEY 操作在优先队列中，我们希望增加关键字的优先队列元素对应的数组下标i来标识。这一操作需要首先将元素A[i]的关键字更新为新值。增大A[i]的关键字可能会违反最大堆的性质。
    - MAX-HEAP-INSERT 能够实现INSERT操作。它的输入是要被插入到最大堆A中的新元素的关键字。MAX-HEAP-INSERT首先通过增加一个关键字为负无穷的叶节点来扩展最大堆。然后调用 HEAP-INCREASE_KEY 为新结点设置对应的关键字，同时保持最大堆的性质
```伪代码

HEAP-MAXIMUM(A)
  return A[1]


HEAP-EXTRACT-MAX(A)
  if A.heap-size < 1
    error "heap underflow"
  max = A[1]
  A[1] = A[A.heap-size]
  A.heap-size = A.heap-size - 1
  MAX-HEAPIFY(A, 1)
  return max

HEAP-INCREASE-KEY(A, i, key)
  if key < A[i]
    error "new key is samller than current key"
  A[i] = key
  while i > 1 and A[PARENT(i)] < A[i]
    exchange A[i] with A[PARENT(i)]
    i = PARENT(i)


MAX-HEAP-INSERT(A, key)
  A.heap-size = A.heap-size + 1
  A[A.heap-size] = 负无穷
  HEAP-INCREASE-KEY(A, A.heap-size, key)

```


## 第7章 快速排序
### 7.1 快速排序的描述
- 与归并排序一样，快速排序也使用了分治的思想。
- 分组：数组A[p..r]被划分为两个(可能为空)子数组A[p..q-1]，使得A[p...q-1]中的每一个元素都小于等于A[q]，而A[q]也小于等于A[q+1...r]中的每个元素。

```伪代码
QUICKSORT(A,p,r)
  if(p < r)
    // 获取中位数应在在的下标
    q = PARTITION(A, p, r)
    QUICKSORT(A,p,q-1)
    QUICKSORT(A,q+1,r)

PARTITION(A, p, r)
  x = A[r]
  i = p - 1
  for j = p to r - 1
    if A[j] <= x
      i = i + 1
      exchange A[i] with A[j]
  exchange A[i + 1] with A[r]
  return i + 1
```

## 第8章 线
性时间排序
### 8.2计数排序
- 假设n个输入元素中的每一个都是在0到k区间内的一个整数，其中k为某个整数。当年k=O(n)时，排序的运行时间为O(n)
- 基本思想
  - 对于每一个输入元素x，确定小于x的元素个数。利用这一信息，就可以直接吧x放到它输出数组中的位置上了。当有几个元素相同时需要考虑重复问题。
- 在技术排序算法的代码中，假设输入是一个数组A[1..n]，A,length = n。我们还需要两个数组：B[1..n]存放排序的输出，C[0..k]提供临时存储空间。
```伪代码
COUNTING-SORT(A, B, k)
let C[0..k] be a new array
for i = 0 to k
  C[i] = 0
for j = 1 to A.length
  C[A[j]] = C[A[j]] + 1
for i = 1 to k
  C[i]=C[i]+C[i-1]
for j = A.length downto 1
  B[C[A[j]]] = A[j]
  C[A[j]] = C[A[j]] - 1
```

### 8.3 基数排序
- 了解概念即可

### 8.4 桶排序
- 桶排序假设输入数据服从均匀分布，平均情况下他们的时间代价为O(n)。与计数排序类似，因为对输入数据作了某种假设，桶排序的速度也很快。4
- 桶的概念是，在均匀分布的数据中，不同样本就是在不同桶中，简单做法是数组中每个元素后接着一个链表，不同链表就是不同的桶，该排序就是将不同数据分区后再进行顺序排序。
```伪代码
BUCKET-SORT(A)
  n = A.length
  let B[0..n-1] be a new array
  for i = 0 to n - 1
    makeB[i] an empty list
  for i = 1 to n
    insert A[i] into list B[nA[i](nA[i]向下取整)]
  for i = 0 to n - 1
    sort list B[i] with insertion sort
  concatenate the lists B[0],B[1],...,B[n-1] together in order
```

## 第9章 中位数和顺序统计量

## 第10章 基本数据结构
### 栈和队列
### 链表
### 有根树

## 第11章 散列表
### 11.1 直接寻址表
- 当关键字无重复，且关键字集合中数量很小是可以使用直接寻址的方式。即散列方式就是关键字与内存一一对应。

### 11.2 散列表
- 当关键字集合很大，无法避免重复，则需要散列。
### 11.3 散列函数(k是关键字，m是当前散列表的大小)
- 除法散列法
  - 通过取法区域，来进行散列
- 乘法散列法
  - h(k) = m(kA mod 1) 向下取整
  - 这里 kA mod 1就是取小数部分
  - 就是将大区间关键字的范围映射到小区间上
- 全域散列法
  - 全域散列详解(https://zhuanlan.zhihu.com/p/145176403)
### 11.4 开放寻址法
- 又称开放定址法，当哈希碰撞发生时，从发生碰撞的那个单元起，按照一定的次序，从哈希表中寻找一个空闲的单元，然后把发生冲突的元素存入到该单元。
- 解决冲突的方法
  - 线性探测
    - 给定一个普通的散列函数h`:U->{0,1,2,...,m-1},称之为辅助散列函数，线性探查方法采用的散列函数为：
      - h(k,i) = (h`(k) + i) mod m, i = 0,1,...,m-1
    - 给定一个普通的散列函数，首先探查T[h\`(k)]，即由辅助散列函数所给出的槽位。再探查T[h`(k)+1]，依次类推直到循环整个序列。
  - 二次探查
    - h(k,i)=(h`(k) + c1_i + c2_i^2) mod m
    - 其中h\`是一个辅助撒捏函数，c1和c2为正的辅助常数，i=0,1...,m-1。初始的探查位置为T[`(k)]，后续的探查位置要加上一个偏移量。
  - 双重散列
    - 双重散列是用于开放寻址法的最好方法之一，因为它所产生的牌系列具有速记选择排列的许多特性
    - h(k,i) = (h1(k) + ih2(k) mod m)
    - 初始探查位置为T[h1(k)]，后续的探查位置是前一个位置加上偏移量h2(k)模m。
### 11.5 完全散列
  - 采用两级单列方式，散列表和散列表后接的链表都采用散列。
## 第12章 二叉搜索树
### 12.1 什么是二叉搜索树
- 二叉搜索树由一颗二叉树来组织。可以使用链表的数据结构来表示，其中每个结点就是一个对象。除了key和卫星数据之外，每个结点还包含属性left，right和p,他们分别指向结点的左孩子，右孩子和双亲。如果某个孩子结点和父节点不存在，则相应属性的值为NULL。根节点是树中唯一父指针为NULL的结点。

```中序遍历-伪代码
INORDER-TREE-wALK(x)
  if x != NULL
    INORDER-TREE-wALK(x.left)
    print x.key
    INORDER-TREE-wALK(x.right)
```

### 12.2 查询二叉搜索树
- 查找
  - 输入一个指向树根的指针和一个关键字k，如果这个结点存在，TREE-SEARCH返回一个指向关键字为k的结点的指针；否则返回NULL。

```二叉树查找-伪代码
递归方式
TREE-SEARCH(x, k)
  if x== NULL or k == x.key
    return x;
  if k < x.key
    return TREE-SEARCH(x.left, k)
  else
    return TREE-SEARCH(x.right, k)

循环方式
INERATIVE-TREE-SEARCH(x,k)
  while x != NULL and k = x.key
    if x < x.key
      x = x.left
    else
      x = x.right
  return x
```
- 最小关键字，最小关键字一定再左下角
```最小关键字-伪代码
TREE-MINMUN(x)
  while x.left != NULL
    x.left
  return x
```

- 最大关键字，做大关键字一定再右下角
```最大关键字-伪代码
TREE-MAXIMUM(x)
  while x.right != NULL
    x = x.right
  return x
```

- 后继与前驱
  - 给定一颗二叉搜索树中的一个结点，有时候需要按中序遍历查它的后继。如果所有的关键字互不相同，则一个结点x的后继是大于x.key的最小关键字的结点。一颗二叉搜索树的结构允许我们通过没有任何关键字的比较来确定一个结点的后继。如果后继存在，下面的过程将返回一颗二叉搜索树中的结点x的后继；如果x是这棵树中的最大关键字，则返回NULL。
```后继-伪代码
TREE-SUCCESSOR(x)
  if x.right != NULL
    return TREE-MINIMUN(x.right)
  y = x.p
  while y != NULL and x == y.right
    x = y
    y = y.p
  return y
```

- 插入和删除
  - 这连个操作会引起二叉搜索数标识的动态集合的变化。一定要修改数据结构类反映这个变化，但修改要保持二叉搜索数性质的成立。
  - 插入
```插入-伪代码
TREE-INSERT(T, z)
  y = NULL
  x = T.root
  while x != NULL
    y = x
    if z.key < x.key
      x = x.left
    else
      x = x.right
  z.p = y
  if y == NULL
    T.root = z
  else if z.key < y.key
    y.left = z
  else
    y.right = z
```

- 删除
  - 删除逻辑步骤
  - 逻辑上概括出的三种情况
    1. 如果z(待删除结点)没有孩子结点，那么只是简单地将它删除，并修改它的父结点，用NULL作为孩子结点来替换z
    2. 如果z只有一个孩子，那么将这个孩子提升到树中z地位置上，并修改z地父结点，用z的孩子来替换z
    3. 如果z有两个孩子，那么找z的后继y(一定在z的右子树中年)，并让y占据树中z的位置。z的原来右子树部分称为y的新的右子树，并且z的左子树成为y的新的左子树。
  - 实际操作时执行的情况
    1. 如果z没有左孩子，那么用其右孩子来替换z，这个右孩子可以是NULL，也可以不是。当z的右孩子是NULL时，此时这种情况归为z没有孩子结点的情形。当z的右孩子非NULL时，此时这种情况归为z没有孩子结点的情形。当z的右孩子非NULL时，这种情况就是z仅有一个孩子结点的情形，该孩子是其右孩子。
    2. 如果z仅有一个孩子且为其左孩子，那么用其左孩子来替换。
    3. 否则，z既有一个左孩子又有一个右孩子。我们要查找z的后继y，这个后继位于z的右子树中并且没有左孩子。现在需要将y移出原来的位置进行拼接，并接替树中的z。
    5. 否则，y位于z的右子树中但并不是z的右孩子，这种情况下，先用y的右孩子替换y，然后再用y替换z。
    - 原则就是要找到被删除结点的后继结点，来代替自己

```删除-伪代码
TRANSPLANT(T, u, v)
  if u.p == NULL
    T.root = v
  else if
    u.p.left = v
  else
    u.p.right = v
  if v != NULL
    v.p = u.p

TREE-DELETE(T, z)
  if z.left == NULL
    TRANSPLANT(T, z, z.right)
  else if
    TRANSPLANT(T, z, z.left)
  else
    y = TREE-MINIMUM(z.right)
    if y.p != z
      TRANSPLANT(T, z, z.right)
      y.right = z.right
      y.right.p = y
    TRANSPLANT(T, z, y)
      y.left = z.left
      y.left.p = y
```

## 第13章 红黑树


