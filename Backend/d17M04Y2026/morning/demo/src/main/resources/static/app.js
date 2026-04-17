const API = "http://localhost:8081";

// ================= TOKEN =================
function getToken() {
  return localStorage.getItem("token");
}

function authHeaders() {
  const token = getToken();

  if (!token) {
    window.location.href = "login.html";
    return {};
  }

  return {
    "Authorization": "Bearer " + token,
    "Content-Type": "application/json"
  };
}

// ================= RESPONSIVE SIZE =================
function getPageSize() {
  const width = window.innerWidth;

  if (width < 600) return 6;     // mobile
  if (width < 1000) return 12;   // tablet
  return 24;                     // desktop
}

// aggiorna dinamicamente quando cambia schermo
window.addEventListener("resize", () => {
  const newSize = getPageSize();

  if (newSize !== size) {
    console.log("Resize → aggiorno size:", newSize);

    size = newSize;

    // reset intelligente SOLO se sei in modalità all
    if (mode === "all") {
      reset();
      loadEvents();
    }
  }
});

// ================= STATE =================
let page = 0;
let size = getPageSize();
let loading = false;
let finished = false;
let mode = "all";
let currentQuery = "";

// ================= INIT =================
document.addEventListener("DOMContentLoaded", () => {
  console.log("DOM pronto");

  document
    .getElementById("searchForm")
    .addEventListener("submit", handleSearch);

  reset();
  loadEvents();
});

// ================= RESET =================
function reset() {
  page = 0;
  size = getPageSize(); // sempre coerente con viewport
  loading = false;
  finished = false;
  document.getElementById("main").innerHTML = "";
}

// ================= LOAD EVENTS =================
async function loadEvents() {
  if (loading || finished) return;

  loading = true;

  try {
    let url;

    if (mode === "search") {
      url = `${API}/events/search?name=${encodeURIComponent(currentQuery)}`;
    } else {
      url = `${API}/events/all?page=${page}&size=${size}`;
    }

    console.log("FETCH:", url);

    const res = await fetch(url, {
      headers: authHeaders()
    });

    if (!res.ok) {
      console.error("HTTP ERROR:", res.status);
      if (res.status === 403) logout();
      loading = false;
      return;
    }

    const data = await res.json();
    const events = Array.isArray(data) ? data : (data.content || []);

    if (events.length === 0) {
      finished = true;
      loading = false;
      return;
    }

    render(events);

    if (mode === "all") {
      page++;

      if (data.last === true) {
        finished = true;
      }
    } else {
      finished = true;
    }

  } catch (err) {
    console.error("Errore loadEvents:", err);
  } finally {
    loading = false;
  }
}

// ================= RENDER =================
function render(events) {
  const container = document.getElementById("main");

  events.forEach(e => {
    const div = document.createElement("div");
    div.classList.add("column");

    div.innerHTML = `
      <h3>${e.name}</h3>
      <small>${formatDate(e.date)}</small>
      <div class="badge medium">${e.status}</div>
    `;

    container.appendChild(div);
  });
}

// ================= SEARCH =================
async function handleSearch(event) {
  event.preventDefault();

  const value = document.getElementById("searchInput").value;

  mode = "search";
  currentQuery = value;

  reset();

  try {
    const res = await fetch(
      `${API}/events/search?name=${encodeURIComponent(value)}`,
      { headers: authHeaders() }
    );

    if (!res.ok) {
      console.error("Search error:", res.status);
      return;
    }

    const data = await res.json();

    render(Array.isArray(data) ? data : []);
    finished = true;

  } catch (err) {
    console.error(err);
  }
}

// ================= INFINITE SCROLL =================
window.addEventListener("scroll", () => {
  if (loading || finished) return;

  if (mode !== "all") return;

  const scrollTop = window.scrollY;
  const windowHeight = window.innerHeight;
  const fullHeight = document.documentElement.scrollHeight;

  if (scrollTop + windowHeight >= fullHeight - 200) {
    loadEvents();
  }
});

// ================= LOAD ALL =================
function loadAllEvents() {
  mode = "all";
  currentQuery = "";
  reset();
  loadEvents();
}

// ================= FORMAT =================
function formatDate(date) {
  return new Date(date).toLocaleString();
}

// ================= LOGOUT =================
function logout() {
  localStorage.removeItem("token");
  window.location.href = "login.html";
}

// ================= THEME =================
function toggleTheme() {
  const current = document.documentElement.getAttribute("data-theme");

  document.documentElement.setAttribute(
    "data-theme",
    current === "light" ? "dark" : "light"
  );
}