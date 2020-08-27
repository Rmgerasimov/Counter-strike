# Counter-strike
This is a basic Shooter game. In the game there are Field, Players of different teams, and Guns.

## Behavior
Separates the players in two types - Terrorist and Counter Terrorist. The game continues until one of the teams is completely dead (all players have 0 health). The terrorists attack first and after that the counter terrorists. The attack happens like that: Each live terrorist shoots on each live counter terrorist once and inflicts damage equal to the bullets fired and after that each live counter terrorist shoots on each live terrorist.
If Terrorists win returns "Terrorist wins!" otherwise returns "Counter Terrorist wins!"

## Commands

1. AddGun  Parameters
-	type - String
-	name - String
-	bulletsCount - int
