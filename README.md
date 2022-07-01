# Game Night Selector

This is a project that will help a group of game players select the right game to play. 

This application will allow a single player or a group of 2 or more to automatically select the first game to play. The application will allow for the game to be selected based
on number of players, available games, game type preference. It will allow specific games to be removed from consideration based on player preference and age restrictions.

# How will it work?

1) The console will ask for the names of the players `num of players must be > 0 and < 9 unless we add optional group splitting`

2) When the players names have been entered the application will pull each player's data file `.csv` `database integration possible alternative but may take more than time allotted`
   The file will include the following:
   - PlayerInfo
     - Age
     - game type preference `>= 1`
     - minGameTime preference (`can be null`)
     - Available game
       - name
       - type
       - minPlayerCount
       - maxPlayerCount
       - minPlayerAge
       - minGameTime
   - played recently `optional: edit field dynamically if game is played for next game selection`

3) PlayerInfo will be added to collection `# and  type TBD` 
4) All games will be added to a collection
5) `Optional` if player count > 10 split into 2 groups and each will follow the remainder
6) Game collection will be filtered in this order
   - Age Restriction `auto remove games over the age restriction`
   - Player count `auto remove games`
   - Game type preference `take top ? of a sorted collection`
   - Recently Played
7) Generate a random number based on the games left
8) Use the random number as an index value to select the game
9) Print Game Selection!


# Deliverables:

1) Create all applicable classes, enum, interfaces, possibly fields
2) Create all applicable empty methods `as far as we currently know`
3) Create test classes and empty test methods
4) Create .csv ingest capability
5) Write method and test method logic
6) Integration of ingester and package structure

Optional Deliverables:

1) Add logic to split group into 2
2) Add player recently to .csv and filtering logic
