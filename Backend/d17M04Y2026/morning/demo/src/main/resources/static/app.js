const API = "http://localhost:8081";
// URL base del backend Spring Boot.
// Tutte le chiamate fetch useranno questo endpoint.

function getToken() {
  // Recupera il JWT salvato nel browser
  // localStorage = memoria persistente del browser (persiste anche dopo la chiusura della sessione)
  return localStorage.getItem("token");
}

function parseJwt(token) {
  try {
    // Un JWT è composto da 3 parti: header.payload.signature
    // qui prendiamo la parte "payload"
    return JSON.parse(atob(token.split('.')[1]));
    // atob = decodifica Base64 → JSON leggibile
  } catch {
    // se il token è corrotto od invalido ritorna null
    return null;
  }
}

function initApp() {
  // funzione chiamata quando la pagina si carica (onload)

  const token = getToken();

  // se non esiste token → utente non loggato
  if (!token) {
    window.location.href = "login.html";
    return;
  }

  const payload = parseJwt(token);

  // se token non valido → logout forzato
  if (!payload) {
    logout();
    return;
  }

  // controllo ruolo ADMIN nel token JWT
  if (payload.role === "ADMIN") {

    // cerca elemento admin panel nella pagina
    const panel = document.getElementById("adminPanel");

    // TODO da nascondere le parti dedicate all'utente normale, o reindirizzare ad una pagina dedicata

    // se esiste, lo rende visibile
    if (panel) panel.style.display = "block";
  }
}

function logout() {
  // elimina il token salvato nel browser
  localStorage.removeItem("token");

  // redirect alla pagina login
  window.location.href = "login.html";
}

function toggleTheme() {
  // recupera tema attuale (light o dark)
  const current = document.documentElement.getAttribute("data-theme");

  // cambia tema alternando tra light e dark
  document.documentElement.setAttribute(
    "data-theme",
    current === "light" ? "dark" : "light"
  );
}