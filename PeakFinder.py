#!/usr/bin/python

def peak1d(array):
    #initialization
    mid = len(array)//2
    print(mid)
    print(array)
    
    #recursion
    if( mid-1 > 0 and array[mid] < array[mid - 1]) :
        return peak1d(array[:mid])
    
    elif( mid+1 < len(array) and array[mid] < array[mid + 1]) :
        return peak1d(array[mid:])    
    
    else :
        return array[mid]

print("Peak : " + str(peak1d([1,-1,3,1,5,6])))