-- =========================================================
-- DB
-- =========================================================
-- Factory → creazione USER / ADMIN
-- Singleton → connessione DB
-- Decorator → modifica dinamica prezzi e prodotti
-- Observer → notifiche su ordini / spedizioni / abbonamenti
--
-- STRUTTURA LOGICA:
-- accounts → autenticazione e ruoli
-- products → catalogo
-- cart → carrello temporaneo
-- orders → ordini effettuati
-- order_items → dettagli ordine
-- shipments → spedizioni
-- notifications → sistema Observer
-- subscriptions → abbonamento PRO
-- =========================================================



-- =========================================================
-- ACCOUNTS
-- =========================================================
-- RELAZIONI:
-- 1 ACCOUNT → N ORDERS
-- 1 ACCOUNT → N CART
-- 1 ACCOUNT → N NOTIFICATIONS
-- 1 ACCOUNT → 1 SUBSCRIPTION
--
-- DESIGN PATTERN:
-- Factory → crea USER od ADMIN
-- =========================================================
CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,

    -- username
    username VARCHAR(100) NOT NULL,

    -- email unica
    email VARCHAR(150) NOT NULL UNIQUE,

    -- password (da cifrare in Java)
    password VARCHAR(255) NOT NULL,

    -- ruolo per autorizzazione (USER / ADMIN, di default USER)
    role ENUM('USER', 'ADMIN') NOT NULL DEFAULT 'USER',

    -- data registrazione utente
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- =========================================================
-- PRODUCTS
-- =========================================================
-- RELAZIONI:
-- 1 PRODUCT → N CART
-- 1 PRODUCT → N ORDER_ITEMS
--
-- DESIGN PATTERN:
-- Decorator → modifica prezzo dinamico (PRO, sconti, tasse)
-- =========================================================
CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,

    -- nome prodotto
    name VARCHAR(150) NOT NULL,

    -- descrizione dettagliata
    description TEXT,

    -- prezzo base (usato dal Decorator in Java)
    price DECIMAL(6,2) NOT NULL,

    -- categoria (per filtri prodotti)
    -- TODO → normalizzare in tabella CATEGORIES
    category VARCHAR(100),

    -- quantità disponibile
    stock INT DEFAULT 0,

    -- data creazione prodotto
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



-- =========================================================
-- CART
-- =========================================================
-- Carrello temporaneo
--
-- RELAZIONI:
-- 1 CART → 1 ACCOUNT
-- M CART → 1 PRODUCT
--
-- VINCOLI:
-- UNIQUE(account_id, product_id) evita duplicati nel carrello
-- =========================================================
CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,

    account_id INT UNIQUE,  

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);



-- =========================================================
-- ORDERS
-- =========================================================
-- RELAZIONI:
-- 1 ACCOUNT → N ORDERS
-- 1 ORDER → N ORDER_ITEMS
-- 1 ORDER → 1 SHIPMENT
--
-- DESIGN PATTERN:
-- Observer → cambia stato ordine
-- =========================================================
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,

    -- utente che ha creato l'ordine
    account_id INT,

    -- totale finale (calcolato in Java con Decorator)
    total DECIMAL(10,2),

    -- stato ordine (Observer attivo su questo campo)
    status ENUM('PENDING', 'PAID', 'SHIPPED', 'DELIVERED', 'CANCELLED')
        DEFAULT 'PENDING',

    -- data creazione ordine
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);

-- ========================================================
-- CART_PRODUCTS
-- =========================================================
-- Dettagli dei prodotti dentro un carrello.
-- Tabella ponte CART ←→ PRODUCTS

-- RELAZIONI:
-- M CART → 1 PRODUCT
-- ==========================================================
CREATE TABLE cart_products (
    id INT AUTO_INCREMENT PRIMARY KEY,

    cart_id INT,
    product_id INT,

    quantity INT NOT NULL DEFAULT 1,

    FOREIGN KEY (cart_id) REFERENCES cart(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,

    -- evita duplicati stesso prodotto nel carrello
    UNIQUE(cart_id, product_id)
);

-- =========================================================
-- ORDER_PRODUCTS
-- =========================================================
-- Dettagli dei prodotti dentro un ordine.
-- Tabella ponte ORDERS ←→ PRODUCTS
--
-- RELAZIONI:
-- M ORDER_ITEMS → 1 ORDER
-- M ORDER_ITEMS → 1 PRODUCT
-- =========================================================
CREATE TABLE order_products (
    id INT AUTO_INCREMENT PRIMARY KEY,

    order_id INT,
    product_id INT,

    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL, -- prezzo al momento dell'acquisto

    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);



-- =========================================================
-- SHIPMENTS
-- =========================================================
-- RELAZIONI:
-- 1 ORDER → 1 SHIPMENT
--
-- DESIGN PATTERN:
-- Observer → notifica cambio stato spedizione
-- =========================================================
CREATE TABLE shipments (
    id INT AUTO_INCREMENT PRIMARY KEY,

    order_id INT,

    tracking_code VARCHAR(100),
    carrier VARCHAR(100),

    status ENUM('PREPARING', 'SHIPPED', 'IN_TRANSIT', 'DELIVERED')
        DEFAULT 'PREPARING',

    shipped_at TIMESTAMP NULL,

    FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);



-- =========================================================
-- NOTIFICATIONS
-- =========================================================
-- Sistema notifiche (Observer Pattern).
-- Utilizzato per:
-- aggiornamenti ordini
-- spedizioni
-- scadenza abbonamenti PRO
-- =========================================================
CREATE TABLE notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,

    account_id INT,

    message TEXT,

    is_read BOOLEAN DEFAULT FALSE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);



-- =========================================================
-- SUBSCRIPTIONS
-- =========================================================
-- RELAZIONI:
-- 1 ACCOUNT → 1 SUBSCRIPTION
--
-- DESIGN PATTERN:
-- Decorator → sconti PRO sui prezzi
-- TODO: Oltre agli sconti aggiungere spedizione prioritaria
-- Observer → scadenza abbonamento
-- =========================================================
CREATE TABLE subscriptions (
    id INT AUTO_INCREMENT PRIMARY KEY,

    account_id INT UNIQUE,

    type ENUM('DEFAULT', 'PRO') DEFAULT 'DEFAULT',

    start_date DATE,
    end_date DATE,

    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);