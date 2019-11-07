import sys
import os.path

vu = list(filter(os.path.isfile, sys.argv[1:]))
print(vu)

# python3 ex7.py ./ex1.py 