#!/usr/bin/env python3

import sys
import os
import re

# sanitize (\illegal) 
# exit()
# glob()
# split()

#prep variables
input_folder=sys.argv[1]
input_template=sys.argv[2]
input_date=sys.argv[3]
output_folder=sys.argv[4]

#check if ./output exists, if not create then process to yes, if yes write file
if os.path.isdir(output_folder) == False:
    os.mkdir(output_folder)

#get dept_code, dept_name, course_name, course_start, course_end, credit_hours, num_students
def readFromACourse(string, nameWithOutCrs, course_num):
    lines=[]
    try:
        infile = open("./" + input_folder + "/" + string, 'r')
        for line in infile:
            lines.append(line)
    except IOError:
        print("end")
    infile.close()

    dept_code=re.search("[A-Z]{3}", lines[0]).group(0)
    dept_name=re.search("[A-Z][a-z]{1,}", lines[0]).group(0)
    course_name=lines[1].replace("\n", "")
    course_start=re.search("[0-9]{1,}\/[0-9]{1,}\/[0-9]{1,}", lines[2]).group(0)
    course_end=re.search("[0-9]{1,}\/[0-9]{1,}\/[0-9]{1,}.*?([0-9]{1,}\/[0-9]{1,}\/[0-9]{1,})", lines[2]).group(0)
    course_end=course_end.replace(course_start + " ", "")
    credit_hours=lines[3].replace("\n", "")
    num_students=lines[4]
    if int(num_students) > 50:
        with open(output_folder + "/" +  nameWithOutCrs + ".warn" , "w") as outfile:
            infile = open(input_folder + "/" + input_template, 'r')
            for line in infile:
                line = line.replace("[[dept_code]]", dept_code)
                line = line.replace("[[dept_name]]", dept_name)
                line = line.replace("[[course_name]]", course_name)
                line = line.replace("[[course_start]]", course_start)
                line = line.replace("[[course_end]]", course_end)
                line = line.replace("[[credit_hours]]", credit_hours)
                line = line.replace("[[num_students]]", num_students)
                line = line.replace("[[course_num]]", course_num)
                line = line.replace("[[date]]", input_date)
                outfile.write(line)

#get course_number, and also call readFromACourse(string)
files = os.listdir("./" + input_folder)
for file in files:
    try:
        names = re.search("[A-Z]{2,}[0-9]{4}.crs", file).group(0)
        nameWithOutCrs = re.search("[A-Z]{2,}[0-9]{4}", file).group(0)
        course_num = re.search("[0-9]{4}", names).group(0)
        readFromACourse(names, nameWithOutCrs, course_num)
    except AttributeError: continue