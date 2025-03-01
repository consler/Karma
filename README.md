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
Takes away karma from you and give it to someone else(again, doesn't have to be online but must've played the server at least once). You can't thank someone if after the transaction you end up in debt.

Usage:
```
/thank <player> <number>(can't be negative)
```
Example usage:
```
/thank Steve 69
```

## Actions
The numbers could and will change.

* For getting an advancement, you earn 50 karma. If it's a challenge, you earn 500 karma.

* For killing a monster, you earn 10 karma. For killing a non-monster, you lose 15 karma.

* For damaging a monster, you earn 2 karma. For damaging a non-monster, you lose 3 karma.

## Effects
The less karma you have, the less damage you do. The more karna you have, the mode damage you do.
