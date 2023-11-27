# For Players
### This is a Library Mod and is not useful without another mod that depends on `quirl`.

# For Developers

You can use this Library mod to add to existing Minecraft Mechanics like Interacting with Axes/Shovels onto Blocks.

### Add this to depend on `quirl`:

### `build.gradle`:
```gradle
repositories {
    mavenCentral()

dependencies {
    modImplementation "net.rotgruengelb:quirl:${project.quirl_version}"
}
```
### `gradle.properties`:
```properties
quirl_version=<quirl_version>+<mc_version>
```

### Remember to add the dependency to your `fabric.mod.json`
