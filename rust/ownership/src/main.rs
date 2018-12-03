fn main() {
    let s = String::from("paarth's string");
    let len = calculate_length(s);
    println!("{}", len);
}

fn calculate_length(s: String) -> usize {
    s.len()
}


