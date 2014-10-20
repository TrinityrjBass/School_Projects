cc                                                                    PAGE 1
 
#include <iostream>
using namespace std; 
cc                                                                    PAGE 2
void main() 
    
    {
    while (numberFound < NUMBER_TO_FIND) 
    {
        sumOfFactors = 0; 
        for (divisor = 1; divisor <= candidate / 2; divisor++) 
            if (candidate % divisor == 0) 
                sumOfFactors += divisor; 
        if (candidate == sumOfFactors) 
        {
            printf("%d\n", candidate); 
            numberFound++; 
            } 
} 
} 
