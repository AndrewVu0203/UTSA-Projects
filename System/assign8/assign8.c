#include "stdio.h"
#include "string.h"
#include "unistd.h"
#include <sys/wait.h> 
#include "stdlib.h"

// ./assign8 ls , pwd , who , echo "andrew loves food"
int main(int argc, char **argv){ 
    char *commands[6][argc];
    int i, row = 0, col = 0;

    for(i = 1; i < argc; i++){
        if(strcmp(argv[i], ",") != 0)
            commands[row][col++] =argv[i];
        if(strcmp(argv[i], ",") == 0 || i + 1 == argc){
            commands[row][col] = NULL; 
            col = 0;
            row++; 
        }    
    }

    int numCommands = row;
    pid_t forkPids[numCommands];
    for(i = 0; i < numCommands; i++){
        switch(forkPids[i] = fork()){
            case -1 : 
                printf("error\n"); 
                break;
            case 0: 
                printf("PID: %ld, PPID: %ld, CMD: %s\n", (long) getpid(), (long) getppid(), commands[i][0]);
                execvp(commands[i][0], commands[i]);
                perror("exec failed");
                exit(0);
                break;
            default : 
                break;
        }
    }

    while(numCommands > 0){
        wait(NULL);
        --numCommands;
    }

    return 0;
}