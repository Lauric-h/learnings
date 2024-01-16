fn main() {
    // If
    let number = 3;

    if number < 5 {
        println!("Oui");
    } else {
        println!("non");
    }

    let condition = true;
    let n = if condition { 5 } else { 6 };
    println!("The value of number is: {number}");

   // let m = if condition { 5 } else { "six" }; // => Error because not same type

    // Loops
    let mut counter = 5;

    let result = loop {
        counter += 1;
        if counter == 10 {
            break counter * 2;
        }
    };

    println!("result {result}");

    // Loop labels
    let mut count = 0;
    'counting_up: loop {
        println!("count = {count}");
        let mut remaining = 10;

        loop {
            println!("remaining = {remaining}");
            if remaining == 9 {
                break;
            }
            if count == 2 {
                break 'counting_up;
            }
            remaining -= 1;
        }
        count += 1;
    }
    println!("End count = {count}");

    // while
    let mut wh = 3;
    while wh != 0 {
        wh -= 1;
    }
    println!("stop");

    // For
    let a = [10, 20, 30, 40, 50];
    let mut index = 0;
    for element in a {
        println!("The value is {element}");
    }

    for num in (1..4).rev() { // rev() reverses the range
        println!("{num}");
    }
}
