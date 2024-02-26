mod unit;
pub mod config;

use std::error::Error;

const MILES: &str = "miles";
const KILOMETERS: &str = "kilometers";

pub fn run(config: config::Config) -> Result<(), Box<dyn Error>> {
    let result = config.compute_km_effort();

    println!("The km effort of this trail is {} {}", result, config.unit);

    Ok(())
}