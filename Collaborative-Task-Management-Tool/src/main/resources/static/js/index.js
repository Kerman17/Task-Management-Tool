const containerElement = document.querySelector('.js-container');
let html = '';


async function getUsers() {
    const response = await fetch('http://localhost:8080/api/v1/users').then((response) => {
        return response.json();
    }).then((usersData) => {
        usersData.forEach((user) => {
            html +=
                `
            <p>User email: ${user.email}, and User name: ${user.name}</p>
            `
        })
        containerElement.innerHTML = html;
    });
}

// getUsers();




