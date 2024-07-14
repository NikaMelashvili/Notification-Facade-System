document.getElementById("loginForm").addEventListener("submit", function () {
  const id = document.getElementById("id").value;
  const emailOpt = document.getElementById("emailOpt").value;
  const smsOpt = document.getElementById("smsOpt").value;
  const promoOpt = document.getElementById("promoOpt").value;

  preferences = {
    ID: id,
    EmailOpt: emailOpt,
    SMSOpt: smsOpt,
    PromoOpt: promoOpt,
  };

  fetch("https://localhost:8080/rest/authentication/authenticate", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
    body: JSON.stringify(preferences),
  })
    .then((response) => {
      if (response.status === 400) {
        throw new Error("Email Or Password is incorrect");
      }
      return response.text();
    })
    .catch((error) => {
      displayError(error.message);
    });
});
