public class Matcher {
    //Long Method(Extract)
    public Matcher() {
    }

    public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

        largeClip(actual, clipLimit);
        if (!checkLengths(expected, actual)) {
            return false;
        }
        return !checkWithDelta(expected, actual, delta);
    }

    private boolean checkLengths(int[] expected, int[] actual) {
        if (actual.length == expected.length) {
            return true;
        } else {
            return false;
        }
    }

    private void largeClip(int[] actual, int clipLimit) {
        for (int i = 0; i < actual.length; i++)
            if (actual[i] > clipLimit)
                actual[i] = clipLimit;
    }

    private boolean checkWithDelta(int[] expected, int[] actual, int delta) {
        for (int i = 0; i < actual.length; i++)
            if (Math.abs(expected[i] - actual[i]) > delta)
                return true;

        return false;
    }
}