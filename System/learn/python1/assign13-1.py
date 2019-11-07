import sys

print(sys.argv[1])
infile = open(sys.argv[1], 'r')
for line in infile: 
    print(line)

infile.close()