#include "stdio.h"
#include "string.h"
#include "unistd.h"
#include <sys/wait.h> 
#include "stdlib.h"
#include <errno.h>

// ./assign8-2 ls -l , sort -k5 -n
// ls -l | sort -k5 -n
int main(int argc, char **argv){ 
    char *commands[2][argc];
    int i, row = 0, col = 0;
    int numCommands;
    int fileDescriptor[2];
    long forkFirst;
    long forkSecond;

    for(i = 1; i < argc; i++){
        if(strcmp(argv[i], ",") != 0)
            commands[row][col++] =argv[i];
        if(strcmp(argv[i], ",") == 0 || i + 1 == argc){
            commands[row][col] = NULL; 
            col = 0;
            row++; 
        }    
    }

    // check number of argument 
    numCommands = row;
    if(numCommands != 2 ){
        perror("Num of commands error");
        return 0;
    }

    // create the pipe
    if(pipe(fileDescriptor) == -1){
        perror("Pipe error");
        return 0;
    }
    switch(forkFirst = fork()){
        case -1: perror("Fork error"); 
        break;
        case 0: 
            if(dup2(fileDescriptor[1], STDOUT_FILENO) == -1) perror("Duplicate out error");
            close(fileDescriptor[0]);
            close(fileDescriptor[1]);
            execvp(commands[0][0], commands[0]);
            perror("Fail to execute out");
        break;
        default:
            switch(forkFirst = fork()){
                case -1: perror("Fork error 2");
                break;
                case 0: 
                    if(dup2(fileDescriptor[0], STDIN_FILENO) == -1) perror("Duplicate in error");
                    close(fileDescriptor[0]);
                    close(fileDescriptor[1]);
                    execvp(commands[1][0], commands[1]);
                    perror("Fail to execute in");
                break;
                default: 
                break;
            }
            wait(NULL);
        break;
    }


    return 0;
}