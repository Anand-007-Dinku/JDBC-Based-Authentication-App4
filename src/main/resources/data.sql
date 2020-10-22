--Plain Text Password
--INSERT INTO USER (USERNAME, PASSWORD) VALUES ('Anand','Anand1');
--INSERT INTO USER (USERNAME, PASSWORD) VALUES ('Santosh','Santosh1');

--Hashed Passwords using Bcrypt algorithm
INSERT INTO USER (USERNAME, PASSWORD) VALUES ('Anand','$2a$11$9yAU.he8Tjh0Tw9xNOb9duopTbwsWCmRom7SeJKGm7ycZwYSC4fmu');
INSERT INTO USER (USERNAME, PASSWORD) VALUES ('Santosh','$2a$11$f2qQZ4qiyLfKharongNa7e1NcMSKVa4WKdo4yi9Gbge9saCTbdXbG');


