package greedIsGood;

public class Greed{
    public static int greedy(int[] dice){
        int [] counter = new int[7];
        int result = 0;

        for(int d : dice)
        {
            counter[d]++;
        }

        int k;
        for(int i = 1; i < counter.length; i++)
        {
            k = i == 1 ? 100 : 10 * i;

            if(counter[i] >= 3)
            {
                result += (counter[i] / 3) * 10 * k;
                counter[i] -= (counter[i] / 3) * 3;
            }
            if(i == 1 || i == 5)
            {
                result += (counter[i] % 3) * k;
            }
        }

        return result;
    }
}
