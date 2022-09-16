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

read T;

while [[ $T -ne 0 ]];
do
    read A B;
    OPS=0;
    
    while :
    do
        gcd=$(gcd $A $B)
        if [[ $gcd > 1 ]];
        then
            break;
        fi
        B=$(($B+1));
        OPS=$(($OPS+1));
    done

    echo $OPS
    T=$((T-1));
done
