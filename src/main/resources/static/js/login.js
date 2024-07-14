document.getElementById("loginForm").addEventListener("submit", function () {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  customer = {
    Email: email,
    Password: password,
  };

  fetch("https://localhost:8080/rest/authentication/authenticate", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
    body: JSON.stringify(customer),
  })
    .then((response) => {
      if (response.status === 400) {
        throw new Error("Email Or Password is incorrect");
      }
      return response.text();
    })
    .then(() => {
      window.location.href = "admin.html";
    })
    .catch((error) => {
      displayError(error.message);
    });
});
