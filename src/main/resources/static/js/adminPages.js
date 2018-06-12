var id = -1

function clickMe() {
    let nm = document.getElementById('username').value
    let txt = document.getElementById('newText').value

    let prc = parseInt(document.getElementById('price').value)
    let prod = {
        name: nm,
        imageId: id,
        description: txt,
        price: prc
    };
    fetch('/product',
        {
            method:'POST',
            body: JSON.stringify(prod),
            headers: {
                'Content-Type': 'application/json'
            }
        }) .then(r => r.text())
.then(r => console.log(r))
}

function upload() {
    var input = document.getElementById('img')

    var data = new FormData()
    data.append('file', input.files[0])
    // data.append('user', 'hubot')

    fetch('/image', {
        method: 'POST',
        body: data
    }).then(r => r.text())
.then(t => parseInt(t))
.then(newId => id = newId)
.then(console.log)
}
function refresh() {
    window.location.reload(true);
}