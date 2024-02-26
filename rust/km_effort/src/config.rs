use crate::unit;

pub struct Config {
    distance: i32,
    elevation: i32,
    pub unit: unit::Unit
}

impl Config {
    pub fn build(args: &[String]) -> Result<Config, &'static str> {
        if args.len() < 3 {
            return Err("not enough arguments");
        }

        let num1 = match args[1].parse::<i32>() {
            Ok(n) => n,
            Err(e) => return Err("Oh non")
        };

        let num2 = match args[2].parse::<i32>() {
            Ok(n) => n,
            Err(e) => return Err("Oh non")
        };

        let unit = match args.get(3).map(|s| s.as_str()) {
            Some("-m") | Some("--miles") => unit::Unit {
                name: unit::UnitName::Miles,
                multiplier: unit::UnitMultiplier::Mile(1.6)
            },
            Some("-km") | Some("--kilometers") | _ => unit::Unit {
                name: unit::UnitName::Kilometers,
                multiplier: unit::UnitMultiplier::Kilometer(1)
            }
        };

        if num1 > num2 {
            return Ok(Config {
                distance: num2,
                elevation: num1,
                unit
            });
        }

        Ok(Config {
            distance: num1,
            elevation: num2,
            unit
        })
    }

    pub fn compute_km_effort(&self) -> f64 {
        let multiplier_value = match self.unit.multiplier {
            unit::UnitMultiplier::Mile(value) => value,
            unit::UnitMultiplier::Kilometer(value) => value as f64
        };

        ((self.distance as f64) / multiplier_value) + (self.elevation as f64) / 100.0
    }
}
