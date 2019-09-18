create table USER
(
    ID           INTEGER default (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_39AD8D41_D987_48D9_89AC_E70F6885548B) auto_increment,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    BIO          VARCHAR(256),
    constraint USER_PK
        primary key (ID)
);

