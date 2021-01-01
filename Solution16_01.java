package code_2020_1223;
//面试题16_01,交换数字
public class Solution16_01 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] ^=numbers[1];
        numbers[1] ^=numbers[0];
        numbers[0] ^=numbers[1];
        return numbers;
    }
}
