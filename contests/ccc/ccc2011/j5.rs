use std::{io, process};

fn main() {
    let mut n = String::new();

    io::stdin().read_line(&mut n)
        .expect("Failed to read n");

    let n: u8 = match n.trim().parse() {
        Ok(num) => num,
        Err(_) => process::exit(1),
    };

    let mut invited_by: Vec<u8> = vec![0; n as usize];

    for friend in 0..(n - 1) {
        let mut inviter = String::new();

        io::stdin().read_line(&mut inviter)
            .expect("Failed to read input");

        let inviter: u8 = match inviter.trim().parse() {
            Ok(num) => num,
            Err(_) => process::exit(1),
        };

        invited_by[(inviter - 1) as usize] = invited_by[(inviter - 1) as usize] | (1 << friend);
    }

    let mut sets: u8 = 1;

    for possibility in 1..2_u8.pow((n - 1) as u32) {
        let mut restriction = 0;
        for bit in 1..(n - 1) {
            if possibility & (1 << bit) != 0 {
                restriction = restriction | invited_by[bit as usize]
            }
        }
        if (possibility & restriction) == restriction { sets = sets + 1; }
    }
    println!("{}", sets);
}
