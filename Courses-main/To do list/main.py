# -*- coding: utf-8 -*-
from lib.csv_main import csv_read, csv_write
from lib.show import show_tasks
from lib.new_tasks import new_task, update_task, delete_task
from lib.user_inputs import inputs

def main():
    file_name = "To Do List"
    csv_data = [[]]
    try:
        csv_data = csv_read(file_name)
    except FileNotFoundError:
        print("File not found!")
        Input = input("Would you like to create a new file? ")
        if Input == "yes":
            print("Creating a new file...")
            
            csv_data = [["Task", "Priority", "Due Date", "Creation Date", "Status", "Notes"]]
            csv_write(csv_data, file_name)
            
            print('File succesfully created with a name of "' + file_name + '"')
        else:
            print("Stopping the program...")
            return
        
    Input = ""
    print(csv_data)
    while Input != "quit":
        if Input == "new task":
            Input = input("would you like to create a new task? ")
            if Input != "yes": return
            
            task_name, priority, due_date, status, notes = inputs()
            new_task(task_name, priority, due_date, status, notes, csv_data, file_name)
            return
        elif Input == "tasks":
            sort_input = input("Would you like to see a sorted csv_data by priority or date? ")
            sort_input2 = input("Would you like to see past, current or all tasks? ")
            show_tasks(sort_input, sort_input2, csv_data)
        elif Input == "delete":
            task_name = input("Please insert task name: ")
            priority = input("Please insert priority: ")
            creation_date = input("Insert creation date (yyyy/mm/dd): ")
            status = input("Insert the status of the task you want to delete: ")


            delete_task(task_name, priority, creation_date, status, csv_data, file_name)
        elif Input == "update":
            task_name, priority, due_date, status, notes = inputs()
            update_task(task_name, priority, due_date, status, notes, csv_data, file_name)
        else:
            print("Such task was not found.")
        Input = input('Command list: new task, tasks, update. Your input: ')


        

main()

"""
Add new task +
View past tasks by date +
Update existing tasks +
Delete tasks +
task should include: task name, priority, due date, creation date, status and notes. +
"""