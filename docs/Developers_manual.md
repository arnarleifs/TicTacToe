nual

## Getting started

### Requirements
* Java JDK (openjdk-7-jdk recommended)
* Git
* For linux: `apt-get-install git`
* For windows: download and install [git bash](http://git-scm.com/download/win)

### Setting up!
1. `git clone` this repository.
2. `./gradlew run` when in projects root folder
3. Try the game locally on [localhost:4567](http://localhost:4567).

#### To run the game on another port:
```sh
export PORT=1337
./gradlew run
```

## Testing
### Unit tests
1. To run test script:
`./gradlew test`

### Functional tests - Selenium
#### Requirements
1. Running on Linux OS make sure you have Firefox 28.0
* Get [Firefox 28.0](https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/28.0/).
2. Running on Servers (GreenQloud for example) where you do not have a GUI:
    * `sudo apt-get install -y xvfb`
        * `sudo apt-get install -y xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic`
	    * `sudo apt-get install -y firefox=28.0+build2-0ubuntu2`
	    3. Running on Windows:
	       * Java JDK 7 in your Path (Example `C:\Program Files\Java\openjdk-7.0.71\bin`)
	          * Firefox 28.0 needs to be accesible from the Command Line
		     * Change lines in `build.gradle` that run the server in the `selenium.doFirst` task to use a valid Windows Path, something like `C:\\path-to-project\\build\\install\\TicTacToe\\bin\\ticatactoe.bat`


		     ## Running selenium test:
		     1. Locally just do `./gradlew selenium`
		     2. Headless mode on servers:
		         * `export DISPLAY=:99`
			     * `./gradlew seleniumXvfb`


