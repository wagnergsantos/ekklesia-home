insert into cargo (id,descricao) values (1, 'Diácono');
insert into cargo (id,descricao) values (2, 'Evangelista');
insert into cargo (id,descricao) values (3, 'Missionário');
insert into cargo (id,descricao) values (4, 'Pastor');


insert into escolaridade (id,descricao) values (1, 'Ensino Fundamental');
insert into escolaridade (id,descricao) values (2, 'Ensino Médio');
insert into escolaridade (id,descricao) values (3, 'Ensino Superior');
insert into escolaridade (id,descricao) values (4, 'Especialização');
insert into escolaridade (id,descricao) values (5, 'Mestrado');
insert into escolaridade (id,descricao) values (6, 'Doutorado');

insert into estado_civil (id,descricao) values (1, 'Casado');
insert into estado_civil (id,descricao) values (2, 'Divorciado');
insert into estado_civil (id,descricao) values (3, 'Solteiro');
insert into estado_civil (id,descricao) values (4, 'Viúvo');


insert into situacao_membro (id,descricao) values (1, 'Ativo');
insert into situacao_membro (id,descricao) values (2, 'Afastado');
insert into situacao_membro (id,descricao) values (3, 'Transferido');



insert into estados (sigla,nome) values ('AC','Acre');  
insert into estados (sigla,nome) values ('AL','Alagoas');  
insert into estados (sigla,nome) values ('AM','Amazonas');
insert into estados (sigla,nome) values ('AP','Amapá');
insert into estados (sigla,nome) values ('BA','Bahia');
insert into estados (sigla,nome) values ('CE','Ceará');
insert into estados (sigla,nome) values ('DF','Distrito Federal');
insert into estados (sigla,nome) values ('ES','Espírito Santo');
insert into estados (sigla,nome) values ('GO','Goiás');
insert into estados (sigla,nome) values ('MA','Maranhão');
insert into estados (sigla,nome) values ('MG','Minas Gerais');
insert into estados (sigla,nome) values ('MS','Mato Grosso do Sul');
insert into estados (sigla,nome) values ('MT','Mato Grosso');
insert into estados (sigla,nome) values ('PA','Pará');
insert into estados (sigla,nome) values ('PB','Paraíba');
insert into estados (sigla,nome) values ('PE','Pernambuco');
insert into estados (sigla,nome) values ('PI','Piauí');
insert into estados (sigla,nome) values ('PR','Paraná');
insert into estados (sigla,nome) values ('RJ','Rio de Janeiro');
insert into estados (sigla,nome) values ('RN','Rio Grande do Norte');
insert into estados (sigla,nome) values ('RO','Rondônia');
insert into estados (sigla,nome) values ('RR','Roraima');
insert into estados (sigla,nome) values ('RS','Rio Grande do Sul');
insert into estados (sigla,nome) values ('SC','Santa Catarina');
insert into estados (sigla,nome) values ('SE','Sergipe');
insert into estados (sigla,nome) values ('SP','São Paulo');
insert into estados (sigla,nome) values ('TO','Tocantins');


insert into usuario (id,username,password,enabled) values (1,'user','$2a$10$Fi2B/1itKSBWoLnc/esxsOTceDS2.OvSolTSXpGQqxyYtilV2oFkK', true);
insert into usuario (id,username,password,enabled) values (2,'admin','$2a$10$C1QWybugQe/561eNDbkix.tzz5WcO6pDqBo9sW9W.FxfEtazVo/la', true);

insert into regra (id,nome) values (1, 'ROLE_USER');
insert into regra (id,nome) values (2, 'ROLE_ADMIN');

insert into usuarios_regras (usuario_id, regra_id) values (1, 1);
insert into usuarios_regras (usuario_id, regra_id) values (2, 1);
insert into usuarios_regras (usuario_id, regra_id) values (2, 2);