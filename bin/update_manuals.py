import ftplib
import os

os.system("python bin/md_to_html.py")

ftp = ftplib.FTP('cptropaeolum.arvixe.com')
ftp.login('tictactoe', 'ticTacTo3')
ftp.cwd('docs.ekbjarnason.com/wwwroot/develop')

# Upload development manual via FTP to server
print("Starting to deploy development manual to docs.ekbjarnason.com")
for root, dirs, files in os.walk('docs/dev'):
	for fname in files:
		full_fname = os.path.join(root, fname)
		full_fname = full_fname.replace("\\", "/")
		correctPath = full_fname.split("dev")[1]
		correctPath = correctPath[1:]
		ftp.storbinary('STOR ' + correctPath, open(full_fname, 'rb'))
print("Development manual deployment completed")

# Upload Administration manual via FTP to server
print("Starting to deploy administration manual to docs.ekbjarnason.com")
ftp.cwd('../admin')
for root, dirs, files in os.walk('docs/admin'):
	for fname in files:
		full_fname = os.path.join(root, fname)
		full_fname = full_fname.replace("\\", "/")
		correctPath = full_fname.split("admin")[1]
		correctPath = correctPath[1:]
		ftp.storbinary('STOR ' + correctPath, open(full_fname, 'rb'))
print("Administration manual deployment completed")

# Upload design report via FTP to server
print("Starting to deploy design report to docs.ekbjarnason.com")
ftp.cwd('../design')
for root, dirs, files in os.walk('docs/design'):
	for fname in files:
		full_fname = os.path.join(root, fname)
		full_fname = full_fname.replace("\\", "/")
		correctPath = full_fname.split("design")[1]
		correctPath = correctPath[1:]
		ftp.storbinary('STOR ' + correctPath, open(full_fname, 'rb'))
print("Design report deployment completed")

ftp.quit()