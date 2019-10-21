my_function(){
    read dept_code0 dept_name0
    read course_name0
    read course_schedule0 course_start0 course_end0
    read course_credit0
    read num_students0
    date0=$3

    #fileNum=$(echo $file | cut -c4-7)
    fileNum=$(echo $file | rev | cut -c5-8 | rev)

    course_num0=$fileNum
    
    if [[ $num_students0 > 50 ]]; then
        my_function1 "$1" "$2" "$3" "$4"
    fi

    mkdir -p $4
} 

my_function1(){

fileName=$(echo $file | cut -c1-3)

cp $1/$2 $4

sed -i.$file "s/\[\[dept_name]]/$dept_name0/g" $4/$2 
sed -i.$file "s/\[\[dept_code]]/$dept_code0/g" $4/$2 
sed -i.$file "s/\[\[course_num]]/$course_num0/g" $4/$2
sed -i.$file "s&\[\[date]]&$date0&g" $4/$2
sed -i.$file "s/\[\[course_name]]/$course_name0/g" $4/$2
sed -i.$file "s&\[\[course_start]]&$course_start0&g" $4/$2
sed -i.$file "s&\[\[course_end]]&$course_end0&g" $4/$2
sed -i.$file "s/\[\[num_students]]/$num_students0/g" $4/$2
sed -i.$file "s/abcdef/abcdef/g" $4/$2

rm $4/$2
mv $4/$2.$file $4/$fileName$fileNum.warn
}

for file in *.crs; do 
    my_function < $file "$1" "$2" "$3" "$4"
done



