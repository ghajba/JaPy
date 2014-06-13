from jnius import autoclass, JavaException
import sys

PyJNIusExample = autoclass("PyJNIusExample")
pyJNIusExample = PyJNIusExample()

print "Calling instantiated addNumbers... The result is %d"%pyJNIusExample.addNumbers(13,1,20,8)

print "Calling instantiated addition... The result is %d"%pyJNIusExample.addition(13,1,20,8)

print "Calling static addition... The result is %d"%PyJNIusExample.addition(13,1,20,8)

print "----------"

print "And now let's look at some error cases"

PyJNIusExample = autoclass("PyJNIusExampleErrors")
pyJNIusExample = PyJNIusExample()

print "Calling addition on the static class with integers results in: %d"%PyJNIusExample.addition(13,1,20,8)
print "Calling addition on the static class with a String results in: %s"%PyJNIusExample.addition("Hello World")

print "Calling addition on intantiated class..."
# exception handling does not yield the same result as letting the exception fly:
# the message "No methods matching your arguments" is not exactly "jnius.JavaMultipleMethod"
pyJNIusExample.addition(13,1,20,8)
