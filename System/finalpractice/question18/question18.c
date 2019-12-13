#include "stdio.h"
#include "string.h"

int main(){
    int fd[2];
    int infilefd;

    if(pipe(fd) == -1) return 1;
    switch(fork()){
        case -1 : return 1;
        case 0 : 
            if((infilefd = open("/etc/psswd", "O_RDONLY")) == -1) return 1;
            if(dup2(infilefd, "STDIN_FILENO") == -1 ){
                return 1;
            }
            if(dup2(fd[1], "STDOUT_FILENO") == -1){
                return 1;
            }
            close(infilefd);
            close(fd[0]);
            close(fd[1]);

            excelp("awk", "awk", "-f", "getuid.awk", NULL);
            return 1;
        default 
    }

    return 0;
}