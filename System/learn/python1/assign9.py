try:
    a = int("a")
#except ValueError: print("You didn't enter an int! Start over.")
except Exception as e: print("a" + e)

print(a)