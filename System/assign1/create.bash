#!/bin/bash

read -p "Enter department code: " department_code 
read -p "Enter department name: " department_name
read -p "Enter course number: " course_num
read -p "Enter course name: " course_name
read -p "Enter course schedule: " course_schedule 
read -p "Enter course start: " course_start 
read -p "Enter course end: " course_end
read -p "Enter course credit: " course_credit
read -p "Enter course initial enrollment: " course_initial


file_name=${department_code^^}$course_num.crs
date=`date +%m-%d-%Y`
write_log="[${date}] CREATED: ${department_code} ${course_num} ${course_name}"

if [ -f ./data/$file_name ]; then
	echo "ERROR: course already exists"
else
	touch ./data/$file_name
	echo $department_code $department_name >> ./data/$file_name
	echo $course_name >> ./data/$file_name
	echo $course_schedule $course_start $course_end >> ./data/$file_name
	echo $course_credit >> ./data/$file_name
	echo $course_initial >> ./data/$file_name
	echo $write_log >> ./data/queries.log
fi

bash assign1.bash

