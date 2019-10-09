#!bin/bash

sed -r -i "s/<date>/$(date "+%m")\/$(date "+%d")\/$(date "+%Y")/g" $1
sed -i -r -f assign2.sed $1

