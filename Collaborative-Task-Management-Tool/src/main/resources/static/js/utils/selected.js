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
    })

document.querySelector('.js-option3')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-option3').classList.add("selected");
    })

document.querySelector('.js-tasks')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-tasks').classList.add("selected");
    })

document.querySelector('.js-option5')
    .addEventListener('click', () => {
        deselectAll();
        document.querySelector('.js-option5').classList.add("selected");
    })

function deselectAll() {
    document.querySelector('.js-home').classList.remove("selected");
    document.querySelector('.js-projects').classList.remove("selected");
    document.querySelector('.js-option3').classList.remove("selected");
    document.querySelector('.js-tasks').classList.remove("selected");
    document.querySelector('.js-option5').classList.remove("selected");
}