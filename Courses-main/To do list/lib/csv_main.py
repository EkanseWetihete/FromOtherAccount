# -*- coding: utf-8 -*-
import csv

def csv_read(file_name):
    with open(file_name + ".csv", newline = '') as csvfile:
        reader = csv.reader(csvfile)
        
        data = []
        
        for row in reader:
            data.append([row[0], row[1], row[2], row[3], row[4], row[5]])
            
        return data
    
def csv_write(newData, file_name):
    with open(file_name + ".csv", 'w', newline = '') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerows(newData)

    