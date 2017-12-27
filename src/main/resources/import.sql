insert into ACTEUR (PRENOM,NOM) values ('Johnny','Depp');
insert into ACTEUR (PRENOM,NOM) values ('Kevin','Spacey');
insert into ACTEUR (PRENOM,NOM) values ('Leonardo', 'Dicaprio' );

insert into FILM (NOM) values ('Pirates des caraibes 2');
insert into FILM (NOM) values ('Transcendance');
insert into FILM (NOM) values ('Ed Wood' );

insert into ACTEUR_FILM values (1,1 );
insert into ACTEUR_FILM values (1,2 );
insert into ACTEUR_FILM values (1,3 );


insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (1,'~/JDE/pirates2a.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (1,'~/JDE/pirates2b.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (2,'~/JDE/transcendancea.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (2,'~/JDE/transcendanceb.mp4',1)

insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (3,'~/JDE/edwooda.mp4',1)
insert into EXTRAITFILM (FILM_ID,LOCATION,ACTEUR_ID) values (3,'~/JDE/edwoodb.mp4',1)

