
#!/bin/bash
awk '{print $2 " " $1}' | sort | awk '{print $2 " " $1}'


