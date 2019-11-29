
CREATE TABLE IF NOT EXISTS Client(id INTEGER PRIMARY KEY AUTO_INCREMENT,cpf VARCHAR(11),name VARCHAR(50),active BOOLEAN,address VARCHAR(50),email VARCHAR(20),age INTEGER ,mothername VARCHAR(50),fathername VARCHAR(50));
DELETE FROM Client;
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('21040572057' ,'Victor Halmenschlager' , 1 , 'Orfanatrofio','c87974207215618543814@sandbox.pagseguro.com.br',27,'Mari Jane Halmenschlager','Osmar Halmenschlager');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('01821468040' ,'Bruno Silva' , 0 , 'China Stret','teste@gmail.com',30,'Joana Silva','Osvaldo Silva');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('01821469077' ,'Joana Dark' , 1 , 'Sertorio','teste2@sandbox.pagseguro.com.br',22,'Mari Dark','Osmar Dark');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('21040572057' ,'Antonia Silveira' , 0 , 'Farrapos','teste3@outlook.com',41,'Joana Silveira','Osvaldo Silveira');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('01821469077' ,'Marina Castro' , 1 , 'Teresopolis','pagme@sandbox.pagseguro.com.br',20,'Jane Castro','Augusto Castro');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('21040572057' ,'Bruno Moura' , 0 , 'Assis Brasil','testando@uol.com',18,'Joana Moura','Silvio Moura');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('01821469077' ,'Matheus Frantz' , 1 , 'Carlos Barbosa','fazsuafe@sandbox.pagseguro.com.br',35,'Joana Frantz','Rubens Frantz');
INSERT INTO Client (cpf,name,active,address,email,age,mothername,fathername) VALUES('69011548755' ,'João Santon' , 0 , 'Cavalhada','vamoformar@gmail.com',38,'Joana Santon','Osvaldo Santon');

