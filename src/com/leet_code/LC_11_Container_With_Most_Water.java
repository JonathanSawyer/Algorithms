package com.leet_code;

public class LC_11_Container_With_Most_Water {
    public static void main(String[] args) {
        int i = maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
        System.out.print(i);
    }

    public static int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length -1;
        int area = 0;
        while(leftIndex < rightIndex) {
            final int lh = height[leftIndex];
            final int rh = height[rightIndex];
            final int tempArea = Math.min(lh, rh) * (rightIndex - leftIndex);
            if(tempArea > area) {
                area = tempArea;
            }
            if(lh > rh) {
                rightIndex--;
            }else {
                leftIndex++;
            }
        }
        return area;
    }
}
