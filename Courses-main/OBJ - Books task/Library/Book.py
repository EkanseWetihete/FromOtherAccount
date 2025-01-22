# -*- coding: utf-8 -*-

class Book:
    def __init__(self, title, author, year, quantity):
        self.title = title
        self.author = author
        self.year = year
        self.quantity = quantity
    
    def __iter__(self):
        return iter([self.title, self.author, self.year, self.quantity])
    
    def get_name(self):
        return self.title
    
    def get_author(self):
        return self.author
    
    def get_year(self):
        return self.quantity
    
    def get_quantity(self):
        return self.quantity
    
    def edit_book(self, title, author, year, quantity):
        self.title = title
        self.author = author
        self.year = year
        self.quantity = quantity
        return "Change was succesful!"
        
        
        