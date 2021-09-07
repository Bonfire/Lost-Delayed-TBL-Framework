# Lost-Tick-TBL-Framework

An augmented Tree-Branch-Leaf framework that also includes tick delays and delayed interacts. Specifically made for LostClient.

Note that for delayed interacts, follow the example code I've written under the `Interaction.java` class. You must write a wrapper around your interact code and supply delays.

## Setup

1. Download the code (I prefer as a ZIP file)
2. Extract the `src/` folder to your script module
3. Remove the `src/org/lostclient/behaviour/walk` example package and references to the `WalkingBranch` in the `Main.java`

## Structure

- `src/org/lostclient/behaviour` - This is where your branches and leaves should be defined. They describe the functionality of your script. I'd recommend not touching the `tick` functionality unless you know what you are doing.
- `src/org/lostclient/framework` - This contains the core of the Tree-Branch framework code. Credits to LostVirt.
- `src/org/lostclient/paint` - Where the core of the script paint code is defined. Credits to Fluffy.
- `src/org/lostclient/utilities` - Contains our utility classes (and it's where you should define any future utility classes),
  - `API.java` - Holds current tree information as well as sleep delay and tick delay settings. Modify the settings to your liking. Also contains the method used in deriving both delays.
  - `Interaction.java` - An example interaction helper that utilizes the framework's sleep delay system. Do note that some interactions are handled by the client (such as walking a path), so only the first action will have a delay.
- `src/org/lostclient/Main.java` - Where you change your script's manifest, branches/leaves, and paint.

## Credits

- [LostVirt's Dreambot-Tree-Branch-Framework](https://github.com/LostVirt/Dreambot-Tree-Branch-Framework) - For the bulk of framework code here
- [Elli-tt's elutils](https://github.com/Elli-tt/el-plugins-source) - For the tick and sleep delay ideas and code
