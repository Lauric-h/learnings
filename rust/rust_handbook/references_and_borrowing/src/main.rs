fn main() {
    let s1 = String::from("hello");
    let len = calculate_length(&s1); // &s1 creates a reference that refers to the value of s1 but does not own it
                                            // because it does not own it, the value it points to will not be dropped
                                            // when the reference stop being used

    println!("size of s1 is {}", len);

    // References are immutable
    // We can create mutable references
    let mut s2 = String::from("hello");
    change(&mut s2);
    // if you have a mutable reference to a value, you can have no other references to that value
    // Also we cannot have a mutable reference while we have an immutable one to the same value
    // But a reference's scope end when it's not used so this works:
    let r1 = &s2;
    let r2 = &s2;
    println!("r1{} r2{}", r1, r2); // scope of r1 and r2 ends there

    let r3 = &mut s2;
    println!("r3 {}", r3);

    // Dangling ref
    let reference_to_nothing = dangle();
}

fn calculate_length(s: &String) -> usize { // s is a reference to a String
    s.len()
} // s goes out of scope but it doesn't have ownership so it's not dropped

fn change(some_string: &mut String) {
    some_string.push_str(", world");
}

fn dangle() -> &String { // dangle returns a reference to a String
    let s = String::from("Hello");
    &s // we return a reference to the String s
} // s goes out of scope and is dropped => danger!
  // because s is created inside the function, the reference would be pointing to an invalid String

fn no_dangle() -> String {
    let s = String::from("hello");
    s
}
