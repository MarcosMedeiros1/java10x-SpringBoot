-- V2: Migrations para adicionar coluna de LEVEL na tabela de Hobbits

ALTER TABLE TB_HOBBITS
ADD COLUMN level VARCHAR(255);
