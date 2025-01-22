# -*- coding: utf-8 -*-
from Library.Book import Book
import csv

def csv_read():
    with open("BookList.csv", newline = '') as csvfile:
        reader = csv.reader(csvfile)
        
        Data = []
        
        for row in reader:
            Data.append(Book(row[0], row[1], row[2], row[3]))
            
        return Data

