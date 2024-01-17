fn main() {
    // To change a struct field, the entire instance must be mut
    let mut user1 = User {
        active: false,
        username: String::from("user"),
        email: String::from("em@ail.fr"),
        sign_in_count: 1,
    };
    user1.email = String::from("mail@e.fr");

    // Here we instantiate a new User instance
    // with the same values as user1 but email
    let user2 = User {
        email: String::from("hello@world.fr"),
        ..user1 // this must come last
    }; // user1 can no longer be used as the String username has been moved into user2
    // Had we created a new String for username, we could have still used user1
    // as active and sign_in_count implements the Copy trait

    // We use String owned type and not &str
    // because we want each instance of the Struct to be the owner of its data


    // Tuple Structs
    // Named tuples without having to name all the fields
    struct Color(i32, i32, i32);
    struct Point(i32, i32, i32);
    // These are 2 different types
    let black = Color(0, 0, 0);
    let origin = Point(0, 0, 0);

    // Unit like structs don't have data
    struct AlwaysEqual;
}

struct User {
    active: bool,
    username: String,
    email: String,
    sign_in_count: u64
}

// As field names and param names are the same, instead of doing
// email: email
// username: username
// We just use the same names
fn build_user (email: String, username: String) -> User {
    User {
        active: true,
        username,
        email,
        sign_in_count: 1,
    }
}
