l

Describes what is needed and how to get the project to build on a fresh machine

## Source control client and access to source control

GitHub is is a Web-based Git repository hosting service. It can host an open source software projects and therefore access is open to all.

#### How to fork the project in GitHub:
Instructions:

Start by forking the repository [TicTacToe](https://github.com/arnarleifs/TicTacToe).

Run the following command in shell (in the directory where you want to clone the project):

1. `git clone` * paste here the url/path of your forked repository*`
2. `./gradlew run` when in projects root folder
3. Try the game locally on [localhost:4567](http://localhost:4567).

#### You can run the game on a different port:
```sh
export PORT=1337
./gradlew run
```

## Build environment

You need to download and setup the following software:

1. [Git](https://help.github.com/articles/set-up-git/)
* For linux: `apt-get-install git`
* For windows: download and install [git bash](http://git-scm.com/download/win)

2. [Java JDK](http://docs.oracle.com/javase/7/docs/webnotes/install/)

## Other necessary dependencies

 * [Travis](https://travis-ci.org/)

 * [Heroku](https://signup.heroku.com/identity)

 * [Selenium IDE](http://www.seleniumhq.org/download/) for Mozilla Firefox. 

 * Velocity template engine

 * Junit

 * Spark

 ## Testing
 ### Unit tests
 1. To run test script:
 `./gradlew test`

 ### End to end tests - Selenium
 #### Requirements
 1. Running on Linux OS make sure you have Firefox 28.0
 * Get [Firefox 28.0](https://ftp.mozilla.org/pub/mozilla.org/firefox/releases/28.0/).
 2. Running on Heroku where you do not have a GUI:
     * `sudo apt-get install -y xvfb`
         * `sudo apt-get install -y xfonts-100dpi xfonts-75dpi xfonts-scalable xfonts-cyrillic`
	     * `sudo apt-get install -y firefox=28.0+build2-0ubuntu2`
	     3. Running on Windows:
	        * Java JDK 7 in your Path (Example `C:\Program Files\Java\openjdk-7.0.71\bin`)
		   * Firefox 28.0 needs to be accesible from the Command Line
		      * Change lines in `build.gradle` that run the server in the `selenium.doFirst` task to use a valid Windows Path, something like `C:\\path-to-project\\build\\install\\TicTacToe\\bin\\TicaTacToe.bat`

		      ## Running selenium test:
		      1. Locally just do `./gradlew selenium`
		      2. Headless mode on servers:
		          * `export DISPLAY=:99`
			      * `./gradlew seleniumXvfb`

