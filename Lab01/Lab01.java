package Lab01;

public class Lab01 {
    static int bfAdditions = 0;
    static int opAdditions = 0;
    
    public static void main(String[] args){
        System.out.printf(
            "%-12s | %-18s | %-12s | %-15s | %-18s | %-12s | %-15s%n",
            "Array Size", "Brute-force Index", "BF Time(ms)", "BF Additions", "Optimized Index", "Opt Time(ms)", "Opt Additions"
        );

        System.out.println(
            "-----------------------------------------------------------------------------------------------------------------------"
        );
        
        for (int i = 0; i <= Lab01_Driver.iterations; i++){
            int[] arr = new int[Lab01_Driver.baseSize * (int)Math.pow(2, i)];
            Lab01_Driver.fillArrayRandom(arr, -100, 100);
            bfAdditions = 0;
            long bfstartTime = System.currentTimeMillis();
            int bfindex = bruteForce(arr);
            long bfendTime = System.currentTimeMillis();
            long bfexecutionTime = bfendTime - bfstartTime;
            opAdditions = 0;
            long opstartTime = System.currentTimeMillis();
            int opIndex = optimized(arr);
            long opendTime = System.currentTimeMillis();
            long opexecutionTime = opendTime - opstartTime;
            System.out.printf(
            "%-12d | %-18d | %-12d | %-15d | %-18d | %-12d | %-15d%n",
            arr.length, bfindex, bfexecutionTime, Math.abs(bfAdditions), opIndex, opexecutionTime, opAdditions
            );
        }
}

    public static int bruteForce(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int rightSum = 0;
            int leftSum = 0;
            for (int j = 0; j < i; j++){
                leftSum += arr[j];
                bfAdditions++;
            }
            for (int j = i + 1; j < arr.length; j++){
                rightSum += arr[j];
                bfAdditions++;
            }
            if (rightSum == leftSum){
                return i;
            }
        }
        return -1;
}

    public static int optimized(int[] arr){
        int sum = 0;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            opAdditions++;
        }
        for (int i = 0; i < arr.length; i++) {
            int rightSum = sum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
            opAdditions++;
    }
        return -1;
    }
}
