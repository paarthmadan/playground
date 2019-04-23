struct User {
    name: String,
    age: i8,
    email: String,
    likes_pizza: bool,
}

fn main() {
    let fixed_user = User {
        name: String::from("Paarth"),
        age: 18,
        email: String::from("paarth@example.com"),
        likes_pizza: true,
    };
    println!("{} is {} and it is {} that this person enjoys pizza", fixed_user.name, fixed_user.age, fixed_user.likes_pizza);
    let mut user = User {
        name: String::from("Paarth"),
        age: 18,
        email: String::from("paarth@example.com"),
        likes_pizza: true,
    };
    user.name = String::from("Batman");;
    user.likes_pizza = false;
    user.email = String::from("batman@example.com");
    println!("{} is {} and it is {} that this person enjoys pizza", user.name, user.age, user.likes_pizza);
}
