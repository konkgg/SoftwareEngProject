import csv

team_scores = {}

users = {"admin": "password"}

def login():
    while True:
        username = input("Enter username: ")
        password = input("Enter password: ")
        if username in users and users[username] == password:
            print("\nLogin successful!")
            return
        else:
            print("\nIncorrect username or password. Please try again.\n")

def load_users():
    with open("users.csv", "r") as f:
        reader = csv.reader(f)
        for row in reader:
            if row:
                users[row[0]] = row[1]

def save_users():
    with open("users.csv", "w", newline="") as f:
        writer = csv.writer(f)
        for username, password in users.items():
            writer.writerow([username, password])

filename = 'scoreboard.csv'
try:
    with open(filename, 'r') as file:
        reader = csv.reader(file)
        for row in reader:
            if row:
                try:
                    team_scores[row[0]] = int(row[1])
                except ValueError:
                    print(f"")
except FileNotFoundError:
    with open(filename, 'w') as file:
        writer = csv.writer(file)
        writer.writerow(['Team', 'Score'])

def update_scores(team, score):
    if not str(score).isdigit():
        return

    team_scores[team] = int(score)
    with open(filename, 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['Team', 'Score'])
        for team, score in team_scores.items():
            writer.writerow([team, score])

def create_team(name):
    team_scores[name] = 0
    with open(filename, 'a') as file:
        writer = csv.writer(file)
        writer.writerow([name, 0])

def remove_team(name):
    del team_scores[name]
    with open(filename, 'w') as file:
        writer = csv.writer(file)
        writer.writerow(['Team', 'Score'])
        for team, score in team_scores.items():
            writer.writerow([team, score])

def display_scoreboard():
    print('\nTeam\tScore')
    for team, score in team_scores.items():
        print(f'{team}\t{score}')
        
def create_schedule():
    weeks = ['week1', 'week2', 'week3', 'week4', 'week5', 'week6', 'week7', 'week8']
    week = input("Enter the week you want to update (week1-week8): ")
    while week not in weeks:
        print("Invalid week entered!")
        week = input("Enter the week you want to update (week1-week8): ")

    matches = []
    for i in range(3):
        team1 = input(f"Enter team 1 for match {i+1} for {week}: ")
        team2 = input(f"Enter team 2 for match {i+1} for {week}: ")
        matches.append((team1, team2))

    with open('schedule.csv', 'a', newline='') as file:
        writer = csv.writer(file)

        writer.writerow([week])
        for team1, team2 in matches:
            writer.writerow([team1, team2])

def display_schedule():
    week = input("Enter week to display (week1-week8): ")
    num_matches = int(input("Enter number of matches to display (1-3): "))
    matches = []
    with open('schedule.csv', 'r') as file:
        reader = csv.reader(file)
        for row in reader:
            if row:
                if row[0] == week:
                    matches.append(row[1].split(','))
    print(week)
    for match in matches[:num_matches]:
        print(','.join(match))

def add_user():
    while True:
        new_username = input("\nEnter new username: ")
        if new_username in users:
            print("\nUsername already exists. Please choose a different username.\n")
        else:
            new_password = input("Enter new password: ")
            users[new_username] = new_password
            save_users()
            break
            
load_users()

login()

while True:
    print('\nWhat would you like to do?')
    print('1. Create a new team')
    print('2. Remove a team')
    print('3. Update a team score')
    print('4. Display the scoreboard')
    print('5. Add a new user')
    print('6. Create a schedule')
    print('7. Display the schedule')
    print('8. Exit')
    choice = input('\nEnter your choice: ')

    if choice == '1':
        name = input('\nEnter the name of the new team: ')
        create_team(name)
        print(f'\nTeam "{name}" created.')

    elif choice == '2':
        name = input('\nEnter the name of the team to remove: ')
        remove_team(name)
        print(f'\nTeam "{name}" removed.')
        
    elif choice == '3':
        name = input('\nEnter the name of the team to update: ')
        if name in team_scores:
            score = input(f'\nEnter the new score for team "{name}": ')
            try:
                score = int(score)
                update_scores(name, score)
                print(f'\nTeam "{name}" score updated to {score}.')
            except ValueError:
                print('\nInvalid input. Please enter a valid integer score.')
        else:
            print(f'\nTeam "{name}" does not exist.')

    elif choice == '4':
        display_scoreboard()

    elif choice == '5':
        add_user()
        print("\nNew user added.")
        
    elif choice == '6':
        create_schedule()
        print('\nSchedule created.')
        
    elif choice == '7':
        display_schedule()

    elif choice == '8':
        exit()

    else:
        print('\nInvalid choice. Please try again.')

