use std::fs::File;
use std::io;
use std::io::{ErrorKind, Read};

fn main() {
    let greetings_file_result = File::open("Hello.txt");
    let greeting_file  = match greetings_file_result {
        Ok(file) => file,
        Err(error) => match error.kind() {
            ErrorKind::NotFound => match File::create("hello.txt") {
                Ok(fc) => fc,
                Err(e) => panic!("Pb creating the file {:?}", e)
            },
            other_error => {
                panic!("Pb opening the file {:?}", error);
            }
        }
    };

    // we can use .unwrap() on Result to simplify
    // if it's Ok it returns the value inside the variable
    // else it panics
    let gr = File::open("coucou.txt").unwrap();

    // expect() does the same but less us chose the panic msg
    // => it's more used
    let grr = File::open("coucou.txt")
        .expect("coucou should be here");

    // Propagating errors
    // We can return errors to let the calling parent handle the errors
    // The "?" operator perform an early return, the function has to return a Result to be compatible (or Option)

    // Panic or not panic ?
    // Most of the time it's better to return a Result and let the calling code decide to panic or not



}

// We can create type to ensure validation
pub struct  Guess {
    value: i32,
}

impl Guess {
    pub fn new(value: i32) -> Guess {
        if value < 1 || value > 100 {
            panic!("Value must be between 1 and 100");
        }
        Guess { value }
    }

    pub fn value(&self) -> i32 {
        self.value
    }
}

fn read_username_from_file() -> Result<String, io::Error> {
    let username_file_result = File::open("hel.txt");

    let mut username_file = match username_file_result {
        Ok(file) => file,
        Err(e) => return Err(e),
    };

    let mut username = String::new();
    match username_file.read_to_string(&mut username) {
        Ok(_) => Ok(username),
        Err(e) => Err(e),
    }
}

// Simplify above function with "?"
fn simplified_read_username_from_file() -> Result<String, io::Error> {
    let mut username_file = File::open("hello.txt")?; // If result is an OK, it puts the result in the variable, else it returns an Err from the whole function
    let mut username = String::new();
    username_file.read_to_string(&mut username)?:
    Ok(username)
}

// even simpler by chaining methods
fn even_simpler_read_username_from_file() -> Result<String, io::Error> {
    let mut username = String::new();
    File::open("hello.txt")?.read_to_string(&mut username)?;
    Ok(username)

    // As reading a file is so common, we could simplify even more by doing
    // fs::read_to_string("hello.txt)
}

fn last_char_of_first_line(text: &str) -> Option<char> {
    text.lines().next()?.chars().last()
}

