insert into Empresa (cnpj, razaoSocial)  values ('0000000000', 'testeEmpresa');
SET @last_id_in_table1 = LAST_INSERT_ID();
insert into Usuario (cpf, login, nome, senha, idEmpresa)
values ('0000000000', 'usu1', 'usuNome', 'usuSenha', @last_id_in_table1);