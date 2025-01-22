# -*- coding: utf-8 -*-
from lib.printing import data_printing

def show_tasks(sort_input, sort_input2, csv_data): 
    sorted_data = [[]]
    if sort_input == "date":
        sorted_data = sorted(csv_data[1:], key=lambda x: x[2])
    else:
        sorted_data = sorted(csv_data[1:], key=lambda x: int(x[1]))
    
    for row in sorted_data:
        if sort_input2 == "current":
            if row[2] > row[3]:
                data_printing(row)
                print()
        elif sort_input2 == "past":
            if row[2] < row[3]:
                data_printing(row)
                print()
        else:
            data_printing(row)
            print()