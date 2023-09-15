-- Tabela de itens da loja do RPG
CREATE TABLE public.loja (
    id integer DEFAULT nextval('public."id-item"'::regclass) NOT NULL,
    nome text,
    efeito text,
    preco float
);

-- Definindo a chave primária
ALTER TABLE public.item ADD CONSTRAINT item_pkey PRIMARY KEY (id);

-- Cria uma sequência que cria as chaves de ID
CREATE SEQUENCE public."id-item"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1;

-- Define a coluna 'id' para usar a sequência
ALTER TABLE public.item ALTER COLUMN id SET DEFAULT nextval('public."id-item"'::regclass);
