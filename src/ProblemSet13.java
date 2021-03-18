import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet13 {

    public static void main(String[] args) {
        
    }

    public static boolean groupSum(int start, int[] numbers, int target) {
        if (start >= numbers.length)
        {
            return false;
        }

        if (numbers[start] == target) {
            return true;
        } else if (numbers[start] > target) {
            return groupSum(start + 1, numbers, target);
        } else {
            if (groupSum(start + 1, numbers, target - numbers[start])) return true;
            if (groupSum(start + 1, numbers, target)) return true;
        }

        return false;
    }

    public static boolean groupSum6(int start, int[] numbers, int target) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int count = 0;
        for (int i : numbers) {
            if (i != 6) {
                temp.add(i);
            } else {
                count++;
            }
        }

        numbers = new int[temp.size()];
        int loop = 0;
        for (int i : temp) {
            numbers[loop] = temp.get(loop);
            loop++;
        }

        target -= (count * 6);

        if (start >= numbers.length)
        {
            return false;
        }

        if (numbers[start] == target) {
            return true;
        } else if (numbers[start] > target) {
            return groupSum6(start + 1, numbers, target);
        } else {
            if (groupSum6(start + 1, numbers, target - numbers[start])) return true;
            if (groupSum6(start + 1, numbers, target)) return true;
        }

        return false;
    }

    public static boolean groupNoAdj(int start, int[] numbers, int target) {
        if (start >= numbers.length)
        {
            return false;
        }

        if (numbers[start] == target) {
            return true;
        } else if (numbers[start] > target) {
            return groupNoAdj(start + 1, numbers, target);
        } else {
            if (groupNoAdj(start + 2, numbers, target - numbers[start])) return true;
            if (groupNoAdj(start + 1, numbers, target)) return true;
        }

        return false;
    }

    public static boolean groupSum5(int start, int[] numbers, int target) {
        if (start >= numbers.length) {
            return false;
        }

        if (numbers[start] == target) {
            return true;
        } else if (numbers[start] > target) {
            return groupSum5(start + 1, numbers, target);
        } else {
            if (numbers[start] % 5 == 0) {
                if (numbers[start + 1] == 1) {
                    return groupSum5(start + 2, numbers, target - numbers[start]);
                } else {
                    return groupSum5(start + 1, numbers, target - numbers[start]);
                }
            } else {
                if (groupSum5(start + 1, numbers, target - numbers[start])) return true;
                if (groupSum5(start + 1, numbers, target)) return true;
            }
        }

        return false;
    }

    public static boolean groupSumClump(int start, int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) {
                numbers[i-1] += numbers[i];
                if (i + 1 < numbers.length && numbers[i] != numbers[i+1]) {
                    numbers[i] = 0;
                } else if (i == numbers.length - 1) {
                    numbers[i] = 0;
                }
            }
        }

        if (start >= numbers.length)
        {
            return false;
        }

        if (numbers[start] == target) {
            return true;
        } else if (numbers[start] > target) {
            return groupSumClump(start + 1, numbers, target);
        } else {
            if (groupSumClump(start + 1, numbers, target - numbers[start])) return true;
            if (groupSumClump(start + 1, numbers, target)) return true;
        }

        return false;
    }

    public static boolean splitArray(int[] numbers) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return splitArrayHelper(numbers, index, sum1, sum2);
    }

    public static boolean splitOdd(int[] numbers) {
        int index = 0;
        int sum1 = 0;
        int sum2 = 0;
        return splitOddHelper(numbers, index, sum1, sum2);
    }

    private static boolean splitArrayHelper(int[] n, int i, int sum1, int sum2) {
        if (i >= n.length) {
            return sum1 == sum2;
        }

        int v = n[i];

        return (splitArrayHelper(n, i + 1, sum1 + v, sum2)
                || splitArrayHelper(n, i + 1, sum1, sum2 + v));
    }

    private static boolean splitOddHelper(int[] n, int i, int s1, int s2) {
        if (i >= n.length) {
            return ((s1 % 10 == 0 && s2 % 2 == 1) || (s1 % 2 == 1 && s2 % 10 == 0));
        }

        int v = n[i];

        return (splitOddHelper(n, i + 1, s1 + v, s2)
                || splitOddHelper(n, i + 1, s1, s2 + v));
    }
}
