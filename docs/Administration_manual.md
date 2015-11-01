# TicTacToe Administration manual

### Requirements
* Java JDK (openjdk-7-jdk recommended)
* Git
* For linux: `apt-get-install git`
* For windows: download and install [git bash](http://git-scm.com/download/win)
* Heroku Toolbelt(for deploying on heroku)
* Linux: `wget -qO- https://toolbelt.heroku.com/install-ubuntu.sh | sh`
* Windows: [Click here](https://toolbelt.heroku.com/windows)
* OSX: [Click here](https://toolbelt.heroku.com/osx)

### Setting up
* Clone the project `git clone` this repository
* For deplaying on heroku do `heroku login` and follow instructions

### Deploying on Heroku
1. When in root directory of the project: `heroku create <NameYourProject>
2. Prepare for pushing on heroku
1. Create a file, system.properties in your apps base folder:
* `echo "java.runtime.version=1.8" > system.properties`
2. Create a file, Procfile in your apps base folder:
* `echo "web: build/install/TicTacToe/bin/TicTacToe" > Procfile`
3. Add the task stage to your build.gradle file to make sure that installApp is run before 
   trying to launch the app using the Procfile definition (see above):
   * `echo "task stage { dependsOn installDist }" >> build.gradle`
   #### Push on Heroku
   1. Run `git status` and add the files to creaded like this:
   * `git status`
   * `git add Procfile system.properties build.gradle`
   * `git commit -m "added gradle files"`
   2. push to heroku:
   * `git push heroku master`
   3. Now check if everything worked properly on: [warm-sierra-2216.herokuapp.com](warm-sierra-2216.herokuapp.com)

   ### Running the app
   1. Run `./gradlew build` when in projects root directory
   2. navigate to build/install/TicTactoe/bin
   3. Run your game
   * Windows: open TicTacToe.bat
   * Linux: run `java TicTacToe`
   4. The game is running on [localhost:4567](localhost:4567)
   * To run on different port:
   * Run: `export PORT=1337`


