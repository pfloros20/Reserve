INSERT INTO `ADMIN` VALUES
(null,'george52','12345'),
(null,'pfloros','54321'),
(null,'teogrx','kodikos'),
(null,'panosxatz','kodikos'),
(null,'chrikyriak','@13d32');

INSERT INTO `OWNER` VALUES
(null,'bas41','12345a'),
(null,'dimitraSa','asdasd'),
(null,'kakadim','asd1234'),
(null,'owner1','ffds1');

INSERT INTO `USER` VALUES
(null,'basilis','asdasd',10.5,10.5),
(null,'JIMMYS','1234',8.0,10.5),
(null,'aliki','asd123',5.0,10.5),
(null,'marina','asd',10.5,6.0),
(null,'Aristidis','ll21',7.0,3.0);

INSERT INTO `STORE`(ID, STORE_NAME, OWNER_ID, CAPACITY, CURRENT_AVAILABILITY, DESCRIPTION, VISIBLE, TYPE) VALUES
(null,'STORE0',1,42,10,'This is the best store in Patras',TRUE,'RESTAURANT'),
(null,'STORE1',2,70,30,'This is the greatest store in Patras',TRUE,'RESTAURANT'),
(null,'STORE2',3,55,24,'This is the most popular store in Patras',TRUE,'COFFEE SHOP'),
(null,'STORE3',4,50,30,'This is one of the best stores in Patras',TRUE,'PIZZA SHOP'),
(null,'STORE4',4,50,30,'This is one of the great stores in Patras',TRUE,'RESTAURANT');

INSERT INTO `STORE`(ID, STORE_NAME, OWNER_ID, CAPACITY, CURRENT_AVAILABILITY, DESCRIPTION, TYPE) VALUES
(null,'STORE5',1,20,8,'This is the second best store in Patras','RESTAURANT');

INSERT INTO `TABLE` VALUES
(null,1,4,'FREE'),
(null,1,4,'TAKEN'),
(null,1,8,'BOOKED'),
(null,1,4,'BOOKED'),
(null,1,4,'FREE'),
(null,1,4,'BOOKED'),
(null,1,4,'TAKEN'),
(null,1,8,'TAKEN'),
(null,1,2,'FREE'),
(null,2,4,'TAKEN'),
(null,2,4,'FREE'),
(null,2,4,'FREE'),
(null,2,4,'BOOKED'),
(null,2,4,'TAKEN'),
(null,3,5,'FREE'),
(null,3,5,'FREE'),
(null,3,5,'TAKEN'),
(null,3,5,'FREE'),
(null,3,5,'FREE'),
(null,3,5,'TAKEN'),
(null,3,10,'BOOKED'),
(null,3,5,'FREE'),
(null,3,5,'FREE'),
(null,3,10,'BOOKED'),
(null,3,8,'TAKEN'),
(null,3,2,'BOOKED'),
(null,4,2,'FREE'),
(null,4,2,'FREE'),
(null,4,4,'TAKEN'),
(null,4,2,'BOOKED'),
(null,4,5,'BOOKED'),
(null,4,5,'TAKEN'),
(null,4,5,'FREE'),
(null,4,5,'FREE'),
(null,4,5,'TAKEN'),
(null,4,5,'TAKEN'),
(null,4,10,'FREE'),
(null,4,5,'TAKEN'),
(null,5,6,'FREE'),
(null,5,6,'FREE'),
(null,5,6,'FREE'),
(null,5,6,'FREE'),
(null,5,6,'FREE'),
(null,5,10,'BOOKED'),
(null,5,2,'TAKEN'),
(null,5,2,'TAKEN'),
(null,5,2,'BOOKED'),
(null,5,2,'BOOKED'),
(null,5,2,'TAKEN');

INSERT INTO `RESERVATION` VALUES
(null,1,3,'ACCEPTED'),
(null,2,1,'ACCEPTED'),
(null,3,3,'DENIED'),
(null,4,4,'ACCEPTED'),
(null,5,5,'ACCEPTED'),
(null,1,4,'DENIED');

INSERT INTO `RES_TABLES` VALUES
(null,1,17),
(null,2,2),
(null,3,17),
(null,4,30),
(null,5,45),
(null,6,30);

INSERT INTO `VISITED` VALUES
(null,1,1),
(null,3,1),
(null,3,2),
(null,3,3),
(null,4,4),
(null,3,5);

INSERT INTO `EVENT` VALUES
(null,'EVENT0',1,'2019-5-10','2019-5-16','2nd anniversary'),
(null,'EVENT1',3,'2019-7-1','2019-7-7','5th anniversary'),
(null,'EVENT2',4,'2019-1-1','2019-1-2','3rd anniversary'),
(null,'EVENT3',5,'2019-5-13','2019-5-13','mother birthday'),
(null,'EVENT4',4,'2019-1-1','2019-1-2','35th anniversary');

INSERT INTO `REVIEW` VALUES
(null,1,1,4,''),
(null,2,1,5,'great store'),
(null,3,5,1,'the worst store ever'),
(null,4,1,4,'nice store'),
(null,1,5,1,'rly bad shit');

INSERT INTO `REPORT` VALUES
(null,2,1,5,'he should not speak like that','HATE_SPEECH'),
(null,2,3,3,'lies','OTHER');


