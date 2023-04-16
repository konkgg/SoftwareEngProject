import csv

team_scores = {}

filename = 'scoreboard.csv'
try:
    with open(filename, 'r') as file:
        reader = csv.reader(file)
        for row in reader:
            team_scores[row[0]] = int(row[1])
except FileNotFoundError:
    with open(filename, 'w') as file:
        writer = csv.writer(file)
        writer.writerow(['Team', 'Score'])

def update_scores(team, score):
    team_scores[team] = score
    with open(filename, 'w') as file:
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
    print('Team\tScore')
    for team, score in team_scores.items():
        print(f'{team}\t{score}')

while True:
    print('\nWhat would you like to do?')
    print('1. Create a new team')
    print('2. Remove a team')
    print('3. Update a team score')
    print('4. Display the scoreboard')
    print('5. Exit')
    choice = input('Enter your choice: ')

    if choice == '1':
        name = input('Enter the name of the new team: ')
        create_team(name)
        print(f'Team "{name}" created.')

    elif choice == '2':
        name = input('Enter the name of the team to remove: ')
        remove_team(name)
        print(f'Team "{name}" removed.')

    elif choice == '3':
        name = input('Enter the name of the team to update: ')
        score = input(f'Enter the new score for team "{name}": ')
        update_scores(name, int(score))
        print(f'Team "{name}" score updated to {score}.')

    elif choice == '4':
        display_scoreboard()

    elif choice == '5':
        break

    else:
        print('Invalid choice. Please try again.')
