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
    println!("The value y in outer scope is {y}")

    let spaces = "   ";
    let spaces = spaces.len();

    // Data Types
    

}
