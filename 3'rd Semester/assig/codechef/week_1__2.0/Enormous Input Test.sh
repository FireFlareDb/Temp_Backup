#!/bin/sh

read N K;

COUNTER=0

while [[ $N -ne 0 ]];
do
    read VAL;
    if (( $VAL%$K == 0 ));
    then
        COUNTER=$((COUNTER+1))
    fi
    
    N=$N-1
done

echo $COUNTER
