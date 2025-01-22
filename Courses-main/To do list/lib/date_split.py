# -*- coding: utf-8 -*-
def date_split(due_date):
    try:
        year, month, day = due_date.split()
        due_date = "{:04d}-{:02d}-{:02d}".format(int(year), int(month), int(day))
    except AttributeError or UnboundLocalError:
        print("Date input was wrong. Setting it as a default.")
        due_date = "2024 01 01"
        year, month, day = due_date.split()
        due_date = "{:04d}-{:02d}-{:02d}".format(int(year), int(month), int(day))
    
    return due_date