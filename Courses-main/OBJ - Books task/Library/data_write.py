# -*- coding: utf-8 -*-
import csv

def csv_write(newData):
    with open("BookList.csv", 'w', newline = '') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerows(newData)
        
