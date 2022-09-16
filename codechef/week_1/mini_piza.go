package main

import "fmt"

func gcd(a int, b int) int {
	for b != 0 {
		a, b = b, a%b
	}
	return a
}

func main() {
	var t int
	fmt.Scanln(&t)
	for i := 0; i < t; i++ {
		var n, k int
		fmt.Scan(&n, &k)
		fmt.Println(n / gcd(n, k))
	}
}
