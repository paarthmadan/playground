use std::panic;
use std::cmp;

fn main() {
    assert!(reverse(321) == 123);
    assert!(reverse(-123) == -321);
    assert!(reverse(1534236469) == 0);
    assert!(reverse(-2147483648) == 0);
    assert!(reverse(1563847412) == 0);
    
    assert!(add_digits(38) == 2);

    assert!(find_complement(5) == 2); 
    assert!(find_complement(1) == 0); 
    assert!(find_complement(2147483647) == 0); 

    let grid = vec![vec![0,1,0,0], vec![1,1,1,0], vec![0,1,0,0], vec![1,1,0,0]];
    assert!(island_perimeter(grid) == 16);

    assert!(valid_parens(String::from("{[]}")) == true);
    assert!(valid_parens(String::from("([)]")) == false);
    assert!(valid_parens(String::from("(")) == false);
}

fn reverse(mut x: i32) -> i32 {
    if x <= i32::min_value() || x > i32::max_value() { return 0 }
    let neg = x < 0;
    if neg { x = x.abs(); }
    let length = ((x as f64).log10().floor() as u8) + 1;
    let mut total = 0;
    for i in 0..length {
        let val = x % 10;
        match val.checked_mul(10_i32.pow((length - i - 1) as u32)) {
            Some(new) => {
                match (total as i32).checked_add(new) {
                    Some(sum) => total = sum,
                    None => return 0,
                }
            },
            None => return 0,
        }
        x /= 10
    }
    if neg { -1 * total } else { total }
}

fn add_digits(mut num: i32) -> i32 {
    if num < 10 { return num }
    let mut sum = 0;
    loop {
        sum += num % 10;
        num = num / 10;
        if num == 0 { break; }
    }
    add_digits(sum)
}

fn find_complement(mut num: i32) -> i32 {
    let mut sum = 0;
    for i in 0..((num as f32).log2() as u32) {
        sum += (!(num & 1) + 2) * 2_i32.pow(i);
        num >>= 1;
    }
    sum
}

fn island_perimeter(grid: Vec<Vec<i32>>) -> i32 {
    let mut perimeter = 0;
    for j in 0..grid.len() {
        for i in 0..grid[j].len() {
            if grid[j][i] == 0 { continue; }
            if i == 0 { perimeter += 1 }
            else if grid[j][i - 1] == 0 { perimeter += 1 }

            if i == grid[j].len() - 1 { perimeter += 1 }
            else if grid[j][i + 1] == 0 { perimeter += 1 }

            if j == 0 { perimeter += 1 }
            else if grid[j - 1][i] == 0 { perimeter += 1 }

            if j == grid.len() - 1 { perimeter += 1 }
            else if grid[j + 1][i] == 0 { perimeter += 1 }
        }
    }
    perimeter
}

fn fizz_buzz(n: i32) -> Vec<String> {
    let mut output: Vec<String> = Vec::new();
    for i in 1..=n {
        if i % 15 == 0 { output.push(String::from("FizzBuzz")); }
        else if i % 5 == 0 { output.push(String::from("Buzz")); }
        else if i % 3 == 0 { output.push(String::from("Fizz")); }
        else { output.push(i.to_string()); }
    }
    output
}

fn max_increase_keeping_skyline(grid: Vec<Vec<i32>>) -> i32 {
    let mut x: Vec<i32> = vec![-1; grid.len()];
    let mut y: Vec<i32> = vec![-1; grid.len()];
    for (i, row) in grid.iter().enumerate() {
        for (j, element) in row.iter().enumerate() {
            if (element > &y[i]) { y[i] = *element; }
            if (element > &x[j]) { x[j] = *element; }
        }
    }
    let mut sum = 0;
    for (i, row) in grid.iter().enumerate() {
        for (j, element) in row.iter().enumerate() {
            sum = sum + (cmp::min(x[j], y[i]) - *element);
        }
    }
    return sum;
}

fn valid_parens(s: String) -> bool {
    let mut stack: Vec<char> = Vec::new();
    for c in s.chars() {
        if c == '(' || c == '{' || c == '[' {
            stack.push(c);
        } else {
            let el = stack.pop();
            let el = match el {
                Some(c) => c,
                None => return false,
            };
            match (el, c) {
                ('[', ']') => continue,
                ('{', '}') => continue,
                ('(', ')') => continue,
                _ => return false,
            }
        }
    }
    stack.len() == 0
}
