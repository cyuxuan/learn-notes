# 算法导论

## 第一章-简介

## 第二章-算法基础

### 2.1-插入排序（算法基础-引子）

1. idea(算法思想)
循环获取数据key，然后在该数据key之前找到合适位置（规定的排序条件）后再插入，实现了插入时即排序的效果

2. fake-code(伪代码)

    ```fake-code
    算法导论版:
    INSERTION-SORT(A) // 定义该函数名称A-待排数组
    for j = 2 to A.length // j从2直到A的末尾
        key = A[j] // 取出待排数
        // 插入数据到已经排过序的A[1,j - 1]
        i = j - 1; // 定义从key的前一个位置到start位置扫描A的开始位置-该部分已经排序过，只需要后移元素那些大于key的元素即可
        while i > 0 and A[i] > key // 将大于当前待排key值的后移
        A[i+1] = A[i]
        i = i - 1
        A[i + 1] = key;
    ```

3. analysis(对该算法的分析)
    - 时间复杂度（忽略循环中常数部分）：
      - 最好情况：该数组已排序，每次只需要取出key，无需进行元素后移，该情况为O(n)
      - 最坏情况：该数组为逆置数组，取出key消耗n-1次，因为是逆置所以前面的数全部要后移，每次取数的key为数组中的j的位置的话-那么每次要前移j-1个数据，所以共有 1+2+3+···+n-1 次前移操作，所以该部分时间复杂度为O(n<sup>2</sup>)

4. x-code(对应语言算法实现)
java-code(具体实现代码java-为使用语言)

    ```java
        public void insertion_sort(Integer[] a){
            for(int i = 1 ; i < a.length ; i++){
                int key = a[i];
                int position = i;
                for (int j = i - 1 ; j >= 0 ; j-- ){
                    if(a[j] > key){
                        a[j+1] = a[j];
                        position -= 1;
                    }
                }
                a[position] = key;
            }
        }
    ```

    c++ code(具体实现代码c++为使用语言)

    ```cpp
    void InsertionSort(int *a, int len)
    {
        for (int j=1; j<len; j++)
        {
            int key = a[j];
            int i = j-1;
            while (i>=0 && a[i]>key)
            {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
    ```

5. note（该部分笔记）

### 2.2-分析算法

### 2.3-设计算法

#### 2.3.1-分治法

- 将问题分解为几个规模较小但类似原问题的若干子问题，递归地求解这些子问题，然后再合并这些子问题的解，来建立原问题的解
- 典型例子-归并排序（这里不讨论-留在排序内容中讨论归并排序）

#### 2.3.2-分治分析算法

##### 这里主要是对算法的效率等进行研究

## 第三章-函数的增长

### 这里不讨论-基本知识在高等数学及离散数学中全部存在

## 第四章-分治策略

- 递归式
    递归式与分治方法是紧密相关的，因为使用递归式可以很自然的刻画分治算法的运行时间。一个递归式就是一个等式或者不等式（详情参见高等数学）
  - 介绍三个求解递归式的方法：
    - 代入法：我们猜测一个界，然后用数学归纳法证明这个界是正确的。
    - 递归树法：将递归式转换为一棵树，其结点表示不同层次的递归调用产生的代价。然后采用边界和技术来求解递归式。
    - 主方法：可求解形如下面公式的递归式的边界：
                  T(n) = aT(n/b) + f(n)
                其中a >= 1, b > 1, f(n)是一个给定的函数。这种形式的递归式很常见，它刻画了这样一个分治算法：生成a个子问题，每个子问题的规模是原问题规模的1/b，分解和合并步骤总共花费时间为f(n)
- 递归式技术细节
  - 在求取渐近界时记得取好上下界，此处上下界指的是函数递归推出条件的上下界。做好充足的算法分析，详情可参考学习高等数学及离散数学。

### 4.1-分治策略引子-最大子数组问题(分治法)

1. idea

    ```idea
        首先要明确分治策略是将问题分解为更小的子问题，然后通过子问题的结果来组合出原问题
        对于数组A[left,right]中的最大子数组问题，首先是要拆分数组，获得更小的数组，来将问题小化。
        考虑-数组中如果以中心点mid为分界点，则最大子数组存在的区域一定是[left, mid]，或者[mid + 1, right]，或者是跨过中点mid的区间[left,right]中。
        此三种情况已经包含以中点mid为分界点进行分界后子数组可能存在的所有情况。
        此时可以进行如下步骤：
            1. 以key为中心，left,right为边界，最大字串是多少。
            2. 以key为中心左边的区域[left, mid]中的最大字串是多少。
            3. 以key为中心右边的区域[mid + 1, right]中的最大字串是多少。
            4. 取1,2,3中的最大值,返回。
            注：这里实际找寻一个确定区间内最大字串的步骤是1，步骤2和3仅仅是在重新定义边界及中心点。
    ```

2. fake-code

    ```fake-code
    // 找寻在A中以mid为中点，low, high为边界时的最大子数组
    FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
        left-sum = -∞
        sum = 0
        for i = mid downto low // 向左延伸
            sum = sum + A[i]
            if (sum > left-sum) // 如果这个数加起来让值变大，则更新sum值，且更新最大子数组左边界
                left-sum = sum
                max-left = i
        right-sum = -∞
        sum = 0
        for j = mid + 1 to low
            sum = sum + A[j]
            if (sum > right-sum) // 同上
                right-sum = sum
                max-right = i
        return (max-left, max-right, left-sum + right-sum)


    // 有了找寻最大子数组的函数接下来开始递归确定mid,low,hight来找寻最大子数组
    FIND-MAXIMUM-SUBARRAY(A, low, mid)
        // 此时是分解到还剩1个元素了
        if high == low
            return (low, high, A[low])
        else mid=⌊(low+high)/2⌋ // 向下取整
            // low该区间最大子数组开始下标
            // right该区间最大子数组结束下标
            // sum该区间最大子数组值
            (left-low,left-high-,left-sum) =  
                FIND-MAXIMUM-SUBARRAY(A, low, mid)
            (right-low,right-high,right-sum) = 
                FIND-MAXIMUM-SUBARRAY(A, mid + 1, high)
            (right-low,right-high,right-sum) = 
                FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
            // 返回当前最大值及其信息
            if(left-sum >= right-sum and left-sum >= cross-sum)
                return (left-low,left-high,left-sum)
            else if(right-sum >= left-sum and right-sum >= cross-sum)
                return (right-low,right-high,right-sum)
            else 
                return (cross-low,cross-high,cross-sum)     
    ```

3. analysis
4. x-code
5. note

### 4.2 矩阵乘法的Strassen算法
