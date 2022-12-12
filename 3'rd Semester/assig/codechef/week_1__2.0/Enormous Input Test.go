package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	var n int
	var k int
	var val int
	count := 0

	reader := bufio.NewScanner(os.Stdin)
	fmt.Scan(&n, &k)

	for i := 0; i < n; i++ {
		reader.Scan()
		val, _ = strconv.Atoi(reader.Text())
		if val%k == 0 {
			count++
		}
	}

	fmt.Print(count)

}
