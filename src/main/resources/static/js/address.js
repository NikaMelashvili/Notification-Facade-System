document
  .getElementById("UpdateAddressForm")
  .addEventListener("submit", function () {
    const id = document.getElementById("id");
    const email = document.getElementById("email");
    const street = document.getElementById("street");
    const number = document.getElementById("number");
    const postCode = document.getElementById("postCode");

    address = {
      Id: id,
      Email: email,
      Street: street,
      Number: number,
      PostCode: postCode,
    };

    fetch("https://localhost:8080/rest/address/update/address", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(address),
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

document
  .getElementById("DeleteAddressForm")
  .addEventListener("submit", function () {
    const id = document.getElementById("id");
    const addressId = document.getElementById("addressID");

    address = {
      AddressId: addressId,
      Id: id,
    };

    fetch("https://localhost:8080/rest/address/delete/address", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(address),
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
document
  .getElementById("GetAddressByIdForm")
  .addEventListener("submit", function () {
    const id = document.getElementById("id");

    fetch("https://localhost:8080/rest/address/get/user-address", {
      method: "",
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "include",
      body: JSON.stringify(id),
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
