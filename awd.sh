docker run
--name mysql
-p 3306:3306
-v /var/lib/mysql:/var/lib/mysql
-e MYSQL_DATABASE=somedb
-e MYSQL_USER=someuser
-e MYSQL_PASSWORD=somepass
yobasystems/alpine-mariadb