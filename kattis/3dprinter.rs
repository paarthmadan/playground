use std::{io, process};

fn main() {
    let mut n = String::new();
    io::stdin().read_line(&mut n).unwrap();

    let n = match n.trim().parse::<f64>() {
        Ok(f) => f,
        Err(_) => process::exit(1),
    };
    println!("{}", (n.log2().ceil() as u32) + 1);
}
