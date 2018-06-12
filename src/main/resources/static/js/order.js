function addListProd(array, wrapper,style) {
    for(i = 0; i < array.length; i++){
        let con = document.getElementById(wrapper)

        let newP = document.createElement('div')
        newP.classList.add(style);

        let newName = document.createElement('p')
        newName.innerHTML = product.name
        newP.appendChild(newName)

        let HowMany = document.createElement('p')
        newName.innerHTML = function (count) {
            return count;
        }
        newP.appendChild(HowMany)
    }
    con.appendChild(newP)


}