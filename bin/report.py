import smtplib

sender = "tictactoeservice@gmail.com"
receivers = ["arnarl14@ru.is", "bjorgvin14@ru.is", "baldurt13@ru.is", "laufeys14@ru.is", "jonasj14@ru.is"]
message = """From: Tic Tac Toe Services <tictactoeservice@gmail.com>
To: TicTacToe Administrators <>
Subject: The deployment was unsuccessful

Please check the logs on Travis for a more detailed logs.

Regards,

The BOSS
"""
try:
    password = "ticTacTo3"
    smptbObj = smtplib.SMTP("smtp.gmail.com", 587)
    smptbObj.ehlo()
    smptbObj.starttls()
    smptbObj.ehlo()
    smptbObj.login(sender, password)
    smptbObj.sendmail(sender, receivers, message)
    smptbObj.quit()
    print ("Successfully sent!")
except smtplib.SMTPException:
    print ("Error: unable to send email")
