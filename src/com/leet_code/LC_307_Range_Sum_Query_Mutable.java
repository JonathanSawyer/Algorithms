package com.leet_code;

public class LC_307_Range_Sum_Query_Mutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});

    }

    static class NumArray {
        class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            int sum;

            SegTree(int leftMost, int rightMost, int[] arr) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
                if (leftMost == rightMost) {
                    sum = arr[leftMost];
                } else {
                    int mid = leftMost + rightMost >>> 1;
                    left = new SegTree(leftMost, mid, arr);
                    right = new SegTree(mid + 1, rightMost, arr);
                }
                recalc();
            }

            private void recalc() {
                if (leftMost == rightMost) {
                    return;
                }
                sum = left.sum + right.sum;
            }

            private void update(int idx, int val) {
                if (leftMost == rightMost) {
                    sum = val;
                } else {
                    final int mid = leftMost + rightMost >>> 1;
                    if (idx <= mid) {
                        left.update(idx, val);
                    } else {
                        right.update(idx, val);
                    }
                    recalc();
                }
            }

            private int query(int l, int r) {
                if (r < leftMost || l > rightMost) {
                    return 0;
                }
                if (l <= leftMost && rightMost <= r) {
                    return sum;
                }
                return left.query(l, r) + right.query(l, r);
            }
        }

        SegTree st;

        public NumArray(int[] nums) {
            if (nums.length != 0)
                st = new SegTree(0, nums.length - 1, nums);
        }

        public void update(int i, int val) {
            st.update(i, val);
        }

        public int sumRange(int i, int j) {
            return st.query(i, j);
        }
    }
}
