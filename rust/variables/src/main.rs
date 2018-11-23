fn main() {
    // Mutability
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);

    // Shadowing
    let y = 10;
    let y = y * 2;
    println!("The value of y is: {}", y);

    // Type change using shadowing
    let spaces = "     ";
    let spaces = spaces.len();
    println!("The value of spaces is: {}", spaces);

    // Scalar Types
    // Integer
    let i: i32 = -1500; // signed
    println!("The value of i is: {}", i);

    let i: u32 = 1500; // unsigned 
    println!("The value of i is: {}", i);

    let i: u8 = 256; // unsigned w/ overflow
    println!("The value of i is: {}, while it should be 256", i);

    // Floating Point
    let fp = 2.0;
    let fp: f32 = 3.0;
    println!("The value of fp is: {}", fp);

    // Numeric Operations
  
    // Addition
    println!("Addition: 5 + 10 = {}", (5+10));
   
    // Subtraction
    println!("Subtraction: 5 - 10 = {}", (5-10));
    
    // Multiplication
    println!("Multiplication: 5 x 10 = {}", (5*10));
    
    // Division
    println!("Addition: 15.0 / 3.2 = {}", (15.0/3.2));

    // Boolean
    let t = true;
    let f: bool = false;

    println!("Boolean: {} {}", t,f);

    // Characters
    let c = 'z';
    let z = 'ℤ';

    let hockey_emoji = '🏒';

    println!("Characters: {} {} {}", c,z,hockey_emoji);

    //Tuples

    let tup: (i32, f64, u8) = (500, 6.4, 1);
    println!("Tuple: ({},{},{})", tup.0, tup.1, tup.2);
    
    let (x, y, z) = tup;

    println!("Deconstructured Tuple: (x) = {}, (y) = {}, (z) = {}", x, y, z);

    //Arrays (type; length)
    let a: [i32; 5] = [1, 2, 3, 4, 5];
    let months = ["January", "Feburary", "March", "April", "May", "..."];

    println!("Arrays: {}, {}", a[0], months[months.len() - 1]);
}
