# -*- coding: utf-8 -*-
from Library.Catalog import Catalog
from Library.data_read import csv_read
from Library.data_display import display
from Library.author_books_search import author_books

def main():
    catalog = Catalog(csv_read())
    user_input = ""
    while user_input != "quit":
        print()
        user_input = input("Type add, search, display, update, delete or quit: ")
        print()
        if user_input == "add":
            title = input("Type a book title: ")
            author = input("Type a name of an author: ")
            year = input("Type when the book was released: ")
            quantity = input("Type how many books you have in store: ")
            
            catalog.book_add(title, author, year, quantity)
        elif user_input == "search title" or user_input == "search":
            title = input("Type a title of a book that you want to search for: ")
            result = catalog.book_search_title(title)
            
            try:
                print(result.title, result.author, result.year, result.quantity)
            except AttributeError:
                print("Such product does not exist")
        elif user_input == "search author":
            author = input("Type an author of a book that you want to search for: ")
            author_books(author, catalog)
        elif user_input == "display":
            result = catalog.book_display()
            display(result)
        elif user_input == "update":
            title = input("Type a book title: ")
            quantity = input("Type how much quantity do you want to add: ")
            catalog.book_update(title, quantity)
        elif user_input == "delete":
            title = input("Type a book title: ")
            author = input("Type a name of an author: ")
            year = input("Type when the book was released: ")
            catalog.book_delete(title, author, year)
            catalog = Catalog(csv_read())
    else:
        print("Stopping process!")
        
main()

"""
Task list:
1. Add a new book to the inventory (title, author, year, quantity). +
2. Search for a book by title or author and display its details. +
3. Display the entire book inventory. + 
4. Update the quantity of a book. +
5. Delete a book from the inventory. +
"""