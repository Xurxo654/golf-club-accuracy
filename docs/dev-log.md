# Development Log: Golf Club Accuracy
## Quick Reference
- **Current Version:** v0.1
- **Current Focus:** Making statistics
- **Next Major Milestone:** Complete statistics
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
