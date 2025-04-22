const mainContainerElement = document.querySelector('.js-main-container-grid');

async function loadProjects() {
    const response = await fetch('http://localhost:8080/api/v1/projects').then((response) => {
        return response.json();
    }).then((projects) => {
        // console.log(projects);
        projects.forEach((project) => {
            html +=
                `
            <div class="card" data-id=${project.id}>
                    <div class="card-top">
                        <p class="project-id">Id: ${project.id}</p>
                        <p class="project-name">Name: ${project.name}</p>
                    </div>
                    <div class="card-description project-description">
                       ${project.description}
                    </div>
                    <div class="card-bottom">
                        <p><span class="project-createdby">Created by: ${project.created_by}</span></p>
                        <p>Created at: ${(new Date(project.created_at)).toISOString().split('T')[0]}</p>
                    </div>
                </div>
            `
        })
    })
}

loadProjects();

const projectsListener = document.querySelector('.js-projects')
    .addEventListener('click', () => {
        mainContainerElement.innerHTML = html;

        document.querySelectorAll('.js-main-container .card').forEach(card => {
            card.addEventListener('click', () => {
                const idSelectedCard = card.dataset.id;
            })
        })

    })



