DROP company IF EXISTS

CREATE TABLE company (

    company_id	BIGINT  IDENTITY NOT NULL PRIMARY KEY,
    company_name	 VARCHAR(50) NOT NULL ,
    province	VARCHAR(20),
    establish_date DATE ,
    company_type	VARCHAR (100),
    company_address	VARCHAR (100),
    legalPerson VARCHAR(20)
);