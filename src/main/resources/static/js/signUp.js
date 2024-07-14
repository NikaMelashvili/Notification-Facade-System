document.getElementById("signupForm").addEventListener("submit", function () {
  const firstName = document.getElementById("FirstName").value;
  const lastName = document.getElementById("LastName").value;
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  user = {
    FirstName: firstName,
    LastName: lastName,
    Email: email,
    Password: password,
  };

  fetch("https://localhost:8080/rest/authentication/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
    body: JSON.stringify(customer),
  })
    .then((response) => {
      if (response.status === 400) {
        throw new Error("User already exists");
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
