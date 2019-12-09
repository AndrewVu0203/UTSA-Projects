/* README

C1234 -> 1 letter -> 
new input, output file
why i write it in incorrect address
System programming recitation too long name, it does not read white space

make assign7
./assign7
xxd -b courses.dat
hexdump -C courses.dat
*/

#include "stdio.h"
#include "string.h"

typedef struct {
    char courseName[64];
    char courseSched[64];
    unsigned int courseHours;
    unsigned int courseSize;
} COURSE;

void askingUserInput();
void courseActions(char);
void createCourse(COURSE course);
void readCourse(COURSE course);
void updateCourse(COURSE course);
void deleteCourse(COURSE course);

int main(){
    askingUserInput();
    return 0;
}

void askingUserInput(){
    char preUserInput[10];
    char userInput;
    printf("Enter one of the following actions or press CTRL-D to exit.\n");
    printf("C - create a new course record\n");
    printf("R - read an existing course record\n");
    printf("U - update an existing course record\n");
    printf("D - delete an existing course record\n");
    scanf(" %s", preUserInput); 

    if(strlen(preUserInput) > 1) askingUserInput();

    sscanf(preUserInput, "%c", &userInput);

    courseActions(userInput);
}

void courseActions(char userInput){
    COURSE course;
    course.courseName[0]='\0';
    course.courseSched[0]='\0';
    course.courseHours=0;
    course.courseSize=0;

    FILE *file = fopen("courses.dat", "rb+");
    if(file == NULL) {
        file = fopen("courses.dat", "wb");
        fclose(file);
    }

    printf("%c\n", userInput);
    if(userInput == 'C' || userInput == 'c') createCourse(course);
    else if (userInput == 'R' || userInput == 'r') readCourse(course);
    else if (userInput == 'U' || userInput == 'u') updateCourse(course);
    else if (userInput == 'D' || userInput == 'd') deleteCourse(course);
    else printf("ERROR: invalid option\n");

    askingUserInput();
}

void createCourse(COURSE course){
    int courseNumber;
    char file_name[] = "courses_dat";
    FILE *file = fopen("courses.dat", "rb+");
    int seekLocation;
    int readLocation;
    int writeLocation;

    printf("Enter course number: ");
    scanf(" %i", &courseNumber);

    if(course.courseSize > 0){
        printf("ERROR: course already exists\n");
    }
    else{
        scanf(" %[^\n]", course.courseName); 
        scanf(" %s", course.courseSched);     
        scanf(" %i", &course.courseHours); 
        scanf(" %i", &course.courseSize);
        seekLocation = fseek(file, (courseNumber)*sizeof(COURSE), SEEK_SET);
        writeLocation = fwrite(&course, sizeof(course), 1L, file);
    }
    fclose(file);
}

void readCourse(COURSE course){
    int seekLocation;
    int readLocation;
    int courseNumber;
    FILE *file = fopen("courses.dat", "rb");

    printf("Enter a CS course number: ");
    scanf(" %i", &courseNumber);

    seekLocation = fseek(file, courseNumber*sizeof(COURSE), SEEK_SET);
    readLocation = fread(&course, sizeof(COURSE), 1L, file); 
    if(course.courseSize < 1){
        printf("ERROR: course not found\n");
    }
    else{
        printf("Course number: %i \n", courseNumber);
        printf("Course name: %s \n", course.courseName);
        printf("Schedule days: %s \n", course.courseSched);
        printf("Credit hours: %i \n", course.courseHours);
        printf("Enrolled student: %i \n", course.courseSize);
    }

    fclose(file);
}
void updateCourse(COURSE course){
    int courseNumber;
    int seekLocation;
    int readLocation;
    int writeLocation;
    COURSE courseTemp;
    FILE *file = fopen("courses.dat", "rb+");
    printf("Enter course number: ");
    scanf(" %i", &courseNumber);

    seekLocation = fseek(file, courseNumber*sizeof(COURSE), SEEK_SET);
    readLocation = fread(&courseTemp, sizeof(COURSE), 1L, file); 
    if(courseTemp.courseSize < 1){
        printf("ERROR: course not found\n");
    }
    else{
        scanf(" %[^\n]", course.courseName); 
        scanf(" %s", course.courseSched);     
        scanf(" %i", &course.courseHours);     
        scanf(" %i", &course.courseSize);

        if(strlen(course.courseName) == 0) strcpy(course.courseName, courseTemp.courseName);
        if(strlen(course.courseSched) == 0) strcpy(course.courseSched, courseTemp.courseSched);
        if(course.courseHours > 0) course.courseHours = courseTemp.courseHours;
        if(course.courseSize > 0) course.courseSize = courseTemp.courseSize;
        
        seekLocation = fseek(file, courseNumber*sizeof(COURSE), SEEK_SET);
        writeLocation = fwrite(&course, sizeof(course), 1L, file);
    }

    fclose(file);
}
void deleteCourse(COURSE course){
    int courseNumber;
    int seekLocation;
    int readLocation;
    int writeLocation;
    scanf(" %i", &courseNumber);
    FILE *file = fopen("courses.dat", "rb+");

    seekLocation = fseek(file, courseNumber*sizeof(COURSE), SEEK_SET);
    readLocation = fread(&course, sizeof(COURSE), 1L, file); 
    if(course.courseSize < 1){
        printf("ERROR: course not found\n");
    }
    else{
        course.courseSize = 0;
        seekLocation = fseek(file, courseNumber*sizeof(COURSE), SEEK_SET);
        writeLocation = fwrite(&course, sizeof(course), 1L, file);
    }
    fclose(file);
}