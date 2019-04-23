use std::io;
use std::process;

fn main() {
    let numbers = composite_numbers(2_000_000);

    let mut t = String::new();

    io::stdin().read_line(&mut t)
        .expect("Failed to read test cases");

    let t: u16 = match t.trim().parse() {
        Ok(num) => num,
        Err(_) => process::exit(1),
    };

    let mut input: Vec<u32> = Vec::new();

    for case in 0..t {
        let mut number = String::new();

        io::stdin().read_line(&mut number)
            .expect("Failed to read input");

        let number: u32 = match number.trim().parse() {
            Ok(num) => num,
            Err(_) => process::exit(1),
        };

        input.push(number);
    }
    
    for i in input {
        let pair = prime_pair(i, &numbers);
        println!("{} {}", pair.0, pair.1);
    }

}

fn prime_pair(input: u32, set: &Vec<bool>) -> (u32, u32) {
    for (i, b) in set.iter().enumerate() {
        let a = (input * 2) - (i as u32 + 2);
        if !b && !set[(a - 2) as usize] {
           return ((i as u32 + 2), a)
        }
    }
    return (0, 0)
}

fn composite_numbers(max: u32) -> Vec<bool> {
    let mut numbers: Vec<bool> = Vec::new();
    populate_vector(&mut numbers, 2, max);
    let mut next_prime = 0;
    loop {
        for n in 2..=(max / (next_prime + 2)) {
            numbers[((n * (next_prime + 2) - 2)) as usize] = true;
        }
        let find_prime = find_next_prime((next_prime + 1) as usize, &numbers);
        match find_prime {
            Some(num) => next_prime = num,
            None => break,
        };
    }
    numbers 
}

fn populate_vector(num: &mut Vec<bool>, start: u32, end: u32) {
    for _ in start..=end { num.push(false); }
}

fn print_vector(vec: &Vec<bool>) {
    for (i, b) in vec.iter().enumerate() { println!("{}: {}", i + 2, b); }
}

fn find_next_prime(start: usize, vec: &Vec<bool>) -> Option<u32> {
    for (i, b) in vec.iter().skip(start).enumerate() {
        if !b { return Some((i + start) as u32) }
    }
    None
}
