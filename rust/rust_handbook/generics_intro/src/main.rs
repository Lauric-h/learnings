fn main() {
    first_function();
}

fn first_function(list: &[i32]) -> &i32 {
    let mut largest = &list[0];

    for number in &list {
        if number > largest {
            largest = number;
        }
    }
    largest;
    println!("Largest nb is {}", largest);
}