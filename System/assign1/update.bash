#!bin/bash

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
write_log="[${date}] UPDATED:  ${department_code} ${course_num} ${course_name}"


if [ -f ./data/$file_name ]; then
     
       {
	read department_code0 department_name0
        read course_num0 course_name0
        read course_schedule0 course_start0 course_end0
        read course_credit0
        read course_initial0
	} < ./data/$file_name

	if [ "$department_code" = "" ]; then department_code=$department_code0
	fi
	if [ "$department_name" = "" ]; then department_name=$department_name0
	fi
	if [ "$course_name" = "" ]; then course_name=$course_name0
	fi
	if [ "$course_schedule" = "" ]; then course_schedule=$course_schedule0
	fi
	if [ "$course_start" = ""  ]; then course_start=$course_start0
	fi
	if [ "$course_end" = "" ]; then course_end=$course_end0
	fi
	if [ "$course_credit" = "" ]; then course_credit=$course_credit0
	fi
	if [ "$course_initial" = "" ]; then course_initial=$course_initial0
	fi


	echo $department_code $department_name > ./data/$file_name
	echo $course_name >> ./data/$file_name
	echo $course_schedule $course_start $course_end >> ./data/$file_name
	echo $course_credit >> ./data/$file_name
	echo $course_initial >> ./data/$file_name
	echo $write_log >> ./data/queries.log

else
	echo $file_name
	echo "ERROR: course does not exist, create first then update" 
fi

bash assign1.bash
