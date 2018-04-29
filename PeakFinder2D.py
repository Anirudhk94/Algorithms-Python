#!/usr/bin/python


def peak2d(array):
    '''This function finds the peak in a 2D array by the
       recursive method.

       Complexity: O(n log m)'''

    n = len(array)
    m = len(array[0])

    j = m // 2

    row = [i[j] for i in array]

    i = row.index(max(row))

    print(i, j)

    if j > 0 and array[i][j] < array[i][j - 1]:
        return peak2d([row[:j] for row in array])

    elif j < m - 1 and array[i][j] < array[i][j + 1]:
        return peak2d([row[j:] for row in array])

    else:
        return array[i][j]


print(peak2d([[1, -1, 3], [1, 5, 6], [-8, 3, 9]]))
