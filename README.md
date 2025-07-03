# Karma Plugin
is a Minecraft Paper plugin to reward the good players and punish the bad players.

## Commands
### /setkarma
Set one's karma to an integer. The player doesn't have to be online but must've been on the server at least once.

Usage:
```
/setkarma <player>(optional, defaulted to the sender) <number> 
```
Example usage:
```
/setkarma Steve 150
```
```
/setkarma 120
```
### /checkkarma
Check one's karma. The player doesn't have to be online but must've been on the server at least once.

Usage:
```
/checkkarma <player>(optional, defaulted to the sender)
```
Example usage:
```
/checkkarma Steve
```
```
/checkkarma
```
### /thank
Takes away karma from you and give it to someone else (again, doesn't have to be online but must've played the server at least once). You can't thank someone if after the transaction you end up in debt.

Usage:
```
/thank <player> <number>(can't be negative)
```
Example usage:
```
/thank Steve 69
```
## karma.yml
When you first start the server a file karma.yml is created. You can tinker with values n stuff in it. 

Changes only take effect after restarting the server.

## Actions
Currently, there are 5 actions:
* Killing a mob
* Damaging a mob
* Priming a TNT
* Blowing up a crystal
* Getting an advancement

## Effects 
The less karma you have, the less attack damage, attack speed and mining speed you have. The more karna you have, the more attack damage, attack speed and mining speed you have. (not configurable yet)


## Thing to be added:
* Karma leaderboard
* Milestone karma announcements
* A log file to log everything
* Daily login karma