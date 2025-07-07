<div align="center">
<h1>
Karma plugin
</h1>

![Paper Support](image/paper-support.svg)
![Purpur Support](image/purpur-support.svg)
</div>

### A Minecraft Paper plugin to reward the good players and punish the bad players.

## Actions
* ### Killing/damaging a mob
* ### Killing/damaging a player (+settings for spawn killing)
* ### Blowing up a TNT or a crystal
* ### Getting an advancement
* ### Typing a banned word in chat
* ### Collecting flowers
* ### Breeding animals

## karma.yml
**When you first start your server, a file called karma.yml is created. Using it, you can configure the severity of each action taken by a player.**

> **<span style="color:Lime">NOTE:</span>**
> <span style="color:lightgreen">Changes only take effect after restarting the server</span>. 

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

## Effects 
The less karma you have, the less attack damage, attack speed and mining speed you have. The more karna you have, the more attack damage, attack speed and mining speed you have. (not configurable yet)


## Thing to be added:
* Karma leaderboard
* Milestone karma announcements
* A log file to log everything
* Daily login karma

## License
![GitHub License](https://img.shields.io/github/license/consler/Karma)
