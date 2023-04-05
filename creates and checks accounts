import getpass
import bcrypt

accounts = {}

def create_account():
    while True:
        username = input("Enter a username: ")
        if not username:
            print("Username cannot be empty")
            continue
        if username in accounts:
            print("Username already exists")
            continue
        break
    while True:
        password = getpass.getpass("Enter a password: ")
        if not password:
            print("Password cannot be empty")
            continue
        password_confirm = getpass.getpass("Confirm your password: ")
        if password != password_confirm:
            print("Passwords do not match")
            continue
        break
    hashed_password = bcrypt.hashpw(password.encode('utf-8'), bcrypt.gensalt())
    accounts[username] = hashed_password
    print("Account created successfully")

def check_account():
    while True:
        username = input("Enter your username: ")
        if not username:
            print("Username cannot be empty")
            continue
        break
    password = getpass.getpass("Enter your password: ")
    if username in accounts and bcrypt.checkpw(password.encode('utf-8'), accounts[username]):
        print("Login successful")
    else:
        print("Username or password is incorrect")

while True:
    choice = input("Enter 1 to create a new account, 2 to check an existing account, or q to quit: ")
    if choice == "1":
        create_account()
    elif choice == "2":
        check_account()
    elif choice == "q":
        break
    else:
        print("Invalid choice")
