

var modal = document.getElementById('myModal');

var btn = document.getElementById("myBtn");

var span = document.getElementsByClassName("close")[0];

btn.onclick = function () {
    modal.style.display = "block";
}

span.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function clickBuy() {
    let fun = document.getElementById('fullName').value
    let num = parseInt(document.getElementById('number').value)
    let buyC = {
        name: fun,
        phone: num
    }
    fetch('/order',
        {
            method: 'POST',
            body: JSON.stringify(buyC),
            headers: {
                'Content-Type': 'application/json'
            },
            credentials: "same-origin"
        }).then(r => r.text())
.then(r => console.log(r)
)}

