fn main() {
    // If statements
    let number = 4;

    if number % 5 == 0 {
        println!("Divisible by 5");
    } else if number % 4 == 0 {
        println!("Divisible by 4");
    } else {
        println!("Not divisible by either 4, or 5!");
    }

    //Variable assignment with if statement
    let number_two = if number % 5 == 0{
        5
    } else if number % 4 == 0{
        4
    } else {
        1
    };

    println!("Number two: {}", number_two);
}
