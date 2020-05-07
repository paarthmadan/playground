use std::io;

fn main() {
    let mut queens: Vec::<(i8, i8)> = Vec::new();
    for i in 0..=7 {
        let mut line = String::new();
        io::stdin().read_line(&mut line).unwrap();

        for (j, c) in line.trim().chars().enumerate() {
            if c == '*' { queens.push((j as i8, (7 - (i as i8)))); }
        }
    }
    let status = if evaluate_validity(&queens) { "valid" } else { "invalid" };
    println!("{}", status);
}

fn evaluate_validity(queens: &Vec::<(i8, i8)>) -> bool {
    if queens.len() != 8 { return false; }
    for i in 0..queens.len() {
        for j in (i + 1)..queens.len() {
            let a = queens[i];
            let b = queens[j];
            if !(horizontal_validity(&a, &b) && vertical_validity(&a, &b) && diagonal_validity(&a, &b)) { return false; }
        }
    }
    true
}

fn horizontal_validity(a: &(i8, i8), b: &(i8, i8)) -> bool {
    a.0 != b.0
}

fn vertical_validity(a: &(i8, i8), b: &(i8, i8)) -> bool {
    a.1 != b.1
}

fn diagonal_validity(a: &(i8, i8), b: &(i8, i8)) -> bool {
    (b.0 - a.0).abs() != (b.1 - a.1).abs()
}
