CREATE TABLE ROLES (
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  ROLE_NAME VARCHAR(15) NOT NULL
);

CREATE TABLE USER_TO_ROLE (
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  FK_USER_ID BIGINT NOT NULL,
  FK_ROLE_ID BIGINT NOT NULL,
    CONSTRAINT FK_UTR_TO_USERS FOREIGN KEY (FK_USER_ID)
            REFERENCES USERS(ID),
    CONSTRAINT FK_UTR_TO_ROLES FOREIGN KEY (FK_ROLE_ID)
            REFERENCES ROLES(ID)
);

CREATE TABLE CARTS (
  ID BIGINT PRIMARY KEY,
  CONSTRAINT FK_UTR_USERS FOREIGN KEY (ID)
      REFERENCES USERS(ID),
);

CREATE TABLE PRODUCT_TO_CART (
  ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  FK_PRODUCT_ID BIGINT NOT NULL,
  FK_CART_ID BIGINT NOT NULL,
  CONSTRAINT FK_UTR_TO_PRODUCTS FOREIGN KEY (FK_PRODUCT_ID)
      REFERENCES PRODUCTS(ID),
  CONSTRAINT FK_UTR_TO_CARTS FOREIGN KEY (FK_CART_ID)
      REFERENCES CARTS(ID)
);