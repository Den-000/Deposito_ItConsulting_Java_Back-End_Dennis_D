const API = "http://localhost:8081";
// endpoint backend

async function getEventsByName() {
  try {
    // prende valore input HTML
    const name = document.getElementById("search").value;

    // chiamata HTTP GET al backend
    const res = await fetch(`${API}/events?name=${encodeURIComponent(name)}`);

    // converte risposta backend in JSON
    const data = await res.json();

    console.log("EVENTS RESPONSE:", data);
    // per debug

    if (res.ok) {
      // mostra eventi trovati
      alert(`Eventi trovati: ${data.length}`);
      // qui potresti anche aggiornare il DOM per mostrare i dettagli degli eventi
    } else {
      // errore backend
      alert("Errore nella ricerca degli eventi");
    }

  } catch (err) {
    // errore rete/server
    console.error(err);
    alert("Errore di rete e/o server");
  }
}