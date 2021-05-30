export default {
    namespaced: true,
    state: {
        userType: null,
        carrito: null
    },
    mutations: {
        setUserType(state, val) {
            if (val == 'user') state.carrito = []
            state.userType = val
        },
        setCarrito(state, val) {
            let busca = false
            let posicion = null
            state.carrito.forEach((book, i) => {
                if (book.id === val.id) {
                    busca = true
                    posicion = i
                }
            });
            if (state.carrito.length > 0 && busca) {
                val.cantidad == 0 ? state.carrito.splice(posicion, 1) : state.carrito[posicion] = val
            } else {
                state.carrito.push(val)
            }

        },


    }
}