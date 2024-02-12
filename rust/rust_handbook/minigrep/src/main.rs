use std::{env, process};

use minigrep::Config;

// Splitting program into main.rs and lib.rs
// main should just:
// - call the command line parsing logic with argument values
// - set up configuration
// - call a run function in lib.rs
// - Handle the error if run returns an error
// => main.rs handles running the program, lib.rs handles the logic

fn main() {
    let args: Vec<String> = env::args().collect();

    let config = Config::build(&args).unwrap_or_else(|err| {
        eprintln!("Problem parsing arguments: {err}");
        process::exit(1);
    });

    if let Err(e) = minigrep::run(config) {
        eprintln!("Application error: {e}");
        process::exit(1);
    }
}




