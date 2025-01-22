# -*- coding: utf-8 -*-

def author_books(author, catalog):
    result = catalog.book_search_author(author)
    if result != []:
        print("Author books: ")
        for i in result:
            print(i.title, i.author, i.year, i.quantity)
    else:
        print("Such author doesn't exist on a list.")