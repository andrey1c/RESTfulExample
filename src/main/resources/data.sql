DELETE FROM UserTransaction ;
DELETE FROM Account ;
DELETE FROM User ;
INSERT INTO User (id, name) VALUES (1, 'andrey');
INSERT INTO User (id, name) VALUES (2, 'jimm');
INSERT INTO Account (id, accountNumber, user_id) VALUES (1,  'sswswswsw', 1,);
INSERT INTO Account (id, accountNumber, user_id) VALUES (2,  'sswswswsw', 2,);
INSERT INTO UserTransaction (id, user_id,account_id,amount) VALUES (1, 1, 1, 55);
INSERT INTO UserTransaction (id, user_id,account_id,amount) VALUES (2, 1, 1, -5);
