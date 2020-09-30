#!/bin/bash

for((counter=0; counter < 99; counter++))
do
	 curl  https://www.gutenberg.org/files/$counter/$counter-0.txt > guten$counter.txt
done
