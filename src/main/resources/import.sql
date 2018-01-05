insert into ACTEUR (PRENOM,NOM,LOCATIONINTRO) values ('Johnny','Depp','~/Video/introJDE.mp4');
insert into ACTEUR (PRENOM,NOM,LOCATIONINTRO) values ('Leonardo', 'Dicaprio','~/Video/introLDE.mp4' );
--insert into ACTEUR (PRENOM,NOM,LOCATIONINTRO) values ('Kevin','Spacey','~/Video/JDE/dark1.mp4');


insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Las Vegas Parano','~/Video/vegas.mp4','~/Video/vegas.png');
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Dark Shadows','~/Video/dark.mp4','~/Video/dark.png');
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Les Griffes de la Nuit 1984','~/Video/freddy.mp4','~/Video/freddy.png' );
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Fenetre secrete','~/Video/fenetre.mp4','~/Video/fenetre.png' );

insert into ACTEUR_FILM values (1, 1);
insert into ACTEUR_FILM values (1, 2);
insert into ACTEUR_FILM values (1, 3);
insert into ACTEUR_FILM values (1, 4);

insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Les infiltres','~/Video/infil.mp4','~/Video/infil.png');
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('J Edgar','~/Video/edgar.mp4','~/Video/edgar.png');
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Django','~/Video/django.mp4','~/Video/django.png' );
insert into FILM (NOM,LOCATIONANSWER,LOCATIONIMAGE) values ('Le loup de wall street','~/Video/loup.mp4','~/Video/loup.png' );

insert into ACTEUR_FILM values (2, 5);
insert into ACTEUR_FILM values (2, 6);
insert into ACTEUR_FILM values (2, 7);
insert into ACTEUR_FILM values (2, 8);

--insert into FILM (NOM,LOCATIONANSWER) values ('Usual Suspect','~/Video/JDE/dark1.mp4');
--insert into FILM (NOM,LOCATIONANSWER) values ('Margin Call','~/Video/JDE/dark1.mp4');
--insert into FILM (NOM,LOCATIONANSWER) values ('Elvis et Nixon','~/Video/JDE/dark1.mp4' );
--insert into FILM (NOM,LOCATIONANSWER) values ('American Beauty','~/Video/JDE/dark1.mp4' );
--
--insert into ACTEUR_FILM values (3, 9);
--insert into ACTEUR_FILM values (3, 10);
--insert into ACTEUR_FILM values (3, 11);
--insert into ACTEUR_FILM values (3, 12);


insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (1,'~/Video/JDE/vegas1.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (1,'~/Video/JDE/vegas2.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (2,'~/Video/JDE/dark1.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (2,'~/Video/JDE/dark2.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (3,'~/Video/JDE/freddy1.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (3,'~/Video/JDE/freddy2.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (4,'~/Video/JDE/fenetre1.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (4,'~/Video/JDE/fenetre2.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (5,'~/Video/LDI/infil1.mp4',2)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (5,'~/Video/LDI/infil2.mp4',2)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (6,'~/Video/LDI/edgar1.mp4',2)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (6,'~/Video/LDI/edgar2.mp4',2)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (7,'~/Video/LDI/django1.mp4',2)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (7,'~/Video/LDI/django2.mp4',2)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (8,'~/Video/LDI/loup1.mp4',2)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (8,'~/Video/LDI/loup2.mp4',2)

--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (9,'~/Documents/IDM/exemple1.mp4',3)
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (9,'~/Documents/IDM/exemple1.mp4',3)
--
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (10,'~/Documents/IDM/exemple1.mp4',3)
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (10,'~/Documents/IDM/exemple1.mp4',3)
--
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (11,'~/Documents/IDM/exemple1.mp4',3)
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (11,'~/Documents/IDM/exemple1.mp4',3)
--
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (12,'~/Documents/IDM/exemple1.mp4',3)
--insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (12,'~/Documents/IDM/exemple1.mp4',3)
--
