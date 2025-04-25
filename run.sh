#
# To run a solution using this script:
# 1. Ensure the correct permissions to this file: $ chmod +x run.sh
# 2. Execute: ./run.sh ./leetcode/TwoSum_1.java
#

#!/bin/bash

# Check if the correct number of arguments are provided
if [ $# -ne 1 ]; then
    echo "Usage: $0 <JavaFilePath>"
    exit 1
fi

# Extract the file name and directory path
dir=$(dirname "$1")
dir=${dir#./}
file=$(basename "$1" .java)

# Compile the Java file
javac "$1"

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run the Java program
    java "$dir.$file"
else
    echo "Compilation failed!"
fi
