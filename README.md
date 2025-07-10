<!--suppress HtmlDeprecatedAttribute -->
<div align="center">
<h1>
Karma plugin
</h1>

![Paper Support](img/paper-support.svg)
![Purpur Support](img/purpur-support.svg)
</div>

### **Ever been annoyed at a player for killing turtles, other players, and not caring about their surroundings? Use the karma plugin to punish those types of players and reward the good ones.**

## Actions
* ### Killing/damaging a mob
* ### Killing/damaging a player (+settings for spawn killing)
* ### Blowing up a TNT or a crystal
* ### Getting an advancement
* ### Typing a banned word in chat
* ### Collecting flowers
* ### Breeding animals

## Customization
**When you first start your server, a file called karma.yml is created. Using it, you can configure everything about this plugin. If you feel like anything's missing, please create an issue**

> **NOTE**:
> Changes only take effect after restarting the server

## Commands
### /setkarma
Set one's karma to an integer. The player doesn't have to be online, but must've been on the server at least once.

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
Check one's karma. The player doesn't have to be online, but must've been on the server at least once.

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
Takes away karma from you and gives it to someone else (again, doesn't have to be online, but must've played the server at least once). You can't thank someone if, after the transaction, you end up in debt.

Usage:
```
/thank <player> <number>(can't be negative)
```
Example usage:
```
/thank Steve 69
```
### /leaderboard
Shows the karma leaderboard

Usage:
```
/leaderboard
```

## Effects 
Configure every effect, attribute, and command ran on whatever milestone you want in karma.yml 

## Thing to be added:
* Start a raid and end a raid
* Karma leaderboard
* Daily login karma
* Smart responses for karma.yml parsing errors

## License
![GNU GPL v3.0](https://img.shields.io/github/license/consler/Karma)
