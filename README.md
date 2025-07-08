<div align="center">
<h1>
Karma plugin
</h1>

![Paper Support](img/paper-support.svg)
![Purpur Support](img/purpur-support.svg)
</div>

### **Ever been annoyed at a player for killing turtles, other players, and not caring about their surroundings? Use the karma plugin to punish that type of players and reward the good players.**

## Actions
* ### Killing/damaging a mob
* ### Killing/damaging a player (+settings for spawn killing)
* ### Blowing up a TNT or a crystal
* ### Getting an advancement
* ### Typing a banned word in chat
* ### Collecting flowers
* ### Breeding animals

## Customization
**When you first start your server, a file called karma.yml is created. Using it, you can configure everything about this plugin. If you feel like anything's missing, please create an issur**

> **NOTE**:
> Changes only take effect after restarting the server

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
* Taming
* Plant sapling
* Healing an animal
* Start a raid and end a raid
* Defeat bosses
* Karma leaderboard
* Daily login karma
* Smart responses for karma.yml parsing errors

## License
![GNU GPL v3.0](https://img.shields.io/github/license/consler/Karma)
