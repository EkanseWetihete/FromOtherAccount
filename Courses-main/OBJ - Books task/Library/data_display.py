# -*- coding: utf-8 -*-

def display(data):
    print("Book list: ")
    for i in data:
        print(i.title, i.author, i.year, i.quantity)