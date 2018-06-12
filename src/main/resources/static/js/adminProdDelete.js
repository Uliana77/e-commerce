
function addDivPaginated3(data, contentDiv, style) {
    addDiv3( data.content, contentDiv, style)
}

function addDiv3(array, contentDiv, style) {

    let cout = 0;
    //  let  nevJoinP  = document.getElementById("joinPrice")

    let con = document.getElementById(contentDiv)

    for (i = 0; i < array.length; i++) {
        let product = array[i];

        let newP = document.createElement('div')
        newP.classList.add(style);


        let newName = document.createElement('p')
        newName.innerHTML = product.name
        newP.appendChild(newName)


        let nnewText = document.createElement('p')
        nnewText.innerHTML = "color: " + product.description
        newP.appendChild(nnewText)

        let newPrice = document.createElement('p')
        newPrice.innerHTML = "price: " + product.price
        newP.appendChild(newPrice)

        cout += product.price


        let newImg = document.createElement('img')
        newImg.classList.add("imgAdd3")
        newImg.src = ("/image/" + product.imageId + ".png")
        newImg.classList.add("imgAdd3");
        newP.appendChild(newImg)

        let add = document.createElement('div')
        add.innerHTML = "delete with prod"
        add.onclick = function () {
            deleteFromProd(product.id)
            con.removeChild(newP)
        }


        add.classList.add("button3");
        newP.appendChild(add)

        con.appendChild(newP)

    }
}
var current;
function showAllProduct(page) {
    current = page
    fetch('/product?count=9&page=' + current)

        .then(r => r.json())
        .then(r => addDivPaginated3(r, 'content', 'mystyle3'))
}

    function deleteFromProd(id) {
    fetch('product/' + id,{
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        credentials: "same-origin"
    })
.then (r => r.text())
.then (r => console.log(r))
}
showAllProduct(0);
 //   nevJoinP.innerHTML = 'Sum: '+ cout
// function addDelBtn() {
//     let btn = document.createElement("div");
//     btn.innerHTML = 'delet with prod.html'
//     btn.onclick = function() {
//         con.removeChild(newP)
//     }
//     return btn
// }


