# Readme

# Names: 
Connor O’Brien, Bryan Nguyen, Jacob Andersen, Zhi He, Alexis Ramirez, Mario Vuletic

# Steps to spin up database

## Step 1
Download Docker

## Step 2
In `./devdb` Run the following

```console
docker exec -it 366_mariadb /bin/bash
```

Then run
```console
docker-compose up
```

Then run:
```console
mariadb -u root -p
```
Then give the password: `passw0rd`

## Step 3: Create database in docker
In the console run:
```console
create database teamdatabase
```
Exit two times:
```
exit
exit
```

## Step 5: Run Java Application
In IntelliJ, click the green arrow in the top right next to the application's name

## Finally: You have created the database CONGRATS!

## Additional Steps to connect and check your database in MariaDB:
Connect using localhost 
```agsl
Username: root
Password: passw0rd
```