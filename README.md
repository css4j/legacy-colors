# Legacy color graphics

[Apache XMLGraphics-Commons](https://xmlgraphics.apache.org/commons/)
contains code for the (now deprecated) SVG 1.1 extended colors, and for that
reason [EchoSVG](https://github.com/css4j/echosvg) used to depend on
xmlgraphics-commons.

But that xmlgraphics-commons dependency implies that lots of unused code gets
into the EchoSVG classpath, so this project was created.

<br/>

## Building from source

### Requirements

To build Legacy-colors you need the following software installed:

- The [Git version control system](https://git-scm.com/downloads) is required to
obtain the sources. Any recent version should suffice.

- Java version 11 to 21 (later versions may work but aren't tested by CI). You can install
it from your favourite package manager or by downloading from [Adoptium](https://adoptium.net/).

<br/>

### Building with Gradle

Execute the build script with `gradlew build` to build. For example:

```shell
git clone https://github.com/css4j/legacy-colors.git
cd legacy-colors
./gradlew build
```

<br/>

### Deploying to a Maven repository

Use:

- `./gradlew publishToMavenLocal` to install in your local Maven repository.

- `./gradlew publish` to deploy to a (generally remote) Maven repository.

If you plan to deploy to a repository, please configure the `mavenReleaseRepoUrl`
and/or `mavenSnapshotRepoUrl` properties (for example in
`GRADLE_USER_HOME/gradle.properties` or in the [command line](https://docs.gradle.org/current/userguide/build_environment.html#sec:project_properties)).
Otherwise, Gradle shall create a `build/repository` subdirectory and deploy there.

Properties `mavenRepoUsername` and `mavenRepoPassword` can also be set (generally
from the command line).

If you would rather look directly at the Gradle publish configurations, please
read the `publishing.repositories.maven` block of
[build.gradle](https://github.com/css4j/legacy-colors/blob/master/build.gradle).

<br/>

## Usage from a Gradle project

If your Gradle project depends on legacy-colors, you can use this project's own Maven
repository in a `repositories` section of your build file:
```groovy
repositories {
    maven {
        url = "https://css4j.github.io/maven/"
        mavenContent {
            releasesOnly()
        }
        content {
            includeGroup 'io.sf.graphics'
            includeGroup 'io.sf.carte'
            includeGroup 'io.sf.jclf'
        }
    }
}
```
please use that repository **only** for the artifact groups that it supplies
(basically those listed in the above `includeGroup` statements).

Then, in your `build.gradle` file:
```groovy
dependencies {
    implementation 'io.sf.graphics:legacy-colors:1.0'
}
```

<br/>

##  Licensing

 For licensing information, please read the LICENSE and NOTICE files.
