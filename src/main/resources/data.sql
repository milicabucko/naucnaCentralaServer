insert into korisnik(id, banka, bitcoin, email, ime, lozinka, paypal, prezime, token, uloga) values (1, TRUE, TRUE, "a@a.com", "a", "$2a$10$F5caNI8Y736RdRH83wpVwOJYiVjMsEyx2qOs0dNbhZy53hPOc8d9q", TRUE, "a", "Token a", "AUTOR");
insert into korisnik(id, banka, bitcoin, email, ime, lozinka, paypal, prezime, token, uloga) values (2, TRUE, TRUE, "c@c.com", "c", "$2a$10$9XUSDiWxDJ3apftSye33ROmFk8cTrLDOj9k91nTXNj21U5lyyT.UG", TRUE, "c", "Token c", "CITALAC");


insert into magazin(id, naziv, open_access) values (1, "Nacionalna Geografija", FALSE);
insert into magazin(id, naziv, open_access) values (2, "Nacionalna Geografija open access", TRUE);

insert into cenovnik_clanarine(id, broj_meseci, cena, magazin_id) values (1, 3, 3, 1);


INSERT INTO `magazin` (`id`,`naziv`,`open_access`,`slika`) VALUES (1,'Blic zena',1,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0CTQ8Qj1VPj-6YIIsKGVN00TjC2WNITPDi7PxH_7-vT2eKw9kAQ');
INSERT INTO `magazin` (`id`,`naziv`,`open_access`,`slika`) VALUES (2,'Blic',0,'https://i.pinimg.com/originals/70/d1/cb/70d1cb9b1a5f8448491f639cbe0041d9.jpg');
INSERT INTO `magazin` (`id`,`naziv`,`open_access`,`slika`) VALUES (3,'Discover',1,'http://discovermagazine.com/~/media/Images/Issue%20Covers/2017/DSC-CV0517web.jpg');

INSERT INTO `izdanje_magazina` (`id`,`besplatan`,`cena`,`magazin_id`,`mesec`) VALUES (1,1,0,1,'Januar');
INSERT INTO `izdanje_magazina` (`id`,`besplatan`,`cena`,`magazin_id`,`mesec`) VALUES (2,0,200,1,'Februar');
INSERT INTO `izdanje_magazina` (`id`,`besplatan`,`cena`,`magazin_id`,`mesec`) VALUES (3,0,200,1,'Mart');
INSERT INTO `izdanje_magazina` (`id`,`besplatan`,`cena`,`magazin_id`,`mesec`) VALUES (4,0,450,2,'Januar');

-- mozda ne??
INSERT INTO `clanarina` (`id`,`cena`,`datum_pocetka`,`datum_zavrsetka`,`korisnik_id`,`magazin_id`,`broj_meseci`) VALUES (1,2,'20180505','20190605',1,1,NULL);


INSERT INTO `naucni_rad` (`id`,`besplatan`,`cena`,`izdanje_magazina_id`,`kljucni_pojmovi`,`koautori`,`link`,`magazin_id`,`naucna_oblast`,`prihvacen`) VALUES (1,0,100,4,'a','a',NULL,1,'a',1);
INSERT INTO `naucni_rad` (`id`,`besplatan`,`cena`,`izdanje_magazina_id`,`kljucni_pojmovi`,`koautori`,`link`,`magazin_id`,`naucna_oblast`,`prihvacen`) VALUES (2,0,100,4,'l','l',NULL,1,'a',0);

