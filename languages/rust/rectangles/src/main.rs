struct Rectangle {
    width: u32,
    height: u32,
}

impl Rectangle {
    fn area(&self) -> u32 {
        self.width * self.height
    }
    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width > other.width && self.height > other.height
    }
    fn square(size: u32) -> Rectangle {
        Rectangle { width: size, height: size }
    }
}

fn main() {
    let rect = Rectangle {
        width: 100,
        height: 200,
    };

    let rect2 = Rectangle {
        width: 110,
        height: 210,
    };

    let rect3 = Rectangle {
        width: 1000,
        height: 200,
    };
    println!("The area of this rectangle is {}", rect.area());
    println!("Rect 1 <> Rect 2: {}", rect.can_hold(&rect2));
    println!("Rect 2 <> Rect 1: {}", rect2.can_hold(&rect));

    let square = Rectangle::square(10);

    println!("The area of the square is {}", square.area());
}
