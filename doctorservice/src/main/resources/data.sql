INSERT INTO DOCTOR VALUES(null, 'Alex', 'Mocanu');
INSERT INTO DOCTOR VALUES(null, 'Claudiu', 'Teohari');
INSERT INTO DOCTOR VALUES(null, 'Costel', 'Bojog');

INSERT INTO patient VALUES(null, 'Vio','Dragu', '1981128270821');
INSERT INTO patient VALUES(null, 'Raul', 'Gheba', '1941128270866');

INSERT INTO consult VALUES (null, '', SYSDATE() - 4, 'durere in suflet', 'durere in gat', 1, 1);
INSERT INTO consult VALUES (null, '', SYSDATE() - 2, '-', 'durere in gat, somnolenta', 2, 1);
INSERT INTO consult VALUES (null, '', SYSDATE(), '-', 's-a extins durerea in cot', 1, 1);

INSERT INTO medication VALUES (null, 'Ibuprofen', 300);
INSERT INTO medication VALUES (null, 'Ibuprofen', 800);
INSERT INTO medication VALUES (null, 'Paracetamol', 400);
INSERT INTO medication VALUES (null, 'Decasept', 50);
INSERT INTO medication VALUES (null, 'Colebil', 2);
