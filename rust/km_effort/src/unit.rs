use std::fmt::{Display, Formatter};
use crate::{KILOMETERS, MILES};

#[derive(Debug)]
enum UnitEnum {
    Mile(Unit),
    Kilometer(Unit)
}

#[derive(Debug)]
pub(crate) enum UnitName {
    Miles,
    Kilometers
}

impl Display for UnitName {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        let name  = match self {
            UnitName::Miles => MILES,
            UnitName::Kilometers => KILOMETERS
        };

        write!(f, "{}", name)
    }
}

#[derive(Debug)]
pub(crate) enum UnitMultiplier {
    Mile(f64),
    Kilometer(i32)
}

#[derive(Debug)]
pub(crate) struct Unit {
    pub(crate) name: UnitName,
    pub(crate) multiplier: UnitMultiplier
}


impl Display for Unit {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        write!(f, "{:?}", self.name)
    }
}
