fn main() {
    another_function(5);
    print_label_measurements(5, 'h');

    let y = {
        let x = 3;
        x + 1 // No ; because it's an expression
    }; // => this returns x + 1 and assign it to y
    println!("Value is {y}");

    let a = plus_one(5);
}

fn another_function(x: i32) {
    println!("{x}");
}

fn print_label_measurements(value: i32, unit: char) {
    println!("Measure {value}{unit}")
}

fn five() -> i32 {
    5
}

fn plus_one(x: i32) -> i32 {
    x + 1
}
