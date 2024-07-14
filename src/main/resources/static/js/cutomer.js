document
  .getElementById("addCutomerForm")
  .addEventListener("submit", function () {
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const age = document.getElementById("age").value;
    const email = document.getElementById("email").value;
    const street = document.getElementById("street").value;
    const number = document.getElementById("number").value;
    const postCode = document.getElementById("postCode").value;
    const password = document.getElementById("password").value;
    const mail = document.getElementById("emailOpt").value;
    const sms = document.getElementById("smsOpt").value;
    const promo = document.getElementById("promoOpt").value;

    user = {
      FirstName: firstName,
      LastName: lastName,
      Age: age,
      Email: email,
      Password: password,
    };
    address = {
      Street: street,
      Number: number,
      PostCode: postCode,
    };
    preference = {
      Mail: mail,
      SMS: sms,
      Promo: promo,
    };

    customer = {
      User: user,
      Address: address,
      preference: preference,
    };

    fetch("https://localhost:8080/rest/user/add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(customer),
    })
      .then((response) => {
        if (response.status === 400) {
          throw new Error();
        }
        return response.text();
      })
      .catch(() => {});
  });

document
  .getElementById("updateCustomerForm")
  .addEventListener("submit", function () {
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const age = document.getElementById("age").value;
    const email = document.getElementById("email").value;
    const street = document.getElementById("street").value;
    const number = document.getElementById("number").value;
    const postCode = document.getElementById("postCode").value;
    const password = document.getElementById("password").value;
    const mail = document.getElementById("emailOpt").value;
    const sms = document.getElementById("smsOpt").value;
    const promo = document.getElementById("promoOpt").value;

    user = {
      FirstName: firstName,
      LastName: lastName,
      Age: age,
      Email: email,
      Password: password,
    };
    address = {
      Street: street,
      Number: number,
      PostCode: postCode,
    };
    preference = {
      Mail: mail,
      SMS: sms,
      Promo: promo,
    };

    customer = {
      User: user,
      Address: address,
      preference: preference,
    };

    fetch("https://localhost:8080/rest/user/update", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(customer),
    })
      .then((response) => {
        if (response.status === 400) {
          throw new Error();
        }
        return response.text();
      })
      .catch(() => {});
  });

document
  .getElementById("addCutomerForm")
  .addEventListener("submit", function () {
    const id = document.getElementById("id").value;
    fetch("https://localhost:8080/rest/user/delete", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(id),
    })
      .then((response) => {
        if (response.status === 400) {
          throw new Error();
        }
        return response.text();
      })
      .catch(() => {});
  });
