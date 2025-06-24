class TrappingRainWater {
    public int trap(int[] height) {
        int size = height.length;
        if (size <= 2) {
            return 0;
        }
        boolean isIncreasing = true, isDecreasing = true;
        for (int i = 1; i < size; i++) {
            if (height[i] < height[i - 1]) {
                isIncreasing = false;
            }
            if (height[i] > height[i - 1]) {
                isDecreasing = false;
            }
        }
        if (isIncreasing || isDecreasing) {
            return 0;
        }
        // maxLeftBoundry = mxlb , maxRightBoundry = mxrb
        int[] mxlb = new int[size];
        int[] mxrb = new int[size];
        mxlb[0] = height[0];
        mxrb[size - 1] = height[size - 1];

        for (int i = 1; i < size; i++) {
            mxlb[i] = Math.max(mxlb[i - 1], height[i]);
        }
        for (int j = size - 2; j >= 0; j--) {
            mxrb[j] = Math.max(mxrb[j + 1], height[j]);
        }
        int trapWater = 0;
        for (int k = 0; k < size; k++) {
            trapWater += Math.min(mxrb[k] , mxlb[k]) -height[k];
        }
        return trapWater;

    }
}