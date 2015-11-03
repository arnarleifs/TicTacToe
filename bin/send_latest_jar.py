import ftplib
import os

# Compile the latest .jar
os.system("./gradlew jar")
# Sign the latest .jar
os.system("sudo ./bin/sign_jar")

# Upload file via FTP to server
print("Starting to deploy latest .jar to FTP server")
filename = "build/libs/TicTacToe.jar"
ftp = ftplib.FTP('cptropaeolum.arvixe.com')
ftp.login('tictactoe', 'ticTacTo3')
ftp.cwd('checkthelunch.ekbjarnason.com/wwwroot/data')
myfile = open(filename, 'rb')
ftp.storbinary('STOR TicTacToe.jar', myfile)
myfile.close()
ftp.quit()
print("Latest .jar upload to FTP server completed!")
