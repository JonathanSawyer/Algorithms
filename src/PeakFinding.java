
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PeakFinding 
{
    private int[] _n;
    
    public PeakFinding() {
    }

    public int[] getInput() {
        return _n;
    }

    public void setInput(int[] _input) {
        this._n = _input;
    }
    
//    If a[n/2] < a[n/2 − 1] then only look at left half 1 . . . n/2 − − − 1 to look for peak
//    Else if a[n/2] < a[n/2 + 1] then only look at right half n/2 + 1 . . . n to look for peak
//    Else n/2 position is a peak: WHY?
//    a[n/2] ≥ a[n/2 − 1]
//    a[n/2] ≥ a[n/2 + 1]
    public int divideAndConquer()
    {
        if(_n.length <= 2)
            return -1;
        
        int peak        = -1;
        int index       = -1;
        int listMiddle  = _n.length / 2;
       
        if(_n[listMiddle] < _n[listMiddle - 1])
        {
            peak    = listMiddle - 1;
            index   = listMiddle - 2;
            
            while(index >= 0)
            {
                if(_n[peak] <= _n[index])
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
        else if(_n[listMiddle] < _n[listMiddle + 1])
        {
            peak    = listMiddle + 1;
            index   = listMiddle + 2;
            
            while(index < _n.length)
            {
                if(_n[peak] <= _n[index])
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
    public int linear()
    {
        if(_n.length <= 2)
            return -1;
                
        if(_n[0] > _n[1])
            return 0; 
        
        for(int index = 1; index < _n.length - 1; index++)
        {            
            if((_n[index] >= _n[index - 1]) && (_n[index] >= _n[index + 1]))
            {
                return index;   
            }
        }
        
        if(_n[_n.length - 1] > _n[_n.length - 2])
            return _n.length - 1; 
                    
        return -1;
    }
}
