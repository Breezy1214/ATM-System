# ATM-System

## Overview

The ATM-System project is a simple ATM simulation written in Java. It allows users to log in with their account
number and PIN, check their balance, deposit money, and withdraw money from their accounts.

## Features

- **Login**: Users can log in using their account number and PIN.
- **Check Balance**: Users can check the balance of their checking and savings accounts.
- **Deposit**: Users can deposit money into their checking or savings accounts.
- **Withdraw**: Users can withdraw money from their checking or savings accounts.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- IntelliJ IDEA or any other Java IDE

### Installation

1. Clone the repository.
2. Open the project in your IDE.

### Running the Application

1. Navigate to the `src` directory.
2. Run the `Atm` class to start the application.

## Usage

1. When prompted, enter the account number `12356797`.
2. Enter the PIN `12345`.
3. Use the menu to check your balance, deposit money, or withdraw money.

## Code Structure

- `src/Menu.java`: Contains the main menu logic and user interaction.
- `src/Account.java`: Represents a bank account with methods for deposit and withdrawal.
- `src/Database.java`: Manages the collection of accounts.
- `src/FileHandler.java`: Handles saving and loading account data to/from a file.

## License

This project is licensed under the MIT License.
