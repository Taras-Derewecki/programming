printf "Enter # of time to run: "
read userin

bacc tderewecki5

printf "\n\nRunning process:\n\n"

for ((i = 1; i <= $userin; i++))
do
    bainterp tderewecki5 2 >& 1 | grep "stack" &> /dev/null
	if [ $? -eq 0  ]
	then	
		printf "Error in execution  #"$i"\n\n"
		exit 1
	fi
done

printf "All runs successful!:\n\n"
