read -p "Enter a course department code and course number: " department_code course_num
file_name=${department_code^^}$course_num.crs
date=`date +%m-%d-%Y`
write_log=[$date]" DELETED:"$department_code" "$course_num

echo $file_name
if [ -f ./data/$file_name ]; then
	rm ./data/$file_name	
	echo "course number was successfully deleted"
else 
	echo "ERROR: course not found"
fi

bash assign1.bash

