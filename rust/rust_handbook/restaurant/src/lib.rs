// We can use nested path
// instead of this
// use std::cmp::Ordering;
// use std::io;
// We can do
use std::{cmp::Ordering, io};


mod front_of_house {
    pub mod hosting {
        pub fn add_to_waitlist() {}

        pub fn give_menu() {}

        fn seat_at_table() {}
    }

    mod serving {
        fn take_order() {}
        fn serve_order() {}
        fn take_payment() {}
    }

    pub mod paying {}
}

mod back_of_house {
    fn fix_incorrect_order() {
        cook_order();
        super::deliver_order(); // super goes to parent of back_of_house which is crate here
    }

    fn cook_order() {}

    // If the struct has a private field, it neets to have a public function to construct an instance
    // (like a __construct in PHP)
    pub struct Breakfast { // pub makes the struct public but not the fields
        pub toast: String,
        seasonal_fruit: String // this field is private
    }

    impl Breakfast {
        pub fn summer(toast: &str) -> Breakfast {
            Breakfast {
                toast: String::from(toast),
                seasonal_fruit: String::from("peaches"),
            }
        }
    }

    // if an enum is public, all of its variant are public
    // By default, enums are public
    pub enum Appetizer {
        Soup,
        Salad
    }
}

// Instead of using everytime the whole path,
// use 'use'
// We don't use until the function name to make it clear the function isn't locally defined
use crate::front_of_house::hosting;

// When bringing struct, enums and other items, specify the full path is OK
use std::collections::HashMap;

// We can use pub with use to re-export and make the item available for others
pub use crate::front_of_house::paying;

pub fn eat_at_restaurant() {
    // Absolute path
    crate::front_of_house::hosting::add_to_waitlist();

    // Relative path
    front_of_house::hosting::add_to_waitlist();

    let mut meal = back_of_house::Breakfast::summer("Rye");
    meal.toast = String::from("wheat");
    // meal.seasonal_fruit = String::from("orange"); is not possible as field is private

    let order1 = back_of_house::Appetizer::Salad;

    // Here we can use fn from hosting without the whole path
    hosting::give_menu();
}

fn deliver_order() {}
