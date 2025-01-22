# -*- coding: utf-8 -*-
from lib.csv_main import csv_write
from datetime import datetime
from lib.date_split import date_split

def new_task(task_name, priority, due_date, status, notes, csv_data, file_name):
    creation_date = datetime.now().date()
    creation_date_str = creation_date.strftime('%Y-%m-%d')
    
    due_date = date_split(csv_data)
    
    csv_data.append([task_name, priority, due_date, creation_date_str, status, notes])
    csv_write(csv_data, file_name)
    
def update_task(task_name, priority, due_date, status, notes, csv_data, file_name):
    change = "False"
    for row in csv_data:
        if row[0] == task_name:
            row[1] = priority
            row[2] = date_split(due_date) #due_date
            row[4] = status
            row[5] = notes
            print("Data was changed succesfully")
            change = "True"
            break
        
    if change == "True":
        csv_write(csv_data, file_name)
        
def delete_task(task_name, priority, creation_date, status, csv_data, file_name):
    for row in csv_data:
        if row[0] == task_name and row[1] == priority and row[4] == status:
            if row[3] == date_split(creation_date): 
                csv_data.remove(row)
                print("Data was deleted succesfully")
                csv_write(csv_data, file_name)
                return
        