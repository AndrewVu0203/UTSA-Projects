#!/usr/bin/env python3
import sys
import os
import shutil
import re 

my_dir = os.path.expanduser('~/rm_trash')
# my_dir = "rm_trash"

# folder rm_trash
if os.path.isdir(my_dir) == False:
    os.mkdir(my_dir)

# function for all actions required for thi assignmentt
def allActions(currentArgv, haveR):

    # special case with directory, don't care about extension 
    if os.path.isdir(currentArgv) and not haveR:
        print("rm.py: cannot remove ’DIR’: Is a directory")
        # sys.stderr.write
        sys.exit(1)
    elif os.path.isdir(currentArgv) == True and haveR == True and os.path.exists(my_dir + "/" + currentArgv) == False: 
        shutil.move(currentArgv, my_dir)

    # if first file is not in the trash, don't care about extension
    if os.path.exists(my_dir + "/" + currentArgv) == False:    
        os.rename(currentArgv, my_dir + "/" + currentArgv)

    # remove extension to handle duplicate, then add it back 
    argSecondSearch = re.search('\.[a-z]{1,}', currentArgv)
    argSecond = "" 
    if argSecondSearch != None : 
        argSecond = argSecondSearch.group(0)
        print(argSecond)
    
    argFirstSearch = re.search('[a-z]{1,}', currentArgv)
    argFirst = "" 
    if argFirstSearch != None : 
        argFirst = argFirstSearch.group(0)
        print(argFirst)

    # handle duplicates. If -x already have, then -x+1 and loop again. 
    if argSecondSearch == None:
        b = 1
        while b != 0:
            if os.path.exists(my_dir + "/" + currentArgv + "-" + str(b)) == True:
                b = b + 1
            else : 
                if os.path.exists(currentArgv) == True and os.path.exists(my_dir + "/" + currentArgv) == True: 
                    os.rename(currentArgv, my_dir + "/" + currentArgv + "-" + str(b))
                break   

    else :
        print("else")
        b = 1
        while b != 0:
            if os.path.exists(my_dir + "/" + argFirst + argSecond) and not os.path.exists(my_dir + "/" + argFirst + "-1" + argSecond):    
                os.rename(currentArgv, my_dir + "/" + argFirst + "-1" + argSecond)
                break
            elif os.path.exists(my_dir + "/" + argFirst + "-" + str(b) + argSecond) == True:
                b = b + 1
            else : 
                if os.path.exists(currentArgv) == True and os.path.exists(my_dir + "/" + currentArgv) == True: 
                    os.rename(currentArgv, my_dir + "/" + argFirst + "-" + str(b) + argSecond)
                break
        
# loop through every argument, then call function to pass variable
for i in range(len(sys.argv)):
    # if arguments have "-r"
    haveR = False
    if "-r" in sys.argv :
        haveR = True

    # only argument larger than 0 mattters 
    if i > 0 : 

        if os.path.exists(sys.argv[i]):
            allActions(sys.argv[i], haveR)
        elif sys.argv[i] == "-r":
            pass
        else: 
            print("rm.py: cannot remove ’FILE’: No such file or directory")