import jpype
import os

jpype.startJVM(jpype.getDefaultJVMPath(), "-ea", "-Djava.class.path=%s"%os.path.abspath("."))

JPypeExample= jpype.JClass("JPypeExample")

numbers = jpype.JArray(jpype.java.lang.Integer, 1)(4)
numbers[0] = jpype.java.lang.Integer(13)
numbers[1] = jpype.java.lang.Integer(1)
numbers[2] = jpype.java.lang.Integer(20)
numbers[3] = jpype.java.lang.Integer(8)

jPypeExample = JPypeExample()

print "The result is: %d"%jPypeExample.addNumbers(13,1,20,8)

print "The result is: %d"%JPypeExample.addition(numbers)
jpype.shutdownJVM()