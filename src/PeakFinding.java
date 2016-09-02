
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PeakFinding 
{
    private int[] _input;
    
    public PeakFinding() {
    }

    public int[] getInput() {
        return _input;
    }

    public void setInput(int[] _input) {
        this._input = _input;
    }
    
//    If a[n/2] < a[n/2 − 1] then only look at left half 1 . . . n/2 − − − 1 to look for peak
//    Else if a[n/2] < a[n/2 + 1] then only look at right half n/2 + 1 . . . n to look for peak
//    Else n/2 position is a peak: WHY?
//    a[n/2] ≥ a[n/2 − 1]
//    a[n/2] ≥ a[n/2 + 1]
    public int divideAndConquer()
    {
        int peak        = -1;
        int index       = -1;
        int listMiddle  = _input.length / 2;
        
        if(_input[listMiddle] < _input[listMiddle - 1])
        {
            peak    = listMiddle - 1;
            index   = listMiddle - 2;
            
            while(index >= 0)
            {
                if(_input[peak] <= _input[index])
                {
                    peak = index;
                }
                else
                {
                    return peak;
                }
                index--;
            }
        }
        else if(_input[listMiddle] < _input[listMiddle + 1])
        {
            peak    = listMiddle + 1;
            index   = listMiddle + 2;
            
            while(index < _input.length)
            {
                if(_input[peak] <= _input[index])
                {
                    peak = index;
                }
                else
                {
                    return peak;
                }
                index++;
            }
        }
        else
        {
            return listMiddle;
        }
        return index < 0 ? ++index : --index;
    }
    
    //peak is n >= n-1 and n >= n+1
    //final position is a peak if n+1 >= n 
    //complexity of T(n) meaning that we would need to check every single item in the whole array to locate the peaks.
    public int[] linear()
    {
        ArrayList<Integer> peaks = new ArrayList();
        for(int index = 0; index < _input.length - 1; index++ )
        {
            if(index == 0)
            {
                if(_input[index] >= _input[index + 1])
                {
                    peaks.add(index);
                }
            }
            else if(_input.length == index + 2)
            {
                if(_input[index + 1] >= _input[index])
                {
                    peaks.add(index + 1);
                }
            }
            else if((_input[index] >= _input[index - 1]) && (_input[index] >= _input[index + 1]))
            {
                peaks.add(index);
            }
        }
        return peaks.stream().mapToInt(i -> i).toArray();
    }
}
