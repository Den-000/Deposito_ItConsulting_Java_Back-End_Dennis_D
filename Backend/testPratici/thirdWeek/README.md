## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## Commenti
Lo Scope è:
- Creare una homapge di login/register

- A seconda di chi effettua il  login adattare view e controller

- Mostrare il Menu Principale

- Per Utenti:
    - Apri catalogo → Visualizza tutti i prodotti o Imposta FIltri di ricerca
    - Cerca prodotto
    - visualizza carrello
    - Impostazioni Account
    - Logout

- Per Admin: 
    - Menu Utenti (CRUD)
    - Menu Prodotti (CRUD)
    - Menu Spedizioni (CRUD)
    - Menu Vendite/Ordini (CRUD)
    - Logout

- Pattern architetturale → MVC

- Pattern di design:
    - Creazionali:
        Factory:
            - Per istanziare Account di diverso tipo (User od Admin)
        Singleton:
            - Per istanziare una sola connesione col DB
    - Strutturali:
        Decorator:
            - Per "decorare" il prezzo finale di un'ordine a seconda dell'abbonamento ("PRO" → ancora da implementare nello User)
            - Da utilizzare per "decorare" in maniera specifica un prodotto generico
    - Comportamentali:
        Observer:
            - Da implementare per notificare aggiornamenti sugli stati della vendita/ordine
            - Da implementare per notificare aggiornamenti sulla scadenza dell'abbonamento "PRO"