package com.leet_code;

import java.util.ArrayList;
import java.util.List;

public class LC_5473_Bulb_Switcher_IV {
    public static void main(String[] args) {
        System.out.print(minFlips("001011101"));
    }

    public static int minFlips(String target) {
        int count = 0;
        List<Integer> a = new ArrayList();
        for(Character c : target.toCharArray()) {
            a.add(Character.getNumericValue(c));
        }

        int res = 0;
        for (int i = 0; i < a.size(); i++)
        {
            /* if the bulb's original state is on and count
               is even, it is currently on...*/
            /* no need to press this switch */
            if (a.get(i) == 1 && count%2 == 0)
                continue;

            /* If the bulb's original state is off and count
               is odd, it is currently on...*/
                /* no need to press this switch */
            else if(a.get(i) == 0 && count%2 != 0)
                continue;

            /* if the bulb's original state is on and count
               is odd, it is currently off...*/
            /* Press this switch to on the bulb and increase
               the count */
            else if (a.get(i) == 1 && count%2 != 0)
            {
                res++;
                count++;
            }

            /* if the bulb's original state is off and
               count is even, it is currently off...*/
            /* press this switch to on the bulb and
               increase the count */
            else if (a.get(i) == 0 && count%2 == 0)
            {
                res++;
                count++;
            }
        }
        return res;
    }
}
