fn main() {
    let celcius = 10.0;
    println!("{}", celcius_to_fahrenheit(celcius));

    let fahrenheit = 90.0;
    println!("{}", fahrenheit_to_celcius(fahrenheit));
}

fn celcius_to_fahrenheit(celcius: f32) -> f32{
    celcius * 9.0/5.0 + 32.0
}

fn fahrenheit_to_celcius(fahrenheit: f32) -> f32{
    (fahrenheit - 32.0) * 5.0/9.0
}
