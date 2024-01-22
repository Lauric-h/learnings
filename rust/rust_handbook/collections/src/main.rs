use std::collections::HashMap;
use std::fmt::format;

fn main() {
    // VECTORS
    let v: Vec<i32> = Vec::new();
    // Rust can infer the types in the Vector
    let v1 = vec![1, 2, 3];

    // Updating a Vector
    let mut v2 = Vec::new(); // needs to be mutable to be updated
    v2.push(5);
    v2.push(4);

    let third: &i32 = &v1[2];
    let third: Option<&i32> = v1.get(2);
    match third {
        Some(third) => println!("Third el is {}", third),
        None => println!("There is no third"),
    }

    // We can use vector.get() that returns an Option<&T>
    // with a match value in order to handle if we get an index out of bond
    // let does_not_exist = &v1[100]; => panic because el out of bond
    let does_not_exist = v1.get(100); // do nothing => we should handle it

    // iterating
    let v4 = vec![100, 32, 57];
    for i in &v4 {
        println!("{}", i);
    }

    let mut v5 = vec![100, 32, 57];
    for i in &mut v5 {
        *i += 50;
    }

    // For a vector to hold value of different types
    // we can do it with an enum
    enum SpreadsheetCell {
        Int(i32),
        Float(f64),
        Text(String),
    }

    let row = vec![
        SpreadsheetCell::Int(3),
        SpreadsheetCell::Text(String::from("blue")),
        SpreadsheetCell::Float(10.12),
    ];

    // STRING
    let mut s = String::from("hello");
    s.push_str(", world");
    s.push('!'); // push takes a single char

    let s1 = String::from("hello");
    let s2 = String::from(" world");
    let s3 = s1 + &s2; // concatenate - s1 has been moved and can no longer be used

    // we can use format
    let s4 = format!("{s2} {s3}");


    // To access specific char of a string, we use slices
    let hello = "Здравствуйте";
    let s = &hello[0..4];

    // we can iterate over string and request the type of item we want
    for c in "Зд".chars() {
        println!("{c}");
    }
    for b in "Зд".bytes() {
        println!("{b}");
    }

    // HASHMAP
    let mut scores = HashMap::new();
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Red"), 10);

    let team_name = String::from("Blue");
    let score = scores.get(&team_name).copied().unwrap_or(0);

    for (key, value) in &scores {
        println!("{key} - {value}");
    }

    // ownership
    // types that implement Copy -> values are copied
    // Owned values -> values will be moved to the hashmap
    let field_name = String::from("Favorite color");
    let field_value = String::from("Yellow");
    let mut map = HashMap::new();
    map.insert(field_name, field_value); // after you can no longer use field_name and field_value
    // as they've been moved to the map

    // Overwriting
    let mut scores2: HashMap<String, i32> = HashMap::new();
    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Blue"), 25);

    // Adding a key and value only if key isn't present
    let mut scores3 = HashMap::new();
    scores3.insert(String::from("Blue"), 10);

    scores3.entry(String::from("Yellow")).or_insert(50);
    scores3.entry(String::from("Blue")).or_insert(15);
    println!("{:?}", scores3);

    // Updating based on old value

    let text = "hello world wondferful world";

    let mut words = HashMap::new();

    for word in text.split_whitespace() {
        let count = words.entry(word).or_insert(0);
        *count += 1;
    }
    println!("{:?}", words);
}

