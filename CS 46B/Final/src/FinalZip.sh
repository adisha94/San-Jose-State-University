#!/bin/bash
mkdir ~/desktop/CS46B/Final
cd ~/desktop/Place/workspace/Final/src
cp *.java ~/desktop/CS46B/Final
cp *.java ~/desktop
cd ~/desktop
echo "Copying required files to zip folder"
time jar -cf Adish_Final.zip *.java *.bash *.sh
# Copy file to desktop move to desktop
chmod +v uza.bash
cp *.bash ~/desktop/text
echo "All files copied. removing temporary files from desktop and exiting script."
rm *.java *.bash