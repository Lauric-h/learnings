fn main() {
     // Variables and mutability
    let mut x = 5;
    println!("The value of x is: {x}");
    x = 6;
    println!("The value of x is: {x}");

    const THREE_HOURS_IN_SECONDS: u32 = 60 * 60 * 3;

    let y = 5;
    let y = y + 1;
    {
        let y = y * 2;
        println!("The value y in inner scope is {y}");
    }
    println!("The value y in outer scope is {y}");

    let spaces = "   ";
    let spaces = spaces.len();

    // Data Types
    // Tuple
    // Tuples can hold multiple types
    let tup: (i32, f64, u8) = (500, 6.4, 1);
    let (a, b, c) = tup;
    println!("The value of a is {a}"); // = destructuring

    let five_hundred = tup.0;
    let six_point_four = tup.1;
    let one = tup.2;
    // Access tup by index
    println!("five hundred {five_hundred} six four {six_point_four} one {one}");

    // Array
    // Array must have same type and have fixed length
    let arr = [1, 2, 3];
    // [type; length]
    let arr1: [i32; 5] = [1, 2, 3, 4, 5];
    // Access:
    let first = arr1[0];

    // Functions
}
