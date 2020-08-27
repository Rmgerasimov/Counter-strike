# Counter-strike
This is a basic Shooter game. In the game there are Field, Players of different teams, and Guns.

### Behavior
Separates the players in two types - Terrorist and Counter Terrorist. The game continues until one of the teams is completely dead (all players have 0 health). The terrorists attack first and after that the counter terrorists. The attack happens like that: Each live terrorist shoots on each live counter terrorist once and inflicts damage equal to the bullets fired and after that each live counter terrorist shoots on each live terrorist.
If Terrorists win returns "Terrorist wins!" otherwise returns "Counter Terrorist wins!"

### Input example  
AddGun Rifle Express 100  
AddGun Rifle Buffalo 100  
AddGun Rifle Assault 100  
AddGun Granate Invalid 100  
AddGun Pistol Kolibri 5  
AddGun Pistol Makarov 15  
AddGun Pistol Magnum 3  
AddGun Pistol  3  
AddPlayer Terrorist Shopoff 50 50 Express  
AddPlayer Terrorist Kris 50 50 Buffalo  
AddPlayer Terrorist  50 50 Express  
AddPlayer Terrorist Atanas 50 50 Invalid  
AddPlayer Terrorist Atanas -10 50 Express  
AddPlayer Terrorist Atanas 20 -50 Express  
AddPlayer CounterTerrorist John 50 50 Kolibri  
AddPlayer CounterTerrorist Peter 30 30 Makarov  
AddPlayer Player Invalid 30 30 Makarov  
StartGame  
Report  
Exit
