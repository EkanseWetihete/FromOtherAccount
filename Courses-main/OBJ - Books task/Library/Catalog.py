# -*- coding: utf-8 -*-
#from Book import Book
from Library.data_write import csv_write
from Library.data_read import csv_read
from Library.Book import Book

books = csv_read()

class Catalog:
    def __init__(self, book):
        self.books = book
        
    def book_search_title(self, title): #searches for a product name
        for i in self.books:
            if i.title == title:
                return i
        return None
    def book_search_author(self, author): #searches for a product name
        author_books = []
        for i in self.books:
            if i.author == author:
                author_books.append(i)
        return author_books
    
    def book_display(self): #displays all books
        data = []
        
        for i in self.books:
            data.append(i)
        return data
    
    def book_update(self, title, quantity): #updates quantity of a book
        try:
            book = self.book_search_title(title)
            book.quantity = int(book.quantity) + int(quantity)
            data = []
            
            for i in self.books:
                data.append([i.title, i.author, i.year, i.quantity])
                
            csv_write(data)
        except AttributeError:
            print("Incorrect input!")
            return
    
    def book_add(self, title, author, year, quantity): #adds books to a list
        self.books.append(Book(title, author, year, quantity))
        csv_write(self.books)
        
    def book_delete(self, title, author, year): #deletes books
        data = []
        
        for i in self.books:
            if i.title == title and i.author == author and int(i.year) == int(year):
                print(title, "Was deleted succesfully!")
            else:
                data.append([i.title, i.author, i.year, i.quantity])
        csv_write(data)
    