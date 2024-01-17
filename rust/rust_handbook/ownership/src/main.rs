fn main() {
    // STACK
    // - LIFO
    // - must have a fixed, known size
    // - "Pushing" and "popping"
    // - Faster than allocating space on the heap

    // HEAP
    // - data with unknown size or size that can change
    // - Find empty spot in the heap and returns a pointer to it
    // - Pointer is a known fixed size, hence can be stored on the stack
    // - "Allocating"
    // - Slower

    // OWNERSHIP
    // Rules:
        // Each value in Rust has an owner.
        // There can only be one owner at a time.
        // When the owner goes out of scope, the value will be dropped.

    // String type is manage data on the heap
    let mut s = String::from("Hello");

    s.push_str(", world");
    println!("{s}");

    let s1 = String::from("Hello");
    let s2 = s1;
    // This does not work because Rust invalidates s1
    // s1 was moved into s2
    // println!("{}", s1);

    let s3 = String::from("Hello");
    let s4 = s3.clone(); // deeply copy data to heap

    // Integers are stored on the stack so no need to invalidate them
    let x = 5;
    let y = x;

    let t = String::from("Coucou"); // t comes into scope
    takes_ownership(t); // t's value is moved into the function
                        // and so is no longer valid here
    // println!("{}", t); // so this does not work

    let z = 5; // z comes into scope
    makes_copy(z); // z is into the function but i32 is Copy so it's ok
    println!("{}", z); // So this works

    let u = gives_ownership(); // moves its return value to u

    let s5 = String::from("Salut");
    let s6 = takes_and_give_back(s5); // s5 is moved
                                             // function moves return value to s6
} // s6 goes out of scope so it's dropped
  // s5 was moved so nothing happens
  // u goes out of scope and dropped

fn takes_ownership(some_string: String) {
    println!("{}", some_string);
}

fn makes_copy(some_int: i32) {
    println!("{}", some_int);
}

fn gives_ownership() -> String {
    let str = String::from("yours");
    str
}

fn takes_and_give_back(a_string: String) -> String {
   a_string
}
