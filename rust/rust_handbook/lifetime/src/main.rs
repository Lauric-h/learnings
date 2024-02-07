use std::fmt::Display;

fn main() {
    // This does not compile
    // let r;
    // {
        // let x = 5;
       // r = &x;
    // }
    // println!("r: {}", r);
    // because the value for r is out of scope

    // We can annotate with lifetime to describe relations
    // between references
    // => Does not affect lifetime, just describes it
    // Starts with a ' and followed by a short name, usually "a" : 'a
    // &'a i32     // a reference with an explicit lifetime
    // &'a mut i32 // a mutable reference with an explicit lifetime

    let string1 = String::from("long string is long");

    {
        let string2 = String::from("xyz");
        let result = longest(string1.as_str(), string2.as_str());
        println!("The longest string is {}", result);
    }

}

// We want the signature to express the following constraint:
// the returned reference will be valid as long as both the parameters are valid.
// This is the relationship between lifetimes of the parameters and the return value.
// We’ll name the lifetime 'a and then add it to each reference,
fn longest<'a>(x: &'a str, y:&'a str) -> &'a str {
    if x.len() > y.len() {
        x
    } else {
        y
    }
}
// we’re not changing the lifetimes of any values passed in or returned.
// Rather, we’re specifying that the borrow checker should reject any values
// that don’t adhere to these constraints.

// Structs
struct ImportantExcerpt<'a> {
    part: &'a str,
}

impl<'a> ImportantExcerpt<'a> {
    fn level(&self) -> i32 {
        3
    }
}

fn longest_with_announcement<'a, T> (
    x: &'a str,
    y: &'a str,
    ann: T,
) -> &'a str
where
    T: Display
{
    println!("Announce {}", ann);
    if x.len() > y.len() {
        x
    } else {
        y
    }
}
