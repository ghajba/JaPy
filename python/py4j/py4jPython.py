__author__ = 'GHajba'

from py4j.java_gateway import JavaGateway
import sys

gateway = JavaGateway()
app = gateway.entry_point

nums = gateway.new_array(gateway.jvm.int, len(sys.argv))
for i in range(1, len(sys.argv)):
    nums[i-1] = int(sys.argv[i])

print("The result is: %d"%app.addNumbers(nums))