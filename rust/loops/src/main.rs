fn main() {
    // loop

    let mut counter = 0;

    let result = loop{
        counter += 1;

        if counter == 10{
            break counter * 2;
        }
    };
    
    println!("{}", result);
    assert_eq!(result, 20);

    // while

    let mut number = 3;

    while number != 0 {
        println!("{}!", number);

        number = number -1;
    }

    println!("LIFTOFF!");

    // for
    let a = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100];

    for element in a.iter() {
        println!("the value is: {}", element);
    }

    //for loop applications

    for countdown in (1..=4).rev() {
        println!("{}!", countdown);
    }

}
