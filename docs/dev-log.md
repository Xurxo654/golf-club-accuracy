# Development Log: Golf Club Accuracy
## Quick Reference
- **Current Version:** v0.1
- **Current Focus:** Console App
- **Next Major Milestone:** Complete Console App
- **Started:** 2025-08-12
---
# 2025-08-12: Project Kickoff
## Today's Goals
- Set up project structure
- Define core data classes
- write first tests
## Decisions Made
- Use a log to track progress of the project
- Use enum to represent clubs
- No ID in shot. Currently, there is no need to access individual shots
## Progress
- Created Shot class
- Created ShotRepository interface
- Created InMemoryShotRepository implementation
### Tests Created
- `ShotRepositoryContract` - documents interface promises
- `InMemoryShotRepositoryTest` - extends contract
## Lessons Learned
### Interface Testing
- Interfaces define contracts
- Test that the implementations have behavior
- Use an abstract class that can be applied to any implementation
- see `ShotRepositoryContract` class
## Tomorrow's Plan
- Make statistic class
---
# 2025-08-13: Statistics
## Today's Goals
- Set up Statistics
## Progress
- Created `calcDispersion` to create a map of the percentage of shots by `ShotResult`
## Lessons Learned
- Identifying tests can ensure code has appropriate behavior
## Tomorrow's Plan
- add more statistics
---
# 2025-08-15:
## Today's Goals
- Statistics by club
- Start CLI
## Progress
- basic statistics completed
- `ConsoleApp` created
- `ConsoleApp` passes initial tests
### Test Created
- `console app prompts for command when started`
- `console app should accept quit command`
- `console app should handle invalid command`
## Tomorrow's Plan
- Define expectations for adding a shot with `ConsoleApp`
  - What does the command look like?
  - What does the response look like?
- Write test for adding club
- Implement adding club
---
# 2025-08-17
## Today's Goals
- Decide on the process for adding clubs
- implement method to add shots via console app
- make console app continue to run until exit command is received
## Decisions Made
- add shot command will launch a second function to capture details
- Make test extension to reduce code writing for console tests
## Challenges
- Difficulty getting shot enum from `readln()`
  - created method on enum class
  - Issue turned out to be that I did not declare the enum correctly. I didn't have `val` in front of the variable in the constructor so it never became a property of the enum.
## Progress
- made companion object on enums to hand finding by their property names
- Created `ConsoleTestExtension` to simplify console testing
- Refactored tests to utilize `ConsoleTestExtension`
- Created `addShot()` method in `ConsoleApp` 
### Tests Created
- `console app should have add shot command`
- `add shot command should request club data`
- `add shot command should request result data`
- `add shot command should complete successfully`
- `add shot should error on invalid club`
- `add shot command should request club again after invalid club`
- `add shot should error on invalid result`
- `add shot command should request result again after invalid result`
## Tomorrow's Plan
- implement loop to continue to prompt for commands until app is exited
# 2025-08-29
## Today's goals
- make add shot return to main prompt when completed.
## Progress
- Added prompt command to the end of addShot() to loop back to start after shot added.
- Tested loop
## Tomorrow's Plan
- add repository to console app
- save shots to repository