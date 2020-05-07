fn main() {
    // Creating Vectors
    let mut v1: Vec<i32> = Vec::new();
    let v2 = vec![3, 4, 5];

    // Pushing elements to a Vector
    v1.push(1);
    v1.push(2);

    // Reading from Vectors
    let second: &i32 = &v2[1];
    println!("The second element is {}", second);

    match v1.get(1) {
        Some(second) => println!("The second element is {}", second),
        None => println!("There is no second element."),
    }

    match v2.get(3) {
        Some(fourth) => println!("The fourth element is {}", fourth),
        None => println!("There is no fourth element."),
    }

    for i in &mut v1 {
        *i += 50;
    }

    for i in v1 {
        println!("{}", i);
    }

}
