public class WeightedRandom {
    //CONST
    private static final int MIN_NUMBER_OF_VERSION = 1;
    private static final int MAX_NUMBER_OF_VERSION = 1000;
    private static final int MIN_WEIGHT = 0;
    private static final int MAX_WEIGHT = 1000000000;


    public static int getRandomVersion(int[] weights) {
        verifyInputData(weights);
        return 0;
    }

    private static void verifyInputData(int[] input) {
        verifyNumberOfVersion(input.length);
        for (int item : input) {
            verifyWeightOfVersion(item);
        }
    }
    private static void verifyNumberOfVersion(int num) {
        if (MIN_NUMBER_OF_VERSION > num || num > MAX_NUMBER_OF_VERSION) {

        }
    }
    private static void verifyWeightOfVersion(int weight) {
        if (MIN_WEIGHT > weight || weight > MAX_WEIGHT) {

        }
    }


}
