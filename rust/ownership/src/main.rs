fn main() {
    let mut s = String::from("paarth's string");
    let len = calculate_length(&s);
    println!("The string '{}' has a length of {}", s, len);

    add_period(&mut s);
    println!("The newly formatted string is: {}", s);
}

fn calculate_length(s: &String) -> usize {
    s.len()
}

fn add_period(s: &mut String) {
    s.push_str("!");
}


