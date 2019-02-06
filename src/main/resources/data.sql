insert into korisnik(id, banka, bitcoin, email, ime, lozinka, paypal, prezime, token, uloga) values (1, TRUE, TRUE, "a@a.com", "a", "$2a$10$F5caNI8Y736RdRH83wpVwOJYiVjMsEyx2qOs0dNbhZy53hPOc8d9q", TRUE, "a", "Token a", "AUTOR");
insert into korisnik(id, banka, bitcoin, email, ime, lozinka, paypal, prezime, token, uloga) values (2, TRUE, TRUE, "c@c.com", "c", "$2a$10$9XUSDiWxDJ3apftSye33ROmFk8cTrLDOj9k91nTXNj21U5lyyT.UG", TRUE, "c", "Token c", "CITALAC");

insert into magazin(id, naziv, open_access) values (1, "Nacionalna Geografija", FALSE);
insert into magazin(id, naziv, open_access) values (2, "Nacionalna Geografija open access", TRUE);

insert into cenovnik_clanarine(id, broj_meseci, cena, magazin_id) values (1, 3, 3, 1);

