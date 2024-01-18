fn main() {
    let rect1 = Rectangle {
        width: 30,
        height: 50
    };

    // :? means print debugging info
    // :#? means print debug info in prettier way
    println!("rect1 is {:?}", rect1);

    println!("area of rect with method is {}", rect1.area());
    if rect1.width() {
        println!("Coucou");
    }

    let rect2 = Rectangle {
        width: 10,
        height: 40,
    };
    let rect3 = Rectangle {
        width: 60,
        height: 45,
    };

    println!("Can rect1 hold rect2? {}", rect1.can_hold(&rect2));
    println!("Can rect1 hold rect3? {}", rect1.can_hold(&rect3));

    let sq = Rectangle::square(3);
}

// We use &Rectangle to borrow the struct rather than taking ownership
// This way, main retains its ownership
fn area_func(rectangle: &Rectangle) -> u32 {
    rectangle.height * rectangle.width // Accessing fields of borrowed struct instances does not move values
}

#[derive(Debug)]
struct Rectangle {
    width: u32,
    height: u32,
}

// adding a method to the struct
impl Rectangle {
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn width(&self) -> bool {
        self.width > 0
    }

    fn can_hold(&self, other: &Rectangle) -> bool {
        self.width  > other.width && self.height > other.height
    }

    // function without &self as 1st param don't need an instance of the struct
    // Often use for constructors
    fn square(size: u32) -> Self {
        Self {
            width: size,
            height: size
        }
    }
}