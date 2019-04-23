fn main() {
    let mut s = String::from("paarth's string");
    let len = calculate_length(&s);
    println!("The string '{}' has a length of {}", s, len);

    add_period(&mut s);
    println!("The newly formatted string is: {}", s);

    let first_word = first_word(&s);
    println!("The first word of the string is: {}", first_word);
}

fn calculate_length(s: &String) -> usize {
    s.len()
}

fn add_period(s: &mut String) {
    s.push_str("!");
}

fn first_word(s: &str) -> &str {
    let bytes = s.as_bytes();

    for (i, &letter) in bytes.iter().enumerate(){
        if letter == b' ' {
            return &s[..i];
        }
    }

    &s[..]
}


