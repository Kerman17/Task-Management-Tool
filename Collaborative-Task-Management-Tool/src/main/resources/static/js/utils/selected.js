document.querySelector('.js-projects')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-projects').classList.add("selected");

        document.querySelector('.main-container-h1')
            .innerHTML = "Projects List";
    })

document.querySelector('.js-home')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-home').classList.add("selected");

        document.querySelector('.main-container-h1')
            .innerHTML = "Welcome (insert name) to the Task Management Tool";

    })

document.querySelector('.js-team')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-team').classList.add("selected");
    })

document.querySelector('.js-tasks')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-tasks').classList.add("selected");
    })

document.querySelector('.js-calendar')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-calendar').classList.add("selected");
    })

function deselectAll() {
    document.querySelector('.js-home').classList.remove("selected");
    document.querySelector('.js-projects').classList.remove("selected");
    document.querySelector('.js-team').classList.remove("selected");
    document.querySelector('.js-tasks').classList.remove("selected");
    document.querySelector('.js-calendar').classList.remove("selected");
}