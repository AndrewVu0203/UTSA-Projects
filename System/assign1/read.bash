#!bin/bash

read -p "Enter a department code and course number: " department_code course_num
file_name=${department_code^^}$course_num.crs

if [ -f ./data/$file_name ]; then
	cat < ./data/$file_name
	#get correct text at correct position
else
	echo "ERROR: course not found"
fi

bash assign1.bash
