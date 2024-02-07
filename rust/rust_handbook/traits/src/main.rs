use std::fmt::Display;
use aggregator::{Summary, Tweet};

fn main() {
    let tweet = Tweet {
        username: String::from("Lauric"),
        content: String::from("tweet tweet tweet"),
        reply: false,
        retweet: false
    };

    println!("1 new tweet: {}", tweet.summarize())
}

pub trait Summary {
    // fn summarize(&self) -> String;

    // we can also define a default behavior for Summarize
    fn summarize(&self) -> String {
        String::from("Read more...")
    }
}

pub struct NewsArticle {
    pub headline: String,
    pub location: String,
    pub author: String,
    pub content: String,
}

impl Summary for NewsArticle {
    fn summarize(&self) -> String {
        format!("{}, by {} ({})", self.headline, self.author, self.location)
    }
}

pub struct Tweet {
    pub username: String,
    pub content: String,
    pub reply: bool,
    pub retweet: bool
}

impl Summary for Tweet {
    fn summarize(&self) -> String {
        format!("{}: {}", self.username, self.content)
    }
}

// We can use trait in parameters of a function for it to accept an item that implements the trait
pub fn notify(item: &impl Summary) {
    println!("Breaking news! {}", item.summarize());
}

// We can add multiple trait in params with +
pub fn notify_plus(item: &(impl Summary + Display)) {}

// We can also add traits in return type
// This cannot be used to return different types
fn return_summarizable() -> impl Summary {}