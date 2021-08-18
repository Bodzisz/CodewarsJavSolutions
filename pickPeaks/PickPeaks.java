package pickPeaks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// https://www.codewars.com/kata/5279f6fe5ab7f447890006a7

public class PickPeaks {

    public static Map<String,List<Integer>> getPeaks(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();

        boolean isPlateaus = false;
        int plateausPos = 0;

        for(int i = 1 ; i < arr.length - 1; i++) {
            if (isPlateaus) {
                if(arr[i + 1] < arr[i]) {
                    pos.add(plateausPos);
                    peaks.add(arr[i]);
                    isPlateaus = false;
                }
                else if(arr[i + 1] > arr[i]) {
                    isPlateaus = false;
                }
            }
            else if (arr[i - 1] < arr[i]) {
                if (arr[i + 1] < arr[i]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                }
                else if (arr[i] == arr[i+1]) {
                    isPlateaus = true;
                    plateausPos = i;
                }
            }
        }

        return new HashMap<>(){
            {
                put("pos", pos);
                put("peaks", peaks);
            }
        };
    }
}

