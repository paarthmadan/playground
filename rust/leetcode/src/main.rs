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

