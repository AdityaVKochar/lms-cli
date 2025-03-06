# lms-cli

## Overview
This is a simple Library Management System (LMS) command-line interface (CLI) application. It allows users to manage books and members, and perform operations such as borrowing and returning books.

## Features
- Add new books to the library
- Add new members to the library
- Borrow books
- Return books
- Search for books by name or ID
- Search for members by name or ID
- View book details including borrowing history
- View member details including borrowing history

## Classes
### Main
The `Main` class contains the main logic for the CLI application. It includes methods to add books and members, borrow and return books, and search for books and members.

### Book
The `Book` class represents a book in the library. It includes attributes such as book name, author, ID, availability status, and borrowing history.

### Member
The `Member` class represents a member of the library. It includes attributes such as member name, ID, and borrowing history.

### History
The `History` class represents the borrowing history of a book. It includes attributes such as member ID, book ID, borrowing time, and returning time.

## Usage
To run the application, execute the `Main` class. The CLI will prompt for various inputs to perform different operations. Use the following commands:
- `0`: Add Book
- `1`: Add Member
- `2`: Borrow Book
- `3`: Return Book
- `4`: Search Book by Name
- `5`: Search Book by ID
- `6`: Search Member by Name
- `7`: Search Member by ID
- `999`: Help
- `1000`: Exit

## Example
```sh
Library Management System
Made by Aditya Vardhan Kochar

Choices:
0: Add Book
1: Add Member
2: Borrow Book
3: Return Book
4: Search Book by Name
5: Search Book by ID
6: Search Member by Name
7: Search Member by ID
999: Help
1000: Exit

>> 0
Book Name: The Great Gatsby
Author: F. Scott Fitzgerald

>> 1
Member Name: John Doe

>> 2
Book ID: 0
Member ID: 0

>> 4
Enter Book Name: The Great Gatsby
```

## Author
Aditya Vardhan Kochar