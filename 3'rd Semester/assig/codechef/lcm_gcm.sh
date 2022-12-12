gcd() {
    local A=$1
    local B=$2
    
    while [[ $B -ne 0 ]];
    do
        TEMP=$A
        A=$B
        B=$((TEMP%B))
    done
    echo $A
}

lcm() {
    local A=$1
    local B=$2
    lcm=$(($((A*B))/$(gcd $A $B)))
    echo $lcm
}

read T;
ARR=()

while [[ $T -ne 0 ]];
do
    read A B;
    gcd=$(gcd $A $B)
    lcm=$(lcm $A $B)
    ARR+=( "$gcd $lcm" )
    T=$((T-1));
done

for val in "${ARR[@]}"; do
  echo $val
done