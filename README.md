# IPoAT-Java Edition

This is a game, where the player can play as a tycoon, who transmitts data over animals. This is a reference to the so
called IPoAC-protocol after [RFC1149](https://datatracker.ietf.org/doc/html/rfc1149). Currently, there are existing two
types of animals: birds and mammals (which are reduced to animals which have hooves). The progress and future ideas can
be seen under [this](https://trello.com/b/5Aa7svzA/ipoat) website, where we show what we're currently doing. It may not be
always the latest version, but it should give you some ideas on what we're currently working.

The game is a sole command-based game. The player has to enter his commands, which are explained down below. There is
also a HELP-command in-game to explain the commands. All commands are case-insensitive, but names have to be correct.

## Game Principle

The player starts with a computer, a floppy disk, a pigeon, a bag and a bird house. With these objects, he must make
money. Money can be earned by sending data via a storage medium such as the floppy disk to another location. If an
animal arrives, it generates the money and flies back. The duration of the two flights to and from the destination are
determined by the speed of the animal. The generated money depends on the amount of data which is sent. Bigger animals
can carry greater amounts of data.  
The player can buy new housing, animals and upgrade objects, but also sell animals or let them breed.

## Commands

```IPoAT
BUY <ANIMAL TYPE>           #BUY A OBJECT OF THE TYPE IN THE BRACKETS
    <STORAGE MEDIUM TYPE>   #TYPES ARE EXPLAINED IN ANOTHER SECTION
    <HABITAT TYPE>
    <TRANSPORT DEVICE TYPE>
    
NEXT DAY                    #A NEW DAY BEGINS. ANIMALS AT HOME RELAX,
                            #ANIMALS ON THE MOVE MOVE FORWARD
                          
SELL    HABITAT     <ID>    #SELL A OBJECT AND RECIEVE PART OF THE COST
        ANIMAL      <NAME>  #ID IS THE ID OF THE OBJECT WHICH THE PLAYER WANTS
        MEDIUM      <ID>    #TO SELL, FOR ANIMALS THE GAME WANTS THE NAME OF THE ANIMAL
        TRANSPORT   <ID>
        
STATS                       #DISPLAY THE STATS OF THE PLAYER

LIST                        #LIST ALL OBJECTS OF A PLAYER

EXIT                        #END GAME (NO SAVEGAMES!!)

HELP                        #DISPLAY ALL AVAILABLE COMMANDS        
```

## Available Types

|             TYPE | Available Types |
|-----------------:|-----------------|
|           ANIMAL | Ox, Pigeon, Cow, Horse, Falcon, Hawk, P1-Ge0n, Donkey               |
|          HABITAT | Stall, Birdhouse               |
| TRANSPORT DEVICE | Bag, Backpack, Cart               |
|   STORAGE MEDIUM | Floppy Disk, CD, DVD, USB, extDrive               |

## Future

Should this game ever be finished, there is a chance this will be translated into C# and put into a Unity project, so
that it is no longer a console game but becomes a nice 3D-Game.