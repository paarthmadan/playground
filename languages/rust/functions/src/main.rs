fn main() {
    let result: i32 = multiply_by_two(2);
    println!("The result is {}", result);
}

fn multiply_by_two(number: i32) -> i32{
    number * 2
}
