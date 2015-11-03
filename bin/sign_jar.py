import os

# Sign Jar with Jarsigner
os.system("jarsigner -keystore build/libs/MyKeystore build/libs/TicTacToe.jar tictactoe < build/libs/pwd")