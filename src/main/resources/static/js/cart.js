
function addDivPaginated(data, contentDiv, style) {
    addDiv2( data.content, contentDiv, style)
}

function addDiv2(array, contentDiv, style) {

    let cout = 0;
    let  nevJoinP  = document.getElementById("joinPrice")

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
        newImg.classList.add("imgAdd2")
        newImg.src = ("/image/"+ product.imageId +".png")
        newImg.classList.add("imgAdd2");
        newP.appendChild(newImg)

        let add = document.createElement('div')
        add.innerHTML = "remove from cart"
        add.onclick = function () {
            deleteFromCart(product.id)
            con.removeChild(newP)
            window.location.reload(true);

        }


        add.classList.add("button2");
        newP.appendChild(add)



    
        con.appendChild(newP)

    }
    nevJoinP.innerHTML = 'Sum: '+ cout

    // function removeWithCart() {
    //     let newP = document.getElementsByTagName('div')
    //     newP.documentElement.removeChild()
    //     newP.removeChild('div')
    //
    //
    // }
}



function deleteFromCart(id) {
    fetch('cart/' + id,{
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        credentials: "same-origin"
    })
.then (r => r.text())
.then (r => console.log(r))
}
