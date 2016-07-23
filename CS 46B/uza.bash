#!/bin/bash

# You are given a "zip of zip files" as argument to this shell script.
# First, unzip the zip file into the current directory.
# Then move the original zip file to a backup, by appending .bak to the name (mv). 
# For each of the extracted zip files, make a new directory whose name is the 
# name of the zip file without the extension .zip (mkdir). For example, if
# a zip file is named fred.zip, you want to make a directory named fred.
# Change into that directory (cd), unzip the file, and change back to 
# the parent.

# The hardest part is to find the name of the file without the extension.
# Here is one way to do that. 
# echo $f | grep -o -E '[^\.]+' | grep -v zip

# To see what it does, try it out on the console: 

# f=fred.zip
# echo $f | grep -o -E '[^\.]+'
# n=`echo $f | grep -o -E '[^\.]+' | grep -v zip`
# echo $n

# An outline of the script is below.

# When you are done, try it out:
# chmod +x uza.bash
# mkdir test
# cd test
# cp ../sample.zip .
# ../uza.bash sample.zip

jar xvf ...
mv ...
for f in ... ; do
   ...
   mkdir ...
   cd ...
   ...
   ...
done 
