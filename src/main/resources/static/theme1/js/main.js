// Hamburger menu overlay

function openNav() {
    document.getElementById("olNav").style.width = "100%";
}

function closeNav() {
    document.getElementById("olNav").style.width = "0%";
}

// Hidden Forms on admin
function on() {
    document.getElementById("hiddenForm").style.display = "block";
    let parentElement = document.getElementById("lockSize")
    let elements = parentElement.getElementsByClassName("profile");
    for (let i = 0; i < elements.length; i++) {
        let myElement = elements[i]; // access element
        myElement.style.paddingBottom = "0px";
    }
}
function off() {
    document.getElementById("hiddenForm").style.display = "none";
}