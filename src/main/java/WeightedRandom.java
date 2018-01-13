import java.util.Random;
import java.util.stream.IntStream;

public class WeightedRandom {
    //CONST
    private static final int MIN_NUMBER_OF_VERSION = 1;
    private static final int MAX_NUMBER_OF_VERSION = 1000;
    private static final int MIN_WEIGHT = 0;
    private static final int MAX_WEIGHT = 1000000000;


    /**
     * Select a message version by weighted random algorithm
     *
     * @param weights
     * @return message version
     */
    public static int getRandomVersion(int[] weights) {
        if (verifyInputData(weights)) {
            int sumOfWeight = IntStream.of(weights).sum();
            int randWeight = randomNumber(MIN_WEIGHT, sumOfWeight);
            for (int i = 1; i <= weights.length; i++) {
                randWeight -= weights[i - 1];
                if (randWeight <= 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int randomNumber(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

    private static boolean verifyInputData(int[] input) {
        boolean status = true;
        status = status && verifyNumberOfVersion(input.length);
        for (int item : input) {
            status = status && verifyWeightOfVersion(item);
        }
        return status;
    }

    private static boolean verifyNumberOfVersion(int num) {
        if (MIN_NUMBER_OF_VERSION > num || num > MAX_NUMBER_OF_VERSION) {
            System.out.println("Number of version should be " + MIN_NUMBER_OF_VERSION + "-" + MAX_NUMBER_OF_VERSION);
            return false;
        }
        return true;
    }

    private static boolean verifyWeightOfVersion(int weight) {
        if (MIN_WEIGHT > weight || weight > MAX_WEIGHT) {
            System.out.println("Weight of version should be " + MIN_WEIGHT + "-" + MAX_WEIGHT);
            return false;
        }
        return true;
    }


}
