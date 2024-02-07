fn main() {
    // Generics are used in functions, structs etc.
    // FUNCTIONS
    // Used in signature
    let number_list = vec![34, 50, 25, 100, 65];

    let result = largest(&number_list);
    println!("The largest number is {}", result);

    let char_list = vec!['y', 'm', 'a', 'q'];

    let result = largest(&char_list);
    println!("The largest char is {}", result);

    // STRUCTS
    let integer = Point { x: 5, y: 10 };
    let float = Point { x: 1.0, y: 4.0 };

    // ENUMS
    // see Result<T, E> and Option<T> enums

    // METHODS
}

// the function largest is generic over some type T.
// This function has one parameter named list, which is a slice of values of type T.
// The largest function will return a reference to a value of the same type T
// We add std::cmp::PartialOrd to make it compile (see traits)
fn largest<T: std::cmp::PartialOrd>(list: &[T]) -> &T {
    let mut largest = &list[0];

    for item in list {
        if item > largest {
            largest = item;
        }
    }

    largest
}

// x and y must be of the same type, whatever the type is
struct Point<T> {
    x: T,
    y: T
}

// If we want to have x and y generic but different types:
struct Point2<T, U> {
    x: T,
    y: U
}

// Methods
impl<T> Point<T> {
    fn x(&self) -> &T {
        &self.x
    }
}

// We can restrict the type for a method
// This means Point<f32> will have this method implemented
// Other instances of Point<T> will not have this method
impl Point<f32> {
    fn distance_from_origin(&self) -> f32 {
        (self.x.powi(2) + self.y.powi(2)).sqrt()
    }
}
