#!bin/bash
# {^^}
read -p "Enter a course department code and number: " department_code course_num
read -p "Enter an enrollment change amount: " amount_change

file_name=${department_code^^}$course_num.crs
date=`date +%m-%d-%Y`
write_log=[$date]" ENROLLMENT: "$department_code" "$course_num" "$amount_change

if [ -f ./data/$file_name ]; then
	{
        read department_code department_name
        read course_num course_name
        read course_schedule course_start course_end
        read course_credit
        read course_initial
        } < ./data/$file_name

	course_initial_after=$((course_initial + $amount_change))	

	echo $department_code $department_name > ./data/$file_name
        echo $course_name >> ./data/$file_name
        echo $course_schedule $course_start $course_end >> ./data/$file_name
        echo $course_credit >> ./data/$file_name
        echo $course_initial_after >> ./data/$file_name
        echo $write_log >> ./data/queries.log

	echo $write_log >> ./data/queries.log
else
	echo $file_name
       echo "ERROR: course not found"
fi

bash assign1.bash
