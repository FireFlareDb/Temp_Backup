package main

import "fmt"

// func gcd(a int, b int) int {
// 	for b != 0 {
// 		a, b = b, a%b
// 	}
// 	return a
// }

func ain() {
	var t int
	fmt.Scanln(&t)

	for i := 0; i < t; i++ {
		var a int
		var b int
		fmt.Scanln(&a)
		fmt.Scanln(&b)

		if a%2 == 0 && b%2 == 0 || gcd(a, b) > 1 {
			fmt.Println(0)
		} else if a%2 == 0 || b%2 == 0 {
			fmt.Println(1)
		} else {
			if gcd(a, b+1) > 1 || gcd(a+1, b) > 1 {
				fmt.Println(1)
			} else {
				fmt.Println(2)
			}
		}
	}
}
