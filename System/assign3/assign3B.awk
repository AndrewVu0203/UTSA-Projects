BEGIN{
    Date["Jan"]=1;
    Date["Feb"]=2;
    Date["Mar"]=3;
    Date["Apr"]=4;
    Date["May"]=5;
    Date["Jun"]=6;
    Date["Jul"]=7;
    Date["Aug"]=8;
    Date["Sep"]=9;
    Date["Oct"]=10;
    Date["Nov"]=11;
    Date["Dec"]=12;

    latestTime;
    latestTimeLine;
    earliestTime = "Dec31" # edge case
    earliestTimeLine
}

$1 ~ /[a-z]{3}[0-9]{3}/{
    if(match(prev, $1)){
    }
    else{
        printf("User: %6s\n", $1)   
    }

    printf("\t")
    for(i = 8; i <= NF; i++){
        printf("%6s ", $i )
    }
        printf("\n")

    prev = $1
}

$5 ~ /[0-9]{2}:[0-9]{2}/ && $1 ~ /[a-z]{3}[0-9]{3}/{
    # if varTime < inputTime, replace it cause we need to find largest time
    # for same time, since it's already alphabet, so if time is equal, don't replace it with new alphabet

    if(latestTime < $5 && latestTime != $5){
        latestTime = $5
        latestTimeLine = $0
    }
}

$5 ~ /[A-Za-z]{3}[0-9]{2}/{
    if(Date[substr(earliestTime, 1,3)] > Date[substr($5, 1,3)]){
        earliestTime = $5
        earliestTimeLine = $0
    }
    if(Date[substr(earliestTime, 1,3)] == Date[substr($5, 1,3)] && substr(earliestTime, 4,5) > substr($5, 4,5) ){
        earliestTime = $5
        earliestTimeLine = $0
    }
}

END {
    print("Earliest Start Time: ")
    printf("%s \n", earliestTimeLine)

    print("Latest Start Time: ")
    printf("%s \n", latestTimeLine)
}

