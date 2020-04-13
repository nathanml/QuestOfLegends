Nathan Maher Levy
U53054148

To run this project, run the following commands in terminal from the root directory:

javac Main/Main.java
java Main/Main

Welcome to The Quest of Legends, a magical game full of spells, heroes, and monsters!
--------------------------------------------------------------------------\n" +
THE WORLD OF PLAY
The world of play is an 8x8 board divided into 3 lanes. At each end of the board is the hero
and monster nexus. The first team that gets to the other team's nexus is the winner of the game.
Each team consists of 3 heroes, with each hero spawning in one lane. Warriors will be denoted with
a W, sorcerers with an S, and Paladins with a P. At the heroes nexus, the heroes can buy items.
The monsters move first, then the hero in the rightmost lane. During each move, a hero can perform 
the following actions:
    W/w: Move up
    A/a: Move left
    S/s: Move down
    D/d: Move right
    Q/q: Quit game
    I/i: Check current hero's inventory
    Instructions: Show the instructions
    B/B: Return to the Heroes Nexus
    1: Attack a monster on same or neighboring tile
    2: Cast a spell
    3: Drink a potion
    4: Equip a weapon
    5: Put on an armor
    teleport: Teleport to a tile in a different lane
The heroes cannot move or teleport to a tile past the the monster in that lane unless the hero has killed
the monster. Monsters respawn at the Monsters nexus every 8 rounds and heroes respawn at the heroes nexus
with half their health when they die.
--------------------------------------------------------------------------
THE HEROES NEXUS
At the hero nexus you can buy weapons, armors, spells, and potions. The heroes nexus can be accessed at the nexus tiles in the bottom most row. Heroes can buy and sell items at the hero nexus At the hero nexus, there are:
    Weaponries which sell weapons, which can be used to attack monsters during fights. Heroes can only hold one weapon at a time, so they must equip a weapon before they can attack with it.
    Armories which sell armors, which protect heroes from incoming attacks from monsters.
    Potion markets sell potions, one use items that can increase one of a hero's attributes.
    Fire markets sell fire spells which damage an enemy and reduces that enemy's defense
    Ice markets sell ice spells which damage an enemy and reduces that enemy's damage.
    Lightning markets sell lightning spells which make it harder for an enemy to dodge attacks.
------------------------------------------------------------------------------\n" +
THE HEROES AND MONSTERS
There are 3 types of heroes: Warriors (favored on strength and agility), Sorcerers (favored on dexterity and agility), and Paladins 
(favored on strength and dexterity). All heros have health (hp), magic power (mana), and experience (exp). Mana is required for casting spells and experience determines when a hero can level up. Hero's strength is the damage they inflict when they attack, dexterity increases damage when casting a spell, and agility increases the chance of dodging an incoming attack.\n" +
When heroes land on a non-market tile, there is a 75% chance that a fight with monsters will be started. The team of monsters will be randomly formed at the moment of the fight. The three types of monsters are Dragons (higher damage), Exoskeletons (higher defense), and Spirits (higher dodge chance).