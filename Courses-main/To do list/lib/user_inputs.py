# -*- coding: utf-8 -*-

def inputs():
    task_name = input("Please insert task name: ")
    priority = input("Please insert priority (the higher number the more impartant it is): ")
    due_date = input("Insert the date of when you need to finish (yyyy/mm/dd) *Do not put 2022 01 01 - instead use 2022 1 1*: ")
    status = input("Insert the status of your current task (Not started, On Going, Delayed, Done, Cancelled): ")
    notes = input("Input your notes about the task: ")
    return task_name, priority, due_date, status, notes