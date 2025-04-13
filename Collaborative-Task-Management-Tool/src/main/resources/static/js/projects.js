const mainContainerElement = document.querySelector('.js-main-container');

async function getProjects() {
    const response = await fetch('http://localhost:8080/api/v1/projects').then((response) => {
        return response.json();
    }).then((projects) => {
        console.log(projects);
        projects.forEach((project) => {
            html +=
                `
            <p>Project id: ${project.id}, Project name: ${project.name},
             Project description: ${project.description}, Created by: ${project.created_by}, Created at: ${project.created_at}</p>
            `

        })
    })
}

getProjects();

const projectsListener = document.querySelector('.js-projects')
    .addEventListener('click', () => {
        mainContainerElement.innerHTML = html;
    })