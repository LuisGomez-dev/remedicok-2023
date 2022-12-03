# remedicok-2023
Remedicok multifront 

Iniciar 
vue ui
root /opt/lampp/manager-linux-x64.run

Directorio de despliegues
/opt/lampp/htdocs/rm

Node 
referencia : https://phoenixnap.com/kb/update-node-js-version
Update Node.js with NVM (Node Version Manager)
The best way to upgrade Node.js is with NVM, a practical tool for managing multiple Node.js versions.

1. Start by updating the package repository with the command:

sudo apt update

2. Install NVM using the curl command:

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash

--------- Note: If you don't have curl, install the utility by running the command: sudo apt install curl.

--------- Alternatively, you use wget and run the command:

---------  wget -q0- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash

3. Close and reopen the terminal for system to recognize the changes or run the command:

source ~/.bashrc

5. Then, verify if you have successfully installed NVM:

nvm --version


6. Before upgrading Node.js, check which version you have running on the system:

nvm ls

7. Now you can check for newly available releases with:

nvm ls-remote

see a list of all available Node.js versions
8. To install the latest version, use the nvm command with the specific Node.js version:

nvm install [version.number]

nvm install v18.12.1