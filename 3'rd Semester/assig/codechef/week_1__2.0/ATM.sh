#!/bin/sh

read W B;

isMul=`echo $W | awk '{print $1 % 5}'`
TEMP=`echo $W | awk '{print $1 + 0.50}'`

if (( $(echo "$TEMP > $B" | bc -l) )) || (( $isMul != 0 ));
then
    echo $B
else
    echo $B $W | awk '{print $1 - $2 - 0.50}'
fi


