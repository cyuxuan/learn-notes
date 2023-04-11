import javafx.util.converter.IntegerStringConverter;

import java.util.Objects;

/**
 * @author 陈玉轩
 * @date 2022-01-16
 * 最大子数组问题-递归求解(分治法求解)
 */
public class MaxSubArray {
    public static void main(String[] args) {
        // 初始化测试数据
        Integer[] source = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        // 执行递归求解
        AreaInfo areaInfo = new AreaInfo();
        areaInfo.low = 0;
        areaInfo.high = source.length - 1;
        areaInfo = findMaxSubArray(source,areaInfo);
        // 输出结果
        System.out.println("res: " + areaInfo.toString());
    }

    
    private static AreaInfo findMaxSubArray(Integer[] source, AreaInfo areaInfo) {
        // 子数组只有一个数据
        if(Objects.equals(areaInfo.high, areaInfo.low)) {
            // 返回当前这个点的值
            areaInfo.sum = source[areaInfo.low];
            return areaInfo;
        } else {
            areaInfo.mid = (areaInfo.low + areaInfo.high) / 2;
            // 左边
            AreaInfo leftAreaInfo = new AreaInfo();
            leftAreaInfo.low = areaInfo.low;
            leftAreaInfo.high = areaInfo.mid;
            leftAreaInfo = findMaxSubArray(source, leftAreaInfo);
            // 右边
            AreaInfo rightAreaInfo = new AreaInfo();
            rightAreaInfo.low = areaInfo.mid + 1;
            rightAreaInfo.high = areaInfo.high;
            rightAreaInfo = findMaxSubArray(source, rightAreaInfo);
            // 中间
            AreaInfo midAreaInfo = new AreaInfo();
            midAreaInfo =  findMaxCrossingSubArray(source, areaInfo);
            // 返回结果
            if(leftAreaInfo.sum > midAreaInfo.sum && leftAreaInfo.sum > rightAreaInfo.sum) {
                return leftAreaInfo;
            } else if(rightAreaInfo.sum > midAreaInfo.sum && rightAreaInfo.sum > leftAreaInfo.sum) {
                return rightAreaInfo;
            } else {
                return midAreaInfo;
            }

        }
    }

    /**
     * 查找当前mid位置开始，向两边探测到的最大值
     * @param source 源数据
     * @param areaInfo 区间信息
     */
    private static AreaInfo findMaxCrossingSubArray(Integer[] source, AreaInfo areaInfo) {
        // 初始化区间信息
        AreaInfo tempAreaInfo = new AreaInfo();
        // 初始化左边和
        Integer left_sum = Integer.MIN_VALUE;
        // 初始化和,用于记录当前探测值
        Integer sum  = 0;
        // 取到向左探测到的最大值
        for(int i= areaInfo.mid; i >= areaInfo.low ; i--) {
            sum = sum + source[i];
            if (sum > left_sum) {
                left_sum = sum;
                tempAreaInfo.low = i;
            }
        }
        // 初始化右边和
        Integer right_sum = Integer.MIN_VALUE;
        sum = 0;
        // 获取右边的最大值
        for (int j= areaInfo.mid+ 1 ; j <= areaInfo.high ; j++) {
            sum = sum + source[j];
            if (sum > right_sum) {
                right_sum = sum;
                tempAreaInfo.high = j;
            } 
        }
        // 返回当前区间信息,
        tempAreaInfo.sum = left_sum + right_sum;
        return tempAreaInfo;
    }

    /**
     * 记录区间信息
     */
    static class AreaInfo {
        /**
         * 区间下限
         */
        public Integer low;

        /**
         * 区间中间，上限加下限取平均值，向下取整
         */
        public Integer mid;

        /**
         * 区间上限 
         */
        public Integer high;    

        /**
         * 区间和(最大和)
         */
        public Integer sum;

        @Override
        public String toString() {
            return "AreaInfo{" +
                    "low=" + low +
                    ", mid=" + mid +
                    ", high=" + high +
                    ", sum=" + sum +
                    '}';
        }
    }
}