
****

# Skyblock Stats - SkyPulseStats

![Hypixel Skyblock](https://i.imgur.com/azUSF9u.png)

Last August, Hypixel released a new game mode called **Skyblock**. Skyblock is a game of resource management, skill development, and grinding to the top (whether if it is a potato battle 🥔, or simply using a macro to get your combat level to 50. jk). This app (currently in progress) will be an app that will help deliver information to users about their profile online by creating an HTML page that will show many stats. Unlike other popular Hypixel Skyblock Stat Viewers, such as [sky.lea.moe](sky.lea.moe) or [https://skyblock.matdoes.dev](https://skyblock.matdoes.dev/), this app will show you all information, including your collection level, your collection count, etc, unlike the other Hypixel Skyblock Viewers, which only deliver a limited amount of information. Estimating time-wise, it will take maybe one more month to finish the whole project. Some features I am currently implementing include:

- Decoding the inventory, enderchest, candy talisman, talisman bag, quiver, potion bag, fisherman bag, data in [https://api.hypixel.net/skyblock/profile?key=key_here&profile=profile_id_here](https://api.hypixel.net/skyblock/profile?key=key_here&profile=profile_id_here). This will be hard because I need to decode the [Base64](https://en.wikipedia.org/wiki/Base64) data into a compressed [GZIP](https://en.wikipedia.org/wiki/Gzip) archive, and then decompress it to get a [.NBT](https://minecraft.gamepedia.com/NBT_format) file, which I must then parse in order to get the contents.
- Show all minion tiers. This should be easy, one API call should do the trick.
- Add textures to items. This will be hard as I must be careful to locate the texture path and direct it to the correct item. Perhaps a good example that [sky.lea.moe](sky.lea.moe) used is [slothpixel](https://github.com/slothpixel/core/blob/master/processors/processInventoryData.js), a repo that can help preform this task.

For current problems, there are no problems as I know of, but please report bugs because they help make this project better.
