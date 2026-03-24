-- Empresa 1: Prefeitura de Araçoiaba da Serra (Dados Reais)
INSERT INTO company (id, external_id, registration_number, country_code, corporate_name, trade_name, status, foundation_date, legal_type, nature, description,
    currency, frequency, payment_method, time_zone, work_week_def, union_name, vacation_policy, advance_policy,
    bank_name, agency, account, account_type, swift_code,
    regime, tax_id,
    logo_type, url, active
) VALUES (
    1, 'COMPANY-BR-001', '46634044000174', 'BR', 'MUNICIPIO DE ARACOIABA DA SERRA', 'Prefeitura de Araçoiaba da Serra', 'ACTIVE', '1970-01-01', 'PUBLIC_SECTOR', 'Administration', 'Prefeitura Municipal',
    'BRL', 'MONTHLY', 'CREDIT', 'America/Sao_Paulo', '40H', 'SINDSERV', 'STANDARD', 'NONE',
    'Banco do Brasil', '1111', '22222', 'CHECKING', 'BRASBRRJ',
    'ISENTO', '46634044000174',
    'PUBLIC', 'http://aracoiaba.sp.gov.br/logo.png', true
);

INSERT INTO address (company_id, street, street_number, neighborhood, city, state, zip_code, country, type_Address)
VALUES (1, 'Av. Luiza Matilde de Oliveira', '1500', 'Centro', 'Araçoiaba da Serra', 'SP', '18190-000', 'BR', 'HEADQUARTERS');

INSERT INTO contact (company_id, name, role, email, phone, department)
VALUES (1, 'João Silva', 'Secretário', 'sec.adm@aracoiaba.sp.gov.br', '1532817000', 'ADMIN');

INSERT INTO company_activities (company_id, activity) VALUES (1, 'Administração Pública em Geral');
INSERT INTO company_tags (company_id, tag) VALUES (1, 'PUBLIC_SECTOR'), (1, 'MUNICIPALITY');


-- Empresa 2: Prefeitura de Capela do Alto (Dados Reais)
INSERT INTO company (id, external_id, registration_number, country_code, corporate_name, trade_name, status, foundation_date, legal_type, nature, description,
    currency, frequency, payment_method, time_zone, work_week_def, union_name, vacation_policy, advance_policy,
    bank_name, agency, account, account_type, swift_code,
    regime, tax_id,
    logo_type, url, active
) VALUES (
    2, 'COMPANY-BR-002', '46634077000114', 'BR', 'MUNICIPIO DE CAPELA DO ALTO', 'Prefeitura de Capela do Alto', 'ACTIVE', '1970-01-01', 'PUBLIC_SECTOR', 'Administration', 'Prefeitura Municipal',
    'BRL', 'MONTHLY', 'CREDIT', 'America/Sao_Paulo', '40H', 'SINDSERV', 'STANDARD', 'NONE',
    'Caixa Economica', '3333', '44444', 'CHECKING', 'CEFXBRSP',
    'ISENTO', '46634077000114',
    'PUBLIC', 'http://capeladoalto.sp.gov.br/logo.png', true
);

INSERT INTO address (company_id, street, street_number, neighborhood, city, state, zip_code, country, type_Address)
VALUES (2, 'Praça São Francisco', '26', 'Centro', 'Capela do Alto', 'SP', '18195-000', 'BR', 'HEADQUARTERS');

INSERT INTO contact (company_id, name, role, email, phone, department)
VALUES (2, 'Maria Oliveira', 'Diretora RH', 'rh@capeladoalto.sp.gov.br', '1532678000', 'HR');

INSERT INTO company_activities (company_id, activity) VALUES (2, 'Administração Pública em Geral');
INSERT INTO company_tags (company_id, tag) VALUES (2, 'PUBLIC_SECTOR'), (2, 'MUNICIPALITY');


-- Empresa 3: NKY-solucoes (Dados Fictícios em SC)
INSERT INTO company (id, external_id, registration_number, country_code, corporate_name, trade_name, status, foundation_date, legal_type, nature, description,
    currency, frequency, payment_method, time_zone, work_week_def, union_name, vacation_policy, advance_policy,
    bank_name, agency, account, account_type, swift_code,
    regime, tax_id, state_tax_id, municipal_tax_id,
    logo_type, url, active
) VALUES (
    3, 'COMPANY-BR-003', '12345678000199', 'BR', 'NKY Solucoes Tecnologicas Ltda', 'NKY-solucoes', 'ACTIVE', '2020-05-15', 'PRIVATE_LIMITED', 'Technology', 'Consultoria e Desenvolvimento de Software',
    'BRL', 'MONTHLY', 'PIX', 'America/Sao_Paulo', '44H', 'SINDPD-SC', 'FLEXIBLE', 'OPTIONAL',
    'Banco Inter', '0001', '998877', 'CHECKING', 'ISPB077',
    'SIMPLES_NACIONAL', '12345678000199', '258456123', '556688',
    'PRIVATE', 'https://nky.solucoes.example/logo.svg', true
);

INSERT INTO address (company_id, street, street_number, neighborhood, city, state, zip_code, country, type_Address)
VALUES (3, 'Rua das Gaivotas', '100', 'Palmas', 'Governador Celso Ramos', 'SC', '88190-000', 'BR', 'HEADQUARTERS');

INSERT INTO address (company_id, street, street_number, neighborhood, city, state, zip_code, country, type_Address)
VALUES (3, 'Av. Beira Mar', '500', 'Centro', 'Florianópolis', 'SC', '88015-000', 'BR', 'BRANCH');

INSERT INTO contact (company_id, name, role, email, phone, department)
VALUES (3, 'Carlos NKY', 'CTO', 'carlos@nky.example', '48999998888', 'TECH');

INSERT INTO company_activities (company_id, activity) VALUES (3, 'Desenvolvimento de Software'), (3, 'Suporte Técnico');
INSERT INTO company_tags (company_id, tag) VALUES (3, 'TECH'), (3, 'STARTUP'), (3, 'REMOTE_FIRST');
INSERT INTO company_metadata (company_id, meta_value) VALUES (3, 'TECH_STACK:JAVA'), (3, 'CLOUD:AWS');