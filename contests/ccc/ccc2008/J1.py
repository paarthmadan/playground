import sys

sys.stdout.write("Enter weight: ")
weight = input()

sys.stdout.write("Enter height: ")
height = input()

bmi = weight / height ** 2

if bmi > 25.0:
    print "Overweight"
elif bmi < 18.5:
    print "Underweight"
else:
    print "Normal weight"

