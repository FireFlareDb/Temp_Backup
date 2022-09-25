#!/bin/sh

read T;

while [[ $T -ne 0 ]];
do
    read val;
    echo "sqrt($val)" | bc
    T=$T-1;
done